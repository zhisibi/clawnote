package com.crayfish.notes.data.sync

import kotlinx.serialization.Serializable

@Serializable
data class NoteMetadata(
    val id: String,
    val title: String,
    val createdAt: Long,
    val updatedAt: Long,
    val bgColor: String,
    val tagIds: List<String> = emptyList()
)

@Serializable
data class GlobalTags(
    val tags: List<TagMetadata>
)

@Serializable
data class TagMetadata(
    val id: String,
    val name: String,
    val color: String
)
