package com.example.temtemcompose.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class TemTem (
    @SerializedName("number")
    val number: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("types")
    val types: ArrayList<String>?,
    @SerializedName("portraitWikiUrl")
    val portrait: String?,
    @SerializedName("wikiUrl")
    val wiki: String?,
    @SerializedName("stats")
    val stats: Map<String, String>?,
    @SerializedName("traits")
    val traits: ArrayList<String>?,
    @SerializedName("techniques")
    val techniques: ArrayList<Technique>?,
    @SerializedName("trivia")
    val trivia: ArrayList<String>?,
    @SerializedName("evolution")
    val evolution: Evolution?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("lumaIcon")
    val lumaIcon: String?,
    @SerializedName("genderRatio")
    val genderRatio: GenderRatio?,
    @SerializedName("catchRate")
    val catchRate: Int?,
    @SerializedName("hatchMins")
    val hatchMins: Double?,
    @SerializedName("tvYields")
    val tvYields: Map<String, String>?,
    @SerializedName("gameDescription")
    val description: String?
)

