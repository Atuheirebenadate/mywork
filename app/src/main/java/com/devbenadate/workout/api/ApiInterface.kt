package com.devbenadate.workout.api


import com.devbenadate.workout.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
  suspend  fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
    @POST("/response")
   suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
   @GET("/exercise_categories")
   suspend fun fetchExerciseCategories(@Header("Authorization")accessToken:String):Response<List<ExerciseCategory>>

}