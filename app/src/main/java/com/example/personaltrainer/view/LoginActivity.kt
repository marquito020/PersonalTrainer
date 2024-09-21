package com.example.personaltrainer.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.R
import com.example.personaltrainer.controller.ClienteController

class LoginActivity : AppCompatActivity() {

    // Declaración de los campos y botones
    private lateinit var edtUsuarioLogin: EditText
    private lateinit var edtPasswordLogin: EditText
    private lateinit var btnIniciarSesion: Button
    private lateinit var btnVolver: Button

    private lateinit var clienteController: ClienteController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicialización de los campos y botones
        edtUsuarioLogin = findViewById(R.id.edtUsuarioLogin)
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        btnVolver = findViewById(R.id.btnVolver)

        // Inicialización del controlador
        clienteController = ClienteController()

        // Acción del botón Iniciar Sesión
        btnIniciarSesion.setOnClickListener {
            val usuario = edtUsuarioLogin.text.toString()
            val password = edtPasswordLogin.text.toString()

            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ClientesEntrenadorActivity::class.java))

            // Validación de usuario y contraseña
            //if (clienteController.validarUsuario(usuario, password)) {
                // Iniciar la sesión y redirigir al menú principal
              //  Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                //startActivity(Intent(this, ClientesEntrenadorActivity::class.java))
            //} else {
                // Mostrar mensaje de error si la validación falla
              //  Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            //}
        }

        // Acción del botón Volver
        btnVolver.setOnClickListener {
            // Regresa al menú principal
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
