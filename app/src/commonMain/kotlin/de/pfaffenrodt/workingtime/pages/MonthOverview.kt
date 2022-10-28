package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun MonthOverview(component: Root.Child.MonthOverview) {
    val items = component.items()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                IconPack.Back,
                "Zurück",
                modifier = Modifier.size(48.dp)
                    .clickable {
                    component.onBack()
                }
                .padding(8.dp)
            )
            Column(
                modifier = Modifier.weight(1f).padding(vertical = 8.dp)) {
                Text("Monat ${component.month.displayFormat}")
                Text(Strings.monthView, modifier = Modifier.alpha(0.6f))
            }
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(1f).padding(16.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    Column(modifier = Modifier.padding(bottom = 8.dp)) {
                        Row(modifier = Modifier.padding(bottom = 16.dp)) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(Strings.actualHours + " TODO")
                                Text("${Strings.targetHours} ${component.month.targetHours} h")
                                Text("${Strings.lastMonthTransfer} ${component.month.lastMonthHoursTransfer} h")
                                Text("${Strings.nextMonthTransfer} TODO h")
                            }
                            Icon(
                                IconPack.Edit,
                                "Bearbeiten",
                                modifier = Modifier.size(48.dp)
                                    .clickable { component.editMonth() }
                                    .padding(8.dp)
                            )
                        }
                        Box (modifier = Modifier
                            .alpha(0.2f)
                            .background(Color.White)
                            .height(1.dp)
                            .fillMaxWidth()){  }
                    }
                }
                if (items.isEmpty()) {
                    item {
                        Text(
                            text = Strings.noEntries,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .alpha(0.87f),
                            style = MaterialTheme.typography.h1,
                        )
                    }
                } else {
                    items(items) {
                        item -> ListItem(item) {
                            day: Day ->  component.onOpenDay(day)
                        }
                    }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        Strings.descriptionStartNewDay,
                        modifier = Modifier
                            .alpha(0.6f),
                        style = MaterialTheme.typography.body1,
                    )
                }
                FloatingActionButton(
                    onClick = { component.onAddDay() },
                    backgroundColor = MaterialTheme.colors.primary,
                    content = {
                        Icon(
                            IconPack.Add,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ListItem(item: Day, open: (day: Day) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable { open(item) }) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(item.date.dayOfMonth.toString() + ".")
        }
    }
}