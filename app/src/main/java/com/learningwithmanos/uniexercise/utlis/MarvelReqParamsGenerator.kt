package com.learningwithmanos.uniexercise.utlis

import com.learningwithmanos.uniexercise.appPref
import com.learningwithmanos.uniexercise.utlis.Hash.Companion.toMD5

data class Params(
    val timestamp: Long?,
    val apiKey: String?,
    val hash: String?
)

class MarvelReqParamsGenerator {

    val apiKey: String? = appPref.apikey //public key
    private val privateKey: String? = appPref.privatekey
    var timestamp: Long? = null
    var hash: String? = null

    init {
        setRequestParams()
    }

    fun createParams(): Params{
        return Params(
            timestamp = timestamp,
            apiKey = apiKey,
            hash = hash
        )
    }
    private fun setRequestParams() {
        timestamp = System.currentTimeMillis()
        val currentData: String = timestamp.toString() + privateKey + apiKey
        hash = currentData.toMD5()
    }
}
