package ru.kirshov.notescompose.domain


import kotlinx.coroutines.withContext
import ru.kirshov.notescompose.data.local.NoteEntity
import ru.kirshov.notescompose.data.local.NotesDao
import ru.kirshov.notescompose.domain.data.NoteRecord


class NotesRepository(
    private val notesDao: NotesDao,
    private val dispatchers: AppDispatchers
) {
    suspend fun getAllNotes(): List<NoteRecord> = withContext(dispatchers.io) {
        return@withContext notesDao.getAll().map { it.toNote() }
    }

    suspend fun addNote(note: NoteRecord) = withContext(dispatchers.io) {
        notesDao.insert(NoteEntity.fromNoteRecord(note))
    }

    suspend fun deleteNote(note: NoteRecord) = withContext(dispatchers.io) {
        notesDao.delete(NoteEntity.fromNoteRecord(note))
    }

    suspend fun updateNote(note: NoteRecord) = withContext(dispatchers.io) {
        notesDao.delete(NoteEntity.fromNoteRecord(note))
    }


}


