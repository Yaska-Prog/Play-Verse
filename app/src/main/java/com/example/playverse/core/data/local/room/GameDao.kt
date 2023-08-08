package com.example.playverse.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.playverse.core.data.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Query("SELECT * FROM Game")
    fun getAllGame(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGame(game: GameEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGameList(game: List<GameEntity>)

    @Query("SELECT * FROM game where id_game = :id")
    fun getDetailGame(id: Int): Flow<GameEntity>

    @Update
    fun updateGame(game: GameEntity)
}