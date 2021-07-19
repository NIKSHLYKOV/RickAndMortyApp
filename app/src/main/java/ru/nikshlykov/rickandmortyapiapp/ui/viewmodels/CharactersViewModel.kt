package ru.nikshlykov.rickandmortyapiapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharactersInteractor
import ru.nikshlykov.rickandmortyapiapp.ui.mappers.CharacterItemModelMapper
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterItemModel

class CharactersViewModel(val getCharactersInteractor: GetCharactersInteractor) :
  ViewModel() {

  private val _charactersTestList2 = MutableLiveData<List<CharacterItemModel>>().apply {
    value = ArrayList()
  }

  private val charactersTestList2: LiveData<List<CharacterItemModel>> = _charactersTestList2

  fun getCharacters(): LiveData<List<CharacterItemModel>> {
    viewModelScope.launch {
      val characterItems: List<CharacterItemModel> =
        getCharactersInteractor.getCharacters()
          .map { character -> CharacterItemModelMapper.map(character) }
      _charactersTestList2.postValue(characterItems)
    }
    return charactersTestList2
  }

  // TODO Переименовать потом названия переменных, когда будет адекватное решение со списком.
}