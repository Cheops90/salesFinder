package com.example.tests;


import com.example.pageobjects.HomePage;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

public class AccessWebsiteTest extends BaseTest {

    @Test
    public void accessWebsite() {
        HomePage.ensureIsOnPage();

        assertTrue(HomePage.verifyLogoIsOnPage());
    }
}
