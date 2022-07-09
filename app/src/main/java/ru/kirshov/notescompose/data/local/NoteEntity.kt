package ru.kirshov.notescompose.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_NAME)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val title:String,
    val content:String,
    val createDate:String,
    val changeDate:String?=null

)
 const val TABLE_NAME = "notes"