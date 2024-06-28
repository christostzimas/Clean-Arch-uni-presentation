package com.learningwithmanos.uniexercise.settings.usecase

import com.learningwithmanos.uniexercise.settings.repo.SettingsRepository
import javax.inject.Inject

/**
 * UC used to update both private and public marvel api keys
 */
interface SaveSharedPreferencesUC {
    suspend fun savePrivateKey(value: String)
    suspend fun savePublicKey(value: String)
}

class SaveSharedPreferencesUCImpl @Inject constructor(
    private val settingsRepository: SettingsRepository
) : SaveSharedPreferencesUC {
    override suspend fun savePrivateKey(value: String) {
        settingsRepository.savePrivateKey(value)
    }

    override suspend fun savePublicKey(value: String) {
        settingsRepository.savePublicKey(value)
    }
}