package com.rasyidin.saltsubmissionapp.ui.screens.products

sealed interface ProductListEvent {
    data class ShowErrorMessage(val message: String): ProductListEvent
    data object ShowSuccessDialog: ProductListEvent
}