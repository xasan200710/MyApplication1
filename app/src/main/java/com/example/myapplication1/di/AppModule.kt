package com.example.myapplication1.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication1.data.repository.MainRepository
import com.example.myapplication1.data.repository.RoomRepository
import com.example.myapplication1.data.service.local.RickAndMortyDao
import com.example.myapplication1.data.service.local.RickAndMortyDatabase
import com.example.myapplication1.data.service.network.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): RickAndMortyApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()
    }

    @Provides
    @Singleton
    fun provideMainRepo(api: RickAndMortyApi): MainRepository {
        return MainRepository(api)
    }

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): RickAndMortyDatabase {
        return Room.databaseBuilder(
            context,
            RickAndMortyDatabase::class.java,
            "DB_NAME"
        ).allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(db: RickAndMortyDatabase): RickAndMortyDao {
        return db.getDao()
    }

    @Provides
    @Singleton
    fun provideRoomRepo(dao: RickAndMortyDao): RoomRepository {
        return RoomRepository(dao)
    }
}