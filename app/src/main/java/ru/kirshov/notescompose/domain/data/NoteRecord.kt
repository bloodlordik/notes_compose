package ru.kirshov.notescompose.domain.data

import java.time.LocalDateTime

data class NoteRecord(
    val id:Int,
    val title:String,
    val content:String,
    val createDate:LocalDateTime,
    val changeDate:LocalDateTime?=null
)
