package com.example.core_ui.topBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.google.android.material.floatingactionbutton.FloatingActionButton

data class AppBarState(
    val title: String = "",
    val showIconBack: Boolean = true,
    val actions: (@Composable RowScope.() -> Unit)? = null
)

data class AppState(
    val appBarState: AppBarState = AppBarState(),
    val fab: @Composable ()->Unit = {}
)
