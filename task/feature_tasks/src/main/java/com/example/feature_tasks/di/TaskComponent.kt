package com.example.feature_tasks.di

import com.example.core_common.di.AppDependencies
import com.example.core_common.scope.FeatureScope
import com.example.core_task_api.di.CoreTaskDependencies
import com.example.feature_tasks.ui.list.TaskListViewModel
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppDependencies::class,
        CoreTaskDependencies::class
    ]
)
interface TaskComponent {
    fun getTaskListViewModel(): TaskListViewModel

    @Component.Builder
    interface Builder {

        fun appDependencies(dependencies: AppDependencies): Builder
        fun coreTaskDependencies(dependencies: CoreTaskDependencies): Builder
        fun build(): TaskComponent
    }
}