package com.example.proyecto

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SuplementoAdapter(
    private val list: List<Suplemento>,
    private val onAgregarClick: (Suplemento) -> Unit
) : RecyclerView.Adapter<SuplementoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgSuplemento)
        val nombre: TextView = itemView.findViewById(R.id.tvNombreSuplemento)
        val precio: TextView = itemView.findViewById(R.id.tvPrecioSuplemento)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_suplemento, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suplemento = list[position]

        holder.nombre.text = suplemento.nombre
        holder.precio.text = "$%.2f".format(suplemento.precio)
        holder.img.setImageResource(suplemento.imagenResId)

        holder.itemView.setOnClickListener {
            onAgregarClick(suplemento)
        }

    }

    override fun getItemCount(): Int {
        return list.size

    }
}



