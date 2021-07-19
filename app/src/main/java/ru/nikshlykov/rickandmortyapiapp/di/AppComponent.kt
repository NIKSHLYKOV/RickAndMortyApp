package ru.nikshlykov.rickandmortyapiapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.nikshlykov.rickandmortyapiapp.ui.fragments.CharacterFragment
import ru.nikshlykov.rickandmortyapiapp.ui.fragments.CharactersFragment
import javax.inject.Singleton

@Component(
  modules = [RepositoryModule::class, InteractorModule::class, ViewModelModule::class,
    NetworkModule::class]
)
@Singleton
interface AppComponent {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: Application): AppComponent
  }

  fun inject(charactersFragment: CharactersFragment)
  fun inject(characterFragment: CharacterFragment)
}