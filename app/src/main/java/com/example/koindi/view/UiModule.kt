package com.example.koindi.view

import com.example.koindi.MainActivity
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

data class SessionManager(
    val session: String
)

val sessionModule = module {
    scope<MainActivity> {
        scoped {
            SessionManager(session = "this is session")
        }
    }
}

val uiModule = module {
    viewModel { AuthViewModel(get(), get()) }
}