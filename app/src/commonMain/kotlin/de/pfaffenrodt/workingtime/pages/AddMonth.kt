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
import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.data.toString
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun AddMonth(component: Root.Child.AddMonth) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // TODO add TOOLBAR back button
        var month by remember { mutableStateOf(Month.now()) }
        Column(modifier = Modifier.fillMaxWidth()) {
            // month input
            OutlinedTextField( // TODO replace with date picker
                value = month.format,
                label = { Text("Monat") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue ->
                    val monthValue = DateFormat.MONTH.tryParse(newValue, false)
                    if (monthValue != null) {
                        month = month.copy(date = monthValue)
                    }
                })
            // target hours
            OutlinedTextField(
                month.targetHours.toString(),
                label = { Text("Sollstunden") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue ->
                    try {
                        month = month.copy(targetHours = newValue)
                    } catch (error: Exception) {

                    }
                })
            // last month
            OutlinedTextField(
                month.lastMonthHoursTransfer.toString(),
                label = { Text("Vormonatübertrag") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue ->
                    try {
                        month = month.copy(lastMonthHoursTransfer = newValue)
                    } catch (error: Exception) {

                    }
                }
            )
        }
        // add button
        Button({
            component.store(month)
        }, modifier = Modifier.fillMaxWidth()) {
            Icon(IconPack.Add, "")
            Text("Hinzufügen", color = Color.Black)
        }
    }
}