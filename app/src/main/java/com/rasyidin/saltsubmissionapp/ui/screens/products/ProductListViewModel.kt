package com.rasyidin.saltsubmissionapp.ui.screens.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasyidin.saltsubmissionapp.domain.model.SortByProduct
import com.rasyidin.saltsubmissionapp.domain.repository.ProductRepository
import com.rasyidin.saltsubmissionapp.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(repository: ProductRepository): ViewModel() {

    var state by mutableStateOf(ProductListState())
        private set

    private val _events: Channel<ProductListEvent> = Channel()
    val events = _events.receiveAsFlow()

    init {
        repository.getProducts()
            .onStart {
                state = state.copy(isLoading = true)
            }
            .onEach { data ->
                state = state.copy(products = data)
            }
            .catch {
                _events.send(ProductListEvent.ShowErrorMessage("Failed to load data!"))
            }
            .onCompletion {
                state = state.copy(isLoading = false)
            }
            .launchIn(viewModelScope)
    }

    fun onAction(action: ProductListAction) {
        when (action) {
            ProductListAction.Checkout -> performCheckout()
            ProductListAction.ClearCart -> clearChart()
            is ProductListAction.DecrementProduct -> updateQuantity(action.productId, -1)
            is ProductListAction.IncrementProduct -> updateQuantity(action.productId, 1)
            is ProductListAction.SortBy -> sortProducts(action.sort)
        }
    }

    private fun sortProducts(sort: SortByProduct) {
        val currentSort = state.sorts.first { it.id == sort.id }
        val currentProducts = state.products
        val sortedProducts = when (currentSort.id) {
            Constants.SORT_BY_HIGHEST_PRICE -> currentProducts.sortedByDescending { it.price }
            Constants.SORT_BY_LOWEST_PRICE -> currentProducts.sortedBy { it.price }
            Constants.SORT_BY_NAME -> currentProducts.sortedBy { it.name }
            else -> currentProducts
        }
        state = state.copy(
            products = sortedProducts,
            selectedSort = currentSort
        )
    }

    private fun updateQuantity(productId: Int, quantity: Int) {
        val currentProduct = state.products.map { product ->
            if (product.id == productId) {
                val newQuantity = product.purchaseQuantity + quantity
                val purchaseQuantity = when  {
                    newQuantity < 0 -> 0
                    newQuantity > product.stock -> product.stock
                    else -> newQuantity
                }
                product.copy(purchaseQuantity = purchaseQuantity)
            } else {
                product
            }
        }
        state = state.copy(
            products = currentProduct,
            totalPrice = currentProduct.sumOf { it.price * it.purchaseQuantity },
            enabledCheckoutButton = currentProduct.sumOf { it.purchaseQuantity } > 0
        )
    }

    private fun clearChart() {
        state = state.copy(
            products = state.products.map { it.copy(purchaseQuantity = 0) },
            totalPrice = 0.0,
            enabledCheckoutButton = false
        )
    }

    private fun performCheckout() {
        viewModelScope.launch {
            _events.send(ProductListEvent.ShowSuccessDialog)
        }
    }

}