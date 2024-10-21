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
	
	 int waitTime;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']")
	public WebElement UniqueReferenceNumber;

	@FindBy(xpath = "//input[@formcontrolname='subDistributors']")
	public WebElement SUBISO;

	@FindBy(xpath = "//input[@formcontrolname='businessNature']")
	public WebElement natureofbusiness;

	@FindBy(xpath = "//input[@formcontrolname='mcc']")
	public WebElement mcc;

	@FindBy(xpath = "(//span[contains(text(), 'Verify Document')])[1]")
    public WebElement VerifyDocument1;
	
//IntroPage
	
	@FindBy(xpath = "//h6[contains(text(), 'Group Merchant Discounts')]")
	public WebElement IntrodiscountRate;
	
	@FindBy(xpath = "//h6[contains(text(), 'Merchant Onboarding Configuration')]")
	public WebElement IntroWhitelabel;

	
	

	public GroupMerchantLocator(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
