import 'package:flutter/material.dart';

class inicio extends StatelessWidget {
  const inicio({super.key}); //constructor de las clases

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //barra superior
      appBar: AppBar(
        title: const Text("Bienvenidos ! "),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            //centrar elementos de manera vertical
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text(
                "¡Hola! Conoce más sobre mí :) ",
                style: TextStyle(
                  fontSize: 22,
                ),
                textAlign: TextAlign.center,
              ),

              const SizedBox(height: 20),

              ElevatedButton(
                onPressed: () {}, //aun no existe una acción para el botón
                child: const Text("Ver mi perfil"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}