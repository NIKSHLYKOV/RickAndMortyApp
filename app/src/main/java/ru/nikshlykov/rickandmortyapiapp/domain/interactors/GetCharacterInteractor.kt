package ru.nikshlykov.rickandmortyapiapp.domain.interactors

import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.domain.repositories.CharactersRepository

class GetCharacterInteractor(private val charactersRepository: CharactersRepository) {

  suspend fun getCharacter(characterId: Int): Character {
    return charactersRepository.getCharacter(characterId)
  }
}