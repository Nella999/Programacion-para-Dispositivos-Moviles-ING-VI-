/*
Descripcion : Clases que tengan distintas funciones para diferentes figuras geometricas.
Autor: Brunella Alor Aquino
Fecha de inicio: 04/04/26
Fecha de ultima modificación: 04/04/26
*/

import kotlin.math.PI

// Clase abstracta shape
abstract class Shape {
    var area: Double = 0.0
    var perimetro: Double = 0.0

    // Funciones abstractas
    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    fun imprimirResultados(nombreFigura: String) {
        println("--- $nombreFigura ---")
        println("Área: $area")
        println("Perímetro: $perimetro\n")
    }
}
// Subclase Cuadrado
class Cuadrado (var lado: Double) : Shape() { //Clase herencia de shape
    // Calculando area del cuadrado
    override fun calcularArea() {
        area = lado * lado
    }
    // Calculando perimetro del cuadrado
    override fun calcularPerimetro() {
        perimetro = lado * 4
    }
}
// Subclase Círculo
class Circulo (var radio: Double): Shape() {
    // Calculando area del circulo
    override fun calcularArea() {
        area = PI * radio * radio
    }
    // Calculando perimetro del circulo
    override fun calcularPerimetro() {
        perimetro = 2 * PI * radio
    }
}
// Subclase Rectángulo
class Rectangulo (var base: Double ,var altura: Double): Shape() {
    // Calculando area del rectangulo
    override fun calcularArea() {
        area = base * altura
    }
    // Calculando perimetro del rectangulo
    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)
    }
}
fun main() {
    println("Elige una figura:")
    println("1. Cuadrado")
    println("2. Círculo")
    println("3. Rectángulo")

    print("Opción: ")
    val opcion = readLine()!!.toInt()

    if (opcion == 1) {
        print("Ingrese el valor 'lado': ")
        val ladoA = readLine()!!.toDouble()

        val cuadrado = Cuadrado(ladoA)
        cuadrado.calcularArea()
        cuadrado.calcularPerimetro()
        cuadrado.imprimirResultados("Cuadrado")

    } else if (opcion == 2) {
        print("Ingrese el radio: ")
        val radio = readLine()!!.toDouble()

        val circulo = Circulo(radio)
        circulo.calcularArea()
        circulo.calcularPerimetro()
        circulo.imprimirResultados("Círculo")

    } else if (opcion == 3) {
        print("Ingrese el valor de la base: ")
        val ladoA = readLine()!!.toDouble()

        print("Ingrese el valor de la altura: ")
        val ladoB = readLine()!!.toDouble()

        val rectangulo = Rectangulo(ladoA, ladoB)
        rectangulo.calcularArea()
        rectangulo.calcularPerimetro()
        rectangulo.imprimirResultados("Rectángulo")

    } else {
        println("Opción inválida")
    }
}