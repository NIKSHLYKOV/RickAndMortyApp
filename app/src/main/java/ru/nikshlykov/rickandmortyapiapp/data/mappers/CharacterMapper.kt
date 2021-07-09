package ru.nikshlykov.rickandmortyapiapp.data.mappers

import ru.nikshlykov.rickandmortyapiapp.data.entities.CharacterEntity
import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.domain.models.Location

class CharacterMapper {
  fun toCharacter(character: CharacterEntity) = Character(
    character.id,
    character.name,
    character.status,
    character.species,
    character.type,
    character.gender,
    Location(character.origin.name, character.origin.url),
    Location(character.location.name, character.location.url),
    character.image,
    character.episode,
    character.url
  )

  // TODO добавить маппер для location
}
