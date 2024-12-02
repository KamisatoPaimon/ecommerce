package com.example.ecommerce.Data.Api

import com.example.ecommerce.Data.Model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("product/getallproducts")
    fun getAllProducts() : Call<List<Product>>
}