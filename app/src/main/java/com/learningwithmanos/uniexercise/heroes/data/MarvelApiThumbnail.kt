package com.learningwithmanos.uniexercise.heroes.data

import com.google.gson.annotations.SerializedName

data class MarvelApiThumbnail (
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val ext: String
){
    fun toUrl(): String = "$path.$ext"
}