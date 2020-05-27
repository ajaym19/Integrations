package com.integrations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.integrations.base.TestBase;
import com.integrations.util.TestUtil;

public class LoginPage extends TestBase {

	// Page Factory -- OR
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement email_id_xpath;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password_xpath;
	@FindBy(xpath = "//form/button[contains(@class,'login-page-button')]")
	WebElement loginBtn_xpath;
	@FindBy(xpath = "//button[text()='Sign Up']")
	WebElement signUpBtn_xpath;

	public LoginPage() {

		// Initialize all the OR
		PageFactory.initElements(driver, this);

	}

	// Creating Actions

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String email_id, String password) {
		dynamicWait(email_id_xpath, TestUtil.EXPLICIT_WAIT_LONG);
		email_id_xpath.sendKeys(email_id);
		password_xpath.sendKeys(password);
		loginBtn_xpath.click();
		return new HomePage();
	}

}
