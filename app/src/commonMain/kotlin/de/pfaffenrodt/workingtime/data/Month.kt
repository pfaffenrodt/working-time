package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.soywiz.klock.DateTime
import com.soywiz.klock.DateTimeTz
import kotlinx.parcelize.Parcelize

@Parcelize
data class Month(
    val date: DateTimeTz,
    val targetHours: String? = null,
    val lastMonthHoursTransfer: String? = null,
): Parcelable {
    val targetHoursBigDecimal = targetHours.bd()
    val lastMonthHoursTransferBigDecimal = targetHours.bd()

    constructor(day: de.pfaffenrodt.workingtime.data.database.Month):
        this(
            day.date,
            day.target_hours,
            day.last_month_hours_transfer
        )

    companion object {
        fun now(): Month {
            return Month(
                date = DateTime.nowLocal(),
            )
        }
    }

    val format: String get() = DateFormat.MONTH.format(this.date)
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