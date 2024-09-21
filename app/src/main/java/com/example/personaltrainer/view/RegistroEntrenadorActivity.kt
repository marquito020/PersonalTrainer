package com.example.personaltrainer.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.R
import com.example.personaltrainer.controller.ClienteController
import com.example.personaltrainer.model.Cliente

class RegistroEntrenadorActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var edtUsuario: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnRegistrar: Button

    private val clienteController = ClienteController() // Puedes tener un controlador específico para entrenadores

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_entrenador)

        // Inicialización de campos y botones
        edtNombre = findViewById(R.id.edtNombreEntrenador)
        edtTelefono = findViewById(R.id.edtTelefonoEntrenador)
        edtUsuario = findViewById(R.id.edtUsuarioEntrenador)
        edtPassword = findViewById(R.id.edtPasswordEntrenador)
        btnRegistrar = findViewById(R.id.btnRegistrarEntrenador)

        // Acción del botón Registrar
        btnRegistrar.setOnClickListener {
            val nombre = edtNombre.text.toString()
            val telefono = edtTelefono.text.toString()
            val usuario = edtUsuario.text.toString()
            val password = edtPassword.text.toString()

            if (clienteController.validarDatos(nombre, 0f, 0f, telefono, usuario, password)) {
                // Aquí puedes crear un objeto Entrenador si tienes una clase específica para ello
                Toast.makeText(this, "Entrenador registrado exitosamente", Toast.LENGTH_SHORT).show()
                // Puedes añadir la lógica para redirigir a otra actividad si es necesario
            } else {
                Toast.makeText(this, "Datos inválidos. Verifique la información ingresada.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
