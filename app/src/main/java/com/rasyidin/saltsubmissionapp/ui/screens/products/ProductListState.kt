package com.rasyidin.saltsubmissionapp.ui.screens.products

import androidx.compose.runtime.Stable
import com.rasyidin.saltsubmissionapp.domain.model.Product
import com.rasyidin.saltsubmissionapp.domain.model.SortByProduct
import com.rasyidin.saltsubmissionapp.utils.Constants

@Stable
data class ProductListState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val sorts: List<SortByProduct> = Constants.sortOptions,
    val selectedSort: SortByProduct = SortByProduct().setDefault(),
    val totalPrice: Double = 0.0,
    val enabledCheckoutButton: Boolean = false,
)
