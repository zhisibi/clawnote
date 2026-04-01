package com.crayfish.notes.data.local.dao

import androidx.room.*
import com.crayfish.notes.data.local.entity.NoteEntity
import com.crayfish.notes.data.local.entity.NoteTagCrossRef
import com.crayfish.notes.data.local.entity.TagEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    // 基础 CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    // 按日期降序查询所有笔记 (用于 Timeline 分组)
    @Query("SELECT * FROM notes WHERE is_archived = 0 ORDER BY created_at DESC")
    fun getAllNotesFlow(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: String): NoteEntity?

    // 标签相关
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTag(tag: TagEntity)

    @Query("SELECT * FROM tags")
    fun getAllTagsFlow(): Flow<List<TagEntity>>

    // 关联相关
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNoteTagCrossRef(crossRef: NoteTagCrossRef)

    @Transaction
    @Query("""
        SELECT * FROM tags 
        INNER JOIN note_tag_cross_ref ON tags.id = note_tag_cross_ref.tag_id 
        WHERE note_tag_cross_ref.note_id = :noteId
    """)
    fun getTagsForNote(noteId: String): Flow<List<TagEntity>>
}
