package com.example.personaltrainer.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.R

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupSeleccion: RadioGroup
    private lateinit var btnIniciarSesion: Button
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas
        radioGroupSeleccion = findViewById(R.id.radioGroupSeleccion)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        // Acción del botón Iniciar Sesión
        btnIniciarSesion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Acción del botón Registrar
        btnRegistrar.setOnClickListener {
            val selectedOptionId = radioGroupSeleccion.checkedRadioButtonId
            if (selectedOptionId != -1) {
                val selectedRadioButton: RadioButton = findViewById(selectedOptionId)

                if (selectedRadioButton.text == "Cliente") {
                    // Ir al registro de Cliente
                    startActivity(Intent(this, RegistroClienteActivity::class.java))
                } else if (selectedRadioButton.text == "Entrenador") {
                    // Ir al registro de Entrenador (debes crear esta pantalla)
                    startActivity(Intent(this, RegistroEntrenadorActivity::class.java))
                }
            } else {
                // Mostrar un mensaje si no se seleccionó ninguna opción
                Toast.makeText(this, "Debes seleccionar Cliente o Entrenador", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
