package ru.nikshlykov.rickandmortyapiapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.nikshlykov.rickandmortyapiapp.ui.fragments.CharacterFragment
import ru.nikshlykov.rickandmortyapiapp.ui.fragments.CharactersFragment
import ru.nikshlykov.rickandmortyapiapp.ui.fragments.DashboardFragment
import ru.nikshlykov.rickandmortyapiapp.ui.fragments.NotificationsFragment

@Module
abstract class FragmentModule {
  @ContributesAndroidInjector
  abstract fun contributeCharactersFragment(): CharactersFragment

  @ContributesAndroidInjector
  abstract fun contributeCharacterFragment(): CharacterFragment

  @ContributesAndroidInjector
  abstract fun contributeDashboardFragment(): DashboardFragment

  @ContributesAndroidInjector
  abstract fun contributeNotificationsFragment(): NotificationsFragment
}