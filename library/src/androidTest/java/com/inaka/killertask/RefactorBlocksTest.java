package com.inaka.killertask;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;


public class RefactorBlocksTest extends AndroidTestCase {

    @UiThreadTest
    public void testLibraryFunctionsRefactor() {
        new ExampleBlocksRefactor();
    }

}
