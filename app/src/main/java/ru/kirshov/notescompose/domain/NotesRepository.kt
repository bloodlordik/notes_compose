package ru.kirshov.notescompose.domain


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.withContext
import ru.kirshov.notescompose.data.local.NoteEntity
import ru.kirshov.notescompose.data.local.NotesDao
import ru.kirshov.notescompose.domain.data.NoteRecord


class NotesRepository(
    private val notesDao: NotesDao,
    private val dispatchers: AppDispatchers
) {
    fun getAllNotes(): Flow<List<NoteRecord>> =
        notesDao.getAll().map { it.map { value -> value.toNote() } }.flowOn(dispatchers.io)

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


