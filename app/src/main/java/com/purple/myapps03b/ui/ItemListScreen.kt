package com.purple.myapps03b.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun ItemListScreen(
    navController: NavController,
    viewModel: UserViewModel
) {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7")
    val selectedItems = viewModel.selectedItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Seleccionar items", modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxHeight(0.8f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { item ->
                ItemRow(
                    item = item,
                    isSelected = selectedItems.value.contains(item),
                    onItemClicked = { viewModel.toggleItemSelection(item) }
                )
            }
        }

        Button(
            onClick = {
                navController.navigate("confirmation_screen")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Confirmar")
        }
    }
}

@Composable
fun ItemRow(item: String, isSelected: Boolean, onItemClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = item)
        Button(onClick = { onItemClicked() }) {
            Text(text = if (isSelected) "Deseleccionar" else "Seleccionar")
        }
    }
}