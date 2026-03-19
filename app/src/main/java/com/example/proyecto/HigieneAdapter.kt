package com.example.proyecto

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class HigieneAdapter(private val lista: List<String>):
        RecyclerView.Adapter<HigieneAdapter.ViewHolder>() {

    class ViewHolder(itemView: android.view.View) :
        RecyclerView.ViewHolder(itemView) {

            val textView: TextView =
                itemView.findViewById(R.id.tvNombreProducto)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val textView = LayoutInflater.from(parent.context)
           .inflate(R.layout.item_higiene,parent, false)
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = lista[position]
    }

    override fun getItemCount(): Int = lista.size

    }
