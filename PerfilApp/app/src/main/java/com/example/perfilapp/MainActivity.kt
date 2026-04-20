/*
Descripción: Conectar todas las pantallas
Autor: Brunella Alor Aquino
Inicio:19 de abril de 2026
Fin: 20 de abril de 2026
*/
package com.example.perfilapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var etNombre: EditText
    lateinit var etEdad: EditText
    lateinit var etCiudad: EditText
    lateinit var etCorreo: EditText

    // Para recibir resultado
    val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Conecta xml con kotlin
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)

        val btnContinuar = findViewById<Button>(R.id.btnContinuar)
        //"Cuando se haga click en el botón continuar se hará:"
        btnContinuar.setOnClickListener {
            //Se guarda
            val usuario = Usuario(
                etNombre.text.toString(),
                etEdad.text.toString(),
                etCiudad.text.toString(),
                etCorreo.text.toString()
            )
            //Se mueve a otra pantalla
            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("usuario", usuario)
            launcher.launch(intent)
        }
    }

    // Guardar datos si rota la pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", etNombre.text.toString())
        outState.putString("edad", etEdad.text.toString())
        outState.putString("ciudad", etCiudad.text.toString())
        outState.putString("correo", etCorreo.text.toString())
    }
    // Restaurar datos
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        etNombre.setText(savedInstanceState.getString("nombre"))
        etEdad.setText(savedInstanceState.getString("edad"))
        etCiudad.setText(savedInstanceState.getString("ciudad"))
        etCorreo.setText(savedInstanceState.getString("correo"))
    }
}