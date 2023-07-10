package com.tokul.atlas.ui.layout

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tokul.atlas.data.BackgroundViewModel
import com.tokul.atlas.ui.theme.AtlasTheme
import kotlinx.coroutines.delay

@Composable
fun Background(content: @Composable () -> Unit) {

    val viewModel = viewModel<BackgroundViewModel>()

    val color1 by animateColorAsState(targetValue = viewModel.currentColors.first, animationSpec = tween(durationMillis = 9000))
    val color2 by animateColorAsState(targetValue = viewModel.currentColors.second, animationSpec = tween(durationMillis = 9000))

    LaunchedEffect(key1 = Unit) {
        println("LaunchedEffect - Background")
        viewModel.updateColorIndex()
        while (true) {
            delay(10000)  // delay for 5 seconds
            viewModel.updateColorIndex()
        }
    }

    val gradient = Brush.linearGradient(
        colors = listOf(color1, color2),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient)
    ) {
        content()
    }
}

@Preview
@Composable
fun BackgroundPreview() {
    AtlasTheme() {
        Background {
            Column() {
                Text(text = "Atlas")
            }
        }
    }
}


