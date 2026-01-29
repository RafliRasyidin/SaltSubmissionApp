package com.rasyidin.saltsubmissionapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun SaltSubmissionAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(content = content)
}