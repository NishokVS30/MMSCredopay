package org.Testcases;

import static org.junit.Assert.assertEquals;
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
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data.Datas;
import io.qameta.allure.Allure;

public class AggregatorOnboardingTestcases {

	private WebDriver driver;

	org.Locators.LoginLocators L;
	org.Locators.BankLocators B;
	org.Locators.AggregatorLocators A;
	org.Locators.SystemUserLocatores S;

	private ExtentTest test;
	
	ExcelDataCache cache = ExcelDataCache.getInstance();

	public AggregatorOnboardingTestcases() throws InterruptedException {

		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

		this.driver = CustomWebDriverManager.getDriver();

	}

	@Given("I visit the payfac onboarding page")

	public void I_visit_the_Payfac_Onboarding_Page() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnDownArrow();

			B.ClickOnOnboarding();

			B.ClickOnPayfac();

			B.ClickOnCreatebutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Aggregator Onboarding");
			throw e;
		}

	}

	@When("I Visit the Sales Info")
	public void SalesInfo() throws InterruptedException {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnSalesInfo();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Aggregator Onboarding");
			throw e;
		}

	}

	@Then("the First label name should be \"VAS Commission\"")
	public void the_label_name_should_be_VASCommission() throws InterruptedException {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnSalesInfo();

			A.VASCommissionLabelNameOne();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the First \"VAS Commission\" field should prompt to select Yes or No based on the given input using sheetname {string} and rownumber {int}")
	public void the_First_VAS_COmmission_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String VAS = testdata.get(rowNumber).get("VAS Commission");

			A.ClickOnVASCommisiionOne();

			B.selectDropdownOption(VAS);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("VAS Commission", VAS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the label name should be \"Aggregator Application Date\"")
	public void the_label_Name_Should_be_Aggrerator_Application_Date() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.AggregatorApplicationDateLabelName();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@When("the user select a valid date in the \"Aggregator Application Date\" field")
	public void theuser_select_avalid_date_inthe_Aggregator_ApplicationDate_field() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnAggreratorApplictionDate();
			A.ClickOnApply();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the label name should be \"Agreement Date\"")
	public void the_label_Name_Should_be_AgreementDate() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.AggreementDateLabelName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the label name should be \"Aggregator Code\"")
	public void the_label_nameshould_be_AggregatorCode() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.AggregatorCodeLabelName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@When("the user select a valid date in the \"Agreement Date\" field")
	public void theuser_select_avalid_date_inthe_Agrement_Date_field() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnAggrementnDate();
			A.ClickOnApply();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"Aggregator Code\" field should not allow to proceed without any input data")
	public void the_aggregatorCode_field_Should_not_allow_to_Proceed_Without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.ClickOnAggregatorCOde();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

//	@Then("the \"Aggregator Code\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
//	public void the_AggragatorCode_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//		try {
//
//			B = new org.Locators.BankLocators(driver);
//
//			A = new org.Locators.AggregatorLocators(driver);
//
//			ExcelDataCache cache = ExcelDataCache.getInstance();
//
//			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
//
//			System.out.println("sheet name: " + testdata);
//
//			String code = testdata.get(rowNumber).get("Aggregator Code");
//
//			System.out.println("0" + testdata.get(0));
//
//			A.ClickOnAggregatorCOde();
//
//			A.EnterOnAggregatorCOde(code);
//
//			B.NOTDisplayedOnInvalidFormat();
//
//			LoginInputDatas("Aggregator Code", code);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Sales Info");
//			throw e;
//		}
//
//	}
	

	@Then("the \"Aggregator Code\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AggragatorCode_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {

	    try {
	        B = new org.Locators.BankLocators(driver);
	        A = new org.Locators.AggregatorLocators(driver);

	        // Initialize Faker
	        Faker faker = new Faker();
	        ExcelDataCache cache = ExcelDataCache.getInstance();
	        List<Map<String, String>> testData = cache.getCachedData(sheetName);

	        // Generate a valid Aggregator Code
	        String aggregatorCode = generateValidAggregatorCode(faker, testData);

	        A.ClickOnAggregatorCOde();
	        A.EnterOnAggregatorCOde(aggregatorCode);

	       
	        // Log the input data
	        LoginInputDatas("Aggregator Code", aggregatorCode);

	        // Ensure the entered Aggregator Code is exactly 6 characters

	    } catch (Exception e) {
	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	        exceptionHandler.handleException(e, "Sales Info");
	        throw e;
	    }
	}

	// Method to generate a valid Aggregator Code
	private String generateValidAggregatorCode(Faker faker, List<Map<String, String>> testData) {
	    String aggregatorCode;
	    Set<String> existingAggregatorCodes = testData.stream()
	                                                  .map(data -> data.get("Aggregator Code"))
	                                                  .collect(Collectors.toSet());

	    while (true) {
	        // Generate a 6-character alphanumeric Aggregator Code
	        aggregatorCode = faker.regexify("[A-Za-z0-9]{6}");

	        // Ensure the code is unique and matches the required format
	        if (!existingAggregatorCodes.contains(aggregatorCode) && aggregatorCode.matches("^[a-zA-Z0-9]{6}$")) {
	            return aggregatorCode; // Return valid, unique Aggregator Code
	        }
	    }
	}


	

	@Then("the label name should be \"Allow Self Merchant Onboard\"")
	public void the_labelname_should_be_Allow_Self_MerchantOnboard() {

		try {
			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.AllowSelfMerchantOnboardLabelName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"Allow Self Merchant Onboard\" field should prompt to select Yes or No based on the given input using sheetname {string} and rownumber {int}")
	public void the_AllowSelfMerchantOnboard_fieldshouldprompt_toselect_YesorNobasedon_the_given_input(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String VAS = testdata.get(rowNumber).get("Allow Self Merchant Onboarding");

			A.ClickOnAllowSelfMerchantOnboard();

			B.selectDropdownOption(VAS);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Allow Self Merchant Onboarding", VAS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the label name should be \"Marsid\" in Sales Info")
	public void the_labelname_should_be_Marsid_inSalesInfo() {

		try {
			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.MarsidLabelName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"Marsid\" field should not allow to proceed without any input data in Sales Info")
	public void the_Marsid_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnMarsid();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"Marsid\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Marsid_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String id = testdata.get(rowNumber).get("Marsid");

			System.out.println("0" + testdata.get(0));

			A.ClickOnMarsid();

			A.EnterOnMarsid(id);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Marsid", id);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the label name should be \"Auto Deactivation Days\" in Sales Info")
	public void the_labelname_should_be_AutoDeactivationdays_inSalesInfo() {

		try {
			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.AutoDeactivationLabelName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"Auto Deactivation Days\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AutoDeactivationDays_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String days = testdata.get(rowNumber).get("Auto Deactivation Days");

			System.out.println("0" + testdata.get(0));

			A.ClearOnAutoDeactivationdays();

			A.ClickOnAutoDeactivationdays();

			A.EnterOnAutoDeactivationdays(days);

			performTabKeyPress();
			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Auto Deactivation Days", days);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the Second label name should be \"VAS Commission\"")
	public void the_Secondlabel_name_should_be_VASCommission() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.VASCommissionLabelNameTWO();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the Second \"VAS Commission\" field should prompt to select Yes or No based on the given input")
	public void the_Second_VAS_COmmission_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnVASCommisiionTWO();

			A.SalesInfoYes();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the label name should be \"IS TMS Aggregator\"")
	public void the_Secondlabel_name_should_be_IS_TMS_Aggregator() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.IsTMSAggregatorLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"IS TMS Aggregator\" field should prompt to select Yes or No based on the given input using sheetname {string} and rownumber {int}")
	public void the_IS_TMS_Aggregator_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String VAS = testdata.get(rowNumber).get("IS TMS Aggregator");

			A.ClickOnISTMSAggregator();

			B.selectDropdownOption(VAS);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("IS TMS Aggregator", VAS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the label name should be \"EKyc Required\"")
	public void the_Secondlabel_name_should_be_EKYC_Required() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.EKycRequiredLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"EKyc Required\" field should prompt to select Yes or No based on the given input using sheetname {string} and rownumber {int}")
	public void the_EKyc_Required_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String VAS = testdata.get(rowNumber).get("EKYC Required");

			A.ClickOnEKYCRequired();

			B.selectDropdownOption(VAS);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("EKYC Required", VAS);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"NextStep\" button should be prompted to click on Sales Info")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_SalesInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {
			B.ClickOnNextStep();

			A.DisplayedOnIntroCompanyInfo();

		} catch (AssertionError ae) {
			takeScreenshotStr("SalesInfo"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

//Company Info	

	@When("I Visit the Company Info")
	public void CompanyInfo() throws InterruptedException {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnCompanyInfo();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Legal Name\"")
	public void the_label_name_should_be_LegalName() throws InterruptedException {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.LegalNameLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Legal Name\" field should not allow to proceed without any input data")
	public void the_LegalName_fieldshould_notallow_toproceed_withoutany_input_data()
			throws InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.ClickOnLegalName();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Legal Name\" field should prompts for invalid input if Less than 2 characters are entered using sheetname {string} and rownumber {int}")
	public void the_LegalName_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String legal = testdata.get(rowNumber).get("Legal Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnLegalName();

			A.EnterOnLegalName(legal);

			performTabKeyPress();

			A.ClearOnLegalName();

			B.DisplayedOnThisInvalidFormat();

			LoginInputDatas("Legal Name", legal);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	
	@Then("the \"Legal Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
//	public void the_legalName_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
//	        throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//	    try {
//	        B = new org.Locators.BankLocators(driver);
//	        A = new org.Locators.AggregatorLocators(driver);
//
//	        // Initialize Faker
//	        Faker faker = new Faker();
//
//	        // Generate a valid legal name
//	        String legalName = generateValidLegalName(faker);
//
//	        // Click on Legal Name field and enter the generated legal name
//	        A.ClickOnLegalName();
//	        A.EnterOnLegalName(legalName);
//
//	        performTabKeyPress();
//
//	        
//	        // Validate that no invalid format message is displayed
//	        B.NOTDisplayedOnInvalidFormat();
//
//	        // Log input data
//	        LoginInputDatas("Legal Name", legalName);
//
//	    } catch (Exception e) {
//	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//	        exceptionHandler.handleException(e, "Company Info");
//	        throw e;
//	    }
//	}
	
	public void the_legalName_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {

	    try {
	        B = new org.Locators.BankLocators(driver);
	        A = new org.Locators.AggregatorLocators(driver);

	        Faker faker = new Faker();
	        
	        List<Map<String, String>> testdata = cache.getCachedData(sheetName);

	        // Generate a valid legal name with only alphanumeric characters (max 10 chars)
	        String legalName = generateValidLegalName(faker, testdata);

	        // Enter the generated legal name in the Legal Name field
	        A.ClickOnLegalName();
	        A.EnterOnLegalName(legalName);

	        performTabKeyPress();

	        // Validate that no invalid format message is displayed
	        B.NOTDisplayedOnInvalidFormat();

	        // Log input data
	        LoginInputDatas("Legal Name", legalName);

	        // Store the generated legal name back to the Excel sheet
	        testdata.get(rowNumber).put("LegalName", legalName); // Make sure to match this with how it's retrieved later
	        cache.setCachedData(sheetName, testdata);

	    } catch (Exception e) {
	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	        exceptionHandler.handleException(e, "Company Info");
	        throw e;
	    }
	}

	// Method to generate a valid legal name (only alphanumeric, max 10 characters)
	private String generateValidLegalName(Faker faker, List<Map<String, String>> testdata) {
	    String legalName;
	    Set<String> existingLegalNames = testdata.stream()
	                                             .map(data -> data.get("LegalName"))
	                                             .collect(Collectors.toSet());

	    while (true) {
	        // Generate a legal name with alphanumeric characters only (7 to 10 characters)
	        legalName = faker.regexify("[A-Za-z0-9]{7,10}");

	        // Check if the generated name is unique and valid
	        if (!existingLegalNames.contains(legalName)) {
	            return legalName; // Return the valid legal name
	        }
	    }
	}

//Brand Name

	@Then("the label name should be \"Brand Name\"")
	public void the_label_name_should_be_BrandName() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.BrandNameLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Brand Name\" field should not allow to proceed without any input data")
	public void the_BrandName_fieldshould_notallow_toproceed_withoutany_input_data()
			throws InterruptedException, AWTException {

		try {
			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.ClickOnBrandName();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Brand Name\" field should prompts for invalid input if Less than 2 characters are entered using sheetname {string} and rownumber {int}")
	public void the_BrandName_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String brand = testdata.get(rowNumber).get("Brand Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnBrandName();

			A.EnterOnBrandName(brand);

			performTabKeyPress();

			A.ClearOnBrandName();

			B.DisplayedOnThisInvalidFormat();

			LoginInputDatas("Brand Name", brand);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Brand Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_BrandName_ShouldPrompt_toEntervalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		ExcelDataCache cache = ExcelDataCache.getInstance();

		List<Map<String, String>> testdata = cache.getCachedData(sheetName);

		System.out.println("sheet name: " + testdata);

		String brand = testdata.get(rowNumber).get("Brand Name");

		System.out.println("0" + testdata.get(0));

		try {

			A.ClickOnBrandName();

			A.EnterOnBrandName(brand);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Brand Name", brand);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Registered Address\"")	
	public void the_label_name_should_be_registeredAddress() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.RegisteredAddressLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Registered Address\" field should not allow to proceed without any input data")
	public void the_RegisteredAddress_fieldshould_notallow_toproceed_withoutany_input_data()
			throws InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.ClickOnRegisteredAddress();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Registered Address\" field should prompt to enter valid inputs within 230 characters using sheetname {string} and rownumber {int}")
	public void theAddress_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Address = testdata.get(rowNumber).get("Registered Address");

			System.out.println("0" + testdata.get(0));

			A.EnterOnRegisteredAddress(Address);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Registered Address", Address);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Registered Pincode\"")
	public void the_label_name_should_be_Pincode() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.RegisteredPincodeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Registered Pincode\" field should not allow to proceed without any input data")
	public void the_Pincode_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnRegisteredPincode();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Registered Pincode\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void thePincode_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String pincode = testdata.get(rowNumber).get("Registered Pincode");

			if (pincode != null && pincode.matches("\\d+\\.0")) {
				pincode = pincode.substring(0, pincode.indexOf(".0"));

				A.ClickOnRegisteredPincode();

				System.out.println("0" + testdata.get(0));

				B.selectDropdownOption(pincode);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Pincode", pincode);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Registered State\"")
	public void the_label_Name_Shouldbe_RegisteredSate() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.RegisteredStateLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the Registered state name should be displayed")
	public void the_statename_should_be_displayed() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			String State = A.getState();
			assertEquals("tamilnadu", State);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Registered City\"")
	public void the_label_Name_Shouldbe_RegisteredCIty() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.RegisteredCityLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the Registered city name should be displayed")
	public void the_cityname_should_be_displayed() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			String City = A.getCity();
			assertEquals("chennai", City);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Business Type\"")
	public void the_label_Name_Shouldbe_BusinessType() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.BusinessTypeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Business Type\" field should not allow to proceed without any input data")
	public void the_Business_Type_field_Shouldnot_allow_toProceed_without_anyInputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnBusinessType();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Business Type\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Business_Type_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String VAS = testdata.get(rowNumber).get("Business Type");

			A.ClickOnBusinessType();

			B.selectDropdownOption(VAS);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Business Type", VAS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Established Year\"")
	public void the_label_Name_Shouldbe_EstablishedYear() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.EstablishedYearLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the user selects a valid date in the \"Established Year\" field")
	public void the_userselects_avalid_date_inthe_EstablishedYear_field() throws AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnEstablishedYearDatepicker();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			A.ClickOnApply();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Registered Number\"")
	public void the_label_Name_Shouldbe_RegisteredNumber() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.RegisteredNumberLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Registered Number\" field should not allow to proceed without any input data")
	public void the_registeredNumber_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.CLickOnRegisterNumber();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

//	@Then("the \"Registered Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
//	public void theRegisteredNumber_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
//			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {
//		
//		try {
//
//		B = new org.Locators.BankLocators(driver);
//		A = new org.Locators.AggregatorLocators(driver);
//
//		
//
//		ExcelDataCache cache = ExcelDataCache.getInstance();
//
//		 List<Map<String, String>> testdata = cache.getCachedData(sheetName);
//				
//
//		System.out.println("sheet name: " + testdata);
//
//		String registeredNumber = testdata.get(rowNumber).get("Registered Number");
//
//		int register = (int) Double.parseDouble(registeredNumber);
//		
//		 if (register.contains("E")) {
//	            Double mobileNumber = Double.valueOf(register);
//	            register = String.format("%.0f", mobileNumber); // Convert to string without decimal
//	        }
//
//		System.out.println("0" + testdata.get(0));
//
//		A.CLickOnRegisterNumber();
//
//		A.EnterOnRegisterNumber(register);
//
//		
//		Robot r = new Robot();
//
//		r.keyPress(KeyEvent.VK_TAB);
//
//		r.keyRelease(KeyEvent.VK_TAB);
//
//		B.NOTDisplayedOnInvalidFormat();
//
//		LoginInputDatas("Registered Number", registeredNumber);
//
//		}catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			   exceptionHandler.handleException(e, "Company Info");
//			    throw e; 
//			}
//			
//		}	

	@Then("the \"Registered Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theRegisteredNumber_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			// Load Excel data using ExcelReader utility
			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			// Fetch the "Registered Number" from the specified row
			String registeredNumber = testdata.get(rowNumber).get("Registered Number");

			// Check and handle if the number contains scientific notation (E notation)
			if (registeredNumber.contains("E")) {
				Double numberInScientificNotation = Double.valueOf(registeredNumber);
				registeredNumber = String.format("%.0f", numberInScientificNotation); // Convert to string without
																						// decimal
			}

			// Log the fetched registered number
			System.out.println("Registered Number: " + registeredNumber);

			// Perform actions using locators
			A.CLickOnRegisterNumber(); // Click on the Registered Number field
			A.EnterOnRegisterNumber(registeredNumber); // Enter the number

			// Use Robot to simulate pressing the TAB key
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);

			// Verify if the invalid format message is displayed (this method may need
			// refinement based on implementation)
			B.NOTDisplayedOnInvalidFormat();

			// Log the input data for "Registered Number"
			LoginInputDatas("Registered Number", registeredNumber);

		} catch (Exception e) {
			// Handle the exception using ExceptionHandler
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e; // Re-throw the exception to ensure test failure
		}
	}

	@Then("the label name should be \"Company PAN\"")
	public void the_label_Name_Shouldbe_CompanyPAN() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.CompanyPANLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Company PAN\" field should not allow to proceed without any input data")
	public void the_CompanyPAN_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.CLickOnCompanyPAN();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Company PAN\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_company_PAN_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String pan = testdata.get(rowNumber).get("Company PAN");

			System.out.println("0" + testdata.get(0));

			A.CLickOnCompanyPAN();

			A.EnterOnCompanyPAN(pan);

			performTabKeyPress();

			A.CLearOnCompanyPAN();

			B.DisplayedOnThisInvalidFormat();

			LoginInputDatas("Company PAN", pan);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

//	@Then("the \"Company PAN\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
//	public void theCompanyPAN_field_shouldprompt_toenter_valid_inputs(String sheetName, int rowNumber)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//		try {
//
//			B = new org.Locators.BankLocators(driver);
//			A = new org.Locators.AggregatorLocators(driver);
//
//			ExcelDataCache cache = ExcelDataCache.getInstance();
//
//			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
//
//			System.out.println("sheet name: " + testdata);
//
//			String pan = testdata.get(rowNumber).get("Company PAN");
//
//			System.out.println("0" + testdata.get(0));
//
//			A.CLickOnCompanyPAN();
//
//			A.EnterOnCompanyPAN(pan);
//
//			performTabKeyPress();
//
//			B.NOTDisplayedOnInvalidFormat();
//
//			LoginInputDatas("Company PAN", pan);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Company Info");
//			throw e;
//		}
//
//	}
	
	
	@Then("the \"Company PAN\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theCompanyPAN_field_shouldprompt_toenter_valid_inputs(String sheetName, int rowNumber)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {

	    try {
	        B = new org.Locators.BankLocators(driver);
	        A = new org.Locators.AggregatorLocators(driver);

	        // Initialize Faker
	        Faker faker = new Faker();

	        // Generate a valid PAN number
	        String pan = generateValidPAN(faker);

	        // Click on Company PAN field and enter the generated PAN number
	        A.CLickOnCompanyPAN();
	        A.EnterOnCompanyPAN(pan);

	        performTabKeyPress();

	        // Validate that no invalid format message is displayed
	        B.NOTDisplayedOnInvalidFormat();

	        // Log input data
	        LoginInputDatas("Company PAN", pan);

	    } catch (Exception e) {
	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	        exceptionHandler.handleException(e, "Company Info");
	        throw e;
	    }
	}

	// Method to generate a valid PAN number
	private String generateValidPAN(Faker faker) {
	    StringBuilder pan = new StringBuilder();
	    
	    // First 5 characters: Uppercase letters
	    for (int i = 0; i < 5; i++) {
	        pan.append(faker.regexify("[A-Z]"));
	    }
	    
	    // Next 4 characters: Digits
	    for (int i = 0; i < 4; i++) {
	        pan.append(faker.number().numberBetween(0, 10));
	    }
	    
	    // Last character: Uppercase letter
	    pan.append(faker.regexify("[A-Z]"));
	    
	    return pan.toString();
	}


//GSTIN

	@Then("the label name should be \"GSTIN\"")
	public void the_label_Name_Shouldbe_GstIN() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.GSTINLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"GSTIN\" field should not allow to proceed without any input data")
	public void the_GstIN_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.CLickOnGSTIN();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"GSTIN\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_GstIN_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String GstIN = testdata.get(rowNumber).get("GSTIN");

			System.out.println("0" + testdata.get(0));

			A.CLickOnGSTIN();

			A.EnterOnGSTIN(GstIN);

			performTabKeyPress();

			A.CLearOnGSTIN();

			B.DisplayedOnThisInvalidFormat();

			LoginInputDatas("GstIN", GstIN);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"GSTIN\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theGSTIN_field_shouldprompt_toenter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String GstIN = testdata.get(rowNumber).get("GSTIN");

			System.out.println("0" + testdata.get(0));

			A.CLickOnGSTIN();

			A.EnterOnGSTIN(GstIN);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("GstIN", GstIN);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Statement Frequency\" in Company Info")
	public void the_label_Name_Shouldbe_StatementFrequency() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.StatementFrequencyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Statement Frequency\" dropdown should prompt to select valid inputs in Company Info using sheetname {string} and rownumber {int}")
	public void the_StatementFrequency_dropdown_should_prompt_toselect_validinputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String frequency = testdata.get(rowNumber).get("Statement Frequency");

			System.out.println("0" + testdata.get(0));

			A.CLickOnStatementFrequency();

			B.selectDropdownOption(frequency);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Statement Frequency", frequency);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Statement Type\" in Company Info")
	public void the_label_Name_Shouldbe_StatementType() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.StatementTypeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Statement Type\" field should not allow to proceed without any input data in Company Info")
	public void the_Statement_Type_field_Shouldnot_allow_toProceed_without_anyInputdata()
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.CLickOnStatementType();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Statement Type\" dropdown should prompt to select valid inputs in Company Info using sheetname {string} and rownumber {int}")
	public void the_StatementType_dropdown_should_prompt_toselect_validinputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Type = testdata.get(rowNumber).get("Statement Type");

			System.out.println("0" + testdata.get(0));

			A.CLickOnStatementType();

			B.selectDropdownOption(Type);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Statement Type", Type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the label name should be \"Email Domain\"")
	public void the_label_Name_Shouldbe_emaildomain() {
		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.EmailDomainLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Email Domain\" field should not allow to proceed without any input data")
	public void the_emaildomain_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.CLickOnEmailDomain();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Email Domain\" field should prompt to enter invalid alphabet domain names using sheetname {string} and rownumber {int}")
	public void the_Emaildomain_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String domain = testdata.get(rowNumber).get("Email Domain");

			System.out.println("0" + testdata.get(0));

			A.CLickOnEmailDomain();

			A.EnterOnEmailDomain(domain);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.EmailDomainClear();

			LoginInputDatas("Domain", domain);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Email Domain\" field should prompt to enter invalid number domain names using sheetname {string} and rownumber {int}")
	public void the_Emaildomain_ShouldPrompt_toEnterInvalidNumbers(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String domain = testdata.get(rowNumber).get("Email Domain");

			System.out.println("0" + testdata.get(0));

			A.CLickOnEmailDomain();

			A.EnterOnEmailDomain(domain);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.EmailDomainClear();

			LoginInputDatas("Domain", domain);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"Email Domain\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theEmaildomain_field_shouldprompt_toenter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String domain = testdata.get(rowNumber).get("Email Domain");

			System.out.println("0" + testdata.get(0));

			A.CLickOnEmailDomain();

			A.EnterOnEmailDomain(domain);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Domain", domain);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@Then("the \"NextStep\" button should be prompted to click on Company Info")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_CompanyInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroPersonalInfo();

		} catch (AssertionError ae) {
			takeScreenshotStr("Company Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

//Personal Info	

	@When("I visit the Personal Info")
	public void I_visit_the_Personal_Info() throws InterruptedException {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnPersonalInfo();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Add\" button should be prompted to click in personal info")
	public void the_Add_button_shouldbe_promptedto_clickinpersonal_info() throws InterruptedException {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnPersonalInfo();

			A.PersonalINfoADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Title\" in Personal Info")
	public void the_label_Name_Shouldbe_title() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.Titlepersonallabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Title\" field should not allow proceeding without any input data in personal info")
	public void the_title_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOntitlepersonal();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Title\" dropdown should prompt to select valid inputs in Personal Info using sheetname {string} and rownumber {int}")
	public void the_title_field_should_allow_to_proceed_valid_input_data(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String title = testdata.get(rowNumber).get("Title");

			System.out.println("0" + testdata.get(0));

			A.ClickOntitlepersonal();

			B.selectDropdownOption(title);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Title", title);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"First Name\" in Personal Info")
	public void the_label_Name_Shouldbefirstname() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.FirstNamePersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"First Name\" field should not allow proceeding without any input data in personal info")
	public void the_firstName_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnFirstNamePersonal();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"First Name\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String FirstName = testdata.get(rowNumber).get("First Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnFirstNamePersonal();

			A.EnterOnFirstNamePersonal(FirstName);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnFirstNamePersonal();

			LoginInputDatas("First Name", FirstName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"First Name\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String FirstName = testdata.get(rowNumber).get("First Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnFirstNamePersonal();

			A.EnterOnFirstNamePersonal(FirstName);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnFirstNamePersonal();

			LoginInputDatas("First Name", FirstName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"First Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String FirstName = testdata.get(rowNumber).get("First Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnFirstNamePersonal();

			A.EnterOnFirstNamePersonal(FirstName);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("First Name", FirstName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

//LastName

	@Then("the label name should be \"Last Name\" in Personal Info")
	public void the_label_Name_ShouldbeLastname() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.LastNamePersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Last Name\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_lastName_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String LastName = testdata.get(rowNumber).get("Last Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnLastNamePersonal();

			A.EnterOnLastNamePersonal(LastName);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnLastNamePersonal();

			LoginInputDatas("Last Name", LastName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Last Name\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_lastName_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String LastName = testdata.get(rowNumber).get("Last Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnLastNamePersonal();

			A.EnterOnLastNamePersonal(LastName);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnLastNamePersonal();

			LoginInputDatas("Last Name", LastName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Last Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_lastName_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String LastName = testdata.get(rowNumber).get("Last Name");

			System.out.println("0" + testdata.get(0));

			A.ClickOnLastNamePersonal();

			A.EnterOnLastNamePersonal(LastName);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Last Name", LastName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Date of Birth\" in Personal Info")
	public void the_label_Name_Shouldbedateofbirth() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.DOBPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Date Of Birth\" field should not allow proceeding without any input data in personal info")
	public void the_DOB_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnDOBPersonal();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the user select a valid date in the \"Date Of Birth\" field in Personal Info")
	public void theuser_selecta_validdatein_the_DateOf_Birthfield_inPersonal_Info()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnOpenCalenderPersonal();

			A.ClickOnChooseMonthandYearPersonal();

			A.ClickOnYearPersonal();

			A.ClickOnMonthPersonal();

			A.ClickOnDatePersonal();

			A.ClickOnApplyPersonal();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"PAN\" in Personal Info")
	public void labelName_should_be_PAN() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.PANPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"PAN\" field should not allow to proceed without any input data in Personal Info")
	public void the_PAN_field_shouldnotallow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			A.ClickOnPANPersonal();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"PAN\" field should prompt to enter Invalid inputs with PAN Format in Personal Info using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_Invalid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String pan = testdata.get(rowNumber).get("PAN");

			A.ClickOnPANPersonal();

			A.EnterOnPanPersonal(pan);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.ClearPAN();

			LoginInputDatas("PAN", pan);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"PAN\" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_valid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

	  try {
			        B = new org.Locators.BankLocators(driver);
			        A = new org.Locators.AggregatorLocators(driver);

			        // Initialize Faker
			        Faker faker = new Faker();

			        // Generate a valid PAN number
			        String pan = generateValidPAN(faker);

			        // Click on Company PAN field and enter the generated PAN number
			        A.ClickOnPANPersonal();

					A.EnterOnPanPersonal(pan);

			        // Validate that no invalid format message is displayed
			        B.NOTDisplayedOnInvalidFormat();

			        // Log input data
			        LoginInputDatas("PAN", pan);

			    } catch (Exception e) {
			        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			        exceptionHandler.handleException(e, "Company Info");
			        throw e;
			    }
			}

	@Then("the label name should be \"Address\" in Personal Info")
	public void labelName_Should_be_Address() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.AddressPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Address\" field should not allow to proceed without any input data in personal info")
	public void the_Address_field_shouldnotallowto_proceed_withoutanyinput_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnAddressPersonal();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Address\" field should prompt to enter valid inputs within 230 characters in personal info using sheetname {string} and rownumber {int}")
	public void theAddress_field_shouldprompt_toenter_valid_inputs_within_230_characters_inPersonalInfo(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Address = testdata.get(rowNumber).get("Address");

			System.out.println("0" + testdata.get(0));

			A.ClickOnAddressPersonal();

			A.EnterOnAddressPersonal(Address);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Address", Address);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Pincode\" in Personal Info")
	public void the_label_name_should_be_Pincode_inPersonal_Info() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.PincodePersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Pincode\" field should not allow to proceed without any input data in Personal Info")
	public void the_Pincode_field_should_not_allow_to_proceed_without_any_input_data_inPersonal_info()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnPincodePersonal();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Pincode\" dropdown should prompt to select valid inputs in Personal Info using sheetname {string} and rownumber {int}")
	public void thePincode_dropdown_should_prompt_to_select_valid_inputs_in_Personal_Info(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String pincode = testdata.get(rowNumber).get("Personal Pincode");

			if (pincode != null && pincode.matches("\\d+\\.0")) {
				pincode = pincode.substring(0, pincode.indexOf(".0"));

				A.ClickOnPincodePersonal();

				System.out.println("0" + testdata.get(0));

				B.selectDropdownOption(pincode);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Pincode", pincode);

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"State\" in Personal Info")
	public void the_label_Name_Shouldbe_State() {
		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.StatePersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"state name\" should be displayed in Personal info")
	public void the_statename_should_be_displayedinpersonalInfo() {

		A = new org.Locators.AggregatorLocators(driver);

		String State = A.getState();
		assertEquals("tamilnadu", State);

	}

	@Then("the label name should be \"City\" in Personal Info")
	public void the_label_Name_Shouldbe_CIty() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.CityPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"City name\" should be displayed in Personal info")
	public void the_cityname_should_be_displayedinpersonalInfo() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			String City = A.getCity();
			assertEquals("chennai", City);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Mobile Number\" in Personal Info")
	public void the_label_name_shouldbe_MobileNumber() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.MobilePersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Mobile Number\" field should not allow proceeding without any input data in Personal Info")
	public void the_MobileNumber_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnMobileNumberPersonal();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Mobile Number\" field should not allow inputs with fewer digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Mobilenumber = testdata.get(rowNumber).get("Mobile Number");

			System.out.println("0" + testdata.get(0));

			A.ClickOnMobileNumberPersonal();

			A.EnterOnMobileNumberPersonal(Mobilenumber);

			performTabKeyPress();

			B.DisplayedOnShouldbe30digits();

			A.ClearOnMobileNumberPersonal();

			LoginInputDatas("Mobile Number", Mobilenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Mobile Number\" field should not allow inputs with more digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Mobilenumber = testdata.get(rowNumber).get("Mobile Number");

			System.out.println("0" + testdata.get(0));

			A.ClickOnMobileNumberPersonal();

			A.EnterOnMobileNumberPersonal(Mobilenumber);

			String enteredMobileNumber = B.getMobileNumber();
			assertTrue("Mobile Number field allows more than 10 digits.", enteredMobileNumber.length() <= 10);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			A.ClearOnMobileNumberPersonal();

			LoginInputDatas("Mobile Number", Mobilenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Mobile Number\" field should prompt to enter valid inputs in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_promptto_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Mobilenumber = testdata.get(rowNumber).get("Mobile Number");

			System.out.println("0" + testdata.get(0));

			if (Mobilenumber.contains("E")) {
				Double numberInScientificNotation = Double.valueOf(Mobilenumber);
				Mobilenumber = String.format("%.0f", numberInScientificNotation); // Convert to string without decimal
			}

			A.ClickOnMobileNumberPersonal();

			A.EnterOnMobileNumberPersonal(Mobilenumber);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Mobile Number", Mobilenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Telephone\" in Personal Info")
	public void the_label_name_shouldbe_telePhoneNumber() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommPhoneNumber();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Telephone\" field should not allow inputs with fewer digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_TelePhone_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Telephone = testdata.get(rowNumber).get("Telephone");

			System.out.println("0" + testdata.get(0));

			A.ClickOnTelephonePersonal();
			A.EnterOnTelephonePersonal(Telephone);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnTelephonePersonal();

			LoginInputDatas("Telephone", Telephone);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Telephone\" field should not allow inputs with more digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_TelePhone_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Telephone = testdata.get(rowNumber).get("Telephone");

			System.out.println("0" + testdata.get(0));

			A.ClickOnTelephonePersonal();
			A.EnterOnTelephonePersonal(Telephone);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnTelephonePersonal();

			LoginInputDatas("Telephone", Telephone);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Telephone\" field should not allow numbers that do not start with the digit 0 in Personal Info using sheetname {string} and rownumber {int}")
	public void the_telePhome_field_should_not_allow_numbers_numbers_that_do_not_start_with_the_digit_0(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Telephone = testdata.get(rowNumber).get("Telephone");

			System.out.println("0" + testdata.get(0));

			A.ClickOnTelephonePersonal();
			A.EnterOnTelephonePersonal(Telephone);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnTelephonePersonal();

			LoginInputDatas("Telephone", Telephone);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Telephone\" field should prompt to enter valid inputs in Personal Info")

	public void the_telephoneNumberfield_shouldprompt_toenter_validinputs(List<Map<String, String>> dataTable)
			throws InterruptedException, AWTException {
		for (Map<String, String> row : dataTable) {

			try {

				B = new org.Locators.BankLocators(driver);
				L = new org.Locators.LoginLocators(driver);
				A = new org.Locators.AggregatorLocators(driver);

				String telephone = row.get("TelePhone Number");

				A.ClickOnTelephonePersonal();
				A.EnterOnTelephonePersonal(telephone);

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_TAB);

				r.keyRelease(KeyEvent.VK_TAB);

				B.NOTDisplayedOnInvalidFormat();

			} catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver,
						ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Personal Info");
				throw e;
			}
		}
	}

	@Then("the label name should be \"Email ID\" in Personal Info")
	public void the_label_name_shouldbe_Emailid() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.EmailPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow proceeding without any input data in Personal Info")
	public void the_EmailID_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnEmailPersonal();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow inputs missing the '@' symbol in personal info using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_symbol(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String emailid = testdata.get(rowNumber).get("Email");

			System.out.println("0" + testdata.get(0));

			A.ClickOnEmailPersonal();

			A.EnterOnemailPersonal(emailid);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnEmailPersonal();

			LoginInputDatas("Email ID", emailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow inputs missing the domain name in Personal Info using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_domainname(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String emailid = testdata.get(rowNumber).get("Email");

			System.out.println("0" + testdata.get(0));

			A.ClickOnEmailPersonal();

			A.EnterOnemailPersonal(emailid);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnEmailPersonal();

			LoginInputDatas("Email ID", emailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the Personal Info \"Email ID\" field should not allow consecutive dots in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_consective_dots_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String emailid = testdata.get(rowNumber).get("Email");

			System.out.println("0" + testdata.get(0));

			A.ClickOnEmailPersonal();

			A.EnterOnemailPersonal(emailid);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnEmailPersonal();

			LoginInputDatas("Email ID", emailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the Personal Info \"Email ID\" field should not allow spaces in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_spaces_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String emailid = testdata.get(rowNumber).get("Email");

			System.out.println("0" + testdata.get(0));

			A.ClickOnEmailPersonal();

			A.EnterOnemailPersonal(emailid);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnEmailPersonal();

			LoginInputDatas("Email ID", emailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should prompt to enter valid inputs in Personal Info using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String emailid = testdata.get(rowNumber).get("Email");

			System.out.println("0" + testdata.get(0));

			A.ClickOnEmailPersonal();

			A.EnterOnemailPersonal(emailid);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Email ID", emailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Nationality\" in Personal Info")
	public void the_label_Name_ShouldbeNationality() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.NationalityPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Nationality\" field should not allow proceeding without any input data in personal info")
	public void the_Nationality_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnNationalityPersonal();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Nationality\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Nationality_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Nationality = testdata.get(rowNumber).get("Nationality");

			System.out.println("0" + testdata.get(0));

			A.ClickOnNationalityPersonal();

			A.EnterOnNationalitypersonal(Nationality);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnNationalityPersonal();

			LoginInputDatas("Nationality", Nationality);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Nationality\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Nationality_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Nationality = testdata.get(rowNumber).get("Nationality");

			System.out.println("0" + testdata.get(0));

			A.ClickOnNationalityPersonal();

			A.EnterOnNationalitypersonal(Nationality);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnNationalityPersonal();

			LoginInputDatas("Nationality", Nationality);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Nationality\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Nationality_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Nationality = testdata.get(rowNumber).get("Nationality");

			System.out.println("0" + testdata.get(0));

			A.ClickOnNationalityPersonal();

			A.EnterOnNationalitypersonal(Nationality);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Nationality", Nationality);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Aadhaar Number\" in Personal Info")
	public void the_label_name_shouldbe_Aadhaar() {

		try {

			A = new org.Locators.AggregatorLocators(driver);

			A.AadhaarNumberPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Aadhaar Number\" field should not allow inputs with fewer than 12 digits in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Aadhaar_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Aadhaar = testdata.get(rowNumber).get("Aadhaar Number");

			System.out.println("0" + testdata.get(0));

			A.ClickOnAadhaarNumberPersonal();

			A.EnterOnAadhaarNumberPersonal(Aadhaar);

			performTabKeyPress();
			B.DisplayedOnShouldbe30digits();

			A.ClearOnAadhaarNumberPersonal();

			LoginInputDatas("Aadhaar Number", Aadhaar);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Aadhaar Number\" field should not allow inputs with more than 12 digits in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Aadhar_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Aadhaar = testdata.get(rowNumber).get("Aadhaar Number");

			System.out.println("0" + testdata.get(0));

			A.ClickOnAadhaarNumberPersonal();

			A.EnterOnAadhaarNumberPersonal(Aadhaar);

			String enteredAadhaarNumber = A.getAadhaarPersonal();
			assertTrue("Mobile Number field allows more than 10 digits.", enteredAadhaarNumber.length() <= 12);

			performTabKeyPress();

			A.ClearOnAadhaarNumberPersonal();

			LoginInputDatas("Aadhaar Number", Aadhaar);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}


	@Then("the \"Aadhaar Number\" field should prompt to enter valid inputs in Personal Info using sheetname {string} and rownumber {int}")
//	public void the_Aadhaar_field_should_promptto_enter_valid_inputs(String sheetName, int rowNumber)
//	        throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//	    try {
//	        B = new org.Locators.BankLocators(driver);
//	        A = new org.Locators.AggregatorLocators(driver);
//
//	        // Initialize Faker
//	        Faker faker = new Faker();
//
//	        // Generate a valid Aadhaar number
//	        String aadhaar = generateValidAadhaar(faker);
//
//	        // Click on Aadhaar Number field and enter the generated Aadhaar number
//	        A.ClickOnAadhaarNumberPersonal();
//	        A.EnterOnAadhaarNumberPersonal(aadhaar);
//
//	        // Simulate Tab key press
//	        Robot r = new Robot();
//	        r.keyPress(KeyEvent.VK_TAB);
//	        r.keyRelease(KeyEvent.VK_TAB);
//
//	        // Validate that no invalid format message is displayed
//	        B.NOTDisplayedOnInvalidFormat();
//
//	        // Log input data
//	        LoginInputDatas("Aadhaar Number", aadhaar);
//
//	    } catch (Exception e) {
//	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//	        exceptionHandler.handleException(e, "Personal Info");
//	        throw e;
//	    }
//	}
//
//	// Method to generate a valid Aadhaar number
//	private String generateValidAadhaar(Faker faker) {
//	    StringBuilder aadhaarNumber = new StringBuilder();
//
//	    // Generate 12 random digits
//	    for (int i = 0; i < 12; i++) {
//	        aadhaarNumber.append(faker.number().numberBetween(0, 10)); // Generate digits between 0-9
//	    }
//
//	    return aadhaarNumber.toString();
//	}

	    public void the_Aadhaar_field_should_promptto_enter_valid_inputs(String sheetName, int rowNumber)
	            throws InvalidFormatException, IOException, InterruptedException, AWTException {

	        try {
	            B = new org.Locators.BankLocators(driver);
	            A = new org.Locators.AggregatorLocators(driver);

	            // Generate a valid Aadhaar number
	            String aadhaar = generateValidAadhaar();

	            // Click on Aadhaar Number field and enter the generated Aadhaar number
	            A.ClickOnAadhaarNumberPersonal();
	            A.EnterOnAadhaarNumberPersonal(aadhaar);

	            // Simulate Tab key press
	            Robot r = new Robot();
	            r.keyPress(KeyEvent.VK_TAB);
	            r.keyRelease(KeyEvent.VK_TAB);

	            // Validate that no invalid format message is displayed
	            B.NOTDisplayedOnInvalidFormat();

	            // Log input data
	            LoginInputDatas("Aadhaar Number", aadhaar);

	        } catch (Exception e) {
	            ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	            exceptionHandler.handleException(e, "Personal Info");
	            throw e;
	        }
	    }

	    // Method to generate a valid Aadhaar number using Verhoeff algorithm
	    private String generateValidAadhaar() {
	        StringBuilder aadhaarNumber = new StringBuilder();
	        Faker faker = new Faker();

	        // Generate 11 random digits
	        for (int i = 0; i < 11; i++) {
	            aadhaarNumber.append(faker.number().numberBetween(0, 10)); // Generate digits between 0-9
	        }

	        // Generate the 12th digit using the Verhoeff algorithm
	        int checkDigit = calculateVerhoeffCheckDigit(aadhaarNumber.toString());
	        aadhaarNumber.append(checkDigit);

	        return aadhaarNumber.toString();
	    }

	    // Verhoeff algorithm to calculate the check digit
	    private int calculateVerhoeffCheckDigit(String number) {
	        int c = 0;
	        int[] myArray = stringToReversedIntArray(number);
	        for (int i = 0; i < myArray.length; i++) {
	            c = d[c][p[i % 8][myArray[i]]];
	        }
	        return inv[c];
	    }

	    // Convert the string number to an int array in reverse order
	    private static int[] stringToReversedIntArray(String num) {
	        int[] myArray = new int[num.length()];
	        for (int i = 0; i < num.length(); i++) {
	            myArray[i] = Integer.parseInt(num.substring(num.length() - 1 - i, num.length() - i));
	        }
	        return myArray;
	    }

	    // Verhoeff tables
	    private static final int[][] d = new int[][] {
	            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
	            {1, 2, 3, 4, 0, 6, 7, 8, 9, 5},
	            {2, 3, 4, 0, 1, 7, 8, 9, 5, 6},
	            {3, 4, 0, 1, 2, 8, 9, 5, 6, 7},
	            {4, 0, 1, 2, 3, 9, 5, 6, 7, 8},
	            {5, 9, 8, 7, 6, 0, 4, 3, 2, 1},
	            {6, 5, 9, 8, 7, 1, 0, 4, 3, 2},
	            {7, 6, 5, 9, 8, 2, 1, 0, 4, 3},
	            {8, 7, 6, 5, 9, 3, 2, 1, 0, 4},
	            {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
	    };

	    private static final int[][] p = new int[][] {
	            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
	            {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
	            {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
	            {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
	            {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
	            {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
	            {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
	            {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
	    };

	    private static final int[] inv = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	


	@Then("the label name should be \"Passport\" in Personal Info")
	public void the_label_Name_ShouldbepassportNumber() {

		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.PassportNumberPersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Passport\" field should not allow only numeric characters using sheetname {string} and rownumber {int}")
	public void the_PassportNumber_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Passport = testdata.get(rowNumber).get("Passport");

			System.out.println("0" + testdata.get(0));

			A.ClickOnPassportNumberPersonal();

			A.EnterOnPassportNumberPersonal(Passport);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnPassportNumberPersonal();

			LoginInputDatas("Passport", Passport);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Passport\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Passport_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Passport = testdata.get(rowNumber).get("Passport");

			System.out.println("0" + testdata.get(0));

			A.ClickOnPassportNumberPersonal();

			A.EnterOnPassportNumberPersonal(Passport);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnThisInvalidFormat();

			A.ClearOnPassportNumberPersonal();

			LoginInputDatas("Passport", Passport);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the \"Passport\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Passport_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Passport = testdata.get(rowNumber).get("Passport");

			System.out.println("0" + testdata.get(0));

			A.ClickOnPassportNumberPersonal();

			A.EnterOnPassportNumberPersonal(Passport);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Passport", Passport);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the label name should be \"Passport Expiry Date\" in Personal Info")
	public void the_label_Name_ShouldbepassportExpiryDate() {
		try {
			A = new org.Locators.AggregatorLocators(driver);

			A.PassportExpiryDatePersonalLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@Then("the user select a valid date in the \"Passport Expiry Date\" field in Personal Info")
	public void theuser_selecta_validdatein_the_PasswordExpiryDate_inPersonal_Info()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnOpenCalenderPasswordExpiry();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			A.ClickOnApplyPersonal();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}
	

	@Then("the \"Save\" button should be prompted to click on Personal Info")
	public void the_savebutton_shouldbe_prompted_toclick_On_PersonalInfo() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnSAVEPersonal();

			B.OkforSuccessfully();

		} catch (AssertionError ae) {
			takeScreenshotStr("Personal Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"NextStep\" button should be prompted to click on Personal Info")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_personalInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroCommunicationInfo();

		} catch (AssertionError ae) {
			takeScreenshotStr("Personal Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("The \"NextStep\" button should prompted to click on Communication Info in Aggregator")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_aggregator() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroChannelConfig();

		} catch (AssertionError ae) {
			takeScreenshotStr("Communication Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	// Channel Config

	@When("I visit the Channel Config in Aggregator")
	public void I_visit_the_Channel_Config() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelConfig();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Add\" button should be prompted to click in Aggregator")
	public void the_Add_button_should_be_prompted_to_click_inchannel_config() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ChannelADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the label name should be \"Bank Name\" in Channel Config")
	public void labelName_should_be_bankname() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelBankNameLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Bank Name\" field should not allow to proceed without any input data")
	public void the_Channel_Config_BankName_field_should_not_allow_to_proceedwithout_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelBankName();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Bank Name\" field prompts for invalid input if a number is entered using sheetname {string} and rownumber {int}")

	public void the_ChannelConfig_BankName_field_prompts_for_invalid_input_ifanumber_is_entered(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String BankName = testdata.get(rowNumber).get("Channel Bank Name");

			System.out.println("0" + testdata.get(0));

			A.ClearOnChannelBankName();

			A.EnterOnChannelBankName(BankName);

			performTabKeyPress();

			A.DisplayedOnInvalidBankName();

			LoginInputDatas("Bank Name", BankName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Bank Name\" field prompts for invalid input if special characters are entered using sheetname {string} and rownumber {int}")

	public void the_ChannelConfig_BankName_field_prompts_for_invalid_input_ifaSpecialCharacter_is_entered(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String BankName = testdata.get(rowNumber).get("Channel Bank Name");

			System.out.println("0" + testdata.get(0));

			A.ClearOnChannelBankName();

			A.EnterOnChannelBankName(BankName);

			performTabKeyPress();

			A.DisplayedOnInvalidBankName();

			LoginInputDatas("Bank Name", BankName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Bank Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")

	public void the_ChannelConfig_BankName_field_prompts_for_valid_input(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String BankName = testdata.get(rowNumber).get("Channel Bank Name");

			System.out.println("0" + testdata.get(0));

			A.ClearOnChannelBankName();

			A.EnterOnChannelBankName(BankName);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_DOWN);

			r.keyRelease(KeyEvent.VK_DOWN);

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Bank Name", BankName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the label name should be \"Channel\" in Channel Config")
	public void labelName_should_be_Channel() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Channel\" field should not allow to proceed without any input data in Aggregator")
	public void the_Channel_Config_POSChannel_field_should_not_allow_to_proceedwithout_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannel();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"POS Channel\" field should prompt to select the channels based on the given input in Aggregator")
	public void POS_Channel_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannel();

			A.SelectOnPOSChannel();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	// Network
	@Then("the label name should be \"Network\" in Channel Config")
	public void labelName_should_be_Network() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.CHannelNetworkLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Network\" field should not allow to proceed without any input data in Aggregator")
	public void the_Channel_Config_POSNetwork_field_should_not_allow_to_proceedwithout_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelNetwork();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"POS Network\" field should prompt to select the channels based on the given input in Aggregator")
	public void POS_Network_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelNetwork();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	// TransactionSets
	@Then("the label name should be \"Transaction Sets\" in Channel Config")
	public void labelName_should_be_Transactionsets() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelTransactionsetsLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Channel Config \"Transaction Sets\" field should not allow to proceed without any input data in Aggregator")
	public void the_Channel_Config_TransactionSets_field_should_not_allow_to_proceedwithout_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelTransactionsets();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"POS Transaction Sets\" field should prompt to select the transaction sets based on the given input in Aggregator")
	public void POSTransaction_Sets_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelTransactionsets();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the label name should be \"Start Date\" in Channel Config")
	public void labelName_should_be_Startdate() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelStartDateLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"Start Date\" field should prompt to select the transaction sets based on the given input in Aggregator")
	public void POSStartDate_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelStartDate();

			A.ClickOnChannelApply();
			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the label name should be \"END Date\" in Channel Config")
	public void labelName_should_be_Enddate() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelEndDateLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"End Date\" field should prompt to select the transaction sets based on the given input in Aggregator")
	public void POSEndDate_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelENDDate();

			A.ClickOnChannelApply();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"Save\" button should be prompted to click on POS Channel Config")
	public void Save_button_to_clickOn_POS_Channel_Config() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelSave();

		} catch (AssertionError ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"Save\" button should be prompted to click on AEPS Channel Config")
	public void Save_button_to_clickOn_AEPS_Channel_Config() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelSave();

		} catch (AssertionError ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"Save\" button should be prompted to click on UPI Channel Config")
	public void Save_button_to_clickOn_UPI_Channel_Config() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelSave();

		} catch (AssertionError ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"UPI Channel\" field should prompt to select the channels based on the given input in Aggregator")
	public void UPI_Channel_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannel();

			A.SelectonUPIChannel();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"UPI Transaction Sets\" field should prompt to select the transaction sets based on the given input in Aggregator")
	public void UPIransaction_Sets_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelTransactionsets();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"AEPS Channel\" field should prompt to select the channels based on the given input in Aggregator")
	public void AEPS_Channel_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannel();

			A.SelectOnAEPSChannel();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the \"AEPS Transaction Sets\" field should prompt to select the transaction sets based on the given input in Aggregator")
	public void AEPSransaction_Sets_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnChannelTransactionsets();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("The \"NextStep\" button should prompted to click on Channel Config in Aggregator")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_ChannelConfig_aggregator() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroKYC();

		} catch (AssertionError ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	// KYC

	@When("I visit the KYC in Aggregator")
	public void I_visit_the_KYC_in_Aggregator() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnKYC();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC \"Company PAN\" field should not allow to proceed without any input data in Aggregator")
	public void the_KYC_CompanyPAN_field_should_not_allow_to_proceedwithout_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			B.ClickOnNextStep();

			A.DisplayedOnInvalidDocumenterror();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC \"Company PAN\" field should prompt a selection based on the uploaded image in the Aggregator using sheetname {string} and rownumber {int}")
	public void the_KYC_CompanyPAN_Certificate_fieldshouldprompt_aselectionbased_onthe_uploadedimage_inthe_Aggregator(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String panImage = testdata.get(rowNumber).get("Company Pan Image");

			System.out.println("0" + testdata.get(0));

			A.UploadCompanyPAN(panImage);

//		    	driver.switchTo().activeElement().sendKeys(panImage);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Pan Image", panImage);

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC \"Company Proof of address\" field should prompt a selection based on the uploaded image using sheetname {string} and rownumber {int}")
	public void the_KYC_CompanyProofofaddress_Certificate_fieldshouldprompt_aselectionbased_onthe_uploadedimage_inthe_Aggregator(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String poAImage = testdata.get(rowNumber).get("Company Proof of address");

			System.out.println("0" + testdata.get(0));

			A.UploadCompanyProofofaddress(poAImage);

//		    	driver.switchTo().activeElement().sendKeys(panImage);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Proof of address Image", poAImage);

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC \"GST Registration Certificate\" field should not allow to proceed without any input data in Aggregator")
	public void the_KYC_GST_RegistrationCertificate_field_should_not_allow_to_proceedwithout_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			B.ClickOnNextStep();

			A.DisplayedOnInvalidDocumenterror();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC \"GST Registration Certificate\" field should prompt a selection based on the uploaded image in the Aggregator using sheetname {string} and rownumber {int}")
	public void the_KYC_GSTRegistration_Certificate_fieldshouldprompt_aselectionbased_onthe_uploadedimage_inthe_Aggregator(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String gst = testdata.get(rowNumber).get("GST Registration Certificate");

			System.out.println("0" + testdata.get(0));

			A.UploadGSTCertificate(gst);

			// driver.switchTo().activeElement().sendKeys(gst);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("GST Certificate Image", gst);

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC \"Aadhaar\" field should prompt a selection based on the uploaded image in the Aggregator using sheetname {string} and rownumber {int}")
	public void the_KYC_Aadhaar_fieldshouldprompt_aselectionbased_onthe_uploadedimage_inthe_Aggregator(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Aadhaar = testdata.get(rowNumber).get("Aadhaar Image");

			System.out.println("0" + testdata.get(0));

			A.Aadhaar(Aadhaar);

			// driver.switchTo().activeElement().sendKeys(gst);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Aadhaar Image", Aadhaar);

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("The \"NextStep\" button should prompted to click on KYC in Aggregator")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_KYC_aggregator() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroRiskInfo();

		} catch (AssertionError ae) {
			takeScreenshotStr("KYC"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	// RiskInfo

	@When("I visit the Risk Info")
	public void I_visit_RiskInfo() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnRiskInfo();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@Then("the FRMParameterscheckbox should be checked")

	public void the_FRMParameterscheckbox_shouldbe_checked() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			Thread.sleep(1000);

			B.checkboxGlobalfrm();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@Then("the FRMParameterscheckbox should be unchecked")

	public void the_FRMParameterscheckbox_shouldbe_unchecked() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.uncheckboxGlobalfrm();

			B.checkboxGlobalfrm();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@When("I click on the \"Velocity Check Minutes\" field in Risk Info")
	public void I_Click_On_the_VelocityCheckMinutes_Field() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnVelocityCheckMinute();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@Then("the label name should be \"Velocity Check Minutes\" in Risk Info")
	public void labelName_should_be_VelocityCheckMinutes() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.VelocityCheckMinuteLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@Then("the \"Velocity Check Minutes\" field should not allow proceeding without any input data in Risk Info")
	public void the_VelocityCheckMinutes_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnVelocityCheckMinute();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@Then("the \"Velocity Check Minutes\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Minutes_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String VelocityCheckMinutes = testdata.get(rowNumber).get("Velocity Check Minutes");

			if (VelocityCheckMinutes != null && VelocityCheckMinutes.matches("\\d+\\.0")) {
				VelocityCheckMinutes = VelocityCheckMinutes.substring(0, VelocityCheckMinutes.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.EnterOnVelocityCheckMinute(VelocityCheckMinutes);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@When("I click on the \"Velocity Check Count\" field in Risk Info")
	public void I_Click_On_the_VelocityCheckCount_Field() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnVelocityCheckCount();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the label name should be \"Velocity Check Count\" in Risk Info")
	public void labelName_should_be_Velocity_Check_Count() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.VelocityCheckCountLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"Velocity Check Count\" field should not allow proceeding without any input data in Risk Info")
	public void the_VelocityCheckCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnVelocityCheckCount();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"Velocity Check Count\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String VelocityCheckCount = testdata.get(rowNumber).get("Velocity Check Count");

			if (VelocityCheckCount != null && VelocityCheckCount.matches("\\d+\\.0")) {
				VelocityCheckCount = VelocityCheckCount.substring(0, VelocityCheckCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.EnterOnVelocityCheckCount(VelocityCheckCount);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Velocity Check Count", VelocityCheckCount);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@When("I click on the \"Cash@POS Count\" field in Risk Info")
	public void I_Click_On_the_CashPOSCount_Field() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnCashpOScount();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the label name should be \"Cash@POS Count\" in Risk Info")
	public void labelName_should_be_CashPOSCount() {
		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.CashpOScountLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"Cash@POS Count\" field should not allow proceeding without any input data in Risk Info")
	public void the_CashPOSCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnCashpOScount();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"Cash@POS Count\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_CashPOSCount_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String CashPOSCount = testdata.get(rowNumber).get("CashPOS Count");

			if (CashPOSCount != null && CashPOSCount.matches("\\d+\\.0")) {
				CashPOSCount = CashPOSCount.substring(0, CashPOSCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.EnterOnCashpOScount(CashPOSCount);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("CashPOSCount", CashPOSCount);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"Micro Atm Count\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_MicroAtmCount_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Count = testdata.get(rowNumber).get("Micro Atm Count");

			if (Count != null && Count.matches("\\d+\\.0")) {
				Count = Count.substring(0, Count.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.EnterOnMicroAtmcount(Count);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Micro Atm Count", Count);

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the label name should be \"International Card Acceptence\" in Risk Info")
	public void labelName_should_be_InternationalCardAcceptence() {
		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.InternationalcardCountLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"International Card Acceptence\" field should prompt to select Yes or No based on the given input in Risk Info using sheetname {string} and rownumber {int}")
	public void the_InternationalCardAcceptence_field_should_prompt_to_select_YesNO_basedon_the_given_input(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String card = testdata.get(rowNumber).get("International Card Acceptance");

			System.out.println("0" + testdata.get(0));

			A.ClickOnInternationalcardCount();

			B.selectDropdownOption(card);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("International Card Acceptance", card);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@When("I click on the \"ICA Daily\" field in Risk Info")
	public void I_Click_On_the_ICADaily_Field() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickonICAdaily();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the label name should be \"Daily\" in Risk Info")
	public void labelName_should_be_daily() {
		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.DailyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Daily\" field should not allow proceeding without any input data in Risk Info")
	public void the_ICADaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickonICAdaily();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Daily\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_ICADaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String ICADAILY = testdata.get(rowNumber).get("ICA Daily");

			if (ICADAILY != null && ICADAILY.matches("\\d+\\.0")) {
				ICADAILY = ICADAILY.substring(0, ICADAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.ClearonICAdaily();

				A.EnteronICAdaily(ICADAILY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("ICA DAILY", ICADAILY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

//ICA Weekly					

	@When("I click on the \"ICA Weekly\" field in Risk Info")
	public void I_Click_On_the_ICAWeekly_Field() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickonICAWeekly();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the label name should be \"Weekly\" in Risk Info")
	public void labelName_should_be_weekly() {

		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.WeeklyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Weekly\" field should not allow proceeding without any input data in Risk Info")
	public void the_ICAWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickonICAWeekly();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Weekly\" field Must be greater than \"ICA Daily\" in Risk Info using sheetname {string} and rownumber {int}")

	public void the_ICAWeekly_field_Mustbe_greaterthan_ICA_D(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

			if (ICAWEEKLY != null && ICAWEEKLY.matches("\\d+\\.0")) {
				ICAWEEKLY = ICAWEEKLY.substring(0, ICAWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.ClearonICAWeekly();
				A.EnteronICAWeekly(ICAWEEKLY);

				performTabKeyPress();

				B.MustbegreaterthanDailyLimit();

				A.ClearonICAWeekly();

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Weekly\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_ICAWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

			if (ICAWEEKLY != null && ICAWEEKLY.matches("\\d+\\.0")) {
				ICAWEEKLY = ICAWEEKLY.substring(0, ICAWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.ClearonICAWeekly();

				A.EnteronICAWeekly(ICAWEEKLY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("ICA WEEKLY", ICAWEEKLY);

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

//Monthly

	@When("I click on the \"ICA Monthly\" field in Risk Info")
	public void I_Click_On_the_ICAMonthly_Field() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickonICAMonthly();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the label name should be \"Monthly\" in Risk Info")
	public void labelName_should_be_Monthly() {
		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.MonthlyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Monthly\" field should not allow proceeding without any input data in Risk Info")
	public void the_ICAMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickonICAMonthly();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Monthly\" field Must be greater than \"ICA Weekly\" in Risk Info using sheetname {string} and rownumber {int}")

	public void the_ICAMonthly_field_Mustbe_greaterthan_ICA_Weekly(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

			if (ICAMonthly != null && ICAMonthly.matches("\\d+\\.0")) {
				ICAMonthly = ICAMonthly.substring(0, ICAMonthly.indexOf(".0"));
				System.out.println("0" + testdata.get(0));

				A.ClearonICAMonthly();

				A.EnteronICAMonthly(ICAMonthly);

				performTabKeyPress();

				B.Mustbegreaterthanweeklylimit();

				A.ClearonICAMonthly();

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"ICA Monthly\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_ICAmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

			if (ICAMonthly != null && ICAMonthly.matches("\\d+\\.0")) {
				ICAMonthly = ICAMonthly.substring(0, ICAMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				A.ClearonICAMonthly();

				A.EnteronICAMonthly(ICAMonthly);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("ICA MONTHLY", ICAMonthly);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	@Then("the \"NextStep\" button should be prompted to click on Risk Info")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_RiskInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroDiscountRate();

		} catch (AssertionError ae) {
			takeScreenshotStr("Risk Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	// Settlement Info

	@Then("the label name should be \"Settlement Mode\"")
	public void the_label_Name_Should_be_SettlementType() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.SettlementModeLabel();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Settlement Mode\" field should not allow proceeding without any input data")
	public void SettlementInfo_SettlementType_field_Shouldnot_allow_Proceeding_without_any_Input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnSettlementMode();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Settlement Mode\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_settlement_SettlementType_dropdown_Should_Prompt_toSelect_Valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String mode = testdata.get(rowNumber).get("Settlement Mode");

//			A.ClickOnSettlementInfo();

			A.ClickOnSettlementMode();

			B.selectDropdownOption(mode);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Settlement Mode", mode);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the label name should be \"Payment Flag\"")
	public void the_label_Name_Should_be_paymentflag() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.PaymentFlagLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Payment Flag\" field should not allow proceeding without any input data")
	public void SettlementInfo_PaymentFlag_field_Shouldnot_allow_Proceeding_without_any_Input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnPaymentFlag();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Payment Flag\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_settlement_PaymentFlag_dropdown_Should_Prompt_toSelect_Valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String payment = testdata.get(rowNumber).get("Payment Flag");

			A.ClickOnPaymentFlag();

			B.selectDropdownOption(payment);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Payment Flag", payment);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the \"NextStep\" button should prompted to click on Settlement Info in Aggregator")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_SettlementInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroWhiteLabel();

		} catch (AssertionError ae) {
			takeScreenshotStr("Settlement Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	// WhiteLabel

	@Then("the \"Whitelabel\" label name should be \"Allow to Create Merchant User\"")
	public void the_whitelabel_labelName_Shouldbe_CreateMerchantUser() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.AllowtocreateMerchantLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the Whitelabel \"Allow to Create Merchant User\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_MerchantUser_dropdown_should_prompt_to_select_valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String payment = testdata.get(rowNumber).get("Allow to create merchant onboard");

			A.ClickOnAllowCreateMerchantOnboard();

			B.selectDropdownOption(payment);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Allow to create merchant onboard", payment);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the \"Whitelabel\" label name should be \"UserName As\"")
	public void the_whitelabel_labelName_Shouldbe_UserNameAs() {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.UserNameAsLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the Whitelabel \"UserName As\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_UserNameAs_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String usernameAs = testdata.get(rowNumber).get("UsernamAs");

			A.ClickOnUserNameAs();

			B.selectDropdownOption(usernameAs);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Usernam As", usernameAs);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the \"NextStep\" button should prompted to click on Whitelabel in Aggregator")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_Whitelabel() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroWebhook();

		} catch (AssertionError ae) {
			takeScreenshotStr("Whitelabel"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

//Discount Rate

	@When("I visit the Discount Rate")
	public void I_visit_the_Discount_Rate() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnDiscountRate();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate");
			throw e;
		}
	}

	@Then("the Discount Rate \"ADD\" button should be prompted to click")
	public void the_DiscountRate_ADD_button_should_be_prompted_to_click() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			B.ChannelADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate");
			throw e;
		}
	}

	@Then("the POS \"Pricing Plan\" field should prompt to select the channels based on the given input in Aggregator")
	public void POS_PricingPlan_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnDiscountRatePricingPlan();

			A.SelectOnPOSPricingPlan();

//			Robot r = new Robot();
//
//			r.keyPress(KeyEvent.VK_TAB);
//
//			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate");
			throw e;
		}
	}

	@Then("the AEPS \"Pricing Plan\" field should prompt to select the channels based on the given input in Aggregator")
	public void AEPS_PricingPlan_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnDiscountRatePricingPlan();

			A.SelectOnAEPSPricingPlan();

//    			Robot r = new Robot();

//    			r.keyPress(KeyEvent.VK_TAB);

//    			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate");
			throw e;
		}
	}

	@Then("the UPI \"Pricing Plan\" field should prompt to select the channels based on the given input in Aggregator")
	public void UPI_PricingPlan_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnDiscountRatePricingPlan();

			A.SelectOnUPIPricingPlan();

//			Robot r = new Robot();

//			r.keyPress(KeyEvent.VK_TAB);

//			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate");
			throw e;
		}
	}

	@Then("the DiscountRate \"Save\" button should be prompted to click")
	public void the_savebutton_shouldbe_prompted_toclick_On_discountRate() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			A = new org.Locators.AggregatorLocators(driver);

			A.ClickOnSAVEPersonal();

		} catch (AssertionError ae) {
			takeScreenshotStr("Discount Rate"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("The \"NextStep\" button should prompted to click on Discount Rate")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_DiscountRate() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		try {

			B.ClickOnNextStep();

			A.DisplayedOnIntroSettlement();

		} catch (AssertionError ae) {
			takeScreenshotStr("Settlement Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"NextStep\" button should prompted to click on Webhook in Aggregator")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_Aggregator() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		try {
			B.ClickOnNextStep();

			B.DisplayedOnstatusHistory();

		} catch (AssertionError ae) {
			takeScreenshotStr("Webhook"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

//Merchant

	private void takeScreenshotStr(String rowNumber) {
		try {
			// Take a screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" + rowNumber
					+ ".png";

			// Save the screenshot to the specified path
			FileUtils.copyFile(screenshot, new File(screenshotPath));

			// Attach the screenshot to the Allure report
			Allure.addAttachment("Screenshot for Row " + rowNumber,
					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

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

}
