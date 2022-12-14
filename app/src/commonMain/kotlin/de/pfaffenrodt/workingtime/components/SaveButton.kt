package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    boundedIndication: Boolean = false,
    onEdit: () -> Unit
) {
    IconButton(
        IconPack.Save,
        "Speichern",
        modifier,
        boundedIndication,
        onEdit
    )
}