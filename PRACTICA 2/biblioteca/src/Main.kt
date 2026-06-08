/*
Descripción: Sistema de gestión para una biblioteca
Autor: Brunella Alor Aquino
Fecha de inicio: 04/04/26
Fecha de ultima modificación: 04/04/26
 */

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}
class Libro( //subclase de Material
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo | Autor: $autor | Género: $genero | Páginas: $numPaginas | Año de Publicación : $anioPublicacion")
    }
}
//subclase de material
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
        println("Revista: $titulo | Editorial: $editorial | ISSN: $issn | Vol: $volumen N°: $numero | Año de Publicacion : $anioPublicacion")
    }
}

// dataclass usuario
data class Usuario(val nombre: String, val apellido: String, val edad: Int)
//Interfaz que contiene los metodos
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material)
    fun devolucion(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}
//Clase que implementa lo de la interfaz
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosRegistrados = mutableListOf<Usuario>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()
    //Agregar libros
    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material: '${material.titulo}' registrado en el catálogo.")
    }
    //Agregar usuarios
    override fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
        println("Usuario: ${usuario.nombre} ${usuario.apellido} registrado.")
    }
    // Registrar prestamo
    override fun prestamo(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material) //eliminar del catálogo
            //crear historial del usuario y agrega el material prestado
            prestamos.getOrPut(usuario) { mutableListOf() }.add(material)
            println("'${material.titulo}' ha sido prestado a ${usuario.nombre}.")
        } else {
            println("El material '${material.titulo}' no está disponible.")
        }
    }
    // Registrar devolución
    override fun devolucion(usuario: Usuario, material: Material) {
        val librosPrestados = prestamos[usuario] // verifica si el usuario tiene prestamos
        // el usuario tiene el libro en sus prestamos
        if (librosPrestados != null && librosPrestados.contains(material)) {
            librosPrestados.remove(material) //elimina el libro
            materialesDisponibles.add(material) // se agrega al catalogo
            println(" ${usuario.nombre} devolvió '${material.titulo}'.")
        } else {
            println("${usuario.nombre} no tiene ese material en préstamo.")
        }
    }
    // Muestra el catalogo
    override fun mostrarMaterialesDisponibles() {
        println("\n--- LIBROS DISPONIBLES ---")
        if (materialesDisponibles.isEmpty()) { // verifica si hay o no libros
            println("No hay libros en el catálogo.") // en caso de no
        }
        else materialesDisponibles.forEach { // recorrer toda la lista
            it.mostrarDetalles()
        }
    }
    //Muestra los prestamos del usuario
    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("\n--- PRÉSTAMOS : ${usuario.nombre.uppercase()} ---")
        val listaLibros = prestamos[usuario]
        if (listaLibros.isNullOrEmpty()) { // si el usuario no tiene prestamos
            println(" ${usuario} no tiene préstamos.")
        }
        else listaLibros.forEach {
            println("- ${it.titulo}") // si el usuario tiene prstamos, se mostrará la lista de material
        }
    }
}
fun main() {
    val BibliotecaSistema = Biblioteca()
    //Crea los materiales/libros
    val libro1 = Libro("El Quijote", "Cervantes", 1605, "Clásico", 500)
    val revista1 = Revista("National Geographic", "Varios", 2023, "0027-9358", 150, 12, "Disney Mag.")

    //Crear Usuarios
    val usuario1 = Usuario("Nella", "Alor", 20)

    //Registrar usuario y material en el sistema
    BibliotecaSistema.registrarMaterial(libro1)
    BibliotecaSistema.registrarMaterial(revista1)
    BibliotecaSistema.registrarUsuario(usuario1)

    // Operaciones
    BibliotecaSistema.mostrarMaterialesDisponibles()
    println("\n Registrando")
    BibliotecaSistema.prestamo(usuario1, libro1)
    BibliotecaSistema.mostrarMaterialesDisponibles()
    BibliotecaSistema.mostrarMaterialesReservadosPorUsuario(usuario1)

    println("\nProceso de devolución")
    BibliotecaSistema.devolucion(usuario1, libro1)
    BibliotecaSistema.mostrarMaterialesDisponibles()
}