package com.example.koindi.data

import com.example.koindi.domain.AuthRepository
import kotlinx.coroutines.delay

class AuthRepoImpl : AuthRepository {
    override suspend fun getUserName(): String {
        delay(3000)
        return "Joe"
    }

    override suspend fun getAddress(): String {
        delay(1000)
        return "address"
    }
}