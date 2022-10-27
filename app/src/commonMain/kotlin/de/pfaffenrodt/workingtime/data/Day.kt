package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.soywiz.klock.DateTime
import kotlinx.parcelize.Parcelize

@Parcelize
data class Day(
    val day: Int,
    val month: Int,
    val year: Int,
): Parcelable {

    companion object {
        fun now(): Day {
            val now = DateTime.now()
            return Day(
                day = now.dayOfMonth,
                month = now.month1,
                year = now.yearInt,
            )
        }
    }

}
