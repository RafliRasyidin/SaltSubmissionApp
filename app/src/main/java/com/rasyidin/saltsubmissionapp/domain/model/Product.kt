package com.rasyidin.saltsubmissionapp.domain.model

data class Product(
    val id: Int = 0,
    val title: String = "",
    val price: Double = 0.0,
    val stock: Int = 0,
    val purchaseQuantity: Int = 0,
)
