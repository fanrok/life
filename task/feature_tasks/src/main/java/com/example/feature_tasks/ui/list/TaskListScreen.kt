package com.example.feature_tasks.ui.list

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.core_ui.topBar.AppBarState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TaskList(
    onComposing: (AppBarState) -> Unit,
    navController: NavHostController,
    viewModel: TaskListViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.screenState.collectAsState().value
    LaunchedEffect(key1 = true) {
        onComposing (
            AppBarState(
                title = "TaskList",
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
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
           text = "TaskList"
        )
        LazyColumn{
            items(state.tasksList) { item ->
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = item.title,
                )
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
    state.errorMessage?.let{
        Toast.makeText(
            context,
            it,
            Toast.LENGTH_LONG
        ).show()
        viewModel.reserError()
    }
}