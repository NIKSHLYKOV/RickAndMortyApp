package ru.nikshlykov.rickandmortyapiapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nikshlykov.rickandmortyapiapp.ui.model.Character

class CharactersViewModel : ViewModel() {

  private val _charactersTestList = MutableLiveData<List<Character>>().apply {
    value = ArrayList()
    (value as ArrayList<Character>).apply {
      add(
        Character(
          0L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          1L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          2L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          3L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          4L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          5L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          6L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          7L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          8L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
      add(
        Character(
          9L,
          "Rick Sanchez",
          "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "Human, Earth"
        )
      )
    }
  }

  val charactersTestList: LiveData<List<Character>> = _charactersTestList
}