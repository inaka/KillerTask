package com.inaka.killertask


import org.junit.Test
import com.inaka.killertask.DoThis
/**
 * Created by inaka on 1/19/16.
 */
class MainTest {
    @Test
    @Throws(Exception::class)
    fun createKillerTask() {

        KillerTask.perform(
                Action(doWork()),
                DoThis(mapOf(
                DoThis.ok to { result: String -> assert(result == "test")},
                DoThis.notOk to { e: Exception -> e.printStackTrace() }
        )))?.go()
    }

    fun doWork(): String{
        val isCancelled = false
        return "test"
    }
}