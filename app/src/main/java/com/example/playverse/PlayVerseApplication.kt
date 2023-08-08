package com.example.playverse

import android.app.Application
import com.example.playverse.core.di.databaseModule
import com.example.playverse.core.di.networkModule
import com.example.playverse.core.di.repositoryModule
import com.example.playverse.di.usecaseModule
import com.example.playverse.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PlayVerseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@PlayVerseApplication)
            modules(
                databaseModule,
                networkModule,
                repositoryModule,
                usecaseModule,
                viewmodelModule
            )
        }
    }
}