package com.rasyidin.saltsubmissionapp.ui.screens.products

import androidx.compose.runtime.Stable
import com.rasyidin.saltsubmissionapp.domain.model.Product
import com.rasyidin.saltsubmissionapp.domain.model.SortByProduct

@Stable
data class ProductListState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val sorts: List<SortByProduct> = emptyList(),
    val selectedSort: SortByProduct = SortByProduct().default,
    val totalPrice: Double = 0.0,
    val enabledCheckoutButton: Boolean = false
)
