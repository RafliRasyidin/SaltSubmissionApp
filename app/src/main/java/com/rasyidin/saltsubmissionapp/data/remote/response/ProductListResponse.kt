package com.rasyidin.saltsubmissionapp.data.remote.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ProductListResponse(

	@SerialName("total")
	val total: Int = 0,

	@SerialName("limit")
	val limit: Int = 0,

	@SerialName("skip")
	val skip: Int = 0,

	@SerialName("products")
	val products: List<ProductResponse> = emptyList()
)
