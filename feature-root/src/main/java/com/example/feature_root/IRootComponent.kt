package com.example.feature_root

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.example.feature_calculator.presentation.IEventFlow
import com.example.feature_feed.IFeedFlow
import com.example.feature_home.IHomeComponent
import kotlinx.coroutines.flow.StateFlow


interface IRootComponent {

    val childStack: StateFlow<ChildStack<*, Child>>

    fun onNewEventClicked()
    fun onTabClicked(tab: MainNavTab)
    sealed interface Child {
        class HomeChild(val component: IHomeComponent): Child
        class FeedChild(val component: IFeedFlow): Child

        class EventChild(val component: IEventFlow): Child
    }

    sealed class MainNavTab(
        val title: String,
        val icon: ImageVector? = null
    ) {
        data object Home: MainNavTab("Главная", Icons.Default.Home)
        data object Feed: MainNavTab("Новости", Icons.Default.DateRange)
        data object Event: MainNavTab("Other")

        companion object{
            val bottomBarTabs = listOf(Home, Feed)

            val tabs = listOf(Home, Feed, Event)
        }
    }

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): IRootComponent
    }
}

