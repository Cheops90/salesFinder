package com.example.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver Instance = null;


    public static void initPage(Object pageObject) {
        if (Instance == null) {
            localInitialize();
        }

        PageFactory.initElements(Driver.Instance, pageObject);
//        ElementFactory.initElements(Driver.Instance, pageObject);
    }

    public static WebDriver localInitialize() {
        if (Instance == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\salesFinder\\salesFinder\\src\\ui_tests\\java\\com\\example\\utils\\chromedriver.exe");
            Instance = new ChromeDriver();
        }
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Instance.manage().window().maximize();
        return Instance;
    }

    public static void close() {
        Instance.close();
        Instance = null;
    }

    public static void quit() {
        Instance.quit();
        Instance = null;
    }

    public static WebElement waitForPresenceByLocator(By condition, int timeOut) {
        WebElement element = (new WebDriverWait(Driver.Instance, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(condition)));
        return element;
    }

    public static WebElement waitForClickableByElement(WebElement condition, int timeOut) {
        WebElement element = (new WebDriverWait(Driver.localInitialize(), timeOut)
                .until(ExpectedConditions.elementToBeClickable(condition)));
        return element;
    }
}
