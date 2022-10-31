package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onEdit: () -> Unit
) {
    IconButton(
        IconPack.Close,
        "Schließen",
        modifier,
        onEdit
    )
}