package com.example.todoparks


import com.google.gson.annotations.SerializedName

data class PlaceItem(
    @SerializedName("intro")
    val intro: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("score")
    val score: String
)