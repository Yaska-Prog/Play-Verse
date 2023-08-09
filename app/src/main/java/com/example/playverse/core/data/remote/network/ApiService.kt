package com.example.playverse.core.data.remote.network

import com.example.playverse.core.data.remote.response.DetailGameResponse
import com.example.playverse.core.data.remote.response.GameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getAllGames(
        @Query("key") key: String = "09106fd37e844773a754c15059fa50e4"
    ): Response<GameResponse>

    @GET("games/{id}")
    suspend fun getDetailGame(
        @Path("id") id: Int,
        @Query("key") key: String = "09106fd37e844773a754c15059fa50e4"
    ): Response<DetailGameResponse>

    @GET("games")
    suspend fun getSearchedGame(
        @Query("search") search: String,
        @Query("key") key: String = "09106fd37e844773a754c15059fa50e4"
        ): Response<GameResponse>
}