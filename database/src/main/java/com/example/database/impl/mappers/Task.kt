package com.example.database.impl.mappers

import com.example.core_task_api.domain.Task
import com.example.database.tables.TaskEntity

fun TaskEntity.mapToDomain(): Task = Task(
    id = id,
    title = title,
    body = body,
    createDate = createDate,
    finishDate = finishDate,
    isUrgently = isUrgently,
    isImportant = isImportant

)