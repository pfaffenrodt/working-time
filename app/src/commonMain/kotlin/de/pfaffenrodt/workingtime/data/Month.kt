package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.soywiz.klock.DateTime
import com.soywiz.klock.TimeSpan
import com.soywiz.klock.hours
import com.soywiz.klock.minutes
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Month(
    val date: DateTime,
    val targetHours: String? = null,
    val lastMonthHoursTransfer: String? = null,
): Parcelable {
    @IgnoredOnParcel
    val targetHoursTimeSpan = targetHours.toTimeSpan()
    @IgnoredOnParcel
    val lastMonthHoursTransferTimeSpan = lastMonthHoursTransfer.toTimeSpan()

    companion object {
        fun now(): Month {
            return Month(
                date = DateTime.now().startOfMonth,
            )
        }
    }

    val format: String get() = DateFormat.MONTH.format(this.date.localUnadjusted)
    val displayFormat: String get() = DateFormat.MONTH_DISPLAY.format(this.date.localUnadjusted)
}

fun String?.toTimeSpan(): TimeSpan {
    if (this == null) {
        return TimeSpan(0.0)
    }
    var sign: String
    var hours: String
    var minutes: String

    val normalized = this.removeSuffix(":")
    if (normalized.contains(":")) {
        val timeRangeRegex = """^(-?)?(\d{1,3}?)?:(\d{1,3})?$""".toRegex()
        if (!this.matches(timeRangeRegex)) {
            throw IllegalArgumentException("invalid time span")
        }
        val (matchSign, matchHours, matchMinutes) = timeRangeRegex.find(this)!!.destructured
        sign = matchSign
        hours = matchHours
        minutes = matchMinutes
    } else {
        val timeRangeRegex = """^(-?)?(\d{1,3}?)?$""".toRegex()
        if (!normalized.matches(timeRangeRegex)) {
            throw IllegalArgumentException("invalid time span")
        }
        val (matchSign, matchHours) = timeRangeRegex.find(normalized)!!.destructured
        sign = matchSign
        hours = matchHours
        minutes = "00"
    }

    return "$sign$hours".toDouble().hours + "$sign$minutes".toDouble().minutes
}