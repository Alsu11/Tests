package org.example;

import org.example.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = new ApplicationManager();
    }

    @After
    public void tearDown() {
        applicationManager.stop();
    }

}
