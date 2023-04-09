package com.diegorb.tiempo.domain.util

sealed class Resource<T>(val data: T? = null, val msg: String? = null) {
    class Exito<T>(data: T?): Resource<T>(data)
    class Error<T>(msg: String, data: T? = null): Resource<T>(data, msg)
}
