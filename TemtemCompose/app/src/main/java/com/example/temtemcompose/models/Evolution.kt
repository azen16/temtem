package com.example.temtemcompose.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Evolution(
    @SerializedName("stage")
    val stage: String?,
    @SerializedName("evolutionTree")
    val evolutionTree: ArrayList<EvolutionTree>?,
    @SerializedName("evolves")
    val evolves: Boolean?,
    @SerializedName("type")
    val type: String?
)
