package ru.kirshov.notescompose.presentation

import ru.kirshov.notescompose.domain.data.NoteRecord

sealed interface UiStateMain

object EmptyList:UiStateMain
data class NoteList(
    val list:List<NoteRecord>
):UiStateMain
