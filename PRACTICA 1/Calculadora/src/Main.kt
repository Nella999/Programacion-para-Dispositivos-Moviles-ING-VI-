/*
Descripción: Calculadora básica con operaciones de suma, resta, multiplicación y división.
Autor: Brunella Alor Aquino
Fecha de creación: 29/03/2026
Fecha de última modificación: 29/03/2026
*/

fun main() {
    var opcion: Int
    //Menu para elegir opciones

    do {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        print("Elige una opción: ")
        opcion = readLine()!!.toInt()

        //Leer la opcion elegida por el usuario
        if (opcion >= 1 && opcion <= 4) {
            print("Ingrese un número: ")
            val num1 = readLine()!!.toDouble()

            print("Ingrese otro número: ")
            val num2 = readLine()!!.toDouble()

            var rpta= 0.0

            if (opcion == 1) {
                rpta = num1 + num2
            } else if (opcion == 2) {
                rpta = num1 - num2
            } else if (opcion == 3) {
                rpta = num1 * num2
            } else if (opcion == 4) {
                if (num2 == 0.0) {
                    println("No se puede dividir.")
                } else {
                    rpta = num1 / num2
                }
            }
            println("Resultado: $rpta")
        } else if (opcion == 5) {
            println("Adiós :)")
        } else {
            println("Opción inválida")
        }
        println()
    } while (opcion != 5)
}