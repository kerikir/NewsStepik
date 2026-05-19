package com.kerikir.news.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v2/everything?apiKey=a84885b07a5140eb8c801ae06c3e14c5")
    suspend fun loadArticles(
        @Query("q") topic: String
    ): NewsResponseDto
}