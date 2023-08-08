package com.example.playverse.core.data.local

import androidx.room.RoomDatabase
import com.example.playverse.core.data.local.entity.GameEntity
import com.example.playverse.core.data.local.room.GameDao
import com.example.playverse.core.data.local.room.GameDatabase
import kotlinx.coroutines.flow.Flow

class LocalDataSource(val database: GameDatabase) {
    fun getAllGame(): Flow<List<GameEntity>> = database.gameDao().getAllGame()

    fun insertGame(game: GameEntity) = database.gameDao().insertGame(game)
    fun insertGameList(game: List<GameEntity>) = database.gameDao().insertGameList(game)

    fun getDetailGame(id: Int): Flow<GameEntity> = database.gameDao().getDetailGame(id = id)
}