package com.purple.myapps03b.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.purple.myapps03b.viewmodel.UserViewModel

@Composable
fun ConfirmationScreen(
    navController: NavController,
    viewModel: UserViewModel
) {
    val name = viewModel.name.collectAsState()
    val email = viewModel.email.collectAsState()
    val selectedItems = viewModel.selectedItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Nombre: ${name.value}")
        Text(text = "Correo: ${email.value}")
        Text(text = "Items: ${selectedItems.value.joinToString()}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Aquí simularíamos el registro
        }) {
            Text(text = "Registrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Editar")
        }
    }
}