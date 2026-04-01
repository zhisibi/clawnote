package com.crayfish.notes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val color: String = "#FF5722" // 标签专属颜色
)
