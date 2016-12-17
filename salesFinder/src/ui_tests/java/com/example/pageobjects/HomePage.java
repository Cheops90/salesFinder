package com.example.pageobjects;


import com.example.configuration.Configuration;
import com.example.utils.Driver;
import org.openqa.selenium.By;


public class HomePage {
    private static final String URL_APP = Configuration.Url.url_wizz;

    public static void ensureIsOnPage() {
        if (!isOn()) {
            goTo();
        }
    }

    public static void goTo() {
        Driver.Instance.navigate().to(URL_APP);
    }

    public static boolean isOn() {
        return Driver.Instance.getCurrentUrl().equals(URL_APP);
    }

    public static HomeCommand accessWebsite() throws InterruptedException {
        ensureIsOnPage();
        return new HomeCommand();
    }

    public static boolean verifyLogoIsOnPage() {
        boolean isDisplayed = true;
        Driver.Instance.findElement(By.cssSelector("div.flight-search__panel__logo img[src='https://wizzair.com/static/prod/resourcepackages/wizzair/mvc/assets/images/wizz-logo--gradient_e4a6a8ed4f40d5cc83ddf15b32cb9f89.svg']")).isDisplayed();
        return isDisplayed;
    }

    public static class HomeCommand {


        public HomeCommand() throws InterruptedException {
            Driver.initPage(this);
        }
    }
}

