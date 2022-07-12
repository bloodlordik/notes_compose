package ru.kirshov.notescompose.domain

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    val main:CoroutineDispatcher
    val io:CoroutineDispatcher
}

