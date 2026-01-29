package com.rasyidin.saltsubmissionapp.ui.screens.products

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.rasyidin.saltsubmissionapp.R
import com.rasyidin.saltsubmissionapp.domain.model.Product
import com.rasyidin.saltsubmissionapp.domain.model.SortByProduct
import com.rasyidin.saltsubmissionapp.ui.components.Footer
import com.rasyidin.saltsubmissionapp.ui.components.Header
import com.rasyidin.saltsubmissionapp.ui.components.Loader
import com.rasyidin.saltsubmissionapp.ui.components.ProductCart
import com.rasyidin.saltsubmissionapp.ui.components.SortBy
import com.rasyidin.saltsubmissionapp.ui.theme.Gray100
import com.rasyidin.saltsubmissionapp.utils.ObserveAsEvents
import com.rasyidin.saltsubmissionapp.utils.toRupiah

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    ObserveAsEvents(viewModel.events) { event ->
        when (event) {
            is ProductListEvent.ShowErrorMessage -> Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
            ProductListEvent.ShowSuccessDialog -> {}
        }
    }
    ProductListContent(
        state = viewModel.state,
        modifier = modifier,
        onSortSelected = { sort ->
            viewModel.onAction(ProductListAction.SortBy(sort))
        },
        onIncrementClick = { product ->
            viewModel.onAction(ProductListAction.IncrementProduct(product.id))
        },
        onDecrementClick = { product ->
            viewModel.onAction(ProductListAction.DecrementProduct(product.id))
        },
        onCheckout = {
            viewModel.onAction(ProductListAction.Checkout)
        },
        onClearCart = {
            viewModel.onAction(ProductListAction.ClearCart)
        }
    )
}

@Composable
private fun ProductListContent(
    state: ProductListState,
    modifier: Modifier = Modifier,
    onSortSelected: (SortByProduct) -> Unit,
    onIncrementClick: (Product) -> Unit,
    onDecrementClick: (Product) -> Unit,
    onClearCart: () -> Unit,
    onCheckout: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header(
            title = "Product List",
            body = if (state.products.isNotEmpty()) "${state.products.size} Products" else null,
            icon = ImageVector.vectorResource(R.drawable.ic_mobile)
        )
        AnimatedContent(
            targetState = state.isLoading,
            modifier = Modifier.weight(1f)
        ) { isLoading ->
            if (isLoading) {
                Column {
                    Spacer(Modifier.weight(1f))
                    Loader(
                        title = "Loading Product Data",
                        description = "Please wait...",
                        icon = ImageVector.vectorResource(R.drawable.ic_mobile),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(Modifier.weight(1f))
                }
            } else {
                Column {
                    Spacer(Modifier.height(32.dp))
                    SortBy(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        sorts = state.sorts,
                        onSortBySelected = onSortSelected,
                        currentSort = state.selectedSort
                    )
                    Spacer(Modifier.height(23.dp))
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        thickness = 1.dp,
                        color = Gray100
                    )
                    Spacer(Modifier.height(32.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(42.dp)
                    ) {
                        items(state.products, key = { it.id }) { product ->
                            ProductCart(
                                product = product,
                                onIncrementClick = {
                                    onIncrementClick(product)
                                },
                                onDecrementClick = {
                                    onDecrementClick(product)
                                }
                            )
                        }
                    }
                }
            }
        }
        Footer(
            label = "Total",
            value = "Rp. ${state.totalPrice.toRupiah()}",
            primaryButtonText = "Checkout",
            secondaryButtonText = "Clear",
            onPrimaryButtonClick = onCheckout,
            onSecondaryButtonClick = onClearCart,
            enabledPrimaryButton = state.enabledCheckoutButton,
            showSecondaryButton = state.enabledCheckoutButton
        )
    }
}