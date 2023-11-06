package com.example.life

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.TaskScreens
import com.example.core_ui.topBar.AppBarState
import com.example.feature_tasks.ui.create.CreateTask
import com.example.feature_tasks.ui.list.TaskList

fun NavGraphBuilder.globalGraph(
    context: Context,
    navController: NavController,
    onAppBarState: (AppBarState) -> Unit
) {

    composable(TaskScreens.list) {
        TaskList(
            onComposing = {
                onAppBarState(it)
            },
            navController = navController
        )
    }
    composable(TaskScreens.create)
    {
        CreateTask(
            onComposing = {
                onAppBarState(it)
            },
            navController = navController
        )
    }
}