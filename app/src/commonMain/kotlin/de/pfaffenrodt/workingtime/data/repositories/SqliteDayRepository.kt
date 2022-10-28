package de.pfaffenrodt.workingtime.data.repositories

import com.soywiz.klock.DateTime
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.data.database.Database
import de.pfaffenrodt.workingtime.data.database.toData
import de.pfaffenrodt.workingtime.data.database.toDataOrNull
import de.pfaffenrodt.workingtime.data.database.toDb

class SqliteDayRepository(
    val database: Database
): DayRepository {
    override fun index(month: Month): List<Day> {
        return database.dayQueries
            .selectLikeDate(month.format + "%")
            .executeAsList()
            .map {
                it.toData()
            }
    }

    override fun get(date: DateTime): Day? {
        return database.dayQueries.selectByDate(date)
            .executeAsOneOrNull()
            .toDataOrNull()
    }

    override fun store(day: Day) {
        database.dayQueries.insert(day.toDb())
    }

    override fun update(day: Day) {
        TODO("Not yet implemented")
    }
}