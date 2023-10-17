package com.example.storesai.data

data class Product(
    val id: String,
    val titulo: String,
    val descripcion: String,
    val codigo: String,
    val cantidad: Double?,
    val precio: Double?,
)
