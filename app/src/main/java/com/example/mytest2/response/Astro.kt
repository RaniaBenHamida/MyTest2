package com.example.mytest2.response

import com.google.gson.annotations.SerializedName

data class Astro(
    @SerializedName("copyright")
    val copyRight: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val urlHD: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val version: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val urlSimple: String
)

