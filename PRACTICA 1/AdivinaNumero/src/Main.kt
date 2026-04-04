/*
Descripción: Calculadora básica con operaciones de suma, resta, multiplicación y división.
Autor: Brunella Alor Aquino
Fecha de creación: 29/03/2026
Fecha de última modificación: 29/03/2026
*/
fun main() {
    //se especifican los valores
    val numaleatorio = (1..30).random()
    var intentos = 5
    // inicio 
    while (intentos > 0) {
        print("Adivina el número entre 1 y 30: ")
        val numusuario = readLine()!!.toInt()
        // acerta al numero
        if (numusuario == numaleatorio) {
            println("¡Felicidades! ")
            break
            // Pistas
        } else {
            if (numusuario < numaleatorio) {
                println("El número es mayor")
            } else {
                println("El número es menor")
            }
        }
        intentos = intentos - 1 //Reduce cada vez que se intenta
        println("Te quedan $intentos intentos")
    }
    //Despues de haber gastado todos los intentos 
    if (intentos == 0) {
        println("Game Over. El número era: $numaleatorio")
    }
}
