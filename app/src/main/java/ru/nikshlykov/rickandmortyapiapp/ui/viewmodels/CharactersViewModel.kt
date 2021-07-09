package ru.nikshlykov.rickandmortyapiapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikshlykov.rickandmortyapiapp.data.repositories.CharactersRepositoryImpl
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharactersInteractor
import ru.nikshlykov.rickandmortyapiapp.ui.mappers.CharacterModelMapper
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterModel

class CharactersViewModel : ViewModel() {

  private val _charactersTestList2 = MutableLiveData<List<CharacterModel>>().apply {
    value = ArrayList()
  }

  private val charactersTestList2: LiveData<List<CharacterModel>> = _charactersTestList2

  fun getCharacters(): LiveData<List<CharacterModel>> {
    viewModelScope.launch {
      val characters: List<CharacterModel> =
        GetCharactersInteractor(CharactersRepositoryImpl).getCharacters()
          .map { character -> CharacterModelMapper().map(character) }
      _charactersTestList2.postValue(characters)
    }
    return charactersTestList2
  }
}