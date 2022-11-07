package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import de.pfaffenrodt.workingtime.components.SecondaryButtonSettings
import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.icons.IconPack
import de.pfaffenrodt.workingtime.icons.Logo
import de.pfaffenrodt.workingtime.icons.monthIcon

@Composable
fun YearOverview(component: Root.Child.YearOverview) {
    val items = component.items()
    if (items.isEmpty()) {
        EmptyYearPage {
            component.onAddMonth()
        }
    } else {
        YearPage(
            component,
            items,
            add = {
                component.onAddMonth()
            },
            open = {
                component.onOpenMonth(it)
            }
        )
    }
}

@Composable
fun EmptyYearPage(add: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()) {
            Image(
                IconPack.Logo,
                null,
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.5f)
                    .wrapContentHeight()
            )
            Text(
                text = Strings.noEntries,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .alpha(0.87f),
                style = MaterialTheme.typography.h1,
            )
        }
        Row() {
            Column(modifier = Modifier.weight(1f)) {
                Text(Strings.workingTimeTracking,
                    modifier = Modifier
                        .alpha(0.87f),
                    style = MaterialTheme.typography.h1,
                )
                Text(Strings.descriptionStartNewMonth,
                    modifier = Modifier
                        .alpha(0.6f),
                    style = MaterialTheme.typography.body1,
                )
            }
            FloatingActionButton(
                onClick = add,
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


@Composable
fun YearPage(
    component: Root.Child.YearOverview,
    items: List<Month>,
    add: () -> Unit,
    open: (month: Month) -> Unit,
) {

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)) {
            Row {
                Image(
                    IconPack.Logo,
                    null,
                    Modifier
                        .fillMaxWidth(0.3f)
                        .wrapContentHeight()
                )

                Column(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                ) {
                    Text(Strings.workingTimeTracking,
                        modifier = Modifier
                            .alpha(0.87f),
                        style = MaterialTheme.typography.h1,
                    )
                    Text(Strings.yearView,
                        modifier = Modifier
                            .alpha(0.6f),
                        style = MaterialTheme.typography.body1,
                    )
                }
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(items) {
                    ListItem(component, it) {
                        month -> open(month)
                    }
                }
            }
        }
        Row() {
            Text(Strings.descriptionStartNewMonth,
                modifier = Modifier
                    .alpha(0.6f)
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                style = MaterialTheme.typography.body1,
            )
            FloatingActionButton(
                onClick = add,
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

@Composable
fun ListItem(
    component: Root.Child.YearOverview,
    item: Month,
    open: (month: Month) -> Unit
) {
    val summary = component.summary(item)
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
    ) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
            .fillMaxWidth().clickable { open(item) }
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f).padding(horizontal = 20.dp)) {
                Text(summary.hours + " (" + summary.transferHours +")", style = MaterialTheme.typography.subtitle1)
                Text(item.displayFormat, style = MaterialTheme.typography.h1)
            }
            SecondaryButtonSettings {
                Icon(
                    item.date.month1.monthIcon(),
                    null,
                    Modifier.size(80.dp)
                        .background(MaterialTheme.colors.secondary, CircleShape)
                        .padding(16.dp),
                )
            }
        }
    }
}