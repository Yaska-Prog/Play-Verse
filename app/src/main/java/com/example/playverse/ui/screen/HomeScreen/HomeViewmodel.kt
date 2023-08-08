package com.example.playverse.ui.screen.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playverse.core.domain.model.GeneralGameEntity
import com.example.playverse.core.domain.usecase.GameDataUseCase
import com.example.playverse.ui.utils.Output
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewmodel(val _gameDataUseCase: GameDataUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<Output<List<GeneralGameEntity>>>(Output.Idle())
    val uiState: StateFlow<Output<List<GeneralGameEntity>>> = _uiState

    fun getGameData() {
        viewModelScope.launch {
            _gameDataUseCase.getHomeData().collect{result ->
                _uiState.value = result
            }
        }
    }
}