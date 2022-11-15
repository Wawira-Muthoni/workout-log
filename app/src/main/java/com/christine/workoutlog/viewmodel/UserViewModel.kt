package com.christine.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.christine.workoutlog.models.LoginRequest
import com.christine.workoutlog.models.LoginResponse
import com.christine.workoutlog.models.RegisterRequest
import com.christine.workoutlog.models.RegisterResponse
import com.christine.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val userRepository = UserRepository()
    val loginResponseLivedata = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    var registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registerErrorLiveData = MutableLiveData<String?>()


    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful) {
                loginResponseLivedata.postValue(response.body())

            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

    fun registerUser(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.makeUserRequest(registerRequest)
            if (response.isSuccessful) {
                registerResponseLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }
}


                                                                                                                                                                                                                                                                                                                                                                                       //var registerResponseLiveData=MutableLiveData<RegisterResponse>()
