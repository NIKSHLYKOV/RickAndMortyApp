package ru.nikshlykov.rickandmortyapiapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.nikshlykov.rickandmortyapiapp.R
import ru.nikshlykov.rickandmortyapiapp.ui.adapters.CharactersRvAdapter
import ru.nikshlykov.rickandmortyapiapp.ui.adapters.OnCharacterItemClickListener
import ru.nikshlykov.rickandmortyapiapp.ui.viewmodels.CharactersViewModel

class CharactersFragment : Fragment(), OnCharacterItemClickListener {

  private lateinit var charactersViewModel: CharactersViewModel

  private lateinit var charactersRvAdapter: CharactersRvAdapter
  private lateinit var charactersRv: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    charactersRvAdapter = CharactersRvAdapter()
    charactersRvAdapter.setOnCharacterItemClickListener(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    charactersViewModel =
      ViewModelProvider(this).get(CharactersViewModel::class.java)
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