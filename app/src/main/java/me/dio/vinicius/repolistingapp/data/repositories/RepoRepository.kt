package me.dio.vinicius.repolistingapp.data.repositories

import kotlinx.coroutines.flow.Flow
import me.dio.vinicius.repolistingapp.data.model.Repo

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}