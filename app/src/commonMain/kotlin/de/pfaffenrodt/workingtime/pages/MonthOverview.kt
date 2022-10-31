package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import de.pfaffenrodt.workingtime.components.EditButton
import de.pfaffenrodt.workingtime.components.Toolbar
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.data.MonthSummary
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun MonthOverview(component: Root.Child.MonthOverview) {
    val items = component.items()
    val summary = MonthSummary(component.month, items)
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar(
            onBack = component::onBack
        ) {
            Text(component.month.displayFormat)
            Text(Strings.monthView, modifier = Modifier.alpha(0.6f))
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(1f).padding(16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                item {
                    Column(modifier = Modifier.padding(bottom = 8.dp)) {
                        Row(modifier = Modifier.padding(bottom = 16.dp)) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(Strings.actualHours + " " + summary.hours )
                                Text("${Strings.targetHours} ${component.month.targetHours ?: "-" }")
                                Text("${Strings.monthDiff} ${summary.monthHoursDiff}")
                                Text("${Strings.lastMonthTransfer} ${component.month.lastMonthHoursTransfer ?: "-" }")
                                Text("${Strings.nextMonthTransfer} ${summary.transferHours}")
                            }
                            EditButton { component.editMonth() }
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
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    item.date.dayOfMonth.toString(),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(8.dp)
                )
                Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(text = item.hoursSummary, style = MaterialTheme.typography.subtitle1)
                    Text(text = item.summary, style = MaterialTheme.typography.h1)
                    if (!item.note.isNullOrBlank()) {
                        Box(
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                        Divider(thickness = 1.dp, color = Color.White.copy(0.6f))
                        Text(
                            text = item.note ?: "",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}