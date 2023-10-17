package com.example.storesai.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storesai.data.Product
import com.example.storesai.data.ProductRepository
import com.example.storesai.data.local.ProductDB
import com.example.storesai.data.remote.ProductApiService
import kotlinx.coroutines.launch

abstract class ProductViewModel(application: Application) : AndroidViewModel(application) {
    abstract val repository: ProductRepository
    abstract val apiService: ProductApiService

    val allProducts: LiveData<List<ProductDB>> = repository.allProducts

//    fun insertProduct(product: ProductDB) {
//        viewModelScope.launch {
//            repository.insertProduct(product)
//        }
//    }
//
//    fun updateProduct(product: ProductDB) {
//        viewModelScope.launch {
//            repository.updateProduct(product)
//        }
//    }
//
//    fun deleteProduct(product: ProductDB) {
//        viewModelScope.launch {
//            repository.deleteProduct(product)
//        }
//    }

    fun fetchProductsFromApi() {
        viewModelScope.launch {
            try {
                val products = apiService.getProducts()
                // Handle the received products as needed
                println(products)
                for (product in products) {
                    println(product.titulo) // Print the name of each product
                }
            } catch (e: Exception) {
                // Handle the API error
            }
        }
    }
}