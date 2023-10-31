package com.example.life.di

import android.content.Context
import androidx.room.Room
import com.example.database.AppDatabase
import com.example.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object DataBaseModule {

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "LifeDB"
    ).build() // The reason we can construct a database for the repo

//    @Singleton
//    @Provides
//    fun provideYourDao(db: AppDatabase) = db.getUserDao()
}