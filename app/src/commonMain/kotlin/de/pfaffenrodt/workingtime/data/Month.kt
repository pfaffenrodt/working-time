package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.soywiz.klock.DateTime
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.TimeSpan
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Month(
    val date: DateTime,
    val targetHours: String? = null,
    val lastMonthHoursTransfer: String? = null,
): Parcelable {
    @IgnoredOnParcel
    val targetHoursBigDecimal = targetHours.bd()
    @IgnoredOnParcel
    val lastMonthHoursTransferBigDecimal = targetHours.bd()

    companion object {
        fun now(): Month {
            return Month(
                date = DateTime.now().startOfMonth,
            )
        }
    }

    val format: String get() = DateFormat.MONTH.format(this.date.localUnadjusted)
    val displayFormat: String get() = DateFormat.MONTH_DISPLAY.format(this.date.localUnadjusted)
}