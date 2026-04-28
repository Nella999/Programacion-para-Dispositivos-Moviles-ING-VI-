/*
Descripción: Se inicializan los datos que recibirá la app
Autor: Brunella Alor Aquino
Inicio:19 de abril de 2026
Fin: 20 de abril de 2026
*/
package com.example.perfilapp

import java.io.Serializable //Para poder enviar en varias pantallas

data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable