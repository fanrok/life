package com.example.life

import android.app.Application
import com.example.life.di.AppComponent
import com.example.life.di.DaggerAppComponent


class App: Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}