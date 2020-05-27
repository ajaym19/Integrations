package com.integrations.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.integrations.base.TestBase;
import com.integrations.pages.HomePage;
import com.integrations.pages.LoginPage;
import com.integrations.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		logger.info("Starting with Setup");
		initialization();
		logger.info("Initialization completed");
		loginPage = new LoginPage();
	}

	@Test(priority = 1, enabled = true)
	public void validateLoginPageTitleTest() throws IOException {
		String title = loginPage.validateLoginPageTitle();
		if (title.equals("ajay")) {
			Assert.assertTrue(true);
			logger.info("Login Page Title TC is passed");
		} else {
			logger.warn("Login Page Title TC is failed");
			TestUtil.takeScreenshot();
			Assert.assertTrue(false);

		}

	}

	@Test(priority = 2, enabled = true)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("email_id"), prop.getProperty("password"));
		homePage.validateHomePageTitle();
		logger.info("Login Successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
