package ru.nikshlykov.rickandmortyapiapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.nikshlykov.rickandmortyapiapp.di.AppComponent
import ru.nikshlykov.rickandmortyapiapp.di.DaggerAppComponent

class App : DaggerApplication() {

  var appComponent: AppComponent = DaggerAppComponent.factory().create(this)

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent
}