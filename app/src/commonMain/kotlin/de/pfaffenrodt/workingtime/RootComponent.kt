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
import de.pfaffenrodt.workingtime.data.DataComponent
import de.pfaffenrodt.workingtime.data.DateFormat
import de.pfaffenrodt.workingtime.data.Day
import de.pfaffenrodt.workingtime.data.Month
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
                root.onAddDay()
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
        class AddDay(private val root: Root): Child {
            fun onBack() {
                root.onBack()
            }

            fun store(day: Day) {
                if (root.data.dayRepository.get(day.date) != null) {
                    // TODO show error entry already given
                    return
                }
                root.data.dayRepository.store(day)
                root.onStoredDay(day)
            }
        }
        class DayOverview(
            private val root: Root,
            val day: Day,
        ): Child {
            fun onBack() {
                root.onBack()
            }
        }
    }

    fun onBack()
    fun onAddMonth()
    fun onOpenMonth(month: Month)
    fun onStoredMonth(month: Month)
    fun onEditMonth(month: Month)
    fun onAddDay()
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
            is Config.AddDay -> Root.Child.AddDay(this)
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
        TODO("Not yet implemented")
    }

    override fun onAddDay() {
        navigation.bringToFront(Config.AddDay)
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
        object AddDay: Config
        @Parcelize
        class DayOverview(val day: Day): Config
    }
}