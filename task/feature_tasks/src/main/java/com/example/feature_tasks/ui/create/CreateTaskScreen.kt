package com.example.feature_tasks.ui.create

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
import androidx.navigation.NavController
import com.example.core_ui.topBar.AppBarState
import com.example.core_ui.topBar.AppState

@Composable
fun CreateTask(
    onComposing: (AppState) -> Unit,
    navController: NavController,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        onComposing(
            AppState(
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
                ), {}
            )
        )
    }
    CreateTask()
}

@Composable
fun CreateTask(){
    Column {
        Row {
            Text("Название задачи")
        }
        Row {
            Text("Описание")
        }
        Row {
            Text("Название задачи")
        }
        Row {
            Text("Название задачи")
        }
        Row {
            Text("Название задачи")
        }
        Row {
            Text("Название задачи")
        }
    }
}