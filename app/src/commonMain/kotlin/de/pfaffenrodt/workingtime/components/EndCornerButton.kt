package de.pfaffenrodt.workingtime.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


val EndCornerButtonShape = RoundedCornerShape(topStart = 4.dp)
@Composable
fun Modifier.endCornerButton(): Modifier {
    return this
        .background(MaterialTheme.colors.primary, EndCornerButtonShape)
}