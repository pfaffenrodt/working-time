package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun MonthOverview(component: Root.Child.MonthOverview) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()) {
            Text("Monat ${component.month.month}")
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