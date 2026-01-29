package com.rasyidin.saltsubmissionapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasyidin.saltsubmissionapp.R
import com.rasyidin.saltsubmissionapp.ui.theme.Gray500
import com.rasyidin.saltsubmissionapp.ui.theme.Gray900
import com.rasyidin.saltsubmissionapp.ui.theme.SaltSubmissionAppTheme
import com.rasyidin.saltsubmissionapp.ui.theme.firaSans

@Composable
fun Loader(
    title: String,
    description: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(76.dp),
            tint = Gray900
        )
        Spacer(Modifier.height(28.dp))
        Text(
            text = title,
            fontFamily = firaSans,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Gray900
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = description,
            fontFamily = firaSans,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Gray500
        )
    }
}

@PreviewScreenSizes
@Composable
private fun LoaderPreview() {
    SaltSubmissionAppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Loader(
                title = "Loading Product Data",
                description = "Please wait...",
                icon = ImageVector.vectorResource(R.drawable.ic_mobile),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}