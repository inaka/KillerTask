package com.inaka.killertask

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Created by inaka on 1/20/16.
 */
class Example {

    fun get(){
        var signal = CountDownLatch(1);

        KillerTask.perform(
                {doWork()},
                WhenDone(mapOf(
                        WhenDone.onSuccess.begin() to {
                            result: String ->
                            {
                                signal.countDown()
                                assert(result == "test")
                            }
                        },
                        WhenDone.onFailure.begin() to {
                            e: Exception ->
                            {
                                signal.countDown()
                                print(e.message)
                            }
                        }
                ))).go()

        signal.await();
    }

    fun doWork(): String {
        return "test"
    }
}