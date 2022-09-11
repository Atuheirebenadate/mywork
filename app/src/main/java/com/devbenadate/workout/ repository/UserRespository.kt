package com.devbenadate.workout.repository

import com.devbenadate.workout.api.ApiClient
import com.devbenadate.workout.api.ApiInterface
import com.devbenadate.workout.models.LoginRequest
import com.devbenadate.workout.models.LoginResponse
import com.devbenadate.workout.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRespository{
    val apiClient= ApiClient.buildApiCleint(ApiInterface::class.java)

    suspend fun  login(loginRequest: LoginRequest) = withContext(Dispatchers.IO){
    val response = apiClient.login(loginRequest)
    return@withContext response}


    suspend fun register(registerRequest: RegisterRequest)= withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequest)
        return@withContext response
    }
}