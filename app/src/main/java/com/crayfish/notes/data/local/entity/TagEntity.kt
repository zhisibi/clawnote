package com.crayfish.notes.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "tags")
data class TagEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    
    @ColumnInfo(name = "name")
    val name: String,
    
    @ColumnInfo(name = "tag_color")
    val tagColor: String = "#FF5733" // 默认小龙虾橙色
)
