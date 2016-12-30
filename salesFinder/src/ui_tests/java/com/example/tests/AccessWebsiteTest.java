package com.example.tests;


import com.example.pageobjects.HomePage;
import implementation.config.SalesResultsListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

@Listeners(SalesResultsListener.class)
public class AccessWebsiteTest extends BaseTest {

    @Test
    public void accessWebsite() {
        HomePage.ensureIsOnPage();

        assertTrue(HomePage.verifyLogoIsOnPage());
    }
}
