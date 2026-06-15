package com.kerikir.news.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination =
    ) {

    }
}



sealed class Screen(val route: String) {

    data object Subscriptions: Screen(route = "subscriptions")

    data object Settings: Screen("settings")
}