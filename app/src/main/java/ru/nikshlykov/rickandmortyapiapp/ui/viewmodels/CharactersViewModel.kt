package ru.nikshlykov.rickandmortyapiapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikshlykov.rickandmortyapiapp.data.repositories.CharacterRepository
import ru.nikshlykov.rickandmortyapiapp.ui.models.Character

class CharactersViewModel : ViewModel() {

  private val _charactersTestList2 = MutableLiveData<List<Character>>().apply {
    value = ArrayList()
  }

  private val charactersTestList2: LiveData<List<Character>> = _charactersTestList2

  fun getCharacters(): LiveData<List<Character>> {
    viewModelScope.launch {
      val characters: List<Character> = CharacterRepository.getCharactersCoroutine()
      _charactersTestList2.postValue(characters)
    }
    return charactersTestList2
  }
}