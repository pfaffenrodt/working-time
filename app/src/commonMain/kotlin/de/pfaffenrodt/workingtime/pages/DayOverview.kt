package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soywiz.klock.DateTime
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.components.CloseButton
import de.pfaffenrodt.workingtime.components.EditButton
import de.pfaffenrodt.workingtime.components.SaveButton
import de.pfaffenrodt.workingtime.components.TimePicker
import de.pfaffenrodt.workingtime.components.Toolbar
import de.pfaffenrodt.workingtime.data.DateFormat
import de.pfaffenrodt.workingtime.data.string
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun DayOverview(component: Root.Child.DayOverview)
{
    var newTime by remember { mutableStateOf(DateTime.now()) }
    var addTime by remember {
        val size = component.day.times.size
        val value = size == 0 || size.mod(2) == 1
        mutableStateOf(value)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar(
            onBack = component::onBack,
        ) {
            Text(component.day.fullDisplayFormat)
            Text(Strings.dayView, modifier = Modifier.alpha(0.6f))
        }
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp).weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Note(component.day.note?:"") {
                        component.onEditNote(it)
                    }
                }
                items(component.day.timeSpans) { item ->
                    Row {
                        val content = "Zeit: " + item.string()
                        Text(content)
                    }
                }
            }

            Column {
                if (addTime) {
                    Box {
                        TimePicker(newTime) { newValue ->
                            newTime = newValue
                        }
                        CloseButton { addTime = false }
                    }
                    Box(modifier = Modifier.padding(16.dp)) {
                        // add button
                        Button({
                            component.store(newTime)
                        }, modifier = Modifier.fillMaxWidth()) {
                            Icon(IconPack.Add, "")
                            Text(Strings.add, color = Color.Black)
                        }
                    }
                } else {
                    Box(modifier = Modifier.padding(16.dp)) {
                        // add button
                        Button({
                            addTime = true
                        }, modifier = Modifier.fillMaxWidth()) {
                            Icon(IconPack.Add, "")
                            Text(Strings.add, color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Note(note: String, onValueChange: (String) -> Unit) {
    var editNote by remember {
        mutableStateOf(false)
    }
    var newNote by remember {
        mutableStateOf(note)
    }
    Card {
        Row(modifier = Modifier.padding(16.dp)) {
            if (editNote) {
                TextField(
                    value = newNote,
                    label = {
                        Text(Strings.note)
                    },
                    onValueChange = { newNote = it },
                    modifier = Modifier.weight(1f)
                )
                SaveButton {
                    onValueChange(newNote)
                    editNote = false
                }
            } else {
                if (note.isNullOrBlank()) {
                    Text(
                        "Eine Notiz hinzufügen?",
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Text(
                        "Notiz:\n${note} ",
                        modifier = Modifier.weight(1f)
                    )
                }
                EditButton { editNote = true }
            }
        }
    }
}