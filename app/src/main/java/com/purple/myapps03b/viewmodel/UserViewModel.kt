package com.purple.myapps03b.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Estado del nombre (persistido con SavedStateHandle)
    private val _name = MutableStateFlow(savedStateHandle["name"] ?: "")
    val name: StateFlow<String> get() = _name

    // Estado del correo (solo en StateFlow)
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> get() = _email

    // Lista de ítems seleccionados (solo StateFlow)
    private val _selectedItems = MutableStateFlow(emptyList<String>())
    val selectedItems: StateFlow<List<String>> get() = _selectedItems

    // Funciones para actualizar el estado
    fun updateName(newName: String) {
        _name.value = newName
        savedStateHandle["name"] = newName // Guardar en SavedStateHandle
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun toggleItemSelection(item: String) {
        val currentSelection = _selectedItems.value
        _selectedItems.value = if (currentSelection.contains(item)) {
            currentSelection - item
        } else {
            currentSelection + item
        }
    }
}