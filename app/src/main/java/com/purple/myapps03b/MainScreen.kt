package com.purple.myapps03b

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.purple.myapps03b.ui.*

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavigation(navController = navController)
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "input_screen") {
        composable("input_screen") {
            InputScreen(navController = navController)
        }
        composable("item_list_screen") {
            ItemListScreen(navController = navController)
        }
        composable("confirmation_screen") {
            ConfirmationScreen(navController = navController)
        }
    }
}