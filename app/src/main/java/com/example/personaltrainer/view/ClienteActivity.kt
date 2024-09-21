package com.example.personaltrainer.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.R
import com.example.personaltrainer.controller.ClienteController
import com.example.personaltrainer.model.Cliente

class ClienteActivity : AppCompatActivity() {

    private lateinit var nombreInput: EditText
    private lateinit var pesoInput: EditText
    private lateinit var alturaInput: EditText
    private lateinit var telefonoInput: EditText
    private lateinit var usuarioInput: EditText
    private lateinit var passwordInput: EditText  // Cambiado a password
    private lateinit var btnRegistrar: Button
    private lateinit var clienteController: ClienteController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        clienteController = ClienteController()

        nombreInput = findViewById(R.id.nombreCliente)
        pesoInput = findViewById(R.id.pesoCliente)
        alturaInput = findViewById(R.id.alturaCliente)
        telefonoInput = findViewById(R.id.telefonoCliente)
        usuarioInput = findViewById(R.id.usuarioCliente)
        passwordInput = findViewById(R.id.passwordCliente)  // Cambiado a password
        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            registrarCliente()
        }
    }

    private fun registrarCliente() {
        val nombre = nombreInput.text.toString()
        val peso = pesoInput.text.toString().toFloatOrNull() ?: -1f
        val altura = alturaInput.text.toString().toFloatOrNull() ?: -1f
        val telefono = telefonoInput.text.toString()
        val usuario = usuarioInput.text.toString()
        val password = passwordInput.text.toString()  // Cambiado a password

        if (clienteController.validarDatos(nombre, peso, altura, telefono, usuario, password)) {
            val nuevoCliente = Cliente(nombre, peso, altura, telefono, usuario, password)
            clienteController.registrarCliente(nuevoCliente)
        } else {
            mostrarMensaje("Datos incorrectos")
        }
    }

    private fun mostrarMensaje(mensaje: String) {
        android.widget.Toast.makeText(this, mensaje, android.widget.Toast.LENGTH_SHORT).show()
    }
}
