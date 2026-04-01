package com.crayfish.notes.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    
    @ColumnInfo(name = "title")
    val title: String,
    
    @ColumnInfo(name = "content")
    val content: String,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "bg_color")
    val bgColor: String = "#FFFFFF", // 默认白色背景
    
    @ColumnInfo(name = "is_archived")
    val isArchived: Boolean = false,
    
    @ColumnInfo(name = "sync_status")
    val syncStatus: Int = 0 // 0: 待同步, 1: 已同步, 2: 冲突
)
