package ru.nikshlykov.rickandmortyapiapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.nikshlykov.rickandmortyapiapp.App
import ru.nikshlykov.rickandmortyapiapp.R
import ru.nikshlykov.rickandmortyapiapp.ui.viewmodels.CharacterViewModel
import javax.inject.Inject

class CharacterFragment : Fragment() {

  @Inject
  lateinit var characterViewModel: CharacterViewModel

  private lateinit var characterImage: ImageView
  private lateinit var characterName: TextView
  private lateinit var characterGender: TextView
  private lateinit var characterSpecies: TextView
  private lateinit var characterStatus: TextView
  private lateinit var characterOrigin: TextView
  private lateinit var characterLocation: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (activity?.application as App).appComponent.inject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_character, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    characterImage = view.findViewById(R.id.fragment_character___image)
    characterName = view.findViewById(R.id.fragment_character___name)
    characterGender = view.findViewById(R.id.fragment_character___gender)
    characterSpecies = view.findViewById(R.id.fragment_character___species)
    characterStatus = view.findViewById(R.id.fragment_character___status)
    characterOrigin = view.findViewById(R.id.fragment_character___origin)
    characterLocation = view.findViewById(R.id.fragment_character___location)

    val characterId: Int
    val bundleArguments = arguments
    if (bundleArguments != null) {
      characterId = CharacterFragmentArgs.fromBundle(bundleArguments).characterId
      characterViewModel.getCharacter(characterId).observe(viewLifecycleOwner) { character ->
        if (character != null) {
          context?.let {
            Glide.with(it)
              .load(character.image)
              .placeholder(R.drawable.shape_load_picture)
              .into(characterImage)
          }
          characterName.text = character.name
          characterGender.text = character.gender
          characterSpecies.text = character.species
          characterStatus.text = character.status
          characterOrigin.text = character.origin
          characterLocation.text = character.location
        }
      }
    } else {
      // TODO реализовать выход из фрагмента с показом диалога об ошибке.
    }
  }
}