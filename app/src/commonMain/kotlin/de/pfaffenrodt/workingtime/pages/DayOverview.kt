package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import de.pfaffenrodt.workingtime.Root

@Composable
fun DayOverview(component: Root.Child.DayOverview)
{
    Column {
        Text("day: ${component.day.format}")
    }
}