package ru.kirshov.notescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kirshov.notescompose.domain.MainViewModel
import ru.kirshov.notescompose.presentation.RootScaffold
import ru.kirshov.notescompose.ui.theme.NotesComposeTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel:MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesComposeTheme {
               RootScaffold(mainViewModel)
            }
        }
    }
}

