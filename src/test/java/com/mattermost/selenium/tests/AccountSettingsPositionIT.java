package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsPositionIT extends DriverBase {

    @Test
    public void testAccountSettingsPositionIT() throws Exception {        driver.get(baseUrl + "/login");
        disableAnimations();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("loginButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        // General Settings
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#accountSettings > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#accountSettings > button.style--none")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Click 'Edit' to add your job title / position".equals(driver.findElement(By.id("positionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("positionEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("positionEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("position"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("Tester");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Tester".equals(driver.findElement(By.id("positionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("positionEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("positionEdit")).click();
        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("Edited Tester");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edited Tester".equals(driver.findElement(By.id("positionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("positionEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("positionEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("position"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("Temp");
        driver.findElement(By.id("cancelSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edited Tester".equals(driver.findElement(By.id("positionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("positionEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("positionEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("position"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("");
        driver.findElement(By.id("position")).sendKeys("*" + Keys.BACK_SPACE);
        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Click 'Edit' to add your job title / position".equals(driver.findElement(By.id("positionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.close"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.close")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#logout > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#logout > button.style--none")).click();
    }
}
