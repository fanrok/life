package com.example.life

import android.app.Application
import com.example.core_common.di.AppDependencies
import com.example.core_common.di.AppDependenciesProvider
import com.example.core_task_api.di.CoreTaskDependencies
import com.example.core_task_api.di.CoreTaskDependenciesProvider
import com.example.life.di.AppComponent
import com.example.life.di.DaggerAppComponent


class App : Application(), AppDependenciesProvider, CoreTaskDependenciesProvider {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
//        appComponent = AppComponent.create(applicationContext)
        appComponent = DaggerAppComponent.builder().setContext(applicationContext).build()
    }

    override fun provideAppDependencies(): AppDependencies  = appComponent

    override fun provideCoreTaskDependencies(): CoreTaskDependencies  = appComponent
}