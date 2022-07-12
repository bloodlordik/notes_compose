package ru.kirshov.notescompose.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.kirshov.notescompose.domain.AppDispatchers

class AndroidDispatcher(
    override val main: CoroutineDispatcher=Dispatchers.Main,
    override val io: CoroutineDispatcher = Dispatchers.IO
) :AppDispatchers