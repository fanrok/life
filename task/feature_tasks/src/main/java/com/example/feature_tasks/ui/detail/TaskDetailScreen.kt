package com.example.feature_tasks.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.example.core_navigation.base.TaskDetailScreenRoute
import com.example.core_ui.topBar.AppBarState
import com.example.core_ui.topBar.AppState

@Composable
fun TaskDetailScreen(
    onComposing: (AppState) -> Unit,
    navController: NavController,
) {
    val context = LocalContext.current
    val savedStateHandle = SavedStateHandle()
    val taskId = savedStateHandle.get<String>(TaskDetailScreenRoute.TASK_ID)
    LaunchedEffect(key1 = true) {
        onComposing(
            AppState(
                AppBarState(
                    title = "Detail Task",
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = null
                            )
                        }
                    }
                ), {}
            )
        )
    }
    DetailTask(taskId)
}

@Composable
fun DetailTask(taskId: String?) {
    Column {
        Row {
            Text("Название задачи")
        }
        Row {
            Text(taskId?:"no")
        }
    }
}