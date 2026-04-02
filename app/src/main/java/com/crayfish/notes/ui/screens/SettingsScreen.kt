package com.crayfish.notes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.crayfish.notes.ui.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(viewModel: SettingsViewModel, onBack: () -> Unit) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("同步设置") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("返回")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Git 私有仓库地址", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = state.remoteUrl,
                onValueChange = { viewModel.onRemoteUrlChange(it) },
                placeholder = { Text("例如 git@github.com:zhisibi/clawnote-notes.git") },
                modifier = Modifier.fillMaxWidth()
            )

            Text("SSH 公钥 (添加到仓库的 Deploy Keys)", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = state.publicKey ?: "正在生成或尚未生成", 
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 80.dp)
            )

            Text("最后同步时间：${state.lastSyncTime}")

            // UI 字体大小设置
            Text("界面字体缩放", fontWeight = FontWeight.Bold)
            Slider(
                value = state.uiFontScale,
                onValueChange = { viewModel.onUiFontScaleChange(it) },
                valueRange = 0.8f..1.4f,
                steps = 3
            )

            Text("笔记字体缩放", fontWeight = FontWeight.Bold)
            Slider(
                value = state.noteFontScale,
                onValueChange = { viewModel.onNoteFontScaleChange(it) },
                valueRange = 0.8f..1.6f,
                steps = 4
            )

            if (state.errorMessage != null) {
                Text(
                    text = "同步失败：${state.errorMessage}",
                    color = MaterialTheme.colorScheme.error
                )
            }

            Button(
                onClick = { viewModel.syncNow() },
                enabled = !state.isSyncing,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (state.isSyncing) "正在同步..." else "立即同步")
            }
        }
    }
}
