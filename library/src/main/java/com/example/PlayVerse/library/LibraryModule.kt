package com.example.PlayVerse.library

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val libModule = module {
    viewModel { LibraryViewmodel(get()) }
}