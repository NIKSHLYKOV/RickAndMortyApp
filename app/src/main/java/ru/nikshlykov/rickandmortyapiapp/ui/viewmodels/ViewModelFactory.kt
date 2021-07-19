package ru.nikshlykov.rickandmortyapiapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharacterInteractor
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharactersInteractor
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
  val getCharactersInteractor: GetCharactersInteractor,
  val getCharacterInteractor: GetCharacterInteractor
) : ViewModelProvider.Factory {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return when (modelClass) {
      CharactersViewModel::class.java -> {
        CharactersViewModel(getCharactersInteractor) as T
      }
      CharacterViewModel::class.java -> {
        CharacterViewModel(getCharacterInteractor) as T
      }
      DashboardViewModel::class.java -> {
        DashboardViewModel() as T
      }
      NotificationsViewModel::class.java -> {
        NotificationsViewModel() as T
      }
      else                               -> {
        throw IllegalArgumentException("ViewModel Not Found")
      }
    }
  }
}