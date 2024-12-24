package com.example.core_data.di

import com.example.core_data.impl.repo.TaskRepoImpl
import com.example.core_task_api.repo.TaskRepo
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepoModule {

    @Binds
    @Singleton
    fun bindProfileRepository(impl: TaskRepoImpl): TaskRepo
}