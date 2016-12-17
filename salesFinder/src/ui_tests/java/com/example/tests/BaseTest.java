package com.example.tests;


import com.example.utils.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void globalSetup() throws InterruptedException {
        Driver.localInitialize();
    }

    @AfterClass
    public void globalCleanup() {
        Driver.quit();
    }
}
