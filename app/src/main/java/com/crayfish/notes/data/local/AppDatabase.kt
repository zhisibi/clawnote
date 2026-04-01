package com.crayfish.notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crayfish.notes.data.local.dao.NoteDao
import com.crayfish.notes.data.local.entity.NoteEntity
import com.crayfish.notes.data.local.entity.NoteTagCrossRef
import com.crayfish.notes.data.local.entity.TagEntity

@Database(
    entities = [NoteEntity::class, TagEntity::class, NoteTagCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
