package com.example.mvvminfo.Login.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class LoginRequest(
    @SerializedName("AppVersion") val appVersion: Int,
    @SerializedName("DeviceBrand") val deviceBrand: String,
    @SerializedName("DeviceModel") val deviceModel: String,
    @SerializedName("MobileTokenID") val mobileTokenID: String,
    @SerializedName("Password") val password: String,
    @SerializedName("Username") val username: String,
    @SerializedName("batterypercentage") val batteryPercentage: Int,
    @SerializedName("deviceid") val deviceId: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
) : Serializable


