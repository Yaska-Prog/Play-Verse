package com.example.core.data

import android.util.Log
import com.example.core.data.local.LocalDataSource
import com.example.core.data.remote.RemoteDataSource
import com.example.core.data.remote.response.DetailGameResponse
import com.example.core.data.remote.response.ResultsItem
import com.example.core.domain.model.DetailGameEntity
import com.example.core.domain.model.GeneralGameEntity
import com.example.core.domain.repository.IPlayVerseRepository
import com.example.core.utils.DataMapper
import com.example.core.utils.Output
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GameRepository(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
): IPlayVerseRepository {
    override fun getGameData(): Flow<Output<List<GeneralGameEntity>>> =
        object : NetworkBoundResource<List<GeneralGameEntity>, List<ResultsItem>>(){
            override fun loadFromDB(): Flow<List<GeneralGameEntity>> {
                return localDataSource.getAllGame().map {
                    DataMapper.mapGeneralEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<Output<List<ResultsItem>>> {
                return remoteDataSource.getAllGameData()
            }

            override suspend fun saveCallResult(data: List<ResultsItem>) {
                val gameList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGameList(gameList)
            }

            override fun shouldFetch(data: List<GeneralGameEntity>?): Boolean {
                return data.isNullOrEmpty()
            }
        }.asFlow()

    override fun getDetailGameData(id: Int): Flow<Output<DetailGameEntity>> =
        object : NetworkBoundResource<DetailGameEntity, DetailGameResponse>() {
            override fun loadFromDB(): Flow<DetailGameEntity> {
                return localDataSource.getDetailGame(id = id).map {
                    DataMapper.convertEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<Output<DetailGameResponse>> {
                return remoteDataSource.getDetailGameData(id)
            }

            override suspend fun saveCallResult(data: DetailGameResponse) {
                val game = DataMapper.mapResponsesToDetailEntities(data)
                localDataSource.updateGame(game)
            }

            override fun shouldFetch(data: DetailGameEntity?): Boolean {
                return data?.platform == null
            }
        }.asFlow()

    override fun getSearchData(word: String): Flow<Output<List<GeneralGameEntity>>> =
        object : NetworkBoundResource<List<GeneralGameEntity>, List<ResultsItem>>() {
            override fun loadFromDB(): Flow<List<GeneralGameEntity>> {
                return localDataSource.searchGame(word).map {
                    Log.d("SearchQuery", word)
                    DataMapper.mapGeneralEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<Output<List<ResultsItem>>> {
                Log.d("CreateCall", word)
                return remoteDataSource.getSearchGame(word)
            }

            override suspend fun saveCallResult(data: List<ResultsItem>) {
                val gameList = DataMapper.mapResponsesToEntities(data)
                Log.d("SaveCall", word)
                localDataSource.insertGameList(gameList)
            }

            override fun shouldFetch(data: List<GeneralGameEntity>?): Boolean {
                return word != ""
            }
        }.asFlow()

    override fun getLibrary(): Flow<Output<List<GeneralGameEntity>>> =
        object : NetworkBoundResource<List<GeneralGameEntity>, List<ResultsItem>>(){
            override fun loadFromDB(): Flow<List<GeneralGameEntity>> {
                return localDataSource.getLibrary().map {
                    DataMapper.mapGeneralEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<Output<List<ResultsItem>>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: List<ResultsItem>) {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: List<GeneralGameEntity>?): Boolean {
                return false
            }
        }.asFlow()

    override fun updateFavorite(id: Int, favorite: Int) {
        localDataSource.updateFavorite(id, favorite)
    }

}