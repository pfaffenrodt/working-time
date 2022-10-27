package de.pfaffenrodt.workingtime

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DayOverview(component: Root.Child.DayOverview)
{
    Column {
        Text("day: ${component.day.day}")
    }
}