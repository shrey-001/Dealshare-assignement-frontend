package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("api/product/all") // Replace with your actual endpoint
    fun getProducts(): Call<List<Product>> // Assuming your API returns a list of Product objects
}