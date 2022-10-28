package de.pfaffenrodt.workingtime.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.soywiz.klock.DateTime


@Composable
expect fun DayPicker(
    value: DateTime,
    minDate: DateTime? = null,
    maxDate: DateTime? = null,
    modifier: Modifier = Modifier,
    onChange: (newValue: DateTime) -> Unit
)