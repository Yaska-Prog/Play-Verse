package com.example.playverse.core.data.remote.network

import com.example.playverse.core.data.remote.response.DetailGameResponse
import com.example.playverse.core.data.remote.response.GameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getAllGames(): Response<GameResponse>

    @GET("games/{id}")
    suspend fun getDetailGame(
        @Path("id") id: Int
    ): Response<DetailGameResponse>

    @GET("games")
    suspend fun getSearchedGame(@Query("search") search: String): Response<GameResponse>
}