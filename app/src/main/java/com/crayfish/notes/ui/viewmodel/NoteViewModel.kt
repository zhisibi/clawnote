package com.crayfish.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crayfish.notes.data.local.dao.NoteDao
import com.crayfish.notes.data.mapper.toDomain
import com.crayfish.notes.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

data class NoteListState(
    val groupedNotes: Map<String, List<Note>> = emptyMap(),
    val isLoading: Boolean = false,
    val pendingDeleteId: String? = null
)

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteDao: NoteDao
) : ViewModel() {

    private val _state = MutableStateFlow(NoteListState())
    val state: StateFlow<NoteListState> = _state.asStateFlow()

    private val dateFormatter = SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA)

    init {
        loadNotes()
    }

    fun onNoteLongClick(noteId: String) {
        _state.update { it.copy(pendingDeleteId = noteId) }
    }

    suspend fun deletePendingNote() {
        val id = _state.value.pendingDeleteId ?: return
        val entity = noteDao.getNoteById(id) ?: return
        noteDao.deleteNote(entity)
        _state.update { it.copy(pendingDeleteId = null) }
    }

    fun clearPendingDelete() {
        _state.update { it.copy(pendingDeleteId = null) }
    }

    private fun loadNotes() {
        noteDao.getAllNotesFlow()
            .onStart { _state.update { it.copy(isLoading = true) } }
            .map { entities ->
                entities.map { entity ->
                    // 这里简化处理，实际应通过 Repository 获取关联标签
                    entity.toDomain(emptyList()) 
                }.groupBy { entity ->
                    dateFormatter.format(Date(entity.createdAt))
                }
            }
            .onEach { grouped ->
                _state.update { it.copy(groupedNotes = grouped, isLoading = false) }
            }
            .launchIn(viewModelScope)
    }
}
