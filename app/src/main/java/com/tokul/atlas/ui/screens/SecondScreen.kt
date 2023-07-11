package com.tokul.atlas.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tokul.atlas.ui.layout.background.Background


@Composable
fun SecondScreen(navController: NavController) {

    Background(
        colors = listOf(
            Pair("#A5FECB", "#0F2027"),
            Pair("#00c6ff", "#0072ff"),
            Pair("#005AA7", "#FFFDE4"),
            Pair("#5433FF", "#A5FECB"),
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Second",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.clickable {
                    navController.navigate("landing")
                })
        }
    }

}