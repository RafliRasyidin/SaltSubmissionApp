package com.rasyidin.saltsubmissionapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasyidin.saltsubmissionapp.ui.theme.Gray200
import com.rasyidin.saltsubmissionapp.ui.theme.Gray300
import com.rasyidin.saltsubmissionapp.ui.theme.Gray800
import com.rasyidin.saltsubmissionapp.ui.theme.Gray900
import com.rasyidin.saltsubmissionapp.ui.theme.SaltSubmissionAppTheme
import com.rasyidin.saltsubmissionapp.ui.theme.firaSans

@Composable
fun ButtonApp(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Gray900,
            contentColor = Color.White,
            disabledContainerColor = Gray300,
            disabledContentColor = Gray200
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontFamily = firaSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun ButtonOutlinedApp(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Gray900,
            disabledContainerColor = Gray300,
            disabledContentColor = Gray200
        ),
        border = BorderStroke(
            width = 2.dp,
            color = Gray800
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontFamily = firaSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
}

@PreviewScreenSizes
@Composable
private fun ButtonAppPreview() {
    SaltSubmissionAppTheme {
        ButtonApp(text = "Checkout")
    }
}

@PreviewScreenSizes
@Composable
private fun ButtonAppOutlinedPreview() {
    SaltSubmissionAppTheme {
        ButtonOutlinedApp(text = "Clear")
    }
}