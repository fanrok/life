package com.example.life.di

import com.example.core_data.di.RepoModule
import com.example.database.di.DataBaseModule
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
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}