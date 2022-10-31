package de.pfaffenrodt.workingtime.data.database

import com.squareup.sqldelight.db.SqlDriver

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): Database {
    val driver = driverFactory.createDriver()
    val database = Database(driver,
        Day.Adapter(
            dateAdapter = dateTimeAdapter,
            timesAdapter = listOfDateTimeAdapter
        ),
        Month.Adapter(dateAdapter = monthAdapter),
    )

    return database
}
