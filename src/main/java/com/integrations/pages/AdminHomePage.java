package com.integrations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.integrations.base.TestBase;
import com.integrations.util.TestUtil;

public class AdminHomePage extends TestBase{
	//t
	
	@FindBy(xpath = "//div[@class='links-container']//button[1]") WebElement adminLabel_xpath;
	@FindBy(xpath = "//ul[@class='sidebar-nav second-menu']//li//a//span[text()='Integrations']") WebElement content_Integration_Link_xpath;
	
	public AdminHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateAdminHomePageTitle() {
		dynamicWait(adminLabel_xpath,TestUtil.EXPLICIT_WAIT_LONG);
		return driver.getTitle();
		
	}
	
	public boolean validateAdminLabel() {
		dynamicWait(adminLabel_xpath,TestUtil.EXPLICIT_WAIT_LONG);
		return adminLabel_xpath.isDisplayed();
	}
	
	public ContentIntegrationPage clickOnContentIntegrationLink() throws InterruptedException {
		dynamicWait(content_Integration_Link_xpath,TestUtil.EXPLICIT_WAIT_SHORT);
		content_Integration_Link_xpath.click();
		Thread.sleep(5000);
		return new ContentIntegrationPage();
	}
	

}
