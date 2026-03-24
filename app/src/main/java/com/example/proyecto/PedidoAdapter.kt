package com.example.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PedidoAdapter (
    private val lista: MutableList<Pedido>,
    private val onEliminarClick: (Int) -> Unit
) : RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById<TextView>(R.id.txtNombrePedido)
        val cantidad = view.findViewById<TextView>(R.id.txtCantidad)
        val btnEliminar = view.findViewById<Button>(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.item_pedido, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedido = lista[position]
        holder.nombre.text = pedido.nombre
        holder.cantidad.text = pedido.cantidad

        holder.btnEliminar.setOnClickListener {
            onEliminarClick(position)
        }
    }

    override fun getItemCount(): Int = lista.size

}
