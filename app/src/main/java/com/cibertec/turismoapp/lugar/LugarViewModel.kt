package com.cibertec.turismoapp.lugar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint

class LugarViewModel: ViewModel() {
    private lateinit var firestore: FirebaseFirestore
    val lugarListMutable = MutableLiveData<List<Lugar>>()
    var lugarList = arrayListOf<Lugar>()

    fun getLugar(){
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("lugares")
            .get()
            .addOnSuccessListener { result ->
                val listLugar = mutableListOf<Lugar>()
                for(document in result) {
                    val id = document.id
                    val data = document.data

                    val nombreLugar = data["nombre"] as String
                    val descripcionLugar = data["descripcion"] as String
                    val imagenLugar = data["imagen"] as String
                    val ubicacionLugar = data["ubicacion"] as GeoPoint
                    val disponibilidadLugar = data["disponibilidad"] as String
                    val costoLugar = data["costo"] as String


                    val lugar = Lugar(nombreLugar, descripcionLugar, imagenLugar, ubicacionLugar, disponibilidadLugar, costoLugar)
                    lugarList.add(lugar)
                }
                lugarListMutable.value = lugarList
            }
            .addOnFailureListener {
                lugarListMutable.value = emptyList()
            }
    }
}