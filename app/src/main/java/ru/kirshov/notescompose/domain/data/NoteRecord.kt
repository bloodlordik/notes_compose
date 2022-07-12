package ru.kirshov.notescompose.domain.data

import ru.kirshov.notescompose.data.local.NoteEntity
import java.time.LocalDateTime

data class NoteRecord(
    val id:Int = 0,
    val title:String,
    val content:String,
    val createDate:LocalDateTime,
    val changeDate:LocalDateTime?=null
)


