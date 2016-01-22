package com.inaka.killertask

import android.util.Log
import java.util.concurrent.CountDownLatch

/**
 * Created by inaka on 1/22/16.
 */
private class ExampleOnlyTask {

    init {
        KillerTask({ Log.wtf("LOG", "KillerTask is awesome") }).go()
    }

}