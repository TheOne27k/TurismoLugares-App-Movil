package com.cibertec.turismoapp.lugar

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.cibertec.turismoapp.R
import com.google.firebase.firestore.GeoPoint

data class Lugar(
    val nombreLugar: String,
    val descripcionLugar: String,
    val imagenLugar: String,
    val ubicacionLugar: GeoPoint,
    val disponibilidadLugar: String,
    val costoLugar: String
)
