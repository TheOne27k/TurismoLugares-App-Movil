package com.cibertec.turismoapp.lugar

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cibertec.turismoapp.MapActivity
import com.cibertec.turismoapp.R
import com.google.android.material.button.MaterialButton

class LugarViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_lugar, parent, false)){
    private var imgLugar: ImageView? = null
    private var nombreLugar: TextView? = null
    private var descripcionLugar: TextView? = null
    private var precioLugar: TextView? = null
    private var disponibilidadLugar: TextView? = null
    private var btnUbicacion: MaterialButton? = null
    init {
        imgLugar = itemView.findViewById(R.id.ImgLugar)
        nombreLugar = itemView.findViewById(R.id.txtNombre)
        descripcionLugar = itemView.findViewById(R.id.txtDescripcion)
        precioLugar = itemView.findViewById(R.id.txtPrecio)
        disponibilidadLugar = itemView.findViewById(R.id.txtDisponibilidad)
        btnUbicacion = itemView.findViewById(R.id.btnUbicacion)
    }
    fun data(lugar: Lugar){
        nombreLugar?.text = lugar.nombreLugar
        descripcionLugar?.text = lugar.descripcionLugar
        precioLugar?.text = lugar.costoLugar
        disponibilidadLugar?.text = lugar.disponibilidadLugar
        imgLugar?.let {
            Glide.with(itemView.context)
                .load(lugar.imagenLugar)
                .placeholder(R.drawable.image)
                .into(it)
        }
        btnUbicacion?.setOnClickListener {
            val context = itemView.context
            val intent = Intent(context, MapActivity::class.java).apply {
                putExtra("LATITUDE", lugar.ubicacionLugar.latitude)
                putExtra("LONGITUDE", lugar.ubicacionLugar.longitude)
                putExtra("TITLE", lugar.nombreLugar)
                putExtra("DESCRIPTION", lugar.descripcionLugar)
                putExtra("IMAGE", lugar.imagenLugar)
            }
            context.startActivity(intent)
        }
    }

}