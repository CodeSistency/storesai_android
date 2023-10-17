package com.example.storesai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductDB(
    @PrimaryKey val id: Int,
    val titulo: String,
    val descripcion: String,
    val codigo: String,
    val cantidad: Double?,
    val precio: Double?,
)
