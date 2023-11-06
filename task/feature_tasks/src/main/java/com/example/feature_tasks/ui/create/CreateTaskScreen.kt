package com.example.feature_tasks.ui.create

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.core_ui.topBar.AppBarState

@Composable
fun CreateTask(
    onComposing: (AppBarState) -> Unit,
    navController: NavController,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        onComposing(
            AppBarState(
                title = "Create Task",
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null
                        )
                    }
                }
            )
        )
    }
}