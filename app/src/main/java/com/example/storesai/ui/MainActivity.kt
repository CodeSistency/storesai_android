package com.example.storesai.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.storesai.R
import com.example.storesai.data.ProductRepository
import com.example.storesai.data.local.ProductDatabase
import com.example.storesai.data.remote.ProductApiService
import com.example.storesai.viewmodel.ProductViewModel
//import com.google.android.ads.mediationtestsuite.viewmodels.ViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var productViewModel: ProductViewModel
    private lateinit var apiService: ProductApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = Retrofit.Builder()
            .baseUrl("https://backend-inventory.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApiService::class.java)

        val productDao = ProductDatabase.getInstance(application).productDao()
        val repository = ProductRepository(productDao)


        productViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(ProductViewModel::class.java)

        val fetchProductsButton: Button = findViewById(R.id.fetchProductsButton)
        fetchProductsButton.setOnClickListener {
            productViewModel.fetchProductsFromApi()
        }
    }
}