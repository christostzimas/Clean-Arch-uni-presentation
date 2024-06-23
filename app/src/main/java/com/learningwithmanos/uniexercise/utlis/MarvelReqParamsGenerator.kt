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
    private val privateKey: String? = "4ed3c347445ff672efdde319dd0c2f817034921d"
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
