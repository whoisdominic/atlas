package com.tokul.atlas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tokul.atlas.ui.screens.LandingScreen
import com.tokul.atlas.ui.screens.SecondScreen

@Composable
fun MainNav() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") { LandingScreen(navController) }
        composable("second") { SecondScreen(navController) }
    }

}
