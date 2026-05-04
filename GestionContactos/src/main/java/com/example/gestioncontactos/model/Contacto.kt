package com.example.gestioncontactos.model

/**
 * Descripción: Modelo de datos para un contacto
 * Autor: Tu nombre
 * Fecha creación: 03/05/2026
 * Última modificación: 03/05/2026
 */
data class Contacto(
    val nombre: String,
    val telefono: String,
    val favorito: Boolean = false
)