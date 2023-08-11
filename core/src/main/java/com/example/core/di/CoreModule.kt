package com.example.core.di

import androidx.room.Room
import com.example.core.data.GameRepository
import com.example.core.data.local.LocalDataSource
import com.example.core.data.local.room.GameDatabase
import com.example.core.data.remote.RemoteDataSource
import com.example.core.data.remote.network.ApiService
import com.example.core.domain.repository.IPlayVerseRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val databaseModule = module {
    factory { get<GameDatabase>().gameDao() }
    single {
        Room.databaseBuilder(
            get(),
            GameDatabase::class.java, "Playverse.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IPlayVerseRepository> { GameRepository(get(), get()) }
}