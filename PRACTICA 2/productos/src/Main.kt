/*
Descripción: Clase Producto con validación de precio y descuento, lectura de datos del usuario y cálculo de precio final.
Autor: Brunella Alor Aquino
Fecha de creación: 03/03/2026
Fecha de última modificación: 03/03/2026
*/
class Producto {
    //validación del precio
    var precio: Double = 0.0
        set(value) {
            if (value < 0) {
                println("Error: El precio no puede ser negativo.")
                field = 0.0
            } else {
                field = value
            }
        }
    // validación de descuento (0% - 100%)
    var descuento: Double = 0.0
        set(value) {
            if (value < 0) {
                println("Error: El descuento no puede ser menor a 0.")
                field = 0.0
            } else if (value > 100) {
                println("Error: El descuento no puede ser mayor a 100.")
                field = 100.0
            } else {
                field = value
            }
        }
    // Calcular el precio final
    fun precioFinal(): Double {
        return precio * (1 - (descuento / 100))
    }
}

fun main() {

    val newproducto = Producto()

    // Leer datos del usuario
    print("Ingrese el precio: ")
    val precioInput = readLine()!!.toDouble()

    print("Ingrese el descuento (%): ")
    val descuentoInput = readLine()!!.toDouble()

    // Asignar valores
    newproducto.precio = precioInput
    newproducto.descuento = descuentoInput

    // Mostrar resultados
    println("Precio: ${newproducto.precio}")
    println("Descuento: ${newproducto.descuento}%")
    println("Precio final: %.2f".format(newproducto.precioFinal()))

    // Caso de prueba con errores
    println("\n--- Prueba con valores inválidos ---")
    val productError = Producto()
    productError.precio = -50.0
    productError.descuento = 150.0

    println("Precio corregido: ${productError.precio}")
    println("Descuento corregido: ${productError.descuento}%")
    println("Precio final: %.2f".format(productError.precioFinal()))
}