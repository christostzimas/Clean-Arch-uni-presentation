package com.learningwithmanos.uniexercise.heroes.di

import com.learningwithmanos.uniexercise.heroes.repo.HeroRepository
import com.learningwithmanos.uniexercise.heroes.repo.HeroRepositoryImpl
import com.learningwithmanos.uniexercise.heroes.source.local.HeroLocalSource
import com.learningwithmanos.uniexercise.heroes.source.local.HeroLocalSourceImpl
import com.learningwithmanos.uniexercise.heroes.source.remote.HeroRemoteSource
import com.learningwithmanos.uniexercise.heroes.source.remote.HeroRemoteSourceImpl
import com.learningwithmanos.uniexercise.heroes.source.remote.MarvelApi
import com.learningwithmanos.uniexercise.heroes.source.remote.MarvelApiImpl
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByHighestNumberOfComicsUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByHighestNumberOfComicsUCImpl
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByNameUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByNameUCImpl
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesUCImpl
import com.learningwithmanos.uniexercise.settings.repo.SettingsRepository
import com.learningwithmanos.uniexercise.settings.repo.SettingsRepositoryImpl
import com.learningwithmanos.uniexercise.settings.usecase.GetSharedPreferencesUC
import com.learningwithmanos.uniexercise.settings.usecase.GetSharedPreferencesUCImpl
import com.learningwithmanos.uniexercise.settings.usecase.SaveSharedPreferencesUC
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface HeroesModule {

    // Usecase

    @Binds
    fun bindsGetHeroesUC(
        getHeroesUCImpl: GetHeroesUCImpl
    ): GetHeroesUC

    @Binds
    fun bindsGetHeroesSortedByNameUC(
        getHeroesSortedByNameUCImpl: GetHeroesSortedByNameUCImpl
    ): GetHeroesSortedByNameUC

    @Binds
    fun bindsGetHeroesSortedByHighestNumberOfComicsUC(
        getHeroesSortedByHighestNumberOfComicsUCImpl: GetHeroesSortedByHighestNumberOfComicsUCImpl
    ): GetHeroesSortedByHighestNumberOfComicsUC

    // Repository

    @Binds
    fun bindsHeroRepository(
        heroRepositoryImpl: HeroRepositoryImpl
    ): HeroRepository

    // Source

    @Binds
    @Singleton
    fun bindsHeroLocalSource(
        heroLocalSourceImpl: HeroLocalSourceImpl
    ): HeroLocalSource

    @Binds
    @Singleton
    fun bindsHeroRemoteSource(
        heroRemoteSourceImpl: HeroRemoteSourceImpl
    ): HeroRemoteSource

    // external frameworks
    @Binds
    fun bindMarvelApi(
        marvelApiImpl: MarvelApiImpl
    ): MarvelApi

}