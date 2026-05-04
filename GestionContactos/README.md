# Gestor de Contactos con Favoritos

## Descripción

Aplicación móvil desarrollada en **Kotlin** utilizando **Jetpack Compose**.
Permite visualizar una lista de contactos, marcarlos como favoritos , eliminarlos ️ y navegar a un formulario para registrar nuevos contactos.

##  Funcionalidades

Mostrar lista de contactos
Marcar / desmarcar favoritos 
Eliminar contactos 
Ordenar favoritos al inicio
Navegación entre pantallas
Interfaz simple e intuitiva

---

## Estructura del proyecto

```
com.example.gestioncontactos
│
├── model
│   └── Contacto.kt
├── screens
│   ├── ListaScreen.kt
│   └── FormularioScreen.kt
├── navigation
│   └── NavManager.kt
└── MainActivity.kt

---

##Tecnologías utilizadas

* Kotlin
* Jetpack Compose
* Navigation Compose
* Material Design 3

---

##  Limitaciones

* No se almacenan contactos nuevos (estado local con `remember`)
* No se utiliza ViewModel en esta práctica
---

## Posibles mejoras

* Implementar ViewModel para estado global
* Guardar contactos en base de datos (Room)
* Validación de campos en formulario
* Diseño UI más avanzado
* Búsqueda de contactos

---

## 👩‍Autor

* Nombre: Brunella Alor Aquino
* Curso: Programación para Dispositivos Moviles
* Fecha: 03-05-2026
