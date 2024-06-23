package com.learningwithmanos.uniexercise.heroes.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learningwithmanos.uniexercise.heroes.data.HeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroesDao {
    @Insert
    suspend fun insertHeroes(heroes: List<HeroEntity>)

    @Query("SELECT * FROM heroes")
    fun getAllHeroes(): Flow<List<HeroEntity>>

    @Query("SELECT COUNT(*) == 0 FROM heroes")
    fun isEmpty(): Flow<Boolean>
}