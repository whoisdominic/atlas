package com.tokul.atlas.ui.layout.background

import android.graphics.Color.parseColor
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tokul.atlas.ui.theme.AtlasTheme
import kotlinx.coroutines.delay
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Background(colors:  List<Pair<String, String>>, content: @Composable () -> Unit) {

    fun parseColor(color: String): Color {
        return Color(android.graphics.Color.parseColor(color))
    }

     val backgroundColors = colors.map { Pair(parseColor(it.first), parseColor(it.second)) }
        .toMutableList()

    var currentColorIndex by remember {
        mutableStateOf(0)
    }

    var currentColors by remember {
        mutableStateOf(backgroundColors[currentColorIndex])
    }

    fun updateColorIndex() {
        currentColorIndex = (currentColorIndex + 1) % backgroundColors.size
        currentColors = backgroundColors[currentColorIndex]
    }

    val color1 by animateColorAsState(
        targetValue = currentColors.first, animationSpec = tween(durationMillis = 9000)
    )
    val color2 by animateColorAsState(
        targetValue = currentColors.second, animationSpec = tween(durationMillis = 9000)
    )

    LaunchedEffect(key1 = Unit) {
        println("LaunchedEffect - Background")
        updateColorIndex()
        while (true) {
            delay(10000)  // delay for 5 seconds
            updateColorIndex()
        }
    }

    val gradient = Brush.linearGradient(
        colors = listOf(color1, color2),
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradient)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun BackgroundPreview() {
    AtlasTheme() {
        Background(
            listOf(
                Pair("#212121", "#8f3d3d"),
                Pair("#6a4896", "#0000FF"),
                Pair("#1f2927", "#23cca4"),
                Pair("#e8c61a", "#b54d07"),
            )
        ) {
            Column() {
                Text(text = "Atlas")
            }
        }
    }
}


