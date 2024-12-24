package com.example.core_task_api.domain

import java.util.Date

data class Task(
    val id: String,
    val title: String,
    val body: String,
    val createDate: Date,
    val finishDate: Date,
    val isUrgently: Boolean,
    val isImportant: Boolean
    )
