package me.dio.vinicius.repolistingapp.domain.di

import me.dio.vinicius.repolistingapp.data.di.DataModule
import me.dio.vinicius.repolistingapp.domain.ListUserRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule() =  module {
            factory { ListUserRepositoriesUseCase(get())}
        }
}