package com.example.life.di

import android.content.Context
import com.example.core_common.di.AppDependencies
import com.example.core_data.di.RepoModule
import com.example.core_task_api.di.CoreTaskDependencies
import com.example.database.di.DataBaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CommonModule::class,
        DataBaseModule::class,
        RepoModule::class
    ]
)
interface AppComponent: AppDependencies, CoreTaskDependencies {

//    companion object {
//        fun create(context: Context): AppComponent =
//            DaggerAppComponent.builder()
//                .setContext(context)
//                .build()
//    }
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setContext(context: Context): Builder
        fun build(): AppComponent
    }
}