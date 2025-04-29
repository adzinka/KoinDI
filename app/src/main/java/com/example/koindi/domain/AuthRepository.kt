package com.example.koindi.domain

interface AuthRepository {

    suspend fun getUserName(): String

    suspend fun getAddress(): String
}