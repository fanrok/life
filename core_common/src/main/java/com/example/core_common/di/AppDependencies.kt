package com.example.core_common.di

import android.content.Context
import com.example.core_common.coroutines.DispatchersProvider

interface AppDependencies {

    fun provideContext(): Context

    fun provideDispatchers(): DispatchersProvider
}

interface AppDependenciesProvider{
    fun provideAppDependencies():AppDependencies
}