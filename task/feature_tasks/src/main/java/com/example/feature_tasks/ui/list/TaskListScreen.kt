package com.example.feature_tasks.ui.list

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.core_common.viewModel.injectViewModel
import com.example.core_navigation.TaskScreens
import com.example.core_task_api.domain.Task
import com.example.core_ui.topBar.AppBarState
import com.example.core_ui.topBar.AppState
import java.util.Date

@Composable
fun TaskListScreen(
    onComposing: (AppState) -> Unit,
    navController: NavController,
//    viewModel: TaskListViewModel = injectViewModel {
//        DaggerTaskComponent.builder().build().getTaskListViewModel()
//    }
) {
    val context = LocalContext.current
//    val state = viewModel.screenState.collectAsState().value
    val state = TaskListState()
    LaunchedEffect(key1 = true) {
        onComposing(
            AppState(
                appBarState = AppBarState(
                    title = "TaskList",
                    showIconBack = false,
                    actions = {}),
                fab = {
                    FloatingActionButton(
                        onClick = { navController.navigate(TaskScreens.create) },
                        content = { Icon(Icons.Filled.Add, "") }
                    )
                }
            )
        )
    }
    TaskList(state, navController)
    state.errorMessage?.let {
        Toast.makeText(
            context,
            it,
            Toast.LENGTH_LONG
        ).show()
//        viewModel.reserError()
    }
}

@Composable
private fun TaskList(
    state: TaskListState,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "TaskList"
        )
        LazyColumn {
            items(state.tasksList) { item ->
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = item.title,
                )
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
}


@Composable
@Preview
fun TaskListPrev() {
    TaskList(
        TaskListState(
            errorMessage = null,
            tasksList = listOf(
                Task(
                    "", "hihihi", "", Date(), Date(), false, false
                ),
                Task(
                    "", "hihihi", "", Date(), Date(), false, false
                ), Task(
                    "", "hihihi", "", Date(), Date(), false, false
                ), Task(
                    "", "hihihi", "", Date(), Date(), false, false
                ), Task(
                    "", "hihihi", "", Date(), Date(), false, false
                ), Task(
                    "", "hihihi", "", Date(), Date(), false, false
                ), Task(
                    "", "hihihi", "", Date(), Date(), false, false
                )
            )
        ),
        rememberNavController()
    )
}