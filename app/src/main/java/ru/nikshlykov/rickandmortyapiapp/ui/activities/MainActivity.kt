package ru.nikshlykov.rickandmortyapiapp.ui.activities

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import ru.nikshlykov.rickandmortyapiapp.R

class MainActivity : DaggerAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val navView: BottomNavigationView = findViewById(R.id.nav_view)

    //val navController = findNavController(R.id.nav_host_fragment)
    val navController = findNavController(this, R.id.nav_host_fragment)
    /*// Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    val appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.navigation_characters,
        R.id.navigation_dashboard,
        R.id.navigation_notifications
      )
    )
    setupActionBarWithNavController(navController, appBarConfiguration)*/
    navView.setupWithNavController(navController)
  }
}