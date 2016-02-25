package com.inaka.killertask

import android.util.Log
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

private class ExampleVariableParametersTasks {

    val signal = CountDownLatch(1);

    init {
        // 1)
        KillerTask({ Log.wtf("LOG", "KillerTask is awesome") }).go() // only main task

        // 2)
        KillerTask(
                { Log.wtf("LOG", "KillerTask is awesome") }, // main task
                { Log.wtf("LOG", "Super awesome!")} // onSuccess
        ).go()

        // 3)
        KillerTask(
                { // main task
                    Log.wtf("LOG", "KillerTask is awesome")
                    "super" // implicit return
                },
                {}, // onSuccess is empty
                { e: Exception? -> Log.wtf("LOG", e.toString()) } // onFailed
        ).go()

        signal.await(5, TimeUnit.SECONDS)
    }

}