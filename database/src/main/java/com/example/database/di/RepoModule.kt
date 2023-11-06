package com.example.database.di

import com.example.core_task_api.repo.TaskRepo
import com.example.database.impl.repo.TaskRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    @Singleton
    fun bindProfileRepository(impl: TaskRepoImpl): TaskRepo
}