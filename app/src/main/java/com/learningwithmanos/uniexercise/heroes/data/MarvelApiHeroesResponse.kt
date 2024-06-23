package com.learningwithmanos.uniexercise.heroes.data

import com.google.gson.annotations.SerializedName

data class MarvelApiHeroesResponse(
    @SerializedName("results")
    val results: List<MarvelApiHeroe>
)