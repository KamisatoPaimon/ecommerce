package com.example.ecommerce.Data.Model

data class Product (
    val productId: Int,
    val productSku: String,
    val productName: String,
    val productPrice: String,
    val productWeight: Double,
    val productCartDesc: String,
    val productShortDesc: String,
    val productLongDesc: String,
    val productThumb: String,
    val productImage: String,
    val productCategoryId: Int,
    val productStock: Int,
    val productLive: Int
)