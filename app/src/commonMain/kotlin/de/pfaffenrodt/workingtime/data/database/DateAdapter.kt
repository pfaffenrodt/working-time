package de.pfaffenrodt.workingtime.data.database

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import com.squareup.sqldelight.ColumnAdapter

val dateTimeAdapter = object : ColumnAdapter<DateTime, String> {

    val format = DateFormat("yyyy-MM-dd")

    override fun decode(databaseValue: String) = format.tryParse(databaseValue, true)!!.local

    override fun encode(value: DateTime) = format.format(value.localUnadjusted)
}
val monthAdapter = object : ColumnAdapter<DateTime, String> {

    val format = DateFormat("yyyy-MM")

    override fun decode(databaseValue: String) = format.tryParse(databaseValue, true)!!.local

    override fun encode(value: DateTime) = format.format(value.localUnadjusted)
}


val listOfDateTimeAdapter = object : ColumnAdapter<List<DateTime>, String> {
    private val delimiter = ";"
    private val format = DateFormat.FORMAT1

    override fun decode(databaseValue: String): List<DateTime> {
        if (databaseValue.isBlank()) {
            return emptyList()
        }

        val list = databaseValue.split(delimiter)
        return list.map {
            format.tryParse(it, true)!!.local
        }
    }

    override fun encode(value: List<DateTime>): String {
        val encoded = value.joinToString(delimiter) { format.format(it.localUnadjusted) }
        return encoded
    }
}