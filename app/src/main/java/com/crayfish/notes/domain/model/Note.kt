package com.crayfish.notes.domain.model

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: Long,
    val updatedAt: Long,
    val bgColor: String,
    val tags: List<Tag> = emptyList(),
    val syncStatus: Int = 0
)

data class Tag(
    val id: String,
    val name: String,
    val color: String
)
