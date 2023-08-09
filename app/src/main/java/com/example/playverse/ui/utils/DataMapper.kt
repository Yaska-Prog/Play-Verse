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
                rating = (it.rating as Double),
                title = (it.name ?: ""),
                backgroundImage = (it.backgroundImage ?: ""),
                released = (it.released ?: ""),
                metascore = (it.metacritic ?: (it.rating * 20.0).toInt())
            )
            gameList.add(game)
        }
        return gameList
    }

    fun mapGeneralEntitiesToDomain(input: List<GameEntity>): List<GeneralGameEntity> =
        input.map {
            GeneralGameEntity(
                id = it.id_game,
                image = it.backgroundImage,
                title = it.title,
                rating = it.rating,
                releaseDate = it.released,
                metacritic = (it.metascore ?: (it.rating * 20.0).toInt())
            )
        }

    fun convertEntitiesToDomain(input: GameEntity): DetailGameEntity{
        val game = DetailGameEntity(
            image = input.backgroundImage,
            title = input.title,
            metaScore = (input.metascore ?: (input.rating * 20.0).toInt()),
            description = input.description,
            genre = input.genre,
            platform = input.platform,
            publishers = input.publishers
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
            platform += "${it?.platform?.name}, "
        }
        val game = GameEntity(
            id_game = input.id as Int,
            rating = input.rating as Double,
            title = (input.name ?: ""),
            backgroundImage = (input.backgroundImage ?: ""),
            released = (input.released ?: ""),
            publishers = publishers,
            platform = platform,
            genre = genre,
            description = input.descriptionRaw,
            metascore = (input.metacritic ?: (input.rating * 20.0).toInt())
        )
        return game
    }
}