package com.example.playverse.core.domain.usecase

import com.example.playverse.core.data.GameRepository
import com.example.playverse.core.domain.model.DetailGameEntity
import com.example.playverse.core.domain.model.GeneralGameEntity
import com.example.playverse.ui.utils.Output
import kotlinx.coroutines.flow.Flow

class GameInteractor(val gameRepository: GameRepository): GameDataUseCase {
    override fun getHomeData(): Flow<Output<List<GeneralGameEntity>>> {
        return gameRepository.getGameData()
    }

    override fun getDetailData(id: Int): Flow<Output<DetailGameEntity>> {
        return gameRepository.getDetailGameData(id)
    }

    override fun searchGame(data: String): Flow<Output<List<GeneralGameEntity>>> {
        return gameRepository.getSearchData(word = data)
    }
}