package com.rasyidin.saltsubmissionapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasyidin.saltsubmissionapp.R
import com.rasyidin.saltsubmissionapp.ui.theme.Red
import com.rasyidin.saltsubmissionapp.ui.theme.SaltSubmissionAppTheme
import com.rasyidin.saltsubmissionapp.ui.theme.firaSans

@Composable
fun Header(
    title: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    body: String? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(Red)
            .padding(horizontal = 20.dp, vertical = 32.dp)
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            tint = Color.White
        )
        Spacer(Modifier.width(21.dp))
        Column(modifier = Modifier.weight(1F)) {
            Text(
                text = title,
                fontFamily = firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
            if (body != null) {
                Spacer(Modifier.height(5.dp))
                Text(
                    text = body,
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}

@PreviewScreenSizes
@Composable
private fun HeaderPreview() {
    SaltSubmissionAppTheme {
        Header(
            title = "Product List",
            icon = ImageVector.vectorResource(R.drawable.ic_mobile)
        )
    }
}

@PreviewScreenSizes
@Composable
private fun HeaderPreview2() {
    SaltSubmissionAppTheme {
        Header(
            title = "Product List",
            icon = ImageVector.vectorResource(R.drawable.ic_mobile),
            body = "3 Products"
        )
    }
}