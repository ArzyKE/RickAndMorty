package com.example.rickandmortyapikotlin.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapikotlin.databinding.ItemCharacterBinding
import com.example.rickandmortyapikotlin.model.CharacterModel

class CharacterAdapter(

    private val itemClick: (id: Int) -> Unit

) : ListAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCharacterBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition).apply {
                    itemClick(id)
                }
            }
        }

        fun onBind(item: CharacterModel?) {
            binding.itemCharacterName.text = item?.name
        }
    }

    companion object {

        private val diffCallback: DiffUtil.ItemCallback<CharacterModel?> =
            object : DiffUtil.ItemCallback<CharacterModel?>() {
                override fun areItemsTheSame(
                    oldItem: CharacterModel,
                    newItem: CharacterModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: CharacterModel,
                    newItem: CharacterModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}





