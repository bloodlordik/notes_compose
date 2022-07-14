package ru.kirshov.notescompose.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import ru.kirshov.notescompose.domain.data.NoteRecord
import java.time.LocalDateTime
import kotlin.random.Random

@Composable
fun NoteListView(
    modifier: Modifier = Modifier,
    noteList: List<NoteRecord> = emptyList(),
    onSelect: (id:Int) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp)
    ){
        items(noteList){ note->
            NoteView(note = note, onClick = onSelect)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }

}

@Preview
@Composable
fun NoteListViewPreview() {
    NoteListView(noteList = generateSampleData(12))
}

private fun generateSampleData(num: Int): List<NoteRecord> {
    return (0 until num).map { value ->
        NoteRecord(
            id = value,
            title = "Test title $value",
            content = LoremIpsum(24).toString(),
            createDate = LocalDateTime.now(),
            changeDate = if (Random.nextBoolean()) LocalDateTime.now() else null
        )
    }
}