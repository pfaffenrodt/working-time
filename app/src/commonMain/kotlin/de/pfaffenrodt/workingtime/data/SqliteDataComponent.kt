package de.pfaffenrodt.workingtime.data

import de.pfaffenrodt.workingtime.data.database.Database
import de.pfaffenrodt.workingtime.data.repositories.DayRepository
import de.pfaffenrodt.workingtime.data.repositories.MonthRepository
import de.pfaffenrodt.workingtime.data.repositories.SqliteDayRepository
import de.pfaffenrodt.workingtime.data.repositories.SqliteMonthRepository

class SqliteDataComponent(database: Database): DataComponent {
    override val dayRepository: DayRepository = SqliteDayRepository(database)
    override val monthRepository: MonthRepository = SqliteMonthRepository(database)
}