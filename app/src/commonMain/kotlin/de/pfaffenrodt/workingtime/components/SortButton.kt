package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun SortButton(
    modifier: Modifier = Modifier,
    boundedIndication: Boolean = false,
    onAction: () -> Unit
) {
    IconButton(
        IconPack.Sort,
        "Sortieren",
        modifier,
        boundedIndication,
        onAction,
    )
}