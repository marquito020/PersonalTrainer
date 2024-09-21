package com.example.personaltrainer.view

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltrainer.R
import com.example.personaltrainer.controller.ClienteController
import com.example.personaltrainer.model.Cliente

class ClientesEntrenadorActivity : AppCompatActivity() {

    private lateinit var edtTelefonoCliente: EditText
    private lateinit var btnAgregarCliente: Button
    private lateinit var lvClientes: ListView

    private val clienteController = ClienteController()
    private val clientes = mutableListOf<Cliente>()
    private lateinit var adapter: ArrayAdapter<Cliente>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes_entrenador)

        edtTelefonoCliente = findViewById(R.id.edtTelefonoCliente)
        btnAgregarCliente = findViewById(R.id.btnAgregarCliente)
        lvClientes = findViewById(R.id.lvClientes)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, clientes)
        lvClientes.adapter = adapter

        btnAgregarCliente.setOnClickListener {
            val telefono = edtTelefonoCliente.text.toString()
            if (telefono.isNotEmpty()) {
                // Aquí podrías añadir más validaciones
                val cliente = Cliente(nombre = "Nuevo Cliente", peso = 0f, altura = 0f, telefono = telefono, usuario = "", password = "")
                clienteController.registrarCliente(cliente)
                clientes.add(cliente)
                adapter.notifyDataSetChanged()
                edtTelefonoCliente.text.clear()
                Toast.makeText(this, "Cliente agregado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor ingrese un número de teléfono", Toast.LENGTH_SHORT).show()
            }
        }

        lvClientes.setOnItemClickListener { _, _, position, _ ->
            val clienteSeleccionado = clientes[position]
            val intent = Intent(this, AsignarRutinaActivity::class.java)
            intent.putExtra("cliente", clienteSeleccionado)
            startActivity(intent)
        }
    }
}
