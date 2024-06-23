package com.learningwithmanos.uniexercise.utlis

import com.learningwithmanos.uniexercise.heroes.data.MarvelApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiEndpoints {
    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") timestamp: Long?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?,
        //@Query("limit") limit: Int?,
        //@Query("offset") offset: Int?
    ): MarvelApiResponse
}