package com.purple.myapps03b

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.purple.myapps03b.ui.*
import com.purple.myapps03b.viewmodel.UserViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val userViewModel: UserViewModel = viewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavigation(navController = navController, userViewModel = userViewModel)
    }
}

@Composable
fun AppNavigation(navController: NavHostController, userViewModel: UserViewModel) {
    NavHost(navController = navController, startDestination = "input_screen") {
        composable("input_screen") {
            InputScreen(navController = navController, viewModel = userViewModel)
        }
        composable("item_list_screen") {
            ItemListScreen(navController = navController, viewModel = userViewModel)
        }
        composable("confirmation_screen") {
            ConfirmationScreen(navController = navController, viewModel = userViewModel)
        }
    }
}