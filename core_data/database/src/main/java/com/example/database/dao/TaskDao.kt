package com.example.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.database.tables.TaskEntity
import com.example.database.tables.User
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getTaskListNow(): List<TaskEntity>

    @Query("SELECT * FROM tasks")
    fun getTaskList(): Flow<List<TaskEntity>>

    @Insert
    fun insert(tasks: List<TaskEntity>)
}