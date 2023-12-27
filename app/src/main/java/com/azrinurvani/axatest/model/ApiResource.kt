package com.azrinurvani.axatest.model

sealed class ApiResource<out R> private constructor(){
    data class Success<out T>(val data: T) : ApiResource<T>()
    data class Error(val error : Throwable) :ApiResource<Nothing>()
}
