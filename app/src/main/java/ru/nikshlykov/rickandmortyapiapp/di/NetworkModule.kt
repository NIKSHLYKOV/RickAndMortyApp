package ru.nikshlykov.rickandmortyapiapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nikshlykov.rickandmortyapiapp.data.CharacterApi
import javax.inject.Singleton

@Module
class NetworkModule {
  private val _baseURL = "https://rickandmortyapi.com/api/"

  private var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(_baseURL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  @Provides
  @Singleton
  fun provideCharacterApi(): CharacterApi {
    return retrofit.create(CharacterApi::class.java)
  }
}