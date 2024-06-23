package com.learningwithmanos.uniexercise.heroes.source.remote

import com.learningwithmanos.uniexercise.heroes.data.MarvelApiHeroesResponse
import com.learningwithmanos.uniexercise.heroes.data.MarvelApiResponse
import com.learningwithmanos.uniexercise.utlis.MarvelApiClient
import com.learningwithmanos.uniexercise.utlis.MarvelApiEndpoints
import com.learningwithmanos.uniexercise.utlis.MarvelReqParamsGenerator
import javax.inject.Inject

private var client: MarvelApiEndpoints = MarvelApiClient.api
interface MarvelApi  {
    suspend fun getData(): MarvelApiResponse
}

class MarvelApiImpl @Inject constructor() : MarvelApi {

    override suspend fun getData(): MarvelApiResponse {
        var response = MarvelApiResponse(0, "", MarvelApiHeroesResponse(listOf()))
        try {
            val apiReqGenerator = MarvelReqParamsGenerator()
            val params = apiReqGenerator.createParams()
            response = client.getCharacters(
                params.timestamp,
                params.apiKey,
                params.hash
            )
        } catch (_: Exception) {
            response.data = MarvelApiHeroesResponse(listOf())
        }

        return response
    }

}