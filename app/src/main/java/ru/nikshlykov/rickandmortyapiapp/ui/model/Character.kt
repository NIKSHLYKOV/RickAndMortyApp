package ru.nikshlykov.rickandmortyapiapp.ui.model

data class Character(
  val id: Long,
  val name: String,
  val imageUrl: String,
  val additionalData: String
)

// TODO подумать над тем, как сделать тут Bitmap, а не ссылку.