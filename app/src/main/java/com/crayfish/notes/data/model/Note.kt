package com.crayfish.notes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val bgColor: String = "#FFFFFF", // 标题背景色
    val tagIds: List<String> = emptyList(), // 关联的标签 ID 列表
    val syncStatus: SyncStatus = SyncStatus.PENDING,
    val gitCommitHash: String? = null
)

enum class SyncStatus {
    PENDING, SYNCED, CONFLICT
}
