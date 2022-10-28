package de.pfaffenrodt.workingtime.data

sealed interface DateFormat {
    companion object {
        val MONTH = com.soywiz.klock.DateFormat("yyyy-MM")
        val DAY = com.soywiz.klock.DateFormat("yyyy-MM-dd")
    }
}