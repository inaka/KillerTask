package com.inaka.killertask

import android.util.Log
import java.util.concurrent.CountDownLatch

private class ExampleBlocksInside {
    val signal = CountDownLatch(1);

    init {
        KillerTask(
                // task
                { "test" },
                // onSuccess
                { result: String ->
                    Log.wtf("result", result)
                    signal.countDown()
                },
                // onFailed
                { e: Exception? ->
                    Log.wtf("result", e.toString())
                    e?.printStackTrace()
                    signal.countDown()
                }).go()

        signal.await()
    }

}