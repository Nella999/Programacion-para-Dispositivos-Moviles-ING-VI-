/*
Descripción:
Autor: Brunella Alor Aquino
Fecha de creación: 03/04/2026
Fecha de última modificación: 04/04/2026
*/


import kotlin.math.PI

// 1. Clase abstracta base
abstract class Shape {
    // Propiedades comunes
    var area: Double = 0.0
    var perimetro: Double = 0.0

    // Funciones abstractas (deben ser implementadas por las subclases)
    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    // Función común para imprimir resultados
    fun imprimirResultados(nombreFigura: String) {
        println("--- $nombreFigura ---")
        println("Área: ${"%.2f".format(area)}")
        println("Perímetro: ${"%.2f".format(perimetro)}\n")
    }
}

// 2. Subclase Cuadrado
class Cuadrado : Shape {
    var lado: Double = 0.0

    // Constructor secundario
    constructor(lado: Double) : super() {
        this.lado = lado
    }

    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = lado * 4
    }
}

// 3. Subclase Círculo
class Circulo : Shape {
    var radio: Double = 0.0

    // Constructor secundario
    constructor(radio: Double) : super() {
        this.radio = radio
    }

    override fun calcularArea() {
        area = PI * radio * radio
    }

    override fun calcularPerimetro() {
        perimetro = 2 * PI * radio
    }
}

// 4. Subclase Rectángulo
class Rectangulo : Shape {
    var base: Double = 0.0
    var altura: Double = 0.0

    // Constructor secundario
    constructor(base: Double, altura: Double) : super() {
        this.base = base
        this.altura = altura
    }

    override fun calcularArea() {
        area = base * altura
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)
    }
}

fun main() {
    // Crear instancias de las subclases
    val miCuadrado = Cuadrado(5.0)
    val miCirculo = Circulo(3.0)
    val miRectangulo = Rectangulo(4.0, 6.0)

    // Ejecutar operaciones y mostrar resultados
    miCuadrado.calcularArea()
    miCuadrado.calcularPerimetro()
    miCuadrado.imprimirResultados("Cuadrado")

    miCirculo.calcularArea()
    miCirculo.calcularPerimetro()
    miCirculo.imprimirResultados("Círculo")

    miRectangulo.calcularArea()
    miRectangulo.calcularPerimetro()
    miRectangulo.imprimirResultados("Rectángulo")
}