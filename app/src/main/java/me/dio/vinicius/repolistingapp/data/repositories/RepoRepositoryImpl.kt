package me.dio.vinicius.repolistingapp.data.repositories

import kotlinx.coroutines.flow.flow
import me.dio.vinicius.repolistingapp.core.RemoteException
import me.dio.vinicius.repolistingapp.data.services.GithubService
import retrofit2.HttpException

class RepoRepositoryImpl(
    private val service: GithubService
) : RepoRepository{

    override suspend fun listRepositories(user: String) = flow{
        try{
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException){
            throw RemoteException(ex.message ?: "Não foi possivel fazer a busca no momento")
        }
    }
}