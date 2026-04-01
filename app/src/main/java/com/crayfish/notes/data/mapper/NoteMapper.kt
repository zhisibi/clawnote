package com.crayfish.notes.data.mapper

import com.crayfish.notes.data.local.entity.NoteEntity
import com.crayfish.notes.data.local.entity.TagEntity
import com.crayfish.notes.domain.model.Note
import com.crayfish.notes.domain.model.Tag

fun NoteEntity.toDomain(tags: List<TagEntity>): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        createdAt = createdAt,
        updatedAt = updatedAt,
        bgColor = bgColor,
        tags = tags.map { it.toDomain() },
        syncStatus = syncStatus
    )
}

fun TagEntity.toDomain(): Tag {
    return Tag(
        id = id,
        name = name,
        color = tagColor
    )
}
