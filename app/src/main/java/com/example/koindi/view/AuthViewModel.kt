package com.example.koindi.view

import androidx.lifecycle.ViewModel
import com.example.koindi.domain.usecases.GetAddressUseCase
import com.example.koindi.domain.usecases.GetUserNameUseCase

class AuthViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val getAddressUseCase: GetAddressUseCase
) : ViewModel() {

}

data class UiState(
    val isLoading: Boolean = false,
    val name: String? = null,
    val address: String? = null,
    val error: String = ""
)