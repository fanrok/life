package com.example.database.impl.repo

import com.example.core_task_api.domain.Task
import com.example.core_task_api.repo.TaskRepo
import kotlinx.coroutines.flow.Flow

class TaskRepoImpl: TaskRepo {
    override suspend fun getTaskListNow(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun getTaskList(): Flow<List<Task>> {
        TODO("Not yet implemented")
    }
}