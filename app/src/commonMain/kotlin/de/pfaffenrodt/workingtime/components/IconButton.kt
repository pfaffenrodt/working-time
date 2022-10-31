package de.pfaffenrodt.workingtime.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    boundedIndication: Boolean = false,
    action: () -> Unit
) {
    Icon(
        imageVector,
        contentDescription,
        modifier = modifier.size(48.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = boundedIndication),
                onClick = action
            )
            .padding(8.dp)
    )
}