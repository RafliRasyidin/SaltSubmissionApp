package com.rasyidin.saltsubmissionapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasyidin.saltsubmissionapp.domain.model.Product
import com.rasyidin.saltsubmissionapp.ui.theme.Gray100
import com.rasyidin.saltsubmissionapp.ui.theme.Gray300
import com.rasyidin.saltsubmissionapp.ui.theme.Gray50
import com.rasyidin.saltsubmissionapp.ui.theme.Gray500
import com.rasyidin.saltsubmissionapp.ui.theme.Gray900
import com.rasyidin.saltsubmissionapp.ui.theme.SaltSubmissionAppTheme
import com.rasyidin.saltsubmissionapp.ui.theme.firaSans
import com.rasyidin.saltsubmissionapp.utils.toRupiah

@Composable
fun ProductCart(
    product: Product,
    modifier: Modifier = Modifier,
    onIncrementClick: () -> Unit = {},
    onDecrementClick: () -> Unit = {}
) {
    val colorButtonIncrement = if (product.purchaseQuantity >= product.stock) Gray300 else Gray900
    val colorButtonDecrement = if (product.purchaseQuantity <= 0) Gray300 else Gray900
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = product.name,
                fontFamily = firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Gray900
            )
            Spacer(Modifier.height(7.dp))
            Text(
                text = "Rp. ${product.price.toRupiah()}",
                fontFamily = firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Gray500
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = Gray100, shape = RoundedCornerShape(8.dp))
                .background(color = Gray50, shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(colorButtonDecrement)
                    .clickable(
                        enabled = product.purchaseQuantity > 0,
                        onClick = onDecrementClick
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "-",
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Spacer(Modifier.width(2.dp))
            Text(
                text = product.purchaseQuantity.toString(),
                fontFamily = firaSans,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Gray900,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.width(2.dp))
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(colorButtonIncrement)
                    .clickable(
                        enabled = product.purchaseQuantity < product.stock,
                        onClick = onIncrementClick
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}

@PreviewScreenSizes
@Composable
private fun ProductChartPreview() {
    SaltSubmissionAppTheme {
        val products = listOf(
            Product(
                id = 1,
                name = "iPhone 9",
                price = 370000.0,
            ),
            Product(
                id = 2,
                name = "iPhone X",
                price = 250000.0,
            ),
            Product(
                id = 3,
                name = "iPhone 13",
                price = 235000.0,
            ),
        )
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(42.dp)
            ) {
                items(products, key = { it.id} ) { product ->
                    ProductCart(product = product)
                }
            }
        }

    }
}