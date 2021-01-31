package com.example.retrofitsample.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address(

    @SerializedName("street")
    val streetAddress: String? = null,

    @SerializedName("suite")
    val suiteAddress: String? = null,

    @SerializedName("city")
    val cityAddress: String? = null,

    @SerializedName("zipcode")
    val zipCodeAddress: String? = null

) : Serializable