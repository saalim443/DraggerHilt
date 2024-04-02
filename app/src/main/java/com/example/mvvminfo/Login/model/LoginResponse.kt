package com.example.mvvminfo.Login.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("data") val data: List<Data>,
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Boolean
) : Serializable

data class Data(
    @SerializedName("Age") val age: String,
    @SerializedName("DeviceID") val deviceID: String,
    @SerializedName("Gender") val gender: String,
    @SerializedName("LoginExpiry") val loginExpiry: String,
    @SerializedName("Mobile") val mobile: String,
    @SerializedName("NAME") val name: String,
    @SerializedName("PhlebotomistID") val phlebotomistID: Int,
    @SerializedName("PrinterMacAddress") val printerMacAddress: String,
    @SerializedName("Token") val token: String,
    @SerializedName("username") val username: String
) : Serializable

