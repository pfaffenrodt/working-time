package de.pfaffenrodt.workingtime

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.soywiz.klock.DateTime
import de.pfaffenrodt.workingtime.data.DataComponent
import de.pfaffenrodt.workingtime.data.DateFormat
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.data.Month
import de.pfaffenrodt.workingtime.data.database.toDb
import kotlinx.parcelize.Parcelize

interface Root {
    val childStack: Value<ChildStack<*, Child>>
    val data: DataComponent

    sealed interface Child {
        class YearOverview(
            private val root: Root,
        ): Child {
            fun onAddMonth() {
                root.onAddMonth()
            }

            fun items(): List<Month> {
                return root.data.monthRepository.index()
            }

            fun onOpenMonth(month: Month) {
                root.onOpenMonth(month)
            }
        }

        class MonthOverview(
            private val root: Root,
            val month: Month
            ): Child {

            fun onBack() {
                root.onBack()
            }

            fun onAddDay() {
                root.onAddDay(month)
            }

            fun editMonth() {
                root.onEditMonth(month)
            }

            fun items(): List<Day> {
                return root.data.dayRepository.index(month)
            }

            fun onOpenDay(day: Day) {
                root.onOpenDay(day)
            }
        }
        class AddMonth(private val root: Root): Child {

            fun onBack() {
                root.onBack()
            }

            fun store(month: Month) {
                if (root.data.monthRepository.get(month.date) != null) {
                    // TODO show error entry already given
                    return
                }
                root.data.monthRepository.store(month)
                root.onStoredMonth(month)
            }
        }
        class AddDay(
            private val root: Root,
            val month: Month
        ): Child {
            fun onBack() {
                root.onBack()
            }

            fun store(day: Day) {
                val existingDay = root.data.dayRepository.get(day.date)
                if (existingDay != null) {
                    // TODO show error entry already given
                    return
                }
                root.data.dayRepository.store(day)
                root.onStoredDay(day)
            }
        }
        class EditMonth(
            private val root: Root,
            val month: Month
        ): Child {
            fun onBack() {
                root.onBack()
            }

            fun store(month: Month) {
                root.data.monthRepository.update(month)
                root.onUpdatedMonth(month)
            }
        }
        class DayOverview(
            private val root: Root,
            val day: Day,
        ): Child {
            fun onBack() {
                root.onBack()
            }

            fun store(time: DateTime) {
                val newTime = day.date.copyDayOfMonth(hours = time.hours, minutes = time.minutes)
                val newTimesList = day.times.toMutableList()
                newTimesList.add(newTime)
                newTimesList.sortBy { it.unixMillis }
                val newDay = day.copy(times = newTimesList)
                root.data.dayRepository.update(newDay)

                root.onStoredDay(root.data.dayRepository.get(newDay.date)!!)
            }

            fun onEditNote(newNode: String) {
                val newDay = day.copy(note = newNode)
                root.data.dayRepository.update(newDay)
                root.onStoredDay(newDay)
            }
        }
    }

    fun onBack()
    fun onAddMonth()
    fun onOpenMonth(month: Month)
    fun onStoredMonth(month: Month)
    fun onUpdatedMonth(month: Month)
    fun onEditMonth(month: Month)
    fun onAddDay(month: Month)
    fun onOpenDay(day: Day)
    fun onStoredDay(day: Day)
}

class RootComponent(
    componentContext: ComponentContext,
    override val data: DataComponent,
): Root, ComponentContext by componentContext {

    init {
        DateFormat.init()
    }

    private val navigation = StackNavigation<Config>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.YearOverview,
            handleBackButton = true,
            childFactory = ::createPage,
        )
    override val childStack: Value<ChildStack<*, Root.Child>> = stack

    private fun createPage(config: Config, componentContext: ComponentContext): Root.Child {
        return when(config) {
            is Config.YearOverview -> Root.Child.YearOverview(this)
            is Config.MonthOverview -> Root.Child.MonthOverview(this, config.month)
            is Config.DayOverview -> Root.Child.DayOverview(this, config.day)
            is Config.AddMonth -> Root.Child.AddMonth(this)
            is Config.EditMonth -> Root.Child.EditMonth(this, config.month)
            is Config.AddDay -> Root.Child.AddDay(this, config.month)
        }
    }

    override fun onBack() {
        navigation.pop()
    }

    override fun onAddMonth() {
        navigation.bringToFront(Config.AddMonth)
    }

    override fun onOpenMonth(month: Month) {
        navigation.bringToFront(Config.MonthOverview(month))
    }

    override fun onStoredMonth(month: Month) {
        navigation.replaceCurrent(Config.MonthOverview(month))
    }

    override fun onEditMonth(month: Month) {
        navigation.bringToFront(Config.EditMonth(month))
    }

    override fun onUpdatedMonth(month: Month) {
        navigation.pop()
        navigation.replaceCurrent(Config.MonthOverview(month))
    }

    override fun onAddDay(month: Month) {
        navigation.bringToFront(Config.AddDay(month))
    }

    override fun onOpenDay(day: Day) {
        navigation.bringToFront(Config.DayOverview(day))
    }

    override fun onStoredDay(day: Day) {
        navigation.replaceCurrent(Config.DayOverview(day))
    }

    private sealed interface Config : Parcelable {
        @Parcelize
        object YearOverview: Config
        @Parcelize
        class MonthOverview(val month: Month): Config
        @Parcelize
        object AddMonth: Config
        @Parcelize
        class EditMonth(val month: Month): Config
        @Parcelize
        class AddDay(val month: Month): Config
        @Parcelize
        class DayOverview(val day: Day): Config
    }
}