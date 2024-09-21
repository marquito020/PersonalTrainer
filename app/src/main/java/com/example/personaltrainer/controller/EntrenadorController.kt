package com.example.personaltrainer.controller

import com.example.personaltrainer.model.Entrenador

class EntrenadorController {

    private val entrenadores = mutableListOf<Entrenador>()

    fun registrarEntrenador(entrenador: Entrenador) {
        entrenadores.add(entrenador)
        println("Entrenador registrado: ${entrenador.nombre}")
    }

    fun validarDatos(
        nombre: String,
        telefono: String,
        usuario: String,
        password: String
    ): Boolean {
        return nombre.isNotEmpty() &&
                telefono.isNotEmpty() &&
                usuario.isNotEmpty() &&
                password.length >= 6
    }
}
