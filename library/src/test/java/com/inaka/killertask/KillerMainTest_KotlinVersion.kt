package com.inaka.killertask

import org.junit.Test

/**
 * Created by inaka on 1/19/16.
 */
class KillerMainTest_KotlinVersion {
    @Test
    fun createKillerTask() {
        KillerTask(doWork, onSuccess, onFailed).go()

        /*
            That is the same as:

               KillerTask({ "test" }, {
                    result: String ->
                    assert(result.equals("test"))
                }, {
                    e: Exception? ->
                    e?.printStackTrace()
                    print(e?.message)
                }).go()
         */
    }

    val doWork: () -> String = {
        "test"
    }

    val onSuccess: (String) -> Unit = {
        result: String ->
        assert(result.equals("test"))
    }

    val onFailed: (Exception?) -> Unit = {
        e: Exception? ->
        e?.printStackTrace()
        print(e?.message)
    }

}