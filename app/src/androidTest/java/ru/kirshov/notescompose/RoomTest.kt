package ru.kirshov.notescompose

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.kirshov.notescompose.data.local.AppDatabase
import ru.kirshov.notescompose.data.local.NotesDao


@RunWith(AndroidJUnit4::class)
class RoomTest {
    private lateinit var dao:NotesDao
    private lateinit var testDb:AppDatabase

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        testDb = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = testDb.getNotesDao()
    }

    @After
    fun closeDb(){
        testDb.close()
    }

    @Test
    fun emptyTest(){
        val list = dao.getAll()
        
    }
}