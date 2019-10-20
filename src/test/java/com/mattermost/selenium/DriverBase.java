package com.mattermost.selenium;

import com.mattermost.selenium.config.DriverFactory;
import com.mattermost.selenium.listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Listeners(ScreenshotListener.class)
public class DriverBase {
    protected WebDriver driver;
    protected String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;

    public static WebDriver getDriver() throws Exception {
        return driverFactory.get().getDriver();
    }

    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    @AfterSuite(alwaysRun = true)
    public static void closeDriverObjects() {
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        driver = getDriver();
        baseUrl = "http://localhost:8065/";
        
        //driver.manage().window().maximize();
        // driver.manage().window().setPosition(new Point(0,0));
        // java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        // Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        // driver.manage().window().setSize(dim);
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() throws Exception {
        driver.manage().deleteAllCookies();

        // String verificationErrorString = verificationErrors.toString();
        // if (!"".equals(verificationErrorString)) {
        //     fail(verificationErrorString);
        // }
    }

    public void disableAnimations() {
        String script = "var styleEl = document.createElement('style'); " +
                        "styleEl.textContent = '*{ " +
                        "    transition-property: none !important; " +
                        "    -o-transition-property: none !important; " +
                        "    -moz-transition-property: none !important; " +
                        "    -ms-transition-property: none !important; " +
                        "    -webkit-transition-property: none !important; " +
                        "    transform: none !important; " +
                        "    -o-transform: none !important; " +
                        "    -moz-transform: none !important; " +
                        "    -ms-transform: none !important; " +
                        "    -webkit-transform: none !important; " +
                        "    animation: none !important; " +
                        "    -o-animation: none !important; " +
                        "    -moz-animation: none !important; " +
                        "    -ms-animation: none !important; " +
                        "    -webkit-animation: none !important; " +
                        "}'; " +
                        "document.head.appendChild(styleEl); ";
        ((JavascriptExecutor) driver).executeScript(script);
    }

    protected boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    // protected String closeAlertAndGetItsText() {
    //     try {
    //         Alert alert = driver.switchTo().alert();
    //         String alertText = alert.getText();
    //         if (acceptNextAlert) {
    //             alert.accept();
    //         } else {
    //             alert.dismiss();
    //         }
    //             return alertText;
    //         } finally {
    //             acceptNextAlert = true;
    //         }
    //     }
    // }
}