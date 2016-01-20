package com.inaka.killertask

import android.os.AsyncTask

class KillerTask<T>(val action: T, val callback: WhenDone<Any>) : AsyncTask<Void, Void, T>() {

    private var exception: Exception? = null

    companion object {
        private var instance: KillerTask<Any>? = null

        fun perform(action: () -> Any, callback: WhenDone<Any>): KillerTask<Any> {
            return KillerTask(action, callback)
        }
    }

    override fun doInBackground(vararg params: Void): T? {
        try {
            return run { action }
        } catch (e: Exception) {
            exception = e
            return null
        }
    }

    override fun onPostExecute(result: T) {
        if (!isCancelled) {
            if (exception != null) {
                callback.failure.run { exception }
            } else {
                callback.success.run { result }
            }
        } else {
            callback.failure.run { java.lang.RuntimeException("task was cancelled") }
        }
    }

    fun go() {
        execute()
    }

    fun cancel() {
        cancel(true)
    }

}


