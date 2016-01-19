package com.inaka.killertask

interface Something<T> {

    @Throws(Exception::class)
    fun whichDoes(): T

}
