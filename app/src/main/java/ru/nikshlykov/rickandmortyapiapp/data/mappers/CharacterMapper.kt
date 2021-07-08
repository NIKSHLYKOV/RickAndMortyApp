package ru.nikshlykov.rickandmortyapiapp.data.mappers

import ru.nikshlykov.rickandmortyapiapp.data.models.Character as DataCharacter
import ru.nikshlykov.rickandmortyapiapp.ui.models.Character as UICharacter

class CharacterMapper {
  fun toUICharacter(character: DataCharacter) = UICharacter(
    character.id,
    character.name,
    character.image,
    character.gender + ", " + character.status
  )
}
