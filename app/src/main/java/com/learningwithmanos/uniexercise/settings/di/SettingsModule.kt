package com.learningwithmanos.uniexercise.settings.di

import android.content.Context
import com.learningwithmanos.uniexercise.settings.repo.SettingsRepository
import com.learningwithmanos.uniexercise.settings.repo.SettingsRepositoryImpl
import com.learningwithmanos.uniexercise.settings.usecase.GetSharedPreferencesUC
import com.learningwithmanos.uniexercise.settings.usecase.GetSharedPreferencesUCImpl
import com.learningwithmanos.uniexercise.settings.usecase.SaveSharedPreferencesUC
import com.learningwithmanos.uniexercise.settings.usecase.SaveSharedPreferencesUCImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SettingsModule {

    //use case
    @Binds
    fun bindsGetSharedPreferencesUc(
        getSharedPreferencesImpl: GetSharedPreferencesUCImpl
    ): GetSharedPreferencesUC

    @Binds
    fun bindsSaveSharedPreferencesUc(
        saveSharedPreferencesUCImpl: SaveSharedPreferencesUCImpl
    ): SaveSharedPreferencesUC

    //repo
    @Binds
    fun bindsSettingsRepository(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository

}

@Module
@InstallIn(SingletonComponent::class)

object ContextModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context
}