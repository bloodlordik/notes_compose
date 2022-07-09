package ru.kirshov.notescompose.data.local

import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAll():List<NoteEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:NoteEntity)
    @Delete
    suspend fun deleteNote(note: NoteEntity)
    @Update
    suspend fun updateNote(note: NoteEntity)
}