package com.rasyidin.saltsubmissionapp.data.remote.api

import com.rasyidin.saltsubmissionapp.data.remote.response.ProductListResponse
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): ProductListResponse
}