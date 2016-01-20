package com.inaka.killertask;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;


/**
 * Created by inaka on 1/20/16.
 */
public class AndroidTest extends AndroidTestCase {

    @UiThreadTest
    public void testLibrary(){
        new Example().get();
    }
}
