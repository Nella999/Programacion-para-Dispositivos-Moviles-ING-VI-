# Práctica 4: Comunicación entre Actividades

## Autor
Brunella Alor

## Fecha
20 de abril de 2026

## Descripción
App desarrollada en Kotlin usando Android Studio, la app permite ingresar datos de un usuario, mostrarlo en pantalla y confirmar si los datos son correctos

---

## Funcionalidades

### FormularioActivity (MainActivity)

* Permite ingresar:
    * Nombre
    * Edad
    * Ciudad
    * Correo electrónico
* Botón **“Continuar”**:
    * Envía los datos a la siguiente actividad usando `Intent`

---

### ResumenActivity
* Muestra los datos ingresados
* Incluye dos botones:
    * **Confirmar**
        * Regresa a la pantalla anterior
        * Muestra un mensaje: *“Perfil guardado correctamente”*
    *  **Volver a editar**
        * Permite modificar los datos

---

## Conceptos aplicados
* Envío de datos con `Intent`
* Uso de `Serializable` para objetos (clase `Usuario`)
* Comunicación entre actividades con `registerForActivityResult`
* Uso de `Toast`
* Manejo de rotación de pantalla con `onSaveInstanceState`

---

## Estructura del proyecto
* `MainActivity.kt` → Formulario de usuario
* `ResumenActivity.kt` → Vista de resumen
* `Usuario.kt` → Clase de datos

---

## Notas
* Se utilizó un diseño simple centrado
* Se personalizaron botones con color lavanda y tipografía tipo serif

---

## Resultado
La aplicación permite una interacción básica entre pantallas, simulando un flujo real de validación de datos de usuario.
