package com.example.core.data.local

import com.example.core.data.local.entity.GameEntity
import com.example.core.data.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(val gameDao: GameDao) {
    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    fun insertGame(game: GameEntity) = gameDao.insertGame(game)
    fun insertGameList(game: List<GameEntity>) = gameDao.insertGameList(game)

    fun getDetailGame(id: Int): Flow<GameEntity> = gameDao.getDetailGame(id = id)

    fun updateGame(game: GameEntity) = gameDao.updateGame(game)

    fun searchGame(title: String) = gameDao.getSearchedGame(title)
}