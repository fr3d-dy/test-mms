package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsNotificationsIT extends DriverBase {

    @Test
    public void testAccountSettingsNotificationsIT() throws Exception {        // LOG IN
        driver.get(baseUrl + "/login");
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
        driver.findElement(By.id("accountSettings")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationsButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationsButton")).click();
        // Desktop notification
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("desktopEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopEdit")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Desktop notifications".equals(driver.findElement(By.id("settingTitle")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.id("desktopNotificationMentions")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.id("desktopDesc")).getText().matches("^For mentions and direct messages[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopEdit")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationNever"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (!driver.findElement(By.id("desktopNotificationNever")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopNotificationNever")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.id("desktopNotificationNever")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Off".equals(driver.findElement(By.id("desktopDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopEdit")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.id("desktopNotificationAllActivity")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.id("desktopDesc")).getText().matches("^For all activity[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Mobile push notifications
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Push notifications are not enabled".equals(driver.findElement(By.id("pushDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("pushEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("pushEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Push notifications have not been enabled by your System Administrator.".equals(driver.findElement(By.cssSelector("div.padding-top > span")).getText())) break; } catch (Exception e) {}
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
        	try { if ("Push notifications are not enabled".equals(driver.findElement(By.id("pushDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Words that trigger mentions
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Words that trigger mentions".equals(driver.findElement(By.id("keysTitle")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\", \"@here\"".equals(driver.findElement(By.id("keysDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("keysEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("keysEdit")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerUsername")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"@channel\", \"@all\", \"@here\"".equals(driver.findElement(By.id("keysDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("keysEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        driver.findElement(By.id("keysEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerShouts"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        driver.findElement(By.id("notificationTriggerShouts")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\"".equals(driver.findElement(By.id("keysDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("keysEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("keysEdit")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustomText"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustom"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerCustom")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustomText"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerCustomText")).clear();
        driver.findElement(By.id("notificationTriggerCustomText")).sendKeys("custom");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"custom\"".equals(driver.findElement(By.id("keysDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("keysEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("keysEdit")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("notificationTriggerCustom")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerShouts"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerShouts")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerUsername")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\", \"@here\"".equals(driver.findElement(By.id("keysDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Reply notification
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.id("commentsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("commentsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("commentsEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        driver.findElement(By.id("notificationCommentsAny")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("cancelSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("cancelSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.id("commentsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("commentsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("commentsEdit")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationCommentsAny")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Trigger notifications on messages in reply threads that I start or participate in".equals(driver.findElement(By.id("commentsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("commentsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("commentsEdit")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("notificationCommentsRoot")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Trigger notifications on messages in threads that I start".equals(driver.findElement(By.id("commentsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("commentsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("commentsEdit")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.id("notificationCommentsNever")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("In addition to notifications for when you're mentioned, select if you would like to receive notifications on reply threads.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.id("commentsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // LOG OUT
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.linkText("Town Square"))) break; } catch (Exception e) {}
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
