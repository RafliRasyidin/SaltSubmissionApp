package com.rasyidin.saltsubmissionapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasyidin.saltsubmissionapp.ui.theme.Gray900
import com.rasyidin.saltsubmissionapp.ui.theme.firaSans

@Composable
fun PopUpDialog(
    title: String,
    description: String,
    textButton: String,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontFamily = firaSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Gray900,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(14.dp))
        Text(
            text = description,
            fontFamily = firaSans,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Gray900,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        ButtonApp(
            text = textButton,
            onClick = onButtonClick
        )
    }
}