package com.example.gestioncontactos.screens
/**
 * Descripción: Muestra lista de contactos
 */
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestioncontactos.model.Contacto
import androidx.compose.ui.graphics.Color
@Composable
fun ListaScreen(navController: NavController) {

    var lista by remember {
        mutableStateOf(
            listOf(
                Contacto("Ana", "923456789"),
                Contacto("Luis", "987654321")
            )
        )
    }

    val listaOrdenada = lista.sortedByDescending { it.favorito }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("formulario")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->
        if (lista.isEmpty()) {
            Text("No hay contactos")
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(listaOrdenada) { contacto ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {
                            Text(contacto.nombre)
                            Text(contacto.telefono)
                        }

                        Row {
                            IconButton(onClick = {
                                lista = lista.map {
                                    if (it == contacto)
                                        it.copy(favorito = !it.favorito)
                                    else it
                                }
                            }) {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = "Favorito",
                                    tint = if (contacto.favorito) Color.Yellow else Color.Gray)
                            }

                            IconButton(onClick = {
                                lista = lista.filter { it != contacto }
                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}
