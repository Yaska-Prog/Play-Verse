package com.example.playverse.ui.screen.DetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.DetailGameEntity
import com.example.core.domain.usecase.GameDataUseCase
import com.example.core.utils.Output
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel(val gameDataUseCase: GameDataUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<Output<DetailGameEntity>>(Output.Idle())
    val uiState: StateFlow<Output<DetailGameEntity>> = _uiState

    fun getDetailGame(id: Int){
        viewModelScope.launch {
            gameDataUseCase.getDetailData(id).collect{result ->
                _uiState.value = result
            }
        }
    }
    fun updateGame(id: Int, favorit: Int){
        var fav = 0
        viewModelScope.launch {
            if(favorit == 0){
                fav = 1
            }
            else{
                fav = 0
            }
            gameDataUseCase.updateGame(id, fav)
        }
    }
}