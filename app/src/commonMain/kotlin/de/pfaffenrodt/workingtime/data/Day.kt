package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.RoundingMode
import com.soywiz.klock.DateTime
import com.soywiz.klock.DateTimeRange
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.TimeSpan
import com.soywiz.klock.toTimeString
import com.soywiz.klock.until
import kotlinx.parcelize.Parcelize
import kotlin.math.roundToInt

@Parcelize
data class Day(
    val date: DateTime,
    val note: String? = null,
    val times: List<DateTime> = listOf(),
): Parcelable {

    companion object {
        fun now(): Day {
            val now = DateTime.now().startOfDay

            return Day(
                date = now,
            )
        }
    }

    val format: String get() = DateFormat.DAY.format(date.localUnadjusted)
    val fullDisplayFormat: String get() = DateFormat.DAY_DISPLAY.format(date.localUnadjusted)

    val timeSpans: List<DateTimeRange> = times.chunked(2)
        .map { it[0].until(it.getOrNull(1) ?: it[0]) }

    val summary: String
        get() = date.dayOfMonth.toString() + ". " +timeSpans.joinToString(" ") { it.string() }

    val hours: TimeSpan
            get() = timeSpans.map { it.duration }
                .reduce { acc, dateTimeRange -> acc.plus(dateTimeRange) }
    
    val hoursSummary: String
        get() = hours.string()
}

fun DateTimeRange.string(): String {
    if (min == max) {
        return min.format(DateFormat.TIME)
    }
    return min.format(DateFormat.TIME) + " - " + max.format(DateFormat.TIME)
}

fun TimeSpan.string(): String {
    val duration = BigDecimal
        .fromDouble(hours)
        .roundToDigitPositionAfterDecimalPoint(2, RoundingMode.CEILING)
        .toString()
    val hours = hours.roundToInt()
    val onlyMinutes = minutes.roundToInt() - (hours * 60)
    val hoursPadded = if (hours < 10) "0$hours" else hours.toString()
    val minutesPadded = if (onlyMinutes == 0) "00" else if (onlyMinutes < 10) "0$onlyMinutes" else onlyMinutes.toString()
    return "${duration} h ($hoursPadded:$minutesPadded)"
}