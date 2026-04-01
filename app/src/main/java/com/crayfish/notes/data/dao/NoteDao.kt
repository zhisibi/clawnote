package com.crayfish.notes.data.dao

import androidx.room.*
import com.crayfish.notes.data.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY createdAt DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: String): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    // 按日期分类查询 (示例：查询今天的笔记)
    @Query("SELECT * FROM notes WHERE createdAt >= :startOfDay ORDER BY createdAt DESC")
    fun getNotesByDate(startOfDay: Long): Flow<List<Note>>
}
