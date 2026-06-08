import 'package:flutter/material.dart';
import 'inicio.dart';
import 'perfil.dart';
import 'hobbies.dart';

void main() {
  runApp(const MyApp());
}
//Define App principal
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Mi App Personal',
// para poder probar las diferentes interfaces debe probarse una a una
      //home: inicio(),
      //home: perfil(),
      home: hobbies(),
    );
  }
}