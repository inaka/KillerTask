package com.inaka.killertask

import com.inaka.killertask.WhenDone.onFailure
import com.inaka.killertask.WhenDone.onSuccess
import org.junit.Test

/**
 * Created by inaka on 1/19/16.
 */
class MainTest {
    @Test
    fun createKillerTask() {

        KillerTask.perform(
                doWork(),
                WhenDone(mapOf(
                        onSuccess.begin() to {
                            result: String ->
                            assert(result.equals("test"))
                        },
                        onFailure.begin() to {
                            e: Exception ->
                            print(e.message)
                        }
                ))).go()
    }

    fun doWork(): String {
        return "test"
    }
}