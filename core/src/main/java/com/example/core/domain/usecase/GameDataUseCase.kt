package com.example.core.domain.usecase

import com.example.core.domain.model.DetailGameEntity
import com.example.core.domain.model.GeneralGameEntity
import com.example.core.utils.Output
import kotlinx.coroutines.flow.Flow


interface GameDataUseCase {
    fun getHomeData(): Flow<Output<List<GeneralGameEntity>>>
    fun getDetailData(id: Int): Flow<Output<DetailGameEntity>>
    fun searchGame(data: String): Flow<Output<List<GeneralGameEntity>>>
}