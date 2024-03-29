package ru.nikshlykov.rickandmortyapiapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import ru.nikshlykov.rickandmortyapiapp.R
import ru.nikshlykov.rickandmortyapiapp.ui.adapters.CharactersRvAdapter
import ru.nikshlykov.rickandmortyapiapp.ui.adapters.OnCharacterItemClickListener
import ru.nikshlykov.rickandmortyapiapp.ui.viewmodels.CharactersViewModel
import javax.inject.Inject

class CharactersFragment : DaggerFragment(), OnCharacterItemClickListener {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private lateinit var charactersViewModel: CharactersViewModel

  private lateinit var charactersRvAdapter: CharactersRvAdapter
  private lateinit var charactersRv: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    charactersViewModel = viewModelFactory.create(CharactersViewModel::class.java)
    charactersRvAdapter = CharactersRvAdapter()
    charactersRvAdapter.setOnCharacterItemClickListener(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_characters, container, false)
    charactersRv = root.findViewById(R.id.characters_rv)
    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    charactersRv.layoutManager =
      LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    charactersRv.adapter = charactersRvAdapter

    charactersViewModel.getCharacters().observe(viewLifecycleOwner, {
      if (it != null) {
        charactersRvAdapter.characterItems = it
      }
    })
  }

  override fun onCharacterItemClick(characterId: Int) {
    val navDirection: NavDirections = CharactersFragmentDirections
      .actionNavigationCharactersToCharacterFragment()
      .setCharacterId(characterId)
    findNavController().navigate(navDirection)
  }
}