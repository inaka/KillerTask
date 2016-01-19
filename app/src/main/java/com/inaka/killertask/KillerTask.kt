package com.inaka.killertask

class KillerTask<T>{

    private var genericTask: GenericTask<T>? = null

    var action: Action<T>? = null

    var callback: DoThis<T>? = null

    private constructor(action: Action<T>) {
        this.action = action
    }

    private constructor(callback: DoThis<T>) {
        this.callback = callback
    }

    private constructor(action: Action<T>, callback: DoThis<T>) {
        this.action = action
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

    val isCancelled: Boolean? = genericTask?.isCancelled

    companion object {

        private var instance: KillerTask<Any>? = null

        fun perform(action: Action<Any>): KillerTask<Any>? {
            if (instance == null) {
                instance = KillerTask(action)
            } else {
                instance!!.action = action
            }
            return instance
        }

        fun perform(action: Action<Any>, callback: DoThis<Any>): KillerTask<Any>?{
            if (instance == null) {
                instance = KillerTask(action, callback)
            } else {
                instance!!.action = action
                instance!!.callback = callback
            }
            return instance
        }
    }
}


