package com.example.rickandmortyapikotlin.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapikotlin.databinding.ItemLocationBinding
import com.example.rickandmortyapikotlin.model.LocationModel

class LocationAdapter(

    private val itemClick: (id: Int) -> Unit

) : ListAdapter<LocationModel, LocationAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                getItem(absoluteAdapterPosition).apply {
                    itemClick(id)
                }
            }
        }

        fun onBind(item: LocationModel?) {
            binding.itemLocationName.text = item?.name
        }
    }

    companion object {
        private val diffCallback: DiffUtil.ItemCallback<LocationModel?> =
            object : DiffUtil.ItemCallback<LocationModel?>() {
                override fun areItemsTheSame(
                    oldItem: LocationModel,
                    newItem: LocationModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: LocationModel,
                    newItem: LocationModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}