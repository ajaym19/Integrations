package com.integrations.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.integrations.base.TestBase;
import com.integrations.pages.AdminHomePage;
import com.integrations.pages.HomePage;
import com.integrations.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	AdminHomePage adminHomePage;
	
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		logger.info("Starting with Setup");
		initialization();
		logger.info("Initialization completed");
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email_id"), prop.getProperty("password"));
	}
	
	
	@Test
	public void validateHomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "ajay", "Home Page title does not match");
		logger.info("Home Page title tc is passed");
	}
	
	@Test
	public void validateUserNameTest() {
		String user_name = homePage.validateUserName();
		Assert.assertEquals(user_name, "Ajay");
		logger.info("Home Page logged in User Name tc is passed");
	}
	
	@Test
	public void validateMyLearningQueueLabelTest() {
		 Assert.assertTrue(homePage.validateMyLearningQueueLabel(), "My Learning Queue Label is not present"); 
		 logger.info("My Learning Queue tc is passed");
		 
	}
	
	@Test
	public void validateMoreButtonTest() {
		 Assert.assertTrue(homePage.validateMoreButton(), "More Button is not present"); 
		 logger.info("More button for various options is present");
		 
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
