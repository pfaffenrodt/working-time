package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    boundedIndication: Boolean = false,
    onBack: () -> Unit
) {
    IconButton(
        IconPack.Back,
        "Zurück",
        modifier,
        boundedIndication,
        onBack,
    )
}