package ru.nikshlykov.rickandmortyapiapp.data

import retrofit2.http.GET
import retrofit2.http.Path
import ru.nikshlykov.rickandmortyapiapp.data.entities.CharacterEntity

interface CharacterApi {
  @GET("character/1,2,3,4,5,6,7,8,9,10,11,12")
  suspend fun getCharacters(): List<CharacterEntity>

  @GET("character/{id}")
  suspend fun getCharacter(@Path("id") characterId: Int): CharacterEntity
}