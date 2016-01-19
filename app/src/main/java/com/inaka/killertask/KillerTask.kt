package com.inaka.killertask

class KillerTask<T>{

    private var genericTask: GenericTask<T>? = null

    var something: Something<T>? = null

    var callback: DoThis<T>? = null

    private constructor(something: Something<T>) {
        this.something = something
    }

    private constructor(callback: DoThis<T>) {
        this.callback = callback
    }

    fun whenDone(callback: DoThis<Any>): KillerTask<Any>? {
        if (instance == null) {
            instance = KillerTask(callback)
        } else {
            instance!!.callback = callback
        }
        return instance
    }

    fun go() {
        if (genericTask == null) {
            genericTask = GenericTask(this)
            genericTask!!.execute()
        }
    }

    fun cancel() {
        if (genericTask != null) {
            genericTask!!.cancel(true)
        }
    }

    val isCancelled: Boolean = genericTask!!.isCancelled

    companion object {

        private var instance: KillerTask<Any>? = null

        fun perform(something: Something<Any>): KillerTask<Any>? {
            if (instance == null) {
                instance = KillerTask(something)
            } else {
                instance!!.something = something
            }
            return instance
        }


    }
}


