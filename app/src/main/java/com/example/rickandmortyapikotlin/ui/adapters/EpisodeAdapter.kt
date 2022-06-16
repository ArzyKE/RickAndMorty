package com.example.rickandmortyapikotlin.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapikotlin.databinding.ItemEpisodeBinding
import com.example.rickandmortyapikotlin.model.EpisodeModel

class EpisodeAdapter(
    private val itemClick: (id: Int) -> Unit
) : ListAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(
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
        private val binding: ItemEpisodeBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                getItem(absoluteAdapterPosition).apply {
                    itemClick(id)
                }
            }
        }

        fun onBind(item: EpisodeModel?) {
            binding.itemEpisodeName.text = item?.name
        }
    }

    companion object {

        private val diffCallback: DiffUtil.ItemCallback<EpisodeModel?> =
            object : DiffUtil.ItemCallback<EpisodeModel?>() {
                override fun areItemsTheSame(
                    oldItem: EpisodeModel,
                    newItem: EpisodeModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: EpisodeModel,
                    newItem: EpisodeModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}
