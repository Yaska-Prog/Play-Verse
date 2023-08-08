package com.example.playverse.di

import com.example.playverse.core.domain.usecase.GameDataUseCase
import com.example.playverse.core.domain.usecase.GameInteractor
import com.example.playverse.ui.screen.HomeScreen.HomeViewmodel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val usecaseModule = module {
    factory<GameDataUseCase> { GameInteractor(get()) }
}

val viewmodelModule = module {
    viewModelOf(::HomeViewmodel)
}