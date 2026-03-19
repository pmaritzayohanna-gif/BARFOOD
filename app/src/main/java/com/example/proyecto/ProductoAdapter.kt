package com.example.proyecto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class ProductoAdapter(private val lista: List<Suplemento>) :
        RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> () {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgSuplemento)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreSuplemento)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecioSuplemento)
        val btnAgregar: Button = itemView.findViewById(R.id.btnAgregar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val suplemento = lista[position]

        holder.tvNombre.text = suplemento.nombre
        holder.tvPrecio.text = String.format(Locale.US, "$ %.2f", suplemento.precio)
        holder.img.setImageResource(suplemento.imagenResId)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetalleActivity::class.java).apply {
                putExtra("nombre", suplemento.nombre)
                putExtra("precio", suplemento.precio)
                putExtra("imagenResId", suplemento.imagenResId)
            }

            context.startActivity(intent)
        }
        holder.btnAgregar.setOnClickListener {
            CarritoManager.agregarProducto(suplemento)

            Toast.makeText(
                holder.itemView.context,
                "Producto agregado al carrito",
                Toast.LENGTH_SHORT
            ).show()

        }

    }

    override fun getItemCount(): Int = lista.size

}



}
