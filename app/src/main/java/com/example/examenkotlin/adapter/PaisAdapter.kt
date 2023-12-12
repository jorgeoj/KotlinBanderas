package com.example.examenkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenkotlin.R
import com.example.examenkotlin.domain.Pais

class PaisAdapter(private val paisList:List<Pais>, private val onClickListener: (Pais) -> Unit) : RecyclerView.Adapter<PaisViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  PaisViewHolder(layoutInflater.inflate(R.layout.item_pais, parent, false))
    }

    override fun getItemCount(): Int = paisList.size

    override fun onBindViewHolder(holder: PaisViewHolder, position: Int) {
        val item = paisList[position]
        holder.render(item, onClickListener)
    }
}