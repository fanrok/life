package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "LifeDB"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()


    @Singleton
    @Provides
    fun provideTaskDao(db: AppDatabase) = db.taskDao()
}