package com.mattermost.selenium.config;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.fail;

public class WaitFirefoxDriver extends FirefoxDriver {
    WaitFirefoxDriver(DesiredCapabilities caps) {
        super(caps);
    }

    WaitFirefoxDriver(FirefoxOptions ops) {
        super(ops);
    }

    @Override
    public WebElement findElement(By by) {
        for (int second = 0;; second++) {
            if (second >= 15)
                throw new NoSuchElementException("Mattermost WaitDriver couldn't fine the element");
            
            try {
                if (super.findElements(by).size() > 0) break;
            } catch (Exception e) {}
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }

        return super.findElement(by);
    }
}
    