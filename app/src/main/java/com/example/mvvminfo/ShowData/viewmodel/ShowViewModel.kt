package com.example.mvvminfo.ShowData.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvminfo.ShowData.repo.ShowRepository
import com.example.mvvminfo.ShowData.model.ShowRequest
import com.example.mvvminfo.ShowData.model.ShowResponse
import com.example.mvvminfo.constant.BaseResponse
import kotlinx.coroutines.launch

class ShowViewModel(application: Application) : AndroidViewModel(application) {

    val userRepo = ShowRepository()
    val loginResult: MutableLiveData<BaseResponse<ShowResponse>> = MutableLiveData()
    fun loginUser(token: String) {

        loginResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {

                val showRequest = ShowRequest(
                    appVersion=72,
                    deviceBrand="vivo",
                    deviceModel="V2246",
                    phlebotomistID="22",
                    batteryPercentage=45,
                    deviceId="9f14845b990a1537",
                    latitude=28.6349881,
                    longitude=77.332813,


                )
                val response = userRepo.showUser(showRequest = showRequest,token=token)
                Log.i("suussssssss",response!!.body().toString())
                if (response?.code() == 200) {
                    loginResult.value = BaseResponse.Success(response.body())
                } else {
                    loginResult.value = BaseResponse.Error(response?.message())
                }

            } catch (ex: Exception) {
                loginResult.value = BaseResponse.Error(ex.message)
            }
        }
    }






}