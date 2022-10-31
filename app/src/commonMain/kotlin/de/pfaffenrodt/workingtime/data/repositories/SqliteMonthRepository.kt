package de.pfaffenrodt.workingtime.data.repositories

import com.soywiz.klock.DateTime
import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.data.database.Database
import de.pfaffenrodt.workingtime.data.database.toData
import de.pfaffenrodt.workingtime.data.database.toDataOrNull
import de.pfaffenrodt.workingtime.data.database.toDb

class SqliteMonthRepository(
    val database: Database
): MonthRepository {
    override fun index(): List<Month> {
        return database.monthQueries
            .selectAll()
            .executeAsList()
            .map {
                it.toData()
            }
    }

    override fun get(date: DateTime): Month? {
        return database.monthQueries.selectByDate(date)
            .executeAsOneOrNull()
            .toDataOrNull()
    }

    override fun store(month: Month) {
        database.monthQueries.insert(month.toDb())
    }

    override fun update(month: Month) {
        database.monthQueries.update(month.toDb())
    }
}