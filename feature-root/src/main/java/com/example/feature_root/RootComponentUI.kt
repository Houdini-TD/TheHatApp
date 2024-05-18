package com.example.feature_root

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme
import com.example.feature_calculator.presentation.EventFlowUI
import com.example.feature_feed.FeedFlowUI
import com.example.feature_home.HomeComponentUI
import com.example.feature_home.main_screen.FakeMainScreen
import com.example.feature_home.main_screen.MainScreenUI

@Composable
fun RootComponentUI(component: IRootComponent) {

    val childStack by component.childStack.collectAsState()
    val bottomBarTabs = IRootComponent.MainNavTab.bottomBarTabs

    val activeInstance = childStack.active.instance
    val activeTab = remember(activeInstance) {
        when (activeInstance) {
            is IRootComponent.Child.HomeChild -> IRootComponent.MainNavTab.Home
            is IRootComponent.Child.FeedChild -> IRootComponent.MainNavTab.Feed
            is IRootComponent.Child.EventChild -> IRootComponent.MainNavTab.Event
        }
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                component::onTabClicked,
                bottomBarTabs,
                activeTab
            )
        },
        floatingActionButton = { NewEventFloatingButton(
            component::onNewEventClicked,
            activeTab == IRootComponent.MainNavTab.Event,
            true
        ) },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = Color.Transparent
    ) {
        Surface(
            modifier = Modifier.padding(it),
            color = Color.Transparent
        ) {
            Children(
                stack = childStack,
                animation = stackAnimation(fade() + scale())
            ) {
                when (val child = it.instance) {
                    is IRootComponent.Child.HomeChild -> HomeComponentUI(child.component)
                    is IRootComponent.Child.FeedChild -> FeedFlowUI(child.component)
                    is IRootComponent.Child.EventChild -> EventFlowUI(child.component)
                }
            }
        }
    }
}

@Composable
fun NewEventFloatingButton(
    onClick: () -> Unit,
    isTabActive: Boolean,
    isEventExists: Boolean
) {
    Box() {
        FloatingActionButton(
            onClick = { onClick() },
            modifier = Modifier                 //Я в курсе что гугл рекомендует
                .align(Alignment.Center)       //помещать FAB в BottomBar, но мне
                .offset(y = 70.dp),             //так не нравится
            containerColor = CustomTheme.colors.overlay.accent
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp),
                color = CustomTheme.colors.text.inverted,
                style = if (!isTabActive)
                    CustomTheme.typography.title.h2
                else
                    CustomTheme.typography.title.h1,
                text = if (isEventExists) "СОБЫТИE" else "НОВОЕ СОБЫТИЕ"
            )
        }
    }
}

@Composable
fun BottomBar(
    onTabSelected: (tab: IRootComponent.MainNavTab) -> Unit,
    tabs: List<IRootComponent.MainNavTab>,
    activeTab: IRootComponent.MainNavTab
) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        containerColor = CustomTheme.colors.overlay.primary,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed {index, tab ->
                if (tab.icon != null){
                    BottomBarButton(
                        tab.icon,
                        { onTabSelected(tab) },
                        selected = tab == activeTab
                    )

                    if (index < tabs.size - 1){
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBarButton(
    image: ImageVector,
    onClick: () -> Unit,
    selected: Boolean
) {
    val size = if (selected) 55.dp else 40.dp
    val color = if (selected) Color(0x79414141) else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
            .animateContentSize(),
        contentAlignment = Alignment.Center,
    ){
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = color)
                .size(size)
        ) {
            IconButton(
                modifier = Modifier.fillMaxSize(),
                onClick = { onClick()}
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp),
                    imageVector = image,
                    contentDescription = "",
                    tint = CustomTheme.colors.icon.primary
                )
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun BottomBarPreview() {
    AppTheme {
        Scaffold(
            bottomBar = { BottomBar(
                {},
                IRootComponent.MainNavTab.tabs,
                IRootComponent.MainNavTab.Home
            ) },
            floatingActionButton = { NewEventFloatingButton({}, true, true) },
            floatingActionButtonPosition = FabPosition.Center,
            containerColor = Color.Transparent
        ) {
            Surface(
                modifier = Modifier.padding(it),
                color = CustomTheme.colors.background.screen
            ) {
                MainScreenUI(component = FakeMainScreen())
            }
        }
    }
}
