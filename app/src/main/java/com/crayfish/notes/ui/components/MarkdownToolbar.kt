package com.crayfish.notes.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
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
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        SmallChip("H1") { onAction("\n# ") }
        SmallChip("H2") { onAction("\n## ") }
        SmallChip("B") { onAction("**粗体**") }
        SmallChip("列") { onAction("\n- ") }
        SmallChip("码") { onAction("\n```\n代码\n```\n") }
        SmallChip("表") { onAction("\n| 表头 | 表头 |\n| --- | --- |\n| 内容 | 内容 |\n") }
    }
}

@Composable
private fun SmallChip(label: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier,
        contentPadding = ButtonDefaults.ContentPadding
            .copy(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(label)
    }
}
