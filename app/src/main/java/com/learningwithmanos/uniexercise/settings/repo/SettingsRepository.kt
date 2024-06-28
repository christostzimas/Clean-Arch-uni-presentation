package com.learningwithmanos.uniexercise.settings.repo

import android.content.Context
import com.learningwithmanos.uniexercise.appPref
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * A repository interface that is used to to save and update the shared preferences
 */
interface SettingsRepository {

    /**
     * Retrieves the public key saved in shared preferences
     * @return public key string
     */
    suspend fun getPublicKey(): String?

    /**
     * Updates the public key value saved in shared preferences
     * @param value The updated value
     */
    suspend fun savePublicKey(value: String)

    /**
     * Retrieves the private key saved in shared preferences
     * @return private key string
     */
    suspend fun getPrivateKey(): String?

    /**
     * Updates the private key value saved in shared preferences
     * @param value The updated value
     */
    suspend fun savePrivateKey(value: String)

}

class SettingsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SettingsRepository {
    override suspend fun savePublicKey(value: String) {
        appPref.setup(context)
        appPref.apikey = value
    }

    override suspend fun getPublicKey(): String? {
        return appPref.apikey
    }

    override suspend fun getPrivateKey(): String? {
        return appPref.privatekey
    }

    override suspend fun savePrivateKey(value: String) {
        appPref.setup(context)
        appPref.privatekey = value
    }
}