package ru.nikshlykov.rickandmortyapiapp.data.repositories

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nikshlykov.rickandmortyapiapp.data.CharacterApi
import ru.nikshlykov.rickandmortyapiapp.data.mappers.CharacterMapper
import ru.nikshlykov.rickandmortyapiapp.data.model.Character
import ru.nikshlykov.rickandmortyapiapp.ui.model.Character as UICharacter


object CharacterRepository {
  private val _baseURL = "https://rickandmortyapi.com/api/"
  private var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(_baseURL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
  private var characterApi: CharacterApi = retrofit.create(CharacterApi::class.java)

  fun getCharacters(charactersLoadedListener: CharactersLoadedListener) {
    return characterApi.getCharacters().enqueue(object : Callback<List<Character>> {
      override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
        Log.i(CharacterRepository::class.java.canonicalName, "onResponse")

        response.body()?.let {
          charactersLoadedListener.charactersLoaded(it.map { dataCharacter ->
            CharacterMapper().toUICharacter(
              dataCharacter
            )
          })
        }
      }

      override fun onFailure(call: Call<List<Character>>, t: Throwable) {
        Log.i(CharacterRepository::class.java.canonicalName, "onFailure")
      }
    })
  }

  interface CharactersLoadedListener {
    fun charactersLoaded(characters: List<UICharacter>)
  }
}

