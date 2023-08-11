package com.example.playverse.ui.screen.SearchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.GeneralGameEntity
import com.example.core.domain.usecase.GameDataUseCase
import com.example.core.utils.Output
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel(val gameDataUseCase: GameDataUseCase): ViewModel() {
    private val _uiState = MutableStateFlow<Output<List<GeneralGameEntity>>>(Output.Idle())
    val uiState: StateFlow<Output<List<GeneralGameEntity>>> = _uiState

    fun getSearchResult(text: String){
        viewModelScope.launch {
            gameDataUseCase.searchGame(text).collect{result ->
                _uiState.value = result
            }
        }
    }
}