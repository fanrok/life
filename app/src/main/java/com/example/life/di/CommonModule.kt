package com.example.life.di

import com.example.core_common.coroutines.DispatchersProvider
import com.example.life.DispatchersProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {
    @Provides
    @Singleton
    fun provideDispatchers(): DispatchersProvider = DispatchersProviderImpl()
}