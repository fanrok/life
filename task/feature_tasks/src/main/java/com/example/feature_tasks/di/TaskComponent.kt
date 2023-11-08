package com.example.feature_tasks.di

import com.example.core_common.scope.FeatureScope
import com.example.feature_tasks.ui.list.TaskListViewModel
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppCompo
    ]
)
interface TaskComponent {
    fun getTaskListViewModel(): TaskListViewModel
}