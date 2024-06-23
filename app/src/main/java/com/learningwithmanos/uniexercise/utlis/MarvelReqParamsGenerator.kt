package com.learningwithmanos.uniexercise.utlis

import com.learningwithmanos.uniexercise.appPref
import java.math.BigInteger
import java.security.MessageDigest

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
        );
    }
    private fun setRequestParams() {
        timestamp = System.currentTimeMillis()
        val currentData: String = timestamp.toString() + privateKey + apiKey
        hash = currentData.toMD5()
    }

    //TODO: Move it
    fun String.toMD5(): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(toByteArray())
        val bigInt = BigInteger(1, digest)
        return bigInt.toString(16).padStart(32, '0')
    }
}
