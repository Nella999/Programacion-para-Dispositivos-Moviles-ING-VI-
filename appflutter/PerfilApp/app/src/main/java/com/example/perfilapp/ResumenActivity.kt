/*
Descripción: Mostrar el resumen de los datos ingresados
Autor: Brunella Alor Aquino
Inicio:19 de abril de 2026
Fin: 20 de abril de 2026
*/
package com.example.perfilapp
import android.app.Activity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val tvResumen = findViewById<TextView>(R.id.tvResumen)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)
        // Se recupera los datos de la otra pantalla
        val usuario = intent.getSerializableExtra("usuario") as Usuario

        //Imprime resultados
        tvResumen.text = """
            Nombre: ${usuario.nombre}
            Edad: ${usuario.edad}
            Ciudad: ${usuario.ciudad}
            Correo: ${usuario.correo}
        """.trimIndent()
        //Boton de confirmar
        btnConfirmar.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        btnEditar.setOnClickListener {
            finish()
        }
    }
}