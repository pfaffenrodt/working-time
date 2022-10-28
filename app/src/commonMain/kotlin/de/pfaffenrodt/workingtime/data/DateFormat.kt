package de.pfaffenrodt.workingtime.data

import com.soywiz.klock.KlockLocale
import com.soywiz.klock.locale.german

sealed interface DateFormat {
    companion object {
        val MONTH = com.soywiz.klock.DateFormat("yyyy-MM")
        val MONTH_DISPLAY = com.soywiz.klock.DateFormat("yyyy - MMMM")
        val DAY = com.soywiz.klock.DateFormat("yyyy-MM-dd")
        val DAY_DISPLAY = com.soywiz.klock.DateFormat("dd. MMMM yyyy")

        fun init() {
            KlockLocale.default = KlockLocale.german
        }
    }

}