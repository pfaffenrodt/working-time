package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.soywiz.klock.DateTime
import com.soywiz.klock.DateTimeTz
import kotlinx.parcelize.Parcelize

@Parcelize
data class Day(
    val date: DateTimeTz,
    val note: String? = null,
): Parcelable {

    constructor(day: de.pfaffenrodt.workingtime.data.database.Day): this(day.date, day.note)

    companion object {
        fun now(): Day {
            val now = DateTime.nowLocal()

            return Day(
                date = now,
            )
        }
    }

    val format: String get() = DateFormat.DAY.format(date)
}
