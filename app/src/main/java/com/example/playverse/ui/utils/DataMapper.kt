package com.example.playverse.ui.utils

import com.example.playverse.core.data.local.entity.GameEntity
import com.example.playverse.core.data.remote.response.DetailGameResponse
import com.example.playverse.core.data.remote.response.ResultsItem
import com.example.playverse.core.domain.model.DetailGameEntity
import com.example.playverse.core.domain.model.GeneralGameEntity

object DataMapper {
    fun mapResponsesToEntities(input: List<ResultsItem>): List<GameEntity>{
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                id_game = it.id as Int,
                rating = it.rating as Double,
                title = it.slug as String,
                backgroundImage = it.backgroundImage as String,
                released = it.released as String
            )
            gameList.add(game)
        }
        return gameList
    }

    fun mapGeneralEntitiesToDomain(input: List<GameEntity>): List<GeneralGameEntity> =
        input.map {
            GeneralGameEntity(
                image = it.backgroundImage,
                title = it.title,
                rating = it.rating,
                releaseDate = it.released
            )
        }

    fun convertEntitiesToDomain(input: GameEntity): DetailGameEntity{
        val game = DetailGameEntity(
            image = input.backgroundImage,
            title = input.title,
            metaScore = input.metascore as Int,
            description = input.description as String,
            genre = input.genre as String,
            platform = input.platform as String,
            publishers = input.publishers as String
        )
        return game
    }

    fun mapResponsesToDetailEntities(input: DetailGameResponse): GameEntity{
        var genre = ""
        var publishers = ""
        var platform = ""
        input.genres?.map { genres ->
            genre += "${genres?.name}, "
        }
        input.publishers?.map {
            publishers += "${it?.name}, "
        }
        input.platforms?.map {
            platform += "${it?.platform}, "
        }
        val game = GameEntity(
            id_game = input.id as Int,
            rating = input.rating as Double,
            title = input.slug as String,
            backgroundImage = input.backgroundImage as String,
            released = input.released as String,
            publishers = publishers,
            platform = platform,
            genre = genre,
            description = input.descriptionRaw,
            metascore = input.metacritic
        )
        return game
    }
}