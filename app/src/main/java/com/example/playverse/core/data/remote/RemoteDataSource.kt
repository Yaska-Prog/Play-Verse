package com.example.playverse.core.data.remote

import com.example.playverse.core.data.remote.network.ApiService
import com.example.playverse.core.data.remote.response.DetailGameResponse
import com.example.playverse.core.data.remote.response.ResultsItem
import com.example.playverse.ui.utils.Output
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class RemoteDataSource(val apiService: ApiService) {
    suspend fun getAllGameData(): Flow<Output<List<ResultsItem>>>{
        return flow {
            try {
                emit(Output.Loading())
                val client = apiService.getAllGames()
                if(client.isSuccessful){
                    val responseBody = client.body()
                    val result = responseBody?.results
                    emit(Output.Success(result) as Output<List<ResultsItem>>)
                }
                else{
                    emit(Output.Error("Retrofit gagal!"))
                }
            } catch (e: Exception){
                emit(Output.Error("Retrofit Gagal!"))
            }
        }
    }

    suspend fun getDetailGameData(id: Int): Flow<Output<DetailGameResponse>>{
        return flow {
            try {
                emit(Output.Loading())
                val client = apiService.getDetailGame(id)
                if(client.isSuccessful){
                    val responseBody = client.body()
                    emit(Output.Success(responseBody) as Output<DetailGameResponse>)
                }
                else{
                    emit(Output.Error("Retrofit gagal!"))
                }
            } catch (e: Exception){
                emit(Output.Error("Retrofit Gagal!"))
            }
        }
    }
}