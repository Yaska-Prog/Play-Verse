package com.example.core.domain.usecase

import com.example.core.data.GameRepository
import com.example.core.domain.model.DetailGameEntity
import com.example.core.domain.model.GeneralGameEntity
import com.example.core.domain.repository.IPlayVerseRepository
import com.example.core.utils.Output
import kotlinx.coroutines.flow.Flow

class GameInteractor(val gameRepository: IPlayVerseRepository): GameDataUseCase {
    override fun getHomeData(): Flow<Output<List<GeneralGameEntity>>> {
        return gameRepository.getGameData()
    }

    override fun getDetailData(id: Int): Flow<Output<DetailGameEntity>> {
        return gameRepository.getDetailGameData(id)
    }

    override fun searchGame(data: String): Flow<Output<List<GeneralGameEntity>>> {
        return gameRepository.getSearchData(word = data)
    }

    override fun getLibrary(): Flow<Output<List<GeneralGameEntity>>> {
        return gameRepository.getLibrary()
    }

    override fun updateGame(id: Int, favorite: Int) {
        gameRepository.updateFavorite(id, favorite)
    }
}