package com.integrations.service;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.integrations.base.TestBase;
import com.integrations.util.TestUtil;

public class FetchContent extends TestBase {

	String fetch_Content_Xpath =  "//td[contains(text(),'%s')]//preceding-sibling::td/descendant::button[contains(text(),'Fetch Content')]";
	
	public void fetchSourceContent(WebDriver driver, String sourceName) throws InterruptedException, IOException {
		
		logger.info("Initiating CSV Fetch Content");
		WebElement fetch_Content =  driver.findElement(By.xpath(String.format(fetch_Content_Xpath, sourceName)));
		dynamicWait(fetch_Content, TestUtil.EXPLICIT_WAIT_LONG);
		fetch_Content.click();
		TestUtil.takeScreenshot();
		logger.info("CSV Fetch Content Initiated");
		
	}
}
