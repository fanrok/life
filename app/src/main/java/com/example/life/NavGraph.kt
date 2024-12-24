package com.example.life

import android.content.Context
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.base.TaskCreateScreenRoute
import com.example.core_navigation.base.TaskDetailScreenRoute
import com.example.core_navigation.base.TaskListScreenRoute
import com.example.core_ui.topBar.AppState
import com.example.feature_tasks.ui.create.CreateTask
import com.example.feature_tasks.ui.detail.TaskDetailScreen
import com.example.feature_tasks.ui.list.TaskListScreen

fun NavGraphBuilder.globalGraph(
    context: Context,
    navController: NavController,
    onAppState: (AppState) -> Unit
) {

    composable(TaskListScreenRoute.route) {
        TaskListScreen(
            onComposing = {
                onAppState(it)
            },
            navController = navController
        )
    }
    composable(TaskCreateScreenRoute.route)
    {
        CreateTask(
            onComposing = {
                onAppState(it)
            },
            navController = navController
        )
    }
    composable(TaskDetailScreenRoute.route)
    {
        TaskDetailScreen(
            onComposing = {
                onAppState(it)
            },
            navController = navController
        )
    }
}