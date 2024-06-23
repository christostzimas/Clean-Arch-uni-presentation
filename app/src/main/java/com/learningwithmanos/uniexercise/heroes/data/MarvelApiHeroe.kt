package com.learningwithmanos.uniexercise.heroes.data

import com.google.gson.annotations.SerializedName

data class MarvelApiHeroe(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("comics")
    var availableComics: MarvelApiComics,

    @SerializedName("thumbnail")
    var imageUrl: MarvelApiThumbnail
)