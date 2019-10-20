package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class TeamSettingsNameDescIT extends DriverBase {

    @Test
    public void testTeamSettingsNameDescIT() throws Exception {        // LOG IN
        driver.get(baseUrl + "/login");
        disableAnimations();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("admin@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.linkText("Town Square")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Save team name with no changes
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("UI Automation".equals(driver.findElement(By.id("headerTeamName")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

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
        	try { if (isElementPresent(By.cssSelector("#teamSettings > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#teamSettings > button.style--none")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("UI Automation".equals(driver.findElement(By.id("nameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("UI Automation".equals(driver.findElement(By.id("headerTeamName")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#teamSettings > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#teamSettings > button.style--none")).click();
        // Team name required
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("nameEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Set the name of the team as it appears on your sign-in screen and at the top of the left-hand sidebar.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("saveSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("UI Automation".equals(driver.findElement(By.id("nameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("nameEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Set the name of the team as it appears on your sign-in screen and at the top of the left-hand sidebar.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        driver.findElement(By.id("teamName")).sendKeys("h" + Keys.BACK_SPACE);
        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("saveSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This field is required".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
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
        	try { if ("UI Automation".equals(driver.findElement(By.id("nameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Cancel out of team name changes
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edit".equals(driver.findElement(By.id("nameEdit")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Set the name of the team as it appears on your sign-in screen and at the top of the left-hand sidebar.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        driver.findElement(By.id("teamName")).sendKeys("h" + Keys.BACK_SPACE);
        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("cancelSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("cancelSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("UI Automation".equals(driver.findElement(By.id("nameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("UI Automation".equals(driver.findElement(By.id("headerTeamName")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#teamSettings > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#teamSettings > button.style--none")).click();
        // Edit Team Name
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edit".equals(driver.findElement(By.id("nameEdit")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Set the name of the team as it appears on your sign-in screen and at the top of the left-hand sidebar.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("Testing Team");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("saveSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Testing Team".equals(driver.findElement(By.id("nameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#teamSettings > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#teamSettings > button.style--none")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edit".equals(driver.findElement(By.id("nameEdit")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameEdit")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Special characters in team name
        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("()_+-={}|[]\\:");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("saveSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("()_+-={}|[]\\:".equals(driver.findElement(By.id("nameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("()_+-={}|[]\\:".equals(driver.findElement(By.id("headerTeamName")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#teamSettings > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#teamSettings > button.style--none")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        // Team name field max characters prevents typing
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edit".equals(driver.findElement(By.id("nameEdit")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        driver.findElement(By.id("teamName")).sendKeys("h" + Keys.BACK_SPACE);
        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("123456789012345%");
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("123456789012345".equals(driver.findElement(By.id("teamName")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("cancelSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("cancelSetting")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        // Set team name back to UI Automation
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edit".equals(driver.findElement(By.id("nameEdit")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameEdit")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("");
        driver.findElement(By.id("teamName")).clear();
        driver.findElement(By.id("teamName")).sendKeys("UI Automation");
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("saveSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("UI Automation".equals(driver.findElement(By.id("nameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        // Team description
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#teamSettings > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#teamSettings > button.style--none")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Click 'Edit' to add a team description.".equals(driver.findElement(By.id("descriptionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("descriptionEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("descriptionEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Team description provides additional information to help users select the right team. Maximum of 50 characters.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("teamDescription")).clear();
        driver.findElement(By.id("teamDescription")).sendKeys("");
        // Team description max characters prevents typing
        driver.findElement(By.id("teamDescription")).clear();
        driver.findElement(By.id("teamDescription")).sendKeys("This sentence contains 53 characters; I counted them.");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This sentence contains 53 characters; I counted th".equals(driver.findElement(By.id("teamDescription")).getAttribute("value"))) break; } catch (Exception e) {}
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
        	try { if ("Click 'Edit' to add a team description.".equals(driver.findElement(By.id("descriptionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("descriptionEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("descriptionEdit")).click();
        // Add team description
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamDescription"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("teamDescription")).clear();
        driver.findElement(By.id("teamDescription")).sendKeys("Testing the team description.");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("saveSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Testing the team description.".equals(driver.findElement(By.id("descriptionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Remove team description
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("descriptionEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("descriptionEdit")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("teamDescription"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.id("teamDescription")).clear();
        driver.findElement(By.id("teamDescription")).sendKeys("");
        driver.findElement(By.id("teamDescription")).clear();
        driver.findElement(By.id("teamDescription")).sendKeys("h" + Keys.BACK_SPACE);
        driver.findElement(By.id("teamDescription")).clear();
        driver.findElement(By.id("teamDescription")).sendKeys("");
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("saveSetting"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Click 'Edit' to add a team description.".equals(driver.findElement(By.id("descriptionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // LOG OUT
        driver.navigate().refresh();
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
