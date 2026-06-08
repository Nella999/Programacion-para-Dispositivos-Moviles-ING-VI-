/*
Descripción: Mostrar un Toast al hacer clic en una imagen
Autor: Brunella Alor Aquino
Fecha creación: 12 de Abril de 2026
Fecha última modificación: 12 de Abril de 2026
*/

package com.example.imagen

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagen = findViewById<ImageView>(R.id.miImagen)

        imagen.setOnClickListener {
            Toast.makeText(this, "Comedia/Romance - 1999", Toast.LENGTH_SHORT).show()
        }
    }
}