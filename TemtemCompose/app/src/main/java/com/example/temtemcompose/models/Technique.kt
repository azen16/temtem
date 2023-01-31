package com.example.temtemcompose.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Technique(
    @SerializedName("name")
    val name: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("levels")
    val levels: String?
)
