package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R // Replace with your actual package name
import com.example.myapplication.Product // Replace with your actual package name

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val productList = listOf(
//            Product("Product 1", "$10.99"),
//            Product("Product 2", "$15.49"),
//            Product("Product 3", "$8.99")
//            // Add more products as needed
//        )
//
//        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = ProductAdapter(productList)
//        recyclerView.adapter = adapter
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val productService = RetrofitClient.retrofit.create(ProductService::class.java)
        val call = productService.getProducts()

        call.enqueue(object : Callback<List<Product>> {
            fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val productList = response.body()
                    val adapter = ProductAdapter(productList)
                    recyclerView.adapter = adapter
                }
            }

            fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Handle error
            }
        })
    }
}

private fun <T> Call<T>.enqueue(any: Any) {

}
