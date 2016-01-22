package com.inaka.killertask

import android.os.AsyncTask
import android.util.Log

class KillerTask<T>(val task: () -> T, val onSuccess: (T) -> Any, val onFailed: (Exception?) -> Any) : AsyncTask<Void, Void, T>() {

    private var exception: Exception? = null

    companion object {
        private val TAG = "KillerTask"
    }

    /**
     * Override AsyncTask's function doInBackground
     */
    override fun doInBackground(vararg params: Void): T? {
        try {
            Log.wtf(TAG, "Enter to doInBackground")
            return run { task() }
        } catch (e: Exception) {
            Log.wtf(TAG, "Error in background task")
            exception = e
            return null
        }
    }

    /**
     * Override AsyncTask's function onPostExecute
     */
    override fun onPostExecute(result: T) {
        Log.wtf(TAG, "Enter to onPostExecute")
        if (!isCancelled) {
            // task not cancelled
            if (exception != null) {
                Log.wtf(TAG, "Failure with Exception")
                run { onFailed(exception) }
            } else {
                Log.wtf(TAG, "Success")
                run { onSuccess(result) }
            }
        } else {
            // task cancelled
            Log.wtf(TAG, "Failure with RuntimeException caused by task cancelled")
            run { onFailed(RuntimeException("Task was cancelled")) }
        }
    }

    /**
     * Execute AsyncTask
     */
    fun go() {
        execute()
    }

    /**
     * Cancel AsyncTask
     */
    fun cancel() {
        cancel(true)
    }

}


