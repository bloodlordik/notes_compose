package ru.kirshov.notescompose.presentation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.kirshov.notescompose.domain.MainViewModel

@Composable
fun RootScaffold(viewModel: MainViewModel){

    val state = viewModel.itemsState.collectAsState(initial = EmptyList)
    Scaffold(
        content = {
            when(state.value){
                is EmptyList -> Text(text = "emty")
                is NoteList -> Text(text = (state.value as NoteList).list.size.toString())
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addNotes() }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center

    ) 
}