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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.components.DayPicker
import de.pfaffenrodt.workingtime.components.MonthPicker
import de.pfaffenrodt.workingtime.components.Toolbar
import de.pfaffenrodt.workingtime.data.DateFormat
import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.data.toString
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun EditMonth(component: Root.Child.EditMonth) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()) {
        var month by remember { mutableStateOf(component.month) }
        Column(modifier = Modifier.fillMaxWidth()) {
            Toolbar(onBack = component::onBack) {
                Text(month.displayFormat + Strings.editMonth)
            }
            Column( modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ){
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
        }
        Box(modifier = Modifier.padding(16.dp)) {
            // add button
            Button({
                component.store(month)
            }, modifier = Modifier.fillMaxWidth()) {
                Icon(IconPack.Add, "")
                Text("Hinzufügen", color = Color.Black)
            }
        }
    }
}