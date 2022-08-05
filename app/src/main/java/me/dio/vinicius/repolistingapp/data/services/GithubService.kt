package me.dio.vinicius.repolistingapp.data.services

import me.dio.vinicius.repolistingapp.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String): List<Repo>
}