package com.devbenadate.workout.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devbenadate.workout.models.LoginRequest
import com.devbenadate.workout.models.LoginResponse
import com.devbenadate.workout.models.RegisterRequest
import com.devbenadate.workout.repository.UserRespository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel(){
    val respository=UserRespository()
    var loginResponseLiveData=MutableLiveData<LoginResponse>()
    val loginErrorLiveDataData=MutableLiveData<String?>()


    var registerResponseLiveData=MutableLiveData<String>()
    val registerErrorLiveData=MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = UserRespository.Login(loginRequest)
            if (response.isSuccessful){
               loginResponseLiveData.postValue(response.body())

            }
            else {
                val error = response.errorBody()?.string()
                loginErrorLiveDataData.postValue(error)
            }

        }
    }
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch{
            val response=UserRespository.regester(registerRequest)
            if (response.isSucessful){
                registerResponseLiveData.postValue(response.body())
            }
            else{
                val error=response.errorBody()?.String()
                loginErrorLiveDataData.postValue(error)
            }

        }
    }

}