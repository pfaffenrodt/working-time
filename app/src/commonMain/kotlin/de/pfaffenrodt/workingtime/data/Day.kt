package de.pfaffenrodt.workingtime.data

import com.arkivanov.essenty.parcelable.Parcelable
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.soywiz.klock.DateTime
import com.soywiz.klock.DateTimeTz
import kotlinx.parcelize.Parcelize

@Parcelize
data class Day(
    val date: DateTime,
    val note: String? = null,
): Parcelable {

    companion object {
        fun now(): Day {
            val now = DateTime.now().startOfDay

            return Day(
                date = now,
            )
        }
    }

    val format: String get() = DateFormat.DAY.format(date.localUnadjusted)
    val fullDisplayFormat: String get() = DateFormat.DAY_DISPLAY.format(date.localUnadjusted)
}
