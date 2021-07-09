package ru.nikshlykov.rickandmortyapiapp.data.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nikshlykov.rickandmortyapiapp.data.CharacterApi
import ru.nikshlykov.rickandmortyapiapp.data.mappers.CharacterMapper
import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.domain.repositories.CharactersRepository

object CharactersRepositoryImpl : CharactersRepository {
  private val _baseURL = "https://rickandmortyapi.com/api/"
  private var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(_baseURL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
  private var characterApi: CharacterApi = retrofit.create(CharacterApi::class.java)

  override suspend fun getCharacters(): List<Character> {
    val characters = characterApi.getCharacters()
    return characters.map { character -> CharacterMapper().map(character) }
  }
}

