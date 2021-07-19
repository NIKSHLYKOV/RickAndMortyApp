package ru.nikshlykov.rickandmortyapiapp.di

import dagger.Module
import dagger.Provides
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharacterInteractor
import ru.nikshlykov.rickandmortyapiapp.domain.interactors.GetCharactersInteractor
import ru.nikshlykov.rickandmortyapiapp.domain.repositories.CharactersRepository

@Module
class InteractorModule {

  @Provides
  fun provideGetCharacterInteractor(charactersRepository: CharactersRepository): GetCharacterInteractor {
    return GetCharacterInteractor(charactersRepository)
  }

  @Provides
  fun provideGetCharactersInteractor(charactersRepository: CharactersRepository): GetCharactersInteractor {
    return GetCharactersInteractor(charactersRepository)
  }
}