package com.example.feature_root

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.example.core.theme.AppTheme
import com.example.core.theme.custom.CustomTheme
import com.example.feature_feed.FeedFlowUI
import com.example.feature_home.HomeComponentUI

@Composable
fun RootComponentUI(component: IRootComponent) {

    val childStack by component.childStack.collectAsState()

    Scaffold(
        bottomBar = { BottomBar(
            component::onHomeTabSelected,
            component::onFeedTabSelected
        )},
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
                when (val child = it.instance){
                    is IRootComponent.Child.HomeChild -> HomeComponentUI(child.component)
                    is IRootComponent.Child.FeedChild -> FeedFlowUI(child.component)
                }
            }
        }
    }
}

@Composable
fun BottomBar(
        onMainTabSelected: () -> Unit,
        onFeedTabSelected: () -> Unit
    ){
    BottomAppBar(
        containerColor = CustomTheme.colors.overlay.primary,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            NavigationBarItem(
                selected = false,
                onClick = { onMainTabSelected() },
                icon = { Icons.Default.Home },
                label = {
                    Text(
                        text = "ГЛАВНАЯ",
                        style = CustomTheme.typography.title.h3,
                        color = CustomTheme.colors.text.inverted
                    )
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            NavigationBarItem(
                selected = false,
                onClick = { onFeedTabSelected() },
                icon = { Icons.Default.Home },
                label = {
                    Text(
                        text = "НОВОСТИ",
                        style = CustomTheme.typography.title.h3,
                        color = CustomTheme.colors.text.inverted
                    )
                }
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun BottomBarPreview(){
    AppTheme {

    }
}
