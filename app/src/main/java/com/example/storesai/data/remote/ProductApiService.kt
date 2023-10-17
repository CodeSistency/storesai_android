package com.example.storesai.data.remote

import com.example.storesai.data.Product
import retrofit2.http.GET

interface ProductApiService {
    @GET("productos")
    suspend fun getProducts(): List<Product>
}