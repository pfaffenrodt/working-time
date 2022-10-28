package de.pfaffenrodt.workingtime.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import de.pfaffenrodt.workingtime.Root
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun DayOverview(component: Root.Child.DayOverview)
{
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                IconPack.Back,
                "Zurück",
                modifier = Modifier.size(48.dp)
                    .clickable {
                        component.onBack()
                    }
                    .padding(8.dp)
            )
            Column(
                modifier = Modifier.weight(1f).padding(vertical = 8.dp)
            ) {
                Text(component.day.fullDisplayFormat)
                Text(Strings.dayView, modifier = Modifier.alpha(0.6f))
            }
        }
    }
}