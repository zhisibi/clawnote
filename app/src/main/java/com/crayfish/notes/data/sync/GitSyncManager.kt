package com.crayfish.notes.data.sync

import com.crayfish.notes.data.local.dao.NoteDao
import com.crayfish.notes.data.local.entity.NoteEntity
import com.crayfish.notes.data.local.entity.NoteTagCrossRef
import com.crayfish.notes.data.local.entity.TagEntity
import kotlinx.coroutines.flow.first
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class GitSyncManager(
    private val noteDao: NoteDao,
    private val gitRepoDir: File
) {
    private val json = Json { prettyPrint = true }

    /**
     * 将本地数据库中的所有笔记导出为 Git 仓库中的文件。
     */
    suspend fun exportToGit() {
        val notes = noteDao.getAllNotesFlow().first()
        val tags = noteDao.getAllTagsFlow().first()

        // 1. 导出全局标签定义
        val globalTags = GlobalTags(tags.map { TagMetadata(it.id, it.name, it.tagColor) })
        File(gitRepoDir, "tags.json").writeText(json.encodeToString(globalTags))

        // 2. 导出每篇笔记
        notes.forEach { note ->
            val noteTags = noteDao.getTagsForNote(note.id).first()
            
            // 导出 Markdown 内容
            val mdFile = File(gitRepoDir, "notes/${note.id}.md")
            mdFile.parentFile.mkdirs()
            mdFile.writeText(note.content)

            // 导出元数据 (颜色、标签、时间戳)
            val metadata = NoteMetadata(
                id = note.id,
                title = note.title,
                createdAt = note.createdAt,
                updatedAt = note.updatedAt,
                bgColor = note.bgColor,
                tagIds = noteTags.map { it.id }
            )
            File(gitRepoDir, "notes/${note.id}.json").writeText(json.encodeToString(metadata))
        }
    }

    /**
     * 从 Git 仓库中的文件导入到本地数据库。
     */
    suspend fun importFromGit() {
        // 1. 导入全局标签
        val tagsFile = File(gitRepoDir, "tags.json")
        if (tagsFile.exists()) {
            val globalTags = json.decodeFromString<GlobalTags>(tagsFile.readText())
            globalTags.tags.forEach { 
                noteDao.insertTag(TagEntity(it.id, it.name, it.color))
            }
        }

        // 2. 导入笔记
        val notesDir = File(gitRepoDir, "notes")
        if (notesDir.exists()) {
            notesDir.listFiles { _, name -> name.endsWith(".json") }?.forEach { jsonFile ->
                val metadata = json.decodeFromString<NoteMetadata>(jsonFile.readText())
                val mdFile = File(notesDir, "${metadata.id}.md")
                val content = if (mdFile.exists()) mdFile.readText() else ""

                // 插入笔记
                val noteEntity = NoteEntity(
                    id = metadata.id,
                    title = metadata.title,
                    content = content,
                    createdAt = metadata.createdAt,
                    updatedAt = metadata.updatedAt,
                    bgColor = metadata.bgColor
                )
                noteDao.insertNote(noteEntity)

                // 插入标签关联
                metadata.tagIds.forEach { tagId ->
                    noteDao.insertNoteTagCrossRef(NoteTagCrossRef(metadata.id, tagId))
                }
            }
        }
    }
}
