package com.rasyidin.saltsubmissionapp.ui.screens.products

import com.rasyidin.saltsubmissionapp.domain.model.SortByProduct

sealed interface ProductListAction {
    data class IncrementProduct(val productId: Int): ProductListAction
    data class DecrementProduct(val productId: Int): ProductListAction
    data object Checkout: ProductListAction
    data object ClearCart: ProductListAction
    data class SortBy(val sort: SortByProduct): ProductListAction
    data object DismissDialog: ProductListAction
}