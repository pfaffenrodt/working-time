package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    IconButton(
        IconPack.Back,
        "Zurück",
        modifier,
        onBack
    )
}