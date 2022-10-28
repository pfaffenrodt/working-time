package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.components.Toolbar

@Composable
fun DayOverview(component: Root.Child.DayOverview)
{
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar(
            onBack = component::onBack,
        ) {
            Text(component.day.fullDisplayFormat)
            Text(Strings.dayView, modifier = Modifier.alpha(0.6f))
        }
    }
}