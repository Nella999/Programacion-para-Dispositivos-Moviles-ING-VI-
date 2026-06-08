import 'package:flutter/material.dart';

class inicio extends StatelessWidget {
  const inicio({super.key});

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
                onPressed: () {},
                child: const Text("Ver mi perfil"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}