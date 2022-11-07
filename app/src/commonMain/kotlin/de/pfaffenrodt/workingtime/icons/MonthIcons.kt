package de.pfaffenrodt.workingtime.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AcUnit
import androidx.compose.material.icons.sharp.CrueltyFree
import androidx.compose.material.icons.sharp.Egg
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.LocalFlorist
import androidx.compose.material.icons.sharp.Pool
import androidx.compose.material.icons.sharp.Surfing
import androidx.compose.ui.graphics.vector.ImageVector

object MonthIcons {
    val January = Icons.Sharp.AcUnit
    val February = Icons.Sharp.Favorite
    val March = Icons.Sharp.CrueltyFree
    val April = Icons.Sharp.Egg
    val May = Icons.Sharp.LocalFlorist
    val June = Icons.Sharp.Pool
    val July = Icons.Sharp.Surfing
    val August = IconPack.Sunflower
    val September = IconPack.Pear
    val October = IconPack.HalloweenPumpkin
    val November = IconPack.AutumnLeaf
    val December = IconPack.ChristmasTree
}

fun Int.monthIcon(): ImageVector {
    return when (this) {
        1 -> MonthIcons.January
        2 -> MonthIcons.February
        3 -> MonthIcons.March
        4 -> MonthIcons.April
        5 -> MonthIcons.May
        6 -> MonthIcons.June
        7 -> MonthIcons.July
        8 -> MonthIcons.August
        9 -> MonthIcons.September
        10 -> MonthIcons.October
        11 -> MonthIcons.November
        12 -> MonthIcons.December
        else -> MonthIcons.January
    }
}