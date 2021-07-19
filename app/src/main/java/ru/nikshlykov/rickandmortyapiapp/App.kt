package ru.nikshlykov.rickandmortyapiapp

import android.app.Application
import ru.nikshlykov.rickandmortyapiapp.di.AppComponent
import ru.nikshlykov.rickandmortyapiapp.di.DaggerAppComponent

class App: Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.factory().create(this)
  }
}