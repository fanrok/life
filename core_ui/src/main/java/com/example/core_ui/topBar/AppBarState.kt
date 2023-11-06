package com.example.core_ui.topBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

data class AppBarState(
    val title: String = "",
    val showIconBack: Boolean = true,
    val actions: (@Composable RowScope.() -> Unit)? = null
)
