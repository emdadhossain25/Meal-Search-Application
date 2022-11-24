package com.example.mealsearchapplication.common

// this file is used for use cases emiting flows
// sealed classes is used for type of objects instead of enums
// this is a generic class
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}
