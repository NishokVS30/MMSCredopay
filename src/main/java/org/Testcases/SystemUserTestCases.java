package org.Testcases;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class SystemUserTestCases {

	org.Locators.LoginLocators L;
	org.Locators.SystemUserLocatores S;

	private WebDriver driver;

	private ExtentTest test;
	
	ExcelDataCache cache = ExcelDataCache.getInstance();

	public SystemUserTestCases() throws InterruptedException {

		this.driver = CustomWebDriverManager.getDriver();
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

		// WebDriver driver = CustomWebDriverManager.getDriver();
	}



	@Then("Should be able to see the Bank, Aggrerators, ISO, Sub ISO, Groupmerchant, Merchant, and Terminal in Onboarding")
	public void i_should_be_able_to_see_the_Bank_Payfac_iso_groupmerchant_merchant_and_terminal_in_onboarding()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();

		S.DisplayedOnbank();

		S.DisplayedOnPayfac();

		S.DisplayedOnISO();

		S.DisplayedOnGM();

		S.DisplayedOnMerchant();

		S.DisplayedOnTerminal();

	}

	@Given("I am searching in the Bank Onboarding with Status : New")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_New() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusNew();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status :New")
	public void I_am_searching_in_the_Bank_Onbarding_with_status_New() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();

		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusNew();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status : Inprogress")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_Inprogress() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusInprogress();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status : Verified")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_Verified() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusVerified();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status : Draft")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_Draft() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusDraft();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status : Referback")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_Referback() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusReferback();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status :Auto Referback")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_AutoReferback() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusAutoReferback();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status : Approved")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_Approved() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusApproved();

		S.Clickonapply();

	}

	@Given("I am searching in the Bank Onboarding with Status : Rejected")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_Rejected() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusRejected();

		S.Clickonapply();

		Thread.sleep(5000);

	}

	@Given("I am searching in the Bank Onboarding with Status : Closed")
	public void I_am_searching_in_the_Bank_Onbarding_with_Status_Closed() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(3000);

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnBank();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusclosed();

		S.Clickonapply();

	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is New")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Bank_Status_is_New()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, and Close buttons in the Bank Onboarding when the status is Inprogress")
	public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Bank_Status_Inprogress()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should not be able to see the Edit button in the Bank Onboarding when the status is Inprogress")
	public void should_not_be_able_to_see_the_Edit_buttons_in_Bank_Status_Inprogress() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		S.NOTDisplayedOnEditbutton();

		Thread.sleep(3000);

	}

	@Then("Should be able to see the Create, View, and Close buttons in the Bank Onboarding when the status is Verified")
	public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Bank_Status_Verified()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should not be able to see the Edit button in the Bank Onboarding when the status is Verified")
	public void should_not_be_able_to_see_the_Edit_buttons_in_Bank_Status_Verified() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnEditbutton();

		Thread.sleep(3000);

	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Draft")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Bank_Status_is_Draft()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Referback")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Bank_Status_is_Referback()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Auto Referback")
	public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Bank_Status_AutoReferback()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedOnViewbutton();

		S.DisplayedonEditbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Approved")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Bank_Status_is_Approved()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create , Edit and View buttons in the Bank Onboarding when the status is Rejected")
	public void shouldbeable_to_see_the_Create_and_View_buttons_in_the_Bank_Onboarding_when_the_status_is_Rejected()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		Thread.sleep(3000);

	}

	@Then("Should not be able to see the Close buttons in the Bank Onboarding when the status is Rejected")
	public void Should_not_be_able_to_see_the_Editand_Closebuttons_intheBankOnboarding_whenthestatus_is_Rejected()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create,Edit and View buttons in the Bank Onboarding when the status is CLosed")
	public void shouldbeable_to_see_the_Create_Edit_and_View_buttons_in_the_Bank_Onboarding_when_the_status_is_Closed()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		Thread.sleep(3000);

	}

	@Then("Should not be able to see the Close button in the Bank Onboarding when the status is Closed")
	public void Should_not_be_able_to_see_the_Closebutton_intheBankOnboarding_whenthestatus_is_CLosed()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnClosebutton();

		Thread.sleep(3000);

	}

	// Cancel

	@Then("I click the Edit button")
	public void I_click_the_Edit_button() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ActionClick();

		S.ClickOnEdit();

		Thread.sleep(3000);
	}

	@Then("I click the edit button")
	public void I_click_the_edit_button() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnEdit();

		Thread.sleep(3000);
	}

	@Then("I click the View button")
	public void I_click_the_View_button() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ActionClick();
		S.clickonView();

		Thread.sleep(3000);
	}

	@Then("I click the view button")
	public void I_click_the_view_button() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ActionClick();
		S.clickonView();

		Thread.sleep(3000);
	}

	@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is New")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheBankOnboarding_whenthestatusisNew()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is New")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_Onboarding() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is New")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_Onboarding()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Inprogress")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_OnboardingStatusisInprogress()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Inprogress")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_OnboardingStatusis_Inprogress()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Verified")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_OnboardingStatusisVerified()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Verified")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_OnboardingStatusis_Verified()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is Draft")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheBankOnboarding_whenthestatusisDraft()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Draft")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_OnboardingStatus_Draft()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Draft")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_Onboarding_Status_Draft()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	//

	@Then("I should be able to see the Cancel and Save as Draft buttons in the Bank Onboarding when the status is Referback")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheBankOnboarding_whenthestatusisReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

	}

	@Then("I Should not be able to see the Submit for Verification button in the Bank Onboarding when the status is Referback")
	public void I_should_beabletoseetheSubmitforVerificationbutton_intheBankOnboarding_whenthestatusisReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Referback")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_OnboardingStatus_Referback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Referback")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_Onboarding_Status_Referback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is Auto Referback")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheBankOnboarding_whenthestatusisAutoReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Auto Referback")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_Onboarding_AutoReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Auto Referback")
	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_Onboarding_AutoReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel and Save as Draft buttons in the Bank Onboarding when the status is Approved")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheBankOnboarding_whenthestatusisApproved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

	}

	@Then("I Should not be able to see the Submit for Verification button in the Bank Onboarding when the status is Approved")
	public void I_shouldnot_beabletoseetheSubmitforVerificationbutton_intheBankOnboarding_whenthestatusisApproved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Approved")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_OnboardingStatus_Approved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Approved")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_Onboarding_Status_Approved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Rejected")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_OnboardingStatusisRejected()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Rejected")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_OnboardingStatusis_Rejected()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is Auto Referback")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheBankOnboarding_whenthestatusisautoreferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel and Save as Draft buttons in the Bank Onboarding when the status is Closed")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheBankOnboarding_whenthestatusisClosed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

	}

	@Then("I Should not be able to see the Submit for Verification button in the Bank Onboarding when the status is Closed")
	public void I_should_beabletoseetheSubmitforVerificationbutton_intheBankOnboarding_whenthestatusisClosed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Bank Onboarding when the status is Closed")

	public void should_be_able_to_see_only_the_Cancel_buttonintheBank_OnboardingStatus_Closed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Closed")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheBank_Onboarding_Status_Closed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

//PayfacOnboarding

	@Given("I am searching in the Payfac Onboarding with Status : New")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_New() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusNew();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status :New")
	public void I_am_searching_in_the_Payfac_Onbarding_with_status_New() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();

		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusNew();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status : Inprogress")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_Inprogress() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusInprogress();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status : Verified")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_Verified() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusVerified();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status : Draft")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_Draft() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusDraft();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status : Referback")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_Referback() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusReferback();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status :Auto Referback")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_AutoReferback() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();
		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusAutoReferback();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status : Approved")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_Approved() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusApproved();

		S.Clickonapply();

	}

	@Given("I am searching in the Payfac Onboarding with Status : Rejected")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_Rejected() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();
		
		

		S.SelectOnStatusRejected();

		S.Clickonapply();

		Thread.sleep(5000);

	}

	@Given("I am searching in the Payfac Onboarding with Status : Closed")
	public void I_am_searching_in_the_Payfac_Onbarding_with_Status_Closed() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(3000);

		S.ClickOnDownArrow();

		S.ClickOnOnboarding();
		S.ClickOnPayfac();

		S.ClickOnMoreFilter();

		S.ClickOnStatus();

		S.SelectOnStatusclosed();

		S.Clickonapply();

	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is New")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Payfac_Status_is_New()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, and Close buttons in the Payfac Onboarding when the status is Inprogress")
	public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Payfac_Status_Inprogress()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should not be able to see the Edit button in the Payfac Onboarding when the status is Inprogress")
	public void should_not_be_able_to_see_the_Edit_buttons_in_Payfac_Status_Inprogress() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		S.NOTDisplayedOnEditbutton();

		Thread.sleep(3000);

	}

	@Then("Should be able to see the Create, View, and Close buttons in the Payfac Onboarding when the status is Verified")
	public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Payfac_Status_Verified()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should not be able to see the Edit button in the Payfac Onboarding when the status is Verified")
	public void should_not_be_able_to_see_the_Edit_buttons_in_Payfac_Status_Verified() throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnEditbutton();

		Thread.sleep(3000);

	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Draft")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Payfac_Status_is_Draft()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Referback")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Payfac_Status_is_Referback()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Auto Referback")
	public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Payfac_Status_AutoReferback()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedOnViewbutton();

		S.DisplayedonEditbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Approved")
	public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Payfac_Status_is_Approved()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		S.DisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create , Edit and View buttons in the Payfac Onboarding when the status is Rejected")
	public void shouldbeable_to_see_the_Create_and_View_buttons_in_the_Payfac_Onboarding_when_the_status_is_Rejected()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		Thread.sleep(3000);

	}

	@Then("Should not be able to see the Close buttons in the Payfac Onboarding when the status is Rejected")
	public void Should_not_be_able_to_see_the_Editand_Closebuttons_inthePayfacOnboarding_whenthestatus_is_Rejected()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnClosebutton();

		Thread.sleep(3000);
	}

	@Then("Should be able to see the Create,Edit and View buttons in the Payfac Onboarding when the status is CLosed")
	public void shouldbeable_to_see_the_Create_Edit_and_View_buttons_in_the_Payfac_Onboarding_when_the_status_is_Closed()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCreatebutton();

		S.ActionClick();

		S.DisplayedonEditbutton();

		S.DisplayedOnViewbutton();

		Thread.sleep(3000);

	}

	@Then("Should not be able to see the Close button in the Payfac Onboarding when the status is Closed")
	public void Should_not_be_able_to_see_the_Closebutton_inthePayfacOnboarding_whenthestatus_is_CLosed()
			throws InterruptedException {
		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnClosebutton();

		Thread.sleep(3000);

	}

	@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is New")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_inthePayfacOnboarding_whenthestatusisNew()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is New")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_Onboarding() throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is New")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_Onboarding()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Inprogress")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_OnboardingStatusisInprogress()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Inprogress")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_OnboardingStatusis_Inprogress()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Verified")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_OnboardingStatusisVerified()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Verified")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_OnboardingStatusis_Verified()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is Draft")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_inthePayfacOnboarding_whenthestatusisDraft()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Draft")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_OnboardingStatus_Draft()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Draft")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_Onboarding_Status_Draft()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	//

	@Then("I should be able to see the Cancel and Save as Draft buttons in the Payfac Onboarding when the status is Referback")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_inthePayfacOnboarding_whenthestatusisReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

	}

	@Then("I Should not be able to see the Submit for Verification button in the Payfac Onboarding when the status is Referback")
	public void I_should_beabletoseetheSubmitforVerificationbutton_inthePayfacOnboarding_whenthestatusisReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Referback")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_OnboardingStatus_Referback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Referback")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_Onboarding_Status_Referback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is Auto Referback")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_inthePayfacOnboarding_whenthestatusisAutoReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Auto Referback")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_Onboarding_AutoReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Auto Referback")
	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_Onboarding_AutoReferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel and Save as Draft buttons in the Payfac Onboarding when the status is Approved")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_inthePayfacOnboarding_whenthestatusisApproved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

	}

	@Then("I Should not be able to see the Submit for Verification button in the Payfac Onboarding when the status is Approved")
	public void I_shouldnot_beabletoseetheSubmitforVerificationbutton_inthePayfacOnboarding_whenthestatusisApproved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Approved")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_OnboardingStatus_Approved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Approved")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_Onboarding_Status_Approved()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Rejected")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_OnboardingStatusisRejected()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Rejected")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_OnboardingStatusis_Rejected()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is Auto Referback")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_inthePayfacOnboarding_whenthestatusisautoreferback()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

		S.DisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see the Cancel and Save as Draft buttons in the Payfac Onboarding when the status is Closed")
	public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_inthePayfacOnboarding_whenthestatusisClosed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		S.DisplayedOnSaveasdraftbutton();

	}

	@Then("I Should not be able to see the Submit for Verification button in the Payfac Onboarding when the status is Closed")
	public void I_should_beabletoseetheSubmitforVerificationbutton_inthePayfacOnboarding_whenthestatusisClosed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnsubmitforverificationbutton();

		Thread.sleep(3000);

		S.ClickOnCancel();

		Thread.sleep(2000);

		S.ClickOnOnboarding();

	}

	@Then("I should be able to see only the Cancel button in the Payfac Onboarding when the status is Closed")

	public void should_be_able_to_see_only_the_Cancel_buttoninthePayfac_OnboardingStatus_Closed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.DisplayedOnCancelbutton();

		Thread.sleep(3000);
	}

	@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Closed")

	public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsinthePayfac_Onboarding_Status_Closed()
			throws InterruptedException {

		S = new org.Locators.SystemUserLocatores(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		S.NOTDisplayedOnSaveasdraftbutton();

		S.NOTDisplayedOnsubmitforverificationbutton();

		S.ClickOnCancel();

		Thread.sleep(3000);

		S.ClickOnOnboarding();

	}
	
	//ISO	

		@Given("I am searching in the ISO Onboarding with Status : New")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status :New")
		public void I_am_searching_in_the_ISO_Onbarding_with_status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();

			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status : Inprogress")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_Inprogress() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusInprogress();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status : Verified")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_Verified() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusVerified();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status : Draft")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_Draft() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusDraft();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status : Referback")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_Referback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status :Auto Referback")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_AutoReferback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusAutoReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status : Approved")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_Approved() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusApproved();

			S.Clickonapply();

		}

		@Given("I am searching in the ISO Onboarding with Status : Rejected")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_Rejected() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusRejected();

			S.Clickonapply();

			Thread.sleep(5000);

		}

		@Given("I am searching in the ISO Onboarding with Status : Closed")
		public void I_am_searching_in_the_ISO_Onbarding_with_Status_Closed() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusclosed();

			S.Clickonapply();

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is New")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_ISO_Status_is_New()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, and Close buttons in the ISO Onboarding when the status is Inprogress")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_ISO_Status_Inprogress()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the ISO Onboarding when the status is Inprogress")
		public void should_not_be_able_to_see_the_Edit_buttons_in_ISO_Status_Inprogress() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, and Close buttons in the ISO Onboarding when the status is Verified")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_ISO_Status_Verified()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the ISO Onboarding when the status is Verified")
		public void should_not_be_able_to_see_the_Edit_buttons_in_ISO_Status_Verified() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Draft")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_ISO_Status_is_Draft()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Referback")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_ISO_Status_is_Referback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Auto Referback")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_ISO_Status_AutoReferback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedonEditbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Approved")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_ISO_Status_is_Approved()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create , Edit and View buttons in the ISO Onboarding when the status is Rejected")
		public void shouldbeable_to_see_the_Create_and_View_buttons_in_the_ISO_Onboarding_when_the_status_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close buttons in the ISO Onboarding when the status is Rejected")
		public void Should_not_be_able_to_see_the_Editand_Closebuttons_intheISOOnboarding_whenthestatus_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create,Edit and View buttons in the ISO Onboarding when the status is CLosed")
		public void shouldbeable_to_see_the_Create_Edit_and_View_buttons_in_the_ISO_Onboarding_when_the_status_is_Closed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close button in the ISO Onboarding when the status is Closed")
		public void Should_not_be_able_to_see_the_Closebutton_intheISOOnboarding_whenthestatus_is_CLosed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is New")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheISOOnboarding_whenthestatusisNew()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is New")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_Onboarding() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is New")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_Onboarding()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Inprogress")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_OnboardingStatusisInprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Inprogress")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_OnboardingStatusis_Inprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Verified")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_OnboardingStatusisVerified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Verified")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_OnboardingStatusis_Verified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is Draft")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheISOOnboarding_whenthestatusisDraft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Draft")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_OnboardingStatus_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Draft")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_Onboarding_Status_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		//

		@Then("I should be able to see the Cancel and Save as Draft buttons in the ISO Onboarding when the status is Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheISOOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the ISO Onboarding when the status is Referback")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheISOOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_OnboardingStatus_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Referback")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_Onboarding_Status_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheISOOnboarding_whenthestatusisAutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Auto Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Auto Referback")
		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the ISO Onboarding when the status is Approved")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheISOOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the ISO Onboarding when the status is Approved")
		public void I_shouldnot_beabletoseetheSubmitforVerificationbutton_intheISOOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Approved")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_OnboardingStatus_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Approved")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_Onboarding_Status_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Rejected")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_OnboardingStatusisRejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Rejected")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_OnboardingStatusis_Rejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheISOOnboarding_whenthestatusisautoreferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the ISO Onboarding when the status is Closed")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheISOOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the ISO Onboarding when the status is Closed")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheISOOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the ISO Onboarding when the status is Closed")

		public void should_be_able_to_see_only_the_Cancel_buttonintheISO_OnboardingStatus_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Closed")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheISO_Onboarding_Status_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

	//SUBISO	

		@Given("I am searching in the SUBISO Onboarding with Status : New")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status :New")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();

			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status : Inprogress")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_Inprogress() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusInprogress();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status : Verified")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_Verified() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusVerified();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status : Draft")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_Draft() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusDraft();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status : Referback")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_Referback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status :Auto Referback")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_AutoReferback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusAutoReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status : Approved")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_Approved() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusApproved();

			S.Clickonapply();

		}

		@Given("I am searching in the SUBISO Onboarding with Status : Rejected")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_Rejected() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusRejected();

			S.Clickonapply();

			Thread.sleep(5000);

		}

		@Given("I am searching in the SUBISO Onboarding with Status : Closed")
		public void I_am_searching_in_the_SUBISO_Onbarding_with_Status_Closed() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnSUBISO();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusclosed();

			S.Clickonapply();

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is New")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_SUBISO_Status_is_New()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, and Close buttons in the SUBISO Onboarding when the status is Inprogress")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_SUBISO_Status_Inprogress()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the SUBISO Onboarding when the status is Inprogress")
		public void should_not_be_able_to_see_the_Edit_buttons_in_SUBISO_Status_Inprogress() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, and Close buttons in the SUBISO Onboarding when the status is Verified")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_SUBISO_Status_Verified()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the SUBISO Onboarding when the status is Verified")
		public void should_not_be_able_to_see_the_Edit_buttons_in_SUBISO_Status_Verified() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Draft")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_SUBISO_Status_is_Draft()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Referback")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_SUBISO_Status_is_Referback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Auto Referback")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_SUBISO_Status_AutoReferback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedonEditbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Approved")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_SUBISO_Status_is_Approved()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create , Edit and View buttons in the SUBISO Onboarding when the status is Rejected")
		public void shouldbeable_to_see_the_Create_and_View_buttons_in_the_SUBISO_Onboarding_when_the_status_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close buttons in the SUBISO Onboarding when the status is Rejected")
		public void Should_not_be_able_to_see_the_Editand_Closebuttons_intheSUBISOOnboarding_whenthestatus_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create,Edit and View buttons in the SUBISO Onboarding when the status is CLosed")
		public void shouldbeable_to_see_the_Create_Edit_and_View_buttons_in_the_SUBISO_Onboarding_when_the_status_is_Closed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close button in the SUBISO Onboarding when the status is Closed")
		public void Should_not_be_able_to_see_the_Closebutton_intheSUBISOOnboarding_whenthestatus_is_CLosed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is New")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheSUBISOOnboarding_whenthestatusisNew()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is New")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_Onboarding() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is New")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_Onboarding()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Inprogress")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_OnboardingStatusisInprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Inprogress")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_OnboardingStatusis_Inprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Verified")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_OnboardingStatusisVerified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Verified")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_OnboardingStatusis_Verified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is Draft")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheSUBISOOnboarding_whenthestatusisDraft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Draft")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_OnboardingStatus_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Draft")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_Onboarding_Status_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		//

		@Then("I should be able to see the Cancel and Save as Draft buttons in the SUBISO Onboarding when the status is Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheSUBISOOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the SUBISO Onboarding when the status is Referback")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheSUBISOOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_OnboardingStatus_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Referback")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_Onboarding_Status_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheSUBISOOnboarding_whenthestatusisAutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Auto Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Auto Referback")
		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the SUBISO Onboarding when the status is Approved")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheSUBISOOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the SUBISO Onboarding when the status is Approved")
		public void I_shouldnot_beabletoseetheSubmitforVerificationbutton_intheSUBISOOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Approved")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_OnboardingStatus_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Approved")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_Onboarding_Status_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Rejected")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_OnboardingStatusisRejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Rejected")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_OnboardingStatusis_Rejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheSUBISOOnboarding_whenthestatusisautoreferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the SUBISO Onboarding when the status is Closed")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheSUBISOOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the SUBISO Onboarding when the status is Closed")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheSUBISOOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Closed")

		public void should_be_able_to_see_only_the_Cancel_buttonintheSUBISO_OnboardingStatus_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Closed")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheSUBISO_Onboarding_Status_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

	//GroupMerchant

		@Given("I am searching in the GroupMerchant Onboarding with Status : New")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status :New")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();

			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status : Inprogress")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_Inprogress() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusInprogress();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status : Verified")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_Verified() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnGM();
			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusVerified();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status : Draft")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_Draft() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusDraft();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status : Referback")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_Referback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status :Auto Referback")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_AutoReferback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusAutoReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status : Approved")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_Approved() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusApproved();

			S.Clickonapply();

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status : Rejected")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_Rejected() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusRejected();

			S.Clickonapply();

			Thread.sleep(5000);

		}

		@Given("I am searching in the GroupMerchant Onboarding with Status : Closed")
		public void I_am_searching_in_the_GroupMerchant_Onbarding_with_Status_Closed() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnGM();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusclosed();

			S.Clickonapply();

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is New")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_GroupMerchant_Status_is_New()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, and Close buttons in the GroupMerchant Onboarding when the status is Inprogress")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_GroupMerchant_Status_Inprogress()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the GroupMerchant Onboarding when the status is Inprogress")
		public void should_not_be_able_to_see_the_Edit_buttons_in_GroupMerchant_Status_Inprogress()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, and Close buttons in the GroupMerchant Onboarding when the status is Verified")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_GroupMerchant_Status_Verified()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the GroupMerchant Onboarding when the status is Verified")
		public void should_not_be_able_to_see_the_Edit_buttons_in_GroupMerchant_Status_Verified()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Draft")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_GroupMerchant_Status_is_Draft()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Referback")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_GroupMerchant_Status_is_Referback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Auto Referback")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_GroupMerchant_Status_AutoReferback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedonEditbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Approved")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_GroupMerchant_Status_is_Approved()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create , Edit and View buttons in the GroupMerchant Onboarding when the status is Rejected")
		public void shouldbeable_to_see_the_Create_and_View_buttons_in_the_GroupMerchant_Onboarding_when_the_status_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close buttons in the GroupMerchant Onboarding when the status is Rejected")
		public void Should_not_be_able_to_see_the_Editand_Closebuttons_intheGroupMerchantOnboarding_whenthestatus_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create,Edit and View buttons in the GroupMerchant Onboarding when the status is CLosed")
		public void shouldbeable_to_see_the_Create_Edit_and_View_buttons_in_the_GroupMerchant_Onboarding_when_the_status_is_Closed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close button in the GroupMerchant Onboarding when the status is Closed")
		public void Should_not_be_able_to_see_the_Closebutton_intheGroupMerchantOnboarding_whenthestatus_is_CLosed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is New")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheGroupMerchantOnboarding_whenthestatusisNew()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is New")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_Onboarding()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is New")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_Onboarding()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Inprogress")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_OnboardingStatusisInprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Inprogress")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_OnboardingStatusis_Inprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Verified")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_OnboardingStatusisVerified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Verified")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_OnboardingStatusis_Verified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Draft")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheGroupMerchantOnboarding_whenthestatusisDraft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Draft")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_OnboardingStatus_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Draft")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_Onboarding_Status_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		//

		@Then("I should be able to see the Cancel and Save as Draft buttons in the GroupMerchant Onboarding when the status is Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheGroupMerchantOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the GroupMerchant Onboarding when the status is Referback")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheGroupMerchantOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_OnboardingStatus_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Referback")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_Onboarding_Status_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheGroupMerchantOnboarding_whenthestatusisAutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Auto Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Auto Referback")
		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the GroupMerchant Onboarding when the status is Approved")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheGroupMerchantOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the GroupMerchant Onboarding when the status is Approved")
		public void I_shouldnot_beabletoseetheSubmitforVerificationbutton_intheGroupMerchantOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Approved")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_OnboardingStatus_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Approved")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_Onboarding_Status_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Rejected")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_OnboardingStatusisRejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Rejected")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_OnboardingStatusis_Rejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheGroupMerchantOnboarding_whenthestatusisautoreferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the GroupMerchant Onboarding when the status is Closed")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheGroupMerchantOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the GroupMerchant Onboarding when the status is Closed")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheGroupMerchantOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Closed")

		public void should_be_able_to_see_only_the_Cancel_buttonintheGroupMerchant_OnboardingStatus_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Closed")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheGroupMerchant_Onboarding_Status_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

	//Merchant

		@Given("I am searching in the Merchant Onboarding with Status : New")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status :New")
		public void I_am_searching_in_the_Merchant_Onbarding_with_status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();

			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status : Inprogress")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_Inprogress() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusInprogress();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status : Verified")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_Verified() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusVerified();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status : Draft")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_Draft() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusDraft();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status : Referback")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_Referback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status :Auto Referback")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_AutoReferback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusAutoReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status : Approved")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_Approved() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusApproved();

			S.Clickonapply();

		}

		@Given("I am searching in the Merchant Onboarding with Status : Rejected")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_Rejected() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusRejected();

			S.Clickonapply();

			Thread.sleep(5000);

		}

		@Given("I am searching in the Merchant Onboarding with Status : Closed")
		public void I_am_searching_in_the_Merchant_Onbarding_with_Status_Closed() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnMerchant();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusclosed();

			S.Clickonapply();

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is New")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Merchant_Status_is_New()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, and Close buttons in the Merchant Onboarding when the status is Inprogress")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Merchant_Status_Inprogress()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the Merchant Onboarding when the status is Inprogress")
		public void should_not_be_able_to_see_the_Edit_buttons_in_Merchant_Status_Inprogress() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, and Close buttons in the Merchant Onboarding when the status is Verified")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Merchant_Status_Verified()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the Merchant Onboarding when the status is Verified")
		public void should_not_be_able_to_see_the_Edit_buttons_in_Merchant_Status_Verified() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Draft")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Merchant_Status_is_Draft()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Referback")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Merchant_Status_is_Referback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Auto Referback")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Merchant_Status_AutoReferback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedonEditbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Approved")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Merchant_Status_is_Approved()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create , Edit and View buttons in the Merchant Onboarding when the status is Rejected")
		public void shouldbeable_to_see_the_Create_and_View_buttons_in_the_Merchant_Onboarding_when_the_status_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close buttons in the Merchant Onboarding when the status is Rejected")
		public void Should_not_be_able_to_see_the_Editand_Closebuttons_intheMerchantOnboarding_whenthestatus_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create,Edit and View buttons in the Merchant Onboarding when the status is CLosed")
		public void shouldbeable_to_see_the_Create_Edit_and_View_buttons_in_the_Merchant_Onboarding_when_the_status_is_Closed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close button in the Merchant Onboarding when the status is Closed")
		public void Should_not_be_able_to_see_the_Closebutton_intheMerchantOnboarding_whenthestatus_is_CLosed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is New")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheMerchantOnboarding_whenthestatusisNew()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is New")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_Onboarding() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is New")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_Onboarding()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Inprogress")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_OnboardingStatusisInprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Inprogress")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_OnboardingStatusis_Inprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Verified")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_OnboardingStatusisVerified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Verified")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_OnboardingStatusis_Verified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is Draft")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheMerchantOnboarding_whenthestatusisDraft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Draft")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_OnboardingStatus_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Draft")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_Onboarding_Status_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		//

		@Then("I should be able to see the Cancel and Save as Draft buttons in the Merchant Onboarding when the status is Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheMerchantOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the Merchant Onboarding when the status is Referback")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheMerchantOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_OnboardingStatus_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Referback")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_Onboarding_Status_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheMerchantOnboarding_whenthestatusisAutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Auto Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Auto Referback")
		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the Merchant Onboarding when the status is Approved")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheMerchantOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the Merchant Onboarding when the status is Approved")
		public void I_shouldnot_beabletoseetheSubmitforVerificationbutton_intheMerchantOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Approved")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_OnboardingStatus_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Approved")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_Onboarding_Status_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Rejected")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_OnboardingStatusisRejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Rejected")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_OnboardingStatusis_Rejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheMerchantOnboarding_whenthestatusisautoreferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the Merchant Onboarding when the status is Closed")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheMerchantOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the Merchant Onboarding when the status is Closed")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheMerchantOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Merchant Onboarding when the status is Closed")

		public void should_be_able_to_see_only_the_Cancel_buttonintheMerchant_OnboardingStatus_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Closed")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheMerchant_Onboarding_Status_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

	//Terminal

		@Given("I am searching in the Terminal Onboarding with Status : New")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status :New")
		public void I_am_searching_in_the_Terminal_Onbarding_with_status_New() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();

			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusNew();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status : Inprogress")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_Inprogress() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusInprogress();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status : Verified")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_Verified() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusVerified();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status : Draft")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_Draft() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusDraft();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status : Referback")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_Referback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status :Auto Referback")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_AutoReferback() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();
			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusAutoReferback();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status : Approved")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_Approved() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusApproved();

			S.Clickonapply();

		}

		@Given("I am searching in the Terminal Onboarding with Status : Rejected")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_Rejected() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusRejected();

			S.Clickonapply();

			Thread.sleep(5000);

		}

		@Given("I am searching in the Terminal Onboarding with Status : Closed")
		public void I_am_searching_in_the_Terminal_Onbarding_with_Status_Closed() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			S.ClickOnOnboarding();
			S.ClickOnTerminal();

			S.ClickOnMoreFilter();

			S.ClickOnFilterByStatus();

			S.SelectOnStatusclosed();

			S.Clickonapply();

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is New")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Terminal_Status_is_New()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, and Close buttons in the Terminal Onboarding when the status is Inprogress")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Terminal_Status_Inprogress()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the Terminal Onboarding when the status is Inprogress")
		public void should_not_be_able_to_see_the_Edit_buttons_in_Terminal_Status_Inprogress() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, and Close buttons in the Terminal Onboarding when the status is Verified")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Terminal_Status_Verified()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should not be able to see the Edit button in the Terminal Onboarding when the status is Verified")
		public void should_not_be_able_to_see_the_Edit_buttons_in_Terminal_Status_Verified() throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnEditbutton();

			Thread.sleep(3000);

		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Draft")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Terminal_Status_is_Draft()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Referback")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Terminal_Status_is_Referback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Auto Referback")
		public void should_be_able_to_see_the_Create_View_and_Close_buttons_in_Terminal_Status_AutoReferback()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedOnViewbutton();

			S.DisplayedonEditbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Approved")
		public void should_be_able_to_see_the_Create_View_Edit_and_Close_buttons_in_Terminal_Status_is_Approved()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			S.DisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create , Edit and View buttons in the Terminal Onboarding when the status is Rejected")
		public void shouldbeable_to_see_the_Create_and_View_buttons_in_the_Terminal_Onboarding_when_the_status_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close buttons in the Terminal Onboarding when the status is Rejected")
		public void Should_not_be_able_to_see_the_Editand_Closebuttons_intheTerminalOnboarding_whenthestatus_is_Rejected()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);
		}

		@Then("Should be able to see the Create,Edit and View buttons in the Terminal Onboarding when the status is CLosed")
		public void shouldbeable_to_see_the_Create_Edit_and_View_buttons_in_the_Terminal_Onboarding_when_the_status_is_Closed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCreatebutton();

			S.ActionClick();

			S.DisplayedonEditbutton();

			S.DisplayedOnViewbutton();

			Thread.sleep(3000);

		}

		@Then("Should not be able to see the Close button in the Terminal Onboarding when the status is Closed")
		public void Should_not_be_able_to_see_the_Closebutton_intheTerminalOnboarding_whenthestatus_is_CLosed()
				throws InterruptedException {
			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnClosebutton();

			Thread.sleep(3000);

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is New")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheTerminalOnboarding_whenthestatusisNew()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is New")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_Onboarding() throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is New")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_Onboarding()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Inprogress")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_OnboardingStatusisInprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Inprogress")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_OnboardingStatusis_Inprogress()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Verified")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_OnboardingStatusisVerified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Verified")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_OnboardingStatusis_Verified()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is Draft")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheTerminalOnboarding_whenthestatusisDraft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Draft")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_OnboardingStatus_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Draft")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_Onboarding_Status_Draft()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		//

		@Then("I should be able to see the Cancel and Save as Draft buttons in the Terminal Onboarding when the status is Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheTerminalOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the Terminal Onboarding when the status is Referback")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheTerminalOnboarding_whenthestatusisReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_OnboardingStatus_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Referback")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_Onboarding_Status_Referback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheTerminalOnboarding_whenthestatusisAutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Auto Referback")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Auto Referback")
		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_Onboarding_AutoReferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the Terminal Onboarding when the status is Approved")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheTerminalOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the Terminal Onboarding when the status is Approved")
		public void I_shouldnot_beabletoseetheSubmitforVerificationbutton_intheTerminalOnboarding_whenthestatusisApproved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Approved")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_OnboardingStatus_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Approved")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_Onboarding_Status_Approved()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Rejected")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_OnboardingStatusisRejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Rejected")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_OnboardingStatusis_Rejected()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is Auto Referback")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheTerminalOnboarding_whenthestatusisautoreferback()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

			S.DisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see the Cancel and Save as Draft buttons in the Terminal Onboarding when the status is Closed")
		public void I_should_beabletoseetheCancelSaveasDraftand_SubmitforVerificationbuttons_intheTerminalOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			S.DisplayedOnSaveasdraftbutton();

		}

		@Then("I Should not be able to see the Submit for Verification button in the Terminal Onboarding when the status is Closed")
		public void I_should_beabletoseetheSubmitforVerificationbutton_intheTerminalOnboarding_whenthestatusisClosed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnsubmitforverificationbutton();

			Thread.sleep(3000);

			S.ClickOnCancel();

			Thread.sleep(2000);

			S.ClickOnOnboarding();

		}

		@Then("I should be able to see only the Cancel button in the Terminal Onboarding when the status is Closed")

		public void should_be_able_to_see_only_the_Cancel_buttonintheTerminal_OnboardingStatus_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.DisplayedOnCancelbutton();

			Thread.sleep(3000);
		}

		@Then("I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Closed")

		public void Should_notbe_able_toseethe_SaveasDraft_and_SubmitforVerificationbuttonsintheTerminal_Onboarding_Status_Closed()
				throws InterruptedException {

			S = new org.Locators.SystemUserLocatores(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			S.NOTDisplayedOnSaveasdraftbutton();

			S.NOTDisplayedOnsubmitforverificationbutton();

			S.ClickOnCancel();

			Thread.sleep(3000);

			S.ClickOnOnboarding();

		}
		
//System Verifier
		
		@Given("I visit the System Verifier Login using sheetname {string} and rownumber {int}")
		public void i_visit_the_System_Verifier_login(String sheetName, int rowNumber)
				throws InvalidFormatException, IOException, InterruptedException {

			 

			 List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String userName = testdata.get(rowNumber).get("UserName");
			String password = testdata.get(rowNumber).get("Password");

			L = new org.Locators.LoginLocators(driver);

			L.EnterOnUsername(userName);

			L.EnterOnPassword(password);

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + userName
					+ "</td><td style='border: 1px solid black;color: black'>" + password + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "UserName", "Password" }, { userName, password },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

		}
		
		
//System Approver		
		@Given("I visit the System Approver Login using sheetname {string} and rownumber {int}")
		public void i_visit_the_System_approver_login(String sheetName, int rowNumber)
				throws InvalidFormatException, IOException, InterruptedException {


			 List<Map<String, String>> testdata = cache.getCachedData(sheetName);
			 
			System.out.println("sheet name: " + testdata);

			String userName = testdata.get(rowNumber).get("UserName");
			String password = testdata.get(rowNumber).get("Password");

			L = new org.Locators.LoginLocators(driver);

			L.EnterOnUsername(userName);

			L.EnterOnPassword(password);

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + userName
					+ "</td><td style='border: 1px solid black;color: black'>" + password + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "UserName", "Password" }, { userName, password },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

		}



}