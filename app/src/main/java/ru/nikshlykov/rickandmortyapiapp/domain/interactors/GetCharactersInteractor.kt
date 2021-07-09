package ru.nikshlykov.rickandmortyapiapp.domain.interactors

import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.domain.repositories.CharactersRepository

class GetCharactersInteractor(private val charactersRepository: CharactersRepository) {

  suspend fun getCharacters(): List<Character> {
    return charactersRepository.getCharacters()
  }
}