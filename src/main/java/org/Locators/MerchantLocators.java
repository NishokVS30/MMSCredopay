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

public class MerchantLocators {

	WebDriver driver;
	
	private int waitTime;
	
// IntroPage
	
	@FindBy(xpath = "//h6[contains(text(),'FRM Parameters')]")
	private WebElement DisplayedonRiskInfo;
	
	@FindBy(xpath = "//h6[contains(text(),'Discount Rate')]")
	private WebElement DisplayedonMerchantDiscount;
	
	@FindBy(xpath = "//h6[contains(text(),'Installation Info')]")
	private WebElement DisplayedonTerminals;
	
	@FindBy(xpath = "//h6[contains(text(),'Payment Bridge')]")
	private WebElement DisplayedonPaymentBridge;
	
	@FindBy(xpath = "//h6[contains(text(),'Allow Card Type')]")
	private WebElement DisplayedonCardBin;
	

	@FindBy(xpath = "//span[text()='Sales Info']")
	private WebElement ClickonSalesInfo;

	@FindBy(xpath = "//span[text()='Company Info']")
	private WebElement ClickOnComapanyInfo;

	@FindBy(xpath = "//span[text()='Personal Info']")
	private WebElement ClickOnPersonalInfo;

	@FindBy(xpath = "//span[text()='Communication Info']")
	private WebElement ClickOnCommunicationInfo;

	@FindBy(xpath = "//span[text()='Risk Info']")
	private WebElement ClickOnRiskInfo;

	@FindBy(xpath = "//span[text()='Card/Bin Profile']")
	private WebElement ClickOnCardBinProfile;

	@FindBy(xpath = "//span[text()='Settlement Info']")
	private WebElement ClickOnSettlementInfo;

	@FindBy(xpath = "(//span[text()='Terminals'])[3]")
	private WebElement CLickOnTerminal;

	@FindBy(xpath = "//span[text()='KYC']")
	private WebElement ClickOnKYC;

//Sales Info	

	@FindBy(xpath = "//mat-label[text()='Credopay Application Date ']")
	private WebElement CredopayApplicableDateLabel;

	@FindBy(xpath = "//mat-label[text()='Merchant Reference Number ']")
	private WebElement MerchantReferenceNumberLabel;

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']")
	private WebElement MerchantReferenceNumber;

	@FindBy(xpath = "//mat-label[text()='Aggregator Application Date ']")
	private WebElement AggregatorApplicationDate;

	@FindBy(xpath = "//mat-label[text()='Aggregator']")
	private WebElement AggregatorLabel;

	@FindBy(xpath = "//input[@formcontrolname='aggregator']")
	private WebElement CLickonAggregator;

	@FindBy(xpath = "//span[text()=' Transtrac Tech ']")
	private WebElement SelectOnAggregator;

	@FindBy(xpath = "//mat-label[text()='ISO ']")
	private WebElement ISOLabel;

	@FindBy(xpath = "//input[@formcontrolname='distributors']")
	private WebElement ClickOnISO;

	@FindBy(xpath = "//input[@formcontrolname='groupMerchant']")
	private WebElement ClickOnGroupMerchant;

	@FindBy(xpath = "//span[text()=' CredopayISO ']")
	private WebElement SelectOnISO;

	@FindBy(xpath = "//mat-label[text()='Sales Person']")
	private WebElement salespersonLabel;

	@FindBy(xpath = "//input[@formcontrolname='salesPerson']")
	private WebElement ClickOnSalesPerson;

	@FindBy(xpath = "//input[@formcontrolname='branchCode']")
	private WebElement ClickonbranchCode;

	@FindBy(xpath = "//mat-label[text()='Branch Code ']")
	private WebElement branchcodeLabel;

	@FindBy(xpath = "//span[text()=' 5461 ']")
	private WebElement SelectOnBranchCode;

//Company Info	

	@FindBy(xpath = "//mat-label[text()='Legal Name  ']")
	private WebElement legalnameLabel;

	@FindBy(xpath = "//mat-label[text()='Brand Name  ']")
	private WebElement BrandNameLabel;

	@FindBy(xpath = "//mat-label[text()='Registered Address ']")
	private WebElement RegisteredAddressLabel;

	@FindBy(xpath = "//span[text()='Location']")
	private WebElement LocationLabel;

	@FindBy(xpath = "//mat-label[text()='Registered Pincode']")
	private WebElement RegisteredPincodeLabel;

	@FindBy(xpath = "//mat-label[text()='State ']")
	private WebElement StateLabel;

	@FindBy(xpath = "//mat-label[text()='City  ']")
	private WebElement CityLabel;

	@FindBy(xpath = "//img[@alt='map']")
	private WebElement Location;

	@FindBy(xpath = "//input[@placeholder='Search for Location']")
	private WebElement SearchtheLocation;

	@FindBy(xpath = "//input[@formcontrolname='location']")
	private WebElement getLocation;

	@FindBy(xpath = "//span[contains(text(), 'Enter Complete Address')]")
	private WebElement CompleteAddress;

	@FindBy(xpath = "//mat-label[text()='Latitude ']")
	private WebElement Latitudelabel;

	@FindBy(xpath = "//mat-label[text()='Longitude ']")
	private WebElement Longtitudelabel;

	@FindBy(xpath = "//mat-label[text()='Location Type ']")
	private WebElement Locationtypelabel;

	@FindBy(xpath = "//input[@formcontrolname='merchantType']")
	private WebElement MerchantType;

	@FindBy(xpath = "//mat-select[@formcontrolname='merchantClassification']")
	private WebElement Merchantclarification;

//RiskInfo

	@FindBy(xpath = "//input[@formcontrolname='weekDaysFrom']")
	private WebElement WeekDaysFrom;

	@FindBy(xpath = "//input[@formcontrolname='weekDaysTo']")
	private WebElement WeekDaysTo;

	@FindBy(xpath = "//input[@formcontrolname='weekEndFrom']")
	private WebElement WeekEndFrom;

	@FindBy(xpath = "//input[@formcontrolname='weekEndTo']")
	private WebElement WeekEndTo;

//	Card/Bin Profile

	@FindBy(xpath = "//span[contains(text(),'Credit')]")
	private WebElement Credit;

	@FindBy(xpath = "//span[contains(text(),'Debit')]")
	private WebElement Debit;

	@FindBy(xpath = "//input[@formcontrolname='binNumber']")
	private WebElement ClickOnBinNumber;

//SettlementInfo

	@FindBy(xpath = "//mat-select[@formcontrolname='payment']")
	private WebElement PaymentMode;

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementFlag']")
	private WebElement SettlementFlag;

//Terminals	

	@FindBy(xpath = "//input[@formcontrolname='terminalName']")
	private WebElement Terminal;

	@FindBy(xpath = "//mat-select[@formcontrolname='terminalType']")
	private WebElement terminalType;

	@FindBy(xpath = "//mat-select[@formcontrolname='upiTerminalType']")
	private WebElement UPITerminalType;

	@FindBy(xpath = "//mat-select[@formcontrolname='upiOfflineType']")
	private WebElement UPIofflineType;

	@FindBy(xpath = "//input[@formcontrolname='upiVPA']")
	private WebElement UPIVPA;

	@FindBy(xpath = "//input[@formcontrolname='deviceModel']")
	private WebElement deviceModel;

	@FindBy(xpath = "//input[@formcontrolname='deviceNumber']")
	private WebElement deviceNumber;

	@FindBy(xpath = "//input[@formcontrolname='imeiNumber']")
	private WebElement IMEINumber;

	@FindBy(xpath = "//mat-select[@formcontrolname='deviceType']")
	private WebElement DeviceType;

	@FindBy(xpath = "//mat-select[@formcontrolname='deviceComercialMode']")
	private WebElement DeviceCommercial;

	@FindBy(xpath = "//mat-select[@formcontrolname='tidFeeApplicable']")
	private WebElement TIDFeeApplicable;

	@FindBy(xpath = "//input[@formcontrolname='devicePrice']")
	private WebElement DevicePrice;

	@FindBy(xpath = "//input[@formcontrolname='installationFee']")
	private WebElement InstallationFee;

	public MerchantLocators(WebDriver driver) {
		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
//IntroPage
	
	public void DisplayedonMerchantDiscountRate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {
			wait.until(ExpectedConditions.visibilityOf(DisplayedonMerchantDiscount));
			assertTrue("Discount Rate Page should be displayed", DisplayedonMerchantDiscount.isDisplayed());
		} catch (NoSuchElementException e) {
			fail("Discount Rate Page should be displayed but not found.");
		} catch (TimeoutException e) {
			fail("Discount Rate Page was not visible within the wait time.");
		}
	}
	
	
	public void DisplayedonMerchantTerminals() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {
			wait.until(ExpectedConditions.visibilityOf(DisplayedonTerminals));
			assertTrue("Terminals Page should be displayed", DisplayedonTerminals.isDisplayed());
		} catch (NoSuchElementException e) {
			fail("Terminals Page should be displayed but not found.");
		} catch (TimeoutException e) {
			fail("Terminals Page was not visible within the wait time.");
		}
	}
	
	
	
	public void DisplayedonMerchantRiskInfo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {
			wait.until(ExpectedConditions.visibilityOf(DisplayedonRiskInfo));
			assertTrue("Risk Info Page should be displayed", DisplayedonRiskInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			fail("Risk Info Page should be displayed but not found.");
		} catch (TimeoutException e) {
			fail("Risk Info Page was not visible within the wait time.");
		}
	}
	
	
	public void DisplayedonPaymentBridge() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {
			wait.until(ExpectedConditions.visibilityOf(DisplayedonPaymentBridge));
			assertTrue("PaymentBridge Page should be displayed", DisplayedonPaymentBridge.isDisplayed());
		} catch (NoSuchElementException e) {
			fail("Payment Bridge Page should be displayed but not found.");
		} catch (TimeoutException e) {
			fail("Payment Bridge Page was not visible within the wait time.");
		}
	}
	
	
	public void DisplayedonCardBin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {
			wait.until(ExpectedConditions.visibilityOf(DisplayedonCardBin));
			assertTrue("CardBin Page should be displayed", DisplayedonCardBin.isDisplayed());
		} catch (NoSuchElementException e) {
			fail("CardBin Page should be displayed but not found.");
		} catch (TimeoutException e) {
			fail("CardBin Page was not visible within the wait time.");
		}
	}

	public void ClickonCardNinProfile() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnCardBinProfile));
			ClickOnCardBinProfile.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnCardBinProfile));
			ClickOnCardBinProfile.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickonMerchantReferenceNumber() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(MerchantReferenceNumber));
			MerchantReferenceNumber.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(MerchantReferenceNumber));
			MerchantReferenceNumber.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronMerchantReferenceNumber(String num) {

		MerchantReferenceNumber.sendKeys(num);

	}

	public void ClickonGroupMerchant() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnGroupMerchant));
			ClickOnGroupMerchant.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnGroupMerchant));
			ClickOnGroupMerchant.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickonLocation() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Location));
			Location.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Location));
			Location.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public String getLocation() {
		return getLocation.getAttribute("value");
	}

	public void ClickonSearchtheLocation() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(SearchtheLocation));
			SearchtheLocation.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(SearchtheLocation));
			SearchtheLocation.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronSearchtheLocation(String loc) {

		SearchtheLocation.sendKeys(loc);
		
	}

	public void ClickonCompleteAddress() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(CompleteAddress));
			CompleteAddress.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(CompleteAddress));
			CompleteAddress.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickonMerchantType() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(MerchantType));
			MerchantType.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(MerchantType));
			MerchantType.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickonMerchantClassification() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Merchantclarification));
			Merchantclarification.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Merchantclarification));
			Merchantclarification.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickonWeekDaysFrom() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekDaysFrom));
			WeekDaysFrom.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekDaysFrom));
			WeekDaysFrom.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronWeekDaysFrom(String num) {

		WeekDaysFrom.sendKeys(num);

	}

	public void ClickonWeekDaysTo() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekDaysTo));
			WeekDaysTo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekDaysTo));
			WeekDaysTo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronWeekDaysTo(String num) {

		WeekDaysTo.sendKeys(num);

	}

	public void ClickonWeekENDFrom() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekEndFrom));
			WeekEndFrom.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekEndFrom));
			WeekEndFrom.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronWeekEndFrom(String num) {

		WeekEndFrom.sendKeys(num);

	}

	public void ClickonWeekENDTo() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekEndTo));
			WeekEndTo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(WeekEndTo));
			WeekEndTo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronWeekEndTo(String num) {

		WeekEndTo.sendKeys(num);

	}

	public void SelectonCredit() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Credit));
			Credit.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Credit));
			Credit.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectonDebit() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Debit));
			Debit.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Debit));
			Debit.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnBinNumber() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnBinNumber));
			ClickOnBinNumber.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnBinNumber));
			ClickOnBinNumber.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

//SettlementInfo

	public void ClickonPaymentMode() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(PaymentMode));
			PaymentMode.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(PaymentMode));
			PaymentMode.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickonSettlementFlag() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementFlag));
			SettlementFlag.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementFlag));
			SettlementFlag.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

//Terminals	

	public void ClickonTerminalName() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Terminal));
			Terminal.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(Terminal));
			Terminal.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronTerminalName(String num) {

		Terminal.sendKeys(num);

	}

	public void ClickonTerminalType() {

//		ComapnyInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(terminalType));
			terminalType.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(terminalType));
			terminalType.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

}
