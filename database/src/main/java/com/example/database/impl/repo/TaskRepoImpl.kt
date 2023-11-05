package com.example.database.impl.repo

import com.example.core_task_api.domain.Task
import com.example.core_task_api.repo.TaskRepo
import com.example.database.dao.TaskDao
import com.example.database.impl.mappers.mapToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepoImpl
    @Inject constructor(
       private val dao: TaskDao
    ) : TaskRepo {
    override suspend fun getTaskListNow(): List<Task> =
        dao.getTaskListNow().map { it.mapToDomain() }

    override fun getTaskList(): Flow<List<Task>> =
        dao.getTaskList().map {list -> list.map { it.mapToDomain() } }
}