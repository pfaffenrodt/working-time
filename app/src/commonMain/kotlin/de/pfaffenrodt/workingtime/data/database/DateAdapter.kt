package de.pfaffenrodt.workingtime.data.database

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import com.squareup.sqldelight.ColumnAdapter

val listOfDateTimeAdapter = object : ColumnAdapter<DateTime, String> {

    val format = DateFormat("yyyy-MM-dd")

    override fun decode(databaseValue: String) = format.tryParse(databaseValue, true)!!.local

    override fun encode(value: DateTime) = format.format(value.localUnadjusted)
}
val listOfMonthAdapter = object : ColumnAdapter<DateTime, String> {

    val format = DateFormat("yyyy-MM")

    override fun decode(databaseValue: String) = format.tryParse(databaseValue, true)!!.local

    override fun encode(value: DateTime) = format.format(value.localUnadjusted)
}