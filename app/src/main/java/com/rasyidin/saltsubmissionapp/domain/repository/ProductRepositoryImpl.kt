package com.rasyidin.saltsubmissionapp.domain.repository

import com.rasyidin.saltsubmissionapp.data.remote.api.ProductApi
import com.rasyidin.saltsubmissionapp.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productApi: ProductApi,
): ProductRepository {

    override fun getProducts(): Flow<List<Product>> {
        return flow {
            val products = productApi.getProducts().products.map { it.toProduct() }
            emit(products)
        }
    }
}