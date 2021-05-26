package com.chunchiehliang.apechealthkey.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chunchiehliang.apechealthkey.databinding.ItemAttractionBinding
import com.chunchiehliang.apechealthkey.models.Attraction


class AttractionListAdapter(private val listener: AttractionListener) :
    ListAdapter<Attraction, AttractionListAdapter.AttractionViewHolder>(AttractionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttractionViewHolder {
        return AttractionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AttractionViewHolder, position: Int) {
        val attractionItem = getItem(position)
        holder.bind(attractionItem, listener)
    }

    class AttractionViewHolder(private var binding: ItemAttractionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(attraction: Attraction, listener: AttractionListener) {
            binding.attraction = attraction
            binding.listener = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): AttractionViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemAttractionBinding.inflate(layoutInflater, parent, false)
                return AttractionViewHolder(binding)
            }
        }
    }
}


class AttractionDiffCallback : DiffUtil.ItemCallback<Attraction>() {
    override fun areItemsTheSame(oldItem: Attraction, newItem: Attraction): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Attraction, newItem: Attraction): Boolean {
        return oldItem == newItem
    }
}

class AttractionListener(val clickListener: (attraction: Attraction) -> Unit) {
    fun onClick(attraction: Attraction) = clickListener(attraction)
}