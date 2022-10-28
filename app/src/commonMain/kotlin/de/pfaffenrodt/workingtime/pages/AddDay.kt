package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.soywiz.klock.DateTime
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.components.DayPicker
import de.pfaffenrodt.workingtime.components.Toolbar
import de.pfaffenrodt.workingtime.data.DateFormat
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun AddDay(component: Root.Child.AddDay) {
    val now = DateTime.now()
    val startOfMonth = component.month.date.startOfMonth
    val endOfMonth = component.month.date.endOfMonth
    val minDate = if (now.month0 == startOfMonth.month0) now else startOfMonth
    val maxDate = if (endOfMonth > now && now.month0 == endOfMonth.month0) now else endOfMonth
    var day by remember {
        val date = if (now.month0 == component.month.date.month0) {
            Day.now()
        } else {
            Day(startOfMonth)
        }
        mutableStateOf(date)
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()) {
        // TODO add TOOLBAR back button
        Column(modifier = Modifier.fillMaxWidth()) {
            Toolbar(onBack = component::onBack) {
                Text(Strings.addDay)
            }
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                DayPicker(day.date,
                    minDate = minDate,
                    maxDate = maxDate) {
                    newValue -> day = day.copy(date = newValue)
                }
                // target hours
                OutlinedTextField(
                    "",
                    label = { Text("Startzeit") },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { newValue ->
                        // TODO update time
                    })
            }
        }
        Box(modifier = Modifier.padding(16.dp)) {
            // add button
            Button({
                component.store(day)
            }, modifier = Modifier.fillMaxWidth()) {
                Icon(IconPack.Add, "")
                Text("Hinzufügen", color = Color.Black)
            }
        }
    }
}