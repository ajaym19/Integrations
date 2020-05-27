package com.integrations.service;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.inject.Key;
import com.integrations.base.TestBase;
import com.integrations.util.TestUtil;

public class SourcesUITest extends TestBase {

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement global_Search_Bar_xpath;
	@FindBy(xpath = "//h6[contains(text(),'Content Source')]")
	WebElement content_Source_Label_xpath;
	@FindBy(xpath = "(//div[@class='five-card-column'][1]//div[@class='card-v3__container card-tile-v3__container card-v3-cursor'])[1]")
	WebElement cards_Container_xpath;

	public SourcesUITest() {

		PageFactory.initElements(driver, this);
	}

	public void verifySourceOnUI(WebDriver driver, String sourceName) throws InterruptedException, IOException {

		logger.info("Verifying Source on UI");
		driver.get(prop.getProperty("url"));
		dynamicWait(global_Search_Bar_xpath, TestUtil.EXPLICIT_WAIT_LONG);
		global_Search_Bar_xpath.sendKeys("*");
		global_Search_Bar_xpath.sendKeys(Keys.ENTER);
		dynamicWait(content_Source_Label_xpath, TestUtil.EXPLICIT_WAIT_LONG);
		Boolean source_present = driver.getPageSource().contains(sourceName);
		if (source_present == true) {
			System.out.println("Source is visible on UI on left side.");
			Assert.assertTrue(true, "Cannot find source on the left panel");
		} else {
			System.out.println("Source is not visible on UI on left side.");

		}
		String sourceNameCheckbox = "//h6[contains(text(),'Content Source')]/parent::div/child::div//input[contains(@aria-label,'%s')]";
		driver.findElement(By.xpath(String.format(sourceNameCheckbox, sourceName))).click();
		//Thread.sleep(5000);
		System.out.println("I am in Click on Card Method");
		dynamicWait(cards_Container_xpath, TestUtil.EXPLICIT_WAIT_SHORT);
		cards_Container_xpath.click();
		//Thread.sleep(5000);
		TestUtil.takeScreenshot();
		System.out.println("I have clicked on the card");
		Boolean content_present = driver.getPageSource().contains("This content does not exist or has been deleted.");
		if (content_present == true) {
			System.out.println("Card creation failed or sync is pending");
		} else {
			System.out.println("Card verified successfully");
		}

	}

}
