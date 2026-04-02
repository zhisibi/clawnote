package com.crayfish.notes.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 简单的 Markdown 工具栏：H1 / H2 / 粗体 / 列表 / 代码块
 */
@Composable
fun MarkdownToolbar(onAction: (String) -> Unit) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedButton(onClick = { onAction("\n# ") }) {
            Text("H1")
        }
        OutlinedButton(onClick = { onAction("\n## ") }) {
            Text("H2")
        }
        OutlinedButton(onClick = { onAction("**粗体**") }) {
            Text("B")
        }
        OutlinedButton(onClick = { onAction("\n- ") }) {
            Text("列表")
        }
        OutlinedButton(onClick = { onAction("\n```\n代码\n```\n") }) {
            Text("代码块")
        }
    }
}
