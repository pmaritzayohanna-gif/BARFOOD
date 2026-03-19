package com.example.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AccesoriosAdapter(
    private val lista: List<Accesorio>,
    private val onAgregarClick: (Accesorio) -> Unit
) : RecyclerView.Adapter<AccesoriosAdapter.ViewHolder> () {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgAccesorio)
        val nombre: TextView = itemView.findViewById(R.id.tvNombreAccesorio)
        val precio: TextView = itemView.findViewById(R.id.tvPrecioAccesorio)
        val btnAgregar: Button = itemView.findViewById(R.id.btnAgregarAccesorio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_accesorio, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val accesorio = lista[position]

        holder.nombre.text = accesorio.nombre
        holder.precio.text = "$ " + "%.2f".format(accesorio.precio)
        holder.img.setImageResource(accesorio.imagen)

        holder.btnAgregar.setOnClickListener {
            onAgregarClick(accesorio)
        }

    }

    override fun getItemCount(): Int = lista.size

}