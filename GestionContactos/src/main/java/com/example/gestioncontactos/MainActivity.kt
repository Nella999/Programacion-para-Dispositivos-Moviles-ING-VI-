/**
 * Descripción: Punto de entrada de la app
 * Autor: Tu nombre
 * Fecha creación: 03/05/2026
 * Última modificación: 03/05/2026
 */

package com.example.gestioncontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gestioncontactos.navigation.NavManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavManager()
        }
    }
}