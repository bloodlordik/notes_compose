package ru.kirshov.notescompose.presentation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kirshov.notescompose.domain.MainViewModel

@Composable
fun RootScaffold(viewModel: MainViewModel){
    val navController = rememberNavController()
    val uiState = viewModel.itemsState.collectAsState(initial = EmptyList)
    NavHost(navController = navController, startDestination = NavigationDestination.RootPage.name){
        composable(NavigationDestination.RootPage.name){
            NoteListPage(navController = navController, uiStateMain = uiState.value)
        }
        composable(NavigationDestination.NotePage.name){
            NoteDetail(navController = navController)
        }
    }

}