package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankLocators {

	WebDriver driver;

    WebDriverWait wait;

	@FindBy(xpath = "//mat-error[text()=' This field is required ']")
	private WebElement fieldisrequired;

	@FindBy(xpath = "//mat-error[text()=' Daily Limit Required ']")
	private WebElement DailyLimitrequired;

	@FindBy(xpath = "//mat-error[text()=' Weekly Limit Required ']")
	private WebElement WeeklyLimitrequired;

	@FindBy(xpath = "//mat-error[text()=' Monthly Limit Required ']")
	private WebElement MOnthlyLimitrequired;

	@FindBy(xpath = "//mat-error[text()=' Minimum Amount Required ']")
	private WebElement MinimumAmountrequired;

	@FindBy(xpath = "//mat-error[text()=' Maximum Amount Required ']")
	private WebElement MAximumAmountrequired;

	@FindBy(xpath = "//mat-error[text()=' Invalid format '] | //mat-error[text()=' Invalid Format ']")
	private WebElement InvalidFormat;

	@FindBy(xpath = "//mat-error[text()=' Mobile Number should be 10 digits ']")
	private WebElement lessthanMobilenumber;

	@FindBy(xpath = "//mat-error[text()=' Must be greater than Daily Limit ']")
	private WebElement greaterthanDailyLimit;

	@FindBy(xpath = "//mat-error[text()=' Must be greater than Weekly Limit ']")
	private WebElement greaterthanweeklyLimit;

	@FindBy(xpath = "//mat-error[text()=' Daily Limit Must be Less than Weekly Limit ']")
	private WebElement Dailylimitmustbelessthanweeklylimit;

	@FindBy(xpath = "//mat-error[text()=' Weekly Limit Must be Less than Monthly Limit ']")
	private WebElement WeeklylimitmustbelessthanMonthlylimit;

	@FindBy(xpath = "//mat-error[text()=' Daily limit & minimum value not be same ']")
	private WebElement Dailylimitmininumvaluenotthesame;

	@FindBy(xpath = "//mat-error[text()=' Minimum & Maximum Value not be same ']")
	private WebElement minimumandmaximumvaluenotbesame;

	@FindBy(xpath = "//mat-error[text()=' mmsonboarding.settlement.minLength ']")
	private WebElement minimumbankaccountLengtherrormessage;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	private WebElement Saveasdraft;

	@FindBy(xpath = "//span[text()=' SUBMIT FOR VERIFICATION ']")
	private WebElement Submitasverification;

	@FindBy(xpath = "//span[text()=' Next Step ']")
	private WebElement NextStep;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement CommSave;

	@FindBy(xpath = "//h6[text()='ADMIN USER Details']")
	private WebElement AdminUserDetails;

	@FindBy(xpath = "//button[@class='logo ng-tns-c471-3']")
	private WebElement ClickOnDownArrow;

	@FindBy(xpath = "//span[text()='Onboarding']")
	private WebElement ClickOnOnboarding;

	@FindBy(xpath = "(//a[@color='accent'])[6]")
	private WebElement ClickOnVerifierOnboarding;

	@FindBy(xpath = "//a[@href='/admin/onboard/banks']")
	private WebElement ClickOnBank;

	@FindBy(xpath = "//span[text()='Aggregators']")
	private WebElement ClickOnPayfac;

	@FindBy(xpath = "//span[text()='ISO']")
	private WebElement ClickOnISO;

	@FindBy(xpath = "//span[text()='Sub ISO']")
	private WebElement ClickOnSUBISO;

	@FindBy(xpath = "//span[text()='Group Merchants']")
	private WebElement ClickOnGM;

	@FindBy(xpath = "//a[@href='/admin/onboard/merchants']")
	private WebElement ClickOnMerchant;

	@FindBy(xpath = "//a[@href='/admin/onboard/terminals']")
	private WebElement ClickOnTerminal;

	@FindBy(xpath = "//span[text()='CREATE']")
	private WebElement Createbutton;
	
//IntroPage
	
	@FindBy(xpath = "//h6[text()='Channel Configuration']")
	private WebElement ChannelConfiguration;
	
	@FindBy(xpath = "//h6[text()='Global FRM Parameters']")
	private WebElement GlobalFRMParameters;
	
	@FindBy(xpath = "//h6[text()='ROUTING ONUS']")
	private WebElement ONUS;
	
	@FindBy(xpath = "//h6[text()='Interchange Plan']")
	private WebElement InterchangePlan;
	
	@FindBy(xpath = "//h6[text()='Bank Details']")
	private WebElement BankDetails;
	
	@FindBy(xpath = "//h6[text()='Bank Onboarding Configuration']")
	private WebElement BankonboardingConfig;
	
	@FindBy(xpath = "//h6[text()='Payment Bridge']")
	private WebElement PaymentBridge;
	
	@FindBy(xpath = "//h6[text()='KYC Config']")
	private WebElement KycConfig;
	
	@FindBy(xpath = "//h6[text()='Status History']")
	private WebElement statusHistory;

	

//BankSideMenu

	@FindBy(xpath = "//span[text()='General Info']")
	private WebElement GeneralInfo;

	@FindBy(xpath = "//span[text()='Communication Info']")
	private WebElement CommunicationInfo;

	@FindBy(xpath = "//span[text()='Channel Config']")
	private WebElement ChannelConfig;

	@FindBy(xpath = "//span[text()='Global FRM']")
	private WebElement GlobalFrm;

	@FindBy(xpath = "//span[text()='Commercial']")
	private WebElement Commercial;

	@FindBy(xpath = "//span[text()='Settlement Info']")
	private WebElement SettlementInfo;

	@FindBy(xpath = "//span[text()='Whitelabel']")
	private WebElement whitelabel;

	@FindBy(xpath = "//span[text()='Webhooks']")
	private WebElement webhooks;

	@FindBy(xpath = "//span[text()='KYC']")
	private WebElement Kyc;

	@FindBy(xpath = "//span[text()='Status History']")
	private WebElement StatusHistory;

	@FindBy(xpath = "//span[text()='Change Log']")
	private WebElement Changelog;
	
	
//Bank	
	

	@FindBy(xpath = "//mat-label[text()='Bank Name']")
	private WebElement BankLabelName;

	@FindBy(xpath = "//mat-label[text()='Address']")
	private WebElement AddressLabelName;

	@FindBy(xpath = "//mat-label[text()='Pincode']")
	private WebElement PincodeLabelName;

	@FindBy(xpath = "//mat-label[text()='GST']")
	private WebElement GSTLabelName;

	@FindBy(xpath = "//mat-label[text()='PAN']")
	private WebElement PANLabelName;

	@FindBy(xpath = "//mat-label[text()='Mars Id']")
	private WebElement MaridLabelName;

	@FindBy(xpath = "//mat-label[text()='Statement Frequency ']")
	private WebElement StatementFrequencyLabelName;

	@FindBy(xpath = "//mat-label[text()='Statement Type ']")
	private WebElement StatementTypeLabelName;

	@FindBy(xpath = "//mat-label[text()='Domain']")
	private WebElement DomainLabelName;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	private WebElement BankName;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	private WebElement Address;

	@FindBy(xpath = "//input[@formcontrolname='zipCode']")
	private WebElement Pincode;

	@FindBy(xpath = "//span[contains(text(), '600341')]")
	private WebElement SelectPincode;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	private WebElement City;

	@FindBy(xpath = "//input[@formcontrolname='state']")
	private WebElement State;

	@FindBy(xpath = "//input[@formcontrolname='country']")
	private WebElement Country;

	@FindBy(xpath = "//input[@formcontrolname='currencyCode']")
	private WebElement CurrencyCode;

	@FindBy(xpath = "//input[@formcontrolname='gst']")
	private WebElement GST;

	@FindBy(xpath = "//input[@formcontrolname='pan']")
	private WebElement PAN;

	@FindBy(xpath = "//input[@formcontrolname='marsId']")
	private WebElement Marsid;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementFrequency']")
	private WebElement StatementFrequency;

	@FindBy(xpath = "//span[text()=' Daily ']")
	private WebElement SelectStatementFrequency;

	@FindBy(xpath = "//span[text()='Daily']")
	private WebElement SelectStatementFrequencyCheck;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementType']")
	private WebElement StatementType;

	@FindBy(xpath = "//span[text()=' Pdf ']")
	private WebElement SelectStatementType;

	@FindBy(xpath = "//span[text()='Pdf']")
	private WebElement SelectStatementTypeCheck;

//	@FindBy(xpath = "//mat-chip-list[@formcontrolname='domain']")
	@FindBy(xpath = "//input[@oninput='this.value=this.value.toLowerCase()']")
	private WebElement Domain;

//Communication Info

	@FindBy(xpath = "//span[text()='Communication Info']")
	private WebElement ClickonCommunicationInfo;

	@FindBy(xpath = "(//span[text()='Add'])[1]")
	private WebElement ClickonCommADD;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	private WebElement ClickonCommuName;

	@FindBy(xpath = "//mat-label[text()='Name']")
	private WebElement LabelCommuName;

	@FindBy(xpath = "//input[@formcontrolname='position']")
	private WebElement ClickonCommuPosition;

	@FindBy(xpath = "//mat-label[text()='Position ']")
	private WebElement LabelCommuPosition;

	@FindBy(xpath = "//input[@formcontrolname='phone']")
	private WebElement ClickonCommuPhonenumber;

	@FindBy(xpath = "//mat-label[text()='Phone Number ']")
	private WebElement LabelCommuPhonenumber;

	@FindBy(xpath = "//input[@formcontrolname='mobile']")
	private WebElement ClickonCommuMobileNumber;

	@FindBy(xpath = "//mat-label[text()='Mobile Number ']")
	private WebElement LabelCommuMobileNumber;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	private WebElement ClickonCommuEmailId;

	@FindBy(xpath = "//mat-label[text()='Email Id ']")
	private WebElement LabelCommuEmailId;

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	private WebElement ClickonCommuUserName;

	@FindBy(xpath = "//mat-label[text()='User Name ']")
	private WebElement LabelCommuUsername;

	@FindBy(xpath = "//mat-label[text()='User Name ']")
	private WebElement LabelCommuADUser;

	@FindBy(xpath = "//mat-select[@formcontrolname='isAdEnabled']")
	private WebElement ClickOnAdUsers;

	@FindBy(xpath = "//span[text()=' YES ']")
	private WebElement SelectOnAdUserYes;

	@FindBy(xpath = "//span[text()=' NO ']")
	private WebElement SelectOnAdUserNO;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement Save;

//Channel Config	

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement ChannelADD;

	@FindBy(xpath = "//mat-label[text()='Channel']")
	private WebElement ChannelLabel;

	@FindBy(xpath = "//mat-label[text()='Network ']")
	private WebElement NetworkLabel;

	@FindBy(xpath = "//mat-label[text()='Transaction Sets ']")
	private WebElement TransactionSetsLabel;

	@FindBy(xpath = "//mat-label[text()='Routing ']")
	private WebElement RoutingLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	private WebElement ClickOnChannel;

	@FindBy(xpath = "//mat-option//span[text()='POS']")
	private WebElement SelectPOSChannel;

	@FindBy(xpath = "//mat-option//span[text()='UPI']")
	private WebElement SelectUPIChannel;

	@FindBy(xpath = "//mat-option//span[text()='AEPS']")
	private WebElement SelectAEPSChannel;
	
	@FindBy(xpath = "//mat-option//span[text()='MATM']")
	private WebElement SelectMATMChannel;
	

	@FindBy(xpath = "//mat-select[@formcontrolname='network']")
	private WebElement ClickOntNetwork;

	@FindBy(xpath = "//span[text()=' VISA ']")
	private WebElement SelectOnNetworkPOS;
	
	@FindBy(xpath = "//span[text()=' MasterCard ']")
	private WebElement SelectOnNetworkMATM;

	@FindBy(xpath = "//span[text()=' Sales ']")
	private WebElement SelectOntransactionsetUPI;

	@FindBy(xpath = "//span[text()=' Withdrawal ']")
	private WebElement SelectOnTransactionsetAEPS;

	@FindBy(xpath = "//mat-select[@formcontrolname='transaction']")
	private WebElement ClickOntransaction;

	@FindBy(xpath = "//span[text()=' Sales ']")
	private WebElement SelectOnTransactionPOS;
	
	@FindBy(xpath = "//span[text()=' Withdrawal ']")
	private WebElement SelectOnTransactionsetMATM;

	@FindBy(xpath = "//mat-select[@formcontrolname='routing']")
	private WebElement ClickOnRouting;

	@FindBy(xpath = "//span[text()=' ONUS ']")
	private WebElement SelectonRouting;

//ONUS Routing

	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement ActionOnOnusbutton;

	@FindBy(xpath = "//mat-icon[text()='edit']")
	private WebElement AddBin;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement ActionOnOnusbutton2;

	

	@FindBy(xpath = "//input[@formcontrolname='bin']")
	private WebElement ClickOnAddBin;

	@FindBy(xpath = "//span[text()=' 678778 ']")
	private WebElement SelectAddBin;

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement SubmitOnOnus;

//Global FRM

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='frmCheck']")
	private WebElement GlobalFRMCheckbox;

//Label	
	@FindBy(xpath = "//mat-label[text()='Velocity Check Minutes ']")
	private WebElement VelocityCheckMinuteLabel;

	@FindBy(xpath = "//mat-label[text()=' Velocity Check Count ']")
	private WebElement VelocityCheckCountLabel;

	@FindBy(xpath = "//mat-label[text()=' Cash@POS Count ']")
	private WebElement CashPOSCountLabel;

	@FindBy(xpath = "//mat-label[text()='Micro ATM Count ']")
	private WebElement MicroATMCountLabel;

	@FindBy(xpath = "//mat-label[text()='International Card Acceptance ']")
	private WebElement InternationalCardCountLabel;

	@FindBy(xpath = "//mat-label[text()='Daily ']")
	private WebElement DailyLabel;

	@FindBy(xpath = "//mat-label[text()=' Weekly']")
	private WebElement WeeklyLabel;

	@FindBy(xpath = "//mat-label[text()=' Monthly ']")
	private WebElement MonthlyLabel;

//Click

	@FindBy(xpath = "//input[@formcontrolname='Vcheckminutes']")
	private WebElement VelocityCheckMinute;

	@FindBy(xpath = "//input[@formcontrolname='Vcheckcount']")
	private WebElement VelocityCheckCount;

	@FindBy(xpath = "//input[@formcontrolname='posperdaycount']")
	private WebElement CashPOSCount;

	@FindBy(xpath = "//input[@formcontrolname='Matmcount']")
	private WebElement MicroATMCount;

	@FindBy(xpath = "//mat-select[@formcontrolname='Icardacceptance']")
	private WebElement InternationalCardCount;

	@FindBy(xpath = "//span[text()='Yes ']")
	private WebElement YesInternationalCardCount;

	@FindBy(xpath = "//span[text()='No ']")
	private WebElement NOInternationalCardCount;

	@FindBy(xpath = "//input[@formcontrolname='frmdaily']")
	private WebElement ICADaily;

	@FindBy(xpath = "//input[@formcontrolname='frmweekly']")
	private WebElement ICAWeekly;

	@FindBy(xpath = "//input[@formcontrolname='frmmonthly']")
	private WebElement ICAMonthly;

//POS	
	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[1]")
	private WebElement POSDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[1]")
	private WebElement POSWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[1]")
	private WebElement POSMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[1]")
	private WebElement POSMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[1]")
	private WebElement POSMaximumAmount;


	// UPI

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[2]")
	private WebElement UPIDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[2]")
	private WebElement UPIWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[2]")
	private WebElement UPIMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[2]")
	private WebElement UPIMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[2]")
	private WebElement UPIMaximumAmount;
	
	
	//AEPS

		@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[3]")
		private WebElement AEPSDaily;

		@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[3]")
		private WebElement AEPSWeekly;

		@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[3]")
		private WebElement AEPSMonthly;

		@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[3]")
		private WebElement AEPSMinimumAmount;

		@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[3]")
		private WebElement AEPSMaximumAmount;

	
//MATM
	
	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[4]")
	private WebElement MATMDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[4]")
	private WebElement MATMWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[4]")
	private WebElement MATMMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[4]")
	private WebElement MATMMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[4]")
	private WebElement MATMMaximumAmount;

//Commercial
	@FindBy(xpath = "(//span[text()='Add'])[1]")
	private WebElement CommercialADD1;

	@FindBy(xpath = "(//span[text()='Add'])[2]")
	private WebElement CommercialADD2;

	@FindBy(xpath = "//mat-label[text()='Channel']")
	private WebElement CommercialChannelLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	private WebElement CommercialChannel;

	@FindBy(xpath = "//span[text()='POS ']")
	private WebElement CommericaialChannelPOS;

	@FindBy(xpath = "//span[text()='AEPS ']")
	private WebElement CommericaialChannelAEPS;
	
	@FindBy(xpath = "//span[text()='UPI ']")
	private WebElement CommericaialChannelUPI;

	@FindBy(xpath = "//input[@formcontrolname='interchangePlan']")
	private WebElement PricingplanInterchange;

	@FindBy(xpath = "//input[@formcontrolname='pricingPlanDescription']")
	private WebElement PricingplanBankOnboarding;

	@FindBy(xpath = "//mat-label[text()='Pricing Plan ']")
	private WebElement PricingplanlabelInterchange;

	@FindBy(xpath = "//mat-label[text()='Pricing Plan']")
	private WebElement PricingplanlabelBankonboarding;

	@FindBy(xpath = "//span[text()=' POS Interchange Bank Plan Small Merchants Emerging(Grocery-5411)']")
	private WebElement SelectOnPricingBankPOSTestPlan;
	
	@FindBy(xpath = "//span[text()=' Bank AEPS Interchange Plan']")
	private WebElement SelectOnPricingBankAEPSTestPlan;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement CommercialSave;

	@FindBy(xpath = "//span[text()=' Bank POS Discount Rate Plan ']")
	private WebElement SelectOnBankOnboardingPricingBankPOSPlan;
	
	@FindBy(xpath = "//span[text()=' Bank AEPS Discount Rate Plan ']")
	private WebElement SelectOnBankOnboardingPricingBankAEPSPlan;
	
	@FindBy(xpath = "//span[text()=' Bank UPI Discount Rate Plan ']")
	private WebElement SelectOnBankOnboardingPricingBankUPIPlan;
	
	

//Settleinfo

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement SettlementInfoADD;

	@FindBy(xpath = "//mat-label[text()='Channel']")
	private WebElement SettlementChannelLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	private WebElement SettlementChannel;

	@FindBy(xpath = "//span[text()='POS ']")
	private WebElement SettlementChannelPOS;

	@FindBy(xpath = "//span[text()='UPI ']")
	private WebElement SettlementChannelUPI;

	@FindBy(xpath = "//span[text()='AEPS ']")
	private WebElement SettlementChannelAEPS;

	@FindBy(xpath = "//mat-label[text()='Account Type']")
	private WebElement SettlementAccountTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='accountType']")
	private WebElement SettlementAccountType;

	@FindBy(xpath = "//span[text()='Savings']")
	private WebElement SettlementAccountTypeSavings;

	@FindBy(xpath = "//span[text()='Current']")
	private WebElement SettlementAccountTypeCurrent;

	@FindBy(xpath = "//span[text()='Salary']")
	private WebElement SettlementAccountTypeSalary;

	@FindBy(xpath = "//span[text()='Business']")
	private WebElement SettlemenAccounttypeBusiness;

	@FindBy(xpath = "//mat-label[text()='Bank A/C Number ']")
	private WebElement SettlementBackAccountLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankAccountNumber']")
	private WebElement SettlementBankAccountNumber;

	@FindBy(xpath = "//mat-label[text()='IFSC Code']")
	private WebElement SettlementIFSCCodeLabel;

	@FindBy(xpath = "//input[@formcontrolname='ifsc']")
	private WebElement SettlementIFSCCode;

	@FindBy(xpath = "//span[text()=' BHGY0323434']")
	private WebElement SettlementIFSCCodeBHG;

	@FindBy(xpath = "//span[text()=' INDB0002285']")
	private WebElement SettlementIFSCCodeIND;

	@FindBy(xpath = "//span[text()=' ICICI000602']")
	private WebElement SettlementIFSCCodeICICI;

	@FindBy(xpath = "//mat-label[text()='Bank Name']")
	private WebElement SettlementBankNameLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	private WebElement SettlementBankName;

	@FindBy(xpath = "//mat-label[text()='Branch']")
	private WebElement SettlementBranchLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankBranch']")
	private WebElement SettlementBranch;

	@FindBy(xpath = "//mat-label[text()='City']")
	private WebElement SettlementCityLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankCity']")
	private WebElement SettlementCity;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement SettlementSave;

	@FindBy(xpath = "//mat-label[text()='Settlement Type ']")
	private WebElement SettlementTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementType']")
	private WebElement SettlementType;

	@FindBy(xpath = "//span[text()='Manual ']")
	private WebElement SettlementTypeManual;

	@FindBy(xpath = "//span[text()='Both ']")
	private WebElement SettlementTypeBoth;

	@FindBy(xpath = "//span[text()='Wallet ']")
	private WebElement SettlementTypeWallet;

	// WhiteLabel

	// Label

	@FindBy(xpath = "//mat-label[text()='Bank Own Deployment ']")
	private WebElement WhiteLabelBankOwnDeployemntLabel;

	@FindBy(xpath = "//mat-label[text()='PayFac Onboarding ']")
	private WebElement WhitelabelPayfacOnboardingLabel;

	@FindBy(xpath = "//mat-label[text()='ISO Onboarding ']")
	private WebElement WhitelabelISOOnboardingLabel;

	@FindBy(xpath = "//mat-label[text()='Sales Team Onboarding ']")
	private WebElement WhitelabelSalesTeamOnboardingLabel;

	@FindBy(xpath = "//mat-label[text()='Max Number of Platform Users']")
	private WebElement WhitelabelMaximumNumberOfPlatformLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='bankOwnDeployement']")
	private WebElement WhitelabelBankOwnDeployment;

	@FindBy(xpath = "//mat-select[@formcontrolname='payfacOnBoarding']")
	private WebElement WhitelabelPayfacOnboarding;

	@FindBy(xpath = "//mat-select[@formcontrolname='isoOnBoarding']")
	private WebElement WhitelabelISOOnboarding;

	@FindBy(xpath = "//mat-select[@formcontrolname='directSaleOnBoarding']")
	private WebElement WhitelabelSalesTeamOnboarding;

	@FindBy(xpath = "//input[@formcontrolname='maxPlatformUser']")
	private WebElement WhitelabelMaxNumberOfPlatform;

	@FindBy(xpath = "//div[contains(@class, 'mat-select-panel') and @role='listbox']//mat-option//span[contains(text(), 'Yes')]")
	private WebElement WhitelabelYES;

	@FindBy(xpath = "//div[contains(@class, 'mat-select-panel') and @role='listbox']//mat-option//span[contains(text(), 'No')]")
	private WebElement WhitelabelNO;

//Webhook

	// Label

	@FindBy(xpath = "//mat-label[text()='Webhook Type']")
	private WebElement WebhookTypeLabel;

	@FindBy(xpath = "//mat-label[text()='Webhook Url']")
	private WebElement WebhookURLLabel;

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement WebhookADD;

	@FindBy(xpath = "//mat-select[@formcontrolname='type']")
	private WebElement WebhookType;

	@FindBy(xpath = "//span[text()='SMS ']")
	private WebElement WebhookTypeSMS;

	@FindBy(xpath = "//input[@formcontrolname='url']")
	private WebElement WebhookTypeURL;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement WebhookSave;

//KYC

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement KYCADD;

	@FindBy(xpath = "//mat-select[@formcontrolname='businessType']")
	private WebElement KYCBusinessType;

	@FindBy(xpath = "//span[text()='Trust ']")
	private WebElement KYCBusinessTypeTrust;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualPoi']")
	private WebElement proofofIdentityComapany;

	@FindBy(xpath = "//span[text()='Company PAN ']")
	private WebElement KYCSelectproofofIdentityCompany;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinPoi']")
	private WebElement KYCNumberofDocinPoiCompany1;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualPoa']")
	private WebElement proofofaddress;

	@FindBy(xpath = "//span[text()='Aadhaar ']")
	private WebElement KYCSelectOnProofAddress;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinPoa']")
	private WebElement KYCNumberofDocinPoaCompany2;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualBankDoc']")
	private WebElement KYCBankDoc;

	@FindBy(xpath = "//span[text()='Bank ']")
	private WebElement KYCSelectBankDoc;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinBank']")
	private WebElement KYCNumberofDocinBankCompany3;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualTaxDoc']")
	private WebElement KYCTaxDoc;

	@FindBy(xpath = "//span[text()='GST Registration Certificate ']")
	private WebElement KYCSelectTaxDoc;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinTax']")
	private WebElement KYCNumberofDocinTaxCompany4;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonPoi']")
	private WebElement KYCIndividualProofOfIdentity;

	@FindBy(xpath = "//span[text()='Aadhaar ']")
	private WebElement KYCIndividualSelectONProofOfIdentity;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinPoi']")
	private WebElement KycNumberOfDocinPOiIndividual1;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonPoa']")
	private WebElement KYCIndividualProofOFAddress;

	@FindBy(xpath = "//span[text()='Driving Licence ']")
	private WebElement KYCIndividualSelectONProofOFAddress;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinPoa']")
	private WebElement KycNumberOfDocinPoaIndividual2;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"keyPersonotherDoc\"]")
	private WebElement KYCIndividualOtherDocument;

	@FindBy(xpath = "//span[text()='Alternate Document ']")
	private WebElement KYCIndividualSelectOnOtherDocument;

	@FindBy(xpath = "//input[@formcontrolname='keyPersonNumberofOtherDoc']")
	private WebElement keyPersonNumberofOtherDocIndividual3;

//Submit    

	@FindBy(xpath = "//span[text()=' SUBMIT FOR VERIFICATION ']")
	private WebElement SubmitfoeVerification;

	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement YesForSubmit;

	@FindBy(xpath = "//span[text()='OK']")
	private WebElement OKForSuccessfully;

	// LogOut

	@FindBy(xpath = "//button[@title='profile']")
	private WebElement Profile;

	@FindBy(xpath = "//mat-icon[text()='logout']")
	private WebElement LogOut;

	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement LogOutYES;

	@FindBy(xpath = "//input[@name='name1']")
	private WebElement SearchbyBankName;

	@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[3]")
	private WebElement ActionClick;
	
	
	
	@FindBy(xpath = "//span[text()='View']")
	private WebElement ViewButton;

	@FindBy(xpath = "//span[text()=' Verified & Next']")
	private WebElement VerifiedandNext;

	@FindBy(xpath = "//span[text()=' SUBMIT FOR APPROVAL ']")
	private WebElement SubmitforApproval;

	@FindBy(xpath = "//span[text()=' Verified']")
	private WebElement Verified;

	@FindBy(xpath = "//span[text()=' APPROVE ']")
	private WebElement Approve;

	@FindBy(xpath = "//span[text()=' CANCEL ']")
	private WebElement ApproveCancel;

	@FindBy(xpath = "//input[@formcontrolname='cpId']")
	private WebElement CPID;

	public BankLocators(WebDriver driver) {

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	public void selectDropdownOption(String optionText) {
	    String xpathExpression = "//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	                              + optionText.toLowerCase() + "')]";
	    driver.findElement(By.xpath(xpathExpression)).click();
	}

	

	public void DisplayedOnVerified() {
		try {
			assertTrue("Verified Button should be displayed", Verified.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Verified Button Should be displayed But not found.");
		}
	}

	public void ClickOnApprove() {
		// Approve.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Approve));

			// Perform the click action
			Approve.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Approve));
			Approve.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnSaveasdraft() {
//		Saveasdraft.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Saveasdraft));

			// Perform the click action
			Saveasdraft.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Saveasdraft));
			Saveasdraft.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnsubmitforverification() {
//		Submitasverification.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Submitasverification));

			// Perform the click action
			Submitasverification.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Submitasverification));
			Submitasverification.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

//	public void ClickOnNextStep() {
//		NextStep.click();
//
//	}

	public void ClickOnNextStep() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(NextStep));

			// Perform the click action
			NextStep.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(NextStep));
			NextStep.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void CancelApprove() {
//		ApproveCancel.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ApproveCancel));

			// Perform the click action
			ApproveCancel.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ApproveCancel));
			ApproveCancel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
//IntroPage	

	public void DisplayedOnAdminuserdetails() {
		try {
			assertTrue("Communication Info Page should be displayed", AdminUserDetails.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication Info Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnChannelConfiguration() {
		try {
			assertTrue("Channel Config Page should be displayed", ChannelConfiguration.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Channel Config Page Should be displayed But not found.");
		}
	}
	public void DisplayedOnGlobalFRMParameters() {
		try {
			assertTrue("Global FRM Page should be displayed", GlobalFRMParameters.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Global FRM Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnRoutingONUS() {
		try {
			assertTrue("Routing ONUS Page should be displayed", ONUS.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Routing ONUS Page Should be displayed But not found.");
		}
	}
	
	
	public void DisplayedOnInterchangePlan() {
		try {
			assertTrue("Commercial Page should be displayed", InterchangePlan.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Commercial Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnBankDetails() {
		try {
			assertTrue("Settlement Info Page should be displayed", BankDetails.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Info Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnBankonboardingConfig() {
		try {
			assertTrue("Whitelabel Page should be displayed", BankonboardingConfig.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Whitelabel Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnPaymentBridge() {
		try {
			assertTrue("Webhook Page should be displayed", PaymentBridge.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Webhook Page Should be displayed But not found.");
		}
	}
	
	public void DisplayedOnKYCConfig() {
		try {
			assertTrue("Webhook Page should be displayed", KycConfig.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Webhook Page Should be displayed But not found.");
		}
	}
	
	
	public void DisplayedOnstatusHistory() {
		try {
			assertTrue("Status History Page should be displayed", statusHistory.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Status History Page Should be displayed But not found.");
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

	public void DisplayedOnDailyLimitRequired() {
		try {
			assertTrue("Daily Limit required should be displayed", DailyLimitrequired.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Daily Limit Required error message Should be displayed but not found.");
		}
	}

	public void DisplayedOnWeeklyLimitRequired() {
		try {
			assertTrue("Weekly Limit required should be displayed", WeeklyLimitrequired.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Weekly Limit Required error message Should be displayed but not found.");
		}
	}

	public void DisplayedOnMonthlyLimitRequired() {
		try {
			assertTrue("Monthly Limit required should be displayed", MOnthlyLimitrequired.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Monthly Limit Required error message Should be displayed but not found.");
		}
	}

	public void DisplayedOnMinimumAmountRequired() {
		try {
			assertTrue("Minimum Amount required should be displayed", MinimumAmountrequired.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Minimum Amount Required error message Should be displayed but not found.");
		}
	}

	public void DisplayedOnMaximumAmountRequired() {
		try {
			assertTrue("Maximum Amount required should be displayed", MAximumAmountrequired.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Maximum Amount Required error message Should be displayed but not found.");
		}
	}

	public void DisplayedOnShouldbe10digits() {
		try {
			assertTrue("MobileNumber should be 10 digits", lessthanMobilenumber.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("MobileNumber should be 10 digits error message Should be displayed but not found.");
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
			Assert.assertFalse("This field is required is displayed For This Role. ", required);
		}
	}

	public void DisplayedOnThisInvalidFormat() {
		try {
			assertTrue("Invalid Format should be displayed", InvalidFormat.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Invalid Format error message Should be displayed but not found.");
		}
	}

	public void NOTDisplayedOnInvalidFormat() {

		boolean required;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			required = InvalidFormat.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			required = false;
		}
		if (required) {
			Assert.assertFalse("Invalid Format is displayed For This Role. ", required);
		}
	}

	public void MustbegreaterthanDailyLimit() {
		try {
			assertTrue("Must be greater then Daily Limit", greaterthanDailyLimit.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Must be greater than Daily Limit Should be displayed but not found.");
		}
	}

	public void Mustbegreaterthanweeklylimit() {
		try {
			assertTrue("Must be greater than weekly limit Should be Displayed", greaterthanweeklyLimit.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Must be greater than weekly Limit Should be displayed but not found.");
		}
	}

	public void dailylimitmustbeLessthanweeklylimit() {
		try {
			assertTrue("Daily Limit Must Be Less than Weekly Limit Should be Displayed",
					Dailylimitmustbelessthanweeklylimit.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Daily Limit Must Be Less than Weekly Limit Should be displayed but not found.");
		}
	}

	public void WeeklyLimitMustbelessthanMonthlyLimit() {
		try {
			assertTrue("Weekly Limit Must Be Less than Monthly Limit Should be Displayed",
					WeeklylimitmustbelessthanMonthlylimit.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Weekly Limit Must Be Less than Monthly Limit Should be displayed but not found.");
		}
	}

	public void DailyLimitandminimumvaluenotbesame() {
		try {
			assertTrue("Daily Limit and minimum value not be same Should be Displayed",
					Dailylimitmininumvaluenotthesame.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Daily Limit and Minimum Value not be same Should be displayed but not found.");
		}
	}

	public void DailyLimitandmaximumvaluenotbesame() {
		try {
			assertTrue("Daily Limit and maximum value not be same Should be Displayed",
					minimumandmaximumvaluenotbesame.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Daily Limit and Maximum Value not be same Should be displayed but not found.");
		}
	}

	public void DisplayedOnThisMinimumLengtherror() {
		try {
			assertTrue("Minimum Length Error Message should be displayed",
					minimumbankaccountLengtherrormessage.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Minimum Length error message Should be displayed but not found.");
		}
	}

//BankSideMenu

	public void DisplayedOnGenralInfo() {
		try {
			assertTrue("General Info should be displayed in BankOnboarding", GeneralInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("General Info button Should be displayed in BankOnboarding But not found.");
		}
	}

	public void CLickOnGenralInfo() {
//		GeneralInfo.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GeneralInfo));
			GeneralInfo.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GeneralInfo));
			GeneralInfo.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DisplayedOnCommunicationInfo() {
		try {
			assertTrue("Communication Info should be displayed in BankOnboarding", CommunicationInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication Info Should be displayed in BankOnboarding But not found.");
		}
	}

	public void CLickOnCommunicationInfo() {
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

	public void DisplayedOnChannelConfig() {
		try {
			assertTrue("Channel Config should be displayed in BankOnboarding", ChannelConfig.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Channel Config Should be displayed in BankOnboarding But not found.");
		}
	}

	public void CLickOnChannelConfig() {
		// ChannelConfig.click();

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

	public void DisplayedOnGlobalFrm() {
		try {
			assertTrue("Global FRM should be displayed in BankOnboarding", GlobalFrm.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Global FRM Should be displayed in BankOnboarding But not found.");
		}
	}

	public void CLickOnglobalfrm() {
//		GlobalFrm.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GlobalFrm));
			GlobalFrm.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GlobalFrm));
			GlobalFrm.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DisplayedOnCommericial() {
		try {
			assertTrue("Commercial should be displayed in BankOnboarding", Commercial.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Commericial Should be displayed in BankOnboarding But not found.");
		}
	}

	public void clickOnCommericial() {
//		Commercial.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Commercial));
			Commercial.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Commercial));
			Commercial.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DisplayedOnSettlementInfo() {
		try {
			assertTrue("Settltment Info should be displayed in BankOnboarding", SettlementInfo.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Info Should be displayed in BankOnboarding But not found.");
		}
	}

	public void clickOnSettlementInfo() {

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

	public void DisplayedOnWhiteLabel() {
		try {
			assertTrue("WhiteLabel should be displayed in BankOnboarding", whitelabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("WhiteLabel Should be displayed in BankOnboarding But not found.");
		}
	}

	public void clickOnWhiteLabel() {

//		whitelabel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(whitelabel));
			whitelabel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(whitelabel));
			whitelabel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DisplayedOnWebhooks() {
		try {
			assertTrue("Webhooks should be displayed in BankOnboarding", webhooks.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("WhiteLabel Should be displayed in BankOnboarding But not found.");
		}
	}

	public void clickOnWebhooks() {

//		webhooks.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(webhooks));
			webhooks.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(webhooks));
			webhooks.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DisplayedOnKYC() {
		try {
			assertTrue("KYC should be displayed in BankOnboarding", Kyc.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("KYC Should be displayed in BankOnboarding But not found.");
		}
	}

	public void clickOnKYC() {

//		Kyc.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Kyc));
			Kyc.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Kyc));
			Kyc.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DisplayedOnStatusHistory() {
		try {
			assertTrue("Status History should be displayed in BankOnboarding", StatusHistory.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Status History Should be displayed in BankOnboarding But not found.");
		}
	}

	public void DisplayedOnChangeLog() {
		try {
			assertTrue("Change Log should be displayed in BankOnboarding", Changelog.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("ChangeLog Should be displayed in BankOnboarding But not found.");
		}
	}

	public void DisplayedOnbank() {
		try {
			assertTrue("BankButton should be displayed", ClickOnBank.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Bank button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnPayfac() {
		try {
			assertTrue("PayfacButton should be displayed", ClickOnPayfac.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Payfac button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnISO() {
		try {
			assertTrue("ISOButton should be displayed", ClickOnISO.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("ISO button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnSUBISO() {
		try {
			assertTrue("SUB ISOButton should be displayed", ClickOnSUBISO.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("SUB ISO button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnGM() {

		try {
			assertTrue("GroupMerchantButton should be displayed", ClickOnGM.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Group Merchant button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnMerchant() {

		try {
			assertTrue("MerchantButton should be displayed", ClickOnMerchant.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Merchant button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnTerminal() {
		try {
			assertTrue("TerminalButton should be displayed", ClickOnTerminal.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Terminal button Should be displayed For This Role But not found.");
		}
	}

	public void NotDisplayedOnBank() {

		boolean BankButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			BankButtonDisplayed = ClickOnBank.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			BankButtonDisplayed = false;
		}
		if (BankButtonDisplayed) {
			Assert.assertFalse("Bank button is displayed For This Role. ", BankButtonDisplayed);
		}

	}

	public void NOTDisplayedOnPayfac() {

		boolean PayfacButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			PayfacButtonDisplayed = ClickOnPayfac.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			PayfacButtonDisplayed = false;
		}
		if (PayfacButtonDisplayed) {
			Assert.assertFalse("Payfac button is displayed For This Role. ", PayfacButtonDisplayed);
		}
	}

	public void NOTDisplayedOnISO() {

		boolean ISOButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			ISOButtonDisplayed = ClickOnISO.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ISOButtonDisplayed = false;
		}
		if (ISOButtonDisplayed) {
			Assert.assertFalse("ISO button is displayed For This Role. ", ISOButtonDisplayed);
		}
	}

	public void ClickOnDownArrow() {
//		ClickOnDownArrow.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnDownArrow));
			ClickOnDownArrow.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnDownArrow));
			ClickOnDownArrow.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

		// wait.until(ExpectedConditions.elementToBeClickable(ClickOnDownArrow)).click();
	}

	public void ClickOnOnboarding() {
//		ClickOnOnboarding.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnOnboarding));
			ClickOnOnboarding.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnOnboarding));
			ClickOnOnboarding.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnVerifierOnboarding() {
//		ClickOnVerifierOnboarding.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnVerifierOnboarding));
			ClickOnVerifierOnboarding.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnVerifierOnboarding));
			ClickOnVerifierOnboarding.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnOnBank() {
//		ClickOnBank.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnBank));
			ClickOnBank.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnBank));
			ClickOnBank.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnPayfac() {
//		ClickOnPayfac.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnPayfac));
			ClickOnPayfac.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnPayfac));
			ClickOnPayfac.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnOnISO() {
//		ClickOnISO.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnISO));
			ClickOnISO.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnISO));
			ClickOnISO.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnSUBISO() {
//		ClickOnSUBISO.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSUBISO));
			ClickOnSUBISO.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSUBISO));
			ClickOnSUBISO.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnGroupMerchant() {
//		ClickOnGM.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnGM));
			ClickOnGM.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnGM));
			ClickOnGM.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnMerchant() {
//		ClickOnMerchant.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnMerchant));
			ClickOnMerchant.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnMerchant));
			ClickOnMerchant.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnTerminal() {
//		ClickOnTerminal.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnTerminal));
			ClickOnTerminal.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnTerminal));
			ClickOnTerminal.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnCreatebutton() {
//		Createbutton.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Createbutton));
			Createbutton.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Createbutton));
			Createbutton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void BankNameLabel() {
		try {
			assertTrue("Bank Label Name should be displayed", BankLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Bank Label Name Should be displayed but not found.");
		}
	}	

	public void AddressLabel() {
		try {
			assertTrue("Address Label Name should be displayed", AddressLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Address Label Name Should be displayed but not found.");
		}
	}

	public void PincodeLabel() {
		try {
			assertTrue("Pincode Label Name should be displayed", PincodeLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Pincode Label Name Should be displayed but not found.");
		}
	}

	public void GSTLabel() {
		try {
			assertTrue("GST Label Name should be displayed", GSTLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("GST Label Name Should be displayed but not found.");
		}
	}

	public void PANLabel() {
		try {
			assertTrue("PAN Label Name should be displayed", PANLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("PAN Label Name Should be displayed but not found.");
		}
	}

	public void MarsidLabel() {
		try {
			assertTrue("Marsid Label Name should be displayed", MaridLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Marsid Label Name Should be displayed but not found.");
		}
	}

	public void StatementFrequencyLabel() {
		try {
			assertTrue("Statement Frequency Label Name should be displayed", StatementFrequencyLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Statement Frequency Label Name Should be displayed but not found.");
		}
	}

	public void StatementTypeLabel() {
		try {
			assertTrue("Statement Type Label Name should be displayed", StatementTypeLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Statement Type Label Name Should be displayed but not found.");
		}
	}

	public void DomainLabel() {
		try {
			assertTrue("Domain Label Name should be displayed", DomainLabelName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Domain Label Name Should be displayed but not found.");
		}
	}

	public void ClickonBankName() {
//		BankName.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(BankName));
			BankName.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(BankName));
			BankName.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnteronBankName(String bank) {
		BankName.sendKeys(bank);
	}

	public String getBankName() {
		return BankName.getAttribute("value");
	}

	public void clearBankName() {
		BankName.clear();
	}

	public void ClickonAddressLine() {
//		Address.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Address));
			Address.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Address));
			Address.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnAddress(String address) {
		Address.sendKeys(address);
	}

	public String getAddress() {
		return Address.getAttribute("value");
	}

	public void clearAddress() {
		Address.clear();
	}

	public void ClickonPincode() {

//		Pincode.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Pincode));
			Pincode.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Pincode));
			Pincode.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectonPincode() {

//		SelectPincode.click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectPincode));
			SelectPincode.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectPincode));
			SelectPincode.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public String getPincode() {
		return Pincode.getAttribute("value");
	}

	public void clearPincode() {
		Pincode.clear();

	}

	public String getCity() {
		return City.getAttribute("value");
	}

	public String getState() {
		return State.getAttribute("value");
	}

	public String getCountry() {
		return Country.getAttribute("value");
	}

	public String getCurrencycode() {
		return CurrencyCode.getAttribute("value");
	}

	public void ClickOnGst() {

//		GST.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GST));
			GST.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GST));
			GST.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnGst(String gst) {

		GST.sendKeys(gst);
	}

	public void clearGst() {
		GST.clear();

	}

	public void ClickonPan() {

//		PAN.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PAN));
			PAN.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PAN));
			PAN.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnPAN(String Pan) {

		PAN.sendKeys(Pan);
	}

	public void ClearPAN() {

		PAN.clear();
	}

	public void ClickonMarsid() {

//		Marsid.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Marsid));
			Marsid.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Marsid));
			Marsid.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronMarsid(String marsid) {

		Marsid.sendKeys(marsid);

	}

	public void ClearMarsid() {

		Marsid.clear();
	}

	public void ClickOnStatementFrequency() {

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

	public void SelectOnStatementFrequency() {

//		SelectStatementFrequency.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementFrequency));
			SelectStatementFrequency.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementFrequency));
			SelectStatementFrequency.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public String getStatementFrequency() {
		return SelectStatementFrequencyCheck.getAttribute("value");
	}

	public void StatementFrequencyClear() {

		StatementFrequency.clear();
	}

	public void ClickOnStatementType() {

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

	public void SelectOnStatementType() {

//		SelectStatementType.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementType));
			SelectStatementType.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectStatementType));
			SelectStatementType.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public String getStatementType() {
		return SelectStatementTypeCheck.getAttribute("value");
	}

	public void ClickOnDomain() {

//		Domain.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Domain));
			Domain.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Domain));
			Domain.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnDomain(String domain) {

		Domain.sendKeys(domain);
	}

	public void Domainclear() {

		Domain.sendKeys(Keys.chord(Keys.CONTROL, "a"));// Select all text
		Domain.sendKeys(Keys.BACK_SPACE);

	}

	// COmmunication Details

	public void CommADD() {

//		ClickonCommADD.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommADD));

			// Perform the click action
			ClickonCommADD.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommADD));
			ClickonCommADD.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnCommName() {

//		ClickonCommuName.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuName));
			ClickonCommuName.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuName));
			ClickonCommuName.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void LabelCommName() {
		try {
			assertTrue("Communication Name Label should be displayed", LabelCommuName.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication Name Label Should be displayed but not found.");
		}
	}

	public void EnterOnCommName(String name) {

		ClickonCommuName.sendKeys(name);
	}

	public void clearCommunicationName() {
		ClickonCommuName.clear();
	}

	public void ClickOnCommPosition() {

//		ClickonCommuPosition.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuPosition));
			ClickonCommuPosition.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuPosition));
			ClickonCommuPosition.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void LabelCommPosition() {
		try {
			assertTrue("Communication Position Label should be displayed", LabelCommuPosition.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication Position Label Should be displayed but not found.");
		}
	}

	public void EnterOnCommunicationPosition(String position) {

		ClickonCommuPosition.sendKeys(position);
	}

	public void clearCommunicationPosition() {
		ClickonCommuPosition.clear();
	}

	public void ClickOnCommPhoneNumber() {

//		ClickonCommuPhonenumber.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuPhonenumber));
			ClickonCommuPhonenumber.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuPhonenumber));
			ClickonCommuPhonenumber.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnteronCommPhoneNumber(String phone) {

		ClickonCommuPhonenumber.sendKeys(phone);
	}

	public void LabelCommPhoneNumber() {
		try {
			assertTrue("Communication PhoneNumber Label should be displayed", LabelCommuPhonenumber.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication PhoneNumber Label Should be displayed but not found.");
		}
	}

	public void clearCommunicationPhoneNumber() {
		ClickonCommuPhonenumber.clear();
	}

	public void ClickonCommMobileNumber() {

//		ClickonCommuMobileNumber.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuMobileNumber));
			ClickonCommuMobileNumber.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuMobileNumber));
			ClickonCommuMobileNumber.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnteronCommMobileNumber(String Mobile) {

		ClickonCommuMobileNumber.sendKeys(Mobile);
	}

	public String getMobileNumber() {
		return ClickonCommuMobileNumber.getAttribute("value");
	}

	public void LabelCommMobileNumber() {
		try {
			assertTrue("Communication MobileNumber Label should be displayed", LabelCommuMobileNumber.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication MobileNumber Label Should be displayed but not found.");
		}
	}

	public void clearCommunicationMobileNumber() {
		ClickonCommuMobileNumber.clear();
	}

	public void ClickonCommEmailid() {

//		ClickonCommuEmailId.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuEmailId));
			ClickonCommuEmailId.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuEmailId));
			ClickonCommuEmailId.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnteronCommEmailid(String email) {

		ClickonCommuEmailId.sendKeys(email);
	}

	public void LabelCommEmailid() {
		try {
			assertTrue("Communication Emailid Label should be displayed", LabelCommuEmailId.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication Emailid Label Should be displayed but not found.");
		}
	}

	public void ClearCommEmailid() {

		ClickonCommuEmailId.clear();
	}

	public void ClickOnCommUsername() {
//		ClickonCommuUserName.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuUserName));
			ClickonCommuUserName.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickonCommuUserName));
			ClickonCommuUserName.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnterOnCommUsername(String user) {
		ClickonCommuUserName.sendKeys(user);
	}

	public void LabelCommUserName() {
		try {
			assertTrue("Communication UserName Label should be displayed", LabelCommuUsername.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication UserName Label Should be displayed but not found.");
		}
	}

	public String getUsername() {
		return ClickOnAdUsers.getText();
	}

	public void LabelCommADUser() {
		try {
			assertTrue("Communication ADUser Label should be displayed", LabelCommuADUser.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Communication ADUser Label Should be displayed but not found.");
		}
	}

	public void ClickOnAdUser() {

//		ClickOnAdUsers.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnAdUsers));
			ClickOnAdUsers.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnAdUsers));
			ClickOnAdUsers.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnYesAdUser() {

		SelectOnAdUserYes.click();
	}

	public void SelectOnNOAdUser() {

		SelectOnAdUserNO.click();
	}

	public String getADUSer() {
		return ClickOnAdUsers.getText();
	}

	public void YesAdUesrdisplayed() {

		assertTrue("Yes option is not displayed", SelectOnAdUserYes.isDisplayed());

	}

	public void NOAdUesrdisplayed() {

		assertTrue("No option is not displayed", SelectOnAdUserNO.isDisplayed());

	}

	public void CommuSavebutton() {

//		CommSave.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommSave));
			CommSave.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommSave));
			CommSave.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

//Channel Config

	public void LabelChannel() {
		try {
			assertTrue("Channel Label Name should be displayed", ChannelLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Channel Label Name Should be displayed but not found.");
		}
	}

	public void LabelNetwork() {
		try {
			assertTrue("Network Label Name should be displayed", NetworkLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Network Label Name Should be displayed but not found.");
		}
	}

	public void LabelTransactionSet() {
		try {
			assertTrue("Transactionset Label Name should be displayed", TransactionSetsLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Transaction Set Label Name Should be displayed but not found.");
		}
	}

	public void LabelRouting() {
		try {
			assertTrue("Routing Label Name should be displayed", RoutingLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Routing Label Name Should be displayed but not found.");
		}
	}

	public void ChannelADD() {
		// ChannelADD.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ChannelADD));

			// Perform the click action
			ChannelADD.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ChannelADD));
			ChannelADD.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void clickonChannel() {
//		ClickOnChannel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnChannel));
			ClickOnChannel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnChannel));
			ClickOnChannel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void clickonNetwork() {
//		ClickOntNetwork.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOntNetwork));
			ClickOntNetwork.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOntNetwork));
			ClickOntNetwork.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void clickonTransactionsetPoS() {

//		Actions a = new Actions(driver);

//		a.doubleClick(ClickOntransaction).perform();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOntransaction));
			Actions a = new Actions(driver);

			a.doubleClick(ClickOntransaction).perform();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			Actions a = new Actions(driver);

			a.doubleClick(ClickOntransaction).perform();

		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void clickonTransactionset() {

//		ClickOntransaction.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOntransaction));
			ClickOntransaction.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOntransaction));
			ClickOntransaction.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void clickonRouting() {

//		Actions a = new Actions(driver);

//		a.doubleClick(ClickOnRouting).perform();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnRouting));
			Actions a = new Actions(driver);

			a.doubleClick(ClickOnRouting).perform();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			Actions a = new Actions(driver);

			a.doubleClick(ClickOnRouting).perform();

		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectonPOSChannel() {
//		SelectPOSChannel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectPOSChannel));
			SelectPOSChannel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectPOSChannel));
			SelectPOSChannel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public String getSelectonPOSChannel() {
		return ClickOnChannel.getText();
	}


	public void SelectonUPIChannel() {
//		SelectUPIChannel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectUPIChannel));
			SelectUPIChannel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectUPIChannel));
			SelectUPIChannel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonUPIChannel() {
		return ClickOnChannel.getText();
	}


	public void SelectonAEPSChannel() {
//		SelectAEPSChannel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectAEPSChannel));
			SelectAEPSChannel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectAEPSChannel));
			SelectAEPSChannel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	
	public void SelectonMATMChannel() {
//		SelectAEPSChannel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectMATMChannel));
			SelectMATMChannel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectMATMChannel));
			SelectMATMChannel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonAEPSChannel() {
		return ClickOnChannel.getText();
	}


	public void SelectonNetworkPOS() {
//		SelectOnTransactionsetPOS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnNetworkPOS));
			SelectOnNetworkPOS.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnNetworkPOS));
			SelectOnNetworkPOS.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public String getSelectonNetworkPOS() {
		return ClickOntNetwork.getText();
	}
	
	public void SelectonNetworkMATM() {
//		SelectOnTransactionsetPOS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnNetworkMATM));
			SelectOnNetworkMATM.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnNetworkMATM));
			SelectOnNetworkMATM.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public String getSelectonNetworkMATM() {
		return ClickOntNetwork.getText();
	}
	
	public void SelectonTransactionsetMATM() {
//		SelectOntransactionsetUPI.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnTransactionsetMATM));
			SelectOnTransactionsetMATM.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnTransactionsetMATM));
			SelectOnTransactionsetMATM.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonTransactionsetkMATM() {
		return ClickOntransaction.getText();
	}


	public void SelectonTransactionsetkUPI() {
//		SelectOntransactionsetUPI.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOntransactionsetUPI));
			SelectOntransactionsetUPI.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOntransactionsetUPI));
			SelectOntransactionsetUPI.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonTransactionsetkUPI() {
		return ClickOntransaction.getText();
	}

	public void SelectonTransactionsetAEPS() {
//		SelectOnTransactionsetAEPS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnTransactionsetAEPS));
			SelectOnTransactionsetAEPS.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnTransactionsetAEPS));
			SelectOnTransactionsetAEPS.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	
	public String getSelectonTransactionsetAEPS() {
		return ClickOntransaction.getText();
	}


	public void SelectonTransactionsetpos() {
//		SelectOnTransaction.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnTransactionPOS));
			SelectOnTransactionPOS.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnTransactionPOS));
			SelectOnTransactionPOS.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public String getSelectonTransactionsetpos() {
		return ClickOntransaction.getText();
	}


	public void SelectonRouting() {
//		SelectonRouting.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectonRouting));
			SelectonRouting.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectonRouting));
			SelectonRouting.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonRouting() {
		return ClickOnRouting.getText();
	}
	
	
	public void SelectonRoutingMATM() {
//		SelectonRouting.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectonRouting));
			SelectonRouting.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectonRouting));
			SelectonRouting.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonRoutingMATM() {
		return ClickOnRouting.getText();
	}

//ONUS

	public void ActionOnONUSButton() {

//		ActionOnOnusbutton.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ActionOnOnusbutton));

			// Perform the click action
			ActionOnOnusbutton.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ActionOnOnusbutton));
			ActionOnOnusbutton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	

	public void ActionOnONUSButton2() {

//		ActionOnOnusbutton.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ActionOnOnusbutton2));

			// Perform the click action
			ActionOnOnusbutton2.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ActionOnOnusbutton2));
			ActionOnOnusbutton2.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}


	public void addbin() {

//		AddBin.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddBin));
			AddBin.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddBin));
			AddBin.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectonBin() {

//		SelectAddBin.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectAddBin));
			SelectAddBin.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectAddBin));
			SelectAddBin.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	
	public String getSelectonBin() {
		return ClickOnAddBin.getText();
	}


	public void SubmitOnONUS() {

//		SubmitOnOnus.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SubmitOnOnus));
			SubmitOnOnus.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SubmitOnOnus));
			SubmitOnOnus.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	// GlobalFRM

	public void checkboxGlobalfrm() {

//		GlobalFRMCheckbox.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GlobalFRMCheckbox));

			// Perform the click action
			GlobalFRMCheckbox.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(GlobalFRMCheckbox));
			GlobalFRMCheckbox.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

		assertTrue("Checkbox should be selected", GlobalFRMCheckbox.isEnabled());
	}

	public void uncheckboxGlobalfrm() {

		GlobalFRMCheckbox.click();

		assertTrue("Checkbox Should be Unselected", !GlobalFRMCheckbox.isSelected());
	}

	// label

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

	public void MicroATMCountLabel() {
		try {
			assertTrue("Micro ATM Count Label Name should be displayed", MicroATMCountLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Micro ATM Count Label Name Should be displayed but not found.");
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

//		VelocityCheckMinute.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(VelocityCheckMinute));

			// Perform the click action
			VelocityCheckMinute.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(VelocityCheckMinute));
			VelocityCheckMinute.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnVelocityCheckCount() {

//		VelocityCheckCount.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(VelocityCheckCount));

			// Perform the click action
			VelocityCheckCount.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(VelocityCheckCount));
			VelocityCheckCount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnCashpOScount() {

//		CashPOSCount.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CashPOSCount));

			// Perform the click action
			CashPOSCount.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CashPOSCount));
			CashPOSCount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnMicroATMCount() {

//		MicroATMCount.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MicroATMCount));

			// Perform the click action
			MicroATMCount.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MicroATMCount));
			MicroATMCount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickOnInternationalcardCount() {

//		InternationalCardCount.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(InternationalCardCount));

			// Perform the click action
			InternationalCardCount.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(InternationalCardCount));
			InternationalCardCount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

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

	public void EnterOnMicroATMCount(String atm) {

		MicroATMCount.sendKeys(atm);

	}

	public void yesInternationalcardCount() {

//		YesInternationalCardCount.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(YesInternationalCardCount));

			// Perform the click action
			YesInternationalCardCount.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(YesInternationalCardCount));
			YesInternationalCardCount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getyesInternationalcardCount() {
		return YesInternationalCardCount.getText();
	}

	public void NoInternationalcardCount() {

//		NOInternationalCardCount.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(NOInternationalCardCount));

			// Perform the click action
			NOInternationalCardCount.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(NOInternationalCardCount));
			NOInternationalCardCount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getNOInternationalcardCount() {
		return NOInternationalCardCount.getText();
	}

	public void ClickonICAdaily() {

//		ICADaily.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ICADaily));

			// Perform the click action
			ICADaily.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ICADaily));
			ICADaily.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonICAdaily() {

		ICADaily.clear();
	}

	public void ClickonICAWeekly() {

//		ICAWeekly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ICAWeekly));
			ICAWeekly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ICAWeekly));
			ICAWeekly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonICAWeekly() {

		ICAWeekly.clear();
	}

	public void ClickonICAMonthly() {

//		ICAMonthly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ICAMonthly));
			ICAMonthly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ICAMonthly));
			ICAMonthly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

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

//POS	

	public void ClickonPosdaily() {

//		POSDaily.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSDaily));
			POSDaily.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSDaily));
			POSDaily.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonPosdaily() {

		POSDaily.clear();
	}

	public void ClickonPosWeekly() {

//		POSWeekly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSWeekly));
			POSWeekly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSWeekly));
			POSWeekly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonPosWeekly() {

		POSWeekly.clear();
	}

	public void ClickonPosMonthly() {

//		POSMonthly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSMonthly));
			POSMonthly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSMonthly));
			POSMonthly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonPosMonthly() {

		POSMonthly.clear();
	}

	public void EnteronPosdaily(String daily) {

		POSDaily.sendKeys(daily);
	}

	public void EnteronPosWeekly(String weekly) {

		POSWeekly.sendKeys(weekly);
	}

	public void EnteronPosMonthly(String Monthly) {

		POSMonthly.sendKeys(Monthly);
	}

	public void ClickonPOSMinimum() {

//		POSMinimumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSMinimumAmount));
			POSMinimumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSMinimumAmount));
			POSMinimumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonPOSMinimum() {

		POSMinimumAmount.clear();
	}

	public void ClickonPOSMaximum() {

//		POSMaximumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSMaximumAmount));
			POSMaximumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(POSMaximumAmount));
			POSMaximumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonPOSMaximum() {

		POSMaximumAmount.clear();
	}

	public void EnteronPOSMinimum(String mini) {

		POSMinimumAmount.sendKeys(mini);
	}

	public void EnteronPOSMaximum(String max) {

		POSMaximumAmount.sendKeys(max);
	}

//AEPS

	public void ClickonAEPSdaily() {

//		AEPSDaily.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSDaily));
			AEPSDaily.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSDaily));
			AEPSDaily.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonAEPSdaily() {

		AEPSDaily.clear();
	}

	public void ClickonAEPSWeekly() {

//		AEPSWeekly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSWeekly));
			AEPSWeekly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSWeekly));
			AEPSWeekly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonAEPSWeekly() {

		AEPSWeekly.clear();
	}

	public void ClickonAEPSMonthly() {

//		AEPSMonthly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSWeekly));
			AEPSMonthly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSWeekly));
			AEPSMonthly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonAEPSMonthly() {

		AEPSMonthly.clear();
	}

	public void EnteronAEPSdaily(String daily) {

		AEPSDaily.sendKeys(daily);
	}

	public void EnteronAEPSWeekly(String weekly) {

		AEPSWeekly.sendKeys(weekly);
	}

	public void EnteronAEPSMonthly(String Monthly) {

		AEPSMonthly.sendKeys(Monthly);
	}

	public void ClickonAEPSMinimum() {

//		AEPSMinimumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSMinimumAmount));
			AEPSMinimumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSMinimumAmount));
			AEPSMinimumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonAEPSMinimum() {

		AEPSMinimumAmount.clear();
	}

	public void ClickonAEPSMaximum() {

//		AEPSMaximumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSMaximumAmount));
			AEPSMaximumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AEPSMaximumAmount));
			AEPSMaximumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonAEPSMaximum() {

		AEPSMaximumAmount.clear();
	}

	public void EnteronAEPSMinimum(String mini) {

		AEPSMinimumAmount.sendKeys(mini);
	}

	public void EnteronAEPSMaximum(String max) {

		AEPSMaximumAmount.sendKeys(max);
	}

//UPI

	public void ClickonUPIdaily() {

//		UPIDaily.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIDaily));
			UPIDaily.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIDaily));
			UPIDaily.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonUPIdaily() {

		UPIDaily.clear();
	}

	public void ClickonUPIWeekly() {

//		UPIWeekly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIWeekly));
			UPIWeekly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIWeekly));
			UPIWeekly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonUPIWeekly() {

		UPIWeekly.clear();
	}

	public void ClickonUPIMonthly() {

//		UPIMonthly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIMonthly));
			UPIMonthly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIMonthly));
			UPIMonthly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonUPIMonthly() {

		UPIMonthly.clear();
	}

	public void EnteronUPIdaily(String daily) {

		UPIDaily.sendKeys(daily);
	}

	public void EnteronUPIWeekly(String weekly) {

		UPIWeekly.sendKeys(weekly);
	}

	public void EnteronUPIMonthly(String Monthly) {

		UPIMonthly.sendKeys(Monthly);
	}

	public void ClickonUPIMinimum() {

//		UPIMinimumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIMinimumAmount));
			UPIMinimumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIMinimumAmount));
			UPIMinimumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonUPIMinimum() {

		UPIMinimumAmount.clear();
	}

	public void ClickonUPIMaximum() {

//		UPIMaximumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIMaximumAmount));
			UPIMaximumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(UPIMaximumAmount));
			UPIMaximumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonUPIMaximum() {

		UPIMaximumAmount.clear();
	}

	public void EnteronUPIMinimum(String mini) {

		UPIMinimumAmount.sendKeys(mini);
	}

	public void EnteronUPIMaximum(String max) {

		UPIMaximumAmount.sendKeys(max);
	}
	
//MATM
	
	public void ClickonMATMdaily() {

//		UPIDaily.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMDaily));
			MATMDaily.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMDaily));
			MATMDaily.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClearonMATMdaily() {

		MATMDaily.clear();
	}

	public void ClickonMATMWeekly() {

//		UPIWeekly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMWeekly));
			MATMWeekly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMWeekly));
			MATMWeekly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonMATMWeekly() {

		MATMWeekly.clear();
	}

	public void ClickonMATMMonthly() {

//		UPIMonthly.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMMonthly));
			MATMMonthly.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMMonthly));
			MATMMonthly.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonMATMMonthly() {

		MATMMonthly.clear();
	}

	public void EnteronMATMdaily(String daily) {

		MATMDaily.sendKeys(daily);
	}

	public void EnteronMATMWeekly(String weekly) {

		MATMWeekly.sendKeys(weekly);
	}

	public void EnteronMATMMonthly(String Monthly) {

		MATMMonthly.sendKeys(Monthly);
	}

	public void ClickonMATMMinimum() {

//		UPIMinimumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMMinimumAmount));
			MATMMinimumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMMinimumAmount));
			MATMMinimumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonMATMMinimum() {

		MATMMinimumAmount.clear();
	}

	public void ClickonMATMMaximum() {

//		UPIMaximumAmount.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMMaximumAmount));
			MATMMaximumAmount.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(MATMMaximumAmount));
			MATMMaximumAmount.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearonMATMMaximum() {

		MATMMaximumAmount.clear();
	}

	public void EnteronMATMMinimum(String mini) {

		MATMMinimumAmount.sendKeys(mini);
	}

	public void EnteronMATMMaximum(String max) {

		MATMMaximumAmount.sendKeys(max);
	}
	

//Commercial

	public void ClickonCommercialADD1() {

		// CommercialADD1.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialADD1));

			// Perform the click action
			CommercialADD1.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialADD1));
			CommercialADD1.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickonCommercialADD2() {

//		CommercialADD2.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialADD2));
			CommercialADD2.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialADD2));
			CommercialADD2.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClickonCommercialChannel() {

//		CommercialChannel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialChannel));
			CommercialChannel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialChannel));
			CommercialChannel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void CommercialChannelLabel() {
		try {
			assertTrue("Channel Label Name should be displayed", CommercialChannelLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Channel Label Name Should be displayed but not found.");
		}
	}

	public void SelectonCommercialChannelPOS() {

//		CommericaialChannelPOS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommericaialChannelPOS));
			CommericaialChannelPOS.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommericaialChannelPOS));
			CommericaialChannelPOS.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonCommercialChannelPOS() {
		return CommercialChannel.getText();
	}


	public void SelectonCommercialChannelAEPS() {

//		CommericaialChannelAEPS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommericaialChannelAEPS));
			CommericaialChannelAEPS.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommericaialChannelAEPS));
			CommericaialChannelAEPS.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectonCommercialChannelAEPS() {
		return CommercialChannel.getText();
	}


	public void CommercialPricingPlanLabelinterchange() {
		try {
			assertTrue("Pricing PLan Label Name should be displayed", PricingplanlabelInterchange.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Pricing Plan Label Name Should be displayed but not found.");
		}
	}

	public void CommercialPricingPlanLabelBankOnboarding() {
		try {
			assertTrue("Pricing PLan Label Name should be displayed", PricingplanlabelBankonboarding.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Pricing Plan Label Name Should be displayed but not found.");
		}
	}

	public void CLickONPricingPlanInterchange() {

//		PricingplanInterchange.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PricingplanInterchange));
			PricingplanInterchange.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PricingplanInterchange));
			PricingplanInterchange.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void CLickONPricingPlanBankOnboarding() {

//		PricingplanBankOnboarding.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PricingplanBankOnboarding));
			PricingplanBankOnboarding.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(PricingplanBankOnboarding));
			PricingplanBankOnboarding.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectONPricingPlanBankPOSTest() {

//		SelectOnPricingBankTestPlan.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnPricingBankPOSTestPlan));
			SelectOnPricingBankPOSTestPlan.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnPricingBankPOSTestPlan));
			SelectOnPricingBankPOSTestPlan.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public String getSelectONPricingPlanBankTest() {
			return PricingplanInterchange.getAttribute("value");
		}
	
	
	public void SelectONPricingPlanBankAEPSTest() {

//		SelectOnPricingBankTestPlan.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnPricingBankAEPSTestPlan));
			SelectOnPricingBankAEPSTestPlan.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnPricingBankAEPSTestPlan));
			SelectOnPricingBankAEPSTestPlan.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void SelectonCommercialChannelUPI() {

//		CommericaialChannelPOS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommericaialChannelUPI));
			CommericaialChannelUPI.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommericaialChannelUPI));
			CommericaialChannelUPI.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	


	public void ClickOnCommercialSave() {

//		CommercialSave.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialSave));
			CommercialSave.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CommercialSave));
			CommercialSave.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectONBankOnboardingPricingBankPOSPlan() {

//		SelectOnPricingBankAEPSPlan.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBankOnboardingPricingBankPOSPlan));
			SelectOnBankOnboardingPricingBankPOSPlan.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBankOnboardingPricingBankPOSPlan));
			SelectOnBankOnboardingPricingBankPOSPlan.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public void SelectONBankOnboardingPricingBankAEPSPlan() {

//		SelectOnPricingBankAEPSPlan.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBankOnboardingPricingBankAEPSPlan));
			SelectOnBankOnboardingPricingBankAEPSPlan.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBankOnboardingPricingBankAEPSPlan));
			SelectOnBankOnboardingPricingBankAEPSPlan.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void SelectONBankOnboardingPricingBankUPIPlan() {

//		SelectOnPricingBankAEPSPlan.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBankOnboardingPricingBankUPIPlan));
			SelectOnBankOnboardingPricingBankUPIPlan.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectOnBankOnboardingPricingBankUPIPlan));
			SelectOnBankOnboardingPricingBankUPIPlan.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	public String getSelectONBankOnboardingPricingBankPlan() {
			return PricingplanBankOnboarding.getAttribute("value");
		}
	

//SettlementInfo

	public void ClickOnSettlementInfoADD() {

//		SettlementInfoADD.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementInfoADD));

			// Perform the click action
			SettlementInfoADD.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementInfoADD));
			SettlementInfoADD.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SettlementLabelChannel() {
		try {
			assertTrue("Settlement Channel Label Name should be displayed", SettlementChannel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Channel Label Name Should be displayed but not found.");
		}
	}

	public void SettlementAccountRypeLabel() {
		try {
			assertTrue("Settlement Account Type Label Name should be displayed",
					SettlementAccountTypeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Account Type Label Name Should be displayed but not found.");
		}
	}

	public void SettlementBanKAccountNumberLabel() {
		try {
			assertTrue("Settlement BankAccount Number Label Name should be displayed",
					SettlementBackAccountLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Bank Account Number Label Name Should be displayed but not found.");
		}
	}

	public void SettlementIFSCCODELabel() {
		try {
			assertTrue("Settlement IFSC Code Label Name should be displayed", SettlementIFSCCodeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement IFSC Code Label Name Should be displayed but not found.");
		}
	}

	public void SettlementBankNameLabel() {
		try {
			assertTrue("Settlement Bank Name Label should be displayed", SettlementBankNameLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement BankName Label Should be displayed but not found.");
		}
	}

	public void SettlementBranchLabel() {
		try {
			assertTrue("Settlement Branch Label Name should be displayed", SettlementBranchLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Branch Label Name Should be displayed but not found.");
		}
	}

	public void SettlementCityLabel() {
		try {
			assertTrue("Settlement City Label Name should be displayed", SettlementCityLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement City Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnSettlementChannel() {

//		SettlementChannel.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementChannel));
			SettlementChannel.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementChannel));
			SettlementChannel.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DoubleClickOnSettlementChannel() {

//		Actions a = new Actions(driver);
//		a.doubleClick(SettlementChannel).perform();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementChannel));
			Actions a = new Actions(driver);
			a.doubleClick(SettlementChannel).perform();

		} catch (ElementClickInterceptedException e) {

			Actions a = new Actions(driver);
			a.doubleClick(SettlementChannel).perform();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnSettlementChannelPOS() {

//		SettlementChannelPOS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementChannelPOS));
			SettlementChannelPOS.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementChannelPOS));
			SettlementChannelPOS.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnSettlementChannelPOS() {
		return SettlementChannel.getText();
	}


	public void ClickOnSettlementAccountType() {

//		SettlementAccountType.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementAccountType));
			SettlementAccountType.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementAccountType));
			SettlementAccountType.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void DoubleClickOnSettlementAccountType() {

//		Actions a = new Actions(driver);
//		a.doubleClick(SettlementAccountType).perform();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementAccountType));
			Actions a = new Actions(driver);
			a.doubleClick(SettlementAccountType).perform();

		} catch (ElementClickInterceptedException e) {

			Actions a = new Actions(driver);
			a.doubleClick(SettlementAccountType).perform();

		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnSettlementAccountTypeCurrent() {

//		SettlementAccountTypeCurrent.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementAccountTypeCurrent));
			SettlementAccountTypeCurrent.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementAccountTypeCurrent));
			SettlementAccountTypeCurrent.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnSettlementAccountTypeCurrent() {
		return SettlementAccountType.getText();
	}


	public void ClickOnBankAccountNumber() {

//		SettlementBankAccountNumber.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementBankAccountNumber));
			SettlementBankAccountNumber.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementBankAccountNumber));
			SettlementBankAccountNumber.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearOnBankAccountNumber() {

		SettlementBankAccountNumber.clear();

	}

	public void EnterOnBankAccountNumber(String BankAccount) {

		SettlementBankAccountNumber.sendKeys(BankAccount);

	}

	public void ClickOnIFSCCode() {

//		SettlementIFSCCode.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementIFSCCode));
			SettlementIFSCCode.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementIFSCCode));
			SettlementIFSCCode.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnIFSCCodeBHG() {

//		SettlementIFSCCodeBHG.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementIFSCCodeBHG));
			SettlementIFSCCodeBHG.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementIFSCCodeBHG));
			SettlementIFSCCodeBHG.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnIFSCCodeBHG() {
		return  SettlementIFSCCode.getAttribute("value");
	}

	
	

	public String getSettlementBankName() {
		return SettlementBankName.getAttribute("value");
	}

	public String getSettlementBranch() {
		return SettlementBranch.getAttribute("value");
	}

	public String getSettlementCity() {
		return SettlementCity.getAttribute("value");
	}

	public void SettlementTypeLabel() {
		try {
			assertTrue("Settlement Type Label Name should be displayed", SettlementTypeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Settlement Type Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnSettlementType() {

//		SettlementType.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementType));
			SettlementType.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementType));
			SettlementType.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnSettlementTypeManual() {

//		SettlementTypeManual.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementTypeManual));
			SettlementTypeManual.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementTypeManual));
			SettlementTypeManual.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnSettlementTypeManual() {
		return SettlementType.getText();
	}

	public void SelectOnSettlementTypeWallet() {

//		SettlementTypeWallet.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementTypeWallet));
			SettlementTypeWallet.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SettlementTypeWallet));
			SettlementTypeWallet.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnSettlementTypeWallet() {
		return SettlementType.getText();
	}



	// WhiteLabel

	public void WhitelabelBankOwnDeploymentLabel() {
		try {
			assertTrue("Whitelabel Bank Own Deployment Label Name should be displayed",
					WhiteLabelBankOwnDeployemntLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("WhiteLabel Settlement Bank Own Deployment Label Name Should be displayed but not found.");
		}
	}

	public void WhitelabelPayfacOnboardingLabel() {
		try {
			assertTrue("WhiteLabel PayFac Onboarding Label Name should be displayed",
					WhitelabelPayfacOnboardingLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("WhiteLabel Payfac Onboarding Label Name Should be displayed but not found.");
		}
	}

	public void WhitelabelISOOnboardingLabel() {
		try {
			assertTrue("WhiteLabel ISO Onboarding Label Name should be displayed",
					WhitelabelISOOnboardingLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("WhiteLabel ISO Onboarding Label Name Should be displayed but not found.");
		}
	}

	public void WhitelabelSalesTeamOnboardingLabel() {
		try {
			assertTrue("WhiteLabel Sales Team Onboarding Label Name should be displayed",
					WhitelabelSalesTeamOnboardingLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("WhiteLabel Sales Team Onboarding Label Name Should be displayed but not found.");
		}
	}

	public void WhitelabelMaximumNumberOfPlatformLabel() {
		try {
			assertTrue("Maximum Number of Platform Label Name should be displayed",
					WhitelabelMaximumNumberOfPlatformLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Maximum N Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnWhitelabelBankOwnDeployment() {

		// WhitelabelBankOwnDeployment.click();

		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelBankOwnDeployment));

			// Perform the click action
			WhitelabelBankOwnDeployment.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelBankOwnDeployment));
			WhitelabelBankOwnDeployment.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getClickOnWhitelabelBankOwnDeployment() {
		return WhitelabelBankOwnDeployment.getText();
	}

	public void ClickOnWhitelabelPayfacOnboarding() {

//		WhitelabelPayfacOnboarding.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelPayfacOnboarding));
			WhitelabelPayfacOnboarding.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelPayfacOnboarding));
			WhitelabelPayfacOnboarding.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getClickOnWhitelabelPayfacOnboarding() {
		return WhitelabelPayfacOnboarding.getText();
	}


	public void ClickOnWhitelabelISOOnboarding() {

//		WhitelabelISOOnboarding.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelISOOnboarding));
			WhitelabelISOOnboarding.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelISOOnboarding));
			WhitelabelISOOnboarding.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getClickOnWhitelabelISOOnboarding() {
		return WhitelabelISOOnboarding.getText();
	}

	public void ClickOnWhitelabelSalesTeamOnboarding() {

//		WhitelabelSalesTeamOnboarding.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelSalesTeamOnboarding));
			WhitelabelSalesTeamOnboarding.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelSalesTeamOnboarding));
			WhitelabelSalesTeamOnboarding.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getClickOnWhitelabelSalesTeamOnboarding() {
		return WhitelabelSalesTeamOnboarding.getText();
	}


	public void SelectOnWhiteLabelYes() {

//		WhitelabelYES.click();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", WhitelabelYES);

	}
	
	public String getSelectOnWhiteLabelYes() {
		return WhitelabelYES.getText();
	}


	public void SelectOnWhiteLabelNO() {

//		WhitelabelNO.click();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", WhitelabelNO);

	}
	
	public String getSelectOnWhiteLabelNO() {
		return WhitelabelNO.getText();
	}

	public void ClickOnMaximumNoofPlatform() {

//		WhitelabelMaxNumberOfPlatform.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelMaxNumberOfPlatform));
			WhitelabelMaxNumberOfPlatform.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WhitelabelMaxNumberOfPlatform));
			WhitelabelMaxNumberOfPlatform.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnMaximumNoofPlatform(String Maximum) {

		WhitelabelMaxNumberOfPlatform.sendKeys(Maximum);

	}

	// Webhooks

	public void WebhooksTypeLabel() {
		try {
			assertTrue("Webhook Type Label Name should be displayed", WebhookTypeLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Webhook Type Label Name Should be displayed but not found.");
		}
	}

	public void WebhooksURLLabel() {
		try {
			assertTrue("Webhook URL Label Name should be displayed", WebhookURLLabel.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Webhook URL Label Name Should be displayed but not found.");
		}
	}

	public void ClickOnWebhookADD() {

//		WebhookADD.click();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", WebhookADD);

	}

	public void ClickOnWebhooksType() {

//		WebhookType.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookType));
			WebhookType.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookType));
			WebhookType.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	

	public void DoubleClickOnWebhookType() {

		Actions a = new Actions(driver);
		a.doubleClick(WebhookType).perform();

	}

	public void SelectOnWebhooksType() {

//		WebhookTypeSMS.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookTypeSMS));
			WebhookTypeSMS.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookTypeSMS));
			WebhookTypeSMS.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnWebhooksType() {
		return WebhookType.getText();
	}

	public void ClickOnWebhooksURL() {

//		WebhookTypeURL.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookTypeURL));
			WebhookTypeURL.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookTypeURL));
			WebhookTypeURL.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void ClearOnWebhooksURL() {

		WebhookTypeURL.sendKeys(Keys.chord(Keys.CONTROL, "a"));// Select all text
		WebhookTypeURL.sendKeys(Keys.BACK_SPACE);

	}

	public void EnterOnWebhooksURL(String url) {

		WebhookTypeURL.sendKeys(url);

	}

	public void ClickOnWebhooksSave() {

//		WebhookSave.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookSave));
			WebhookSave.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WebhookSave));
			WebhookSave.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	// KYC

	public void ClickOnKYCBusinessType() {

//		KYCBusinessType.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCBusinessType));
			KYCBusinessType.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCBusinessType));
			KYCBusinessType.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnKYCBusinessTypeTrust() {

//		KYCBusinessTypeTrust.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCBusinessTypeTrust));
			KYCBusinessTypeTrust.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCBusinessTypeTrust));
			KYCBusinessTypeTrust.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnKYCBusinessTypeTrust() {
		return KYCBusinessType.getText();
	}

	public void ClickOnProofOfIdentityCompany() {

//		proofofIdentityComapany.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(proofofIdentityComapany));
			proofofIdentityComapany.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(proofofIdentityComapany));
			proofofIdentityComapany.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnProofOfIdentityCompany() {

//		KYCSelectproofofIdentityCompany.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectproofofIdentityCompany));
			KYCSelectproofofIdentityCompany.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectproofofIdentityCompany));
			KYCSelectproofofIdentityCompany.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnProofOfIdentityCompany() {
		return proofofIdentityComapany.getText();
	}

	public void ClickOnNumberOfCompany1() {

//		KYCNumberofDocinPoiCompany1.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinPoiCompany1));
			KYCNumberofDocinPoiCompany1.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinPoiCompany1));
			KYCNumberofDocinPoiCompany1.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnNumberOfCompany1(String com1) {

		KYCNumberofDocinPoiCompany1.sendKeys(com1);

	}

	public void ClickOnProofOfAddressCompany() {

//		proofofaddress.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(proofofaddress));
			proofofaddress.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(proofofaddress));
			proofofaddress.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnProofOfAddressCompany() {

//		KYCSelectOnProofAddress.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectOnProofAddress));
			KYCSelectOnProofAddress.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectOnProofAddress));
			KYCSelectOnProofAddress.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnProofOfAddressCompany() {
		return proofofaddress.getText();
	}


	public void ClickOnNumberOfCompany2() {

//		KYCNumberofDocinPoaCompany2.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinPoaCompany2));
			KYCNumberofDocinPoaCompany2.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinPoaCompany2));
			KYCNumberofDocinPoaCompany2.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnNumberOfCompany2(String com2) {

		KYCNumberofDocinPoaCompany2.sendKeys(com2);

	}

	public void ClickOnBankDocumentCompany() {

//		KYCBankDoc.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCBankDoc));
			KYCBankDoc.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCBankDoc));
			KYCBankDoc.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnBankDocumentCompany() {

//		KYCSelectBankDoc.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectBankDoc));
			KYCSelectBankDoc.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectBankDoc));
			KYCSelectBankDoc.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnBankDocumentCompany() {
		return KYCBankDoc.getText();
	}


	public void ClickOnNumberOfCompany3() {

//		KYCNumberofDocinBankCompany3.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinBankCompany3));
			KYCNumberofDocinBankCompany3.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinBankCompany3));
			KYCNumberofDocinBankCompany3.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnNumberOfCompany3(String com3) {

		KYCNumberofDocinBankCompany3.sendKeys(com3);

	}

	public void ClickOnTaxDocumentCompany() {

//		KYCTaxDoc.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCTaxDoc));
			KYCTaxDoc.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCTaxDoc));
			KYCTaxDoc.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnTaxDocumentCompany() {

//		KYCSelectTaxDoc.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectTaxDoc));
			KYCSelectTaxDoc.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCSelectTaxDoc));
			KYCSelectTaxDoc.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnTaxDocumentCompany() {
		return KYCTaxDoc.getText();
	}


	public void ClickOnNumberOfCompany4() {

//		KYCNumberofDocinTaxCompany4.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinTaxCompany4));
			KYCNumberofDocinTaxCompany4.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCNumberofDocinTaxCompany4));
			KYCNumberofDocinTaxCompany4.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnNumberOfCompany4(String com4) {

		KYCNumberofDocinTaxCompany4.sendKeys(com4);

	}
	// Individual

	public void ClickOnProofOfIdentityIndividual() {

//		KYCIndividualProofOfIdentity.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualProofOfIdentity));
			KYCIndividualProofOfIdentity.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualProofOfIdentity));
			KYCIndividualProofOfIdentity.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnProofOfIdentityIndividual() {

//		KYCIndividualSelectONProofOfIdentity.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualSelectONProofOfIdentity));
			KYCIndividualSelectONProofOfIdentity.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualSelectONProofOfIdentity));
			KYCIndividualSelectONProofOfIdentity.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnProofOfIdentityIndividual() {
		return KYCIndividualProofOfIdentity.getText();
	}

	public void ClickOnNumberOfIndividual1() {

//		KycNumberOfDocinPOiIndividual1.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KycNumberOfDocinPOiIndividual1));
			KycNumberOfDocinPOiIndividual1.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KycNumberOfDocinPOiIndividual1));
			KycNumberOfDocinPOiIndividual1.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnNumberOfIndividual1(String in1) {

		KycNumberOfDocinPOiIndividual1.sendKeys(in1);

	}

	public void ClickOnProofOfAddressIndividual() {

//		KYCIndividualProofOFAddress.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualProofOFAddress));
			KYCIndividualProofOFAddress.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualProofOFAddress));
			KYCIndividualProofOFAddress.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnProofOfAddressIndividual() {

//		KYCIndividualSelectONProofOFAddress.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualSelectONProofOFAddress));
			KYCIndividualSelectONProofOFAddress.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualSelectONProofOFAddress));
			KYCIndividualSelectONProofOFAddress.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnProofOfAddressIndividual() {
		return KYCIndividualProofOFAddress.getText();
	}

	public void ClickOnNumberOfIndividual2() {

//		KycNumberOfDocinPoaIndividual2.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KycNumberOfDocinPoaIndividual2));
			KycNumberOfDocinPoaIndividual2.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KycNumberOfDocinPoaIndividual2));
			KycNumberOfDocinPoaIndividual2.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnNumberOfIndividual2(String in2) {

		KycNumberOfDocinPoaIndividual2.sendKeys(in2);

	}

	public void ClickOnOtherDocumentIndividual() {

//		KYCIndividualOtherDocument.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualOtherDocument));
			KYCIndividualOtherDocument.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualOtherDocument));
			KYCIndividualOtherDocument.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SelectOnOtherDocumentIndividual() {

//		KYCIndividualSelectOnOtherDocument.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualSelectOnOtherDocument));
			KYCIndividualSelectOnOtherDocument.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(KYCIndividualSelectOnOtherDocument));
			KYCIndividualSelectOnOtherDocument.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getSelectOnOtherDocumentIndividual() {
		return KYCIndividualOtherDocument.getText();
	}


	public void ClickOnNumberOfIndividual3() {

//		keyPersonNumberofOtherDocIndividual3.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(keyPersonNumberofOtherDocIndividual3));
			keyPersonNumberofOtherDocIndividual3.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(keyPersonNumberofOtherDocIndividual3));
			keyPersonNumberofOtherDocIndividual3.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void EnterOnNumberOfIndividual3(String in3) {

		keyPersonNumberofOtherDocIndividual3.sendKeys(in3);

	}

	public void Yesforsubmit() {

//		YesForSubmit.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(YesForSubmit));
			YesForSubmit.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(YesForSubmit));
			YesForSubmit.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void OkforSuccessfully() {

//		OKForSuccessfully.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(OKForSuccessfully));
			OKForSuccessfully.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(OKForSuccessfully));
			OKForSuccessfully.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void LogoutProfile() {

//		Profile.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Profile));
			Profile.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Profile));
			Profile.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void Logoutbutton() {

//		LogOut.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(LogOut));
			LogOut.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(LogOut));
			LogOut.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void LogoutYESbutton() {

//		LogOutYES.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(LogOutYES));
			LogOutYES.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(LogOutYES));
			LogOutYES.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SearchbyBankName(String bankname) {

		SearchbyBankName.sendKeys(bankname);

	}

	public void ClickSearchbyBankName() {

		// SearchbyBankName.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchbyBankName));
			SearchbyBankName.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SearchbyBankName));
			SearchbyBankName.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	public String getClickSearchbyBankName() {
			return SearchbyBankName.getAttribute("value");
		}


	
	

	public void ActionClick() {
//		ActionClick.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ActionClick));
			ActionClick.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ActionClick));
			ActionClick.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}
	
	
	public void ClickonViewButton() {

//		wait.until(ExpectedConditions.elementToBeClickable(VerifiedandNext)).click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ViewButton));
			ViewButton.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ViewButton));
			ViewButton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void VerifiedandNext() {

//		wait.until(ExpectedConditions.elementToBeClickable(VerifiedandNext)).click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(VerifiedandNext));
			VerifiedandNext.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(VerifiedandNext));
			VerifiedandNext.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void SubmitforApproval() {
//		SubmitforApproval.click();

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SubmitforApproval));
			SubmitforApproval.click();
		} catch (ElementClickInterceptedException e) {

			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SubmitforApproval));
			SubmitforApproval.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public String getCPID() {
		return CPID.getAttribute("value");
	}

}
