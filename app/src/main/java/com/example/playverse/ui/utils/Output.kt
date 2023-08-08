package com.example.playverse.ui.utils

sealed class Output<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Output<T>(data)
    class Loading<T>(data: T? = null) : Output<T>(data)
    class Error<T>(message: String, data: T? = null) : Output<T>(data, message)
    class Idle<T>(data: T? = null) : Output<T>(data)
}
