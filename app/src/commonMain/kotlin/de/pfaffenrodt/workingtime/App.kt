package de.pfaffenrodt.workingtime

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.pfaffenrodt.workingtime.icons.IconPack
import de.pfaffenrodt.workingtime.icons.Logo

@Composable
fun App() {
    MyApplicationTheme {
        var route by remember { mutableStateOf("empty") }
        when(route) {
            "empty" -> EmptyYearPage { route = "create" }
            "create" -> Text("create")
        }
    }
}


@Composable
fun EmptyYearPage( start: () -> Unit) {
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
                onClick = { start() },
                backgroundColor = MaterialTheme.colors.primary,
                content = {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            )
        }
    }
}