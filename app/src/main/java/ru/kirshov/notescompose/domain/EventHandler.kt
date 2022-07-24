package ru.kirshov.notescompose.domain

interface EventHandler<T> {
    fun emit(event:T)
}