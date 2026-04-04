/*
Descripción: Clase producto que tiene precio y descuento aplicable
Autor: Brunella Alor Aquino
Fecha de creación: 03/04/2026
Fecha de última modificación: 04/04/2026
*/

class Producto {
    //validación con el setter
    var precio: Double = 0.0
        set(value) {
            if (value < 0) {
                println("Error: El precio no puede ser negativo.")
                field = 0.0 //reemplazar directamente
            } else {
                field = value
            }
        }
        get() = field

    // Descuento aplicable (0% a 100%)
    var descuento: Double = 0.0
        set(value) {
            field = when {
                value < 0 -> {
                    println("Error: El descuento no puede ser menor a 0.")
                    0.0
                }
                value > 100 -> {
                    println("Error: El descuento no puede ser mayor a 100.")
                    100.0
                }
                else -> value
            }
        }
        get() = field

    // Calcular el precio final
    fun PrecioFinal(): Double { return precio * (1 - (descuento / 100)) }
}

fun main() {
    val newProduct = Producto()

    // Leer datos insertados por el usuario
    print("Ingrese el precio del producto: ")
    newProduct.precio = readLine()!!.toDouble()
    print("Ingrese el descuento (%): ")
    newProduct.descuento = readLine()!!.toDouble()

    println("Precio: ${newProduct.precio}")
    println("Descuento: ${newProduct.descuento}%")
    println("Precio final: ${newProduct.PrecioFinal()}")

    println("============== Prueba de errores ==============")
    val productError = Producto()
    productError.precio = -50.0
    productError.descuento = 150.0

    println("Precio corregido: ${productError.precio}")
    println("Descuento corregido: ${productError.descuento}%")
}