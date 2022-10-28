package de.pfaffenrodt.workingtime.data

import de.pfaffenrodt.workingtime.data.repositories.DayRepository
import de.pfaffenrodt.workingtime.data.repositories.MonthRepository

interface DataComponent {
    val dayRepository: DayRepository
    val monthRepository: MonthRepository
}