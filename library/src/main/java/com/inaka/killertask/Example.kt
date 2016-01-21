package com.inaka.killertask

import android.util.Log
import java.util.concurrent.CountDownLatch

/**
 * Created by inaka on 1/20/16.
 */
private class Example {
    val signal = CountDownLatch(1);

    val onSuccess: (String) -> Unit = {
        result: String ->
        Log.wtf("result", result)
        signal.countDown()
    }

    val onFailed: (Exception?) -> Unit = {
        e: Exception? ->
        Log.wtf("result", e.toString())
        e?.printStackTrace()
        signal.countDown()
    }

    init {
        KillerTask(doWork(), onSuccess, onFailed).go()
        signal.await()
    }

    fun doWork(): String {
        return "test"
    }

}