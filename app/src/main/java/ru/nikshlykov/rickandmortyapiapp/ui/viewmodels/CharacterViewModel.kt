package ru.nikshlykov.rickandmortyapiapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharacterInteractor
import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.ui.mappers.CharacterModelMapper
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterModel

class CharacterViewModel(val getCharacterInteractor: GetCharacterInteractor) : ViewModel() {

  private val _character = MutableLiveData<CharacterModel>()

  private val character: LiveData<CharacterModel> = _character

  fun getCharacter(characterId: Int): LiveData<CharacterModel> {
    viewModelScope.launch {
      val character: Character =
        getCharacterInteractor.getCharacter(characterId)
      _character.postValue(CharacterModelMapper.map(character))
    }
    return character
  }
}