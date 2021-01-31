package com.example.retrofitsample.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("id")
    val userId: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("username")
    val userName: String? = null,

    @SerializedName("email")
    val userEmail: String? = null,

    @SerializedName("address")
    val userAddressObject : Address? = null,

    @SerializedName("phone")
    val userPhone: String? = null,

    @SerializedName("website")
    val userWebsite: String? = null
    ) : Serializable



