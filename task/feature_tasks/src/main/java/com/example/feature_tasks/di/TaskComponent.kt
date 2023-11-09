package com.example.feature_tasks.di

import android.content.Context
import com.example.core_common.di.AppDependencies
import com.example.core_common.di.AppDependenciesProvider
import com.example.core_common.scope.FeatureScope
import com.example.core_task_api.di.CoreTaskDependencies
import com.example.core_task_api.di.CoreTaskDependenciesProvider
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
    companion object {
        private var component: TaskComponent? = null
        fun getOrCreate(context: Context): TaskComponent {
            if(component == null){
                component = DaggerTaskComponent
                    .builder()
                    .appDependencies((context.applicationContext as AppDependenciesProvider).provideAppDependencies())
                    .coreTaskDependencies((context.applicationContext as CoreTaskDependenciesProvider).provideCoreTaskDependencies())
                    .build()
            }
            return component!!
        }
    }

    @Component.Builder
    interface Builder {
        fun appDependencies(dependencies: AppDependencies): Builder
        fun coreTaskDependencies(dependencies: CoreTaskDependencies): Builder
        fun build(): TaskComponent
    }
}