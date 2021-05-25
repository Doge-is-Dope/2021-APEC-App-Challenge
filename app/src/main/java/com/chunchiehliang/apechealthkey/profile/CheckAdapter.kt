package com.chunchiehliang.apechealthkey.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chunchiehliang.apechealthkey.databinding.ItemCheckBinding
import com.chunchiehliang.apechealthkey.models.Check


class CheckListAdapter(private val listener: CheckListener) :
    ListAdapter<Check, CheckListAdapter.CheckViewHolder>(CheckDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckViewHolder {
        return CheckViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CheckViewHolder, position: Int) {
        val electionItem = getItem(position)
        holder.bind(electionItem, listener)
    }

    class CheckViewHolder(private var binding: ItemCheckBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(check: Check, listener: CheckListener) {
            binding.check = check
            binding.listener = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CheckViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCheckBinding.inflate(layoutInflater, parent, false)
                return CheckViewHolder(binding)
            }
        }
    }
}


class CheckDiffCallback : DiffUtil.ItemCallback<Check>() {
    override fun areItemsTheSame(oldItem: Check, newItem: Check): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Check, newItem: Check): Boolean {
        return oldItem == newItem
    }
}

class CheckListener(val clickListener: (check: Check) -> Unit) {
    fun onClick(check: Check) = clickListener(check)
}