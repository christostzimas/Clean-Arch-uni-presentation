package com.learningwithmanos.uniexercise.heroes.source.remote

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.data.MarvelApiHeroe
import com.learningwithmanos.uniexercise.heroes.data.MarvelApiResponse
import javax.inject.Inject

/**
 * Interface that wraps the framework that is used for the Rest calls
 */
interface HeroRemoteSource {

    /**
     * @return retrieves the a list of heroes from a certain endpoint
     */
    suspend fun getHeroes(): List<Hero>
}

class HeroRemoteSourceImpl @Inject constructor(
    //private val restFrameworkWrapper: DummyRestFrameworkWrapper,
    private val marvelApi: MarvelApi,
): HeroRemoteSource {

    override suspend fun getHeroes(): List<Hero> {
        val response: MarvelApiResponse = marvelApi.getData()

        return if (response.code == 200) {

            response.data.results.map {
                it.mapToHero()
            }
        } else {
            emptyList()
        }
    }


    private fun MarvelApiHeroe.mapToHero(): Hero {
        return Hero(
            id = this.id,
            name = this.name,
            availableComics = this.availableComics.availableComics,
            imageUrl = this.imageUrl.toUrl()
        )
    }
}

