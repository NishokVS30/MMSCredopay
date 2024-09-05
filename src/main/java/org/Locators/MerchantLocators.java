package org.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MerchantLocators {
	
	WebDriver driver;
	
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
	private WebElement ClickonMerchantReferenceNumber;
	
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
	private WebElement ClickOnISO ;
	
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
	
	
	@FindBy(xpath = "//mat-label[text()='Latitude ']")
	private WebElement Latitudelabel;
	
	@FindBy(xpath = "//mat-label[text()='Longitude ']")
	private WebElement Longtitudelabel;
	
	@FindBy(xpath = "//mat-label[text()='Location Type ']")
	private WebElement Locationtypelabel;
	
	
}

