package ru.kirshov.notescompose.domain


import ru.kirshov.notescompose.data.local.NotesDao
import ru.kirshov.notescompose.domain.data.NoteRecord
import ru.kirshov.notescompose.domain.data.toNote

class NotesRepository(private val notesDao: NotesDao) {
    suspend fun getAllNotes():List<NoteRecord>{
        return notesDao.getAll().map { it.toNote() }
    }

}


