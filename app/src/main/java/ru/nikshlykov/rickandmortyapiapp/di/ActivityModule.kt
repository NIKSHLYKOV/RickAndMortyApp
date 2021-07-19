package ru.nikshlykov.rickandmortyapiapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.nikshlykov.rickandmortyapiapp.ui.activities.MainActivity

@Module
abstract class ActivityModule {
  @ContributesAndroidInjector
  abstract fun contributeMainActivity(): MainActivity?
}