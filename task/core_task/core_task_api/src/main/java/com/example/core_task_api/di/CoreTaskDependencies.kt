package com.example.core_task_api.di

import com.example.core_task_api.repo.TaskRepo

interface CoreTaskDependencies {
    fun provideRepo(): TaskRepo
}

interface CoreTaskDependenciesProvider{
    fun provideCoreTaskDependencies():CoreTaskDependencies
}