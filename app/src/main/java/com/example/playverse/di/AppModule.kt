package com.example.playverse.di

import com.example.core.domain.usecase.GameDataUseCase
import com.example.core.domain.usecase.GameInteractor
import com.example.playverse.ui.screen.DetailScreen.DetailViewModel
import com.example.playverse.ui.screen.HomeScreen.HomeViewmodel
import com.example.playverse.ui.screen.SearchScreen.SearchViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val usecaseModule = module {
    factory<GameDataUseCase> { GameInteractor(get()) }
}

val viewmodelModule = module {
    viewModel<HomeViewmodel>{HomeViewmodel(get())}
    viewModel<DetailViewModel>{DetailViewModel(get())}
    viewModel<SearchViewModel>{SearchViewModel(get())}
}