package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsNicknameIT extends DriverBase {

    @Test
    public void testAccountSettingsNicknameIT() throws Exception {        driver.get(baseUrl + "/login");
        disableAnimations();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
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
        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        // General Settings
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("accountSettings"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("accountSettings")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("nicknameEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Click 'Edit' to add a nickname".equals(driver.findElement(By.id("nicknameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nicknameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("nickname"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nickname")).clear();
        driver.findElement(By.id("nickname")).sendKeys("");
        driver.findElement(By.id("nickname")).clear();
        driver.findElement(By.id("nickname")).sendKeys("Added Nick");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Added Nick".equals(driver.findElement(By.id("nicknameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nicknameEdit")).click();
        driver.findElement(By.id("nickname")).clear();
        driver.findElement(By.id("nickname")).sendKeys("Edited Nick");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edited Nick".equals(driver.findElement(By.id("nicknameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nicknameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("nickname"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nickname")).clear();
        driver.findElement(By.id("nickname")).sendKeys("");
        driver.findElement(By.id("nickname")).sendKeys("*" + Keys.BACK_SPACE);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Click 'Edit' to add a nickname".equals(driver.findElement(By.id("nicknameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.linkText("Town Square"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("logout"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("logout")).click();
    }
}
