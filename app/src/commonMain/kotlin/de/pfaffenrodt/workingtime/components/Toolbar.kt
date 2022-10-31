package de.pfaffenrodt.workingtime.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

typealias Action = () -> Unit
typealias Actions = @Composable (RowScope.() -> Unit)

@Composable
fun Toolbar(
    onBack: Action,
    actions: Actions? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Toolbar(leadingActions = {
        BackButton(onBack = onBack)
    },
        content = content,
        tailingActions = actions
    )
}

@Composable
fun Toolbar(
    leadingActions: Actions? = null,
    tailingActions: Actions? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (leadingActions != null) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
            ) {
                leadingActions()
            }
        }
        Column(
            modifier = Modifier.weight(1f)
                .padding(vertical = 8.dp)
                .align(Alignment.CenterVertically),
        ) {
            content()
        }
        if (tailingActions != null) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp),
            ) {
                tailingActions()
            }
        }
    }
}