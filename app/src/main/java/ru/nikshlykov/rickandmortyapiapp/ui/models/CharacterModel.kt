package ru.nikshlykov.rickandmortyapiapp.ui.models

data class CharacterModel(
  val id: Int,
  val name: String,
  val imageUrl: String,
  val additionalData: String
)

// TODO подумать над тем, как сделать тут Bitmap/Drawable, а не ссылку.