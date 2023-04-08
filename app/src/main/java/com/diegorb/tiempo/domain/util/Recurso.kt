package com.diegorb.tiempo.domain.util

sealed class Recurso<T>(val data: T? = null, val msg: String? = null) {
    class Exito<T>(data: T?): Recurso<T>(data)
    class Error<T>(msg: String, data: T? = null): Recurso<T>(data, msg)
}
