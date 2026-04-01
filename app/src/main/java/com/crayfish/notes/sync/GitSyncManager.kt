package com.crayfish.notes.sync

import android.content.Context
import com.crayfish.notes.data.model.Note
import java.io.File

class GitSyncManager(private val context: Context) {
    private val gitRepoDir = File(context.filesDir, "notes_repo")

    fun syncWithRemote(remoteUrl: String, token: String) {
        // 1. 检查本地仓库是否存在，不存在则 clone
        // 2. 执行 git pull --rebase
        // 3. 将本地 Room 数据库中的 PENDING 笔记写入 .md 文件
        // 4. 执行 git add . && git commit -m "Sync from Android"
        // 5. 执行 git push
        println("Syncing with remote: $remoteUrl")
    }

    fun saveNoteToFile(note: Note) {
        val noteFile = File(gitRepoDir, "${note.id}.md")
        val metaFile = File(gitRepoDir, "${note.id}.json")
        
        // 写入 Markdown 内容
        noteFile.writeText(note.content)
        
        // 写入元数据 (颜色、标签)
        val metaJson = """
            {
                "title": "${note.title}",
                "bgColor": "${note.bgColor}",
                "tagIds": ${note.tagIds},
                "updatedAt": ${note.updatedAt}
            }
        """.trimIndent()
        metaFile.writeText(metaJson)
    }
}
