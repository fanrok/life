package com.example.database.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "tasks"
)
data class TaskEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val body: String,
    val createDate: Date,
    val finishDate: Date,
    val isUrgently: Boolean,
    val isImportant: Boolean
    )
