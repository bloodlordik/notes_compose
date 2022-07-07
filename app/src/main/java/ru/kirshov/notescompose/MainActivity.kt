package ru.kirshov.notescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.kirshov.notescompose.presentation.RootScaffold
import ru.kirshov.notescompose.ui.theme.NotesComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesComposeTheme {
               RootScaffold()
            }
        }
    }
}

