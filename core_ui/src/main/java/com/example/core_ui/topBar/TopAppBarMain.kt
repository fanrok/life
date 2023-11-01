package com.example.core_ui.topBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMain(
    title: String
){
    TopAppBar(
        navigationIcon =  {},
        title = {
            Text(
                text = title
            )
        },
        actions = {}
    )
}
