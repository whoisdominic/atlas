package com.tokul.atlas.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class BackgroundViewModel : ViewModel() {

    private val backgroundColors = listOf<Pair<String, String>>(
        Pair("#212121", "#8f3d3d"),
        Pair("#6a4896", "#0000FF"),
        Pair("#1f2927", "#23cca4"),
        Pair("#e8c61a", "#b54d07"),
    ).map { Pair(parseColor(it.first), parseColor(it.second)) }
        .toMutableList()

    var currentColorIndex by mutableStateOf(0)

    var currentColors by mutableStateOf(backgroundColors[currentColorIndex])

    private fun parseColor(color: String): Color {
        return Color(android.graphics.Color.parseColor(color))
    }

    fun updateColorIndex() {
        currentColorIndex = (currentColorIndex + 1) % backgroundColors.size
        currentColors = backgroundColors[currentColorIndex]
    }
}