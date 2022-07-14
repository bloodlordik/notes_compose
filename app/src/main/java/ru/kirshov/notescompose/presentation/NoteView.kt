package ru.kirshov.notescompose.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import ru.kirshov.notescompose.domain.data.NoteRecord
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.logging.SimpleFormatter

@Composable
fun NoteView(modifier: Modifier = Modifier, note: NoteRecord, onClick: (id:Int) -> Unit = {}) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick.invoke(note.id) },
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = note.title, style = MaterialTheme.typography.h6)
            if (note.changeDate != null) {
                Text(
                    text = "Changed ${note.changeDate.format(DateTimeFormatter.ofPattern("MM/hh:mm"))}",
                    style = MaterialTheme.typography.overline
                )
            } else {
                Text(
                    text = "Created ${note.createDate.format(DateTimeFormatter.ofPattern("MM/hh:mm"))}",
                    style = MaterialTheme.typography.overline
                )
            }
        }
    }

}

@Composable
@Preview
fun NoteViewPreview() {
    NoteView(
        note = NoteRecord(
            id = 12,
            title = "Test title",
            content = LoremIpsum(24).toString(),
            createDate = LocalDateTime.now(),
            changeDate = null
        )
    ) {

    }
}