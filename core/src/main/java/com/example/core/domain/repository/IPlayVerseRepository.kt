package com.example.core.domain.repository

import com.example.core.domain.model.DetailGameEntity
import com.example.core.domain.model.GeneralGameEntity
import com.example.core.utils.Output
import kotlinx.coroutines.flow.Flow

interface IPlayVerseRepository {
    fun getGameData(): Flow<Output<List<GeneralGameEntity>>>
    fun getDetailGameData(id: Int): Flow<Output<DetailGameEntity>>
    fun getSearchData(word: String): Flow<Output<List<GeneralGameEntity>>>
}