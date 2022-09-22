package com.devbenadate.workout.ViewModel

import android.media.session.MediaSession
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devbenadate.workout.ExerciseReponsitory
import com.devbenadate.workout.models.ExerciseCategory
import kotlinx.coroutines.launch
import retrofit2.Response

class ExerciseViewModel:ViewModel() {
    val exerciseReponsitory=ExerciseReponsitory()
    val exerciseCategoryLiveData=MutableLiveData<List<ExerciseCategory>>()
    val errorLiveData=MutableLiveData<String>()


    fun fetchExerciseCategories(accessToken: String){
        viewModelScope.launch{
            val response=exerciseReponsitory.fetchExerciseCategory(accessToken)
            if (response.isSuccesful){
            exerciseCategoryLiveData.postValue(response.body())
        }
        else{
            val errormessage=response.errorBody()?.String()
            errorLiveData.postValue(errormessage)
        }
        }

    }

}