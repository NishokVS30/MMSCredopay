package org.Locators;

import java.time.Duration;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SUBISOLocators {
	
	WebDriver driver;

	WebDriverWait wait;
	
	int waitTime;


	@FindBy(xpath = "//input[@formcontrolname='distributors']")
	public WebElement ISOName;
	

	
	public SUBISOLocators(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
