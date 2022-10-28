package de.pfaffenrodt.workingtime.components

import android.widget.TimePicker
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.soywiz.klock.DateTime


@Composable
actual fun TimePicker(
    value: DateTime,
    modifier: Modifier,
    onChange: (newValue: DateTime) -> Unit
) {
    AndroidView(
        factory = {
                context -> TimePicker(context)
            .apply {
                setIs24HourView(true)
                setOnTimeChangedListener { view, hourOfDay, minute ->
                    onChange(value.copyDayOfMonth(hours = hourOfDay, minutes = minute))
                }
                hour = value.hours
                minute = value.minutes
            }
        },
        modifier = modifier.fillMaxWidth().defaultMinSize(minHeight = 200.dp),
        update = {
                view ->
            val newValue = value.unixMillisLong
            view.hour = value.hours
            view.minute = value.minutes
        })
}