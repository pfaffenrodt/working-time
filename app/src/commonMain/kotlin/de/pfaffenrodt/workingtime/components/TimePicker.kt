package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.soywiz.klock.DateTime


@Composable
expect fun TimePicker(
    value: DateTime,
    modifier: Modifier = Modifier,
    onChange: (newValue: DateTime) -> Unit
)