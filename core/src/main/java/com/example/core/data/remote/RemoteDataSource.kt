package com.example.core.data.remote

import com.example.core.data.remote.network.ApiService
import com.example.core.data.remote.response.DetailGameResponse
import com.example.core.data.remote.response.ResultsItem
import com.example.core.utils.Output
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class RemoteDataSource(val apiService: ApiService) {
    suspend fun getAllGameData(): Flow<Output<List<ResultsItem>>>{
        return flow {
            val client = apiService.getAllGames()
            if(client.isSuccessful){
                val responseBody = client.body()
                val result = responseBody?.results
                emit(Output.Success(result) as Output<List<ResultsItem>>)
            }
            else{
                emit(Output.Error("Retrofit gagal!"))
            }
        }
    }

    suspend fun getDetailGameData(id: Int): Flow<Output<DetailGameResponse>>{
        return flow {
            val client = apiService.getDetailGame(id)
            if(client.isSuccessful){
                val responseBody = client.body()
                emit(Output.Success(responseBody) as Output<DetailGameResponse>)
            }
            else{
                emit(Output.Error("Retrofit gagal!"))
            }
        }
    }

    suspend fun getSearchGame(input: String): Flow<Output<List<ResultsItem>>>{
        return flow{
            val client = apiService.getSearchedGame(input)
            if(client.isSuccessful){
                val responseBody = client.body()
                emit(Output.Success(responseBody?.results) as Output<List<ResultsItem>>)
            }
            else{
                emit(Output.Error("Retrofit gagal!"))
            }
        }
    }
}