package com.crayfish.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crayfish.notes.data.local.dao.NoteDao
import com.crayfish.notes.data.local.entity.NoteEntity
import com.crayfish.notes.data.local.entity.NoteTagCrossRef
import com.crayfish.notes.data.local.entity.TagEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

data class NoteEditorState(
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val content: String = "",
    val bgColor: String = "#FFFFFF",
    val selectedTags: List<TagEntity> = emptyList(),
    val allTags: List<TagEntity> = emptyList(),
    val isPreviewMode: Boolean = false
)

@HiltViewModel
class NoteEditorViewModel @Inject constructor(
    private val noteDao: NoteDao
) : ViewModel() {

    private val _state = MutableStateFlow(NoteEditorState())
    val state: StateFlow<NoteEditorState> = _state.asStateFlow()

    init {
        // 仅初始化标签列表，不加载具体某条笔记
        viewModelScope.launch {
            noteDao.getAllTagsFlow().collect { tags ->
                _state.update { it.copy(allTags = tags) }
            }
        }
    }

    fun loadNote(noteId: String?) {
        if (noteId == null || noteId == "new") {
            // 新建笔记，重置为默认状态
            _state.value = NoteEditorState()
            return
        }
        viewModelScope.launch {
            val note = noteDao.getNoteById(noteId)
            if (note != null) {
                _state.update {
                    it.copy(
                        id = note.id,
                        title = note.title,
                        content = note.content,
                        bgColor = note.bgColor
                    )
                }
            }
        }
    }

    fun onTitleChange(newTitle: String) {
        _state.update { it.copy(title = newTitle) }
    }

    fun onContentChange(newContent: String) {
        _state.update { it.copy(content = newContent) }
    }

    fun onColorChange(newColor: String) {
        _state.update { it.copy(bgColor = newColor) }
    }

    fun setPreviewMode(enabled: Boolean) {
        _state.update { it.copy(isPreviewMode = enabled) }
    }

    fun insertSnippet(snippet: String) {
        _state.update { it.copy(content = it.content + snippet) }
    }

    fun toggleTag(tag: TagEntity) {
        _state.update { currentState ->
            val newTags = if (currentState.selectedTags.contains(tag)) {
                currentState.selectedTags - tag
            } else {
                currentState.selectedTags + tag
            }
            currentState.copy(selectedTags = newTags)
        }
    }

    fun saveNote() {
        viewModelScope.launch {
            val currentState = _state.value
            val noteEntity = NoteEntity(
                id = currentState.id,
                title = currentState.title,
                content = currentState.content,
                bgColor = currentState.bgColor,
                updatedAt = System.currentTimeMillis()
            )
            noteDao.insertNote(noteEntity)
            
            // 更新标签关联
            currentState.selectedTags.forEach { tag ->
                noteDao.insertNoteTagCrossRef(NoteTagCrossRef(currentState.id, tag.id))
            }
        }
    }
}
