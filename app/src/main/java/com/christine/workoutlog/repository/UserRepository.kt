package com.christine.workoutlog.repository

import com.christine.workoutlog.api.ApiClient
import com.christine.workoutlog.api.ApiInterface
import com.christine.workoutlog.models.LoginRequest
import com.christine.workoutlog.models.LoginResponse
import com.christine.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>
     = withContext(Dispatchers.IO){
         val response = apiClient.loginUser(loginRequest)
         return@withContext response
     }
    suspend fun makeUserRequest(registerRequest: RegisterRequest)
            = withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequest)
        return@withContext response
    }
}