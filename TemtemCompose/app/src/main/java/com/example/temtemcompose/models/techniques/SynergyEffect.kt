package com.example.temtemcompose.models.techniques

import com.google.gson.annotations.SerializedName

data class SynergyEffect(
    @SerializedName("effect")
    val effect: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("damage")
    val damage: Int?
)
