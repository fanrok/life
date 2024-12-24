package com.example.feature_tasks.ui.list

import com.example.core_task_api.domain.Task

data class TaskListState(
    val errorMessage: String? = null,
    val tasksList: List<Task> = emptyList()
)
