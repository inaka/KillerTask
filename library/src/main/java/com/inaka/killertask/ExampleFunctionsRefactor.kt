package com.inaka.killertask

import android.util.Log
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import java.util.concurrent.CountDownLatch

/**
 * Created by inaka on 1/21/16.
 */
private class ExampleFunctionsRefactor {
    val signal = CountDownLatch(1);

    val onSuccess: (String) -> Unit = {
        result: String ->
        Log.wtf("success result", result)
        signal.countDown()
    }

    val onFailed: (Exception?) -> Unit = {
        e: Exception? ->
        Log.wtf("error result", e.toString())
        e?.printStackTrace()
        signal.countDown()
    }

    val doWork: () -> String = {
        var connection: URLConnection? = null;

        try{
            var url = URL("https://inaka.net/blog")
            connection = url.openConnection();
        }catch (e: Exception){
            e.printStackTrace()
        }

        var httpConn = connection as HttpURLConnection;
        httpConn.connectTimeout = 3000;
        httpConn.readTimeout = 5000;

        // return
        httpConn.responseCode.toString()
    }

    init {
        KillerTask(doWork, onSuccess, onFailed).go()
        signal.await()
    }

}