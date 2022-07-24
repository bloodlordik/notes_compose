package ru.kirshov.notescompose.domain


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import ru.kirshov.notescompose.domain.data.NoteRecord

import ru.kirshov.notescompose.presentation.EmptyList
import ru.kirshov.notescompose.presentation.LoadingRepository
import ru.kirshov.notescompose.presentation.NoteList
import ru.kirshov.notescompose.presentation.UiStateMain
import java.time.LocalDateTime

class MainViewModel(
    private val repository: NotesRepository,
    private val dispatchers: AppDispatchers
) : ViewModel(){
    fun getAllNotes():Flow<List<NoteRecord>> = repository.getAllNotes()
    fun addNote(note:NoteRecord){
        viewModelScope.launch(dispatchers.io) {
            repository.addNote(note)
        }
    }


}