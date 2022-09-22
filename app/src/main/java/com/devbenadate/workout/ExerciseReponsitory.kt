package com.devbenadate.workout

import android.media.session.MediaSession
import com.devbenadate.workout.api.ApiClient
import com.devbenadate.workout.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ExerciseReponsitory {
    val apiClient = ApiClient.buildApiCleint(ApiInterface::class.java)
    suspend fun fetchExerciseCategory(accessToken:String)=
        withContext(Dispatchers.IO) {
            var response = apiClient
            return@withContext response
        }
}
//    val ApiClient.buildApiClient(ApiiNterface::class.java)
//    suspend fun fetchExercises(accessToken:String)= withContext(Dispatchers.IO)
