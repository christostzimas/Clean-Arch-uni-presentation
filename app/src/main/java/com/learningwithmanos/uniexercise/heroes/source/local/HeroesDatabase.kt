package com.learningwithmanos.uniexercise.heroes.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learningwithmanos.uniexercise.heroes.data.HeroEntity

@Database(entities = [HeroEntity::class], version = 1, exportSchema = false)

abstract class HeroesDatabase: RoomDatabase() {
    abstract fun heroesDao(): HeroesDao
}