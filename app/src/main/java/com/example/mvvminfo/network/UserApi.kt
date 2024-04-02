package com.example.mvvminfo.network

import com.example.mvvminfo.Login.model.LoginRequest
import com.example.mvvminfo.Login.model.LoginResponse
import com.example.mvvminfo.ShowData.model.ShowRequest
import com.example.mvvminfo.ShowData.model.ShowResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApi {

    @POST("api/Login/Login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("api/Home/SyncAllData")
    suspend fun loginShow(
        @Header("Authorization") token: String,
        @Body showRequest: ShowRequest
    ): Response<ShowResponse>



    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}