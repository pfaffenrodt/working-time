package de.pfaffenrodt.workingtime.data.repositories

import com.soywiz.klock.DateTime
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.data.Month

interface DayRepository {
    fun index(month: Month): List<Day>
    fun get(date: DateTime): Day?
    fun store(day: Day)
    fun update(day: Day)
}