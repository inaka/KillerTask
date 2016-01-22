package com.inaka.killertask;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;


/**
 * Created by inaka on 1/20/16.
 */
public class BlocksInsideTest extends AndroidTestCase {

    @UiThreadTest
    public void testLibraryWithBlocks() {
        new ExampleAllTogether();
    }

}
