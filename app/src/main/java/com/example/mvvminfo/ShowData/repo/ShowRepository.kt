package com.example.mvvminfo.ShowData.repo

import com.example.mvvminfo.ShowData.model.ShowRequest
import com.example.mvvminfo.ShowData.model.ShowResponse
import com.example.mvvminfo.network.UserApi
import retrofit2.Response

class ShowRepository {
    suspend fun showUser(showRequest: ShowRequest, token: String): Response<ShowResponse>? {
        return  UserApi.getApi()?.loginShow(token = "Bearer $token",showRequest=showRequest)
    }
}