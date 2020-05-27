package com.integrations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.integrations.base.TestBase;
import com.integrations.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath="//div[@aria-label='Profile']//span//span") WebElement user_Name_xpath;
	@FindBy(xpath = "//span[@class = 'username-redesign' and text() = 'More']") WebElement more_Button_xpath;
	@FindBy(xpath = "//div[contains(text(),'Admin')]") WebElement admin_Link_xpath;
	@FindBy(xpath = "//div[@class='left-rail-title']//div//span") WebElement my_Learning_Queue_xpath;
	
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public String validateUserName() {
		dynamicWait(user_Name_xpath,TestUtil.EXPLICIT_WAIT_LONG);
		return user_Name_xpath.getText();
	}
	
	public boolean validateMyLearningQueueLabel() {
		dynamicWait(my_Learning_Queue_xpath, TestUtil.EXPLICIT_WAIT_SHORT);
		return my_Learning_Queue_xpath.isDisplayed();
	}
	
	public boolean validateMoreButton() {
		return more_Button_xpath.isDisplayed();
	}
	
	
	public AdminHomePage clickOnAdminLink() throws InterruptedException {
		dynamicWait(more_Button_xpath, TestUtil.EXPLICIT_WAIT_SHORT);
		more_Button_xpath.click();
		admin_Link_xpath.click();
		Thread.sleep(8000);
		return new AdminHomePage();
	}
	
	
	
	
}
