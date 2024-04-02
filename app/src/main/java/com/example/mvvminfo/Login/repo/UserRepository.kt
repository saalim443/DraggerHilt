package com.example.mvvminfo.Login.repo

import com.example.mvvminfo.Login.model.LoginRequest
import com.example.mvvminfo.Login.model.LoginResponse
import com.example.mvvminfo.network.UserApi
import retrofit2.Response

class UserRepository {

    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}