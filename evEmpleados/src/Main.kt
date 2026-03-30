import javax.swing.DefaultListSelectionModel

/*
Descripción: Programa que calcula el salario que recibirá cada empleado y evaluará su rendimiento.
Autor: Brunella Alor Aquino
Fecha de creación: 29/03/2026
Fecha de última modificación: 29/03/2026
*/
fun main() {
    print("Ingrese su salario mensual: ") //Solo acepta numeros enteros
    val SM = readLine()!!.toInt()

    print("Ingrese su puntuación (0 a 10): ")
    val PE = readLine()!!.toInt()

    // Calcular el rendimiento del usuario
    val nivel = if (PE >= 0 && PE <= 3) {
        "Tu rendimiento es INACEPTABLE"
    } else if (PE >= 4 && PE <= 6) {
        "Tu rendimiento es ACEPTABLE"
    } else if (PE >= 7 && PE <= 10) {
        "Tu rendimiento es MERITORIO"
    } else {
        "PUNTUACIÓN INVÁLIDA"
    }

    // Calcular dinero de usuario
    val NSM = SM * (PE / 10.0)

    // Mostrar resultados
    println("$nivel")
    println("Cantidad de Dinero Recibido: $$NSM")
}