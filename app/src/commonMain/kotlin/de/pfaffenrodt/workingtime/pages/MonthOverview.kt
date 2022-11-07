package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.components.EditButton
import de.pfaffenrodt.workingtime.components.SortButton
import de.pfaffenrodt.workingtime.components.Toolbar
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.data.MonthSummary
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun MonthOverview(component: Root.Child.MonthOverview) {
    val items = component.items()
    val summary = MonthSummary(component.month, items)
    var sortByDesc by remember { mutableStateOf(true) }
    val sortedItems = if (sortByDesc) {
        items.sortedByDescending { it.dayOfMonth }
    } else {
        items.sortedBy { it.dayOfMonth }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar(
            onBack = component::onBack,
            actions = {
              SortButton {
                  sortByDesc = !sortByDesc
              }
            },
        ) {
            Text(component.month.displayFormat)
            Text(Strings.monthView, modifier = Modifier.alpha(0.6f))
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize(),
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
                                .alpha(0.87f),
                            style = MaterialTheme.typography.h1,
                        )
                    }
                } else {
                    items(sortedItems, key = { it.dayOfMonth }) {
                        item -> ListItem(item) {
                            day: Day ->  component.onOpenDay(day)
                        }
                    }
                }
                item {
                    Box(modifier = Modifier.defaultMinSize(minHeight = 48.dp)) {
                        if (items.size > 5) {
                            Text(
                                Strings.descriptionStartNewDay,
                                modifier = Modifier.fillMaxSize(0.7f)
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                style = MaterialTheme.typography.body1,
                            )
                        }
                    }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
            ) {
                if (items.size < 5) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            Strings.descriptionStartNewDay,
                            modifier = Modifier
                                .alpha(0.6f),
                            style = MaterialTheme.typography.body1,
                        )
                    }
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
    Card(modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.medium) {
        Column(modifier = Modifier.fillMaxWidth().clickable { open(item) }) {
            Row(Modifier.height(IntrinsicSize.Min)) {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.primary)
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 4.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        item.dayOfMonth,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier,
                        fontFamily = FontFamily.Monospace,
                        color = MaterialTheme.colors.onPrimary,
                    )
                    Text(
                        item.dayOfWeek,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier,
                        fontFamily = FontFamily.Monospace,
                        color = MaterialTheme.colors.onPrimary,
                    )
                }
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                ) {
                    Text(text = item.hoursSummary, style = MaterialTheme.typography.h1)
                    Text(text = item.summary, style = MaterialTheme.typography.subtitle1)
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