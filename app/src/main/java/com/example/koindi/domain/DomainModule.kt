package com.example.koindi.domain

import com.example.koindi.domain.usecases.GetAddressUseCase
import com.example.koindi.domain.usecases.GetUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserNameUseCase(get()) }
    factory { GetAddressUseCase(get()) }
}