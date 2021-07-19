package ru.nikshlykov.rickandmortyapiapp.ui.mappers

import ru.nikshlykov.rickandmortyapiapp.core.Mapper
import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterItemModel

object CharacterItemModelMapper : Mapper<Character, CharacterItemModel>() {

  override fun map(value: Character): CharacterItemModel {
    return CharacterItemModel(
      value.id,
      value.name,
      value.image,
      "${value.gender}, ${value.status}"
    )
  }

  override fun reverseMap(value: CharacterItemModel): Character {
    throw NotImplementedError()
  }
}