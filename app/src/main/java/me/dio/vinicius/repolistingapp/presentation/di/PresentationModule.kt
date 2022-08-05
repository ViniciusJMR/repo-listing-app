package me.dio.vinicius.repolistingapp.presentation.di

import me.dio.vinicius.repolistingapp.presentation.MainViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule() = module {
        viewModel { MainViewModel(get())}
    }
}