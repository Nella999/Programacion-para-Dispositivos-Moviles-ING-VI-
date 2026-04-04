/*
Descripción: Simular el juego entre el usuario y la computadora.
Autor: Brunella Alor Aquino
Fecha de creación: 29/03/2026
Fecha de última modificación: 29/03/2026
*/

fun main() {
    // Elección de la computadora
    val PC = listOf("papel", "piedra", "tijera").random()
    val usuario: String

    // Elección del usuario
    print("Elige entre piedra, papel o tijera: ")
    usuario = readLine()!!.toString()

    println("La computadora eligió: $PC")

    // Comparar resultados
    if (usuario == PC) {
        println("Es un Empate")
    } else if (usuario == "piedra" && PC == "tijera") {
        println("Felicidades, ganaste")
    } else if (usuario == "tijera" && PC == "papel") {
        println("Felicidades, ganaste")
    } else if (usuario == "papel" && PC == "piedra") {
        println("Felicidades, ganaste")
    } else if (usuario == "piedra" || usuario == "papel" || usuario == "tijera") {
        println("Lo siento, perdiste")
    } else {
        println("Opción inválida")
    }
}