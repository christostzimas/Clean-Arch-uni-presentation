package com.learningwithmanos.uniexercise.settings.usecase

import com.learningwithmanos.uniexercise.settings.repo.SettingsRepository
import javax.inject.Inject

/**
 * UC used to retrieve both private and public marvel api keys
 */
interface GetSharedPreferencesUC {
    suspend fun getPublicKey(): String?

    suspend fun getPrivateKey(): String?
}

class GetSharedPreferencesUCImpl @Inject constructor(
    private val settingsRepository: SettingsRepository
) : GetSharedPreferencesUC {
    override suspend fun getPublicKey(): String? {
        return settingsRepository.getPublicKey()
    }

    override suspend fun getPrivateKey(): String? {
        return settingsRepository.getPrivateKey()
    }
}