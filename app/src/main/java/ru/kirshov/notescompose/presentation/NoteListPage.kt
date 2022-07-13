package ru.kirshov.notescompose.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.kirshov.notescompose.domain.data.NoteRecord

@Composable
fun NoteListPage(navController: NavController, uiStateMain: UiStateMain){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(NavigationDestination.NotePage.name)
            }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        when(uiStateMain){
            is EmptyList->{
                Text(text = "Empty")
            }
            is NoteList->{
                Text(text = uiStateMain.list.first().content)
            }
        }
    }

}