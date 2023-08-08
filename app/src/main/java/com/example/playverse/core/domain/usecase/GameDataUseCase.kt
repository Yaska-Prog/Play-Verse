package com.example.playverse.core.domain.usecase

import com.example.playverse.core.domain.model.DetailGameEntity
import com.example.playverse.core.domain.model.GeneralGameEntity
import com.example.playverse.ui.utils.Output
import kotlinx.coroutines.flow.Flow


interface GameDataUseCase {
    fun getHomeData(): Flow<Output<List<GeneralGameEntity>>>
    fun getDetailData(id: Int): Flow<Output<DetailGameEntity>>
    fun searchGame(data: String): Flow<Output<List<GeneralGameEntity>>>
}