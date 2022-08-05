package me.dio.vinicius.repolistingapp

import android.app.Application
import me.dio.vinicius.repolistingapp.data.di.DataModule
import me.dio.vinicius.repolistingapp.domain.di.DomainModule
import me.dio.vinicius.repolistingapp.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}