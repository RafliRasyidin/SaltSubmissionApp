package com.rasyidin.saltsubmissionapp.domain.repository

import com.rasyidin.saltsubmissionapp.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(): Flow<List<Product>>
}