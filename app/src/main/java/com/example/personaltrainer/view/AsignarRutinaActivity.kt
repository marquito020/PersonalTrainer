package com.example.personaltrainer.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.R

class AsignarRutinaActivity : AppCompatActivity() {

    private lateinit var btnPecho: Button
    private lateinit var btnPiernas: Button
    private lateinit var btnBrazos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignar_rutina)

        btnPecho = findViewById(R.id.btnArribaAdelante)
        btnPiernas = findViewById(R.id.btnAbajoAdelante)
        btnBrazos = findViewById(R.id.btnAbajoAtras)

        // Cuando se presione el botón de Pecho
        btnPecho.setOnClickListener {
            val intent = Intent(this, EjerciciosPechoActivity::class.java)
            startActivity(intent)
        }

        // Cuando se presione el botón de Piernas
        btnPiernas.setOnClickListener {
            val intent = Intent(this, EjerciciosPiernasActivity::class.java)
            startActivity(intent)
        }

        // Cuando se presione el botón de Brazos
        btnBrazos.setOnClickListener {
            val intent = Intent(this, EjerciciosBrazosActivity::class.java)
            startActivity(intent)
        }

        // Puedes agregar más listeners para otras partes del cuerpo
    }
}
