package com.android.weatherapp.nextstack.nytimes

import android.app.Application
import com.android.weatherapp.nextstack.nytimes.di.dataSourceModule
import com.android.weatherapp.nextstack.nytimes.di.networkModule
import com.android.weatherapp.nextstack.nytimes.di.presentationModule
import com.android.weatherapp.nextstack.nytimes.di.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                dataSourceModule,
                repoModule,
                presentationModule
            )
        }
    }
}