package org.Locators;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.Testcases.CustomWebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassLocator {

	WebDriver driver;

    int waitTime;

	WebDriverWait wait;
	
	public BaseClassLocator(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime(); // Get wait time from CustomWebDriverManager
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectDropdownOption(String optionText) {
		// Construct the XPath for the option text in a case-insensitive manner
		String xpathExpression = "//mat-option//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ optionText.toLowerCase() + "')]";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {
			// Wait for the overlay to disappear (if it exists)
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

			// Wait for the dropdown option to be visible and clickable
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

			// Scroll the element into view (if needed) and click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();
		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");

			// Try clicking via JavaScript as a fallback
			WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

//	public void clickElement(WebElement element) {
//
//		try {
//
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//			element.click();
//
//		} catch (ElementClickInterceptedException e) {
//			System.out.println("Element click intercepted for the input field. Trying to interact via JavaScript.");
//			((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element);
//		} catch (TimeoutException e) {
//			System.out
//					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
//		}
//	}
	
	public void clickElement(WebElement element) {
	    try {
	        // Wait for the element to be visible and clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	        wait.until(ExpectedConditions.visibilityOf(element)); // Ensure visibility
	        wait.until(ExpectedConditions.elementToBeClickable(element)); // Ensure clickable
	        
	        // Scroll to the element to make sure it's in view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        
	        // Attempt to click the element
	        element.click();
	        System.out.println("Element clicked successfully.");
	        
	    } catch (ElementClickInterceptedException e) {
	        // Handle the case where another element blocks the click
	        System.out.println("Element click intercepted. Trying to click via JavaScript.");
	        
	        try {
	            // Use JavaScript as a fallback to click the element
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	            System.out.println("Element clicked via JavaScript.");
	        } catch (Exception jsException) {
	            System.out.println("JavaScript click also failed.");
	            jsException.printStackTrace();
	        }
	        
	    } catch (TimeoutException e) {
	        // Handle timeout when waiting for the element to be clickable
	        System.out.println("The element '" + element + "' is not clickable within the timeout.");
	        e.printStackTrace();
	        
	    } catch (StaleElementReferenceException e) {
	        // Handle stale element reference exception
	        System.out.println("The element '" + element + "' is stale. Trying to relocate the element.");
	        e.printStackTrace();
	        
	    } catch (Exception e) {
	        // Handle any other unexpected exceptions
	        System.out.println("An unexpected error occurred while trying to click the element.");
	        e.printStackTrace();
	    }
	}

	public void ActionclickElement(WebElement element) {
	    int attempts = 0;

	    while (attempts < 3) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", element);
	            break;

	        } catch (StaleElementReferenceException e) {
	            attempts++;

	        } catch (ElementClickInterceptedException e) {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", element);
	            break;

	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	            break;
	        }
	    }
	}

	

	public void enterElement(WebElement element, String text) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    		wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(text);

		} catch (ElementClickInterceptedException e) {

			element.sendKeys(text);

		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}
	

	public void UploadImage(WebElement element, String text) {

		try {
		
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
	
	public boolean isElementNotDisplayed(WebElement element, String elementName) {
	    boolean isDisplayed;
	    
	    try {
	        isDisplayed = element.isDisplayed();
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        isDisplayed = false;
	    }
	    if (isDisplayed) {
	        Assert.assertFalse(elementName + " is displayed, but it should not be.", isDisplayed);
	    }
	    
	   	    return !isDisplayed;
	
	}

	public void CLearElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		try {
			
			wait.until(ExpectedConditions.visibilityOf(element));

			element.clear();

		} catch (ElementClickInterceptedException e) {

			element.clear();

		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}
	
	public String getElementValue(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	    try {
	    	wait.until(ExpectedConditions.visibilityOf(element));
	        // Get the current value of the input field using the "value" attribute
	        return element.getAttribute("value");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element is not found: " + element);
	        return null;
	    } catch (TimeoutException e) {
	        System.out.println("The input field is not found within the timeout.");
	        return null;
	    }
	}

	
	

}
