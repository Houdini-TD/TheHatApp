package com.example.thehatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.example.core.theme.AppTheme
import com.example.feature_root.RootComponentUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = DaggerMainDaggerComponent.create().rootComponentFactory(defaultComponentContext())


        setContent {
            AppTheme {
                RootComponentUI(rootComponent)
            }
        }
    }
}
