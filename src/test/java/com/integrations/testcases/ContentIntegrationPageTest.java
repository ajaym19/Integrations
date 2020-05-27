package com.integrations.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.integrations.base.TestBase;
import com.integrations.enums.IntegrationType;
import com.integrations.pages.AdminHomePage;
import com.integrations.pages.ContentIntegrationPage;
import com.integrations.pages.HomePage;
import com.integrations.pages.LoginPage;

public class ContentIntegrationPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AdminHomePage adminHomePage;
	ContentIntegrationPage contentIntegrationPage;

	public ContentIntegrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email_id"), prop.getProperty("password"));
		adminHomePage = homePage.clickOnAdminLink();
		contentIntegrationPage = adminHomePage.clickOnContentIntegrationLink();
	}

	@Test
	public void createCSVIntegrationSource() throws IOException, InterruptedException {
		logger.info("Initiating CSV Source Creation Test");
		contentIntegrationPage.createIntegrationSource(IntegrationType.CSV);

	}
	
	@Test
	public void createRSSIntegrationSource() throws IOException, InterruptedException {
		logger.info("Initiating RSS Source Creation Test");
		contentIntegrationPage.createIntegrationSource(IntegrationType.RSS);

	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
