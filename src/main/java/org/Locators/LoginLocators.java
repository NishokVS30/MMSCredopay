package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLocators {

	WebDriver driver;

	@FindBy(xpath = "//h1[text()='Sign In']")
	private WebElement LoginpageDisplayed;

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	private WebElement EnterOnUserName;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement EnterOnPassword;
	
	@FindBy(xpath = "//input[@formcontrolname='captchaText']")
	private WebElement EnterOnCaptcha;

	@FindBy(xpath = "//mat-label[@for='username']")
	private WebElement LabelUsername;

	@FindBy(xpath = "//mat-label[@for='password']")
	private WebElement LabelPassword;

	@FindBy(xpath = "//span[text()='Sign In']")
	private WebElement ClickOnLogin;

	@FindBy(xpath = "//mat-error[text()=' This field is required']")
	private WebElement fieldisrequired;

	@FindBy(xpath = "//span[text()='Invalid Username or Password']")
	private WebElement Invaliduserorpass;

	@FindBy(xpath = "//span[text()='Invalid Captcha']")
	private WebElement InvalidCaptcha;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement ClickonEyeicon;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[2]/div[1]/div[2]/form[1]/div[1]/div[3]/span[1]/*[1]")
	private WebElement Displayedoncaptcha;

	@FindBy(xpath = "//mat-label[text()='Enter Captcha']")
	private WebElement CaptchaLabelName;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[2]/div[1]/div[2]/form[1]/div[1]/div[3]/button[1]/span[1]/img[1]")
	private WebElement CaptchaRefresh;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[1]/div[1]/div[1]/div[3]/div[1]/p-carousel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-skeleton-loader[1]/img[1]")
	private WebElement Image;

	@FindBy(xpath = "//span[text()='Forgot?']")
	private WebElement Forgot;

	@FindBy(xpath = "//span[text()='Verify OTP & Set Password']")
	private WebElement Forgoterrormessage;

	@FindBy(xpath = "//a[text()=' Contact Support']")
	private WebElement ClickOnContactSupport;

	@FindBy(xpath = "//span[text()='Email']")
	private WebElement ContactSupportVerify;

	@FindBy(xpath = "//a[text()=' Terms of Use ']")
	private WebElement ClickOnTermOfUse;

	@FindBy(xpath = "//h2[text()=' Terms and Conditions']")
	private WebElement TermofuseVerify;

	@FindBy(xpath = "//span[text()='OK']")
	private WebElement OK;

	@FindBy(xpath = "//a[text()=' Privacy Policy']")
	private WebElement Clickonprivacy;

	@FindBy(xpath = "//h2[text()='Introduction']")
	private WebElement PrivacypolicyVerify;

	public LoginLocators(WebDriver driver) {
		// initialize elements
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void DisplayedOnOK() {
		try {
			assertTrue("OK Button should be displayed", OK.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Ok button Should be displayed But not found.");
		}
	}

	public void DisplayedOnLoginPage() {
		try {
			assertTrue("LoginPage should be displayed", LoginpageDisplayed.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Login Page Should be displayed");
		}
	}

	public void EnterOnUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(EnterOnUserName));

		// Send keys to the element
		EnterOnUserName.sendKeys(username);
	}

	public void EnterOnPassword(String password) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(EnterOnPassword));

		// Send keys to the element
		EnterOnPassword.sendKeys(password);
	}
	
	public void EnterOnCaptcha(String captcha) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(EnterOnCaptcha));

		// Send keys to the element
		EnterOnCaptcha.sendKeys(captcha);
	}

	public void DisplayedOnUsername() {
		try {
			assertTrue("Username Label should be displayed", LabelUsername.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("The UserName Label Should be displayed On the Login Page");
		}
	}

	public void DisplayedOnPassword() {
		try {
			assertTrue("The Password Label should be displayed", LabelPassword.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("The Password Label Should be displayed On the Login Page");
		}
	}

	public void DisplayedOnThisFieldisRequired() {
		try {
			assertTrue("ThisFieldisrequired should be displayed", fieldisrequired.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("This Field is Required error message Should be displayed but not found.");
		}
	}

	public void NOTDisplayedOnThisfieldisrequired() {

		boolean required;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			required = fieldisrequired.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			required = false;
		}
		if (required) {
			Assert.assertFalse("Create button is displayed For This Role. ", required);
		}
	}

	public void DisplayedOnInvalidusernameorpassword() {
		try {
			assertTrue("Thisfieldisrequired should be displayed", Invaliduserorpass.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("This Field is Required error message Should be displayed but not found.");
		}
	}

	public void NOTDisplayedOnInvalidusernameorpassword() {

		boolean required;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			required = Invaliduserorpass.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			required = false;
		}
		if (required) {
			Assert.assertFalse("Create button is displayed For This Role. ", required);
		}
	}

	public String getPasswordFieldValue() {
		return EnterOnPassword.getAttribute("value");
	}

	public boolean isPasswordField() {
		return EnterOnPassword.getAttribute("type").equals("password");
	}

	// Method to check if the password field is of type text
	public boolean isTextField() {
		return EnterOnPassword.getAttribute("type").equals("text");
	}

	public void ClickOneyeicon() {
		ClickonEyeicon.click();
	}

	public boolean DisplayedonCaptcha() {
		try {

			return Displayedoncaptcha.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean CaptchaLabel() {
		try {
			return CaptchaLabelName.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean InvalidCaptcha() {
		try {
			return InvalidCaptcha.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean CaptchaRefresh() {
		try {
			return CaptchaRefresh.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean image() {
		try {
			return Image.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickonforgot() {
		Forgot.click();
	}

	public boolean ForgoterrorMesage() {
		try {
			return Forgoterrormessage.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickonContactSupport() {
		ClickOnContactSupport.click();
	}

	public boolean ContectSupportVerify() {
		try {
			return ContactSupportVerify.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickonTermofuse() {
		ClickOnTermOfUse.click();
	}

	public boolean TermofuseVerify() throws InterruptedException {
		List<String> li = new ArrayList<String>();
		try {

			Set<String> allWindows = driver.getWindowHandles();
			li = new ArrayList<>(allWindows); // addAll

			Thread.sleep(3000);
			driver.switchTo().window(li.get(1));

			return TermofuseVerify.isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		} finally {
			// Close the final window

			driver.switchTo().window(li.get(1));

			driver.close();

			driver.switchTo().window(li.get(0));

		}
	}

	public void clickonPrivacypolicy() {
		Clickonprivacy.click();
	}

	public boolean PrivacyPolicyVerify() throws InterruptedException {
		List<String> li = new ArrayList<String>();
		try {

			Set<String> allWindows = driver.getWindowHandles();
			li = new ArrayList<>(allWindows); // addAll

			Thread.sleep(3000);
			driver.switchTo().window(li.get(1));

			return PrivacypolicyVerify.isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		} finally {
			// Close the final window

			driver.switchTo().window(li.get(1));

			driver.close();

			driver.switchTo().window(li.get(0));

		}
	}

	public void ClickOnOk() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(OK));
			OK.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(OK));
			OK.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	public void ClickOnSignIn() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnLogin));
			ClickOnLogin.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnLogin));
			ClickOnLogin.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

}
