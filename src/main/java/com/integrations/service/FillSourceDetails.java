package com.integrations.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.integrations.base.TestBase;
import com.integrations.util.IntegrationSources;
import com.integrations.util.TestUtil;

public class FillSourceDetails extends TestBase {
	
	FetchContent fetchContent = new FetchContent();
	SourcesUITest sourceUITest = new SourcesUITest();
	Random random = new Random();
	String randomID = String.format("%04d", random.nextInt(10000));

	@FindBy(xpath = "//input[@placeholder='Source Name']")
	WebElement source_Name_xpath;
	@FindBy(xpath = "//input[@aria-label = 'Select a language from the list']")
	WebElement lang_Dropdown_xpath;
	@FindBy(xpath = "//div[@aria-label = 'English']")
	WebElement lang_Select_xpath;
	@FindBy(xpath = "//div[4]//div[1]//input[1]")
	WebElement delimiter_xpath;
	@FindBy(id = "fileInput")
	WebElement upload_File_xpath;
	@FindBy(id = "fileInput1")
	WebElement logo_xpath;
	@FindBy(id = "fileInput2")
	WebElement banner_xpath;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement save_Source_xpath;
	
	//RSS
	@FindBy(xpath = "//input[@placeholder = 'Source feed URL']")
	WebElement rss_Source_URL_xpath;

	public FillSourceDetails() {
		PageFactory.initElements(driver, this);
	}

	public void createCSVSource(WebDriver driver) throws IOException, InterruptedException {

		logger.info("filling source details for CSV");
		FileInputStream is = new FileInputStream(IntegrationSources.CREATE_CSV_PROP_PATH);
		Properties prop = new Properties();
		prop.load(is);
		String sourceName = prop.getProperty("source_name")+randomID;
		source_Name_xpath.sendKeys(sourceName);
		lang_Dropdown_xpath.sendKeys(prop.getProperty("language"));
		lang_Select_xpath.click();
		delimiter_xpath.sendKeys(prop.getProperty("delimiter"));
		upload_File_xpath.sendKeys(IntegrationSources.CREATE_CSV_FILE_PATH);
		logo_xpath.sendKeys(IntegrationSources.CREATE_CSV_LOGO_BANNER_PATH);
		banner_xpath.sendKeys(IntegrationSources.CREATE_CSV_LOGO_BANNER_PATH);
		TestUtil.dynamicWait(save_Source_xpath, TestUtil.EXPLICIT_WAIT_SHORT);
		save_Source_xpath.click();
		Thread.sleep(2000);
		TestUtil.takeScreenshot();
		//Thread.sleep(6000);
		driver.getPageSource().contains(sourceName);
		logger.info("CSV Souce is created successfully");
		fetchContent.fetchSourceContent(driver, sourceName);
		sourceUITest.verifySourceOnUI(driver, sourceName);
		

	}
	
	public void createRSSSource(WebDriver driver) throws IOException, InterruptedException {
		logger.info("filling source details for RSS");
		FileInputStream is = new FileInputStream(IntegrationSources.CREATE_RSS_PROP_PATH);
		Properties prop = new Properties();
		prop.load(is);
		String sourceName = prop.getProperty("source_name")+randomID;
		source_Name_xpath.sendKeys(sourceName);
		lang_Dropdown_xpath.sendKeys(prop.getProperty("language"));
		lang_Select_xpath.click();
		rss_Source_URL_xpath.sendKeys(prop.getProperty("source_feed_url"));
		logo_xpath.sendKeys(IntegrationSources.CREATE_RSS_LOGO_BANNER_PATH);
		TestUtil.dynamicWait(save_Source_xpath, TestUtil.EXPLICIT_WAIT_SHORT);
		save_Source_xpath.click();
		Thread.sleep(8000);
		driver.getPageSource().contains(sourceName);
		logger.info("RSS Souce is created successfully");
		fetchContent.fetchSourceContent(driver, sourceName);
		sourceUITest.verifySourceOnUI(driver, sourceName);

	}

}
