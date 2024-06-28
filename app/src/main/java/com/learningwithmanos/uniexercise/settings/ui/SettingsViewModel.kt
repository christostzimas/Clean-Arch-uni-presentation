package com.learningwithmanos.uniexercise.settings.ui

import androidx.lifecycle.ViewModel
import com.learningwithmanos.uniexercise.settings.data.Input
import com.learningwithmanos.uniexercise.settings.usecase.GetSharedPreferencesUC
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.learningwithmanos.uniexercise.settings.usecase.SaveSharedPreferencesUC
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getSharedPreferences: GetSharedPreferencesUC,
    private val saveSharedPreferences: SaveSharedPreferencesUC,
) : ViewModel() {

    private val _publicKeyState = mutableStateOf(Input())
    val publicKeyState: State<Input> = _publicKeyState

    private val _privateKeyState = mutableStateOf(Input())
    val privateKeyState: State<Input> = _privateKeyState

    init {
        viewModelScope.launch {
            loadPublicKey()
            loadPrivateKey()
        }
    }

    /**
     * Loads the current value of the public key
     */
    private suspend fun loadPublicKey() {
        val publicKey = getSharedPreferences.getPublicKey() ?: ""
        _publicKeyState.value = Input(publicKey)
    }

    /**
     * Updates the value of the public key in shared preferences
     * @param value  The new value of the public key
     */
    suspend fun updatePublicKey(value: String) {
        _publicKeyState.value = Input(value)
        saveSharedPreferences.savePublicKey(value)
    }

    /**
     * Loads the current value of the private key
     */
    private suspend fun loadPrivateKey() {
        val privateKey = getSharedPreferences.getPrivateKey() ?: ""
        _privateKeyState.value = Input(privateKey)
    }

    /**
     * Updates the value of the private key in shared preferences
     * @param value  The new value of the private key
     */
    suspend fun updatePrivateKey(value: String) {
        _privateKeyState.value = Input(value)
        saveSharedPreferences.savePrivateKey(value)
    }


}