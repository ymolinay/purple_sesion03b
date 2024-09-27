package com.purple.myapps03b.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.purple.myapps03b.viewmodel.UserViewModel

@Composable
fun InputScreen(
    navController: NavController,
    viewModel: UserViewModel
) {
    val name = viewModel.name.collectAsState()
    val email = viewModel.email.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name.value,
            onValueChange = { viewModel.updateName(it) },
            label = { Text("Ingrese nombre") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        TextField(
            value = email.value,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text("Ingrese correo") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("item_list_screen")
        }) {
            Text(text = "Siguiente")
        }
    }
}