package com.example.examenkotlin.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examenkotlin.databinding.ItemPaisBinding
import com.example.examenkotlin.domain.Pais

class PaisViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemPaisBinding.bind(view)
    private lateinit var pais: Pais


    fun render(item: Pais, onClickListener: (Pais) -> Unit) {
        binding.tvNombrePais.text = item.pais
        binding.ivUE.setImageResource(item.ue)
        binding.ivbandera.setImageResource(item.bandera)
        itemView.setOnClickListener {
            onClickListener(item)
        }
        pais = item
    }
}