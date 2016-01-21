package com.inaka.killertask

import android.os.AsyncTask
import android.util.Log

class KillerTask<T>(val action: T, val callback: WhenDone<T>) : AsyncTask<Void, Void, T>() {

    private var exception: Exception? = null

    companion object {
        private val TAG = "KillerTask"
    }

    override fun doInBackground(vararg params: Void): T? {
        try {
            Log.wtf(TAG, "Enter to doInBackground")
            return run { action }
        } catch (e: Exception) {
            Log.wtf(TAG, "Error in background task")
            exception = e
            return null
        }
    }

    override fun onPostExecute(result: T) {
        Log.wtf(TAG, "Enter to onPostExecute")
        if (!isCancelled) {
            if (exception != null) {
                Log.wtf(TAG, "Failure with Exception")
                run { callback.failure(exception) }
            } else {
                Log.wtf(TAG, "Success")
                run { callback.success(result) }
            }
        } else {
            Log.wtf(TAG, "Failure with RuntimeException caused by task cancelled")
            run { callback.failure(RuntimeException("Task was cancelled")) }
        }
    }

    fun go() {
        execute()
    }

    fun cancel() {
        cancel(true)
    }

}


