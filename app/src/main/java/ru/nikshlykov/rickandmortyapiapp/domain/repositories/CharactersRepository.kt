package ru.nikshlykov.rickandmortyapiapp.domain.repositories

import ru.nikshlykov.rickandmortyapiapp.domain.models.Character

interface CharactersRepository {
  suspend fun getCharacters(): List<Character>
}