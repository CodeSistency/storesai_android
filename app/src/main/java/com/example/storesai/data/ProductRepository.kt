package com.example.storesai.data

import androidx.lifecycle.LiveData
import com.example.storesai.data.local.ProductDB
import com.example.storesai.data.local.ProductDao

class ProductRepository(private val productDao: ProductDao) {
    val allProducts: LiveData<List<ProductDB>> = productDao.getAllProducts()

//    suspend fun insertProduct(product: ProductDB) {
//        productDao.insertProduct(product)
//    }
//
//    suspend fun updateProduct(product: ProductDB) {
//        productDao.updateProduct(product)
//    }
//
//    suspend fun deleteProduct(product: ProductDB) {
//        productDao.deleteProduct(product)
//    }
}