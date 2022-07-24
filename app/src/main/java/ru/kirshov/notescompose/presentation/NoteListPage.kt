package ru.kirshov.notescompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow
import ru.kirshov.notescompose.domain.data.NoteRecord

@Composable
fun NoteListPage(navController: NavController, notes:Flow<List<NoteRecord>>){
    val state = notes.collectAsState(initial = emptyList())
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
       if (state.value.isEmpty()){
           Text(text = "Not record")
       }else{
          NoteListView(
              noteList = state.value,
              onSelect = {sectedId->

              }
          )
       }
    }

}