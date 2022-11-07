package de.pfaffenrodt.workingtime.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
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
            modifier.background(MaterialTheme.colors.primary, CircleShape),
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
            modifier.background(MaterialTheme.colors.primary, CircleShape),
        ) {
            onChange(value.plus(MonthSpan(1)))
        }
    }
}