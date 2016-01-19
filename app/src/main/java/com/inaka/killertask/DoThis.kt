package com.inaka.killertask

interface DoThis<T> {
    fun ifOK(result: T)
    fun ifNotOK(e: Exception)
}
