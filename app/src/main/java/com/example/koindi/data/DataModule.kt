package com.example.koindi.data

import com.example.koindi.domain.AuthRepository
import org.koin.dsl.module

val dataModule = module {

    factory<AuthRepository> { AuthRepoImpl() }
}