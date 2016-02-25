package com.inaka.killertask;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;


public class BlocksInsideTest extends AndroidTestCase {

    @UiThreadTest
    public void testLibraryWithBlocks() {
        new ExampleBlocksInside();
    }

}
