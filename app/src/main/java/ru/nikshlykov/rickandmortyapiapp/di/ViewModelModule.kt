package ru.nikshlykov.rickandmortyapiapp.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.nikshlykov.rickandmortyapiapp.ui.viewmodels.ViewModelFactory

@Module
abstract class ViewModelModule {

  @Binds
  abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}