package com.example.personaltrainer.model
import java.io.Serializable

data class Cliente(
    val nombre: String,
    val peso: Float,
    val altura: Float,
    val telefono: String,
    val usuario: String,
    val password: String
) : Serializable
