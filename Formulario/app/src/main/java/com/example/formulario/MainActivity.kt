/*
Descripción: Formulario Mejorado con componentes Compose
Autor: Brunella Alor Aquino
Inicio:27 de abril de 2026
Fin: 27 de abril de 2026
*/
package com.example.formulario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Formulario()
        }
    }
}

@Composable
fun Formulario() {

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    var genero by remember { mutableStateOf("Masculino") }
    var terminos by remember { mutableStateOf(false) }
    var activo by remember { mutableStateOf(false) }
    var nivel by remember { mutableStateOf(0f) }

    var resultado by remember { mutableStateOf("") } //guarda y muestra el resultado
    var registrado by remember { mutableStateOf(false) } //Verificar si es está registrado o no

    val nombreValido = nombre.isNotBlank()//validar texto
    val edadValida = edad.all { it.isDigit() } && edad.isNotBlank()//validar solo digitos
    val correoValido = correo.contains("@")//Debe tener si o si ´@´
    val formularioValido =
        nombreValido && edadValida && correoValido && terminos //revisa el formulario

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Formulario de Registro :)",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF6A1B9A)
        )

        Text(
            text = "Complete sus datos",
            style = MaterialTheme.typography.bodyMedium
        )
        //Cajas
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Género", fontWeight = FontWeight.Bold)

        //Boton de "masculino" y "femenino"
        Row(verticalAlignment = Alignment.CenterVertically) {
           //Selección de opciones
            RadioButton(
                selected = genero == "Masculino",
                onClick = { genero = "Masculino" }
            )
            Text("Masculino")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = genero == "Femenino",
                onClick = { genero = "Femenino" }
            )
            Text("Femenino")
        }
        //Casilla de selección
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = terminos,
                onCheckedChange = { terminos = it }
            )
            Text("Aceptar términos")
        }
        //Casilla de selección
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Usuario Activo")
            Switch(
                checked = activo,
                onCheckedChange = { activo = it }
            )
        }
        //Barra deslizadora
        Text(
            text = "Nivel: ${nivel.toInt()}",
            fontWeight = FontWeight.Bold
        )

        Slider(
            value = nivel,
            onValueChange = { nivel = it },
            valueRange = 0f..10f
        )

        Button(
            onClick = {
                resultado =
                    "Usuario $nombre, $edad años, ${if (activo) "Activo" else "Inactivo"}, nivel ${nivel.toInt()}"
                registrado = true
            },
            enabled = formularioValido,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50)
            ), //cambia de color el boton cuando es true
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
        //Limpiar
        Button(
            onClick = {
                nombre = ""
                edad = ""
                correo = ""
                genero = "Masculino"
                terminos = false
                activo = false
                nivel = 0f
                resultado = ""
                registrado = false
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF44336)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpiar")
        }

        if (registrado) {
            Text(
                text = "Se registró correctamente",
                color = Color(0xFF2E7D32),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = resultado,
                color = Color(0xFF1565C0),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}