package ru.nikshlykov.rickandmortyapiapp.data.mappers

import ru.nikshlykov.rickandmortyapiapp.data.entities.CharacterEntity
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterModel

class CharacterMapper {
  fun toUICharacter(character: CharacterEntity) = CharacterModel(
    character.id,
    character.name,
    character.image,
    character.gender + ", " + character.status
  )
}
