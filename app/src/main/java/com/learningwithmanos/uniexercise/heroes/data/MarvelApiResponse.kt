package com.learningwithmanos.uniexercise.heroes.data

import com.google.gson.annotations.SerializedName

data class MarvelApiResponse(
    @SerializedName("code")
    var code: Int,

    @SerializedName("status")
    var status: String,

    @SerializedName("data")
    var data: MarvelApiHeroesResponse
)