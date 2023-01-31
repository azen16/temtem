package com.example.temtemcompose.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionTree(
    @SerializedName("number")
    val number: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("stage")
    val stage: Int?,
    @SerializedName("levels")
    val levels: Int?,
    @SerializedName("trading")
    val trading: Boolean?,
    @SerializedName("traitMapping")
    val traitMapping: Map<String, String>?
)
