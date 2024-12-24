package com.example.feature_tasks.ui.list

import com.example.core_task_api.repo.TaskRepo
import javax.inject.Inject

data class TaskListFacade @Inject constructor(
    private val taskRepo: TaskRepo
){
    val getTaskList = taskRepo.getTaskList()
}
