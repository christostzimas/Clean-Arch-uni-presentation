package com.learningwithmanos.uniexercise.heroes.source.local

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.data.HeroEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Interface that wraps the local storage data framework that is used
 */
interface HeroLocalSource {

    /**
     * @return true if heroes are stored locally else false
     */
    fun isHeroDataStored(): Flow<Boolean>

    /**
     * Stores a list of heroes to the local data storage
     * @param heroes list of heroes to be stored
     */
    suspend fun storeHeroes(heroes: List<Hero>)

    /**
     * @return the list of heroes stored at the local storage
     */
    fun getHeroes(): Flow<List<Hero>>

    /**
    * @return true if local heroes don't exist
    */
    fun isEmpty(): Flow<Boolean>
}

class HeroLocalSourceImpl @Inject constructor(
    private val dbWrapper: DBWrapper,
    private val heroesDao: HeroesDao
): HeroLocalSource {
    override fun isHeroDataStored(): Flow<Boolean> {
        return dbWrapper.isHeroDataStored()
    }

    override suspend fun storeHeroes(heroes: List<Hero>) {
        //dbWrapper.storeHeroes(heroes = heroes)
        val heroesList: List<HeroEntity> = heroes.map {
            it.mapToHeroEntity()
        }
        heroesDao.insertHeroes(heroesList)
    }

    override fun getHeroes(): Flow<List<Hero>> {
        //return dbWrapper.getHeroes()
        return heroesDao.getAllHeroes().map{
            heroesList -> heroesList.map { it.mapToHero() }
        }
    }

    override fun isEmpty(): Flow<Boolean> {
        return heroesDao.isEmpty()
    }

    /**
    * Convert Hero object to HeroEntity object
    */
    private fun Hero.mapToHeroEntity() = HeroEntity (
        id = this.id,
        name = this.name,
        availableComics = this.availableComics,
        imageUrl = this.imageUrl
    )

    /**
     * Convert HeroEntity object to Hero object
     */
    private fun HeroEntity.mapToHero() = Hero (
        id = this.id,
        name = this.name,
        availableComics = this.availableComics,
        imageUrl = this.imageUrl
    )

}