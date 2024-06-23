package com.learningwithmanos.uniexercise.utlis

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApiClient {
    private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

    val api: MarvelApiEndpoints by lazy { Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(MarvelApiEndpoints::class.java)
    }
}