package com.example.gestioncontactos.screens
/**
 * Descripción: Formulario para agregar contacto
 */

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FormularioScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Guardar")
        }
    }
}
