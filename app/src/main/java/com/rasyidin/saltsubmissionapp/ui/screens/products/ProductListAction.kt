package com.rasyidin.saltsubmissionapp.ui.screens.products

sealed interface ProductListAction {
    data class IncrementProduct(val productId: Int): ProductListAction
    data class DecrementProduct(val productId: Int): ProductListAction
    data object Checkout: ProductListAction
    data object ClearCart: ProductListAction
}