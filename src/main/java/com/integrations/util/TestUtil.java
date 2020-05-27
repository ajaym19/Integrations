package com.integrations.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.integrations.base.TestBase;



public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT_TIMEOUT = 30;
	public static long EXPLICIT_WAIT_LONG = 30;
	public static long EXPLICIT_WAIT_SHORT = 10;
	
	
	
	
	

	public static void takeScreenshot() throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+ "/Screenhots/" + System.currentTimeMillis() + "test.png";
		FileUtils.copyFile(srcFile, new File(screenshotPath));
		System.out.println("screenshot saved");
		
	}
	
	
	
}
