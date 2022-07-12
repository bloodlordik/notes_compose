package ru.kirshov.notescompose.domain


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.kirshov.notescompose.domain.data.NoteRecord

import ru.kirshov.notescompose.presentation.EmptyList
import ru.kirshov.notescompose.presentation.NoteList
import ru.kirshov.notescompose.presentation.UiStateMain
import java.time.LocalDateTime

class MainViewModel(
    private val repository: NotesRepository,
    private val dispatchers: AppDispatchers
):ViewModel() {
   val itemsState: Flow<UiStateMain> = repository.getAllNotes().map {
       if (it.isEmpty()) EmptyList else NoteList(list = it)
   }.flowOn(dispatchers.main)
    fun addNotes(){
        viewModelScope.launch {
            repository.addNote(
                NoteRecord(
                    title = "llll",
                    content = "jjjj",
                    createDate = LocalDateTime.now(),
                    changeDate = null
                )
            )
        }
    }


}