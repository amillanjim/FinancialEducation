package com.alexm.financialeducation.utils

sealed class DataState<T>(val data: T? = null, val message: String? = null, code: Int? = null){
    class Success<T>(data: T?): DataState<T>(data)
    class Error<T>(message: String, data: T? = null, code: Int? = null):
        DataState<T>(data, message, code)
    class Loading<T>(data: T? = null): DataState<T>(data)
    class Empty<T>: DataState<T>()
}