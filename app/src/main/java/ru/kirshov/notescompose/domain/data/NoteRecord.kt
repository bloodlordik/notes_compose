package ru.kirshov.notescompose.domain.data

import ru.kirshov.notescompose.data.local.NoteEntity
import java.time.LocalDateTime

data class NoteRecord(
    val id:Int,
    val title:String,
    val content:String,
    val createDate:LocalDateTime,
    val changeDate:LocalDateTime?=null
)

fun NoteEntity.toNote():NoteRecord{
    return NoteRecord(
        id = this.id,
        title = this.title,
        content = this.content,
        createDate = LocalDateTime.parse(this.createDate),
        changeDate = if (this.changeDate == null) {
            null
        }else{
            LocalDateTime.parse(this.changeDate)
        }
    )
}

