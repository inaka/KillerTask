package com.inaka.killertask;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;


/**
 * Created by inaka on 1/21/16.
 */
public class KillerTaskFunctionsTest extends AndroidTestCase {

    @UiThreadTest
    public void testLibraryFunctionsRefactor() {
        new ExampleFunctionsRefactor();
    }

}
