package com.learningwithmanos.uniexercise.heroes.source.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideHeroeDao(heroesDb: HeroesDatabase): HeroesDao {
        return heroesDb.heroesDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): HeroesDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            HeroesDatabase::class.java,
            "marvelHeroes.db"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

}