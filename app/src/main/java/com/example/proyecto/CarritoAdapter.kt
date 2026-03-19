package com.example.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarritoAdapter(
    private val items: MutableList<Suplemento>,
    private val onCarritoChanged: () -> Unit
) : RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgCarrito)
        val nombre: TextView = itemView.findViewById(R.id.tvNombreCarrito)
        val precio: TextView = itemView.findViewById(R.id.tvPrecioCarrito)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carrito, parent, false)
        return ViewHolder(vista)
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]

            holder.nombre.text = item.nombre
            holder.precio.text = "$%.2f".format(item.precio)
            holder.img.setImageResource(item.imagenResId)

            holder.btnEliminar.setOnClickListener {
                val pos = holder.bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    items.removeAt(pos)
                    notifyItemRemoved(pos)
                    notifyItemRangeChanged(pos, items.size)
                    onCarritoChanged()


                }
            }
        }
        override fun getItemCount(): Int = items.size

}