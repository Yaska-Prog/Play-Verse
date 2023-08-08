package com.example.playverse.core.data.local

import com.example.playverse.core.data.local.entity.GameEntity
import com.example.playverse.core.data.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(val gameDao: GameDao) {
    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    fun insertGame(game: GameEntity) = gameDao.insertGame(game)
    fun insertGameList(game: List<GameEntity>) = gameDao.insertGameList(game)

    fun getDetailGame(id: Int): Flow<GameEntity> = gameDao.getDetailGame(id = id)
}