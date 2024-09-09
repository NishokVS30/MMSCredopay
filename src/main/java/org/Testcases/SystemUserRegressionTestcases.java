package org.Testcases;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class SystemUserRegressionTestcases {

	private WebDriver driver;

	org.Locators.BankLocators B;
	org.Locators.SystemUserLocatores S;
	org.Locators.AggregatorLocators A;
	org.Locators.ISOLocators ISO;

	public SystemUserRegressionTestcases() {
		this.driver = CustomWebDriverManager.getDriver();
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}

	private ExtentTest test;

	@When("System Maker - Onboarding should be displayed in the side menu")
	public void I_Visit_System_Maker_Onboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		S.ClickOnDownArrow();

		B.ClickOnOnboarding();

	}

	@Then("the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Maker_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.DisplayedOnbank();

		B.DisplayedOnPayfac();

		B.DisplayedOnISO();

		B.DisplayedOnSUBISO();

		Thread.sleep(2000);

		B.DisplayedOnGM();

		B.DisplayedOnMerchant();

		B.DisplayedOnTerminal();

	}

	@When("the SystemMaker clicks the bank module")
	public void SystemMakerClicktheBankModule() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnBank();

	}

	@When("the SystemMaker clicks the Create Button")
	public void the_SystemMaker_clicks_theCreateButton() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnCreate();

	}

	@Then("the \"Bank Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void Bank_name_field_should_prompt_to_enter_valid_inputs_within_30_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {
try {
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(3000);

		B.ClickonBankName();

		B.clearBankName();

		B.EnteronBankName(Bankname);

		String enteredBankName = B.getBankName();

		LoginInputDatas("Bank Name", Bankname);

		assertTrue("Bank Name field does not accept valid input within 30 characters.", enteredBankName.length() <= 30);

		Thread.sleep(2000);

	     performTabKeyPress();
		
	    } catch (Exception e) {
	        takeScreenshotStr("General Info"); // Take screenshot on exception
	        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
	        throw e; // Re-throw to ensure the test fails
	    }

	}

	@Then("the \"Address\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theAddress_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

try {
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Address = testdata.get(rowNumber).get("Address");

		System.out.println("0" + testdata.get(0));

		B.EnterOnAddress(Address);

		Thread.sleep(2000);

		performTabKeyPress();
		
		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Address", Address);
		
	 } catch (Exception e) {
	        takeScreenshotStr("General Info"); // Take screenshot on exception
	        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
	        throw e; // Re-throw to ensure the test fails
	    }


	}

	@Then("the \"Domain\" field should prompt to enter the valid domain name using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String domain = testdata.get(rowNumber).get("Domain");

		Thread.sleep(1000);

		B.ClickOnDomain();

		B.EnterOnDomain(domain);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Domain", domain);

	}

	@Then("the \"NextStep\" button should be prompted to click on General Info")
	public void the_nextstep_button_shouldbe_prompted_toClickonGeneralInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		Thread.sleep(1000);
       try {
		B.ClickOnNextStep();
		
		Thread.sleep(1000);
		
		B.DisplayedOnAdminuserdetails();
		
		

	  } catch (AssertionError ae) {
	        takeScreenshotStr("Bank"); // Take screenshot on assertion error
	        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
	        throw ae;
	  }

	}

	@Then("The \"NextStep\" button should prompt a click on Communication Info")
	public void the_nextstep_button_shouldbe_prompted_toClickonCommInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		test = ExtentCucumberAdapter.getCurrentStep();
		test.info("Scenario running on environment: ");

		Thread.sleep(1000);
    try {
		B.ClickOnNextStep();
		
		B.DisplayedOnChannelConfiguration();
		
	  } catch (AssertionError ae) {
	        takeScreenshotStr("Aggregator"); // Take screenshot on assertion error
	        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
	        throw ae;
	  }

	}
	
	@Then("the Channel Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}")
	public void processAllData(String sheetName)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {

	    // Initialize BankLocators only once
	    B = new org.Locators.BankLocators(driver);

	    // Set implicit wait for the driver
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	    // Set the Excel file path and sheet name
	    ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\git\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
	            sheetName);

	    // Get the total number of non-empty rows
	    int numberOfRows = ExcelUtils.getRowCount(sheetName);
	    System.out.println("Total rows found: " + numberOfRows);

	    // Loop through all the rows
	    for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
	        System.out.println("Running test for row number: " + currentRow);
	    	ArrayList<String> key = new ArrayList<>();
	    	ArrayList<String> value = new ArrayList<>();
	    	


	        // Fetch the current row's data
	        Map<String, String> testData = ExcelUtils.getRowData(sheetName, currentRow);
	        System.out.println("Test data: " + testData);

	        // Retrieve data from the row for each field, handling null values
	        String channel = testData.get("Channel");
	        String network = testData.get("Network");
	        String transactionSet = testData.get("Transaction Sets");
	        String routing = testData.get("Routing");
	        

	        // Check if any of the data fields are null or empty and skip that field
	        if (channel != null && !channel.trim().isEmpty()) {
//	            B.CLickOnChannelConfig(); // Open the channel config
	            Thread.sleep(2000); // Wait to ensure page elements load properly
	            B.ChannelADD(); // Click 'Add' button for the channel
	            B.clickonChannel(); // Click on the channel dropdown

	            Thread.sleep(2000); 
	            // Select the channel based on the Excel value (e.g., POS, AEPS, etc.)
	            B.selectDropdownOption(channel);
//	            LoginInputDatas("Channel-" + currentRow, channel);
		    	key.add("Channel-" + currentRow);
		    	value.add(channel);
	            
	            performTabKeyPress();
	            // Log input data for the channel
	        } else {
	            System.out.println("Channel data is null or empty for row: " + currentRow);
	        }

	        if (network != null && !network.trim().isEmpty()) {
	            // Network selection
	            B.clickonNetwork(); // Click on the network dropdown
	            B.selectDropdownOption(network); // Select network from Excel
//	            LoginInputDatas("Network-" + currentRow, network); 
	            
	            key.add("Network-" + currentRow);
		    	value.add(network);
	            
	            performTabKeyPress();
	            // Log input data for the network
	        } else {
	            System.out.println("Network data is null or empty for row: " + currentRow);
	        }

	        if (transactionSet != null && !transactionSet.trim().isEmpty()) {
	            // Transaction Set selection
	            B.clickonTransactionsetPoS(); // Click on the transaction set dropdown
	            B.selectDropdownOption(transactionSet); // Select transaction set from Excel
//	            LoginInputDatas("Transaction Set-" + currentRow, transactionSet);
	            key.add("Transaction Set-" + currentRow);
		    	value.add(transactionSet);
	            performTabKeyPress();
	            // Log input data for transaction set
	        } else {
	            System.out.println("Transaction Set data is null or empty for row: " + currentRow);
	        }

	        if (routing != null && !routing.trim().isEmpty()) {
	            // Routing selection
	            B.clickonRouting(); // Click on the routing dropdown
	            B.selectDropdownOption(routing); // Select routing from Excel
//	            LoginInputDatas("Routing-" + currentRow, routing);
	            key.add("Routing-" + currentRow);
		    	value.add(routing);
	            performTabKeyPress();
	            // Log input data for routing
	        } else {
	            System.out.println("Routing data is null or empty for row: " + currentRow);
	        }
 
	        // Save the configuration (Only after filling all required fields)
	        B.CommuSavebutton();
	        LoginInputData(key,value);
	    }
	}
	



	@Then("the Settlement Info \"Channel\" dropdown should prompt to select the valid inputs")
	public void SettlementInfo_channel_dropdown_Should_Prompt_toSelect_ValidInputs() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnSettlementChannel();

		Thread.sleep(2000);

		B.SelectOnSettlementChannelPOS();
		
		String selectOnSettlementChannelPOS = B.getSelectOnSettlementChannelPOS();
		
		LoginInputDatas("Settlement Channel", selectOnSettlementChannelPOS);


	}

	@Then("the Settlement Info \"Account Type\" dropdown should prompt to select the valid inputs")
	public void SettlementInfo_AccountType_dropdown_Should_Prompt_toSelect_ValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnSettlementAccountType();

		B.SelectOnSettlementAccountTypeCurrent();
		
        String SelectOnSettlementAccountTypeCurrent = B.getSelectOnSettlementAccountTypeCurrent();
		
		LoginInputDatas("Settlement Account Type", SelectOnSettlementAccountTypeCurrent);


	}

	@When("the System Maker clicks the \"Submit for verification\" button in Bank Onboarding")
	public void the_SystemMaker_ClickThe_Submitforverification_button_inBankOnboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnsubmitforverification();

	}

	@When("the System Maker clicks the \"Yes\" button to confirm submission in Bank Onboarding")
	public void the_SystemMaker_clicksthe_Yes_buttonto_confirm_submissionin_BankOnboarding()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		B.Yesforsubmit();

		Thread.sleep(5000);

		B.OkforSuccessfully();

	}

	@When("the System Maker clicks on the profile and log-out button")
	public void the_SystemMaker_clicksontheprofileand_log_out_button() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(5000);

		B.LogoutProfile();

		Thread.sleep(2000);

		B.Logoutbutton();

	}

	@When("the System Maker handles the pop-up by selecting the \"Yes\" button and redirected to login page")
	public void the_SystemMaker_handles_thePopUp_by_selecting_YES_button() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.LogoutYESbutton();

	}

//System Verifier - Bank

	@When("System Verifier - Onboarding should be displayed in the side menu")
	public void System_Verifier_Onboarding_should_be_displayed_intheside_menu() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		S.ClickOnDownArrow();

		B.ClickOnVerifierOnboarding();
	}

	@Then("the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Verifier_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.DisplayedOnbank();

		B.DisplayedOnPayfac();

		B.DisplayedOnISO();

		B.DisplayedOnSUBISO();

		Thread.sleep(2000);

		B.DisplayedOnGM();

		B.DisplayedOnMerchant();

		B.DisplayedOnTerminal();

	}

	@When("the System Verifier clicks the bank module")
	public void the_SystemVerifier_Clicks_the_bank_Module() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnBank();

	}

//	@When("the System Verifier clicks the Create Button")
//	public void the_SystemVerifier_clicks_theCreateButton() {
//
//		B = new org.Locators.BankLocators(driver);
//
//		S = new org.Locators.SystemUserLocatores(driver);
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		
//		S.ClickOnCreate();
//
//	}

	@When("the System Verifier ensure the bank status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_System_Verifier_Ensure_the_BankStatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(4000);

		B.ClickSearchbyBankName();

		Thread.sleep(2000);

		B.SearchbyBankName(Bankname);

		Thread.sleep(2000);

	}

	@When("the System Verifier click on action Three dot button and select the view option")
	public void theSystem_Verifierclick_onaction_Threedot_button_and_selecttheview_option()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.ActionClick();

		Thread.sleep(4000);

		S.clickonView();

	}

	@When("the System Verifier checks \"General Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_General_Info_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickOnGenralInfo();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Communication Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_CommunicationInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickOnCommunicationInfo();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Channel Config\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_ChannelConfig_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickOnChannelConfig();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"ONUS Routing\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_ONUSRouting_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Global FRM\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_GlobalFRM_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickOnglobalfrm();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Commerical\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_Commerical_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnCommericial();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Settlement Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_SettlementInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnSettlementInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"WhiteLabel\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_WhiteLabel_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnWhiteLabel();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Webhooks\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_Webhooks_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnWebhooks();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"KYC\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_KYC_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnKYC();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System verifier clicks the \"Submit for Approval\" button in Bank Onboarding")
	public void the_Systemverifier_ClickThe_Submitforapproval_button_inBankOnboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.SubmitforApproval();

	}

	@When("the System verifier clicks the \"Yes\" button to confirm submission in Bank Onboarding")
	public void the_Systemverifier_clicksthe_Yes_buttonto_confirm_submissionin_BankOnboarding()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		B.Yesforsubmit();

		Thread.sleep(5000);

		B.OkforSuccessfully();

	}

	@When("the System verifier clicks on the profile and log-out button")
	public void the_Systemverifier_clicksontheprofileand_log_out_button() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(5000);

		B.LogoutProfile();

		Thread.sleep(2000);

		B.Logoutbutton();

	}

	@When("the System verifier handles the pop-up by selecting the \"Yes\" button and redirected to login page")
	public void the_Systemverifier_handles_thePopUp_by_selecting_YES_button() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.LogoutYESbutton();

	}

	@When("System Approver - Onboarding should be displayed in the side menu")
	public void System_Approver_Onboarding_should_be_displayed_intheside_menu() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		S.ClickOnDownArrow();

		B.ClickOnVerifierOnboarding();
	}

	@Then("the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Approver_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.DisplayedOnbank();

		B.DisplayedOnPayfac();

		B.DisplayedOnISO();

		B.DisplayedOnSUBISO();

		Thread.sleep(2000);

		B.DisplayedOnGM();

		B.DisplayedOnMerchant();

		B.DisplayedOnTerminal();
	}

	@When("the System Approver clicks the bank module")
	public void the_SystemApprover_Clicks_the_bank_Module() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnBank();

	}

	@When("the System Approver ensure the bank status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_System_Approver_Ensure_the_BankStatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(4000);

		B.ClickSearchbyBankName();

		Thread.sleep(3000);

		B.SearchbyBankName(Bankname);

		Thread.sleep(2000);

//		Robot r = new Robot();
//
//		r.keyPress(KeyEvent.VK_ENTER);
//
//		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@When("the System Approver click on action Three dot button and select the view option")
	public void theSystem_Approverclick_onaction_Threedot_button_and_selecttheview_option()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.ActionClick();

		Thread.sleep(4000);

		S.clickonView();

	}

	@When("the System Approver check if \"General Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_GeneralInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.CLickOnGenralInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"Communication Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_CommunicationInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.CLickOnCommunicationInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"Channel Config\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_ChannelConfig_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.CLickOnChannelConfig();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"ONUS Routing\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_ONUSRouting_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"Global FRM\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_GlobalFRM_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.CLickOnglobalfrm();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"Commercial\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_Commercial_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickOnCommericial();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"Settlement Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_SettlementInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickOnSettlementInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"Whitelabel\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_Whitelabel_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickOnWhiteLabel();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"Webhooks\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_Webhooks_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickOnWebhooks();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver check if \"KYC\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_KYC_isverified_andclicks_the_NextStepbutton() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickOnKYC();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}

	@When("the System Approver clicks the \"Submit for Approve\" button in Bank Onboarding")
	public void the_SystemApprover_ClickThe_Submitforapprove_button_inBankOnboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnApprove();

	}

	@When("the System Approver clicks the \"Yes\" button to confirm submission in Bank Onboarding")
	public void the_SystemvApprover_clicksthe_Yes_buttonto_confirm_submissionin_BankOnboarding()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		B.Yesforsubmit();

		Thread.sleep(5000);

		B.OkforSuccessfully();

	}

	@When("the System Approver clicks on the profile and log-out button")
	public void the_Systemapprover_clicksontheprofileand_log_out_button() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(5000);

		B.LogoutProfile();

		Thread.sleep(2000);

		B.Logoutbutton();

	}

	@When("the System Approver handles the pop-up by selecting the \"Yes\" button and redirected to login page")
	public void the_SystemApprover_handles_thePopUp_by_selecting_YES_button() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.LogoutYESbutton();

	}

	@When("Verify that Bank CPID is displayed correctly on the \"Bank Onboarding List page\" using sheetname {string} and rownumber {int}")
	public void Verify_thatBankCPID_isdisplayedcorrectly_onthe_BankOnboarding_Listpage(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(3000);

		B.CancelApprove();

		Thread.sleep(4000);

		B.ClickSearchbyBankName();

		Thread.sleep(2000);

		B.SearchbyBankName(Bankname);

		Thread.sleep(2000);

		B.ActionClick();

		S.clickonView();

		String cpid = B.getCPID();

		LoginInputDatas("Bank CPID", cpid);

	}

//Aggregator

	@When("the SystemMaker clicks the Aggregator module")
	public void SystemMakerClicktheAggregatorModule() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnPayfac();

	}

	// SystemVerifier-Aggregator

	@When("the System Verifier clicks the Aggregator module")
	public void the_SystemVerifier_Clicks_the_Aggregator_Module() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnPayfac();

	}

	@When("the System Verifier ensure the Aggregator status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemVerifier_ensure_the_bankstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Aggrename = testdata.get(rowNumber).get("Legal Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(4000);

		B.ClickSearchbyBankName();

		Thread.sleep(2000);

		B.SearchbyBankName(Aggrename);

		Thread.sleep(2000);

		LoginInputDatas("Search by Aggregator Name", Aggrename);

	}

	@When("the System Verifier checks \"Sales Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_SalesInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnSalesInfo();

		Thread.sleep(4000);
		
		A.ClickOnManualTakeOver();
			
		Thread.sleep(4000);
		
        B.Yesforsubmit();		

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Company Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_CompanyInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnCompanyInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Personal Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_PersonalInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnPersonalInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Risk Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_RiskInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnRiskInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"Discount Rate\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_Discount_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnDiscountRate();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

	}

	@When("the System Verifier checks \"KYC\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons in Aggregator")
	public void theSystem_Verifierchecks_KYC_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons_Aggregator()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnKYC();

		Thread.sleep(4000);

		A.ClickOnViewDocument1();

		Thread.sleep(2000);

		A.ClickonActionDiscountRate();

		Thread.sleep(2000);

		A.ViewDocumentVerified();

		Thread.sleep(2000);

		A.ViewDocumentSubmitandNext();

		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_ESCAPE);
		
		r.keyRelease(KeyEvent.VK_ESCAPE);


		Thread.sleep(4000);

		A.ClickOnViewDocument2();

		Thread.sleep(2000);

		A.ClickonActionDiscountRate();

		Thread.sleep(2000);

		A.ViewDocumentVerified();

		Thread.sleep(2000);

		A.ViewDocumentSubmitandNext();

		Thread.sleep(2000);

		A.ClickonActionDiscountRate();

		Thread.sleep(2000);

		A.ViewDocumentVerified();

		Thread.sleep(2000);

		A.ViewDocumentSubmitandNext();

	    r.keyPress(KeyEvent.VK_ESCAPE);
		
		r.keyRelease(KeyEvent.VK_ESCAPE);

		Thread.sleep(2000);

	}
	
//Approver	
	
	@When("the System Approver clicks the Aggregator module")
	public void the_SystemApprover_Clicks_the_Aggregator_Module() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnPayfac();

	}

	@When("the System Approver ensure the Aggregator status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemApprover_ensure_the_bankstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Aggrename = testdata.get(rowNumber).get("Legal Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(4000);

		B.ClickSearchbyBankName();

		Thread.sleep(2000);

		B.SearchbyBankName(Aggrename);

		Thread.sleep(2000);

		LoginInputDatas("Search by Aggregator Name", Aggrename);

	}
	
	
	@When("the System Approver check if \"Sales Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_SalesInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		
		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnSalesInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}
	
	@When("the System Approver check if \"Company Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_CompanyInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		
		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnCompanyInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}
	
	@When("the System Approver check if \"Personal Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_personalInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		
		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnPersonalInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}
	
	@When("the System Approver check if \"Risk Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_riskInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		
		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnRiskInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}
	
	@When("the System Approver check if \"Discount Rate\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_DiscountRate_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		
		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnDiscountRate();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

	}
	
	@When("Verify that Aggregator CPID is displayed correctly on the \"Aggregator Onboarding List page\" using sheetname {string} and rownumber {int}")
	public void Verify_thatAggregatorCPID_isdisplayedcorrectly_onthe_AggregatorOnboarding_Listpage(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String LegalName = testdata.get(rowNumber).get("Legal Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(3000);

		B.CancelApprove();

		Thread.sleep(4000);

		B.ClickSearchbyBankName();

		Thread.sleep(2000);

		B.SearchbyBankName(LegalName);

		Thread.sleep(2000);

		B.ActionClick();

		S.clickonView();

		String cpid = B.getCPID();

		LoginInputDatas("Aggregator CPID", cpid);

	}
	
	
//ISO
	

	@When("the SystemMaker clicks the ISO module")
	public void SystemMakerClicktheISOModule() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnISO();

	}
	
	@When("the user select a valid date in the \"ISO Application Date\" field")
	public void theuser_select_avalid_date_inthe_ISO_ApplicationDate_field() throws AWTException, InterruptedException {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnAggreratorApplictionDate();
		
		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);


	}
	
	@Then("the \"Aggregator Name\" field should prompt to select the valid inputs using sheetname {string} and rownumber {int}")
	public void the_AggragatorCode_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);
		
		ISO = new org.Locators.ISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String code = testdata.get(rowNumber).get("Aggregator Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		ISO.ClickOnAggregatorName();

		ISO.EnterOnAggregatorName(code);
		
		Thread.sleep(2000);
		
		String da = "//span[contains(text(),'" + code + "')]";
		driver.findElement(By.xpath(da)).click();


//			Thread.sleep(2000);
//			Robot r = new Robot();
//	
//			r.keyPress(KeyEvent.VK_TAB);
//	
//			r.keyRelease(KeyEvent.VK_TAB);
//	
			B.NOTDisplayedOnInvalidFormat();

		
		LoginInputDatas("Aggregator Name", code);

	}

	
	@When("the user select a valid date in the \"Agreement Date\" field in ISO")
	public void theuser_select_avalid_date_inthe_AgreementDate_field() throws AWTException, InterruptedException {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnAggrementnDate();
		
		Thread.sleep(2000);
		 
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);


	}
	
	
	@When("the SystemMaker clicks the SUBSO module")
	public void SystemMakerClicktheSUBSOModule() {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnISO();

	}
	
	@Then("the \"Save\" button should be prompted to click on Company Info in ISO")
	public void the_savebutton_shouldbe_prompted_toclick_On_PersonalInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnSAVEPersonal();

		Thread.sleep(3000);

		B.OkforSuccessfully();
	}

	
	

	private void takeScreenshot(int rowNumber) {
	    try {
	        // Take a screenshot
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" + rowNumber + ".png";

	        // Save the screenshot to the specified path
	        FileUtils.copyFile(screenshot, new File(screenshotPath));

	        // Attach the screenshot to the Allure report
	        Allure.addAttachment("Screenshot for Row " + rowNumber, new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

	        // Attach the screenshot to the Extent report
	        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

	    } catch (IOException e) {
	        e.printStackTrace();
	        
	    }
	}
	
	private void takeScreenshotStr(String rowNumber) {
	    try {
	        // Take a screenshot
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" + rowNumber + ".png";

	        // Save the screenshot to the specified path
	        FileUtils.copyFile(screenshot, new File(screenshotPath));

	        // Attach the screenshot to the Allure report
	        Allure.addAttachment("Screenshot for Row " + rowNumber, new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

	        // Attach the screenshot to the Extent report
	        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

	    } catch (IOException e) {
	        e.printStackTrace();
	        
	    }
	}

	
	private void performTabKeyPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}	


	private void LoginInputDatas(String fieldName, String fieldValue) {

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldName + "</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldValue + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { fieldName }, { fieldValue }, };
		Markup m = MarkupHelper.createTable(data);

		// Log the table in Extent Report
		test.log(Status.PASS, m);
	}
	
	
	
	 public void LoginInputData(ArrayList<String> Keys, ArrayList<String> Values) {
		// Convert ArrayLists to arrays
		String[] keys = Keys.toArray(new String[0]);
		String[] values = Values.toArray(new String[0]);

		// Prepare data for Extent Report
		String[][] data = new String[2][keys.length];
		data[0] = keys; // Header row
		data[1] = values; // Data row

		// Create table markup and log to Extent Report
		Markup m = MarkupHelper.createTable(data);
		ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, m);

		// Construct HTML table for Allure report
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<table style='color: black; border: 1px solid black; border-collapse: collapse;'>");

		// Add header row
		tableBuilder.append("<tr>");
		for (String key : keys) {
			tableBuilder.append("<th style='border: 1px solid black; color: black;'>").append(key).append("</th>");
		}
		tableBuilder.append("</tr>");

		// Add data row
		tableBuilder.append("<tr>");
		for (String value : values) {
			tableBuilder.append("<td style='border: 1px solid black; color: black;'>").append(value).append("</td>");
		}
		tableBuilder.append("</tr>");

		tableBuilder.append("</table>");

		// Attach HTML table to Allure report
		Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(tableBuilder.toString().getBytes()),
				"html");
	}
	

}
