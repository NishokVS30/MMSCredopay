package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AggregatorLocators {

	WebDriver driver;

	@FindBy(xpath = "//mat-error[text()=' Invalid bank name ']")
	private WebElement InvalidBankName;
	
	@FindBy(xpath = "(//mat-error[text()=' Please Upload a document '])[1]")
	private WebElement InvalidDocumenterror;


//SideMenu

	@FindBy(xpath = "//span[text()='Sales Info']")
	private WebElement SalesInfo;

	@FindBy(xpath = "//span[text()='Company Info']")
	private WebElement ComapnyInfo;

	@FindBy(xpath = "//span[text()='Personal Info']")
	private WebElement PersonalInfo;

	@FindBy(xpath = "//span[text()='Communication Info']")
	private WebElement CommunicationInfo;

	@FindBy(xpath = "//span[text()='Channel Config']")
	private WebElement ChannelConfig;

	@FindBy(xpath = "//span[text()='KYC']")
	private WebElement KYC;

	@FindBy(xpath = "//span[text()='Risk Info']")
	private WebElement RiskINfo;

	@FindBy(xpath = "//span[text()='Discount Rate']")
	private WebElement DiscountRate;

	@FindBy(xpath = "//span[text()='Settlement Info']")
	private WebElement SettlementInfo;

	@FindBy(xpath = "//span[text()='Whitelabel']")
	private WebElement Whitelabel;

	@FindBy(xpath = "//span[text()='Webhooks']")
	private WebElement Webhooks;

	@FindBy(xpath = "//span[text()='Status History']")
	private WebElement StatusHistory;

	@FindBy(xpath = "//span[text()='Change Log']")
	private WebElement ChangeLog;
	
	
//IntroMenu
	
	@FindBy(xpath = "//h6[text()='Brand Info']")
	private WebElement IntroCompanyInfo;
	
	@FindBy(xpath = "//h6[text()='Partner / Director / Owner / Trustee Details']")
	private WebElement IntroPersonalInfo;
	
	@FindBy(xpath = "//h6[text()='ADMIN USER Details']")
	private WebElement IntroCommunicationInfo;
	
	@FindBy(xpath = "//h6[text()='Channel Configuration']")
	private WebElement IntroChannelConfig;
	
	@FindBy(xpath = "//h6[text()='Personal Documents']")
	private WebElement IntroKYC;
	
	@FindBy(xpath = "//h6[text()='FRM Parameters']")
	private WebElement IntroRiskInfo;
	
	@FindBy(xpath = "//h6[text()='Aggregator Discounts']")
	private WebElement IntroDiscountRate;
	
	@FindBy(xpath = "//h6[text()='Bank Details']")
	private WebElement IntroSettlementInfo;
	
	@FindBy(xpath = "//h6[text()='Aggregator Onboarding Configuration']")
	private WebElement IntroWhitelabel;
	
	@FindBy(xpath = "//h6[text()='Payment Bridge']")
	private WebElement IntroWebhooks;
	

//SalesInfo

	@FindBy(xpath = "(//mat-label[text()='VAS Commission'])[1]")
	private WebElement VASCommissionLabelOne;

	@FindBy(xpath = "(//mat-select[@formcontrolname='isVasAllowed'])[1]")
	private WebElement VASCommissionOne;

	@FindBy(xpath = "//span[text()=' Yes ']")
	private WebElement SalesInfoYes;

	@FindBy(xpath = "//span[text()=' No ']")
	private WebElement SalesInfoNO;

	@FindBy(xpath = "//mat-label[text()='Aggregator Application Date ']")
	private WebElement AggregatorApplicationDateLabel;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
	private WebElement AggregatorApplicationDateCalenderOne;

	@FindBy(xpath = "//span[text()='Apply']")
	private WebElement Apply;

	@FindBy(xpath = "//mat-label[text()='Agreement Date ']")
	private WebElement AggreementDateLabel;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	private WebElement AggregatorApplicationDateCalenderTwo;

	@FindBy(xpath = "//mat-label[text()='Aggregator Code ']")
	private WebElement AggregatorCodeLabel;

	@FindBy(xpath = "//input[@formcontrolname='aggregatorCode']")
	private WebElement AggregatorCode;

	@FindBy(xpath = "//mat-label[text()='Allow Self Merchant Onboard ']")
	private WebElement AllowSelfMerchantOnboardLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='allowSelfMerchant']")
	private WebElement AllowSelfMerchantOnboard;

	@FindBy(xpath = "//mat-label[text()='Mars Id']")
	private WebElement MarsIdLabel;

	@FindBy(xpath = "//input[@formcontrolname='marsId']")
	private WebElement MarsId;

	@FindBy(xpath = "//mat-label[text()='Auto Deactivation days ']")
	private WebElement AutoDeactivationdayslabel;

	@FindBy(xpath = "//input[@formcontrolname='autoDeactivationDays']")
	private WebElement AutoDeactivationdays;

	@FindBy(xpath = "(//mat-label[text()='VAS Commission'])[2]")
	private WebElement VASCommissionLabelTWO;

	@FindBy(xpath = "(//mat-select[@formcontrolname='isVasAllowed'])[2]")
	private WebElement VASCommissionTWO;

	@FindBy(xpath = "//mat-label[text()='Is TMS Aggregator ']")
	private WebElement IsTMSAggregatorLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='tmsAggregator']")
	private WebElement IsTMSAggregator;

	@FindBy(xpath = "//mat-label[text()='EKyc Required ']")
	private WebElement EKycRequiredLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='isEkycRequired']")
	private WebElement EKycRequired;

//ComapanyInfo

	@FindBy(xpath = "//mat-label[text()='Legal Name  ']")
	private WebElement LegalNameLabel;

	@FindBy(xpath = "//input[@formcontrolname='legalName']")
	private WebElement LegalName;

	@FindBy(xpath = "//mat-label[text()='Brand Name  ']")
	private WebElement BrandNameLabel;

	@FindBy(xpath = "//input[@formcontrolname='brandName']")
	private WebElement BrandName;

	@FindBy(xpath = "//mat-label[text()='Registered Address ']")
	private WebElement RegisteredAddressLabel;

	@FindBy(xpath = "//input[@formcontrolname='registerAddress']")
	private WebElement RegisteredAddress;

	@FindBy(xpath = "//mat-label[text()='Registered Pincode ']")
	private WebElement RegisteredPincodeLabel;

	@FindBy(xpath = "//input[@formcontrolname='registerPin']")
	private WebElement RegisteredPincode;

	@FindBy(xpath = "//span[text()=' 600341 '] | //span[text()='600341 ']")
	private WebElement SelectOnRegisteredPincode;

	@FindBy(xpath = "//mat-label[text()='State ']")
	private WebElement StateLabel;

	@FindBy(xpath = "//input[@formcontrolname='state']")
	private WebElement State;

	@FindBy(xpath = "//mat-label[text()='City  ']")
	private WebElement CityLabel;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	private WebElement City;

	@FindBy(xpath = "//mat-label[text()='Business Type ']")
	private WebElement BusinessTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='businessType']")
	private WebElement BusinessType;

	@FindBy(xpath = "//span[text()=' Trust ']")
	private WebElement SelectOnBusinessType;

	@FindBy(xpath = "//mat-label[text()='Established Year ']")
	private WebElement EstablishedYearLabel;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	private WebElement EstablishedYearDatepicker;

	@FindBy(xpath = "//mat-label[text()='Registered Number ']")
	private WebElement RegisterNumberLabel;

	@FindBy(xpath = "//input[@formcontrolname='registeredNumber']")
	private WebElement RegisterNumber;

	@FindBy(xpath = "//mat-label[text()='Company PAN  ']")
	private WebElement ComapanyPANLabel;

	@FindBy(xpath = "//input[@formcontrolname='companyPan']")
	private WebElement ComapnyPAN;

	@FindBy(xpath = "//mat-label[text()='GSTIN ']")
	private WebElement GSTINLabel;

	@FindBy(xpath = "//input[@formcontrolname='gstin']")
	private WebElement GSTIN;

	@FindBy(xpath = "//mat-label[text()='Statement Frequency ']")
	private WebElement StatementFrequencyLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementFrequency']")
	private WebElement StatementFrequency;

	@FindBy(xpath = "//span[text()=' Monthly ']")
	private WebElement SelectStatementFrequencyQuarterly;

	@FindBy(xpath = "//mat-label[text()='Statement Type ']")
	private WebElement StatementTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementType']")
	private WebElement StatementType;

	@FindBy(xpath = "//span[text()=' Pdf ']")
	private WebElement SelectStatementTypePDF;

	@FindBy(xpath = "//mat-label[text()='Email Domain ']")
	private WebElement EmailDoaminLabel;

	@FindBy(xpath = "//input[@oninput='this.value=this.value.toLowerCase()']")
	private WebElement EmailDomain;

//Personal Info

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement PersonalINfoADD;

	@FindBy(xpath = "//mat-label[text()='Title']")
	private WebElement titlepersonallabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='title']")
	private WebElement titlepersonal;

	@FindBy(xpath = "//span[text()=' Mr.']")
	private WebElement SelectbytitlePersonal;

	@FindBy(xpath = "//mat-label[text()='First Name ']")
	private WebElement FirstNamePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	private WebElement FirstNamePersonal;

	@FindBy(xpath = "//mat-label[text()='Last Name ']")
	private WebElement LastNamePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	private WebElement LastNamePersonal;

	@FindBy(xpath = "//mat-label[text()='Date Of Birth']")
	private WebElement DOBPersonllLabel;

	@FindBy(xpath = "//input[@formcontrolname='dob']")
	private WebElement DOBPersonl;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	private WebElement OpenCalenderPersonal;

	@FindBy(xpath = "//span[text()='Apply']")
	private WebElement ApplyPersonalDatePicker;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	private WebElement ChooseMonthandYear;

	@FindBy(xpath = "//div[text()=' 1998 ']")
	private WebElement Year;

	@FindBy(xpath = "//div[text()=' NOV ']")
	private WebElement Month;

	@FindBy(xpath = "//div[text()=' 30 ']")
	private WebElement Date;

	@FindBy(xpath = "//mat-label[text()='PAN ']")
	private WebElement PanPersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='pan']")
	private WebElement PanPersonal;

	@FindBy(xpath = "//mat-label[text()='Address']")
	private WebElement AddressPersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	private WebElement AddressPersonal;

	@FindBy(xpath = "//mat-label[text()='Pincode']")
	private WebElement PincodePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='pincode']")
	private WebElement PincodePersonal;

	@FindBy(xpath = "//mat-label[text()='City ']")
	private WebElement CityPersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	private WebElement CityPersonal;

	@FindBy(xpath = "//mat-label[text()='State ']")
	private WebElement StatePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='state']")
	private WebElement StatePersonal;

	@FindBy(xpath = "//mat-label[text()='Mobile ']")
	private WebElement MobilePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='mobile']")
	private WebElement MobilePersonal;

	@FindBy(xpath = "//mat-label[text()='Telephone ']")
	private WebElement telephonepersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='telephone']")
	private WebElement telephonepersonal;

	@FindBy(xpath = "//mat-label[text()='Email']")
	private WebElement emailpersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	private WebElement emailPersonal;

	@FindBy(xpath = "//mat-label[text()='Nationality ']")
	private WebElement NationalitypersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='nationality']")
	private WebElement Nationalitypersonal;

	@FindBy(xpath = "//mat-label[text()='Aadhaar Number ']")
	private WebElement AadhaarNumberLabelPersonal;

	@FindBy(xpath = "//input[@formcontrolname='aadharNumber']")
	private WebElement AadhaarNumberPersonal;

	@FindBy(xpath = "//mat-label[text()='Passport Number ']")
	private WebElement PassportNumberPersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='passportNumber']")
	private WebElement PassportNumberPersonal;

	@FindBy(xpath = "//mat-label[text()='Passport Expiry date ']")
	private WebElement PassportExpiryDatePersonal;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	private WebElement OpenCalenderPasswordExpiryDate;

//	@FindBy(xpath = "//span[text()='Save'] | //span[text()=' Save ']")
	@FindBy(xpath = "//span[contains(text(), 'Save')]")
	private WebElement SAVEPersonal;

//Channel Config

	@FindBy(xpath = "//mat-label[text()='Bank Name ']")
	private WebElement ChannelBankNameLabel;

	@FindBy(xpath = "//mat-label[text()='Channel ']")
	private WebElement ChannelLabel;

	@FindBy(xpath = "//mat-label[text()='Network ']")
	private WebElement CHannelNetworkLabel;

	@FindBy(xpath = "//mat-label[text()='Transaction Sets ']")
	private WebElement ChannelTransactionsetsLabel;

	@FindBy(xpath = "//mat-label[text()='Start Date']")
	private WebElement ChannelStartDateLabel;

	@FindBy(xpath = "//mat-label[text()='End Date']")
	private WebElement ChannelENDDateLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	private WebElement ChannelBankName;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	private WebElement Channel;

	@FindBy(xpath = "//span[text()=' POS'] | //span[text()='POS']")
	private WebElement ChannelPOS;

	@FindBy(xpath = "//span[text()=' AEPS'] | //span[text()='AEPS']")
	private WebElement ChannelAEPS;

	@FindBy(xpath = "//span[text()=' UPI'] | //mat-option[@role='option']//span[contains(text(), 'UPI')]")
	private WebElement ChannelUPI;

	@FindBy(xpath = "//mat-select[@formcontrolname='network']")
	private WebElement ChannelNetwork;

	@FindBy(xpath = "//mat-select[@formcontrolname='transaction']")
	private WebElement ChannelTransaction;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
	private WebElement ChannelOpencalender1;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	private WebElement ChannelOpencalender2;

	@FindBy(xpath = "//span[text()=' Apply']")
	private WebElement ChannelApply;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement ChannelSave;
	
//KYC
	
	@FindBy(xpath = "(//input[@type='file'])[2]")
	private WebElement CompanyProofofaddressUpload;
	
	@FindBy(xpath = "(//input[@type='file'])[8]")
	private WebElement CompanyPANUpload;
	
	@FindBy(xpath = "(//input[@type='file'])[13]")
	private WebElement GSTCertificateUpload;
	
	@FindBy(xpath = "(//input[@type='file'])[4]")
	private WebElement AadhaarUpload;	

//RiskInfo

	// Label
	@FindBy(xpath = "//mat-label[text()='Velocity Check Minutes ']")
	private WebElement VelocityCheckMinuteLabel;

	@FindBy(xpath = "//mat-label[text()=' Velocity Check Count ']")
	private WebElement VelocityCheckCountLabel;

	@FindBy(xpath = "//mat-label[text()=' Cash@POS Count']")
	private WebElement CashPOSCountLabel;

	@FindBy(xpath = "//mat-label[text()='International Card Acceptance ']")
	private WebElement InternationalCardCountLabel;

	@FindBy(xpath = "//mat-label[text()='Daily ']")
	private WebElement DailyLabel;

	@FindBy(xpath = "//mat-label[text()=' Weekly']")
	private WebElement WeeklyLabel;

	@FindBy(xpath = "//mat-label[text()=' Monthly ']")
	private WebElement MonthlyLabel;

	// Click

	@FindBy(xpath = "//input[@formcontrolname='vCheckMinutes']")
	private WebElement VelocityCheckMinute;

	@FindBy(xpath = "//input[@formcontrolname='vCheckCount']")
	private WebElement VelocityCheckCount;

	@FindBy(xpath = "//input[@formcontrolname='posPerDayCount']")
	private WebElement CashPOSCount;
	
	@FindBy(xpath = "//input[@formcontrolname='matmCount']")
	private WebElement microatmcount;

	@FindBy(xpath = "//mat-select[@formcontrolname='iCardAcceptance']")
	private WebElement InternationalCardCount;

	@FindBy(xpath = "//span[text()=' Yes ']")
	private WebElement YesInternationalCardCount;

	@FindBy(xpath = "//span[text()=' No ']")
	private WebElement NOInternationalCardCount;

	@FindBy(xpath = "//input[@formcontrolname='frmDaily']")
	private WebElement ICADaily;

	@FindBy(xpath = "//input[@formcontrolname='frmWeekly']")
	private WebElement ICAWeekly;

	@FindBy(xpath = "//input[@formcontrolname='frmMonthly']")
	private WebElement ICAMonthly;

	// POS
	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[3]")
	private WebElement POSDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[3]")
	private WebElement POSWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[3]")
	private WebElement POSMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[3]")
	private WebElement POSMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[3]")
	private WebElement POSMaximumAmount;

	// AEPS

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[2]")
	private WebElement AEPSDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[2]")
	private WebElement AEPSWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[2]")
	private WebElement AEPSMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[2]")
	private WebElement AEPSMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[2]")
	private WebElement AEPSMaximumAmount;

	// UPI

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[1]")
	private WebElement UPIDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[1]")
	private WebElement UPIWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[1]")
	private WebElement UPIMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[1]")
	private WebElement UPIMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[1]")
	private WebElement UPIMaximumAmount;
	
//DiscountRate
	@FindBy(xpath = "//input[@formcontrolname='pricingPlanDescription']")
	private WebElement DiscountRatePricingPlan;
	
	@FindBy(xpath = "//span[text()=' TestPOSS ']")
	private WebElement POSPricingPlan;

	@FindBy(xpath = "//span[text()=' Test AEPS ']")
	private WebElement AEPSPricingPlan;

	@FindBy(xpath = "//span[text()=' Test UPI ']")
	private WebElement UPIPricingPlan;


//Settlement

	@FindBy(xpath = "//mat-label[text()='Settlement Mode ']")
	private WebElement SettlementModeLabel;

	@FindBy(xpath = "//mat-label[text()='Payment Flag ']")
	private WebElement PaymentFlagLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementMode']")
	private WebElement SettlementMode;

	@FindBy(xpath = "//mat-select[@formcontrolname='paymentFlag']")
	private WebElement PaymentFlag;

	@FindBy(xpath = "//span[text()='Aggregator Gross Settlement']")
	private WebElement SelectOnSettlementMode;

	@FindBy(xpath = "//span[text()='D']")
	private WebElement SelectOnPaymenrFlag;

//WhiteLabel

	@FindBy(xpath = "//mat-label[text()='Allow to Create Merchant User']")
	private WebElement AllowtocreateMerchantLabel;

	@FindBy(xpath = "//mat-label[text()='UserName As ']")
	private WebElement UserNameAsLabl;

	@FindBy(xpath = "//mat-select[@formcontrolname='createMerchentUser']")
	private WebElement CreateMerchantUser;

	@FindBy(xpath = "//mat-select[@formcontrolname='userNameAs']")
	private WebElement UserNameAs;

	@FindBy(xpath = "//span[text()=' phone ']")
	private WebElement SelectonUserNameAs;
	
//Manual Takeover
	
	@FindBy(xpath = "//span[text()=' Manual Takeover ']")
	private WebElement ManualTakeOver;
	
	@FindBy(xpath = "(//span[text()=' View Document '])[1]")
    private WebElement ViewDocument1;
	
	@FindBy(xpath = "(//span[text()=' View Document '])[2]")
    private WebElement ViewDocument2;

	
	@FindBy(xpath = "(//span[text()=' View Document '])[3]")
    private WebElement ViewDocument3;

	
	@FindBy(xpath = "//mat-select[@formcontrolname='type']")
    private WebElement Actions;
	
	@FindBy(xpath = "//span[text()=' Verified ']")
    private WebElement ViewDocumentVerified;

	@FindBy(xpath = "//span[text()='Submit & Next']")
    private WebElement ViewDocumentSubmitandNext;
	

	public AggregatorLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
//IntroPage
	
	public void DisplayedOnIntroCompanyInfo() {
		try {
			assertTrue("Company Info Page should be displayed", IntroCompanyInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Company Info Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnIntroPersonalInfo() {
		try {
			assertTrue("Personal Info Page should be displayed", IntroPersonalInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Personal Info Page Should be displayed But not found.");
		}
	}
	
	
	public void DisplayedOnIntroCommunicationInfo() {
		try {
			assertTrue("Communication Info Page should be displayed", IntroCommunicationInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication Info Page Should be displayed But not found.");
		}
	}
	
	
	public void DisplayedOnIntroChannelConfig() {
		try {
			assertTrue("Channel Config Page should be displayed", IntroChannelConfig.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Channel Config Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnIntroKYC() {
		try {
			assertTrue("KYC Page should be displayed", IntroKYC.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("KYC Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnIntroRiskInfo() {
		try {
			assertTrue("Risk Info Page should be displayed", IntroRiskInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Risk Info Page Should be displayed But not found.");
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
	
	public void DisplayedOnIntroSettlement() {
		try {
			assertTrue("Settlement Info Page should be displayed", IntroSettlementInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Info Page Should be displayed But not found.");
		}
	}
	
	
	public void DisplayedOnIntroWhiteLabel() {
		try {
			assertTrue("Whitelabel Page should be displayed", IntroWhitelabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Whitelabel Page Should be displayed But not found.");
		}
	}
	
	
	public void DisplayedOnIntroWebhook() {
		try {
			assertTrue("Webhook Page should be displayed", IntroWebhooks.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Webhook Page Should be displayed But not found.");
		}
	}
	
	
	
	
	public void DisplayedOnInvalidBankName() {

		try {
			assertTrue("Invalid Bank Name should be displayed", InvalidBankName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Invalid Bank Name Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnInvalidDocumenterror() {

		try {
			assertTrue("Please Upload a document should be displayed", InvalidDocumenterror.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Please Upload a document Should be displayed But not found.");
		}
	}

//SideMenu

	public void ClickOnSalesInfo() {

//		SalesInfo.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SalesInfo));
			SalesInfo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SalesInfo));
			SalesInfo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}

	public void ClickOnCompanyInfo() {

//		ComapnyInfo.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ComapnyInfo));
			ComapnyInfo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ComapnyInfo));
			ComapnyInfo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	
	public void ClickOnPersonalInfo() {

//		WhitelabelMaxNumberOfPlatform.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo));
			PersonalInfo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo));
			PersonalInfo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}


	public void ClickOnCommunicationInfo() {

//		CommunicationInfo.click();
		
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommunicationInfo));
			CommunicationInfo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommunicationInfo));
			CommunicationInfo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}


	}

	public void ClickOnChannelConfig() {

//		ChannelConfig.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ChannelConfig));
			ChannelConfig.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ChannelConfig));
			ChannelConfig.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}


	}

	public void ClickOnKYC() {

//		KYC.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYC));
			KYC.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYC));
			KYC.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}


	}

	public void ClickOnRiskInfo() {

//		RiskINfo.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(RiskINfo));
			RiskINfo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(RiskINfo));
			RiskINfo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnDiscountRate() {

//		DiscountRate.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(DiscountRate));
			DiscountRate.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(DiscountRate));
			DiscountRate.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}


	}

	public void ClickOnSettlementInfo() {

//		SettlementInfo.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementInfo));
			SettlementInfo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementInfo));
			SettlementInfo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnWhitelabel() {

//		Whitelabel.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Whitelabel));
			Whitelabel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Whitelabel));
			Whitelabel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}


	}

	public void ClickOnWebhooks() {

//		Webhooks.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Webhooks));
			Webhooks.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Webhooks));
			Webhooks.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnStatusHistory() {

//		StatusHistory.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(StatusHistory));
			StatusHistory.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(StatusHistory));
			StatusHistory.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnChangeLog() {

//		ChangeLog.click();
		
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ChangeLog));
			ChangeLog.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ChangeLog));
			ChangeLog.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	// SalesInfoLabel

	public void VASCommissionLabelNameOne() {
		try {
			assertTrue("VAS Commission Label Name should be displayed", VASCommissionLabelOne.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("VAS Commission Label Name Should be displayed but not found.");
		}
	}

	public void AggregatorApplicationDateLabelName() {
		try {
			assertTrue("Aggregator Application Date Label Name should be displayed",
					AggregatorApplicationDateLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Aggregator Application Date Label Name Should be displayed but not found.");
		}
	}

	public void AggreementDateLabelName() {
		try {
			assertTrue("Aggreement Date Label Name should be displayed", AggreementDateLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Aggreement Date Label Name Should be displayed but not found.");
		}
	}

	public void AggregatorCodeLabelName() {
		try {
			assertTrue("Aggregator Code Label Name should be displayed", AggregatorCodeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Aggregator Code Label Name Should be displayed but not found.");
		}
	}

	public void AllowSelfMerchantOnboardLabelName() {
		try {
			assertTrue("Allow Self Merchant Onboard Label Name should be displayed",
					AllowSelfMerchantOnboardLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Allow Self Merchant Onboard Label Name Should be displayed but not found.");
		}
	}

	public void MarsidLabelName() {
		try {
			assertTrue("Marsid Label Name should be displayed", MarsIdLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Marsid Label Name Should be displayed but not found.");
		}
	}

	public void AutoDeactivationLabelName() {
		try {
			assertTrue("Auto Deactivation Label Name should be displayed", AutoDeactivationdayslabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Auto Deactivation Label Name Should be displayed but not found.");
		}
	}

	public void VASCommissionLabelNameTWO() {
		try {
			assertTrue("VAS Commission Label Name should be displayed", VASCommissionLabelTWO.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("VAS Commission Label Name Should be displayed but not found.");
		}
	}

	public void IsTMSAggregatorLabel() {
		try {
			assertTrue("Is TMS Aggregator Label Name should be displayed", IsTMSAggregatorLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Is TMS Aggregator Label Name Should be displayed but not found.");
		}
	}

	public void EKycRequiredLabel() {
		try {
			assertTrue("EKyc Required Label Name should be displayed", IsTMSAggregatorLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("EKyc Required Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnVASCommisiionOne() {

//		VASCommissionOne.click();
		
		  try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(VASCommissionOne));
	   			VASCommissionOne.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(VASCommissionOne));
	   			VASCommissionOne.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void SalesInfoYes() {

//		SalesInfoYes.click();
		
		  try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SalesInfoYes));
	   			SalesInfoYes.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SalesInfoYes));
	   			SalesInfoYes.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}
	}

	public void SalesInfoNO() {

//		SalesInfoNO.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SalesInfoNO));
	   			SalesInfoNO.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SalesInfoNO));
	   			SalesInfoNO.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void ClickOnAggreratorApplictionDate() {

//		AggregatorApplicationDateCalenderOne.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AggregatorApplicationDateCalenderOne));
	   			AggregatorApplicationDateCalenderOne.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AggregatorApplicationDateCalenderOne));
	   			AggregatorApplicationDateCalenderOne.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

		
		

	}

	public void ClickOnApply() {

//		Apply.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(Apply));
	   			Apply.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(Apply));
	   			Apply.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void ClickOnAggrementnDate() {

//		AggregatorApplicationDateCalenderTwo.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AggregatorApplicationDateCalenderTwo));
	   			AggregatorApplicationDateCalenderTwo.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AggregatorApplicationDateCalenderTwo));
	   			AggregatorApplicationDateCalenderTwo.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void ClickOnAggregatorCOde() {

//		AggregatorCode.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AggregatorCode));
	   			AggregatorCode.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AggregatorCode));
	   			AggregatorCode.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void EnterOnAggregatorCOde(String aggrement) {

		AggregatorCode.sendKeys(aggrement);

	}

	public void ClickOnAllowSelfMerchantOnboard() {

//		AllowSelfMerchantOnboard.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AllowSelfMerchantOnboard));
	   			AllowSelfMerchantOnboard.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(AllowSelfMerchantOnboard));
	   			AllowSelfMerchantOnboard.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void ClickOnMarsid() {

//		MarsId.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(MarsId));
	   			MarsId.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(MarsId));
	   			MarsId.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void EnterOnMarsid(String marsid) {

		MarsId.sendKeys(marsid);

	}

	public void ClickOnAutoDeactivationdays() {

//		AutoDeactivationdays.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(AutoDeactivationdays));
   			AutoDeactivationdays.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(AutoDeactivationdays));
   			AutoDeactivationdays.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}

	}

	public void ClearOnAutoDeactivationdays() {

		AutoDeactivationdays.clear();
	}

	public void EnterOnAutoDeactivationdays(String marsid) {

		AutoDeactivationdays.sendKeys(marsid);

	}

	public void ClickOnVASCommisiionTWO() {

//		VASCommissionTWO.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(VASCommissionTWO));
   			VASCommissionTWO.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(VASCommissionTWO));
   			VASCommissionTWO.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnISTMSAggregator() {

//		IsTMSAggregator.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(MarsId));
	   			MarsId.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(MarsId));
	   			MarsId.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void ClickOnEKYCRequired() {

//		EKycRequired.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(EKycRequired));
	   			EKycRequired.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(EKycRequired));
	   			EKycRequired.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

//CompanyInfo

	public void LegalNameLabel() {
		try {
			assertTrue("Legal Label Name should be displayed", LegalNameLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Legal Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnLegalName() {

//		LegalName.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(LegalName));
	   			LegalName.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(LegalName));
	   			LegalName.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void ClearOnLegalName() {

		LegalName.clear();

	}

	public void EnterOnLegalName(String Legal) {

		LegalName.sendKeys(Legal);

	}

	public void BrandNameLabel() {
		try {
			assertTrue("Brand Label Name should be displayed", BrandNameLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Brand Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnBrandName() {

//		BrandName.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(BrandName));
	   			BrandName.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(BrandName));
	   			BrandName.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void ClearOnBrandName() {

		BrandName.clear();

	}

	public void EnterOnBrandName(String brand) {

		BrandName.sendKeys(brand);

	}

	public void RegisteredAddressLabel() {
		try {
			assertTrue("Registered Address Label Name should be displayed", RegisteredAddressLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Registered Address Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnRegisteredAddress() {

//		RegisteredAddress.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(RegisteredAddress));
	   			RegisteredAddress.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(RegisteredAddress));
	   			RegisteredAddress.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void EnterOnRegisteredAddress(String address) {

		RegisteredAddress.sendKeys(address);

	}

	public void RegisteredPincodeLabel() {
		try {
			assertTrue("State Label Name should be displayed", RegisteredPincodeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Registered Pincode Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnRegisteredPincode() {

//		RegisteredPincode.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(RegisteredPincode));
	   			RegisteredPincode.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(RegisteredPincode));
	   			RegisteredPincode.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}



	}
	
	public void EnterOnRegisteredPincode(String pin) {
		RegisteredPincode.sendKeys(pin);
		
	}
	
	
	

	public String getRegisteredPincode() {
		return RegisteredPincode.getAttribute("value");
	}

	public void SelectOnRegisteredPincode() {

//		SelectOnRegisteredPincode.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SelectOnRegisteredPincode));
	   			SelectOnRegisteredPincode.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SelectOnRegisteredPincode));
	   			SelectOnRegisteredPincode.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void RegisteredStateLabel() {
		try {
			assertTrue("State Label Name should be displayed", StateLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("State Label Name Should be displayed but not found.");
		}
	}

	public String getState() {
		return State.getAttribute("value");
	}

	public void RegisteredCityLabel() {
		try {
			assertTrue("City Label Name should be displayed", CityLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("City Label Name Should be displayed but not found.");
		}
	}

	public String getCity() {
		return City.getAttribute("value");
	}

	public void BusinessTypeLabel() {
		try {
			assertTrue("Business Type Label Name should be displayed", BusinessTypeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Business Type Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnBusinessType() {

//		BusinessType.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(BusinessType));
	   			BusinessType.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(BusinessType));
	   			BusinessType.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void SelectOnBusinessType() {

//		SelectOnBusinessType.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBusinessType));
	   			SelectOnBusinessType.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBusinessType));
	   			SelectOnBusinessType.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void EstablishedYearLabel() {
		try {
			assertTrue("Established Year Label Name should be displayed", EstablishedYearLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Established Year Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnEstablishedYearDatepicker() {

//		EstablishedYearDatepicker.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(EstablishedYearDatepicker));
	   			EstablishedYearDatepicker.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(EstablishedYearDatepicker));
	   			EstablishedYearDatepicker.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void RegisteredNumberLabel() {
		try {
			assertTrue("Register Number Label Name should be displayed", RegisterNumberLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Register Number Label Name Should be displayed but not found.");
		}
	}

	public void CLickOnRegisterNumber() {

//		RegisterNumber.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(RegisterNumber));
	   			RegisterNumber.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(RegisterNumber));
	   			RegisterNumber.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void CLearOnRegisterNumber() {

		RegisterNumber.clear();

	}

//	public void EnterOnRegisterNumber(String register) {
//
//		RegisterNumber.sendKeys(register);
//
//	}

//	public void EnterOnRegisterNumber(Integer num) {
//		RegisterNumber.sendKeys(num.toString());
//	}
	
	public void EnterOnRegisterNumber(String num) {
	RegisterNumber.sendKeys(num);
}

	public void CompanyPANLabel() {
		try {
			assertTrue("Company PAN Label Name should be displayed", ComapanyPANLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Company PAN Label Name Should be displayed but not found.");
		}
	}

	public void CLickOnCompanyPAN() {

//		ComapnyPAN.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(ComapnyPAN));
	   			ComapnyPAN.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(ComapnyPAN));
	   			ComapnyPAN.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void CLearOnCompanyPAN() {

		ComapnyPAN.clear();

	}

	public void EnterOnCompanyPAN(String company) {

		ComapnyPAN.sendKeys(company);

	}

	public void GSTINLabel() {
		try {
			assertTrue("GSTIN Label Name should be displayed", GSTINLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("GSTIN Label Name Should be displayed but not found.");
		}
	}

	public void CLickOnGSTIN() {

//		GSTIN.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(GSTIN));
	   			GSTIN.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(GSTIN));
	   			GSTIN.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

		
		

	}

	public void CLearOnGSTIN() {

		GSTIN.clear();

	}

	public void EnterOnGSTIN(String gstin2) {

		GSTIN.sendKeys(gstin2);

	}

	public void EnterOnGSTIN1(Integer gstin2) {
		GSTIN.sendKeys(gstin2.toString());
	}

	public void StatementFrequencyLabel() {
		try {
			assertTrue("Statement Frequency Label Name should be displayed", StatementFrequencyLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Statement Frequency Label Name Should be displayed but not found.");
		}
	}

	public void CLickOnStatementFrequency() {

//		StatementFrequency.click();
		
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(StatementFrequency));
	   			StatementFrequency.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(StatementFrequency));
	   			StatementFrequency.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}


	}

	public void SelectOnStatementFrequencyQuarterly() {

//		SelectStatementFrequencyQuarterly.click();
		
		 try {

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementFrequencyQuarterly));
	   			SelectStatementFrequencyQuarterly.click();
	   		} catch (ElementClickInterceptedException e) {

	   			System.err.println("Element click intercepted: " + e.getMessage());

	   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementFrequencyQuarterly));
	   			SelectStatementFrequencyQuarterly.click();
	   		} catch (Exception e) {
	   			// Handle other potential exceptions
	   			System.err.println("An unexpected error occurred: " + e.getMessage());
	   		}

	}

	public void StatementTypeLabel() {
		try {
			assertTrue("Statement Type Label Name should be displayed", StatementTypeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Statement Type Label Name Should be displayed but not found.");
		}
	}

	public void CLickOnStatementType() {

//		StatementType.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(StatementType));
   			StatementType.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(StatementType));
   			StatementType.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void SelectOnStatementTypePDF() {

//		SelectStatementTypePDF.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementTypePDF));
   			SelectStatementTypePDF.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementTypePDF));
   			SelectStatementTypePDF.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void EmailDomainLabel() {
		try {
			assertTrue("Email Domain Label Name should be displayed", StatementFrequencyLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("GSTIN Label Name Should be displayed but not found.");
		}
	}

	public void CLickOnEmailDomain() {

//		EmailDomain.click();
		
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(EmailDomain));
   			EmailDomain.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(EmailDomain));
   			EmailDomain.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}



	}

	public void EnterOnEmailDomain(String domain) {

		EmailDomain.sendKeys(domain);

	}

	public void EmailDomainClear() {

		EmailDomain.sendKeys(Keys.chord(Keys.CONTROL, "a"));// Select all text
		EmailDomain.sendKeys(Keys.BACK_SPACE);

	}

//PersonalLabel

	public void Titlepersonallabel() {
		try {
			assertTrue("Title Label Name should be displayed", titlepersonallabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Title Label Name Should be displayed but not found.");
		}
	}

	public void FirstNamePersonalLabel() {
		try {
			assertTrue("First Name Label should be displayed", FirstNamePersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("First Name Label Should be displayed but not found.");
		}
	}

	public void LastNamePersonalLabel() {
		try {
			assertTrue("Last Name Label should be displayed", LastNamePersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Last Name Label Should be displayed but not found.");
		}
	}

	public void DOBPersonalLabel() {
		try {
			assertTrue("Date Of Birth Label Name should be displayed", DOBPersonllLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Date Of Birth Label Name Should be displayed but not found.");
		}
	}

	public void PANPersonalLabel() {
		try {
			assertTrue("PAN Label Name should be displayed", PanPersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("PAN Label Name Should be displayed but not found.");
		}
	}

	public void AddressPersonalLabel() {
		try {
			assertTrue("Address Label Name should be displayed", AddressPersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Address Label Name Should be displayed but not found.");
		}
	}

	public void PincodePersonalLabel() {
		try {
			assertTrue("Pincode Label Name should be displayed", PincodePersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Pincode Label Name Should be displayed but not found.");
		}
	}

	public void CityPersonalLabel() {
		try {
			assertTrue("City Label Name should be displayed", CityPersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("City Label Name Should be displayed but not found.");
		}
	}

	public void StatePersonalLabel() {
		try {
			assertTrue("State Label Name should be displayed", StatePersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("State Label Name Should be displayed but not found.");
		}
	}

	public void MobilePersonalLabel() {
		try {
			assertTrue("Mobile Label Name should be displayed", MobilePersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Mobile Label Name Should be displayed but not found.");
		}
	}

	public void TelephonePersonalLabel() {
		try {
			assertTrue("Telephone Label Name should be displayed", telephonepersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Telephone Label Name Should be displayed but not found.");
		}
	}

	public void EmailPersonalLabel() {
		try {
			assertTrue("EMail Label Name should be displayed", emailpersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Email Label Name Should be displayed but not found.");
		}
	}

	public void NationalityPersonalLabel() {
		try {
			assertTrue("Nationality Label Name should be displayed", NationalitypersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Nationality Label Name Should be displayed but not found.");
		}
	}

	public void AadhaarNumberPersonalLabel() {
		try {
			assertTrue("Aadhaar Number Label Name should be displayed", AadhaarNumberLabelPersonal.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Aadhaar Number Label Name Should be displayed but not found.");
		}
	}

	public void PassportNumberPersonalLabel() {
		try {
			assertTrue("Passport Number Label Name should be displayed", PassportNumberPersonalLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Passport Number Label Name Should be displayed but not found.");
		}
	}

	public void PassportExpiryDatePersonalLabel() {
		try {
			assertTrue("Passport Expiry Date Label Name should be displayed", PassportExpiryDatePersonal.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Passport Expiry Date Label Name Should be displayed but not found.");
		}
	}

	public void PersonalINfoADD() {

		PersonalINfoADD.click();

	}

	public void ClickOntitlepersonal() {

//		titlepersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(titlepersonal));
   			titlepersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(titlepersonal));
   			titlepersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void Selectbytitlepersonal() {

//		SelectbytitlePersonal.click();
		
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(SelectbytitlePersonal));
   			SelectbytitlePersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(SelectbytitlePersonal));
   			SelectbytitlePersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnFirstNamePersonal() {

//		FirstNamePersonal.click();
		
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(FirstNamePersonal));
   			FirstNamePersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(FirstNamePersonal));
   			FirstNamePersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClearOnFirstNamePersonal() {

		FirstNamePersonal.clear();

	}

	public void EnterOnFirstNamePersonal(String first) {

		FirstNamePersonal.sendKeys(first);

	}

	public void ClickOnLastNamePersonal() {

//		LastNamePersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(LastNamePersonal));
   			LastNamePersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(LastNamePersonal));
   			LastNamePersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}

	}

	public void ClearOnLastNamePersonal() {

		LastNamePersonal.clear();

	}

	public void EnterOnLastNamePersonal(String last) {

		LastNamePersonal.sendKeys(last);

	}

	public void ClickOnDOBPersonal() {

//		DOBPersonl.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(DOBPersonl));
   			DOBPersonl.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(DOBPersonl));
   			DOBPersonl.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnOpenCalenderPersonal() {

//		OpenCalenderPersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(OpenCalenderPersonal));
   			OpenCalenderPersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(OpenCalenderPersonal));
   			OpenCalenderPersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnChooseMonthandYearPersonal() {

//		ChooseMonthandYear.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(ChooseMonthandYear));
   			ChooseMonthandYear.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(ChooseMonthandYear));
   			ChooseMonthandYear.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnYearPersonal() {

//		Year.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Year));
   			Year.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Year));
   			Year.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnMonthPersonal() {

//		Month.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Month));
   			Month.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Month));
   			Month.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnDatePersonal() {

//		Date.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Date));
   			Date.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Date));
   			Date.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnApplyPersonal() {

//		ApplyPersonalDatePicker.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(ApplyPersonalDatePicker));
   			ApplyPersonalDatePicker.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(ApplyPersonalDatePicker));
   			ApplyPersonalDatePicker.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClickOnPANPersonal() {

//		PanPersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(PanPersonal));
   			PanPersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(PanPersonal));
   			PanPersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClearOnPANPersonal() {

		PanPersonal.clear();

	}

	public void EnterOnPanPersonal(String pan) {

		PanPersonal.sendKeys(pan);

	}

	public void ClickOnAddressPersonal() {

//		AddressPersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(AddressPersonal));
   			AddressPersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(AddressPersonal));
   			AddressPersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}

	}

	public void ClearOnAddressPersonal() {

		AddressPersonal.clear();

	}

	public void EnterOnAddressPersonal(String address) {

		AddressPersonal.sendKeys(address);

	}

	public void ClickOnPincodePersonal() {

		PincodePersonal.click();
		
	}

	public String getPincodePersonal() {
		return PincodePersonal.getAttribute("value");
	}

	public void ClickOnMobileNumberPersonal() {

//		MobilePersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(MobilePersonal));
   			MobilePersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(MobilePersonal));
   			MobilePersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClearOnMobileNumberPersonal() {

		MobilePersonal.clear();

	}

	public void EnterOnMobileNumberPersonal(String mobile) {

		MobilePersonal.sendKeys(mobile);

	}

	public void ClickOnTelephonePersonal() {

//		telephonepersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(telephonepersonal));
   			telephonepersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(telephonepersonal));
   			telephonepersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClearOnTelephonePersonal() {

		telephonepersonal.clear();

	}

	public void EnterOnTelephonePersonal(String tele) {

		telephonepersonal.sendKeys(tele);

	}

	public void ClickOnEmailPersonal() {

//		emailPersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(emailPersonal));
   			emailPersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(emailPersonal));
   			emailPersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClearOnEmailPersonal() {

		emailPersonal.clear();

	}

	public void EnterOnemailPersonal(String email) {

		emailPersonal.sendKeys(email);

	}

	public void ClickOnNationalityPersonal() {

//		Nationalitypersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Nationalitypersonal));
   			Nationalitypersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(Nationalitypersonal));
   			Nationalitypersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClearOnNationalityPersonal() {

		Nationalitypersonal.clear();

	}

	public void EnterOnNationalitypersonal(String nation) {

		Nationalitypersonal.sendKeys(nation);

	}

	public void ClickOnAadhaarNumberPersonal() {

//		AadhaarNumberPersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(AadhaarNumberPersonal));
   			AadhaarNumberPersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(AadhaarNumberPersonal));
   			AadhaarNumberPersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}

	}

	public void ClearOnAadhaarNumberPersonal() {

		AadhaarNumberPersonal.clear();

	}

	public void EnterOnAadhaarNumberPersonal(String aadhar) {

		AadhaarNumberPersonal.sendKeys(aadhar);

	}

	public String getAadhaarPersonal() {
		return AadhaarNumberPersonal.getAttribute("value");
	}

	public void ClickOnPassportNumberPersonal() {

//		PassportNumberPersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(PassportNumberPersonal));
   			PassportNumberPersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(PassportNumberPersonal));
   			PassportNumberPersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}


	}

	public void ClearOnPassportNumberPersonal() {

		PassportNumberPersonal.clear();

	}

	public void EnterOnPassportNumberPersonal(String pass) {

		PassportNumberPersonal.sendKeys(pass);

	}

	public void ClickOnOpenCalenderPasswordExpiry() {

//		OpenCalenderPasswordExpiryDate.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(OpenCalenderPasswordExpiryDate));
   			OpenCalenderPasswordExpiryDate.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(OpenCalenderPasswordExpiryDate));
   			OpenCalenderPasswordExpiryDate.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}

	}

	public void ClickOnSAVEPersonal() {

//		SAVEPersonal.click();
		
		try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(SAVEPersonal));
   			SAVEPersonal.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(SAVEPersonal));
   			SAVEPersonal.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}

	}

//ChannelConfig
	public void ChannelBankNameLabel() {
		try {
			assertTrue("Bank Name Label Should be displayed", ChannelBankNameLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Bank Name Label Should be displayed but not found.");
		}
	}

	public void ChannelLabel() {
		try {
			assertTrue("Channel Label Name Should be displayed", ChannelLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Channel Label Name Should be displayed but not found.");
		}
	}

	public void CHannelNetworkLabel() {
		try {
			assertTrue("Network Label Name Should be displayed", CHannelNetworkLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Network Label Name Should be displayed but not found.");
		}
	}

	public void ChannelTransactionsetsLabel() {
		try {
			assertTrue("Transaction Set Label Name Should be displayed", ChannelTransactionsetsLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Transaction Set Label Name Should be displayed but not found.");
		}
	}

	public void ChannelStartDateLabel() {
		try {
			assertTrue("Start Date Label Name Should be displayed", ChannelStartDateLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Start Date Label Name Should be displayed but not found.");
		}
	}

	public void ChannelEndDateLabel() {
		try {
			assertTrue("End Date Label Name Should be displayed", ChannelENDDateLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("End Date Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnChannelBankName() {
		
		ChannelBankName.click();

	}
	
	public void ClearOnChannelBankName() {
		
		ChannelBankName.clear();

	}


	public void EnterOnChannelBankName(String bankname) {
		
		ChannelBankName.sendKeys(bankname);

	}
	
	public void ClickOnChannel() {
		
		Channel.click();

	}
	
	public void SelectOnPOSChannel() {
	    
		ChannelPOS.click();

	}
	
	
       public void SelectonUPIChannel() {
		
 //   	   ChannelUPI.click();
    	   
    	   try {

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(ChannelUPI));
   			ChannelUPI.click();
   		} catch (ElementClickInterceptedException e) {

   			System.err.println("Element click intercepted: " + e.getMessage());

   			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   			wait.until(ExpectedConditions.elementToBeClickable(ChannelUPI));
   			ChannelUPI.click();
   		} catch (Exception e) {
   			// Handle other potential exceptions
   			System.err.println("An unexpected error occurred: " + e.getMessage());
   		}
		
		}

	
	public void SelectOnAEPSChannel() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ChannelAEPS);	    
	   
	
	}

	
   public void ClickOnChannelNetwork() {
		
        ChannelNetwork.click();

	}
   
   public void ClickOnChannelTransactionsets() {
		
       ChannelTransaction.click();

	}
   
   public void ClickOnChannelStartDate() {
		
       ChannelOpencalender1.click();

	}
   
   public void ClickOnChannelENDDate() {
		
       ChannelOpencalender2.click();

	}
   
   
   public void ClickOnChannelApply() {
		
       ChannelApply.click();

	}
   
   public void ClickOnChannelSave() {
		
       ChannelSave.click();

	}
   
//KYC   
   
   public void UploadCompanyProofofaddress(String proofofaddress) {
		
	   //    CompanyPANUpload.click();
		   CompanyProofofaddressUpload.sendKeys(proofofaddress);

		}
   
   
   public void UploadCompanyPAN(String pan) {
		
   //    CompanyPANUpload.click();
	   CompanyPANUpload.sendKeys(pan);

	}
   
   public void UploadGSTCertificate(String gst) {
		
      // GSTCertificateUpload.click();

       GSTCertificateUpload.sendKeys(gst);
	}
   
   public void Aadhaar(String aadhaar) {
		
	      // GSTCertificateUpload.click();

	       AadhaarUpload.sendKeys(aadhaar);
		}
	

//RiskInfo

	public void VelocityCheckMinuteLabel() {
		try {
			assertTrue("Velocity Check Minute Label Name should be displayed", VelocityCheckMinuteLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Velocity Check Minute Label Name Should be displayed but not found.");
		}
	}

	public void VelocityCheckCountLabel() {
		try {
			assertTrue("Velocity Check Count Label Name should be displayed", VelocityCheckCountLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Velocity Check Count Label Name Should be displayed but not found.");
		}
	}

	public void CashpOScountLabel() {
		try {
			assertTrue("Cash POS Count Label Name should be displayed", CashPOSCountLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Cash POS Count Label Name Should be displayed but not found.");
		}
	}

	public void InternationalcardCountLabel() {
		try {
			assertTrue("International Card Count Label Name should be displayed",
					InternationalCardCountLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("International Card Count Label Name Should be displayed but not found.");
		}
	}

	public void DailyLabel() {
		try {
			assertTrue("Daily Label Name should be displayed", DailyLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Daily Label Name Should be displayed but not found.");
		}
	}

	public void WeeklyLabel() {
		try {
			assertTrue("Weekly Label Name should be displayed", WeeklyLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Weekly Label Name Should be displayed but not found.");
		}
	}

	public void MonthlyLabel() {
		try {
			assertTrue("Monthly Label Name should be displayed", MonthlyLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Monthly Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnVelocityCheckMinute() {

		VelocityCheckMinute.click();

	}

	public void ClickOnVelocityCheckCount() {

		VelocityCheckCount.click();

	}

	public void ClickOnCashpOScount() {

		CashPOSCount.click();

	}
	
	public void ClickOnMicroAtmcount() {

		microatmcount.click();

	}


	public void ClickOnInternationalcardCount() {

		InternationalCardCount.click();

	}

	public void EnterOnVelocityCheckMinute(String checkMinute) {

		VelocityCheckMinute.sendKeys(checkMinute);

	}

	public void EnterOnVelocityCheckCount(String checkcount) {

		VelocityCheckCount.sendKeys(checkcount);

	}

	public void EnterOnCashpOScount(String cashposcount) {

		CashPOSCount.sendKeys(cashposcount);

	}
	
	
	public void EnterOnMicroAtmcount(String icroatmcount) {
   
		microatmcount.sendKeys(icroatmcount);

	}
	
	

	public void yesInternationalcardCount() {

		YesInternationalCardCount.click();

	}

	public void NoInternationalcardCount() {

		NOInternationalCardCount.click();

	}

	public void ClickonICAdaily() {

		ICADaily.click();
	}

	public void ClearonICAdaily() {

		ICADaily.clear();
	}

	public void ClickonICAWeekly() {

		ICAWeekly.click();
	}

	public void ClearonICAWeekly() {

		ICAWeekly.clear();
	}

	public void ClickonICAMonthly() {

		ICAMonthly.click();
	}

	public void ClearonICAMonthly() {

		ICAMonthly.clear();
	}

	public void EnteronICAdaily(String daily) {

		ICADaily.sendKeys(daily);
	}

	public void EnteronICAWeekly(String Weekly) {

		ICAWeekly.sendKeys(Weekly);
	}

	public void EnteronICAMonthly(String Monthly) {

		ICAMonthly.sendKeys(Monthly);
	}
	
//DiscountRate
	
	public void ClickOnDiscountRatePricingPlan() {

		DiscountRatePricingPlan.click();

	}
	

	public void SelectOnPOSPricingPlan() {

		POSPricingPlan.click();

	}
	
	public void SelectOnAEPSPricingPlan() {

		AEPSPricingPlan.click();

	}
	
	public void SelectOnUPIPricingPlan() {

		UPIPricingPlan.click();

	}
	
	
	

//SettlementInfo

	public void SettlementModeLabel() {
		try {
			assertTrue("Settlement Mode Label Name should be displayed", SettlementModeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Mode Label Name Should be displayed but not found.");
		}
	}

	public void PaymentFlagLabel() {
		try {
			assertTrue("Payment Flag Label Name should be displayed", PaymentFlagLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Payment Flag Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnSettlementMode() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(SettlementMode));
	    
	    SettlementMode.click();
	}

	
	public void ClickOnPaymentFlag() {

		PaymentFlag.click();

	}

	public void SelectOnSettlementMode() {

		SelectOnSettlementMode.click();

	}

	public void SelectOnPaymentFlag() {

		SelectOnPaymenrFlag.click();

	}

//WhiteLabel

	public void AllowtocreateMerchantLabel() {
		try {
			assertTrue("Allow to create Merchant Label Name should be displayed",
					AllowtocreateMerchantLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Allow to create Merchant Label Name Should be displayed but not found.");
		}
	}

	public void UserNameAsLabel() {
		try {
			assertTrue("UserName As Label Name should be displayed", UserNameAsLabl.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("UserName As Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnAllowCreateMerchantOnboard() {

		CreateMerchantUser.click();

	}

	public void ClickOnUserNameAs() {

		UserNameAs.click();

	}

	public void SelectOnUserNameAs() {

		SelectonUserNameAs.click();

	}
	
	
	
//MakeTakeOver
	
	public void ClickOnManualTakeOver() {
		
		ManualTakeOver.click();
		
		
	}
	
       public void ClickOnViewDocument1() {
		
	   ViewDocument1.click();
	   
       }
	   
	   public void ClickOnViewDocument2() {
			
		   ViewDocument2.click();

		
		
	}
	   
	   public void ClickOnViewDocument3() {
			
		   ViewDocument3.click();


	   }
	   
	   public void ClickonActionDiscountRate() {
			
		   Actions.click();


	   }
	   
	   public void ViewDocumentVerified() {
			
		   ViewDocumentVerified.click();


	   }
	   
	   public void ViewDocumentSubmitandNext() {
			
		   ViewDocumentSubmitandNext.click();


	   }

	   
	   
	
	

}
