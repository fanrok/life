package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.database.converters.Converters
import com.example.database.dao.TaskDao
import com.example.database.dao.UserDao
import com.example.database.tables.TaskEntity
import com.example.database.tables.User

@Database(
    entities = [
        User::class,
        TaskEntity::class
    ], version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
}