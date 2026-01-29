package com.rasyidin.saltsubmissionapp.data.remote.response

import com.rasyidin.saltsubmissionapp.domain.model.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(

    @SerialName("price")
    val price: Double = 0.0,

    @SerialName("id")
    val id: Int = 0,

    @SerialName("title")
    val title: String = "",

    @SerialName("stock")
    val stock: Int = 0
) {
    fun toProduct() = Product(
        id = id,
        name = title,
        stock = stock,
        price = price
    )
}