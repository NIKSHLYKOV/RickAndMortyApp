package ru.nikshlykov.rickandmortyapiapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.nikshlykov.rickandmortyapiapp.App
import javax.inject.Singleton

@Component(
  modules = [AndroidInjectionModule::class, ActivityModule::class, FragmentModule::class,
    RepositoryModule::class, InteractorModule::class, ViewModelModule::class, NetworkModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: Application): AppComponent
  }
}