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

	int waitTime;

	// Merchant Locators

	// IntroPage

	@FindBy(xpath = "//h6[contains(text(),'FRM Parameters')]")

	public WebElement DisplayedonRiskInfo;

	@FindBy(xpath = "//h6[contains(text(),'Discount Rate')]")

	public WebElement DisplayedonMerchantDiscount;

	@FindBy(xpath = "//h6[contains(text(),'Installation Info')]")

	public WebElement DisplayedonTerminals;

	@FindBy(xpath = "//h6[contains(text(),'Payment Bridge')]")

	public WebElement DisplayedonPaymentBridge;

	@FindBy(xpath = "//h6[contains(text(),'Allow Card Type')]")

	public WebElement DisplayedonCardBin;

	@FindBy(xpath = "//span[contains(text(),'Sales Info')]")

	public WebElement ClickonSalesInfo;

	@FindBy(xpath = "//span[contains(text(),'Company Info')]")

	public WebElement ClickOnComapanyInfo;

	@FindBy(xpath = "//span[contains(text(),'Personal Info')]")

	public WebElement ClickOnPersonalInfo;

	@FindBy(xpath = "//span[contains(text(),'Communication Info')]")

	public WebElement ClickOnCommunicationInfo;

	@FindBy(xpath = "//span[contains(text(),'Risk Info')]")

	public WebElement ClickOnRiskInfo;

	@FindBy(xpath = "//span[contains(text(),'Card/Bin Profile')]")

	public WebElement ClickOnCardBinProfile;

	@FindBy(xpath = "//span[contains(text(),'Settlement Info')]")

	public WebElement ClickOnSettlementInfo;

	@FindBy(xpath = "(//span[contains(text(),'Terminals')])[3]")

	public WebElement CLickOnTerminal;

	@FindBy(xpath = "//span[contains(text(),'KYC')]")

	public WebElement ClickOnKYC;

	// Sales Info

	@FindBy(xpath = "//mat-label[contains(text(), 'Credopay Application Date')]")

	public WebElement CredopayApplicableDateLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Merchant Reference Number')]")

	public WebElement MerchantReferenceNumberLabel;

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']")
	public WebElement MerchantReferenceNumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'Aggregator Application Date')]")

	public WebElement AggregatorApplicationDate;

	@FindBy(xpath = "//mat-label[contains(text(), 'Aggregator')]")

	public WebElement AggregatorLabel;

	@FindBy(xpath = "//input[@formcontrolname='aggregator']")
	public WebElement CLickonAggregator;

	@FindBy(xpath = "//span[contains(text(), 'Transtrac Tech')]")

	public WebElement SelectOnAggregator;

	@FindBy(xpath = "//mat-label[contains(text(), 'ISO')]")

	public WebElement ISOLabel;

	@FindBy(xpath = "//input[@formcontrolname='distributors']")
	public WebElement ClickOnISO;

	@FindBy(xpath = "//input[@formcontrolname='groupMerchant']")
	public WebElement ClickOnGroupMerchant;

	@FindBy(xpath = "//mat-label[contains(text(), 'Sales Person')]")

	public WebElement salespersonLabel;

	@FindBy(xpath = "//input[@formcontrolname='salesPerson']")
	public WebElement ClickOnSalesPerson;

	@FindBy(xpath = "//input[@formcontrolname='branchCode']")
	public WebElement ClickonbranchCode;

	@FindBy(xpath = "//mat-label[contains(text(), 'Branch Code')]")

	public WebElement branchcodeLabel;

	// Company Info

	@FindBy(xpath = "//mat-label[contains(text(), 'Legal Name')]")

	public WebElement legalnameLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Brand Name')]")

	public WebElement BrandNameLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Registered Address')]")

	public WebElement RegisteredAddressLabel;

	@FindBy(xpath = "//span[contains(text(), 'Location')]")

	public WebElement LocationLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Registered Pincode')]")

	public WebElement RegisteredPincodeLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'State')]")

	public WebElement StateLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'City')]")

	public WebElement CityLabel;

	@FindBy(xpath = "//img[@alt='map']")
	public WebElement Location;

	@FindBy(xpath = "//input[@placeholder='Search for Location']")
	public WebElement SearchtheLocation;

	@FindBy(xpath = "//input[@formcontrolname='location']")
	public WebElement getLocation;

	@FindBy(xpath = "//span[contains(text(), 'Enter Complete Address')]")
	public WebElement CompleteAddress;

	@FindBy(xpath = "//mat-label[contains(text(), 'Latitude')]")

	public WebElement Latitudelabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Longitude')]")

	public WebElement Longtitudelabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Location Type')]")

	public WebElement Locationtypelabel;

	@FindBy(xpath = "//input[@formcontrolname='merchantType']")
	public WebElement MerchantType;

	@FindBy(xpath = "//mat-select[@formcontrolname='merchantClassification']")
	public WebElement Merchantclarification;

	// RiskInfo

	@FindBy(xpath = "//input[@formcontrolname='weekDaysFrom']")
	public WebElement WeekDaysFrom;

	@FindBy(xpath = "//input[@formcontrolname='weekDaysTo']")
	public WebElement WeekDaysTo;

	@FindBy(xpath = "//input[@formcontrolname='weekEndFrom']")
	public WebElement WeekEndFrom;

	@FindBy(xpath = "//input[@formcontrolname='weekEndTo']")
	public WebElement WeekEndTo;

//			Card/Bin Profile

	@FindBy(xpath = "//span[contains(text(),'Credit')]")
	public WebElement Credit;

	@FindBy(xpath = "//span[contains(text(),'Debit')]")
	public WebElement Debit;

	@FindBy(xpath = "//input[@formcontrolname='binNumber']")
	public WebElement ClickOnBinNumber;

	@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[3]")
	public WebElement ActionTerminal;
	
	@FindBy(xpath = "//span[contains(text(),'VERIFY')]")
	public WebElement VerifyTerminal;

	// SettlementInfo

	@FindBy(xpath = "//mat-select[@formcontrolname='payment']")
	public WebElement PaymentMode;

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementFlag']")
	public WebElement SettlementFlag;

	// Terminals

	@FindBy(xpath = "(//span[contains(text(),'Terminals')])[4]")

	public WebElement Terminals;

	@FindBy(xpath = "//input[@formcontrolname='terminalName']")
	public WebElement Terminal;

	@FindBy(xpath = "//mat-select[@formcontrolname='terminalType']")
	public WebElement terminalType;

	@FindBy(xpath = "//mat-select[@formcontrolname='upiTerminalType']")
	public WebElement UPITerminalType;

	@FindBy(xpath = "//mat-select[@formcontrolname='upiOfflineType']")
	public WebElement UPIofflineType;

	@FindBy(xpath = "//input[@formcontrolname='upiVPA']")
	public WebElement UPIVPA;

	@FindBy(xpath = "//input[@formcontrolname='deviceModel']")
	public WebElement deviceModel;

	@FindBy(xpath = "//input[@formcontrolname='deviceNumber']")
	public WebElement deviceNumber;

	@FindBy(xpath = "//input[@formcontrolname='imeiNumber']")
	public WebElement IMEINumber;

	@FindBy(xpath = "//mat-select[@formcontrolname='deviceType']")
	public WebElement DeviceType;

	@FindBy(xpath = "//mat-select[@formcontrolname='deviceComercialMode']")
	public WebElement DeviceCommercial;

	@FindBy(xpath = "//mat-select[@formcontrolname='tidFeeApplicable']")
	public WebElement TIDFeeApplicable;

	@FindBy(xpath = "//input[@formcontrolname='devicePrice']")
	public WebElement DevicePrice;

	@FindBy(xpath = "//input[@formcontrolname='installationFee']")
	public WebElement InstallationFee;

	public MerchantLocators(WebDriver driver) {
		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
