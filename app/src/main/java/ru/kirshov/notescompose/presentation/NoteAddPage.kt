package ru.kirshov.notescompose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kirshov.notescompose.domain.data.NoteRecord
import java.time.LocalDateTime

@Composable
fun NoteAddPage(
    successful:(note:NoteRecord)->Unit = {}
) {
    var titleText by remember {
        mutableStateOf("")
    }
    var content by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = titleText,
            onValueChange = { titleText = it },
            label = { Text("Title") })
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text(text = "Content") },
            singleLine = false
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
             successful.invoke(
                 NoteRecord(
                     title = titleText,
                     content = content,
                     createDate = LocalDateTime.now(),
                     changeDate = null
                 )
             )
            }) {
                Text(text = "Add note")
            }
        }
    }

}

