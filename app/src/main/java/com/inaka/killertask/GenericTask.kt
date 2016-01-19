package com.inaka.killertask

import android.os.AsyncTask

class GenericTask<T>(killerTask: KillerTask<T>) : AsyncTask<Void, Void, T>() {

    private val something: Something<T>
    private val callback: DoThis<T>
    private var exception: Exception? = null

    init {
        something = killerTask.something as Something<T>
        callback = killerTask.callback as DoThis<T>
    }

    override fun doInBackground(vararg params: Void): T? {
        try {
            return something.whichDoes()
        } catch (e: Exception) {
            exception = e
            return null
        }
    }

    override fun onPostExecute(result: T) {

        if (!isCancelled) {
            if (exception != null) {
                callback.ifNotOK(exception as Exception)
            } else {
                callback.ifOK(result)
            }
        } else {
            callback.ifNotOK(RuntimeException("task was cancelled"))
        }

    }

}
