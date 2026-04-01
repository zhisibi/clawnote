package com.crayfish.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crayfish.notes.data.sync.GitAuthManager
import com.crayfish.notes.domain.usecase.SyncUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsState(
    val remoteUrl: String = "",
    val lastSyncTime: String = "尚未同步",
    val isSyncing: Boolean = false,
    val errorMessage: String? = null,
    val publicKey: String? = null
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val syncUseCase: SyncUseCase,
    private val gitAuthManager: GitAuthManager
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state.asStateFlow()

    init {
        // 读取已有公钥
        _state.update { it.copy(publicKey = gitAuthManager.getPublicKey()) }
    }

    fun onRemoteUrlChange(url: String) {
        _state.update { it.copy(remoteUrl = url) }
    }

    fun syncNow() {
        viewModelScope.launch {
            _state.update { it.copy(isSyncing = true, errorMessage = null) }
            val result = syncUseCase.executeSync()
            _state.update {
                if (result.isSuccess) {
                    it.copy(
                        isSyncing = false,
                        lastSyncTime = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.util.Date()),
                        errorMessage = null
                    )
                } else {
                    it.copy(
                        isSyncing = false,
                        errorMessage = result.exceptionOrNull()?.message ?: "未知错误"
                    )
                }
            }
        }
    }
}
