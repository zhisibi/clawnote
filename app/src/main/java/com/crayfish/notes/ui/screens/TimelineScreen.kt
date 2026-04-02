package com.crayfish.notes.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crayfish.notes.ui.components.NoteCard
import com.crayfish.notes.ui.viewmodel.NoteViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TimelineScreen(
    viewModel: NoteViewModel,
    onNoteClick: (String) -> Unit,
    onNewNoteClick: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    val scope = rememberCoroutineScope()

    if (state.pendingDeleteId != null) {
        AlertDialog(
            onDismissRequest = { viewModel.clearPendingDelete() },
            title = { Text("删除笔记") },
            text = { Text("确定要删除这条笔记吗？此操作不可恢复。") },
            confirmButton = {
                TextButton(onClick = {
                    scope.launch {
                        viewModel.deletePendingNote()
                    }
                }) {
                    Text("删除")
                }
            },
            dismissButton = {
                TextButton(onClick = { viewModel.clearPendingDelete() }) {
                    Text("取消")
                }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("小龙虾记事本 🦞") },
                actions = {
                    TextButton(onClick = { /* TODO: 导航到 settings，UI 层补入口时使用 */ }) {
                        Text("同步")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNewNoteClick) {
                Icon(Icons.Default.Add, contentDescription = "新建笔记")
            }
        }
    ) { padding ->
        if (state.groupedNotes.isEmpty()) {
            // 空状态占位
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            ) {
                Text(
                    text = "还没有任何笔记，点击右下角 + 开始记录吧！",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(32.dp),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.66f)
                    .padding(padding)
                    .padding(horizontal = 16.dp)
            ) {
                state.groupedNotes.forEach { (date, notes) ->
                    stickyHeader {
                        Text(
                            text = date,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.background)
                                .padding(vertical = 8.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    items(notes) { note ->
                        NoteCard(
                            note = note,
                            onClick = { onNoteClick(note.id) },
                            onLongClick = {
                                viewModel.onNoteLongClick(note.id)
                            }
                        )
                    }
                }
            }
        }
    }
}
