package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.pfaffenrodt.workingtime.icons.IconPack

@Composable
fun EditButton(
    modifier: Modifier = Modifier,
    onEdit: () -> Unit
) {
    IconButton(
        IconPack.Edit,
        "Bearbeiten",
        modifier,
        onEdit
    )
}