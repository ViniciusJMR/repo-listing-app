package me.dio.vinicius.repolistingapp.data.repositories

import kotlinx.coroutines.flow.flow
import me.dio.vinicius.repolistingapp.data.services.GithubService

class RepoRepositoryImpl(
    private val service: GithubService
) : RepoRepository{

    override suspend fun listRepositories(user: String) = flow{
        val repoList = service.listRepositories(user)
        emit(repoList)
    }
}