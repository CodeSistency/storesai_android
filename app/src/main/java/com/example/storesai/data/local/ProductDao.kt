package com.example.storesai.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.storesai.data.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM productdb")
    fun getAllProducts(): LiveData<List<ProductDB>>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertProduct(product: ProductDB): Unit
//
//    @Update
//    suspend fun updateProduct(product: ProductDB): Int
//
//    @Delete
//    suspend fun deleteProduct(product: ProductDB): Unit
}