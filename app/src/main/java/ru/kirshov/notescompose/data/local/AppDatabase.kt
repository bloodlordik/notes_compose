package ru.kirshov.notescompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [NoteEntity::class]
)
abstract class AppDatabase:RoomDatabase() {
    abstract  fun getNotesDao():NotesDao
}