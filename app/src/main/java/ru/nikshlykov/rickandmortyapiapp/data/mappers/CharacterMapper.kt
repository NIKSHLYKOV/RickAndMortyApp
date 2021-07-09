package ru.nikshlykov.rickandmortyapiapp.data.mappers

import ru.nikshlykov.rickandmortyapiapp.core.Mapper
import ru.nikshlykov.rickandmortyapiapp.data.entities.CharacterEntity
import ru.nikshlykov.rickandmortyapiapp.domain.models.Character
import ru.nikshlykov.rickandmortyapiapp.domain.models.Location

class CharacterMapper : Mapper<CharacterEntity, Character>() {

  override fun map(value: CharacterEntity): Character {
    return Character(
      value.id,
      value.name,
      value.status,
      value.species,
      value.type,
      value.gender,
      Location(value.origin.name, value.origin.url),
      Location(value.location.name, value.location.url),
      value.image,
      value.episode,
      value.url
    )
  }

  override fun reverseMap(value: Character): CharacterEntity {
    throw NotImplementedError()
  }

  // TODO добавить маппер для location
}
