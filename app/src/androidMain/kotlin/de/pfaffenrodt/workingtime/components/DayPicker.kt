package de.pfaffenrodt.workingtime.components

import android.icu.util.Calendar
import android.widget.CalendarView
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.soywiz.klock.DateTime


@Composable
actual fun DayPicker(
    value: DateTime,
    minDate: DateTime?,
    maxDate: DateTime?,
    modifier: Modifier,
    onChange: (newValue: DateTime) -> Unit)
{
    AndroidView(
        factory = {
                context -> CalendarView(context)
            .apply {
                setOnDateChangeListener { view, year, month, dayOfMonth ->
                    onChange(DateTime(year, month+1, dayOfMonth))
                }
                date = value.unixMillisLong
                minDate?.unixMillisLong?.let { value -> this.minDate = value }
                maxDate?.unixMillisLong?.let { value -> this.maxDate = value }
            }
        },
        modifier = modifier.fillMaxWidth().defaultMinSize(minHeight = 200.dp),
        update = {
            view ->
            val newValue = value.unixMillisLong
            if (view.date != newValue) {
                view.date = newValue
            }
            minDate?.unixMillisLong?.let { view.minDate = it }
            maxDate?.unixMillisLong?.let { view.maxDate = it }
        })
}
