package me.dio.vinicius.repolistingapp.domain

import kotlinx.coroutines.flow.Flow
import me.dio.vinicius.repolistingapp.core.UseCase
import me.dio.vinicius.repolistingapp.data.model.Repo
import me.dio.vinicius.repolistingapp.data.repositories.RepoRepository

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
    ) : UseCase<String, List<Repo>>(){
    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }

}