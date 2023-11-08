package com.example.life.di

import com.example.core_common.coroutines.DispatchersProvider
import com.example.life.DispatchersProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CommonModule {
    @Provides
    @Singleton
    fun provideDispatchers(): DispatchersProvider = DispatchersProviderImpl()
}