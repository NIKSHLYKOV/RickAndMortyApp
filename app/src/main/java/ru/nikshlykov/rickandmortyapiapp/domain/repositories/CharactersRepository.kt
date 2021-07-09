package ru.nikshlykov.rickandmortyapiapp.domain.repositories

import ru.nikshlykov.rickandmortyapiapp.domain.models.Character

interface CharactersRepository {
  fun getCharacters(): List<Character>
}