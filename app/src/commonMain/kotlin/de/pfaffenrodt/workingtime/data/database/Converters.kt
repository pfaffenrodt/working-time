package de.pfaffenrodt.workingtime.data.database

import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.data.Day

fun Month.toDb(): de.pfaffenrodt.workingtime.data.database.Month
{
    return de.pfaffenrodt.workingtime.data.database.Month(
        date = date,
        target_hours = targetHours,
        last_month_hours_transfer = lastMonthHoursTransfer,
    )
}

fun de.pfaffenrodt.workingtime.data.database.Month?.toDataOrNull(): Month?
{
    if (this == null) {
        return null
    }
    return toData()
}

fun de.pfaffenrodt.workingtime.data.database.Month.toData(): Month
{
    return Month(
        date = date,
        targetHours = target_hours,
        lastMonthHoursTransfer = last_month_hours_transfer,
    )
}

fun Day.toDb(): de.pfaffenrodt.workingtime.data.database.Day
{
    return de.pfaffenrodt.workingtime.data.database.Day(
        date = date,
        note = note,
    )
}

fun de.pfaffenrodt.workingtime.data.database.Day?.toDataOrNull(): Day?
{
    if (this == null) {
        return null
    }
    return toData()
}

fun de.pfaffenrodt.workingtime.data.database.Day.toData(): Day
{
    return Day(
        date = date,
        note = note,
    )
}