package de.pfaffenrodt.workingtime

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import de.pfaffenrodt.workingtime.pages.AddDay
import de.pfaffenrodt.workingtime.pages.AddMonth
import de.pfaffenrodt.workingtime.pages.DayOverview
import de.pfaffenrodt.workingtime.pages.EditMonth
import de.pfaffenrodt.workingtime.pages.MonthOverview
import de.pfaffenrodt.workingtime.pages.YearOverview

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
        is Root.Child.YearOverview -> YearOverview(activeComponent)
        is Root.Child.AddMonth -> AddMonth(activeComponent)
        is Root.Child.EditMonth -> EditMonth(activeComponent)
        is Root.Child.MonthOverview -> MonthOverview(activeComponent)
        is Root.Child.AddDay -> AddDay(activeComponent)
        is Root.Child.DayOverview -> DayOverview(activeComponent)
    }
}
