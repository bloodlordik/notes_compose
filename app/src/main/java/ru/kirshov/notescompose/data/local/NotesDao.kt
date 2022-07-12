package ru.kirshov.notescompose.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll(): Flow<List<NoteEntity>>
    @Insert
    fun insert(note:NoteEntity)
    @Delete
    fun delete(note: NoteEntity)
    @Update
    fun update(note: NoteEntity)

}