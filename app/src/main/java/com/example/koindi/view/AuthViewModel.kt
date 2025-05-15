package com.example.koindi.view

import android.R.attr.name
import android.R.id.message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koindi.domain.usecases.GetAddressUseCase
import com.example.koindi.domain.usecases.GetUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class AuthViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val getAddressUseCase: GetAddressUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        getUserName()
    }

    fun getUserName() = getUserNameUseCase()
        .onStart {
            _uiState.update { UiState(isLoading = true) }
        }.onEach { result ->
            _uiState.update { it.copy(name = result) }
        }.catch { message ->
            _uiState.update { it.copy(error = message.toString()) }
        }.onCompletion {
            _uiState.update { it.copy(isLoading = false) }
        }
        .launchIn(viewModelScope)

    fun getAddress() = getAddressUseCase()
        .onEach { result ->
            _uiState.update { it.copy(address = result) }
        }.catch { message ->
            _uiState.update { it.copy(error = message.toString()) }
        }.launchIn(viewModelScope)
}

data class UiState(
    val isLoading: Boolean = false,
    val name: String? = null,
    val address: String? = null,
    val error: String = ""
)