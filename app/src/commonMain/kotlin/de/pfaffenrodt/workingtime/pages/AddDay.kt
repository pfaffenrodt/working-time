package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.data.DateFormat
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun AddDay(component: Root.Child.AddDay) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // TODO add TOOLBAR back button
        var day by remember { mutableStateOf(Day.now()) }
        Column(modifier = Modifier.fillMaxWidth()) {
            // day input
            OutlinedTextField( // TODO replace with date picker
                value = day.format,
                label = { Text("Tag") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue ->
                    val dayValue = DateFormat.DAY.tryParse(newValue)
                    if (dayValue != null) {
                        day = day.copy(date = dayValue.local)
                    }
                })
            // target hours
            OutlinedTextField(
                "",
                label = { Text("Startzeit") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue ->
                    // TODO update time
                })
        }
        // add button
        Button({
            component.store(day)
        }, modifier = Modifier.fillMaxWidth()) {
            Icon(IconPack.Add, "")
            Text("Hinzufügen", color = Color.Black)
        }
    }
}