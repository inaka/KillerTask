package com.inaka.killertask

import android.util.Log
import org.junit.Test

/**
 * Created by inaka on 1/19/16.
 */
class KillerMainTest_KotlinVersion {
    @Test
    fun createKillerTask() {
        KillerTask(doWork(), onSuccess, onFailed).go()
    }

    fun doWork(): String {
        return "test"
    }

    val onSuccess: (String) -> Unit = {
        result: String ->
        assert(result.equals("test"))
    }

    val onFailed: (Exception?) -> Unit = {
        e: Exception? ->
        e?.printStackTrace()
    }

}