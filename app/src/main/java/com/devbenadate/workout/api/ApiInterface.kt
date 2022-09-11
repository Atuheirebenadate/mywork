package com.devbenadate.workout.api


import com.devbenadate.workout.models.LoginRequest
import com.devbenadate.workout.models.LoginResponse
import com.devbenadate.workout.models.RegisterRequest
import com.devbenadate.workout.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
  suspend  fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
    @POST("/response")
   suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}