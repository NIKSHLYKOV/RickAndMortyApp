package ru.nikshlykov.rickandmortyapiapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.nikshlykov.rickandmortyapiapp.R
import ru.nikshlykov.rickandmortyapiapp.ui.models.CharacterItemModel

interface OnCharacterItemClickListener {
  fun onCharacterItemClick(characterId: Int)
}

class CharactersRvAdapter : RecyclerView.Adapter<CharactersRvAdapter.CharacterViewHolder>() {

  var characterItems: List<CharacterItemModel> = ArrayList()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  private var onCharacterItemClickListener: OnCharacterItemClickListener? = null

  fun setOnCharacterItemClickListener(onCharacterItemClickListener: OnCharacterItemClickListener) {
    this.onCharacterItemClickListener = onCharacterItemClickListener
  }

  override fun getItemCount(): Int {
    return characterItems.size
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    val cardView = LayoutInflater.from(parent.context)
      .inflate(R.layout.character_item, parent, false) as CardView
    return CharacterViewHolder(cardView)
  }

  override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
    val characterItem: CharacterItemModel = characterItems[position]
    holder.itemView.setOnClickListener {
      onCharacterItemClickListener?.onCharacterItemClick(characterId = characterItem.id)
    }
    holder.characterName.text = characterItem.name
    holder.characterAdditionalInfo.text = characterItem.additionalData
    Glide.with(holder.itemView.context)
      .load(characterItem.imageUrl)
      .placeholder(R.drawable.shape_load_picture)
      .into(holder.characterImage)
  }

  class CharacterViewHolder(v: View) :
    RecyclerView.ViewHolder(v) {
    val characterName: TextView = v.findViewById(R.id.character_name)
    val characterAdditionalInfo: TextView = v.findViewById(R.id.character_additional_info)
    val characterImage: ImageView = v.findViewById(R.id.charater_image)
  }
}