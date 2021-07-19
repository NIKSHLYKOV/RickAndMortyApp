package ru.nikshlykov.rickandmortyapiapp.data.repositories

import ru.nikshlykov.rickandmortyapiapp.data.CharacterApi
import ru.nikshlykov.rickandmortyapiapp.data.mappers.CharacterMapper
import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.domain.repositories.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(val characterApi: CharacterApi) :
  CharactersRepository {

  override suspend fun getCharacters(): List<Character> {
    val characters = characterApi.getCharacters()
    return characters.map { character -> CharacterMapper().map(character) }
  }

  override suspend fun getCharacter(characterId: Int): Character {
    val character = characterApi.getCharacter(characterId)
    return CharacterMapper().map(character)
  }
}

