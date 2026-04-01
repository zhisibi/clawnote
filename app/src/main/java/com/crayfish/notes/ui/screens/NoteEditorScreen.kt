package com.crayfish.notes.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.crayfish.notes.ui.viewmodel.NoteEditorViewModel
import io.noties.markwon.Markwon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEditorScreen(viewModel: NoteEditorViewModel, onBack: () -> Unit) {
    val state by viewModel.state.collectAsState()
    val colors = listOf("#FFFFFF", "#F8D7DA", "#D1E7DD", "#FFF3CD", "#CFE2FF", "#E2E3E5")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("编辑笔记") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "返回")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.setPreviewMode(false) }) {
                        Icon(Icons.Default.Edit, contentDescription = "编辑")
                    }
                    IconButton(onClick = { viewModel.setPreviewMode(true) }) {
                        Text("预览")
                    }
                    IconButton(onClick = { 
                        viewModel.saveNote()
                        onBack()
                    }) {
                        Icon(Icons.Default.Check, contentDescription = "保存")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(android.graphics.Color.parseColor(state.bgColor)))
                .padding(16.dp)
        ) {
            // 标题输入
            TextField(
                value = state.title,
                onValueChange = { viewModel.onTitleChange(it) },
                placeholder = { Text("标题", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                ),
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 颜色选择器
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(colors) { colorHex ->
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(android.graphics.Color.parseColor(colorHex)))
                            .clickable { viewModel.onColorChange(colorHex) }
                            .then(if (state.bgColor == colorHex) Modifier.padding(4.dp).background(Color.Black, CircleShape) else Modifier)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (!state.isPreviewMode) {
                // 编辑模式：多行 Markdown 文本框
                TextField(
                    value = state.content,
                    onValueChange = { viewModel.onContentChange(it) },
                    placeholder = { Text("支持 Markdown 语法，例如 # 标题、**加粗**、`代码` 等") },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                    )
                )
            } else {
                // 预览模式：Markdown 渲染
                val scrollState = rememberScrollState()
                val context = LocalContext.current
                val markwon = Markwon.builder(context).build()

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                ) {
                    AndroidView(
                        factory = { ctx ->
                            android.widget.TextView(ctx).apply {
                                setTextColor(android.graphics.Color.BLACK)
                            }
                        },
                        update = { textView ->
                            markwon.setMarkdown(
                                textView,
                                state.content.ifBlank { "（内容为空）" }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
