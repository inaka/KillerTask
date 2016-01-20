package com.inaka.killertask

import android.util.Log
import java.util.concurrent.CountDownLatch

/**
 * Created by inaka on 1/20/16.
 */
class Example {
    val signal = CountDownLatch(1);

    fun get() {
        KillerTask(
                doWork(),
                WhenDone(mapOf(
                        WhenDone.success to onSuccess,
                        WhenDone.failed to onFailed
                ))).go()
        signal.await()
    }

    fun doWork(): String {
        return "test"
    }

    val onSuccess: (String) -> Unit = {
        result: String ->
        Log.wtf("resultado", result)
        signal.countDown()
    }

    val onFailed: (Exception) -> Unit = {
        e: Exception ->
        Log.wtf("resultado", e.toString())
        e.printStackTrace()
        signal.countDown()
    }
}