package com.inaka.killertask

import android.util.Log
import org.junit.Test

/**
 * Created by inaka on 1/19/16.
 */
class MainTest {
    @Test
    fun createKillerTask() {

        KillerTask(
                doWork(),
                WhenDone(mapOf(
                        WhenDone.success to onSuccess,
                        WhenDone.failed to onFailed
                ))).go()
    }

    fun doWork(): String {
        return "test"
    }

    val onSuccess: (String) -> Unit = {
        result: String ->
        Log.wtf("resultado", result)
        assert(result.equals("test"))
    }

    val onFailed: (Exception) -> Unit = {
        e: Exception ->
        Log.wtf("resultado", e.toString())
        print(e.message)
    }
}