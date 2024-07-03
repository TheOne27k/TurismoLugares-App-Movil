package com.cibertec.turismoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.turismoapp.lugar.LugarAdapter
import com.cibertec.turismoapp.lugar.LugarViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var lugarViewModel: LugarViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lugarViewModel = ViewModelProvider(this)[LugarViewModel::class.java]
        val recyclerLugar = findViewById<RecyclerView>(R.id.recyclerLugares)
        val adapter = LugarAdapter()
        recyclerLugar.adapter = adapter
        recyclerLugar.layoutManager = LinearLayoutManager(this)
        lugarViewModel.getLugar()
        lugarViewModel.lugarListMutable.observe(this){
            if(it.isNotEmpty()){
                adapter.setLugar(it)
            }
        }
    }
}