package ru.nikshlykov.rickandmortyapiapp.ui.mappers

import ru.nikshlykov.rickandmortyapiapp.core.Mapper
import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterModel

class CharacterModelMapper : Mapper<Character, CharacterModel>() {

  override fun map(value: Character): CharacterModel {
    return CharacterModel(
      value.id,
      value.name,
      value.status,
      value.species,
      value.gender,
      value.origin.name,
      value.location.name,
      value.image
    )
  }

  override fun reverseMap(value: CharacterModel): Character {
    throw NotImplementedError()
  }
}