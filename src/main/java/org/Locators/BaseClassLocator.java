package org.Locators;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.Testcases.CustomWebDriverManager;
import org.junit.Assert;
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

public class BaseClassLocator {

	WebDriver driver;

	public int waitTime;

	WebDriverWait wait;

//LoginLocators	

	@FindBy(xpath = "//h1[contains(text(), 'Sign In')]")
	public WebElement LoginpageDisplayed;

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	public WebElement EnterOnUserName;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	public WebElement EnterOnPassword;

	@FindBy(xpath = "//input[@formcontrolname='captchaText']")
	public WebElement EnterOnCaptcha;

	@FindBy(xpath = "//mat-label[@for='username']")
	public WebElement LabelUsername;

	@FindBy(xpath = "//mat-label[@for='password']")
	public WebElement LabelPassword;

	@FindBy(xpath = "//span[contains(text(), 'Sign In')]")
	public WebElement ClickOnLogin;

	@FindBy(xpath = "//mat-error[contains(text(), 'This field is required')]")
	public WebElement fieldisrequired;

	@FindBy(xpath = "//span[contains(text(), 'Invalid Username or Password')]")
	public WebElement Invaliduserorpass;

	@FindBy(xpath = "//span[contains(text(), 'Invalid Captcha')]")
	public WebElement InvalidCaptcha;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElement ClickonEyeicon;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[2]/div[1]/div[2]/form[1]/div[1]/div[3]/span[1]/*[1]")
	public WebElement Displayedoncaptcha;

	@FindBy(xpath = "//mat-label[contains(text(), 'Enter Captcha')]")
	public WebElement CaptchaLabelName;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[2]/div[1]/div[2]/form[1]/div[1]/div[3]/button[1]/span[1]/img[1]")
	public WebElement CaptchaRefresh;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[1]/div[1]/div[1]/div[3]/div[1]/p-carousel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-skeleton-loader[1]/img[1]")
	public WebElement Image;

	@FindBy(xpath = "//span[contains(text(), 'Forgot?')]")
	public WebElement Forgot;

	@FindBy(xpath = "//span[contains(text(), 'Verify OTP & Set Password')]")
	public WebElement Forgoterrormessage;

	@FindBy(xpath = "//a[contains(text(), 'Contact Support')]")
	public WebElement ClickOnContactSupport;

	@FindBy(xpath = "//span[contains(text(), 'Email')]")
	public WebElement ContactSupportVerify;

	@FindBy(xpath = "//a[contains(text(), 'Terms of Use')]")
	public WebElement ClickOnTermOfUse;

	@FindBy(xpath = "//h2[contains(text(), 'Terms and Conditions')]")
	public WebElement TermofuseVerify;

	@FindBy(xpath = "//a[contains(text(), 'Privacy Policy')]")
	public WebElement Clickonprivacy;

	@FindBy(xpath = "//h2[contains(text(), 'Introduction')]")
	public WebElement PrivacypolicyVerify;

//Bank Locators

	@FindBy(xpath = "//mat-error[contains(text(),'Daily Limit Required')]")
	public WebElement DailyLimitrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Weekly Limit Required')]")
	public WebElement WeeklyLimitrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Monthly Limit Required')]")
	public WebElement MOnthlyLimitrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Minimum Amount Required')]")
	public WebElement MinimumAmountrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Maximum Amount Required')]")
	public WebElement MAximumAmountrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Invalid format') or contains(text(),'Invalid Format')]")
	public WebElement InvalidFormat;

	@FindBy(xpath = "//mat-error[contains(text(), 'Mobile Number should be 30 digits')]")
	public WebElement lessthanMobilenumber;

	@FindBy(xpath = "//mat-error[contains(text(), 'Must be greater than Daily Limit')]")
	public WebElement greaterthanDailyLimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Must be greater than Weekly Limit')]")
	public WebElement greaterthanweeklyLimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Daily Limit Must be Less than Weekly Limit')]")
	public WebElement Dailylimitmustbelessthanweeklylimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Weekly Limit Must be Less than Monthly Limit')]")
	public WebElement WeeklylimitmustbelessthanMonthlylimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Daily limit & minimum value not be same')]")
	public WebElement Dailylimitmininumvaluenotthesame;

	@FindBy(xpath = "//mat-error[contains(text(), 'Minimum & Maximum Value not be same')]")
	public WebElement minimumandmaximumvaluenotbesame;

	@FindBy(xpath = "//mat-error[contains(text(), 'mmsonboarding.settlement.minLength')]")
	public WebElement minimumbankaccountLengtherrormessage;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	public WebElement Saveasdraft;

	@FindBy(xpath = "//span[contains(text(), 'SUBMIT FOR VERIFICATION')]")
	public WebElement Submitasverification;

	@FindBy(xpath = "//span[contains(text(), 'Next Step')]")
	public WebElement NextStep;

	@FindBy(xpath = "//h6[contains(text(), 'ADMIN USER Details')]")
	public WebElement AdminUserDetails;

	@FindBy(xpath = "//button[@class='logo ng-tns-c471-3']")
	public WebElement ClickOnDownArrow;

	@FindBy(xpath = "//button[@class='logo ng-tns-c479-3']")
	public WebElement ClickOnDownArrowSuperadmin;

	@FindBy(xpath = "//span[contains(text(), 'Onboarding')]")
	public WebElement ClickOnOnboarding;

	@FindBy(xpath = "//a[@href='/admin/onboard/banks']")
	public WebElement ClickOnBank;

	@FindBy(xpath = "//a[@href='/admin/onboard/aggregators']")
	public WebElement ClickOnPayfac;

	@FindBy(xpath = "//a[@href='/admin/onboard/isos']")
	public WebElement ClickOnISO;

	@FindBy(xpath = "//a[@href='/admin/onboard/sub-isos']")
	public WebElement ClickOnSUBISO;

	@FindBy(xpath = "//a[@href='/admin/onboard/group-merchants']")
	public WebElement ClickOnGM;

	@FindBy(xpath = "//a[@href='/admin/onboard/merchants']")
	public WebElement ClickOnMerchant;

	@FindBy(xpath = "//a[@href='/admin/onboard/terminals']")
	public WebElement ClickOnTerminal;

	@FindBy(xpath = "//span[contains(text(),'CREATE')]")
	public WebElement Createbutton;

	// IntroPage

	@FindBy(xpath = "//h6[contains(text(), 'Channel Configuration')]")
	public WebElement ChannelConfiguration;

	@FindBy(xpath = "//h6[contains(text(), 'Global FRM Parameters')]")
	public WebElement GlobalFRMParameters;

	@FindBy(xpath = "//h6[contains(text(), 'ROUTING ONUS')]")
	public WebElement ONUS;

	@FindBy(xpath = "//h6[contains(text(), 'Interchange Plan')]")
	public WebElement InterchangePlan;

	@FindBy(xpath = "//h6[contains(text(), 'Bank Details')]")
	public WebElement BankDetails;

	@FindBy(xpath = "//h6[contains(text(), 'Bank Onboarding Configuration')]")
	public WebElement BankonboardingConfig;

	@FindBy(xpath = "//h6[contains(text(), 'Payment Bridge')]")
	public WebElement PaymentBridge;

	@FindBy(xpath = "//h6[contains(text(), 'KYC Config') or contains(text(), 'Personal Documents')]")
	public WebElement KycConfig;

	@FindBy(xpath = "//h6[contains(text(), 'Status History')]")
	public WebElement statusHistory;

	// BankSideMenu

	@FindBy(xpath = "//span[contains(text(), 'General Info')]")
	public WebElement GeneralInfo;

	@FindBy(xpath = "//span[contains(text(), 'Communication Info')]")
	public WebElement CommunicationInfo;

	@FindBy(xpath = "//span[contains(text(), 'Channel Config')]")
	public WebElement ChannelConfig;

	@FindBy(xpath = "//span[contains(text(), 'ONUS Routing')]")
	public WebElement ONUSRouting;

	@FindBy(xpath = "//span[contains(text(), 'Global FRM')]")
	public WebElement GlobalFrm;

	@FindBy(xpath = "//span[contains(text(), 'Commercial')]")
	public WebElement Commercial;

	@FindBy(xpath = "//span[contains(text(), 'Settlement Info')]")
	public WebElement SettlementInfo;

	@FindBy(xpath = "//span[contains(text(), 'Whitelabel')]")
	public WebElement whitelabel;

	@FindBy(xpath = "//span[contains(text(), 'Webhooks')]")
	public WebElement webhooks;

	@FindBy(xpath = "//span[contains(text(), 'KYC')]")
	public WebElement Kyc;

	@FindBy(xpath = "//span[contains(text(), 'Status History')]")
	public WebElement StatusHistory;

	@FindBy(xpath = "//span[contains(text(), 'Change Log')]")
	public WebElement Changelog;

	// Bank

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank Name')]")
	public WebElement BankLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Address')]")
	public WebElement AddressLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Pincode')]")
	public WebElement PincodeLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'GST')]")
	public WebElement GSTLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'PAN')]")
	public WebElement PANLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Mars Id')]")
	public WebElement MaridLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Statement Frequency')]")
	public WebElement StatementFrequencyLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Statement Type')]")
	public WebElement StatementTypeLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Domain')]")
	public WebElement DomainLabelName;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	public WebElement BankName;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	public WebElement Address;

	@FindBy(xpath = "//input[@formcontrolname='zipCode']")
	public WebElement Pincode;

	@FindBy(xpath = "//span[contains(text(), '600341')]")
	public WebElement SelectPincode;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	public WebElement City;

	@FindBy(xpath = "//input[@formcontrolname='state']")
	public WebElement State;

	@FindBy(xpath = "//input[@formcontrolname='country']")
	public WebElement Country;

	@FindBy(xpath = "//input[@formcontrolname='currencyCode']")
	public WebElement CurrencyCode;

	@FindBy(xpath = "//input[@formcontrolname='gst']")
	public WebElement GST;

	@FindBy(xpath = "//input[@formcontrolname='pan']")
	public WebElement PAN;

	@FindBy(xpath = "//input[@formcontrolname='marsId']")
	public WebElement Marsid;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementFrequency']")
	public WebElement StatementFrequency;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementType']")
	public WebElement StatementType;

//	@FindBy(xpath = "//mat-chip-list[@formcontrolname='domain']")
	@FindBy(xpath = "//input[@oninput='this.value=this.value.toLowerCase()']")
	public WebElement Domain;

	// Communication Info

	@FindBy(xpath = "//span[contains(text(), 'Communication Info')]")
	public WebElement ClickonCommunicationInfo;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[1]")
	public WebElement ClickonCommADD;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[2]")
	public WebElement ClickonCommSettlementandReconADD;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	public WebElement ClickonCommuName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Name')]")
	public WebElement LabelCommuName;

	@FindBy(xpath = "//input[@formcontrolname='position']")
	public WebElement ClickonCommuPosition;

	@FindBy(xpath = "//mat-label[contains(text(), 'Position')]")
	public WebElement LabelCommuPosition;

	@FindBy(xpath = "//input[@formcontrolname='phone']")
	public WebElement ClickonCommuPhonenumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'Phone Number')]")
	public WebElement LabelCommuPhonenumber;

	@FindBy(xpath = "//input[@formcontrolname='mobile']")
	public WebElement ClickonCommuMobileNumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'Mobile Number')]")
	public WebElement LabelCommuMobileNumber;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement ClickonCommuEmailId;

	@FindBy(xpath = "//mat-label[contains(text(), 'Email Id')]")
	public WebElement LabelCommuEmailId;

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	public WebElement ClickonCommuUserName;

	@FindBy(xpath = "//mat-label[contains(text(), 'User Name')]")
	public WebElement LabelCommuUsername;

	@FindBy(xpath = "//mat-select[@formcontrolname='isAdEnabled']")
	public WebElement ClickOnAdUsers;

	// Channel Config

	@FindBy(xpath = "//span[contains(text(), 'Add')]")
	public WebElement ChannelADD;

	@FindBy(xpath = "//mat-label[contains(text(), 'Channel')]")
	public WebElement ChannelLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Network')]")
	public WebElement NetworkLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Transaction Sets')]")
	public WebElement TransactionSetsLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Routing')]")
	public WebElement RoutingLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	public WebElement ClickOnChannel;

	@FindBy(xpath = "//mat-select[@formcontrolname='network']")
	public WebElement ClickOntNetwork;

	@FindBy(xpath = "//mat-select[@formcontrolname='transaction']")
	public WebElement ClickOntransaction;

	@FindBy(xpath = "//mat-select[@formcontrolname='routing']")
	public WebElement ClickOnRouting;

	// ONUS Routing

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElement ActionOnOnusbutton;

	@FindBy(xpath = "//mat-icon[contains(text(), 'edit')]")
	public WebElement AddBin;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElement ActionOnOnusbutton2;

	@FindBy(xpath = "//input[@formcontrolname='bin']")
	public WebElement ClickOnAddBin;

	@FindBy(xpath = "//span[contains(text(), 'Submit')]")
	public WebElement SubmitOnOnus;

	// Global FRM

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='frmCheck']")
	public WebElement GlobalFRMCheckbox;

	// Label

	@FindBy(xpath = "//mat-label[contains(text(), 'Velocity Check Minutes')]")

	public WebElement VelocityCheckMinuteLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Velocity Check Count')]")

	public WebElement VelocityCheckCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Cash@POS Count')]")

	public WebElement CashPOSCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Micro ATM Count')]")

	public WebElement MicroATMCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'International Card Acceptance')]")

	public WebElement InternationalCardCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Daily')]")

	public WebElement DailyLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Weekly')]")

	public WebElement WeeklyLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Monthly')]")

	public WebElement MonthlyLabel;

	// Click

	@FindBy(xpath = "//input[@formcontrolname='Vcheckminutes']")
	public WebElement VelocityCheckMinute;

	@FindBy(xpath = "//input[@formcontrolname='Vcheckcount']")
	public WebElement VelocityCheckCount;

	@FindBy(xpath = "//input[@formcontrolname='posperdaycount']")
	public WebElement CashPOSCount;

	@FindBy(xpath = "//input[@formcontrolname='Matmcount']")
	public WebElement MicroATMCount;

	@FindBy(xpath = "//mat-select[@formcontrolname='Icardacceptance']")
	public WebElement InternationalCardCount;

	@FindBy(xpath = "//input[@formcontrolname='frmdaily']")
	public WebElement ICADaily;

	@FindBy(xpath = "//input[@formcontrolname='frmweekly']")
	public WebElement ICAWeekly;

	@FindBy(xpath = "//input[@formcontrolname='frmmonthly']")
	public WebElement ICAMonthly;

	// POS
	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[1]")
	public WebElement POSDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[1]")
	public WebElement POSWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[1]")
	public WebElement POSMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[1]")
	public WebElement POSMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[1]")
	public WebElement POSMaximumAmount;

	// UPI

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[2]")
	public WebElement UPIDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[2]")
	public WebElement UPIWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[2]")
	public WebElement UPIMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[2]")
	public WebElement UPIMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[2]")
	public WebElement UPIMaximumAmount;

	// AEPS

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[3]")
	public WebElement AEPSDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[3]")
	public WebElement AEPSWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[3]")
	public WebElement AEPSMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[3]")
	public WebElement AEPSMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[3]")
	public WebElement AEPSMaximumAmount;

	// MATM

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[4]")
	public WebElement MATMDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[4]")
	public WebElement MATMWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[4]")
	public WebElement MATMMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[4]")
	public WebElement MATMMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[4]")
	public WebElement MATMMaximumAmount;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[1]")

	public WebElement CommercialADD1;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[2]")

	public WebElement CommercialADD2;

	@FindBy(xpath = "//mat-label[contains(text(), 'Channel')]")
	public WebElement CommercialChannelLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	public WebElement CommercialChannel;

	@FindBy(xpath = "//input[@formcontrolname='interchangePlan']")
	public WebElement PricingplanInterchange;

	@FindBy(xpath = "//input[@formcontrolname='pricingPlanDescription']")
	public WebElement PricingplanBankOnboarding;

	@FindBy(xpath = "//mat-label[contains(text(), 'Pricing Plan')]")
	public WebElement Pricingplanlabel;

	@FindBy(xpath = "//span[contains(text(), 'Save')]")
	public WebElement SaveButton;

	// Settleinfo

	@FindBy(xpath = "//mat-label[contains(text(), 'Channel')]")

	public WebElement SettlementChannelLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	public WebElement SettlementChannel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Account Type')]")

	public WebElement SettlementAccountTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='accountType']")
	public WebElement SettlementAccountType;

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank A/C Number')]")

	public WebElement SettlementBackAccountLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankAccountNumber']")
	public WebElement SettlementBankAccountNumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'IFSC Code')]")

	public WebElement SettlementIFSCCodeLabel;

	@FindBy(xpath = "//input[@formcontrolname='ifsc']")
	public WebElement SettlementIFSCCode;

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank Name')]")

	public WebElement SettlementBankNameLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	public WebElement SettlementBankName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Branch')]")

	public WebElement SettlementBranchLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankBranch']")
	public WebElement SettlementBranch;

	@FindBy(xpath = "//mat-label[contains(text(), 'City')]")

	public WebElement SettlementCityLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankCity']")
	public WebElement SettlementCity;

	@FindBy(xpath = "//mat-label[contains(text(), 'Settlement Type')]")

	public WebElement SettlementTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementType']")
	public WebElement SettlementType;

	// WhiteLabel

	// Label

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank Own Deployment')]")

	public WebElement WhiteLabelBankOwnDeployemntLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'PayFac Onboarding')]")

	public WebElement WhitelabelPayfacOnboardingLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'ISO Onboarding')]")

	public WebElement WhitelabelISOOnboardingLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Sales Team Onboarding')]")

	public WebElement WhitelabelSalesTeamOnboardingLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Max Number of Platform Users')]")

	public WebElement WhitelabelMaximumNumberOfPlatformLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='bankOwnDeployement']")
	public WebElement WhitelabelBankOwnDeployment;

	@FindBy(xpath = "//mat-select[@formcontrolname='payfacOnBoarding']")
	public WebElement WhitelabelPayfacOnboarding;

	@FindBy(xpath = "//mat-select[@formcontrolname='isoOnBoarding']")
	public WebElement WhitelabelISOOnboarding;

	@FindBy(xpath = "//mat-select[@formcontrolname='directSaleOnBoarding']")
	public WebElement WhitelabelSalesTeamOnboarding;

	@FindBy(xpath = "//input[@formcontrolname='maxPlatformUser']")
	public WebElement WhitelabelMaxNumberOfPlatform;

	@FindBy(xpath = "//div[contains(@class, 'mat-select-panel') and @role='listbox']//mat-option//span[contains(text(), 'Yes')]")
	public WebElement WhitelabelYES;

	@FindBy(xpath = "//div[contains(@class, 'mat-select-panel') and @role='listbox']//mat-option//span[contains(text(), 'No')]")
	public WebElement WhitelabelNO;

	// Webhook

	// Label

	@FindBy(xpath = "//mat-label[contains(text(), 'Webhook Type')]")

	public WebElement WebhookTypeLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Webhook Url')]")

	public WebElement WebhookURLLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='type']")
	public WebElement WebhookType;

	@FindBy(xpath = "//input[@formcontrolname='url']")
	public WebElement WebhookTypeURL;

	// KYC

	@FindBy(xpath = "//span[contains(text(), 'Add')]")

	public WebElement AddButton;

	@FindBy(xpath = "//mat-select[@formcontrolname='businessType']")
	public WebElement KYCBusinessType;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualPoi']")
	public WebElement proofofIdentityComapany;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinPoi']")
	public WebElement KYCNumberofDocinPoiCompany1;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualPoa']")
	public WebElement proofofaddress;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinPoa']")
	public WebElement KYCNumberofDocinPoaCompany2;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualBankDoc']")
	public WebElement KYCBankDoc;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinBank']")
	public WebElement KYCNumberofDocinBankCompany3;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualTaxDoc']")
	public WebElement KYCTaxDoc;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinTax']")
	public WebElement KYCNumberofDocinTaxCompany4;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonPoi']")
	public WebElement KYCIndividualProofOfIdentity;

	@FindBy(xpath = "//span[contains(text(), 'Aadhaar')]")

	public WebElement Aadhaar;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinPoi']")
	public WebElement KycNumberOfDocinPOiIndividual1;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonPoa']")
	public WebElement KYCIndividualProofOFAddress;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinPoa']")
	public WebElement KycNumberOfDocinPoaIndividual2;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonotherDoc']")
	public WebElement KYCIndividualOtherDocument;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonTaxDoc']")
	public WebElement KYCIndividualTaxDocument;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonBankDoc']")
	public WebElement KYCIndividualBankDocument;

	@FindBy(xpath = "//input[@formcontrolname='keyPersonNumberofOtherDoc']")
	public WebElement keyPersonNumberofOtherDocIndividual3;

	// Submit

	@FindBy(xpath = "//span[contains(text(), 'SUBMIT FOR VERIFICATION')]")
	public WebElement SubmitfoeVerification;

	@FindBy(xpath = "//span[contains(text(), 'OK')]")

	public WebElement OKButton;

	// LogOut

	@FindBy(xpath = "//button[@title='profile']")
	public WebElement Profile;

	@FindBy(xpath = "//mat-icon[contains(text(), 'logout')]")

	public WebElement LogOut;

	@FindBy(xpath = "//mat-error[contains(text(),'YES') or contains(text(),'Yes')]")

	public WebElement YesButton;

	@FindBy(xpath = "//mat-error[contains(text(),'NO') or contains(text(),'No')]")

	public WebElement NoButton;

	@FindBy(xpath = "//input[@name='name1']")
	public WebElement SearchbyBankName;

	@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[3]")
	public WebElement ActionClick;

	@FindBy(xpath = "//span[contains(text(),'View')]")
	public WebElement ViewButton;

	@FindBy(xpath = "//span[contains(text(),'Verified & Next')]")
	public WebElement VerifiedandNext;

	@FindBy(xpath = "//span[contains(text(),'SUBMIT FOR APPROVAL')]")
	public WebElement SubmitforApproval;

	@FindBy(xpath = "//span[contains(text(),'Verified')]")
	public WebElement Verified;

	@FindBy(xpath = "//span[contains(text(),'APPROVE')]")
	public WebElement Approve;

	@FindBy(xpath = "//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cancel')]")
	public WebElement ApproveCancel;

	@FindBy(xpath = "//input[@formcontrolname='cpid'] | //input[@formcontrolname='cpId']")
	public WebElement CPID;

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

		try {

			element.clear();

		} catch (ElementClickInterceptedException e) {

			element.clear();

		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}

	
	

}
