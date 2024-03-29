package com.example.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.core.data.local.entity.GameEntity
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

    @Query("SELECT * FROM game WHERE title LIKE :title")
    fun getSearchedGame(title: String): Flow<List<GameEntity>>

    @Query("SELECT * FROM game WHERE favorited = 1")
    fun getLibrary(): Flow<List<GameEntity>>

    @Query("UPDATE Game SET favorited = :favorit WHERE id_game = :id_game")
    fun updateFavorite(id_game: Int, favorit: Int)
}