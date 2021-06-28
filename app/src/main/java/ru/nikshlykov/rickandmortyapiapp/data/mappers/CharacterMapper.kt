package ru.nikshlykov.rickandmortyapiapp.data.mappers

import ru.nikshlykov.rickandmortyapiapp.data.model.Character as DataCharacter
import ru.nikshlykov.rickandmortyapiapp.ui.model.Character as UICharacter

class CharacterMapper {
  fun toUICharacter(character: DataCharacter) = UICharacter(
    character.id,
    character.name,
    character.image,
    character.gender + ", " + character.status
  )
}
