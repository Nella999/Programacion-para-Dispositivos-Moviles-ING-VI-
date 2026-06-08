import 'package:flutter/material.dart';

class hobbies extends StatelessWidget {
  const hobbies({super.key}); //constructor de la clase

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mis Hobbies"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          children: [
// Ordenar los hobbies de manera horizontal
            Row(
              children: const [
                Icon(Icons.book),
                SizedBox(width: 10),
                Text("Escribir poemas"),
              ],
            ),

            SizedBox(height: 20),

            Row(
              children: const [
                Icon(Icons.music_note),
                SizedBox(width: 10),
                Text("Descubrir nuevos artistas musicales"),
              ],
            ),

            SizedBox(height: 20),

            Row(
              children: const [
                Icon(Icons.sports_soccer),
                SizedBox(width: 10),
                Text("Practicar basquetball"),
              ],
            ),

            SizedBox(height: 20),

            Row(
              children: const [
                Icon(Icons.art_track),
                SizedBox(width: 10),
                Text("Dibujar o pintar"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}