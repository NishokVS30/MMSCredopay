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
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class BankOnboardingTestcases {

	private WebDriver driver;

	org.Locators.LoginLocators L;
	org.Locators.BankLocators B;

	private ExtentTest test;
	
	ExcelDataCache cache = ExcelDataCache.getInstance();
	
//	@Before("@loadDataExcelReader") 
//    public static void setUp() throws InvalidFormatException, IOException {
//       ExcelDataCache cache = ExcelDataCache.getInstance();
//        System.out.println("BEFORE ALL WORK");
//        cache.loadData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx"); // Load data only once
//    }
	
	
	public BankOnboardingTestcases() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}
	
	 

	@Given("I visit the SuperAdmin Login using sheetname {string} and rownumber {int}")
	public void i_visit_the_SuperAdmin_maker_login(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {

		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

		try {

			// ExcelDataCache cache = ExcelDataCache.getInstance();
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

		} catch (Exception e) {

			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}

	}

	@And("I enter the credentials and click the login button")
	public void i_enter_the_credentials_and_click_the_login_button() throws InterruptedException {

		try {
			L = new org.Locators.LoginLocators(driver);
			Thread.sleep(9000);
			L.ClickOnSignIn();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}
	}

	@Given("I visit the System Maker Login using sheetname {string} and rownumber {int}")
	public void i_visit_the_System_maker_login(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {

		try {
			
			
			// ExcelDataCache cache = ExcelDataCache.getInstance();
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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}
	}

	@And("I enter the credentials and click a login button")
	public void i_enter_the_credentials_and_click_a_login_button() throws InterruptedException {

		try {
			L = new org.Locators.LoginLocators(driver);
			Thread.sleep(9000);
			L.ClickOnSignIn();

			L.ClickOnOk();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}

	}

	@Given("I visit the bank onboarding page in Super Admin")
	public void I_visit_the_bank_onboarding_page_SuperAdmin() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		try {

			B.ClickOnDownArrowSuperAdmin();

			B.ClickOnOnboarding();

			B.ClickOnOnBank();

			B.ClickOnCreatebutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding List");
			throw e;
		}

	}

	@Given("I visit the bank onboarding page")
	public void I_visit_the_bank_onboarding_page() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		try {

			B.ClickOnDownArrow();

			B.ClickOnOnboarding();

			B.ClickOnOnBank();

			B.ClickOnCreatebutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding List");
			throw e;
		}

	}

	@When("I Visit the General Info")
	public void I_visit_the_GeneralInfo() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			B.CLickOnGenralInfo();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@When("I click on the \"Bank Name\" field")
	public void I_click_on_the_Bank_Name() {

		B = new org.Locators.BankLocators(driver);

		B.ClickonBankName();

	}

	@Then("the label name should be \"Bank Name\"")
	public void the_label_name_should_be_BankName() {

		B = new org.Locators.BankLocators(driver);

		B.BankNameLabel();

	}

	@Then("the \"Bank Name\" field should prompt to enter valid inputs within 30 characters using sheetname {string} and rownumber {int}")
	public void Bank_name_field_should_prompt_to_enter_valid_inputs_within_30_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			String Bankname = testdata.get(rowNumber).get("BankName");

			B.ClickonBankName();

			B.EnteronBankName(Bankname);

			String enteredBankName = B.getBankName();

			assertTrue("Bank Name field does not accept valid input within 30 characters.",
					enteredBankName.length() <= 30);

			performTabKeyPress();

			LoginInputDatas("Bank Name", Bankname);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Bank Name\" field should prompts for invalid input if more than 30 characters are entered using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifmore_than30characters_are_entered(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

		        List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Bankname = testdata.get(rowNumber).get("BankName");

			System.out.println("0" + testdata.get(0));

			B.ClickonBankName();

			B.EnteronBankName(Bankname);

			String enteredBankName = B.getBankName();

			assertTrue("Bank Name field does not accept valid input within 30 characters.",
					enteredBankName.length() <= 30);

			performTabKeyPress();

			B.clearBankName();

			LoginInputDatas("Bank Name", Bankname);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the \"Bank Name\" field should prompts for Invalid inputs within Lessthan 30 characters using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifless_than30characters_are_entered(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Bankname = testdata.get(rowNumber).get("BankName");

			System.out.println("0" + testdata.get(0));

			B.EnteronBankName(Bankname);

			String enteredBankName = B.getBankName();
			assertTrue("Bank Name field does not accept valid input within 30 characters.",
					enteredBankName.length() <= 30);

			performTabKeyPress();

			B.clearBankName();

			LoginInputDatas("Bank Name", Bankname);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the \"Bank Name\" field prompts for invalid input if a number is entered using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifanumberis_entered(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			 

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Bankname = testdata.get(rowNumber).get("BankName");

			System.out.println("0" + testdata.get(0));

			B.EnteronBankName(Bankname);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearBankName();

			LoginInputDatas("Bank Name", Bankname);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Bank Name\" field prompts for invalid input if special characters are entered using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifaSpecialCharacter_are_entered(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Bankname = testdata.get(rowNumber).get("BankName");

			System.out.println("0" + testdata.get(0));

			B.EnteronBankName(Bankname);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearBankName();

			LoginInputDatas("Bank Name", Bankname);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Bank Name\" field should not allow to proceed without any input data")
	public void the_BankName_field_should_not_allow_to_proceed_without_any_input_data() throws AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonBankName();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@When("I click on the \"Address\" field")
	public void I_ClickOn_AddressField() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonAddressLine();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the label name should be \"Address\"")
	public void labelName_Should_be_Address() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.AddressLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Address\" field should prompt to enter valid inputs within 230 characters using sheetname {string} and rownumber {int}")
	public void theAddress_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();
		        List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Address = testdata.get(rowNumber).get("Address");

			System.out.println("0" + testdata.get(0));

			B.ClickonAddressLine();

			B.EnterOnAddress(Address);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Address", Address);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Address\" field should not allow to proceed without any input data")
	public void the_Address_field_shouldnotallowto_proceed_withoutanyinput_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonAddressLine();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@When("I click on the \"Pincode\" field")
	public void I_click_on_the_PincodeField() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPincode();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the label name should be \"Pincode\"")
	public void the_label_name_should_be_Pincode() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.PincodeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the \"Pincode\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void thePincode_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();
		        List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String pincode = testdata.get(rowNumber).get("Pincode");

			if (pincode != null && pincode.matches("\\d+\\.0")) {
				pincode = pincode.substring(0, pincode.indexOf(".0"));

				B.ClickonPincode();

				System.out.println("0" + testdata.get(0));

				B.selectDropdownOption(pincode);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Pincode", pincode);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the \"Pincode\" field should not allow to proceed without any input data")
	public void the_Pincode_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPincode();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the city name should be displayed.")
	public void the_cityname_should_be_displayed() {

		try {

			B = new org.Locators.BankLocators(driver);

			String City = B.getCity();
			assertEquals("chennai", City);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the state name should be displayed.")
	public void the_statename_should_be_displayed() {

		try {

			B = new org.Locators.BankLocators(driver);

			String State = B.getState();
			assertEquals("tamilnadu", State);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the Country name should be displayed.")
	public void the_Countryname_should_be_displayed() {

		try {

			B = new org.Locators.BankLocators(driver);

			String Country = B.getCountry();
			assertEquals("d test", Country);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the Currency Code name should be displayed.")
	public void the_Currencycode_should_be_displayed() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			String CurrencyCode = B.getCurrencycode();
			assertEquals("588", CurrencyCode);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@When("I click on the \"GST\" field")
	public void I_Click_on_the_GST_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnGst();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the label name should be \"GST\"")
	public void labelName_should_be_GST() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.GSTLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"GST\" field should prompt to enter valid inputs with GST format using sheetname {string} and rownumber {int}")
	public void the_GST_field_should_prompt_to_enter_valid_inputs_with_GST_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();
		        List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			String gst = testdata.get(rowNumber).get("GST");

			System.out.println("0" + testdata.get(0));

			B.ClickOnGst();

			B.EnterOnGst(gst);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("GST", gst);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"GST\" field should prompt to enter Invalid inputs with GST format using sheetname {string} and rownumber {int}")
	public void the_GST_field_should_prompt_to_enter_Invalid_inputs_with_GST_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String gst = testdata.get(rowNumber).get("GST");

			B.EnterOnGst(gst);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearGst();

			LoginInputDatas("GST", gst);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the \"GST\" field should not allow to proceed without any input data")
	public void the_GST_field_shouldnotallow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			B.ClickOnGst();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

//PAN

	@When("I click on the \"PAN\" field")
	public void I_Click_on_the_PAN_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPan();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the label name should be \"PAN\"")
	public void labelName_should_be_PAN() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.PANLabel();

		} catch (Exception e) {
			takeScreenshotStr("General Info"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"PAN\" field should prompt to enter valid inputs with PAN format using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_valid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String pan = testdata.get(rowNumber).get("PAN");

			System.out.println("0" + testdata.get(0));

			B.ClickonPan();

			B.EnterOnPAN(pan);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("PAN", pan);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the \"PAN\" field should prompt to enter Invalid inputs with PAN format using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_Invalid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String pan = testdata.get(rowNumber).get("PAN");

			B.EnterOnPAN(pan);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.ClearPAN();

			LoginInputDatas("PAN", pan);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"PAN\" field should not allow to proceed without any input data")
	public void the_PAN_field_shouldnotallow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPan();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@When("I click on the \"Marsid\" field")
	public void I_Click_on_the_Marsid_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonMarsid();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the label name should be \"Marsid\"")
	public void labelName_should_be_Marsid() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.MarsidLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"MarsId\" field	should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void Marsid_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String marsid = testdata.get(rowNumber).get("Mars id");

			if (marsid != null && marsid.matches("\\d+\\.0")) {
				marsid = marsid.substring(0, marsid.indexOf(".0"));

				B.EnteronMarsid(marsid);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Marsid", marsid);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@When("I click on the \"Statement Frequency\" field")
	public void Iclick_on_the_StatementFrequency_field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnStatementFrequency();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the label name should be \"Statement Frequency\"")
	public void labelName_should_be_StatementFrequency() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.StatementFrequencyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Statement Frequency\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Statement_Frequency_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String StatementFrequency = testdata.get(rowNumber).get("Statement Frequency");

			B.ClickOnStatementFrequency();

			B.selectDropdownOption(StatementFrequency);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Statement Frequency", StatementFrequency);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@When("I click on the \"Statement Type\" field")
	public void Iclick_on_the_StatementType_field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnStatementType();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the label name should be \"Statement Type\"")
	public void labelName_should_be_StatementType() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.StatementTypeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Statement Type\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Statement_Type_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String StatementType = testdata.get(rowNumber).get("Statement Type");

			B.ClickOnStatementType();

			B.selectDropdownOption(StatementType);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Statement Type", StatementType);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@When("I click on the \"Domain\" field")
	public void Iclick_on_the_Domain_field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnDomain();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the label name should be \"Domain\"")
	public void labelName_should_be_Domain() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.DomainLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Domain\" field should not allow to proceed without any input data")
	public void the_Domainfield_shouldnot_allowtoproceed_withoutany_inputdata()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnDomain();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			takeScreenshotStr("General Info"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"Domain\" field should prompt to enter valid domain names using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String domain = testdata.get(rowNumber).get("Domain");

			B.EnterOnDomain(domain);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Domain", domain);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Domain\" field should prompt to enter invalid alphabet domain names using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_Invalid_Alphabetinputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String domain = testdata.get(rowNumber).get("Domain");

			B.EnterOnDomain(domain);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.Domainclear();

			LoginInputDatas("Domain", domain);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}
	}

	@Then("the \"Domain\" field should prompt to enter invalid number domain names using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_Invalid_Numbers_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String domain = testdata.get(rowNumber).get("Domain");

			B.EnterOnDomain(domain);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.Domainclear();

			LoginInputDatas("Domain", domain);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("To verify if the \"Save\" button is prompted to click and a success popup is displayed using sheetname {string} and rownumber {int}")

	public void To_verify_if_the_Save_button_is_prompted_to_click_and_success_popup_is_displayed(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			L = new org.Locators.LoginLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Bankname = testdata.get(rowNumber).get("BankName");

			System.out.println("0" + testdata.get(0));

			B.clearBankName();

			B.EnteronBankName(Bankname);

			String enteredBankName = B.getBankName();

			assertTrue("Bank Name field does not accept valid input within 30 characters.",
					enteredBankName.length() <= 30);

			performTabKeyPress();

			B.ClickOnSaveasdraft();

			L.DisplayedOnOK();

			L.ClickOnOk();

		} catch (AssertionError ae) {
			takeScreenshotStr("General Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@When("I visit the Communication Info")
	public void I_visit_the_Communication_Info() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.DisplayedOnCommunicationInfo();

			B.CLickOnCommunicationInfo();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Add\" button should be prompted to click")
	public void the_Add_button_should_be_prompted_to_click() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.CommADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Settlement & Recon Contact Details Add\" button should be prompted to click")
	public void the_Settlementand_Recon_Contact_Details_Add_button_should_be_prompted_to_click()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.CommSettlementandReconADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}
	}

//CommunicationName

	@When("I click on the \"Communication Name\" field")
	public void I_Click_on_the_Name_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCommName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}
	}

	@Then("the label name should be \"Name\"")
	public void labelName_should_be_Name() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Communication Name\" field should not allow proceeding without any input data")
	public void the_Communication_Name_field_Shouldnot_allow_Proceeding_without_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCommName();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}
	}

	@Then("the \"Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationName = testdata.get(rowNumber).get("Communication Name");

			System.out.println("0" + testdata.get(0));

			B.EnterOnCommName(CommunicationName);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Communication Name", CommunicationName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Name\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationName = testdata.get(rowNumber).get("Communication Name");

			System.out.println("0" + testdata.get(0));

			B.EnterOnCommName(CommunicationName);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearCommunicationName();

			test = ExtentCucumberAdapter.getCurrentStep();

			LoginInputDatas("Communication Name", CommunicationName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}
	}

	@Then("the \"Name\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationName = testdata.get(rowNumber).get("Communication Name");

			System.out.println("0" + testdata.get(0));

			B.EnterOnCommName(CommunicationName);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearCommunicationName();

			LoginInputDatas("Communication Name", CommunicationName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

//Position

	@When("I click on the \"Position\" field")
	public void I_Click_on_the_Position_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCommPosition();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the label name should be \"Position\"")
	public void labelName_should_be_Position() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommPosition();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Position\" field should not allow proceeding without any input data")
	public void the_Position_field_Shouldnot_allow_Proceeding_without_any_input_data()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCommPosition();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Position\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_position_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationPosition = testdata.get(rowNumber).get("Communication Position");

			System.out.println("0" + testdata.get(0));

			B.EnterOnCommunicationPosition(CommunicationPosition);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Communication Position", CommunicationPosition);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Position\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Position_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationPosition = testdata.get(rowNumber).get("Communication Position");

			System.out.println("0" + testdata.get(0));

			B.EnterOnCommunicationPosition(CommunicationPosition);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearCommunicationPosition();

			LoginInputDatas("Communication Position", CommunicationPosition);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Position\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Position_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationPosition = testdata.get(rowNumber).get("Communication Position");

			System.out.println("0" + testdata.get(0));

			B.EnterOnCommunicationPosition(CommunicationPosition);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearCommunicationPosition();

			LoginInputDatas("Communication Position", CommunicationPosition);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

//PhoneNumber

	@When("I click on the \"Phone Number\" field")
	public void I_Click_On_the_Phonenumber_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCommPhoneNumber();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the label name should be \"Phone Number\"")
	public void the_label_name_shouldbe_PhoneNumber() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommPhoneNumber();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Phone Number\" field should not allow inputs with fewer digits than required using sheetname {string} and rownumber {int}")
	public void the_Phone_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationPhonenumber = testdata.get(rowNumber).get("Communication PhoneNumber");

			System.out.println("0" + testdata.get(0));

			B.EnteronCommPhoneNumber(CommunicationPhonenumber);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearCommunicationPhoneNumber();

			LoginInputDatas("Communication PhoneNumber", CommunicationPhonenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Phone Number\" field should not allow inputs with more digits than required using sheetname {string} and rownumber {int}")
	public void the_Phone_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationPhonenumber = testdata.get(rowNumber).get("Communication PhoneNumber");

			System.out.println("0" + testdata.get(0));

			B.EnteronCommPhoneNumber(CommunicationPhonenumber);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearCommunicationPhoneNumber();

			LoginInputDatas("Communication PhoneNumber", CommunicationPhonenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Phone Number\" field should not allow numbers that do not start with the digit 0 using sheetname {string} and rownumber {int}")
	public void the_Phome_field_should_not_allow_numbers_numbers_that_do_not_start_with_the_digit_0(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationPhonenumber = testdata.get(rowNumber).get("Communication PhoneNumber");

			System.out.println("0" + testdata.get(0));

			B.EnteronCommPhoneNumber(CommunicationPhonenumber);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.clearCommunicationPhoneNumber();

			LoginInputDatas("Communication PhoneNumber", CommunicationPhonenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Phone Number\" field should prompt to enter valid inputs")

	public void the_PhoneNumberfield_shouldprompt_toenter_validinputs(List<Map<String, String>> dataTable)
			throws InterruptedException, AWTException {
		for (Map<String, String> row : dataTable) {

			try {

				B = new org.Locators.BankLocators(driver);
				L = new org.Locators.LoginLocators(driver);

				String Phonenumber = row.get("PhoneNumber");
				B.EnteronCommPhoneNumber(Phonenumber);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

			} catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver,
						ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Communication Info");
				throw e;
			}

		}
	}

//MobileNumber

	@When("I click on the \"Mobile Number\" field")
	public void I_Click_On_the_Mobilenumber_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonCommMobileNumber();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the label name should be \"Mobile Number\"")
	public void the_label_name_shouldbe_MobileNumber() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommMobileNumber();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Mobile Number\" field should not allow inputs with fewer digits than required using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationMobilenumber = testdata.get(rowNumber).get("Communication MobileNumber");

			System.out.println("0" + testdata.get(0));

			B.EnteronCommMobileNumber(CommunicationMobilenumber);

			performTabKeyPress();

			B.DisplayedOnShouldbe30digits();

			B.clearCommunicationMobileNumber();

			LoginInputDatas("Communication MobileNumber", CommunicationMobilenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Mobile Number\" field should not allow inputs with more digits than required using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CommunicationMobilenumber = testdata.get(rowNumber).get("Communication MobileNumber");

			System.out.println("0" + testdata.get(0));

			B.EnteronCommMobileNumber(CommunicationMobilenumber);

			String enteredMobileNumber = B.getMobileNumber();
			assertTrue("Mobile Number field allows more than 10 digits.", enteredMobileNumber.length() <= 10);

			performTabKeyPress();

			B.clearCommunicationMobileNumber();

			LoginInputDatas("Communication MobileNumber", CommunicationMobilenumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

//	@Then("the \"Mobile Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
//	public void the_Mobile_field_should_promptto_enter_valid_inputs(String sheetName, int rowNumber)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//		try {
//			B = new org.Locators.BankLocators(driver);
//
//			// ExcelDataCache cache = ExcelDataCache.getInstance();
//			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
//					
//
//			System.out.println("Sheet name: " + sheetName);
//
//			// Fetch the mobile number for the specified row
//			String communicationMobileNumber = String
//					.valueOf(testdata.get(rowNumber).get("Communication MobileNumber"));
//			System.out.println("Mobile Number: " + communicationMobileNumber);
//
//			// Remove scientific notation if present
//			if (communicationMobileNumber.contains("E")) {
//				Double mobileNumber = Double.valueOf(communicationMobileNumber);
//				communicationMobileNumber = String.format("%.0f", mobileNumber); // Convert to string without decimal
//			}
//
//			B.EnteronCommMobileNumber(communicationMobileNumber);
//
//			// Consider replacing with explicit wait
//			performTabKeyPress();
//			// Consider replacing with explicit wait
//
//			// Validate mobile number format
//			B.NOTDisplayedOnInvalidFormat();
//
//			// Log input data
//			LoginInputDatas("Communication MobileNumber", communicationMobileNumber);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Communication Info");
//			throw e;
//		}
//	}
	
	
	@Then("the \"Mobile Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {

	    try {
	        B = new org.Locators.BankLocators(driver);
	        
	        // Initialize Faker
	        Faker faker = new Faker();

	        // Generate a valid mobile number starting with 9, 8, 7, or 6
	        String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9
	        String remainingDigits = faker.number().digits(9); // Generate 9 random digits
	        String communicationMobileNumber = firstDigit + remainingDigits;
	        
	        System.out.println("Generated Mobile Number: " + communicationMobileNumber);

	        B.EnteronCommMobileNumber(communicationMobileNumber);

	        // Consider replacing with explicit wait
	        performTabKeyPress();
	        // Consider replacing with explicit wait

	        // Validate mobile number format
	        B.NOTDisplayedOnInvalidFormat();

	        // Log input data
	        LoginInputDatas("Communication MobileNumber", communicationMobileNumber);

	    } catch (Exception e) {
	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	        exceptionHandler.handleException(e, "Communication Info");
	        throw e;
	    }
	}



	@Then("the \"Mobile Number\" field should not allow proceeding without any input data")
	public void the_MobileNumber_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonCommMobileNumber();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

//Emailid

	@When("I click on the \"Email ID\" field")
	public void I_Click_On_the_emailid_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonCommEmailid();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the label name should be \"Email ID\"")
	public void the_label_name_shouldbe_Emailid() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommEmailid();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow proceeding without any input data")
	public void the_EmailID_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonCommEmailid();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow inputs missing the '@' symbol using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_symbol(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

			System.out.println("0" + testdata.get(0));

			B.ClearCommEmailid();

			B.EnteronCommEmailid(Communicationemailid);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.ClearCommEmailid();

			LoginInputDatas("Communication EmailID", Communicationemailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow inputs missing the domain name using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_domainname(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

			System.out.println("0" + testdata.get(0));

			B.ClearCommEmailid();

			B.EnteronCommEmailid(Communicationemailid);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.ClearCommEmailid();

			LoginInputDatas("Communication EmailID", Communicationemailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow consecutive dots in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_consective_dots_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

			System.out.println("0" + testdata.get(0));

			B.ClearCommEmailid();

			B.EnteronCommEmailid(Communicationemailid);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.ClearCommEmailid();

			LoginInputDatas("Communication EmailID", Communicationemailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Email ID\" field should not allow spaces in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_spaces_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

			System.out.println("0" + testdata.get(0));

			B.ClearCommEmailid();

			B.EnteronCommEmailid(Communicationemailid);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.ClearCommEmailid();

			LoginInputDatas("Communication EmailID", Communicationemailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

//	@Then("the \"Email ID\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
//	public void the_EmailID_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//		try {
//
//			B = new org.Locators.BankLocators(driver);
//
//			// ExcelDataCache cache = ExcelDataCache.getInstance();
//
//			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
//					
//
//			System.out.println("sheet name: " + testdata);
//
//			String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");
//
//			System.out.println("0" + testdata.get(0));
//
//			B.ClearCommEmailid();
//
//			B.EnteronCommEmailid(Communicationemailid);
//
//			performTabKeyPress();
//
//			B.NOTDisplayedOnInvalidFormat();
//
//			LoginInputDatas("Communication EmailID", Communicationemailid);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Communication Info");
//			throw e;
//		}
//
//	}
	
	
	@Then("the \"Email ID\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {

	    try {
	        B = new org.Locators.BankLocators(driver);

	        // Initialize Faker
	        Faker faker = new Faker();

	        // Generate a random email address with @gmail.com
	        String randomEmailPrefix = faker.internet().slug(); // Generate a random string for the prefix
	        String Communicationemailid = randomEmailPrefix + "@gmail.com"; // Append @gmail.com
	        System.out.println("Generated Email ID: " + Communicationemailid);

	        B.ClearCommEmailid();
	        B.EnteronCommEmailid(Communicationemailid);

	        performTabKeyPress();

	        // Validate the email format
	        B.NOTDisplayedOnInvalidFormat();

	        // Log input data
	        LoginInputDatas("Communication EmailID", Communicationemailid);

	    } catch (Exception e) {
	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	        exceptionHandler.handleException(e, "Communication Info");
	        throw e;
	    }
	}


	@When("I click on the \"UserName\" field")
	public void I_Click_On_the_UserName_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCommUsername();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the label name should be \"UserName\"")
	public void the_label_name_shouldbe_UserName() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommUserName();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Username\" field should be auto-filled based on the entered email ID using sheetname {string} and rownumber {int}")
	public void the_Username_field_should_be_autofilled_based_on_the_entered_emailID(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

			String autoFilledUsername = B.getUsername();

			assertEquals(Communicationemailid, autoFilledUsername);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Communication UserName", Communicationemailid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the label name should be \"AD User\"")
	public void the_label_name_should_be_ADUser() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelCommADUser();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"AD User\" field should prompt to select Yes or No based on the given input using sheetname {string} and rownumber {int}")
	public void the_ADUser_field_should_prompt_to_select_YesNO_basedon_the_given_input(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String ADUSer = testdata.get(rowNumber).get("AD User");

			B.ClickOnAdUser();

			B.selectDropdownOption(ADUSer);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("AD USER", ADUSer);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e;
		}

	}

	@Then("the \"Save\" button should be prompted to click on Communication Info")
	public void the_savebutton_shouldbe_prompted_toclick_On_COmmunicationInfo() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CommuSavebutton();

		} catch (AssertionError ae) {
			takeScreenshotStr("Communication Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("The \"NextStep\" button should prompt a click on Communication Info")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_COmmunicationInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {

			B.ClickOnNextStep();

			B.DisplayedOnChannelConfiguration();

		} catch (AssertionError ae) {
			takeScreenshotStr("ONUS"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@When("I visit the Channel Config")

	public void I_visit_the_Channel_config() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.DisplayedOnChannelConfig();

			B.CLickOnChannelConfig();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the label name should be \"Channel\"")
	public void labelName_should_be_Channel() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelChannel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the label name should be \"Network\"")
	public void labelName_should_be_Network() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelNetwork();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the label name should be \"Transaction Sets\"")
	public void labelName_should_be_TransactionSets() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelTransactionSet();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the label name should be \"Routing\"")
	public void labelName_should_be_Routing() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.LabelRouting();

		} catch (Exception e) {
			takeScreenshotStr("Channel Config"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"POS Channel\" field should prompt to select the channels based on the given input")
	public void the_Channel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonChannel();

			B.SelectonPOSChannel();

			String selectonPOSChannel = B.getSelectonPOSChannel();

			LoginInputDatas("Channel", selectonPOSChannel);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"UPI Channel\" field should prompt to select the channels based on the given input")
	public void the_UPIChannel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonChannel();

			B.SelectonUPIChannel();

			String selectonUPIChannel = B.getSelectonUPIChannel();

			LoginInputDatas("Channel", selectonUPIChannel);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"AEPS Channel\" field should prompt to select the channels based on the given input")
	public void the_AEPSChannel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonChannel();

			B.SelectonAEPSChannel();

			String selectonAEPSChannel = B.getSelectonAEPSChannel();

			LoginInputDatas("Channel", selectonAEPSChannel);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"MATM Channel\" field should prompt to select the channels based on the given input")
	public void the_MATMChannel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonChannel();

			B.SelectonMATMChannel();

			String selectonAEPSChannel = B.getSelectonAEPSChannel();

			LoginInputDatas("Channel", selectonAEPSChannel);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"POS Network\" field should prompt to select the Network based on the given input")
	public void the_Network_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonNetwork();

			B.SelectonNetworkPOS();

			String selectonPosNetwork = B.getSelectonNetworkPOS();

			LoginInputDatas("Network", selectonPosNetwork);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"MATM Network\" field should prompt to select the Network based on the given input")
	public void the_MATMNetwork_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonNetwork();

			B.SelectonNetworkMATM();

			String selectonPosNetwork = B.getSelectonNetworkMATM();

			LoginInputDatas("Network", selectonPosNetwork);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"POS Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_TransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonTransactionsetPoS();

			B.SelectonTransactionsetpos();

			String SelectonTransactionsetpos = B.getSelectonTransactionsetpos();

			LoginInputDatas("Transaction Set", SelectonTransactionsetpos);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"UPI Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_UPITransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonTransactionset();

			B.SelectonTransactionsetkUPI();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			String SelectonTransactionsetkUPI = B.getSelectonTransactionsetkUPI();

			LoginInputDatas("Transaction Set", SelectonTransactionsetkUPI);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"AEPS Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_AEPSTransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonTransactionset();

			B.SelectonTransactionsetAEPS();

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			String SelectonTransactionsetAEPS = B.getSelectonTransactionsetAEPS();

			LoginInputDatas("Transaction Set", SelectonTransactionsetAEPS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"MATM Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_MATMTransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonTransactionsetPoS();

			B.SelectonTransactionsetMATM();

			String SelectonTransactionsetpos = B.getSelectonTransactionsetkMATM();

			LoginInputDatas("Transaction Set", SelectonTransactionsetpos);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"POS Routing\" field should prompt to select the routing based on the given input")
	public void the_Routing_fieldshouldprompt_toselect_theroutingsbased_onthe_giveninput() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonRouting();

			B.SelectonRouting();

			String SelectonRouting = B.getSelectonRouting();

			LoginInputDatas("Routing", SelectonRouting);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"MATM Routing\" field should prompt to select the routing based on the given input")
	public void the_MATMRouting_fieldshouldprompt_toselect_theroutingsbased_onthe_giveninput()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.clickonRouting();

			B.SelectonRoutingMATM();

			String SelectonRouting = B.getSelectonRouting();

			LoginInputDatas("Routing", SelectonRouting);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}
	}

	@Then("the \"Save\" button should be prompted to click on Channel COnfig")
	public void the_Save_button_should_be_prompted_to_click_on_Channel_COnfig() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CommuSavebutton();

		} catch (AssertionError ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"NextStep\" button should be prompted to click on channel config")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_COmmunicationconfig() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnNextStep();

			B.DisplayedOnRoutingONUS();

		} catch (AssertionError | Exception ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

//ONUS

	@When("I visit the ONUS Routing")

	public void I_visit_the_ONUS_Routing() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.DisplayedOnRoutingONUS();

			B.CLickOnONUSRouting();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "ONUS");
			throw e;
		}
	}

	@Then("the \"POS ADD BIN\" field should prompt to select the Bin based on the given input using sheetname {string} and rownumber {int}")
	public void the_POSAddbin_field_should_prompt_to_select_thebin_basedonthegiveninput(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String BIN = testdata.get(rowNumber).get("ONUS Routing POS");

			if (BIN != null && BIN.matches("\\d+\\.0")) {
				BIN = BIN.substring(0, BIN.indexOf(".0"));

				B.ActionOnONUSButton();

				B.addbin();

				B.ClickonADDBIN();

				System.out.println("0" + testdata.get(0));

				B.EnterOnAddBin(BIN);

				performTabKeyPress();

				B.SubmitOnONUS();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("POS BIN", BIN);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "ONUS");
			throw e;
		}
	}

	@Then("the \"MATM ADD BIN\" field should prompt to select the Bin based on the given input using sheetname {string} and rownumber {int}")
	public void the_Addbin_field_should_prompt_to_select_thebin_basedonthegiveninput(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String BIN = testdata.get(rowNumber).get("ONUS Routing MATM");

			if (BIN != null && BIN.matches("\\d+\\.0")) {
				BIN = BIN.substring(0, BIN.indexOf(".0"));

				B.ActionOnONUSButton2();

				B.addbin();

				B.ClickonADDBIN();

				System.out.println("0" + testdata.get(0));

				B.EnterOnAddBin(BIN);

				performTabKeyPress();

				B.SubmitOnONUS();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("MATM BIN", BIN);

			}

		} catch (Exception e) {
			takeScreenshotStr("ONUS"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"NextStep\" button should be prompted to click on ONUS Routing")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_ONUSRouting() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnNextStep();

			B.DisplayedOnGlobalFRMParameters();

		} catch (AssertionError ae) {
			takeScreenshotStr("ONUS"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@When("I visit the Global FRM")
	public void I_visit_GlobalFRM() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			driver.navigate().refresh();

			B.CLickOnglobalfrm();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the GlobalFRMcheckbox should be checked")

	public void the_GlobalFRMcheckbox_shouldbe_checked() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.checkboxGlobalfrm();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the GlobalFRMcheckbox should be unchecked")

	public void the_GlobalFRMcheckbox_shouldbe_unchecked() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.uncheckboxGlobalfrm();

			B.checkboxGlobalfrm();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@When("I click on the \"Velocity Check Minutes\" field")
	public void I_Click_On_the_VelocityCheckMinutes_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnVelocityCheckMinute();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the label name should be \"Velocity Check Minutes\"")
	public void labelName_should_be_VelocityCheckMinutes() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.VelocityCheckMinuteLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"Velocity Check Minutes\" field should not allow proceeding without any input data")
	public void the_VelocityCheckMinutes_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnVelocityCheckMinute();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"Velocity Check Minutes\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Minutes_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String VelocityCheckMinutes = testdata.get(rowNumber).get("Velocity Check Minutes");

			if (VelocityCheckMinutes != null && VelocityCheckMinutes.matches("\\d+\\.0")) {
				VelocityCheckMinutes = VelocityCheckMinutes.substring(0, VelocityCheckMinutes.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnVelocityCheckMinute(VelocityCheckMinutes);

//				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Velocity Check Minutes", VelocityCheckMinutes);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@When("I click on the \"Velocity Check Count\" field")
	public void I_Click_On_the_VelocityCheckCount_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnVelocityCheckCount();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the label name should be \"Velocity Check Count\"")
	public void labelName_should_be_Velocity_Check_Count() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.VelocityCheckCountLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"Velocity Check Count\" field should not allow proceeding without any input data")
	public void the_VelocityCheckCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnVelocityCheckCount();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"Velocity Check Count\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		// ExcelDataCache cache = ExcelDataCache.getInstance();

		 List<Map<String, String>> testdata = cache.getCachedData(sheetName);

		System.out.println("sheet name: " + testdata);

		try {

			String VelocityCheckCount = testdata.get(rowNumber).get("Velocity Check Count");

			if (VelocityCheckCount != null && VelocityCheckCount.matches("\\d+\\.0")) {
				VelocityCheckCount = VelocityCheckCount.substring(0, VelocityCheckCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnVelocityCheckCount(VelocityCheckCount);

//				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Velocity Check Count", VelocityCheckCount);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@When("I click on the \"Cash@POS Count\" field")
	public void I_Click_On_the_CashPOSCount_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCashpOScount();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the label name should be \"Cash@POS Count\"")
	public void labelName_should_be_CashPOSCount() {
		B = new org.Locators.BankLocators(driver);

		try {

			B.CashpOScountLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"Cash@POS Count\" field should not allow proceeding without any input data")
	public void the_CashPOSCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnCashpOScount();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"Cash@POS Count\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_CashPOSCount_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String CashPOSCount = testdata.get(rowNumber).get("CashPOS Count");

			if (CashPOSCount != null && CashPOSCount.matches("\\d+\\.0")) {
				CashPOSCount = CashPOSCount.substring(0, CashPOSCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnCashpOScount(CashPOSCount);

//				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("CashPOSCount", CashPOSCount);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@When("I click on the \"Micro ATM Count\" field")
	public void I_Click_On_the_MicroATMCount_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnMicroATMCount();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the label name should be \"Micro ATM Count\"")
	public void labelName_should_be_MicroATMCount() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.MicroATMCountLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"Micro ATM Count\" field should not allow proceeding without any input data")
	public void the_MicroATMCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickOnMicroATMCount();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"Micro ATM Count\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MicroATM_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String MicroATMCount = testdata.get(rowNumber).get("Micro ATM Count");

			if (MicroATMCount != null && MicroATMCount.matches("\\d+\\.0")) {
				MicroATMCount = MicroATMCount.substring(0, MicroATMCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnMicroATMCount(MicroATMCount);

//				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Micro ATM Count", MicroATMCount);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the label name should be \"International Card Acceptence\"")
	public void labelName_should_be_InternationalCardAcceptence() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.InternationalcardCountLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"International Card Acceptence\" field should prompt to select the Yes or No based on the given input using sheetname {string} and rownumber {int}")
	public void the_InternationalCardAcceptence_field_should_prompt_to_select_YesNO_basedon_the_given_input(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String card = testdata.get(rowNumber).get("International Card Acceptance");

			System.out.println("0" + testdata.get(0));

			B.ClickOnInternationalcardCount();

			B.selectDropdownOption(card);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("International Card Acceptance", card);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@When("I click on the \"ICA Daily\" field")
	public void I_Click_On_the_ICADaily_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonICAdaily();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the label name should be \"Daily\"")
	public void labelName_should_be_daily() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.DailyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Daily\" field should not allow proceeding without any input data")
	public void the_ICADaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonICAdaily();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICADaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String ICADAILY = testdata.get(rowNumber).get("ICA Daily");

			if (ICADAILY != null && ICADAILY.matches("\\d+\\.0")) {
				ICADAILY = ICADAILY.substring(0, ICADAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAdaily(ICADAILY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("ICA DAILY", ICADAILY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

//ICA Weekly					

	@When("I click on the \"ICA Weekly\" field")
	public void I_Click_On_the_ICAWeekly_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonICAWeekly();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the label name should be \"Weekly\"")
	public void labelName_should_be_weekly() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.WeeklyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Weekly\" field should not allow proceeding without any input data")
	public void the_ICAWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonICAWeekly();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Weekly\" field Must be greater than \"ICA Daily\" using sheetname {string} and rownumber {int}")

	public void the_ICAWeekly_field_Mustbe_greaterthan_ICA_D(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

			if (ICAWEEKLY != null && ICAWEEKLY.matches("\\d+\\.0")) {
				ICAWEEKLY = ICAWEEKLY.substring(0, ICAWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAWeekly(ICAWEEKLY);

				performTabKeyPress();

				B.MustbegreaterthanDailyLimit();

				B.ClearonICAWeekly();
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICAWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

			if (ICAWEEKLY != null && ICAWEEKLY.matches("\\d+\\.0")) {
				ICAWEEKLY = ICAWEEKLY.substring(0, ICAWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAWeekly(ICAWEEKLY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("ICA Weekly", ICAWEEKLY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}
//Monthly

	@When("I click on the \"ICA Monthly\" field")
	public void I_Click_On_the_ICAMonthly_Field() {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonICAMonthly();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the label name should be \"Monthly\"")
	public void labelName_should_be_Monthly() {

		try {
			B = new org.Locators.BankLocators(driver);

			B.MonthlyLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Monthly\" field should not allow proceeding without any input data")
	public void the_ICAMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonICAMonthly();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Monthly\" field Must be greater than \"ICA Weekly\" using sheetname {string} and rownumber {int}")

	public void the_ICAMonthly_field_Mustbe_greaterthan_ICA_Weekly(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

			if (ICAMonthly != null && ICAMonthly.matches("\\d+\\.0")) {
				ICAMonthly = ICAMonthly.substring(0, ICAMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAMonthly(ICAMonthly);

				performTabKeyPress();

				B.Mustbegreaterthanweeklylimit();

				B.ClearonICAMonthly();

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"ICA Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICAmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

			if (ICAMonthly != null && ICAMonthly.matches("\\d+\\.0")) {
				ICAMonthly = ICAMonthly.substring(0, ICAMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAMonthly(ICAMonthly);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("ICA Monthly", ICAMonthly);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}
//POS

	@Then("the \"POS Daily\" field should not allow proceeding without any input data")
	public void the_POSDaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPosdaily();

			performTabKeyPress();

			B.DisplayedOnDailyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"POS Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String POSDAILY = testdata.get(rowNumber).get("POS Daily");

			if (POSDAILY != null && POSDAILY.matches("\\d+\\.0")) {
				POSDAILY = POSDAILY.substring(0, POSDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonPosdaily();

				B.EnteronPosdaily(POSDAILY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("POS Daily", POSDAILY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}
	// POS Weekly

	@Then("the \"POS Weekly\" field should not allow proceeding without any input data")
	public void the_POSWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPosWeekly();

			performTabKeyPress();

			B.DisplayedOnWeeklyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"POS Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String POSWEEKLY = testdata.get(rowNumber).get("POS Weekly");

			if (POSWEEKLY != null && POSWEEKLY.matches("\\d+\\.0")) {
				POSWEEKLY = POSWEEKLY.substring(0, POSWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonPosWeekly();

				B.EnteronPosWeekly(POSWEEKLY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("POS Weekly", POSWEEKLY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	// POSMonthly

	@Then("the \"POS Monthly\" field should not allow proceeding without any input data")
	public void the_POSMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPosMonthly();

			performTabKeyPress();

			B.DisplayedOnMonthlyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"POS Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String POSMonthly = testdata.get(rowNumber).get("POS Monthly");

			if (POSMonthly != null && POSMonthly.matches("\\d+\\.0")) {
				POSMonthly = POSMonthly.substring(0, POSMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonPosMonthly();

				B.EnteronPosMonthly(POSMonthly);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("POS Monthly", POSMonthly);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"POS Minimum\" field should not allow proceeding without any input data")
	public void the_Minimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

//		B.ClickonPOSMinimum();

			performTabKeyPress();

			B.DisplayedOnMinimumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"POS Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Minimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("POS Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonPOSMinimum();

				B.EnteronPOSMinimum(Minimum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("POS Minimum", Minimum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"POS Maximum\" field should not allow proceeding without any input data")
	public void the_Maximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonPOSMaximum();

			performTabKeyPress();

			B.DisplayedOnMaximumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"POS Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Maximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("POS Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonPOSMaximum();

				B.EnteronPOSMaximum(Maximum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("POS Maximum", Maximum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

//AEPS

	@Then("the \"AEPS Daily\" field should not allow proceeding without any input data")
	public void the_AEPSDaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonAEPSdaily();

			performTabKeyPress();

			B.DisplayedOnDailyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"AEPS Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String AEPSDAILY = testdata.get(rowNumber).get("AEPS Daily");

			if (AEPSDAILY != null && AEPSDAILY.matches("\\d+\\.0")) {
				AEPSDAILY = AEPSDAILY.substring(0, AEPSDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonAEPSdaily();

				B.EnteronAEPSdaily(AEPSDAILY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("AEPS Daily", AEPSDAILY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	// AEPS Weekly

	@Then("the \"AEPS Weekly\" field should not allow proceeding without any input data")
	public void the_AEPSWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonAEPSWeekly();

			performTabKeyPress();

			B.DisplayedOnWeeklyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"AEPS Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String AEPSWEEKLY = testdata.get(rowNumber).get("AEPS Weekly");

			if (AEPSWEEKLY != null && AEPSWEEKLY.matches("\\d+\\.0")) {
				AEPSWEEKLY = AEPSWEEKLY.substring(0, AEPSWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonAEPSWeekly();

				B.EnteronAEPSWeekly(AEPSWEEKLY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("AEPS Weekly", AEPSWEEKLY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	// Monthly

	@Then("the \"AEPS Monthly\" field should not allow proceeding without any input data")
	public void the_AEPSMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonAEPSMonthly();

			performTabKeyPress();

			B.DisplayedOnMonthlyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"AEPS Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String AEPSMonthly = testdata.get(rowNumber).get("AEPS Monthly");

			if (AEPSMonthly != null && AEPSMonthly.matches("\\d+\\.0")) {
				AEPSMonthly = AEPSMonthly.substring(0, AEPSMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonAEPSMonthly();

				B.EnteronAEPSMonthly(AEPSMonthly);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("AEPS Monthly", AEPSMonthly);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"AEPS Minimum\" field should not allow proceeding without any input data")
	public void the_AEPSMinimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonAEPSMinimum();

			performTabKeyPress();

			B.DisplayedOnMinimumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"AEPS Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("AEPS Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonAEPSMinimum();

				B.EnteronAEPSMinimum(Minimum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("AEPS Minimum", Minimum);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"AEPS Maximum\" field should not allow proceeding without any input data")
	public void the_AEPSMaximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonAEPSMaximum();

			performTabKeyPress();

			B.DisplayedOnMaximumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"AEPS Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("AEPS Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonAEPSMaximum();

				B.EnteronAEPSMaximum(Maximum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("AEPS Maximum", Maximum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

//UPI

	@Then("the \"UPI Daily\" field should not allow proceeding without any input data")
	public void the_UPIDaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonUPIdaily();

			performTabKeyPress();

			B.DisplayedOnDailyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"UPI Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String UPIDAILY = testdata.get(rowNumber).get("UPI Daily");

			if (UPIDAILY != null && UPIDAILY.matches("\\d+\\.0")) {
				UPIDAILY = UPIDAILY.substring(0, UPIDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonUPIdaily();

				B.EnteronUPIdaily(UPIDAILY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("UPI Daily", UPIDAILY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	// UPI Weekly

	@Then("the \"UPI Weekly\" field should not allow proceeding without any input data")
	public void the_UPIWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonUPIWeekly();

			performTabKeyPress();

			B.DisplayedOnWeeklyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"UPI Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String UPIWEEKLY = testdata.get(rowNumber).get("UPI Weekly");

			if (UPIWEEKLY != null && UPIWEEKLY.matches("\\d+\\.0")) {
				UPIWEEKLY = UPIWEEKLY.substring(0, UPIWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonUPIWeekly();

				B.EnteronUPIWeekly(UPIWEEKLY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("UPI Weekly", UPIWEEKLY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	// Monthly

	@Then("the \"UPI Monthly\" field should not allow proceeding without any input data")
	public void the_UPIMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonUPIMonthly();

			performTabKeyPress();

			B.DisplayedOnMonthlyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"UPI Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPImonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String UPIMonthly = testdata.get(rowNumber).get("UPI Monthly");

			if (UPIMonthly != null && UPIMonthly.matches("\\d+\\.0")) {
				UPIMonthly = UPIMonthly.substring(0, UPIMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonUPIMonthly();

				B.EnteronUPIMonthly(UPIMonthly);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("UPI Monthly", UPIMonthly);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"UPI Minimum\" field should not allow proceeding without any input data")
	public void the_UPIMinimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonUPIMinimum();

			performTabKeyPress();

			B.DisplayedOnMinimumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"UPI Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("UPI Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonUPIMinimum();

				B.EnteronUPIMinimum(Minimum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("UPI Minimum", Minimum);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"UPI Maximum\" field should not allow proceeding without any input data")
	public void the_UPIMaximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonUPIMaximum();

			performTabKeyPress();

			B.DisplayedOnMaximumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"UPI Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("UPI Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonUPIMaximum();

				B.EnteronUPIMaximum(Maximum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("UPI Maximum", Maximum);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"NextStep\" button should be prompted to click on Global FRM")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_GlobalFRM() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {

			B.ClickOnNextStep();

			B.DisplayedOnCommericial();

		} catch (AssertionError ae) {
			takeScreenshotStr("Global FRM"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

//MATM
	@Then("the \"MATM Daily\" field should not allow proceeding without any input data")
	public void the_MATMDaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonMATMdaily();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.DisplayedOnDailyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"MATM Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String MATMDAILY = testdata.get(rowNumber).get("MATM Daily");

			if (MATMDAILY != null && MATMDAILY.matches("\\d+\\.0")) {
				MATMDAILY = MATMDAILY.substring(0, MATMDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonMATMdaily();

				B.EnteronMATMdaily(MATMDAILY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("MATM Daily", MATMDAILY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	// MATM Weekly

	@Then("the \"MATM Weekly\" field should not allow proceeding without any input data")
	public void the_MATMWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonMATMWeekly();

			performTabKeyPress();

			B.DisplayedOnWeeklyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"MATM Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String WEEKLY = testdata.get(rowNumber).get("MATM Weekly");

			if (WEEKLY != null && WEEKLY.matches("\\d+\\.0")) {
				WEEKLY = WEEKLY.substring(0, WEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonMATMWeekly();

				B.EnteronMATMWeekly(WEEKLY);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("MATM Weekly", WEEKLY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	// MATMMonthly

	@Then("the \"MATM Monthly\" field should not allow proceeding without any input data")
	public void the_MATMMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonMATMMonthly();

			performTabKeyPress();

			B.DisplayedOnMonthlyLimitRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"MATM Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Monthly = testdata.get(rowNumber).get("MATM Monthly");

			if (Monthly != null && Monthly.matches("\\d+\\.0")) {
				Monthly = Monthly.substring(0, Monthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonMATMMonthly();

				B.EnteronMATMMonthly(Monthly);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("MATM Monthly", Monthly);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"MATM Minimum\" field should not allow proceeding without any input data")
	public void the_MATMMinimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

//		B.ClickonPOSMinimum();

			performTabKeyPress();

			B.DisplayedOnMinimumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"MATM Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("MATM Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonMATMMinimum();

				B.EnteronMATMMinimum(Minimum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("MATM Minimum", Minimum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"MATM Maximum\" field should not allow proceeding without any input data")
	public void the_MATMMaximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			B.ClickonMATMMaximum();

			performTabKeyPress();

			B.DisplayedOnMaximumAmountRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

	@Then("the \"MATM Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("MATM Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClearonMATMMaximum();

				B.EnteronMATMMaximum(Maximum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("MATM Maximum", Maximum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}
	}

//Commercial	

	@When("I visit the Commercial")
	public void I_visit_Commercial() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnCommericial();
		} catch (Exception e) {	
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Interchange Plan Add\" button should be prompted to click")
	public void Interchange_plan_ADDButton_ShouldbePrompted_toClick() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialADD1();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@When("I click on the \"Interchange Plan Channel\" field")
	public void I_Click_Onthe_Interchange_PLan_Channel() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialChannel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the Interchage Plan label name should be \"Channel\"")
	public void the_interchangePlan_labelName_shouldbe_channel() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CommercialChannelLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Interchange Plan Channel\" field should not allow proceeding without any input data")
	public void the_InterChangePlan_Channel_field_Should_not_allow_proceeding_without_any_inputdata() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnCommercialSave();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Interchange Plan Channel - POS\" dropdown should prompt to select valid inputs")
	public void the_interchange_plan_channel_POs_dropdown_should_prompt_toselectValidInputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialChannel();

			B.SelectonCommercialChannelPOS();

			String selectonCommercialChannelPOS = B.getSelectonCommercialChannelPOS();

			LoginInputDatas("Commercial Channel", selectonCommercialChannelPOS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Interchange Plan Channel - AEPS\" dropdown should prompt to select valid inputs")
	public void the_interchange_plan_channel_AEPS_dropdown_should_prompt_toselectValidInputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialChannel();

			B.SelectonCommercialChannelAEPS();

			String selectonCommercialChannelAEPS = B.getSelectonCommercialChannelAEPS();

			LoginInputDatas("Commercial Channel", selectonCommercialChannelAEPS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the Interchange Pricing Plan label name should be \"Pricing Plan\"")
	public void the_interchangePlan_labelName_shouldbe_PricingPlan() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CommercialPricingPlanLabelinterchange();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Interchange Pricing Plan\" field should not allow proceeding without any input data")
	public void the_InterChangePricingPlan_field_Should_not_allow_proceeding_without_any_inputdata() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnCommercialSave();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@When("the \"Interchange Pricing Plan - BANK TEST PLAN\" dropdown should prompt to select valid inputs")
	public void the_interchange_pricingplan_BankTestPlan_dropdownShould_Prompt_toSelect_valid_inputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickONPricingPlanInterchange();

			B.SelectONPricingPlanBankPOSTest();

			String SelectONPricingPlanBankTest = B.getSelectONPricingPlanBankTest();

			LoginInputDatas("Pricing Plan", SelectONPricingPlanBankTest);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@When("the \"Interchange Pricing Plan - AEPS\" dropdown should prompt to select valid inputs")
	public void the_interchange_pricingplan_AEPS_dropdownShould_Prompt_toSelect_valid_inputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickONPricingPlanInterchange();

			B.SelectONPricingPlanBankAEPSTest();

			String SelectONPricingPlanBankTest = B.getSelectONPricingPlanBankTest();

			LoginInputDatas("Pricing Plan", SelectONPricingPlanBankTest);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the Commercial \"Save\" button should be prompted to click")
	public void the_CommercialSave_button_SHould_be_prompted_toClick() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnCommercialSave();

		} catch (AssertionError ae) {
			takeScreenshotStr("Commercial"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@Then("the \"Bank Onboarding Commercial Add\" button should be prompted to click")
	public void the_BankOnboarding_CommercialAdd_Button_Shouldbe_prompted_toClick() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialADD2();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the Bank Onboarding Commercial label name should be \"Channel\"")
	public void the_BankOnboardingCommercialPlan_labelName_shouldbe_channel() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CommercialChannelLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Bank Onboarding Commercial Channel\" field should not allow proceeding without any input data")
	public void the_BankOnboarding_Channel_field_Should_not_allow_proceeding_without_any_inputdata() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnCommercialSave();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Bank Onboarding Commercial Channel - POS\" dropdown should prompt to select valid inputs")
	public void Bank_OnboardingCommercial_ChannelPOS_dropdown_should_prompt_toselectValidInputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialChannel();

			B.SelectonCommercialChannelPOS();

			String selectonCommercialChannelPOS = B.getSelectonCommercialChannelPOS();

			LoginInputDatas("Commercial Channel", selectonCommercialChannelPOS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Bank Onboarding Commercial Channel - AEPS\" dropdown should prompt to select valid inputs")
	public void Bank_OnboardingCommercial_ChannelAEPS_dropdown_should_prompt_toselectValidInputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialChannel();

			B.SelectonCommercialChannelAEPS();

			String selectonCommercialChannelAEPS = B.getSelectonCommercialChannelAEPS();

			LoginInputDatas("Commercial Channel", selectonCommercialChannelAEPS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Bank Onboarding Commercial Channel - UPI\" dropdown should prompt to select valid inputs")
	public void Bank_OnboardingCommercial_ChannelUPI_dropdown_should_prompt_toselectValidInputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickonCommercialChannel();

			B.SelectonCommercialChannelUPI();

			String selectonCommercialChannelAEPS = B.getSelectonCommercialChannelAEPS();

			LoginInputDatas("Commercial Channel", selectonCommercialChannelAEPS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the Bank Onboarding Commercial label name should be \"Pricing Plan\"")
	public void the_BankOnboardingCommercial_labelName_shouldbe_PricingPlan() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CommercialPricingPlanLabelBankOnboarding();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"Bank Onboarding Commercial Pricing Plan\" field should not allow proceeding without any input data")
	public void the_BankOnboarding_field_Should_not_allow_proceeding_without_any_inputdata() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnCommercialSave();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@When("the \"Bank Onboarding Commercial Pricing Plan - POS\" dropdown should prompt to select valid inputs")
	public void the_BankOnboarding_pricingplan_POS_dropdownShould_Prompt_toSelect_valid_inputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickONPricingPlanBankOnboarding();

			B.SelectONBankOnboardingPricingBankPOSPlan();

			String SelectONPricingBankAEPSPlan = B.getSelectONBankOnboardingPricingBankPlan();

			LoginInputDatas("Pricing Plan", SelectONPricingBankAEPSPlan);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@When("the \"Bank Onboarding Commercial Pricing Plan - BANK AEPS PLAN\" dropdown should prompt to select valid inputs")
	public void the_BankOnboarding_pricingplan_BankAEPSPlan_dropdownShould_Prompt_toSelect_valid_inputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickONPricingPlanBankOnboarding();

			B.SelectONBankOnboardingPricingBankAEPSPlan();

			String SelectONPricingBankAEPSPlan = B.getSelectONBankOnboardingPricingBankPlan();

			LoginInputDatas("Pricing Plan", SelectONPricingBankAEPSPlan);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@When("the \"Bank Onboarding Commercial Pricing Plan - UPI\" dropdown should prompt to select valid inputs")
	public void the_BankOnboarding_pricingplan_UPI_dropdownShould_Prompt_toSelect_valid_inputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickONPricingPlanBankOnboarding();

			B.SelectONBankOnboardingPricingBankUPIPlan();

			String SelectONPricingBankAEPSPlan = B.getSelectONBankOnboardingPricingBankPlan();

			LoginInputDatas("Pricing Plan", SelectONPricingBankAEPSPlan);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	@Then("the \"NextStep\" button should be prompted to click on Commercial")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_Commercial() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {

			B.ClickOnNextStep();

			B.DisplayedOnBankDetails();

		} catch (AssertionError ae) {
			takeScreenshotStr("Commercial"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@When("I visit the Settlement Info")
	public void I_visit_the_SettlementInfo() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnSettlementInfo();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"ADD\" button should be prompted to click")
	public void theSettlementInfoAddbuttonShould_be_Prompted_toClick() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnSettlementInfoADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Channel\" field should not allow proceeding without any input data")
	public void settlementInfo_Channel_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnSettlementChannel();

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

	@Then("the Settlement Info \"Channel\" dropdown should prompt to select the valid inputs using sheetname {string} and rownumber {int}")
	public void SettlementInfo_channel_dropdown_Should_Prompt_toSelect_ValidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String channel = testdata.get(rowNumber).get("Settlement Channel");

			System.out.println("0" + testdata.get(0));

			B.ClickOnSettlementChannel();

			B.selectDropdownOption(channel);

			performTabKeyPress();

			LoginInputDatas("Settlement Channel", channel);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the label name should be \"Account Type\"")
	public void the_labelName_Should_be_AccountType() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.SettlementAccountRypeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Account Type\" field should not allow proceeding without any input data")
	public void settlementInfo_AccountType_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnSettlementAccountType();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

//		B.DoubleClickOnSettlementAccountType();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Account Type\" dropdown should prompt to select the valid inputs using sheetname {string} and rownumber {int}")
	public void SettlementInfo_AccountType_dropdown_Should_Prompt_toSelect_ValidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Account = testdata.get(rowNumber).get("Account Type");

			System.out.println("0" + testdata.get(0));

			B.ClickOnSettlementAccountType();

			B.selectDropdownOption(Account);

			performTabKeyPress();

			LoginInputDatas("Settlement Account Type", Account);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the label name should be \"Bank Account Number\"")
	public void the_labelName_Shouldbe_BankAccountNumber() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.SettlementBanKAccountNumberLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Bank Account Number\" field should not allow proceeding without any input data")
	public void settlementInfo_BankAccountNumber_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnBankAccountNumber();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Bank Account Number\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_SettlementInfo_BankAccountNumberField_ShouldPrompt_toEnterInvalidInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String BanKAccountNumber = testdata.get(rowNumber).get("Bank Account Number");

			System.out.println("0" + testdata.get(0));

			B.ClickOnBankAccountNumber();

			B.EnterOnBankAccountNumber(BanKAccountNumber);

			performTabKeyPress();

			B.DisplayedOnThisMinimumLengtherror();

			B.ClearOnBankAccountNumber();

			LoginInputDatas("Bank Account Number", BanKAccountNumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Bank Account Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_SettlementInfo_BankAccountNumberField_ShouldPrompt_toEntervalidInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();
			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("Sheet name: " + sheetName);

			// Fetch the bank account number for the specified row
			String bankAccountNumber = String.valueOf(testdata.get(rowNumber).get("Bank Account Number"));
			System.out.println("Bank Account Number: " + bankAccountNumber);

			// Handle scientific notation
			if (bankAccountNumber.contains("E")) {
				Double accountNumberDouble = Double.valueOf(bankAccountNumber);
				bankAccountNumber = String.format("%.0f", accountNumberDouble); // Convert to string without decimals
			}

			B.ClickOnBankAccountNumber();
			B.EnterOnBankAccountNumber(bankAccountNumber);

			// Consider replacing with explicit wait
			performTabKeyPress();

			// Validate bank account number format
			B.NOTDisplayedOnInvalidFormat();

			// Log input data
			LoginInputDatas("Bank Account Number", bankAccountNumber);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the label name should be \"IFSC Code\"")
	public void the_labelName_Should_be_IfscCode() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.SettlementIFSCCODELabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"IFSC Code\" field should not allow proceeding without any input data")
	public void settlementInfo_IfscCode_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnIFSCCode();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"IFSC Code\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void SettlementInfo_IFSCCode_dropdown_Should_Prompt_toSelect_ValidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String IFSCCode = testdata.get(rowNumber).get("IFSC Code");

			System.out.println("0" + testdata.get(0));

			B.ClickOnIFSCCode();

			B.selectDropdownOption(IFSCCode);

			performTabKeyPress();

			LoginInputDatas("IFSC Code", IFSCCode);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the \"SettlementInfo\" label name should be \"Bank Name\"")
	public void the_labelName_Shouldbe_BankName() {
		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.SettlementBankNameLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the label name should be \"Branch\"")
	public void the_labelName_Shouldbe_Branch() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.SettlementBranchLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the \"SettlementInfo\" label name should be \"City\"")
	public void the_labelName_Shouldbe_City() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.SettlementCityLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Bank Name should be displayed")
	public void the_BankName_should_be_displayed() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			String BankName = B.getSettlementBankName();
			assertEquals("TESTING", BankName);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Branch should be displayed")
	public void the_Branch_should_be_displayed() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			String Branch = B.getSettlementBranch();
			assertEquals("CREDOPAY", Branch);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the CityName should be displayed")
	public void the_City_should_be_displayed() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			String City = B.getSettlementCity();
			assertEquals("chennai", City);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the SettlementInfo \"Save\" button should be prompted to click")
	public void the_Settlement_Info_Save_buttonshould_beprompted_toclick() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CommuSavebutton();

		} catch (AssertionError ae) {
			takeScreenshotStr("Settlement Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@Then("the label name should be \"Settlement Type\"")
	public void the_label_Name_Should_be_SettlementType() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.SettlementTypeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Settlement Type\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_settlement_SettlementType_dropdown_Should_Prompt_toSelect_Valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String type = testdata.get(rowNumber).get("Settlement Type");

			System.out.println("0" + testdata.get(0));

			B.ClickOnSettlementType();

			B.selectDropdownOption(type);

			performTabKeyPress();

			LoginInputDatas("Settlement Type", type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the Settlement Info \"Settlement Type\" field should not allow proceeding without any input data")
	public void SettlementInfo_SettlementType_field_Shouldnot_allow_Proceeding_without_any_Input_data()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnNextStep();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	@Then("the \"NextStep\" button should be prompted to click on Settlement Info")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_SettlementInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {

			B.ClickOnNextStep();

			B.DisplayedOnBankonboardingConfig();

		} catch (AssertionError ae) {
			takeScreenshotStr("Settlement Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@When("I visit the Whitelabel")
	public void I_visit_the_Whitelabel() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnWhiteLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the \"Whitelabel\" label name should be \"Bank Own Deployment\"")
	public void the_whitelabel_labelName_Shouldbe_BankOwnDeployment() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.WhitelabelBankOwnDeploymentLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the Whitelabel \"BankOwnDeployment\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_BankOwnDeployment_dropdown_should_prompt_to_select_valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String type = testdata.get(rowNumber).get("Bank Own Deployment");

			System.out.println("0" + testdata.get(0));

			B.ClickOnWhitelabelBankOwnDeployment();

			B.selectDropdownOption(type);

			performTabKeyPress();

			LoginInputDatas("Whitelabel Bank Own Deployment", type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the \"Whitelabel\" label name should be \"Payfac Onboarding\"")
	public void the_whitelabel_labelName_Shouldbe_PayfacOnboarding() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.WhitelabelPayfacOnboardingLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the Whitelabel \"Payfac Onboarding\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_PayfacOnboarding_dropdown_should_prompt_to_select_valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String type = testdata.get(rowNumber).get("Payfac Onboarding");

			System.out.println("0" + testdata.get(0));

			B.ClickOnWhitelabelPayfacOnboarding();

			B.selectDropdownOption(type);

			performTabKeyPress();

			LoginInputDatas("Whitelabel Payfac Onboarding", type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the \"Whitelabel\" label name should be \"ISO Onboarding\"")
	public void the_whitelabel_labelName_Shouldbe_ISOOnboarding() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.WhitelabelISOOnboardingLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the Whitelabel \"ISO Onboarding\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_ISOOnboarding_dropdown_should_prompt_to_select_valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String type = testdata.get(rowNumber).get("ISO Onboarding");

			System.out.println("0" + testdata.get(0));

			B.ClickOnWhitelabelISOOnboarding();

			B.selectDropdownOption(type);

			performTabKeyPress();

			LoginInputDatas("Whitelabel ISO Onboarding", type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the \"Whitelabel\" label name should be \"Sales Team Onboarding\"")
	public void the_whitelabel_labelName_Shouldbe_SalesTeamOnboarding() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.WhitelabelSalesTeamOnboardingLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the Whitelabel \"Sales Team Onboarding\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_SalesTeamOnboarding_dropdown_should_prompt_to_select_valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String type = testdata.get(rowNumber).get("Sales Team Onboarding");

			System.out.println("0" + testdata.get(0));

			B.ClickOnWhitelabelSalesTeamOnboarding();

			B.selectDropdownOption(type);

			performTabKeyPress();

			LoginInputDatas("Whitelabel Sales Team Onboarding", type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the Whitelabel \"Max Number of platform\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_MaxNumberofplatformField_ShouldPrompt_toEntervalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("Maximum No of Platform");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.ClickOnMaximumNoofPlatform();

				B.EnterOnMaximumNoofPlatform(Maximum);

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();

				LoginInputDatas("Maximum Number Of Platform", Maximum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

	@Then("the \"NextStep\" button should be prompted to click on WHiteLabel")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_WhiteLabel() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {

			B.ClickOnNextStep();

			B.DisplayedOnPaymentBridge();

		} catch (AssertionError ae) {
			takeScreenshotStr("Whitelabel"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@When("I visit the Webhooks")
	public void I_visit_theWebhooks() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnWebhooks();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the Webhooks \"Add\" button should be prompted to click")
	public void the_webhooks_Add_button_should_be_prompted_toClick() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnWebhookADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the \"Webhooks\" label name should be \"Webhook Type\"")
	public void the_webhooks_label_name_should_be_webhookType() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.WebhooksTypeLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the Webhooks \"Webhook Type\" field should not allow proceeding without any input data")
	public void the_webhooks_type_field_Shouldnot_allow_proceeding_without_any_input_data() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnWebhooksSave();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the Webhooks \"Webhook Type\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Webhooks_WebhookType_dropdown_shouldprompt_toselect_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			 List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String type = testdata.get(rowNumber).get("Webhook Type");

			System.out.println("0" + testdata.get(0));

			B.ClickOnWebhooksType();

			B.selectDropdownOption(type);

			B.NOTDisplayedOnInvalidFormat();

			performTabKeyPress();

			LoginInputDatas("Webhook Type", type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the \"Webhooks\" label name should be \"Webhook Url\"")
	public void the_webhooks_label_name_should_be_webhookUrl() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.WebhooksURLLabel();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the Webhooks \"Webhook Url\" field should not allow proceeding without any input data")
	public void the_webhooks_type_field_URL_Shouldnot_allow_proceeding_without_any_input_data() throws AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnWebhooksURL();

			performTabKeyPress();

			B.DisplayedOnThisFieldisRequired();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the Webhooks \"Webhook URL\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_Webhooks_WebhookURL_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			 List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String webhookurl = testdata.get(rowNumber).get("Webhook url");

			System.out.println("0" + testdata.get(0));

			B.ClickOnWebhooksURL();

			B.EnterOnWebhooksURL(webhookurl);

			performTabKeyPress();

			B.DisplayedOnThisInvalidFormat();

			B.ClearOnWebhooksURL();

			LoginInputDatas("Webhook URL", webhookurl);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the Webhooks \"Webhook URL\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_WebhookURL_ShouldPrompt_toEntervalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Webhookurl = testdata.get(rowNumber).get("Webhook url");

			System.out.println("0" + testdata.get(0));

			B.ClickOnWebhooksURL();

			B.EnterOnWebhooksURL(Webhookurl);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Webhook URL", Webhookurl);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhook");
			throw e;
		}
	}

	@Then("the Webhooks \"Save\" button should be prompted to click")
	public void the_webhooks_Save_button_Shouldbe_prompted_toClick() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnWebhooksSave();

		} catch (AssertionError ae) {
			takeScreenshotStr("Webhook"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@Then("the \"NextStep\" button should be prompted to click on Webhooks")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_Webhooks() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {

			B.ClickOnNextStep();

			B.DisplayedOnKYCConfig();

		} catch (AssertionError ae) {
			takeScreenshotStr("Webhook"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@When("I visit the KYC Config")
	public void I_visit_the_Kyc() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnKYC();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}
	}

	@Then("the KYC Config \"Add\" button should be prompted to click")
	public void theKYC_Config_ADD_Button_should_be_promptedto_CLick() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnWebhookADD();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC Config \"Business Type\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_KYC_Config_BusinessType_dropdown_should_prompt_toselect_validInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String business = testdata.get(rowNumber).get("Business Type");

			System.out.println("0" + testdata.get(0));

			B.ClickOnKYCBusinessType();

			B.selectDropdownOption(business);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Business Type", business);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}
	}

	@Then("the Company KYC \"Proof of Identity\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_CompanyKYC_Config_BusinessType_dropdown_should_prompt_toselect_validInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Company = testdata.get(rowNumber).get("Company Proof of Identity");

			System.out.println("0" + testdata.get(0));

			B.ClickOnProofOfIdentityCompany();

			B.selectDropdownOption(Company);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Business Type", Company);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Company KYC \"Proof of Address\" dropdown should prompt to select valid inputs")
	public void the_CompanyKYC_ProofOfAddress_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnProofOfAddressCompany();

			B.SelectOnProofOfAddressCompany();

			performTabKeyPress();

			String SelectOnProofOfAddressCompany = B.getSelectOnProofOfAddressCompany();

			LoginInputDatas("Proof Of Address", SelectOnProofOfAddressCompany);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Company KYC \"Bank Documents\" dropdown should prompt to select valid inputs")
	public void the_CompanyKYC_BankDocuments_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnBankDocumentCompany();

			B.SelectOnBankDocumentCompany();

			performTabKeyPress();

			String SelectOnBankDocumentCompany = B.getSelectOnBankDocumentCompany();

			LoginInputDatas("Bank Document", SelectOnBankDocumentCompany);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Company KYC \"Tax Documents\" dropdown should prompt to select valid inputs")
	public void the_CompanyKYC_TaxDocuments_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnTaxDocumentCompany();

			B.SelectOnTaxDocumentCompany();

			performTabKeyPress();

			String SelectOnTaxDocumentCompany = B.getSelectOnTaxDocumentCompany();

			LoginInputDatas("Tax Document", SelectOnTaxDocumentCompany);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Individual \"Proof of Identity\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Individual_Config_BusinessType_dropdown_should_prompt_toselect_validInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Individual = testdata.get(rowNumber).get("Individual Proof of Identity");

			System.out.println("0" + testdata.get(0));

			B.ClickOnProofOfIdentityIndividual();

			B.selectDropdownOption(Individual);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Individual Proof of Identity", Individual);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Individual \"Proof of Address\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Individual_ProofOfAddress_dropdown_should_prompt_toselect_validInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Individual = testdata.get(rowNumber).get("Individual Proof of address");

			System.out.println("0" + testdata.get(0));

			B.ClickOnProofOfAddressIndividual();

			B.selectDropdownOption(Individual);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Individual Proof of Address", Individual);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Individual \"Bank Document\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Individual_BankDocuments_dropdown_should_prompt_toselect_validInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Individual = testdata.get(rowNumber).get("Individual Bank Document");

			System.out.println("0" + testdata.get(0));

			B.ClickOnBankDocumentIndividual();

			B.selectDropdownOption(Individual);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Individual Bank Document", Individual);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Individual \"Tax Document\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Individual_TaxDocuments_dropdown_should_prompt_toselect_validInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Individual = testdata.get(rowNumber).get("Individual Tax Document");

			System.out.println("0" + testdata.get(0));

			B.ClickOnTaxDocumentIndividual();

			B.selectDropdownOption(Individual);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Individual Tax Document", Individual);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the Individual \"Other Document\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Individual_OtherDocuments_dropdown_should_prompt_toselect_validInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
					

			System.out.println("sheet name: " + testdata);

			String Individual = testdata.get(rowNumber).get("Individual Other Document");

			System.out.println("0" + testdata.get(0));

			B.ClickOnOtherDocumentIndividual();

			B.selectDropdownOption(Individual);

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Individual Other Document", Individual);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

	@Then("the KYC \"Save\" button should be prompted to click")
	public void the_KYC_Save_button_Shouldbe_prompted_toClick() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnWebhooksSave();

		} catch (AssertionError ae) {
			takeScreenshotStr("KYC Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@Then("the \"NextStep\" button should be prompted to click on KYC")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_KYC() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {

			B.ClickOnNextStep();

			B.DisplayedOnstatusHistory();

		} catch (AssertionError ae) {
			takeScreenshotStr("KYC"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@Then("the \"Submit for verification\" button should be prompted to click on BankOnboarding")
	public void the_SubmitforVerfication_Shouldbeprompted_toclickOnBank_onboarding() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnsubmitforverification();

			B.Yesforsubmit();

			B.OkforSuccessfully();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Submit for verification");
			throw e;
		}

	}

	private void takeScreenshot(int rowNumber) {
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
