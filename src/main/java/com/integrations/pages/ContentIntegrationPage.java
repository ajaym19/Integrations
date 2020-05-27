package com.integrations.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.integrations.base.TestBase;
import com.integrations.enums.IntegrationType;
import com.integrations.service.FillSourceDetails;

public class ContentIntegrationPage extends TestBase {

	public static IntegrationType integrationType;
	String addSourceButton;
	FillSourceDetails fillSourceDetails;

	public ContentIntegrationPage() {
		PageFactory.initElements(driver, this);
	}

	public void createIntegrationSource(IntegrationType integrationType) throws IOException, InterruptedException {

		fillSourceDetails = new FillSourceDetails();
		addSourceButton = "//button[@aria-label='%s']";
		String plusButton = "Add " + integrationType;
		driver.findElement(By.xpath(String.format(addSourceButton, plusButton))).click();
		logger.info("Clicked on plus icon to add source details, now calling the method based on the Integration Type");

		switch (integrationType) {
		case RSS:
			fillSourceDetails.createRSSSource(driver);
			break;

		case CSV:
			fillSourceDetails.createCSVSource(driver);
			break;

		default:
			System.out.println("nowhere");
			break;
		}

	}
}
