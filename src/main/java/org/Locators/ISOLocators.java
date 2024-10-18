package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ISOLocators {

	WebDriver driver;
	
	private int waitTime;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='aggregator']")
	private WebElement AggregatorName;
	
	@FindBy(xpath = "//h6[text()='ISO Onboarding Configuration' or text()='Sub Iso Onboarding Configuration']")
	private WebElement IntroWhitelabelISO;
	
	
	@FindBy(xpath = "//h6[text()='Iso Discounts' or text()='Sub ISO Discounts']")
	private WebElement IntroDiscountRate;
	
	
	public ISOLocators(WebDriver driver) {	

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickOnAggregatorName() {

//		AggregatorName.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(AggregatorName));
			AggregatorName.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(AggregatorName));
			AggregatorName.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnAggregatorName(String name) {

		AggregatorName.sendKeys(name);
		
		

	}
	
	public void DisplayedOnIntroWhiteLabelISO() {
	
	
	try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.visibilityOf(IntroWhitelabelISO)); // Wait until the element is visible
        
        assertTrue("Whitelabel Page should be displayed", IntroWhitelabelISO.isDisplayed());
    } catch (NoSuchElementException e) {
    	fail("Whitelabel Page Should be displayed But not found.");
    } catch (TimeoutException e) {
    	fail("Whitelabel Page Should be displayed But not found.");
    }
}
	
	public void DisplayedOnIntroDiscountRate() {
//		try {
//			assertTrue("Discount Rate Page should be displayed", IntroDiscountRate.isDisplayed());
//		} catch (NoSuchElementException e) {
//			// Fail the test if the button is not found
//			fail("Discount Rate Page Should be displayed But not found.");
//		}
//	}

		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
	        wait.until(ExpectedConditions.visibilityOf(IntroDiscountRate)); // Wait until the element is visible
	        
	        assertTrue("Discount Rate Page should be displayed", IntroDiscountRate.isDisplayed());
	    } catch (NoSuchElementException e) {
	    	fail("Discount Rate Page Should be displayed But not found.");
	    } catch (TimeoutException e) {
	    	fail("Discount Rate Page Should be displayed But not found.");
	    }
	}

}
