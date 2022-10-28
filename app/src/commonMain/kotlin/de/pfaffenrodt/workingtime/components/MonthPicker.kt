package de.pfaffenrodt.workingtime.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.soywiz.klock.DateTime
import com.soywiz.klock.MonthSpan

@Composable
fun MonthPicker(
    value: DateTime,
    modifier: Modifier = Modifier,
    onChange: (newValue: DateTime) -> Unit
)
{
    Row(modifier = modifier) {
        IconButton(
            Icons.Filled.KeyboardArrowLeft,
        "Monat zurück",
        ) {
            onChange(value.minus(MonthSpan(1)))
        }
        Text(
            value.format("MMMM"),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
                .align(Alignment.CenterVertically)
        )
        IconButton(
            Icons.Default.KeyboardArrowRight,
        "nächster Monat",
        ) {
            onChange(value.minus(MonthSpan(1)))
        }
    }
}