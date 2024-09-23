package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ISOLocators {

	WebDriver driver;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='aggregator']")
	private WebElement AggregatorName;
	
	@FindBy(xpath = "//h6[text()='ISO Onboarding Configuration']")
	private WebElement IntroWhitelabelISO;
	
	
	@FindBy(xpath = "//h6[text()='Iso Discounts']")
	private WebElement IntroDiscountRate;
	
	
	public ISOLocators(WebDriver driver) {

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickOnAggregatorName() {

		AggregatorName.click();

	}

	public void EnterOnAggregatorName(String name) {

		AggregatorName.sendKeys(name);
		
		

	}
	
	public void DisplayedOnIntroWhiteLabelISO() {
		try {
			assertTrue("Whitelabel Page should be displayed", IntroWhitelabelISO.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Whitelabel Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnIntroDiscountRate() {
		try {
			assertTrue("Discount Rate Page should be displayed", IntroDiscountRate.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Discount Rate Page Should be displayed But not found.");
		}
	}


}
