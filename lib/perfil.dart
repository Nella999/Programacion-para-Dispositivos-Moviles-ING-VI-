import 'package:flutter/material.dart';

class perfil extends StatelessWidget {
  const perfil({super.key}); //constructor de la clase

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mi Perfil"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          children: [
//Se agregó un permiso dentro de pubspec para poder instalar los
// paquetes de assets y colocar una foto desde mi ordenador
            Image.asset(
              "assets/mifoto.jpeg",
              height: 200,
            ),

            const SizedBox(height: 20),

            const Text(
              "Nella Alor",
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),

            const SizedBox(height: 10),

            const Text(
              "Estudiante de Ingeniería de Software. Me gusta el arte, crear, y aprender nuevas tecnologías.",
              textAlign: TextAlign.center,
            ),

            const SizedBox(height: 20),
//Para organizar los elementos de manera horizontal
            Row(
              children: const [
                Icon(Icons.email), //icono de correo
                SizedBox(width: 10),
                Text("balora@ulasalle.edu.pe"),
              ],
            ),

            const SizedBox(height: 10),

            Row(
              children: const [
                Icon(Icons.phone),
                SizedBox(width: 10),
                Text("963425551"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}