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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soywiz.klock.DateTime
import com.soywiz.klock.DateTimeRange
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.components.CloseButton
import de.pfaffenrodt.workingtime.components.DeleteButton
import de.pfaffenrodt.workingtime.components.EditButton
import de.pfaffenrodt.workingtime.components.PrimaryButtonSettings
import de.pfaffenrodt.workingtime.components.SaveButton
import de.pfaffenrodt.workingtime.components.TimePicker
import de.pfaffenrodt.workingtime.components.Toolbar
import de.pfaffenrodt.workingtime.components.endCornerButton
import de.pfaffenrodt.workingtime.data.DateFormat
import de.pfaffenrodt.workingtime.data.string
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun DayOverview(component: Root.Child.DayOverview)
{
    var editMode by remember { mutableStateOf(false) }

    if (editMode) {
        DayOverviewEditMode(
            component,
            onCancelEditMode = { editMode = false },
            onSave = { editMode = false },
        )
    } else {
        DayOverviewNormalMode(component,
            onEnableEditMode = { editMode = true }
        )
    }
}

@Composable
fun DayOverviewNormalMode(
    component: Root.Child.DayOverview,
    onEnableEditMode: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar(
            component::onBack,
            actions = {
                EditButton(onEdit = onEnableEditMode)
            }
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
                    TimeSpanItem(item)
                }
            }

            AddTime(component)
        }
    }
}

@Composable
fun DayOverviewEditMode(
    component: Root.Child.DayOverview,
    onCancelEditMode: () -> Unit,
    onSave: () -> Unit,
) {
    var editItems by remember { mutableStateOf(component.day.times) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar(
            leadingActions = {
                CloseButton(onClick = onCancelEditMode)
            },
            tailingActions = {
                SaveButton {
                    component.updateListOfEntries(editItems)
                    onSave()
                }
            }
        ) {
            Text(component.day.fullDisplayFormat)
            Text(Strings.dayEditView, modifier = Modifier.alpha(0.6f))
        }
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp).weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(editItems) { index, item ->
                    EditTimeItem(index, editItems.lastIndex, item) {
                        editItems = editItems.toMutableList().also { it.removeAt(index) }
                    }
                }
            }
        }
    }
}

@Composable
fun EditTimeItem(index: Int, lastIndex: Int, item: DateTime, onDelete: () -> Unit) {
    val label = if (index % 2 == 0)
        Strings.startTime
    else if (index == lastIndex)
        Strings.endOfWorkingDay
    else Strings.endTime

    Card {
        Row(verticalAlignment = Alignment.CenterVertically){
            val content = label + " " + item.toString(DateFormat.TIME)
            Text(content, modifier = Modifier.weight(1f).padding(8.dp))
            DeleteButton {
                onDelete()
            }
        }
    }
}

@Composable
fun TimeSpanItem(item: DateTimeRange) {
    Card {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val content = "${Strings.timeRange}: " + item.string()
            Text(content, modifier = Modifier.weight(1f).padding(8.dp))
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
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.Bottom
        ) {
            if (editNote) {
                TextField(
                    value = newNote,
                    label = {
                        Text(Strings.note)
                    },
                    onValueChange = { newNote = it },
                    modifier = Modifier.weight(1f).padding(16.dp)
                )
                PrimaryButtonSettings {
                    SaveButton(boundedIndication = true,
                        modifier = Modifier.endCornerButton()
                    ) {
                        onValueChange(newNote)
                        editNote = false
                    }
                }
            } else {
                if (note.isNullOrBlank()) {
                    Text(
                        "Eine Notiz hinzufügen?",
                        modifier = Modifier.weight(1f).padding(16.dp)
                    )
                } else {
                    Text(
                        "Notiz:\n${note} ",
                        modifier = Modifier.weight(1f).padding(16.dp)
                    )
                }

                PrimaryButtonSettings {
                    EditButton(
                        boundedIndication = true,
                        modifier = Modifier.endCornerButton()
                    ) { editNote = true }
                }
            }
        }
    }
}

@Composable
fun AddTime(component: Root.Child.DayOverview) {
    var newTime by remember { mutableStateOf(DateTime.now()) }
    var addTime by remember {
        val size = component.day.times.size
        val value = size == 0 || size < 4 && size.mod(2) == 1
        mutableStateOf(value)
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