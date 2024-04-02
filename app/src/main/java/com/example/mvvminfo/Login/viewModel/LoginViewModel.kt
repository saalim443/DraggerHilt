package com.example.mvvminfo.Login.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvminfo.constant.BaseResponse
import com.example.mvvminfo.Login.repo.UserRepository
import com.example.mvvminfo.Login.model.LoginRequest
import com.example.mvvminfo.Login.model.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val userRepo = UserRepository()
    val loginResult: MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()
    fun loginUser(email: String, pwd: String) {

        loginResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(
                    appVersion=72,
                    deviceBrand="vivo",
                    deviceModel="V2246",
                    mobileTokenID="",
                    password="12345",
                    username="Ahll03433",
                    batteryPercentage=42,
                    deviceId="9f14845b990a1537",
                    latitude=28.6349962,
                    longitude=77.3328689

                )
                val response = userRepo.loginUser(loginRequest = loginRequest)
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