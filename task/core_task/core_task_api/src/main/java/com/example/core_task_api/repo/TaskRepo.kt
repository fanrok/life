package com.example.core_task_api.repo

import com.example.core_task_api.domain.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepo {
    suspend fun getTaskListNow(): List<Task>

    fun getTaskList(): Flow<List<Task>>
}