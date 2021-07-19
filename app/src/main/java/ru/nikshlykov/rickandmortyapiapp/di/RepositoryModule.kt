package ru.nikshlykov.rickandmortyapiapp.di

import dagger.Binds
import dagger.Module
import ru.nikshlykov.rickandmortyapiapp.data.repositories.CharactersRepositoryImpl
import ru.nikshlykov.rickandmortyapiapp.domain.repositories.CharactersRepository

@Module
abstract class RepositoryModule {

  @Binds
  abstract fun provideCharactersRepository(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersRepository
}