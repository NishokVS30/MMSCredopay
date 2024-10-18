package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TerminalLocators {

	WebDriver driver;
	int waitTime;

	@FindBy(xpath = "//span[contains(text(), 'Submit & Next')]")
	private WebElement ViewDocumentSubmitandNext;

	@FindBy(xpath = "//input[@formcontrolname='merchant']")
	public WebElement Merchant;

	@FindBy(xpath = "//input[@formcontrolname='terminalName']")
	private WebElement Terminal;

	public TerminalLocators(WebDriver driver) {
		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickElement(WebElement element) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for the input field. Trying to interact via JavaScript.");
			((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element);
		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}

	public void enterElement(WebElement element, String text) {

		try {
			// Wait for the input field to be visible
			element.sendKeys(text);

		} catch (ElementClickInterceptedException e) {
			
			element.sendKeys(text);
			
		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}
	
	public boolean isElementDisplayed(WebElement element, String elementName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

	    try {
	       
	        wait.until(ExpectedConditions.visibilityOf(element));

	        assertTrue(elementName + " is displayed.", element.isDisplayed());
	        
	        return true;

	    } catch (NoSuchElementException e) {
	        System.out.println(elementName + " is not displayed.");
	        return false;

	    } catch (TimeoutException e) {
	        System.out.println(elementName + " is not displayed due to timeout.");
	        return false;
	    }
	}

	
	public void CLearElement(WebElement element) {

		try {
			
			element.clear();

		} catch (ElementClickInterceptedException e) {
			
			element.clear();
			
		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}
	
	
	
//	public WebElement clickElementXpath(String xplathText) {
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
//		WebElement inputElement = null; // Declare the variable here
//
//		try {
//			// Wait for the input field to be visible
//			inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xplathText)));
//			inputElement.click();
//			return inputElement;
//		} catch (TimeoutException e) {
//			System.out.println(
//					"The input field with formControlName '" + xplathText + "' is not found within the timeout.");
//		} catch (ElementClickInterceptedException e) {
//			System.out.println("Element click intercepted for the input field. Trying to interact via JavaScript.");
//
//			// Try sending keys via JavaScript as a fallback
//			((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputElement);
//		}
//		return inputElement;
//	}

}
