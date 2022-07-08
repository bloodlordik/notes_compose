package ru.kirshov.notescompose.data.local

import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll():List<NoteEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note:NoteEntity)
    @Delete
    fun deleteNote(note: NoteEntity)
    @Update
    fun updateNote(note: NoteEntity)
}