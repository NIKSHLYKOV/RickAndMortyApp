package ru.nikshlykov.rickandmortyapiapp.di

import dagger.Module
import dagger.Provides
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharacterInteractor
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharactersInteractor
import ru.nikshlykov.rickandmortyapiapp.ui.viewmodels.CharacterViewModel
import ru.nikshlykov.rickandmortyapiapp.ui.viewmodels.CharactersViewModel

@Module
class ViewModelModule {

  @Provides
  fun provideCharactersViewModel(getCharactersInteractor: GetCharactersInteractor): CharactersViewModel {
    return CharactersViewModel(getCharactersInteractor)
  }

  @Provides
  fun provideCharacterViewModel(getCharacterInteractor: GetCharacterInteractor): CharacterViewModel {
    return CharacterViewModel(getCharacterInteractor)
  }
}