package ru.kirshov.notescompose.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kirshov.notescompose.data.AndroidDispatcher
import ru.kirshov.notescompose.data.local.AppDatabase
import ru.kirshov.notescompose.domain.AppDispatchers
import ru.kirshov.notescompose.domain.MainViewModel
import ru.kirshov.notescompose.domain.NotesRepository

val androidModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "appDb").build()
            .getNotesDao()
    }
    factory<AppDispatchers> { AndroidDispatcher() }
    single { NotesRepository(get(), get()) }
    viewModel { MainViewModel(get(), get()) }
}