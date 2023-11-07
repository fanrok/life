package com.example.life

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.TaskScreens
import com.example.core_ui.topBar.AppBarState
import com.example.core_ui.topBar.AppState
import com.example.core_ui.topBar.TopAppBarMain
import com.example.life.ui.theme.LifeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            LifeTheme {
                MainContent(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("LongMethod")
fun MainContent(
    navController: NavHostController
) {
    val context = LocalContext.current
    var appState by remember {
        mutableStateOf(AppState())
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBarMain(appState.appBarState, navController)
            },
            bottomBar = {
                BottomAppBar() { }
            },
            floatingActionButton = appState.fab
        ) { padding ->
            NavHost(
                modifier = Modifier.padding(padding),
                navController = navController,
                startDestination = TaskScreens.list
            ) {
                globalGraph(
                    context = context,
                    navController = navController,
                    onAppState = { appState = it }
                )
            }
        }
    }
}
