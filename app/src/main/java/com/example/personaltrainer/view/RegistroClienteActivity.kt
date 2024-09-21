package com.example.personaltrainer.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.R
import com.example.personaltrainer.controller.ClienteController
import com.example.personaltrainer.model.Cliente

class RegistroClienteActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtPeso: EditText
    private lateinit var edtAltura: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var edtUsuario: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnRegistrar: Button

    private val clienteController = ClienteController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_cliente)

        // Inicialización de campos y botones
        edtNombre = findViewById(R.id.edtNombreCliente)
        edtPeso = findViewById(R.id.edtPesoCliente)
        edtAltura = findViewById(R.id.edtAlturaCliente)
        edtTelefono = findViewById(R.id.edtTelefonoCliente)
        edtUsuario = findViewById(R.id.edtUsuarioCliente)
        edtPassword = findViewById(R.id.edtPasswordCliente)
        btnRegistrar = findViewById(R.id.btnRegistrarCliente)

        // Acción del botón Registrar
        btnRegistrar.setOnClickListener {
            val nombre = edtNombre.text.toString()
            val peso = edtPeso.text.toString().toFloatOrNull() ?: 0f
            val altura = edtAltura.text.toString().toFloatOrNull() ?: 0f
            val telefono = edtTelefono.text.toString()
            val usuario = edtUsuario.text.toString()
            val password = edtPassword.text.toString()

            if (clienteController.validarDatos(nombre, peso, altura, telefono, usuario, password)) {
                val cliente = Cliente(nombre, peso, altura, telefono, usuario, password)
                clienteController.registrarCliente(cliente)
                Toast.makeText(this, "Cliente registrado exitosamente", Toast.LENGTH_SHORT).show()
                // Puedes añadir la lógica para redirigir a otra actividad si es necesario
            } else {
                Toast.makeText(this, "Datos inválidos. Verifique la información ingresada.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
