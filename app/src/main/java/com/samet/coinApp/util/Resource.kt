package com.samet.coinApp.util

sealed class Resource<out T> {

    data class Success<out T>(val data: T? = null) : Resource<T>()
    data class Loading(val nothing: Nothing? = null) : Resource<Nothing>()
    data class Failed(val error: String? = null) : Resource<Nothing>()
    data class Exception(val message: String? = null) : Resource<Nothing>()

}