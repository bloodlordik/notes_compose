package ru.kirshov.notescompose.domain

import ru.kirshov.notescompose.domain.data.NoteRecord

sealed interface ActionEvents

object AddNoteNavigation:ActionEvents
data class SelectNote(val noteRecord: NoteRecord):ActionEvents
