package com.example.temtemcompose.models.techniques

import com.google.gson.annotations.SerializedName

data class TechniqueInfo(
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("classIcon")
    val classIcon: String?,
    @SerializedName("damage")
    val damage: Int?,
    @SerializedName("staminaCost")
    val staminaCost: Int?,
    @SerializedName("hold")
    val hold: Int?,
    @SerializedName("priorityIcon")
    val priorityIcon: String?,
    @SerializedName("synergy")
    val synergy: String?,
    @SerializedName("synergyEffect")
    val synergyEffects: ArrayList<SynergyEffect>?,
    @SerializedName("targets")
    val targets: String?,
    @SerializedName("description")
    val description: String?
)