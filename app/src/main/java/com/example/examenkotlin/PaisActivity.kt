package com.example.examenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PaisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pais)

        val posicion = intent.getIntExtra("posicion", 0)
        val nombrePais = intent.getStringExtra("pais")
        val bandera = intent.getIntExtra("bandera", 0)
        val ue = intent.getIntExtra("ue", 0)
        val miembro = intent.getBooleanExtra("miembro", false)
        val mapa = intent.getIntExtra("mapa", 0)
        val habitantes = intent.getStringExtra("habitantes")
        val capital = intent.getStringExtra("capital")

        //Poner el nombre del pais
        val pais = findViewById<TextView>(R.id.tvPais)
        pais.setText(nombrePais)
        //Poner la imagen del pais
        val imgPais = findViewById<ImageView>(R.id.ivBanderaPais)
        imgPais.setImageResource(bandera)
        //Poner la imagen de la ue
        val imgUe = findViewById<ImageView>(R.id.ivUnionEuropea)
        if(miembro){
            imgUe.setImageResource(R.drawable.europe)
        }else{
            imgUe.setImageResource(R.drawable.europa)
        }

        //Poner el texto de si es miembro o no de la UE
        val txtUnionEuropea = findViewById<TextView>(R.id.tvMiembro)
        if (miembro){
            txtUnionEuropea.setText(R.string.es_miembro)
        }else{
            txtUnionEuropea.setText(R.string.no_es_miembro)
        }
        //Poner la imagen del mapa del pais
        val imgMapaPais = findViewById<ImageView>(R.id.ivMapa)
        imgMapaPais.setImageResource(mapa)
        //Poner el numero de habitantes
        val numHabitantes = findViewById<TextView>(R.id.tvHabitantes)
        numHabitantes.setText("Habitantes: $habitantes")
        //Poner la capital
        val capitalPais = findViewById<TextView>(R.id.tvCapital)
        capitalPais.setText("Capital: $capital")
        //Boton para volver
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }
    }
}