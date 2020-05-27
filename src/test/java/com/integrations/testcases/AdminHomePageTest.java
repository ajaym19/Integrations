package com.integrations.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.integrations.base.TestBase;
import com.integrations.pages.AdminHomePage;
import com.integrations.pages.ContentIntegrationPage;
import com.integrations.pages.HomePage;
import com.integrations.pages.LoginPage;

public class AdminHomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AdminHomePage adminHomePage;
	ContentIntegrationPage contentIntegrationPage; 

	public AdminHomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		logger.info("Starting with Setup");
		initialization();
		logger.info("Initialization completed");
		loginPage = new LoginPage();
		homePage =  loginPage.login(prop.getProperty("email_id"), prop.getProperty("password"));
		adminHomePage = homePage.clickOnAdminLink();
	}
	
	
	@Test(priority = 1)
	public void validateAdminHomePageTitleTest() {
		String title = adminHomePage.validateAdminHomePageTitle();
		Assert.assertEquals(title, "EdCast Admin Console");
		logger.info("Admin Home Page title TC is passed");
		
	}
	
	@Test(priority = 2)
	public void validateAdminLabelTest() {
		Assert.assertTrue(adminHomePage.validateAdminLabel(), "ADMIN Label is not present");
		logger.info("Admin label TC is passed");
	}
	
	@Test(priority = 3)
	public void clickOnContentIntegrationLinkTest() throws InterruptedException {
		contentIntegrationPage = adminHomePage.clickOnContentIntegrationLink();
		logger.info("Clicking on Content Integration Link");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
