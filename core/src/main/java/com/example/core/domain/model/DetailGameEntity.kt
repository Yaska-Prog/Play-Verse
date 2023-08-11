package com.example.core.domain.model

data class DetailGameEntity(
    var image: String?,
    var title: String?,
    var metaScore: Int?,
    var platform: String?,
    var genre: String?,
    var publishers: String?,
    var description: String?,
    var favorited: Int
)
