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
	
	private int waitTime;


	@FindBy(xpath = "//input[@formcontrolname='distributors']")
	private WebElement ISOName;
	

	
	public SUBISOLocators(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickOnISOName() {

//		ISOName.click();
		
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ISOName));
			ISOName.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ISOName));
			ISOName.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronISOName(String name) {

		ISOName.sendKeys(name);
		
		

	}

}
