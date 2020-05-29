package com.integrations.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.Log4jEntityResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.integrations.util.TestUtil;
import com.integrations.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	// public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger logger;
	//static tt

	public TestBase() {

		prop = new Properties();
		try {
			String project_path = System.getProperty("user.dir");
			InputStream is = new FileInputStream(project_path + "/src/main/resources/config.properties");
			try {
				prop.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		
		logger = Logger.getLogger("Integrations");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Initialization started");
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Resources/Drivers/chromedriver");
			driver = new ChromeDriver();
			logger.info(String.format("Identified the browser to be used as %s Launching %s driver",browserName,browserName));
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "./Resources/Drivers/geckodriver");
			driver = new FirefoxDriver();
			logger.info(String.format("Identified the browser to be used as %s Launching %s driver",browserName,browserName));
		}

		// e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		// e_driver.register(eventListener);
		// driver=e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logger.info("Hitting the URL");

	}

	public static void dynamicWait(WebElement element, long timer) {
		wait = new WebDriverWait(driver, timer);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
