package org.Locators;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SUBISOLocators {
	
	WebDriver driver;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='distributors']")
	private WebElement ISOName;
	

	
	public SUBISOLocators(WebDriver driver) {

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickOnISOName() {

		ISOName.click();

	}

	public void EnteronISOName(String name) {

		ISOName.sendKeys(name);
		
		

	}

}
