package com.example.core.domain.model

data class GeneralGameEntity(
    var id: Int,
    var image: String,
    var title: String,
    var rating: Double,
    var releaseDate: String,
    var metacritic: Int
)
