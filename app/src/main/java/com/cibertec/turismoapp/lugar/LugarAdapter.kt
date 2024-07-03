package com.cibertec.turismoapp.lugar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LugarAdapter(): RecyclerView.Adapter<LugarViewHolder>() {
    private var lugarList = emptyList<Lugar>()
    fun setLugar(lugar: List<Lugar>){
        lugarList = lugar
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LugarViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = lugarList.size

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar: Lugar = lugarList[position]
        holder.data(lugar)
    }
}