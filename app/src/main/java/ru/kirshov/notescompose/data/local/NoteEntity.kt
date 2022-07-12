package ru.kirshov.notescompose.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.kirshov.notescompose.domain.data.NoteRecord
import java.time.LocalDateTime

@Entity(tableName = TABLE_NAME)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val title:String,
    val content:String,
    @ColumnInfo(name = "create_date") val createDate:String,
    @ColumnInfo(name = "change_date") val changeDate:String?=null
){
    fun toNote() = NoteRecord(
        id = id,
        title = title,
        content = content,
        createDate = LocalDateTime.parse(createDate),
        changeDate = if (changeDate==null) null else LocalDateTime.parse(changeDate)
    )
    companion object{
        fun fromNoteRecord(note:NoteRecord):NoteEntity{
            return NoteEntity(
                id = note.id,
                title = note.title,
                content = note.content,
                createDate = note.createDate.toString(),
                changeDate = if(note.changeDate==null) null else note.changeDate.toString()
            )
        }
    }
}
const val TABLE_NAME = "notes"