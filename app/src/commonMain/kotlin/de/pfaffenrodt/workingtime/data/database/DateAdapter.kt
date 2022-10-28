package de.pfaffenrodt.workingtime.data.database

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTimeTz
import com.squareup.sqldelight.ColumnAdapter

val listOfDateTimeAdapter = object : ColumnAdapter<DateTimeTz, String> {

    val format = DateFormat.FORMAT2

    override fun decode(databaseValue: String) = format.tryParse(databaseValue, true)!!

    override fun encode(value: DateTimeTz) = format.format(value)
}
val listOfMonthAdapter = object : ColumnAdapter<DateTimeTz, String> {

    val format = DateFormat("yyyy-MM")

    override fun decode(databaseValue: String) = format.tryParse(databaseValue, true)!!

    override fun encode(value: DateTimeTz) = format.format(value)
}