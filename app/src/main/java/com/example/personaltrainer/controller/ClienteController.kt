package com.example.personaltrainer.controller

import com.example.personaltrainer.model.Cliente

class ClienteController {

    private val clientes = mutableListOf<Cliente>()

    fun registrarCliente(cliente: Cliente) {
        clientes.add(cliente)
        println("Cliente registrado: ${cliente.nombre}")
    }

    fun validarDatos(
        nombre: String,
        peso: Float,
        altura: Float,
        telefono: String,
        usuario: String,
        password: String
    ): Boolean {
        return nombre.isNotEmpty() &&
                peso > 0 &&
                altura > 0 &&
                telefono.isNotEmpty() &&
                usuario.isNotEmpty() &&
                password.length >= 6
    }
}
