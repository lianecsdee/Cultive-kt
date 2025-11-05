package com.cultiveplus.cultiveplusapp.model
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cultiveplus.cultiveplusapp.databinding.ItemEstufaBinding


class EstufaAdapter(): ListAdapter<Estufa, EstufaAdapter.EstufaViewHolder>(EstufaDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EstufaViewHolder {
        val binding = ItemEstufaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EstufaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: EstufaViewHolder,
        position: Int
    ) {
        val user = getItem(position)
        holder.bind(user)

//        holder.itemView.setOnClickListener {
//            onItemClicked(user)
//        }
    }

    inner class EstufaViewHolder(private val binding: ItemEstufaBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(estufa: Estufa){
            binding.tvNomeEstufa.text = estufa.nome
//            binding.tvName.text = estufa.name
//            binding.tvEmail.text = estufa.email
        }
    }

    private class EstufaDiffCallback: DiffUtil.ItemCallback<Estufa>(){
        override fun areItemsTheSame(oldItem: Estufa, newItem: Estufa): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Estufa, newItem: Estufa): Boolean {
            return oldItem == newItem
        }
    }
}