package com.example.feature_tasks.di

import com.example.core_common.coroutines.DispatchersProvider
import com.example.core_common.scope.FeatureScope
import com.example.feature_tasks.ui.list.TaskListFacade
import com.example.feature_tasks.ui.list.TaskListViewModel
import dagger.Module
import dagger.Provides


@Module
abstract class TaskModule {
    @Provides
    @FeatureScope
    fun provideTaskListViewModel(
        useCases: TaskListFacade,
        dispatchers: DispatchersProvider
    ) =
        TaskListViewModel(useCases, dispatchers)
}