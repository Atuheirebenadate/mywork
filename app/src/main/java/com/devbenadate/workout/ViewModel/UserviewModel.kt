package com.devbenadate.workout.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devbenadate.workout.models.LoginRequest
import com.devbenadate.workout.models.LoginResponse
import com.devbenadate.workout.models.RegisterRequest
import com.devbenadate.workout.repository.UserRespository
import kotlinx.coroutines.launch
class UserViewModel:ViewModel() {

    val userRepository=UserRespository()
    //     val userRegister=RegisterRepository()
    var loginResponseLiveData= MutableLiveData<LoginResponse>()  //obser
    val loginErrorLiveData = MutableLiveData<String?>()  //for failure
    var registerResponseLiveData= MutableLiveData<RegisterRequest>()
    val registerErrorLiveData = MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.login(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())

            }
            else{
                val error = response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }

        }

    }
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.register(registerRequest)
            if (response.isSuccessful){
                registerResponseLiveData.postValue((response.body()))
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
            else{
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }

}