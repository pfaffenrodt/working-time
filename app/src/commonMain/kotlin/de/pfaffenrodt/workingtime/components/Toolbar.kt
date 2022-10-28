package de.pfaffenrodt.workingtime.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

typealias Action = () -> Unit

@Composable
fun Toolbar(
    onBack: Action? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (onBack != null) {
            BackButton(onBack = onBack)
        }
        Column(
            modifier = Modifier.weight(1f)
                .padding(vertical = 8.dp)
                .align(Alignment.CenterVertically),
        ) {
            content()
        }
    }
}