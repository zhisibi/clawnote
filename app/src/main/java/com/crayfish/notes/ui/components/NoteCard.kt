package com.crayfish.notes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crayfish.notes.domain.model.Note

@Composable
fun NoteCard(note: Note, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .background(Color(android.graphics.Color.parseColor(note.bgColor)))
                .padding(16.dp)
        ) {
            Text(
                text = note.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = note.content.take(50),
                fontSize = 14.sp,
                color = Color.DarkGray,
                maxLines = 2
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                note.tags.forEach { tag ->
                    Surface(
                        color = Color(android.graphics.Color.parseColor(tag.color)),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = tag.name,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                            fontSize = 10.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
