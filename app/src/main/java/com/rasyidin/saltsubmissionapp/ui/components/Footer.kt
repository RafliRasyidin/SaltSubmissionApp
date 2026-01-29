package com.rasyidin.saltsubmissionapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasyidin.saltsubmissionapp.ui.theme.Gray900
import com.rasyidin.saltsubmissionapp.ui.theme.SaltSubmissionAppTheme
import com.rasyidin.saltsubmissionapp.ui.theme.firaSans

@Composable
fun Footer(
    label: String,
    value: String,
    primaryButtonText: String,
    modifier: Modifier = Modifier,
    secondaryButtonText: String? = null,
    onPrimaryButtonClick: () -> Unit = {},
    onSecondaryButtonClick: () -> Unit = {},
    enabledPrimaryButton: Boolean = true,
    enabledSecondaryButton: Boolean = true
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(24.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = label,
                fontFamily = firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Gray900
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = value,
                fontFamily = firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Gray900,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }
        Spacer(Modifier.height(17.dp))
        ButtonApp(
            text = primaryButtonText,
            onClick = onPrimaryButtonClick,
            enabled = enabledPrimaryButton
        )
        AnimatedVisibility(!secondaryButtonText.isNullOrEmpty()) {
            Spacer(Modifier.height(11.dp))
            ButtonOutlinedApp(
                text = secondaryButtonText.orEmpty(),
                onClick = onSecondaryButtonClick,
                enabled = enabledSecondaryButton
            )
        }
    }
}

@Preview(showBackground = true, name = "Full Footer")
@Composable
fun PreviewFooterFull() {
    SaltSubmissionAppTheme {
        Surface(color = Color(0xFFF6F6F6)) { // Gray50
            Footer(
                label = "Total:",
                value = "Rp. 1.225.000",
                primaryButtonText = "Checkout",
                secondaryButtonText = "Reset",
                onPrimaryButtonClick = {},
                onSecondaryButtonClick = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "Primary Only")
@Composable
fun PreviewFooterPrimaryOnly() {
    SaltSubmissionAppTheme {
        Surface(color = Color(0xFFF6F6F6)) {
            Footer(
                label = "Subtotal:",
                value = "Rp. 350.000",
                primaryButtonText = "Pay Now",
                secondaryButtonText = null // This hides the second button
            )
        }
    }
}

@Preview(showBackground = true, name = "Disabled State")
@Composable
fun PreviewFooterDisabled() {
    SaltSubmissionAppTheme {
        Surface(color = Color(0xFFF6F6F6)) {
            Footer(
                label = "Total:",
                value = "Rp. 0",
                primaryButtonText = "Checkout",
                enabledPrimaryButton = false // Tests your enabled logic
            )
        }
    }
}