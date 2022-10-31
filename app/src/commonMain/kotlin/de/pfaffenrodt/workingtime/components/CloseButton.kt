package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.pfaffenrodt.workingtime.Strings
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    boundedIndication: Boolean = false,
    onClick: () -> Unit
) {
    IconButton(
        IconPack.Close,
        Strings.close,
        modifier,
        boundedIndication,
        onClick
    )
}