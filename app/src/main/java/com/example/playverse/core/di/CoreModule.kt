package com.example.playverse.core.di

import androidx.room.Room
import com.example.playverse.core.data.GameRepository
import com.example.playverse.core.data.local.LocalDataSource
import com.example.playverse.core.data.local.room.GameDatabase
import com.example.playverse.core.data.remote.RemoteDataSource
import com.example.playverse.core.data.remote.network.ApiService
import com.example.playverse.core.data.remote.network.AuthenticationInterceptor
import com.example.playverse.core.domain.repository.IPlayVerseRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(AuthenticationInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/games")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            GameDatabase::class.java, "Playverse.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
//    factory { get<GameDatabase>().gameDao() }
}

val repositoryModule = module {
//    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IPlayVerseRepository> { GameRepository(get(), get()) }
}