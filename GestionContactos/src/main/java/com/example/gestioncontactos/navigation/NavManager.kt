/**
 * Descripción: Manejo de navegación entre pantallas
 * Autor: Tu nombre
 * Fecha creación: 03/05/2026
 * Última modificación: 03/05/2026
 */

package com.example.gestioncontactos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.gestioncontactos.screens.*

@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "lista") {

        composable("lista") {
            ListaScreen(navController)
        }

        composable("formulario") {
            FormularioScreen(navController)
        }
    }
}