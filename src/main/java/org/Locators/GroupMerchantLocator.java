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

public class GroupMerchantLocator {

	WebDriver driver;
	
	private int waitTime;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']")
	private WebElement UniqueReferenceNumber;

	@FindBy(xpath = "//input[@formcontrolname='subDistributors']")
	private WebElement SUBISO;

	@FindBy(xpath = "//input[@formcontrolname='businessNature']")
	private WebElement natureofbusiness;

	@FindBy(xpath = "//input[@formcontrolname='mcc']")
	private WebElement mcc;

	@FindBy(xpath = "(//span[text()=' Verify Document '])[1]")
	private WebElement VerifyDocument1;
	
//IntroPage
	
	@FindBy(xpath = "//h6[text()='Group Merchant Discounts']")
	private WebElement IntrodiscountRate;
	
	@FindBy(xpath = "//h6[text()='Merchant Onboarding Configuration']")
	private WebElement IntroWhitelabel;
	
	

	public GroupMerchantLocator(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void DisplayedOnIntroDiscountRate() {
		
		try {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime)); // Wait for up to 10 seconds
	        wait.until(ExpectedConditions.visibilityOf(IntrodiscountRate)); // Wait until the element is visible
	        
	        assertTrue("Discount Rate Page should be displayed", IntrodiscountRate.isDisplayed());
	    } catch (NoSuchElementException e) {
	    	fail("Discount Rate Page Should be displayed But not found.");
	    } catch (TimeoutException e) {
	    	fail("Discount Rate Page Should be displayed But not found.");
	    }
	}
	
	public void DisplayedOnIntroWhiteLabel() {
		
		try {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime)); // Wait for up to 10 seconds
	        wait.until(ExpectedConditions.visibilityOf(IntroWhitelabel)); // Wait until the element is visible
	        
	        assertTrue("Whitelabel Page should be displayed", IntroWhitelabel.isDisplayed());
	    } catch (NoSuchElementException e) {
	    	fail("Whitelabel Page Should be displayed But not found.");
	    } catch (TimeoutException e) {
	    	fail("Whitelabel Page Should be displayed But not found.");
	    }
	}


	public void ClickOnUniqueReferenceNumber() {

//		UniqueReferenceNumber.click();
		
		
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(UniqueReferenceNumber));

			// Perform the click action
			UniqueReferenceNumber.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(UniqueReferenceNumber));
			UniqueReferenceNumber.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronUniqueReferenceNumber(String num) {

		UniqueReferenceNumber.sendKeys(num);

	}

	public void ClickOnSUBISOName() {

//		SUBISO.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(SUBISO));

			// Perform the click action
			SUBISO.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(SUBISO));
			SUBISO.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}


	public void EnteronSUBISOName(String name) {

		SUBISO.sendKeys(name);

	}

	public void ClickOnnatureofbusiness() {

//		natureofbusiness.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(natureofbusiness));

			// Perform the click action
			natureofbusiness.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(natureofbusiness));
			natureofbusiness.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnMCC() {

//		mcc.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(mcc));

			// Perform the click action
			mcc.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(mcc));
			mcc.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public void ClearOnMCC() {
		
		mcc.clear();
	}
	
	public void EnterOnMCC(String code) {
		
		mcc.sendKeys(code);
	}

	public void verifyDocument() {

//		VerifyDocument1.click();
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(VerifyDocument1));

			// Perform the click action
			VerifyDocument1.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(VerifyDocument1));
			VerifyDocument1.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

}
