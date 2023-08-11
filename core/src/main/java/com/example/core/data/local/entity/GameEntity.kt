package com.example.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NonNls

@Entity(tableName = "Game")
data class GameEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_game")
    val id_game: Int,

    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "released")
    val released: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "metascore")
    val metascore: Int? = null,

    @ColumnInfo(name = "platform")
    val platform: String? = null,

    @ColumnInfo(name = "genre")
    val genre: String? = null,

    @ColumnInfo(name = "publishers")
    val publishers: String? = null,

    @ColumnInfo(name = "description")
    val description: String? = null
)
