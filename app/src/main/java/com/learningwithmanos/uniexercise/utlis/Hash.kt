package com.learningwithmanos.uniexercise.utlis

import java.math.BigInteger
import java.security.MessageDigest

class Hash {

    companion object {
        /**
         * Converts a given string to its MD5 hash.
         * @return The MD5 hash of the string.
         */
        fun String.toMD5(): String {
            val md = MessageDigest.getInstance("MD5")
            val digest = md.digest(this.toByteArray())
            val bigInt = BigInteger(1, digest)
            return bigInt.toString(16).padStart(32, '0')
        }
    }
}
