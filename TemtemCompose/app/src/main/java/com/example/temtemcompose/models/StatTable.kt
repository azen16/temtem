package com.example.temtemcompose.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class StatTable(
    @SerializedName("hp")
    val hp: String?,
    @SerializedName("sta")
    val stamina: String?,
    @SerializedName("spd")
    val speed: String?,
    @SerializedName("atk")
    val attack: String?,
    @SerializedName("def")
    val defense: String?,
    @SerializedName("spatk")
    val specAttack: String?,
    @SerializedName("spdef")
    val specDefense: String?,
    @SerializedName("total")
    val total: String?
)
