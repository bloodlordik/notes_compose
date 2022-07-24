package ru.kirshov.notescompose.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.kirshov.notescompose.domain.ActionEvents
import ru.kirshov.notescompose.domain.AddNoteNavigation
import ru.kirshov.notescompose.domain.EventHandler

@Composable
fun EmptyNoteList(eventHandler: EventHandler<ActionEvents>){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Button(onClick = {
            eventHandler.emit(AddNoteNavigation)
        }) {
            Text(text = "Add note")
        }
    }
}