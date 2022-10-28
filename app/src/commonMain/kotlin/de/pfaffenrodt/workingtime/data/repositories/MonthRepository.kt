package de.pfaffenrodt.workingtime.data.repositories

import com.soywiz.klock.DateTime
import de.pfaffenrodt.workingtime.data.Month

interface MonthRepository {
    fun index(): List<Month>
    fun get(date: DateTime): Month?
    fun store(month: Month)
    fun update(month: Month)
}