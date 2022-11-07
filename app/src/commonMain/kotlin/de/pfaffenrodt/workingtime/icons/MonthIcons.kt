package de.pfaffenrodt.workingtime.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AcUnit
import androidx.compose.material.icons.outlined.CrueltyFree
import androidx.compose.material.icons.outlined.Egg
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.LocalFlorist
import androidx.compose.material.icons.outlined.Pool
import androidx.compose.material.icons.outlined.Surfing
import androidx.compose.ui.graphics.vector.ImageVector

object MonthIcons {
    val January = Icons.Outlined.AcUnit
    val February = Icons.Outlined.Favorite
    val March = Icons.Outlined.CrueltyFree
    val April = Icons.Outlined.Egg
    val May = Icons.Outlined.LocalFlorist
    val June = Icons.Outlined.Pool
    val July = Icons.Outlined.Surfing
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