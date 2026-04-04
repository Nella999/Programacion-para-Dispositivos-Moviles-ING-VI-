/*
Descripción:
Autor: Brunella Alor Aquino
Fecha de creación: 03/04/2026
Fecha de última modificación: 04/04/2026
*/


// --- CLASES BASE Y DERIVADAS ---
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("LIBRO: $titulo | Autor: $autor | Género: $genero | Páginas: $numPaginas ($anioPublicacion)")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("REVISTA: $titulo | Editorial: $editorial | ISSN: $issn | Vol: $volumen N°: $numero ($anioPublicacion)")
    }
}

// --- DATA CLASS PARA USUARIO ---
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material)
    fun devolucion(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosRegistrados = mutableListOf<Usuario>()
    // Mapa: Usuario -> Lista de materiales que tiene prestados
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Sistema: '${material.titulo}' registrado en el catálogo.")
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
        println("Sistema: Usuario ${usuario.nombre} ${usuario.apellido} registrado.")
    }

    override fun prestamo(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            // Agregamos al mapa (si el usuario no existe en el mapa, creamos su lista)
            prestamos.getOrPut(usuario) { mutableListOf() }.add(material)
            println("Éxito: '${material.titulo}' prestado a ${usuario.nombre}.")
        } else {
            println("Error: El material '${material.titulo}' no está disponible.")
        }
    }

    override fun devolucion(usuario: Usuario, material: Material) {
        val listaPrestada = prestamos[usuario]
        if (listaPrestada != null && listaPrestada.contains(material)) {
            listaPrestada.remove(material)
            materialesDisponibles.add(material)
            println("Éxito: ${usuario.nombre} devolvió '${material.titulo}'.")
        } else {
            println("Error: ${usuario.nombre} no tiene ese material en préstamo.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("\n--- CATÁLOGO DE MATERIALES DISPONIBLES ---")
        if (materialesDisponibles.isEmpty()) println("No hay materiales en estantería.")
        else materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("\n--- PRÉSTAMOS ACTIVOS: ${usuario.nombre.uppercase()} ---")
        val lista = prestamos[usuario]
        if (lista.isNullOrEmpty()) println("Este usuario no tiene préstamos.")
        else lista.forEach { println("- ${it.titulo}") }
    }
}

fun main() {
    val miBiblioteca = Biblioteca()

    // 1. Crear Materiales e Instancias
    val libro1 = Libro("El Quijote", "Cervantes", 1605, "Clásico", 500)
    val revista1 = Revista("National Geographic", "Varios", 2023, "0027-9358", 150, 12, "Disney Mag.")

    // 2. Crear Usuarios
    val usuario1 = Usuario("Avril", "Sánchez", 20)

    // 3. Registrar en el sistema
    miBiblioteca.registrarMaterial(libro1)
    miBiblioteca.registrarMaterial(revista1)
    miBiblioteca.registrarUsuario(usuario1)

    // 4. Operaciones
    miBiblioteca.mostrarMaterialesDisponibles()

    println("\n>>> Iniciando trámites...")
    miBiblioteca.prestamo(usuario1, libro1)

    miBiblioteca.mostrarMaterialesDisponibles()
    miBiblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    println("\n>>> Proceso de devolución...")
    miBiblioteca.devolucion(usuario1, libro1)
    miBiblioteca.mostrarMaterialesDisponibles()
}