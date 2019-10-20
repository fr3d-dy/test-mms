package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsUsernameIT extends DriverBase {

    @Test
    public void testAccountSettingsUsernameIT() throws Exception {        driver.get(baseUrl + "/login");
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
        	try { if (isElementPresent(By.id("usernameEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("usernameEdit")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("*" + Keys.BACK_SPACE);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("cancelSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("cancelSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("test".equals(driver.findElement(By.id("usernameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("usernameEdit")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("hi");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test2");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This username is already taken. Please choose another.".equals(driver.findElement(By.id("serverError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test-1");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("test-1".equals(driver.findElement(By.id("usernameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationsButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationsButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.id("keysDesc")).getText().matches("^\"@test-1\", \"test-1\"[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("generalButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("generalButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("usernameEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("usernameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("username"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("_test");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("all");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("channel");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("here");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("matterbot");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("test".equals(driver.findElement(By.id("usernameDesc")).getText())) break; } catch (Exception e) {}
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
