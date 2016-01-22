package com.inaka.killertask;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;

/**
 * Created by inaka on 1/22/16.
 */
public class VariableParametersTest extends AndroidTestCase {

    @UiThreadTest
    public void testLibraryWithBlocks() {
        new ExampleVariableParametersTasks();
    }

}
