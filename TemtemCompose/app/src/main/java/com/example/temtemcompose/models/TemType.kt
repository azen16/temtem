package com.example.temtemcompose.models

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class TemType(
    @SerializedName("name")
    val name: String?,
    @SerializedName("icon")
    val icon: String?
)