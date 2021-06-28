package ru.nikshlykov.rickandmortyapiapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nikshlykov.rickandmortyapiapp.data.repositories.CharacterRepository
import ru.nikshlykov.rickandmortyapiapp.ui.model.Character

class CharactersViewModel : ViewModel(), CharacterRepository.CharactersLoadedListener {

  private val _charactersTestList2 = MutableLiveData<List<Character>>().apply {
    value = ArrayList()
  }

  private val charactersTestList2: LiveData<List<Character>> = _charactersTestList2

  fun getCharacters(): LiveData<List<Character>> {
    CharacterRepository.getCharacters(this)
    return charactersTestList2
  }

  override fun charactersLoaded(characters: List<Character>) {
    _charactersTestList2.value = characters
  }
}