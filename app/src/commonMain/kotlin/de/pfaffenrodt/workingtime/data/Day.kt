package de.pfaffenrodt.workingtime.data

import androidx.compose.runtime.toMutableStateList
import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.RoundingMode
import com.soywiz.klock.DateTime
import com.soywiz.klock.DateTimeRange
import com.soywiz.klock.TimeSpan
import com.soywiz.klock.toTimeString
import com.soywiz.klock.until
import de.pfaffenrodt.workingtime.Strings
import kotlinx.parcelize.Parcelize

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
        .map {
            if (it.duration.hours < 6.0) {
                listOf(it)
            } else {
                // add break
                listOf(it, DateTimeRange(it.max - TimeSpan(-30.0*60*1000), it.max))
            }
        }.flatten()

    val summary: String
        get() = timeSpans.joinToString("\n") { it.shortString() }

    val hours: TimeSpan
            get() {
                val hours = timeSpans.map { it.duration }
                if (hours.isEmpty()) {
                    return TimeSpan(0.0)
                }

                return hours.reduce { acc, dateTimeRange -> acc.plus(dateTimeRange) }
            }
    
    val hoursSummary: String
        get() = hours.string()
}

fun DateTimeRange.string(): String {
    if (min == max) {
        return min.format(DateFormat.TIME) + " 0 h"
    }
    val duration = min.until(max).duration.string()
    return min.format(DateFormat.TIME) + " - " + max.format(DateFormat.TIME) + " $duration"
}

fun DateTimeRange.shortString(): String {
    if (min == max) {
        return min.format(DateFormat.TIME) + " 0 h"
    }
    val duration = min.until(max).duration.shortString()
    return min.format(DateFormat.TIME) + " - " + max.format(DateFormat.TIME) + " $duration"
}

fun TimeSpan.string(): String {
    if (minutes < 0) {
        return "$minutes min ${Strings.timeForBreak}"
    }

    val duration = BigDecimal
        .fromDouble(hours)
        .roundToDigitPositionAfterDecimalPoint(2, RoundingMode.ROUND_HALF_TOWARDS_ZERO)
        .toStringExpanded()
    val timeString = toTimeString().removeRange(5, 8)
    return "$timeString (${duration} h)"
}

fun TimeSpan.shortString(): String {
    if (minutes < 0) {
        return "$minutes min ${Strings.timeForBreak}"
    }

    return toTimeString().removeRange(5, 8)
}