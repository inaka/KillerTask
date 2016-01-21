package com.inaka.killertask

import android.os.AsyncTask
import android.util.Log

class KillerTask<T>(val action: T, val callback: WhenDone<Any>) : AsyncTask<Void, Void, T>() {

    private var exception: Exception? = null

    companion object {
        private val TAG = "KillerTask"
    }

    override fun doInBackground(vararg params: Void): T? {
        try {
            Log.wtf(TAG, "enter to doInBackground")
            return run { action }
        } catch (e: Exception) {
            Log.wtf(TAG, "error in task doing in background")
            exception = e
            return null
        }
    }

    override fun onPostExecute(result: T) {
        Log.wtf(TAG, "enter to onPostExecute")
        if (!isCancelled) {
            if (exception != null) {
                Log.wtf(TAG, "failure with Exception")
                run { callback.failure(exception) }
            } else {
                Log.wtf(TAG, "success")
                run { callback.success(result as Any) }
            }
        } else {
            Log.wtf(TAG, "failure RuntimeException / cancel task")
            run { callback.failure(RuntimeException("task was cancelled")) }
        }
    }

    fun go() {
        execute()
    }

    fun cancel() {
        cancel(true)
    }

}


