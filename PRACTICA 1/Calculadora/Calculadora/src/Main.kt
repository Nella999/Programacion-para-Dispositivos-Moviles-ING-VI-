/*
Descripción: Calculadora básica con operaciones de suma, resta, multiplicación y división.
Autor: Nella
Fecha de creación: 29/03/2026
Fecha de última modificación: 29/03/2026
*/

fun main() {

    var opcion: Int
    do {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        print("Elige una opción: ")
        opcion = readLine()!!.toInt()

        if (opcion in 1..4) {
            print("Ingrese el primer número: ")
            val a = readLine()!!.toDouble()

            print("Ingrese el segundo número: ")
            val b = readLine()!!.toDouble()

            val resultado = if (opcion == 1) {
                a + b
            } else if (opcion == 2) {
                a - b
            } else if (opcion == 3) {
                a * b
            } else {
                if (b == 0.0) {
                    println("No se puede dividir entre 0")
                    continue
                }
                a / b
            }

            println("Resultado: $resultado")

        } else if (opcion == 5) {
            println("Saliendo del programa...")
        } else {
            println("Opción inválida")
        }

        println()

    } while (opcion != 5)
}