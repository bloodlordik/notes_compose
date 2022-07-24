package ru.kirshov.notescompose.presentation


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ru.kirshov.notescompose.domain.MainViewModel

@Composable
fun NoteDetail(
    navController: NavController,
    viewModel: MainViewModel
) {
    NoteAddPage() {
        viewModel.addNote(it)
        navController.navigate(NavigationDestination.RootPage.name)
    }
}