package ru.kirshov.notescompose.data.local

import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): List<NoteEntity>
    @Insert
    fun insert(note:NoteEntity)
    @Delete
    fun delete(note: NoteEntity)
    @Update
    fun update(note: NoteEntity)

}