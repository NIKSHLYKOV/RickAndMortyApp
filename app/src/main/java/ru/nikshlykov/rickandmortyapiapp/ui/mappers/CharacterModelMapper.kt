package ru.nikshlykov.rickandmortyapiapp.ui.mappers

import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterModel

class CharacterModelMapper {

  fun toCharacterModel(character: Character): CharacterModel {
    return CharacterModel(
      character.id,
      character.name,
      character.image,
      "${character.gender}, ${character.status}"
    )
  }
}