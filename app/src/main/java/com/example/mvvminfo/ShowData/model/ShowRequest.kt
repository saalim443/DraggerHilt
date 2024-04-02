package com.example.mvvminfo.ShowData.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ShowRequest(
    @SerializedName("AppVersion") val appVersion: Int,
    @SerializedName("DeviceBrand") val deviceBrand: String,
    @SerializedName("DeviceModel") val deviceModel: String,
    @SerializedName("PhlebotomistID") val phlebotomistID: String,
    @SerializedName("batterypercentage") val batteryPercentage: Int,
    @SerializedName("deviceid") val deviceId: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
) : Serializable
