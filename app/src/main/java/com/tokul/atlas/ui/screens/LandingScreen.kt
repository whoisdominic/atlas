package com.tokul.atlas.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tokul.atlas.ui.layout.background.Background

@Composable
fun LandingScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Background(colors = listOf(
            Pair("#212121", "#8f3d3d"),
            Pair("#6a4896", "#0000FF"),
            Pair("#1f2927", "#23cca4"),
            Pair("#e8c61a", "#b54d07"),
        )) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Landing", color = Color.White, fontSize = 30.sp, modifier = Modifier.clickable {
                    navController.navigate("second")
                })
            }
        }
    }
}