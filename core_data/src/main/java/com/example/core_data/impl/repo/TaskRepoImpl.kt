package com.example.core_data.impl.repo

import com.example.core_common.mapIterable
import com.example.core_data.impl.mappers.mapToDomain
import com.example.core_task_api.domain.Task
import com.example.core_task_api.repo.TaskRepo
import com.example.database.dao.TaskDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepoImpl
    @Inject constructor(
       private val dao: TaskDao
    ) : TaskRepo {
    override suspend fun getTaskListNow(): List<Task> =
        dao.getTaskListNow().map { it.mapToDomain() }

    override fun getTaskList(): Flow<List<Task>> =
        dao.getTaskList().mapIterable { it.mapToDomain() }
}