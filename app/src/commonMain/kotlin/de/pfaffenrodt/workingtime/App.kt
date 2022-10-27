package de.pfaffenrodt.workingtime

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun App(root: RootComponent) {
    MyApplicationTheme {
        Surface(color = MaterialTheme.colors.background) {
            RootContent(root)
        }
    }
}


@Composable
fun RootContent(root: Root)
{
    val childStack by root.childStack.subscribeAsState()
    when(val activeComponent = childStack.active.instance) {
        is Root.Child.YearOverview -> YearOverview(root::onAddMonth)
        is Root.Child.AddMonth -> AddMonth(activeComponent)
        is Root.Child.MonthOverview -> MonthOverview(activeComponent)
        is Root.Child.AddDay -> AddDay(activeComponent)
        is Root.Child.DayOverview -> DayOverview(activeComponent)
    }
}
