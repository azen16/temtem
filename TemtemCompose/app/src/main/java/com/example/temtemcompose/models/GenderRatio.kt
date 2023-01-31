package com.example.temtemcompose.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GenderRatio(
    @SerializedName("male")
    val male: Int?,
    @SerializedName("female")
    val female: Int?
)
