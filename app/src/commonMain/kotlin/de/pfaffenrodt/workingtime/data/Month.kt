package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.soywiz.klock.DateTime
import kotlinx.parcelize.Parcelize

@Parcelize
data class Month(
    val month: Int,
    val year: Int,
    val targetHours: String? = null,
    val lastMonthHoursTransfer: String? = null,
): Parcelable {
    val targetHoursBigDecimal = targetHours.bd()
    val lastMonthHoursTransferBigDecimal = targetHours.bd()

    companion object {
        fun now(): Month {
            val now = DateTime.now()
            return Month(
                month = now.month1,
                year = now.yearInt,
            )
        }
    }

}

fun String?.bd(): BigDecimal {
    if (this == null) {
        return BigDecimal.ZERO
    }

    return BigDecimal.parseString(this.replace(',', '.'))
}

fun String?.toString(): String {
    if (this == null) {
        return ""
    }
    return this
}