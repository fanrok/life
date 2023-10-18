package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.UserDao
import com.example.database.tables.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}