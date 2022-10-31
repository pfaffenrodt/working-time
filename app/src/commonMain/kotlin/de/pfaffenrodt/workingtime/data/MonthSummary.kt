package de.pfaffenrodt.workingtime.data

import com.soywiz.klock.TimeSpan

class MonthSummary(
    month: Month,
    days: List<Day>,
) {

    val hoursValue = if (days.isEmpty()) TimeSpan(0.0) else days.map { it.hours }
        .reduce { acc, hours -> acc.plus(hours) }
    val hours = hoursValue
        .string()
    private val targetHoursTimeSpan = month.targetHoursTimeSpan
    val monthHoursDiff = (hoursValue - targetHoursTimeSpan).string()
    val transferHours = (hoursValue - targetHoursTimeSpan + month.lastMonthHoursTransferTimeSpan).string()
}