package com.example.life

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.TaskScreens
import com.example.core_ui.topBar.AppState
import com.example.feature_tasks.ui.create.CreateTask
import com.example.feature_tasks.ui.list.TaskListScreen

fun NavGraphBuilder.globalGraph(
    context: Context,
    navController: NavController,
    onAppState: (AppState) -> Unit
) {

    composable(TaskScreens.list) {
        TaskListScreen(
            onComposing = {
                onAppState(it)
            },
            navController = navController
        )
    }
    composable(TaskScreens.create)
    {
        CreateTask(
            onComposing = {
                onAppState(it)
            },
            navController = navController
        )
    }
}