package com.example.playverse.core.domain.model

data class DetailGameEntity(
    var image: String,
    var title: String,
    var metaScore: Int,
    var platform: String,
    var genre: String,
    var publishers: String,
    var description: String
)
