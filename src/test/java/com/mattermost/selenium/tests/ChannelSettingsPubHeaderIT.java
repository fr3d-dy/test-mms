package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class ChannelSettingsPubHeaderIT extends DriverBase {

    @Test
    public void testChannelSettingsPubHeaderIT() throws Exception {        // LOG IN
        driver.get(baseUrl + "/login");
        disableAnimations();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
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

        // PUBLIC CHANNEL
        // Add Public Channel from + icon, without header
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("createPublicChannel"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("createPublicChannel")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("newChannelName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("newChannelName")).clear();
        driver.findElement(By.id("newChannelName")).sendKeys("");
        driver.findElement(By.id("newChannelName")).clear();
        driver.findElement(By.id("newChannelName")).sendKeys("headertest");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("URL: /headertest (Edit)".equals(driver.findElement(By.cssSelector("p.input__help.dark")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("form.form-horizontal > div.modal-footer > button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("form.form-horizontal > div.modal-footer > button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Beginning of headertest".equals(driver.findElement(By.cssSelector("h4.channel-intro__title > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("p.channel-intro__content > span > span")).getText().matches("^This is the start of the headertest channel, created by admin[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Invite others to this channel".equals(driver.findElement(By.xpath("//div[@id='channelIntro']/button")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("strong.heading")).click();
        // View channel info without header
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("li#channelViewInfo.MenuItem button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("li#channelViewInfo.MenuItem button.style--none")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("#channelInfoModalLabel > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertThat("Header:", is(not(driver.findElement(By.cssSelector("div.info__label > span")).getText())));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("div.about-modal.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        driver.navigate().refresh();
        // Add header using `Add a channel description` placeholder link
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Add a channel description".equals(driver.findElement(By.cssSelector("div.channel-header__description.light > button.style--none")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.channel-header__description.light > button.style--none")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Edit the text appearing next to the channel name in the channel header.".equals(driver.findElement(By.cssSelector("div.modal-body.edit-modal-body > div > p > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("edit_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Verify header 1024 character limit
        driver.findElement(By.id("edit_textbox")).sendKeys("https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.htm&");
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.htm&".equals(driver.findElement(By.id("edit_textbox")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary.save-button"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-primary.save-button")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This channel header is too long, please enter a shorter one".equals(driver.findElement(By.cssSelector("label.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Add header using `Set a Header` link
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[@id='channelIntro']/button[2]"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[@id='channelIntro']/button[2]")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("edit_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("edit_textbox")).sendKeys("*Header");
        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary.save-button"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-primary.save-button")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("p.markdown__paragraph-inline")).getText().matches("^[\\s\\S]*Header$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(2000);
        Thread.sleep(2000);
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("channelHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("channelHeaderDropdownButton")).click();
        // Verify channel info with header
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("li#channelViewInfo.MenuItem button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("li#channelViewInfo.MenuItem button.style--none")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("#channelInfoModalLabel > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("div.info__value > p")).getText().matches("^[\\s\\S]*Header$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.about-modal.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        driver.navigate().refresh();
        // Edit header, use markdown
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("channelHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("channelHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#channelEditHeader > button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#channelEditHeader > button.style--none")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("edit_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("edit_textbox")).sendKeys("* " + Keys.SHIFT + Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("edit_textbox")).sendKeys("- Item 1 " + Keys.SHIFT + Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("edit_textbox")).sendKeys("- [Item 2 is a link](http://google.com)");
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary.save-button"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-primary.save-button")).click();
        Thread.sleep(2000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Header".equals(driver.findElement(By.cssSelector("em")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("em")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Header".equals(driver.findElement(By.cssSelector("div.popover-content > p > em")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Item 1".equals(driver.findElement(By.cssSelector("div.popover-content > ul > li")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Item 2 is a link".equals(driver.findElement(By.xpath("(//a[contains(text(),'Item 2 is a link')])[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.linkText("Item 2 is a link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("em")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("channelHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("channelHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("li#channelViewInfo.MenuItem button.style--none"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("li#channelViewInfo.MenuItem button.style--none")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("#channelInfoModalLabel > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Header".equals(driver.findElement(By.cssSelector("div.info__value > p > em")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Item 1".equals(driver.findElement(By.cssSelector("div.info__value > ul > li")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Item 2 is a link".equals(driver.findElement(By.xpath("(//a[contains(text(),'Item 2 is a link')])[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.about-modal.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        // LOG OUT
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
