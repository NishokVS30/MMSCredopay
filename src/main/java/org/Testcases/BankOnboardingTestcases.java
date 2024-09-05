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

	public BankOnboardingTestcases() {
		this.driver = CustomWebDriverManager.getDriver();
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}

	@Given("I visit the SuperAdmin Login using sheetname {string} and rownumber {int}")
	public void i_visit_the_SuperAdmin_maker_login(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {

		try {

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

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
			takeScreenshotStr("Login Screen"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@And("I enter the credentials and click the login button")
	public void i_enter_the_credentials_and_click_the_login_button() throws InterruptedException {

		try {
			L = new org.Locators.LoginLocators(driver);
			Thread.sleep(9000);
			L.ClickOnSignIn();
		} catch (Exception e) {
			takeScreenshotStr("Login Screen"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Given("I visit the System Maker Login using sheetname {string} and rownumber {int}")
	public void i_visit_the_System_maker_login(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {

		try {
			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

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
			takeScreenshotStr("Login Screen"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@And("I enter the credentials and click a login button")
	public void i_enter_the_credentials_and_click_a_login_button() throws InterruptedException {

		try {
			L = new org.Locators.LoginLocators(driver);
			Thread.sleep(9000);
			L.ClickOnSignIn();

			Thread.sleep(5000);
			L.ClickOnOk();

		} catch (Exception e) {
			takeScreenshotStr("Login Screen"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Given("I visit the bank onboarding page")
	public void I_visit_the_bank_onboarding_page() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		try {
			Thread.sleep(3000);

			B.ClickOnDownArrow();

			Thread.sleep(2000);

			B.ClickOnOnboarding();

			Thread.sleep(2000);

			B.ClickOnOnBank();

			Thread.sleep(2000);

			B.ClickOnCreatebutton();

			Thread.sleep(1000);

		} catch (Exception e) {
			takeScreenshotStr("Onboarding List"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@When("I click on the \"Bank Name\" field")
	public void I_click_on_the_Bank_Name() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonBankName();

	}

	@Then("the label name should be \"Bank Name\"")
	public void the_label_name_should_be_BankName() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.BankNameLabel();

	}

	@Then("the \"Bank Name\" field should prompt to enter valid inputs within 30 characters using sheetname {string} and rownumber {int}")
	public void Bank_name_field_should_prompt_to_enter_valid_inputs_within_30_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Bankname = testdata.get(rowNumber).get("BankName");

			System.out.println("0" + testdata.get(0));

			Thread.sleep(2000);

			B.EnteronBankName(Bankname);

			String enteredBankName = B.getBankName();

			assertTrue("Bank Name field does not accept valid input within 30 characters.",
					enteredBankName.length() <= 30);

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			LoginInputDatas("Bank Name", Bankname);

		} catch (Exception e) {
			takeScreenshotStr("General Info"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"Bank Name\" field should prompts for invalid input if more than 30 characters are entered using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifmore_than30characters_are_entered(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		B.EnteronBankName(Bankname);

		String enteredBankName = B.getBankName();

		assertTrue("Bank Name field does not accept valid input within 30 characters.", enteredBankName.length() <= 30);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.clearBankName();

		LoginInputDatas("Bank Name", Bankname);

	}

	@Then("the \"Bank Name\" field should prompts for Invalid inputs within Lessthan 30 characters using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifless_than30characters_are_entered(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		B.EnteronBankName(Bankname);

		String enteredBankName = B.getBankName();
		assertTrue("Bank Name field does not accept valid input within 30 characters.", enteredBankName.length() <= 30);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.clearBankName();

		LoginInputDatas("Bank Name", Bankname);

	}

	@Then("the \"Bank Name\" field prompts for invalid input if a number is entered using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifanumberis_entered(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		B.EnteronBankName(Bankname);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		B.clearBankName();

		LoginInputDatas("Bank Name", Bankname);

	}

	@Then("the \"Bank Name\" field prompts for invalid input if special characters are entered using sheetname {string} and rownumber {int}")
	public void the_Bank_Name_field_should_prompts_forinvalidinput_ifaSpecialCharacter_are_entered(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		B.EnteronBankName(Bankname);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		B.clearBankName();

		LoginInputDatas("Bank Name", Bankname);

	}

	@Then("the \"Bank Name\" field should not allow to proceed without any input data")
	public void the_BankName_field_should_not_allow_to_proceed_without_any_input_data() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonBankName();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisFieldisRequired();

	}

	@When("I click on the \"Address\" field")
	public void I_ClickOn_AddressField() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonAddressLine();

	}

	@Then("the label name should be \"Address\"")
	public void labelName_Should_be_Address() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.AddressLabel();

	}

	@Then("the \"Address\" field should prompt to enter valid inputs within 230 characters using sheetname {string} and rownumber {int}")
	public void theAddress_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Address = testdata.get(rowNumber).get("Address");

			System.out.println("0" + testdata.get(0));

			B.EnterOnAddress(Address);

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Address", Address);

		} catch (Exception e) {
			takeScreenshotStr("General Info"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"Address\" field should not allow to proceed without any input data")
	public void the_Address_field_shouldnotallowto_proceed_withoutanyinput_data()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		B.ClickonAddressLine();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@When("I click on the \"Pincode\" field")
	public void I_click_on_the_PincodeField() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPincode();

	}

	@Then("the label name should be \"Pincode\"")
	public void the_label_name_should_be_Pincode() {
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.PincodeLabel();

	}

	@Then("the \"Pincode\" dropdown should prompt to select valid inputs")
	public void thePincode_dropdown_should_prompt_to_select_valid_inputs() throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		try {
			B.ClickonPincode();

			B.SelectonPincode();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

			String SelectedPincode = B.getPincode();
			assertEquals("600341", SelectedPincode);

			LoginInputDatas("Pincode", SelectedPincode);

		} catch (Exception e) {
			takeScreenshotStr("General Info"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"Pincode\" field should not allow to proceed without any input data")
	public void the_Pincode_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPincode();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the city name should be displayed.")
	public void the_cityname_should_be_displayed() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String City = B.getCity();
		assertEquals("chennai", City);

	}

	@Then("the state name should be displayed.")
	public void the_statename_should_be_displayed() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String State = B.getState();
		assertEquals("tamilnadu", State);

	}

	@Then("the Country name should be displayed.")
	public void the_Countryname_should_be_displayed() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String Country = B.getCountry();
		assertEquals("d test", Country);

	}

	@Then("the Currency Code name should be displayed.")
	public void the_Currencycode_should_be_displayed() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String CurrencyCode = B.getCurrencycode();
		assertEquals("588", CurrencyCode);

		Thread.sleep(3000);

	}

	@When("I click on the \"GST\" field")
	public void I_Click_on_the_GST_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnGst();

	}

	@Then("the label name should be \"GST\"")
	public void labelName_should_be_GST() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.GSTLabel();

	}

	@Then("the \"GST\" field should prompt to enter valid inputs with GST format using sheetname {string} and rownumber {int}")
	public void the_GST_field_should_prompt_to_enter_valid_inputs_with_GST_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String gst = testdata.get(rowNumber).get("GST");

			System.out.println("0" + testdata.get(0));

			B.EnterOnGst(gst);

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("GST", gst);

		} catch (Exception e) {
			takeScreenshotStr("General Info"); // Take screenshot on exception
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "An error occurred: " + e.getMessage());
			throw e; // Re-throw to ensure the test fails
		}

	}

	@Then("the \"GST\" field should prompt to enter Invalid inputs with GST format using sheetname {string} and rownumber {int}")
	public void the_GST_field_should_prompt_to_enter_Invalid_inputs_with_GST_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String gst = testdata.get(rowNumber).get("GST");

		B.EnterOnGst(gst);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		B.clearGst();

		LoginInputDatas("GST", gst);

	}

	@Then("the \"GST\" field should not allow to proceed without any input data")
	public void the_GST_field_shouldnotallow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnGst();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

//PAN

	@When("I click on the \"PAN\" field")
	public void I_Click_on_the_PAN_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPan();

	}

	@Then("the label name should be \"PAN\"")
	public void labelName_should_be_PAN() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.PANLabel();

	}

	@Then("the \"PAN\" field should prompt to enter valid inputs with PAN format using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_valid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String pan = testdata.get(rowNumber).get("PAN");

		System.out.println("0" + testdata.get(0));

		B.EnterOnPAN(pan);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("PAN", pan);
	}

	@Then("the \"PAN\" field should prompt to enter Invalid inputs with PAN format using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_Invalid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String pan = testdata.get(rowNumber).get("PAN");

		B.EnterOnPAN(pan);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		B.ClearPAN();

		LoginInputDatas("PAN", pan);

	}

	@Then("the \"PAN\" field should not allow to proceed without any input data")
	public void the_PAN_field_shouldnotallow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPan();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@When("I click on the \"Marsid\" field")
	public void I_Click_on_the_Marsid_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonMarsid();

	}

	@Then("the label name should be \"Marsid\"")
	public void labelName_should_be_Marsid() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.MarsidLabel();

	}

	@Then("the \"MarsId\" field	should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void Marsid_dropdown_should_prompt_to_select_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String marsid = testdata.get(rowNumber).get("Mars id");

		B.EnteronMarsid(marsid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Marsid", marsid);
	}

	@When("I click on the \"Statement Frequency\" field")
	public void Iclick_on_the_StatementFrequency_field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnStatementFrequency();

	}

	@Then("the label name should be \"Statement Frequency\"")
	public void labelName_should_be_StatementFrequency() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.StatementFrequencyLabel();

	}

	@Then("the \"Statement Frequency\" dropdown should prompt to select valid inputs")
	public void the_Statement_Frequency_dropdown_should_prompt_to_select_valid_inputs() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.SelectOnStatementFrequency();

		Thread.sleep(2000);

		String StatementFrequency = B.getStatementFrequency();
//	    assertEquals("Daily", StatementFrequency);

		LoginInputDatas("StatementFrequency", StatementFrequency);

	}

	@When("I click on the \"Statement Type\" field")
	public void Iclick_on_the_StatementType_field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnStatementType();

	}

	@Then("the label name should be \"Statement Type\"")
	public void labelName_should_be_StatementType() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.StatementTypeLabel();

	}

	@Then("the \"Statement Type\" dropdown should prompt to select valid inputs")
	public void the_Statement_Type_dropdown_should_prompt_to_select_valid_inputs() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnStatementType();

		B.SelectOnStatementType();

		B.NOTDisplayedOnThisfieldisrequired();

		B.NOTDisplayedOnInvalidFormat();

		Thread.sleep(2000);

		String StatementType = B.getStatementType();
//	    assertEquals("Pdf", StatementType);

		LoginInputDatas("StatementType", StatementType);

	}

	@When("I click on the \"Domain\" field")
	public void Iclick_on_the_Domain_field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnDomain();

	}

	@Then("the label name should be \"Domain\"")
	public void labelName_should_be_Domain() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.DomainLabel();

	}

	@Then("the \"Domain\" field should not allow to proceed without any input data")
	public void the_Domainfield_shouldnot_allowtoproceed_withoutany_inputdata()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		B.ClickOnDomain();

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Domain\" field should prompt to enter valid domain names using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String domain = testdata.get(rowNumber).get("Domain");

		Thread.sleep(3000);

		B.EnterOnDomain(domain);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Domain", domain);

	}

	@Then("the \"Domain\" field should prompt to enter invalid alphabet domain names using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_Invalid_Alphabetinputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String domain = testdata.get(rowNumber).get("Domain");

		B.EnterOnDomain(domain);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.Domainclear();

		LoginInputDatas("Domain", domain);

	}

	@Then("the \"Domain\" field should prompt to enter invalid number domain names using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_Invalid_Numbers_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String domain = testdata.get(rowNumber).get("Domain");

		B.EnterOnDomain(domain);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.Domainclear();

		LoginInputDatas("Domain", domain);

	}

	@Then("To verify if the \"Save\" button is prompted to click and a success popup is displayed using sheetname {string} and rownumber {int}")

	public void To_verify_if_the_Save_button_is_prompted_to_click_and_success_popup_is_displayed(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		L = new org.Locators.LoginLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Bankname = testdata.get(rowNumber).get("BankName");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		B.clearBankName();

		B.EnteronBankName(Bankname);

		String enteredBankName = B.getBankName();

		assertTrue("Bank Name field does not accept valid input within 30 characters.", enteredBankName.length() <= 30);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.ClickOnSaveasdraft();

		L.DisplayedOnOK();

		L.ClickOnOk();

	}

	@When("I visit the Communication Info")
	public void I_visit_the_Communication_Info() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		B.DisplayedOnCommunicationInfo();

		B.CLickOnCommunicationInfo();

	}

	@Then("the \"Add\" button should be prompted to click")
	public void the_Add_button_should_be_prompted_to_click() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(4000);

		B.CommADD();

	}

//CommunicationName

	@When("I click on the \"Communication Name\" field")
	public void I_Click_on_the_Name_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCommName();

	}

	@Then("the label name should be \"Name\"")
	public void labelName_should_be_Name() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommName();

	}

	@Then("the \"Communication Name\" field should not allow proceeding without any input data")
	public void the_Communication_Name_field_Shouldnot_allow_Proceeding_without_any_input_data()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCommName();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationName = testdata.get(rowNumber).get("Communication Name");

		System.out.println("0" + testdata.get(0));

		B.EnterOnCommName(CommunicationName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Communication Name", CommunicationName);

	}

	@Then("the \"Name\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationName = testdata.get(rowNumber).get("Communication Name");

		System.out.println("0" + testdata.get(0));

		B.EnterOnCommName(CommunicationName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.clearCommunicationName();

		test = ExtentCucumberAdapter.getCurrentStep();

		LoginInputDatas("Communication Name", CommunicationName);
	}

	@Then("the \"Name\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationName = testdata.get(rowNumber).get("Communication Name");

		System.out.println("0" + testdata.get(0));

		B.EnterOnCommName(CommunicationName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.clearCommunicationName();

		LoginInputDatas("Communication Name", CommunicationName);

	}

//Position

	@When("I click on the \"Position\" field")
	public void I_Click_on_the_Position_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCommPosition();

	}

	@Then("the label name should be \"Position\"")
	public void labelName_should_be_Position() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommPosition();

	}

	@Then("the \"Position\" field should not allow proceeding without any input data")
	public void the_Position_field_Shouldnot_allow_Proceeding_without_any_input_data()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCommPosition();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Position\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_position_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationPosition = testdata.get(rowNumber).get("Communication Position");

		System.out.println("0" + testdata.get(0));

		B.EnterOnCommunicationPosition(CommunicationPosition);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Communication Position", CommunicationPosition);

	}

	@Then("the \"Position\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Position_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationPosition = testdata.get(rowNumber).get("Communication Position");

		System.out.println("0" + testdata.get(0));

		B.EnterOnCommunicationPosition(CommunicationPosition);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.clearCommunicationPosition();

		LoginInputDatas("Communication Position", CommunicationPosition);
	}

	@Then("the \"Position\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Position_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationPosition = testdata.get(rowNumber).get("Communication Position");

		System.out.println("0" + testdata.get(0));

		B.EnterOnCommunicationPosition(CommunicationPosition);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.clearCommunicationPosition();

		LoginInputDatas("Communication Position", CommunicationPosition);

	}

//PhoneNumber

	@When("I click on the \"Phone Number\" field")
	public void I_Click_On_the_Phonenumber_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCommPhoneNumber();

	}

	@Then("the label name should be \"Phone Number\"")
	public void the_label_name_shouldbe_PhoneNumber() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommPhoneNumber();

	}

	@Then("the \"Phone Number\" field should not allow inputs with fewer digits than required using sheetname {string} and rownumber {int}")
	public void the_Phone_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationPhonenumber = testdata.get(rowNumber).get("Communication PhoneNumber");

		System.out.println("0" + testdata.get(0));

		B.EnteronCommPhoneNumber(CommunicationPhonenumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.clearCommunicationPhoneNumber();

		LoginInputDatas("Communication PhoneNumber", CommunicationPhonenumber);
	}

	@Then("the \"Phone Number\" field should not allow inputs with more digits than required using sheetname {string} and rownumber {int}")
	public void the_Phone_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationPhonenumber = testdata.get(rowNumber).get("Communication PhoneNumber");

		System.out.println("0" + testdata.get(0));

		B.EnteronCommPhoneNumber(CommunicationPhonenumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.clearCommunicationPhoneNumber();

		LoginInputDatas("Communication PhoneNumber", CommunicationPhonenumber);

	}

	@Then("the \"Phone Number\" field should not allow numbers that do not start with the digit 0 using sheetname {string} and rownumber {int}")
	public void the_Phome_field_should_not_allow_numbers_numbers_that_do_not_start_with_the_digit_0(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationPhonenumber = testdata.get(rowNumber).get("Communication PhoneNumber");

		System.out.println("0" + testdata.get(0));

		B.EnteronCommPhoneNumber(CommunicationPhonenumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.clearCommunicationPhoneNumber();

		LoginInputDatas("Communication PhoneNumber", CommunicationPhonenumber);

	}

	@Then("the \"Phone Number\" field should prompt to enter valid inputs")

	public void the_PhoneNumberfield_shouldprompt_toenter_validinputs(List<Map<String, String>> dataTable)
			throws InterruptedException, AWTException {
		for (Map<String, String> row : dataTable) {

			B = new org.Locators.BankLocators(driver);
			L = new org.Locators.LoginLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			String Phonenumber = row.get("PhoneNumber");
			B.EnteronCommPhoneNumber(Phonenumber);

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			B.NOTDisplayedOnInvalidFormat();

		}
	}

//MobileNumber

	@When("I click on the \"Mobile Number\" field")
	public void I_Click_On_the_Mobilenumber_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonCommMobileNumber();

	}

	@Then("the label name should be \"Mobile Number\"")
	public void the_label_name_shouldbe_MobileNumber() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommMobileNumber();

	}

	@Then("the \"Mobile Number\" field should not allow inputs with fewer digits than required using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationMobilenumber = testdata.get(rowNumber).get("Communication MobileNumber");

		System.out.println("0" + testdata.get(0));

		B.EnteronCommMobileNumber(CommunicationMobilenumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnShouldbe10digits();

		Thread.sleep(2000);

		B.clearCommunicationMobileNumber();

		LoginInputDatas("Communication MobileNumber", CommunicationMobilenumber);
	}

	@Then("the \"Mobile Number\" field should not allow inputs with more digits than required using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationMobilenumber = testdata.get(rowNumber).get("Communication MobileNumber");

		System.out.println("0" + testdata.get(0));

		B.EnteronCommMobileNumber(CommunicationMobilenumber);

		String enteredMobileNumber = B.getMobileNumber();
		assertTrue("Mobile Number field allows more than 10 digits.", enteredMobileNumber.length() <= 10);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.clearCommunicationMobileNumber();

		LoginInputDatas("Communication MobileNumber", CommunicationMobilenumber);
	}

	@Then("the \"Mobile Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_promptto_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CommunicationMobilenumber = testdata.get(rowNumber).get("Communication MobileNumber");

		System.out.println("0" + testdata.get(0));

		B.EnteronCommMobileNumber(CommunicationMobilenumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Communication MobileNumber", CommunicationMobilenumber);

	}

	@Then("the \"Mobile Number\" field should not allow proceeding without any input data")
	public void the_MobileNumber_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonCommMobileNumber();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

//Emailid

	@When("I click on the \"Email ID\" field")
	public void I_Click_On_the_emailid_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonCommEmailid();

	}

	@Then("the label name should be \"Email ID\"")
	public void the_label_name_shouldbe_Emailid() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommEmailid();

	}

	@Then("the \"Email ID\" field should not allow proceeding without any input data")
	public void the_EmailID_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonCommEmailid();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Email ID\" field should not allow inputs missing the '@' symbol using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_symbol(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

		System.out.println("0" + testdata.get(0));

		B.ClearCommEmailid();

		B.EnteronCommEmailid(Communicationemailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.ClearCommEmailid();

		LoginInputDatas("Communication EmailID", Communicationemailid);
	}

	@Then("the \"Email ID\" field should not allow inputs missing the domain name using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_domainname(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

		System.out.println("0" + testdata.get(0));

		B.ClearCommEmailid();

		B.EnteronCommEmailid(Communicationemailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.ClearCommEmailid();

		LoginInputDatas("Communication EmailID", Communicationemailid);

	}

	@Then("the \"Email ID\" field should not allow consecutive dots in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_consective_dots_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

		System.out.println("0" + testdata.get(0));

		B.ClearCommEmailid();

		B.EnteronCommEmailid(Communicationemailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(4000);

		B.ClearCommEmailid();

		LoginInputDatas("Communication EmailID", Communicationemailid);
	}

	@Then("the \"Email ID\" field should not allow spaces in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_spaces_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

		System.out.println("0" + testdata.get(0));

		B.ClearCommEmailid();

		B.EnteronCommEmailid(Communicationemailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.ClearCommEmailid();

		LoginInputDatas("Communication EmailID", Communicationemailid);
	}

	@Then("the \"Email ID\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

		System.out.println("0" + testdata.get(0));

		B.ClearCommEmailid();

		B.EnteronCommEmailid(Communicationemailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Communication EmailID", Communicationemailid);

	}

	@When("I click on the \"UserName\" field")
	public void I_Click_On_the_UserName_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCommUsername();

	}

	@Then("the label name should be \"UserName\"")
	public void the_label_name_shouldbe_UserName() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommUserName();

	}

	@Then("the \"Username\" field should be auto-filled based on the entered email ID using sheetname {string} and rownumber {int}")
	public void the_Username_field_should_be_autofilled_based_on_the_entered_emailID(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Communicationemailid = testdata.get(rowNumber).get("Communication EmailId");

		String autoFilledUsername = B.getUsername();

		assertEquals(Communicationemailid, autoFilledUsername);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Communication UserName", Communicationemailid);

	}

	@Then("the label name should be \"AD User\"")
	public void the_label_name_should_be_ADUser() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommADUser();

	}

	@Then("the \"AD User\" field should prompt to select Yes or No based on the given input")
	public void the_ADUser_field_should_prompt_to_select_YesNO_basedon_the_given_input() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnAdUser();

		B.SelectOnYesAdUser();

		Thread.sleep(2000);

//		B.YesAdUesrdisplayed();

		Thread.sleep(3000);

		B.ClickOnAdUser();

		B.SelectOnNOAdUser();

		Thread.sleep(2000);

		String aduSer = B.getADUSer();

		LoginInputDatas("Ad User", aduSer);

//		B.NOAdUesrdisplayed();

	}

	@Then("the \"Save\" button should be prompted to click on Communication Info")
	public void the_savebutton_shouldbe_prompted_toclick_On_COmmunicationInfo() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CommuSavebutton();
	}

	@Then("the \"NextStep\" button should be prompted to click on Communication Info")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_COmmunicationInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnNextStep();
	}

	@When("I visit the Channel Config")

	public void I_visit_the_Channel_config() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.DisplayedOnChannelConfig();

		B.CLickOnChannelConfig();
	}

	@Then("the label name should be \"Channel\"")
	public void labelName_should_be_Channel() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelChannel();

	}

	@Then("the label name should be \"Network\"")
	public void labelName_should_be_Network() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelNetwork();
	}

	@Then("the label name should be \"Transaction Sets\"")
	public void labelName_should_be_TransactionSets() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelTransactionSet();

	}

	@Then("the label name should be \"Routing\"")
	public void labelName_should_be_Routing() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelRouting();

	}

	@Then("the \"POS Channel\" field should prompt to select the channels based on the given input")
	public void the_Channel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickonChannel();

		Thread.sleep(3000);

		B.SelectonPOSChannel();

		String selectonPOSChannel = B.getSelectonPOSChannel();

		LoginInputDatas("Channel", selectonPOSChannel);

	}

	@Then("the \"UPI Channel\" field should prompt to select the channels based on the given input")
	public void the_UPIChannel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickonChannel();

		Thread.sleep(3000);

		B.SelectonUPIChannel();

		String selectonUPIChannel = B.getSelectonUPIChannel();

		LoginInputDatas("Channel", selectonUPIChannel);

	}

	@Then("the \"AEPS Channel\" field should prompt to select the channels based on the given input")
	public void the_AEPSChannel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickonChannel();

		Thread.sleep(3000);

		B.SelectonAEPSChannel();

		String selectonAEPSChannel = B.getSelectonAEPSChannel();

		LoginInputDatas("Channel", selectonAEPSChannel);

	}
	
	@Then("the \"MATM Channel\" field should prompt to select the channels based on the given input")
	public void the_MATMChannel_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickonChannel();

		Thread.sleep(3000);

		B.SelectonMATMChannel();

		String selectonAEPSChannel = B.getSelectonAEPSChannel();

		LoginInputDatas("Channel", selectonAEPSChannel);

	}


	@Then("the \"POS Network\" field should prompt to select the Network based on the given input")
	public void the_Network_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.clickonNetwork();

		Thread.sleep(2000);

		B.SelectonNetworkPOS();

		String selectonPosNetwork = B.getSelectonNetworkPOS();

		LoginInputDatas("Network", selectonPosNetwork);

	}
	
	@Then("the \"MATM Network\" field should prompt to select the Network based on the given input")
	public void the_MATMNetwork_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.clickonNetwork();

		Thread.sleep(2000);

		B.SelectonNetworkMATM();

		String selectonPosNetwork = B.getSelectonNetworkMATM();

		LoginInputDatas("Network", selectonPosNetwork);

	}


	@Then("the \"POS Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_TransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.clickonTransactionsetPoS();

		Thread.sleep(2000);

		B.SelectonTransactionsetpos();

		String SelectonTransactionsetpos = B.getSelectonTransactionsetpos();

		LoginInputDatas("Transaction Set", SelectonTransactionsetpos);

	}

	@Then("the \"UPI Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_UPITransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.clickonTransactionset();

		Thread.sleep(2000);

		B.SelectonTransactionsetkUPI();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		String SelectonTransactionsetkUPI = B.getSelectonTransactionsetkUPI();

		LoginInputDatas("Transaction Set", SelectonTransactionsetkUPI);

	}

	@Then("the \"AEPS Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_AEPSTransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.clickonTransactionset();

		Thread.sleep(3000);

		B.SelectonTransactionsetAEPS();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		String SelectonTransactionsetAEPS = B.getSelectonTransactionsetAEPS();

		LoginInputDatas("Transaction Set", SelectonTransactionsetAEPS);

	}
	
	@Then("the \"MATM Transaction Sets\" field should prompt to select the transaction sets based on the given input")
	public void the_MATMTransactionSets_fieldshouldprompt_toselect_thechannelsbased_onthe_giveninput()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		B.clickonTransactionsetPoS();

		Thread.sleep(2000);

		B.SelectonTransactionsetMATM();

		String SelectonTransactionsetpos = B.getSelectonTransactionsetkMATM();

		LoginInputDatas("Transaction Set", SelectonTransactionsetpos);

	}

	@Then("the \"POS Routing\" field should prompt to select the routing based on the given input")
	public void the_Routing_fieldshouldprompt_toselect_theroutingsbased_onthe_giveninput() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickonRouting();

		Thread.sleep(3000);

		B.SelectonRouting();

		String SelectonRouting = B.getSelectonRouting();

		LoginInputDatas("Routing", SelectonRouting);

	}
	
	@Then("the \"MATM Routing\" field should prompt to select the routing based on the given input")
	public void the_MATMRouting_fieldshouldprompt_toselect_theroutingsbased_onthe_giveninput() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.clickonRouting();

		Thread.sleep(3000);

		B.SelectonRoutingMATM();

		String SelectonRouting = B.getSelectonRouting();

		LoginInputDatas("Routing", SelectonRouting);

	}

	@Then("the \"Save\" button should be prompted to click on Channel COnfig")
	public void the_Save_button_should_be_prompted_to_click_on_Channel_COnfig() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CommuSavebutton();
	}

	@Then("the \"NextStep\" button should be prompted to click on channel config")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_COmmunicationconfig() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		try {
			B.ClickOnNextStep();

			B.DisplayedOnRoutingONUS();

		} catch (AssertionError ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

//ONUS

	@Then("the \"POS ADD BIN\" field should prompt to select the Bin based on the given input")
	public void the_POSAddbin_field_should_prompt_to_select_thebin_basedonthegiveninput() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ActionOnONUSButton();

		B.addbin();

		Thread.sleep(2000);

		B.SelectonBin();

		B.SubmitOnONUS();

		String SelectonBin = B.getSelectonBin();

		LoginInputDatas("ONUS BIN", SelectonBin);

	}
	
	@Then("the \"MATM ADD BIN\" field should prompt to select the Bin based on the given input")
	public void the_Addbin_field_should_prompt_to_select_thebin_basedonthegiveninput() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ActionOnONUSButton2();

		B.addbin();

		Thread.sleep(2000);

		B.SelectonBin();

		B.SubmitOnONUS();

		String SelectonBin = B.getSelectonBin();

		LoginInputDatas("ONUS BIN", SelectonBin);

	}


	@Then("the \"NextStep\" button should be prompted to click on ONUS Routing")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_ONUSRouting() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

try {		
		
		Thread.sleep(3000);

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

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		B.CLickOnglobalfrm();

	}

	@Then("the GlobalFRMcheckbox should be checked")

	public void the_GlobalFRMcheckbox_shouldbe_checked() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.checkboxGlobalfrm();

	}

	@Then("the GlobalFRMcheckbox should be unchecked")

	public void the_GlobalFRMcheckbox_shouldbe_unchecked() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.uncheckboxGlobalfrm();

		Thread.sleep(4000);

		B.checkboxGlobalfrm();

	}

	@When("I click on the \"Velocity Check Minutes\" field")
	public void I_Click_On_the_VelocityCheckMinutes_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnVelocityCheckMinute();

	}

	@Then("the label name should be \"Velocity Check Minutes\"")
	public void labelName_should_be_VelocityCheckMinutes() {
		B = new org.Locators.BankLocators(driver);

		B.VelocityCheckMinuteLabel();

	}

	@Then("the \"Velocity Check Minutes\" field should not allow proceeding without any input data")
	public void the_VelocityCheckMinutes_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnVelocityCheckMinute();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Velocity Check Minutes\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Minutes_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String VelocityCheckMinutes = testdata.get(rowNumber).get("Velocity Check Minutes");

		System.out.println("0" + testdata.get(0));

		B.EnterOnVelocityCheckMinute(VelocityCheckMinutes);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Velocity Check Minutes", VelocityCheckMinutes);

	}

	@When("I click on the \"Velocity Check Count\" field")
	public void I_Click_On_the_VelocityCheckCount_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnVelocityCheckCount();

	}

	@Then("the label name should be \"Velocity Check Count\"")
	public void labelName_should_be_Velocity_Check_Count() {
		B = new org.Locators.BankLocators(driver);

		B.VelocityCheckCountLabel();

	}

	@Then("the \"Velocity Check Count\" field should not allow proceeding without any input data")
	public void the_VelocityCheckCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnVelocityCheckCount();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Velocity Check Count\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String VelocityCheckCount = testdata.get(rowNumber).get("Velocity Check Count");

		System.out.println("0" + testdata.get(0));

		B.EnterOnVelocityCheckCount(VelocityCheckCount);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Velocity Check Count", VelocityCheckCount);

	}

	@When("I click on the \"Cash@POS Count\" field")
	public void I_Click_On_the_CashPOSCount_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCashpOScount();

	}

	@Then("the label name should be \"Cash@POS Count\"")
	public void labelName_should_be_CashPOSCount() {
		B = new org.Locators.BankLocators(driver);

		B.CashpOScountLabel();

	}

	@Then("the \"Cash@POS Count\" field should not allow proceeding without any input data")
	public void the_CashPOSCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnCashpOScount();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Cash@POS Count\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_CashPOSCount_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CashPOSCount = testdata.get(rowNumber).get("CashPOS Count");

		System.out.println("0" + testdata.get(0));

		B.EnterOnCashpOScount(CashPOSCount);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("CashPOSCount", CashPOSCount);
	}

	@When("I click on the \"Micro ATM Count\" field")
	public void I_Click_On_the_MicroATMCount_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnMicroATMCount();

	}

	@Then("the label name should be \"Micro ATM Count\"")
	public void labelName_should_be_MicroATMCount() {
		B = new org.Locators.BankLocators(driver);

		B.MicroATMCountLabel();

	}

	@Then("the \"Micro ATM Count\" field should not allow proceeding without any input data")
	public void the_MicroATMCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickOnMicroATMCount();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Micro ATM Count\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MicroATM_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String MicroATMCount = testdata.get(rowNumber).get("Micro ATM Count");

		System.out.println("0" + testdata.get(0));

		B.EnterOnMicroATMCount(MicroATMCount);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Micro Atm Count</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + MicroATMCount + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Micro Atm Count" }, { MicroATMCount },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

		LoginInputDatas("Micro ATM Count", MicroATMCount);

	}

	@Then("the label name should be \"International Card Acceptence\"")
	public void labelName_should_be_InternationalCardAcceptence() {
		B = new org.Locators.BankLocators(driver);

		B.InternationalcardCountLabel();

	}

	@Then("the \"International Card Acceptence\" field should prompt to select Yes or No based on the given input")
	public void the_InternationalCardAcceptence_field_should_prompt_to_select_YesNO_basedon_the_given_input()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		B.ClickOnInternationalcardCount();

		B.NoInternationalcardCount();

		Thread.sleep(3000);

		B.ClickOnInternationalcardCount();

		B.yesInternationalcardCount();

		String getyesInternationalcardCount = B.getyesInternationalcardCount();

		LoginInputDatas("International Card Count", getyesInternationalcardCount);

	}

	@When("I click on the \"ICA Daily\" field")
	public void I_Click_On_the_ICADaily_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonICAdaily();

	}

	@Then("the label name should be \"Daily\"")
	public void labelName_should_be_daily() {
		B = new org.Locators.BankLocators(driver);

		B.DailyLabel();

	}

	@Then("the \"ICA Daily\" field should not allow proceeding without any input data")
	public void the_ICADaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonICAdaily();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"ICA Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICADaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICADAILY = testdata.get(rowNumber).get("ICA Daily");

		System.out.println("0" + testdata.get(0));

		B.EnteronICAdaily(ICADAILY);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("ICA DAILY", ICADAILY);

	}

//ICA Weekly					

	@When("I click on the \"ICA Weekly\" field")
	public void I_Click_On_the_ICAWeekly_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonICAWeekly();

	}

	@Then("the label name should be \"Weekly\"")
	public void labelName_should_be_weekly() {
		B = new org.Locators.BankLocators(driver);

		B.WeeklyLabel();

	}

	@Then("the \"ICA Weekly\" field should not allow proceeding without any input data")
	public void the_ICAWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonICAWeekly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"ICA Weekly\" field Must be greater than \"ICA Daily\" using sheetname {string} and rownumber {int}")

	public void the_ICAWeekly_field_Mustbe_greaterthan_ICA_D(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

		System.out.println("0" + testdata.get(0));

		B.EnteronICAWeekly(ICAWEEKLY);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.MustbegreaterthanDailyLimit();

		B.ClearonICAWeekly();

	}

	@Then("the \"ICA Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICAWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

		System.out.println("0" + testdata.get(0));

		B.EnteronICAWeekly(ICAWEEKLY);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("ICA Weekly", ICAWEEKLY);

	}

//Monthly

	@When("I click on the \"ICA Monthly\" field")
	public void I_Click_On_the_ICAMonthly_Field() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonICAMonthly();

	}

	@Then("the label name should be \"Monthly\"")
	public void labelName_should_be_Monthly() {
		B = new org.Locators.BankLocators(driver);

		B.MonthlyLabel();

	}

	@Then("the \"ICA Monthly\" field should not allow proceeding without any input data")
	public void the_ICAMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonICAMonthly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"ICA Monthly\" field Must be greater than \"ICA Weekly\" using sheetname {string} and rownumber {int}")

	public void the_ICAMonthly_field_Mustbe_greaterthan_ICA_Weekly(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

		System.out.println("0" + testdata.get(0));

		B.EnteronICAMonthly(ICAMonthly);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.Mustbegreaterthanweeklylimit();

		B.ClearonICAMonthly();

	}

	@Then("the \"ICA Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICAmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

		System.out.println("0" + testdata.get(0));

		B.EnteronICAMonthly(ICAMonthly);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("ICA Monthly", ICAMonthly);
	}

//POS

	@Then("the \"POS Daily\" field should not allow proceeding without any input data")
	public void the_POSDaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPosdaily();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnDailyLimitRequired();

	}

	@Then("the \"POS Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String POSDAILY = testdata.get(rowNumber).get("POS Daily");

		System.out.println("0" + testdata.get(0));

		B.ClearonPosdaily();

		B.EnteronPosdaily(POSDAILY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("POS Daily", POSDAILY);

	}

	// POS Weekly

	@Then("the \"POS Weekly\" field should not allow proceeding without any input data")
	public void the_POSWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPosWeekly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnWeeklyLimitRequired();

	}

	@Then("the \"POS Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String POSWEEKLY = testdata.get(rowNumber).get("POS Weekly");

		System.out.println("0" + testdata.get(0));

		B.ClearonPosWeekly();

		B.EnteronPosWeekly(POSWEEKLY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("POS Weekly", POSWEEKLY);
	}

	// POSMonthly

	@Then("the \"POS Monthly\" field should not allow proceeding without any input data")
	public void the_POSMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPosMonthly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMonthlyLimitRequired();

	}

	@Then("the \"POS Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String POSMonthly = testdata.get(rowNumber).get("POS Monthly");

		System.out.println("0" + testdata.get(0));

		B.ClearonPosMonthly();

		B.EnteronPosMonthly(POSMonthly);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("POS Monthly", POSMonthly);

	}

	@Then("the \"POS Minimum\" field should not allow proceeding without any input data")
	public void the_Minimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		B.ClickonPOSMinimum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMinimumAmountRequired();

	}

	@Then("the \"POS Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Minimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Minimum = testdata.get(rowNumber).get("POS Minimum");

		System.out.println("0" + testdata.get(0));

		B.ClearonPOSMinimum();

		B.EnteronPOSMinimum(Minimum);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("POS Minimum", Minimum);
	}

	@Then("the \"POS Maximum\" field should not allow proceeding without any input data")
	public void the_Maximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonPOSMaximum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMaximumAmountRequired();

	}

	@Then("the \"POS Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Maximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Maximum = testdata.get(rowNumber).get("POS Maximum");

		System.out.println("0" + testdata.get(0));

		B.ClearonPOSMaximum();

		B.EnteronPOSMaximum(Maximum);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("POS Maximum", Maximum);
	}

//AEPS

	@Then("the \"AEPS Daily\" field should not allow proceeding without any input data")
	public void the_AEPSDaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonAEPSdaily();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnDailyLimitRequired();

	}

	@Then("the \"AEPS Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String AEPSDAILY = testdata.get(rowNumber).get("AEPS Daily");

		System.out.println("0" + testdata.get(0));

		B.ClearonAEPSdaily();

		B.EnteronAEPSdaily(AEPSDAILY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("AEPS Daily", AEPSDAILY);
	}

	// AEPS Weekly

	@Then("the \"AEPS Weekly\" field should not allow proceeding without any input data")
	public void the_AEPSWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonAEPSWeekly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnWeeklyLimitRequired();

	}

	@Then("the \"AEPS Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String AEPSWEEKLY = testdata.get(rowNumber).get("AEPS Weekly");

		System.out.println("0" + testdata.get(0));

		B.ClearonAEPSWeekly();

		B.EnteronAEPSWeekly(AEPSWEEKLY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("AEPS Weekly", AEPSWEEKLY);

	}

	// Monthly

	@Then("the \"AEPS Monthly\" field should not allow proceeding without any input data")
	public void the_AEPSMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonAEPSMonthly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMonthlyLimitRequired();

	}

	@Then("the \"AEPS Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String AEPSMonthly = testdata.get(rowNumber).get("AEPS Monthly");

		System.out.println("0" + testdata.get(0));

		B.ClearonAEPSMonthly();

		B.EnteronAEPSMonthly(AEPSMonthly);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("AEPS Monthly", AEPSMonthly);

	}

	@Then("the \"AEPS Minimum\" field should not allow proceeding without any input data")
	public void the_AEPSMinimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonAEPSMinimum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMinimumAmountRequired();

	}

	@Then("the \"AEPS Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Minimum = testdata.get(rowNumber).get("AEPS Minimum");

		System.out.println("0" + testdata.get(0));

		B.ClearonAEPSMinimum();

		B.EnteronAEPSMinimum(Minimum);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("AEPS Minimum", Minimum);

	}

	@Then("the \"AEPS Maximum\" field should not allow proceeding without any input data")
	public void the_AEPSMaximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonAEPSMaximum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMaximumAmountRequired();

	}

	@Then("the \"AEPS Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Maximum = testdata.get(rowNumber).get("AEPS Maximum");

		System.out.println("0" + testdata.get(0));

		B.ClearonAEPSMaximum();

		B.EnteronAEPSMaximum(Maximum);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("AEPS Maximum", Maximum);
	}

//UPI

	@Then("the \"UPI Daily\" field should not allow proceeding without any input data")
	public void the_UPIDaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonUPIdaily();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnDailyLimitRequired();

	}

	@Then("the \"UPI Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String UPIDAILY = testdata.get(rowNumber).get("UPI Daily");

		System.out.println("0" + testdata.get(0));

		B.ClearonUPIdaily();

		B.EnteronUPIdaily(UPIDAILY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("UPI Daily", UPIDAILY);
	}

	// UPI Weekly

	@Then("the \"UPI Weekly\" field should not allow proceeding without any input data")
	public void the_UPIWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonUPIWeekly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnWeeklyLimitRequired();

	}

	@Then("the \"UPI Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String UPIWEEKLY = testdata.get(rowNumber).get("UPI Weekly");

		System.out.println("0" + testdata.get(0));

		B.ClearonUPIWeekly();

		B.EnteronUPIWeekly(UPIWEEKLY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("UPI Weekly", UPIWEEKLY);
	}

	// Monthly

	@Then("the \"UPI Monthly\" field should not allow proceeding without any input data")
	public void the_UPIMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonUPIMonthly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMonthlyLimitRequired();

	}

	@Then("the \"UPI Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPImonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String UPIMonthly = testdata.get(rowNumber).get("UPI Monthly");

		System.out.println("0" + testdata.get(0));

		B.ClearonUPIMonthly();

		B.EnteronUPIMonthly(UPIMonthly);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("UPI Monthly", UPIMonthly);
	}

	@Then("the \"UPI Minimum\" field should not allow proceeding without any input data")
	public void the_UPIMinimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonUPIMinimum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMinimumAmountRequired();

	}

	@Then("the \"UPI Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Minimum = testdata.get(rowNumber).get("UPI Minimum");

		System.out.println("0" + testdata.get(0));

		B.ClearonUPIMinimum();

		B.EnteronUPIMinimum(Minimum);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("UPI Minimum", Minimum);

	}

	@Then("the \"UPI Maximum\" field should not allow proceeding without any input data")
	public void the_UPIMaximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonUPIMaximum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMaximumAmountRequired();

	}

	@Then("the \"UPI Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Maximum = testdata.get(rowNumber).get("UPI Maximum");

		System.out.println("0" + testdata.get(0));

		B.ClearonUPIMaximum();

		B.EnteronUPIMaximum(Maximum);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("UPI Maximum", Maximum);

	}

	@Then("the \"NextStep\" button should be prompted to click on Global FRM")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_GlobalFRM() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

		try {
			B.ClickOnNextStep();

			B.DisplayedOnInterchangePlan();

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

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonMATMdaily();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnDailyLimitRequired();

	}

	@Then("the \"MATM Daily\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String MATMDAILY = testdata.get(rowNumber).get("MATM Daily");

		System.out.println("0" + testdata.get(0));

		B.ClearonMATMdaily();

		B.EnteronMATMdaily(MATMDAILY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("MATM Daily", MATMDAILY);

	}

	// MATM Weekly

	@Then("the \"MATM Weekly\" field should not allow proceeding without any input data")
	public void the_MATMWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonMATMWeekly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnWeeklyLimitRequired();

	}

	@Then("the \"MATM Weekly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String WEEKLY = testdata.get(rowNumber).get("MATM Weekly");

		System.out.println("0" + testdata.get(0));

		B.ClearonMATMWeekly();

		B.EnteronMATMWeekly(WEEKLY);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("MATM Weekly", WEEKLY);
	}

	// MATMMonthly

	@Then("the \"MATM Monthly\" field should not allow proceeding without any input data")
	public void the_MATMMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonMATMMonthly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMonthlyLimitRequired();

	}

	@Then("the \"MATM Monthly\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Monthly = testdata.get(rowNumber).get("MATM Monthly");

		System.out.println("0" + testdata.get(0));

		B.ClearonMATMMonthly();

		B.EnteronMATMMonthly(Monthly);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("MATM Monthly", Monthly);

	}

	@Then("the \"MATM Minimum\" field should not allow proceeding without any input data")
	public void the_MATMMinimum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		B.ClickonPOSMinimum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMinimumAmountRequired();

	}

	@Then("the \"MATM Minimum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Minimum = testdata.get(rowNumber).get("MATM Minimum");

		System.out.println("0" + testdata.get(0));

		B.ClearonMATMMinimum();

		B.EnteronMATMMinimum(Minimum);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("MATM Minimum", Minimum);
	}

	@Then("the \"MATM Maximum\" field should not allow proceeding without any input data")
	public void the_MATMMaximum_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.ClickonMATMMaximum();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		B.DisplayedOnMaximumAmountRequired();

	}

	@Then("the \"MATM Maximum\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Maximum = testdata.get(rowNumber).get("MATM Maximum");

		System.out.println("0" + testdata.get(0));

		B.ClearonMATMMaximum();

		B.EnteronMATMMaximum(Maximum);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("MATM Maximum", Maximum);
	}


//Commercial	

	@When("I visit the Commercial")
	public void I_visit_Commercial() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		B.clickOnCommericial();

	}

	@Then("the \"Interchange Plan Add\" button should be prompted to click")
	public void Interchange_plan_ADDButton_ShouldbePrompted_toClick() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		Thread.sleep(2000);


		B.ClickonCommercialADD1();

	}

	@When("I click on the \"Interchange Plan Channel\" field")
	public void I_Click_Onthe_Interchange_PLan_Channel() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickonCommercialChannel();

	}

	@Then("the Interchage Plan label name should be \"Channel\"")
	public void the_interchangePlan_labelName_shouldbe_channel() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CommercialChannelLabel();

	}

	@Then("the \"Interchange Plan Channel\" field should not allow proceeding without any input data")
	public void the_InterChangePlan_Channel_field_Should_not_allow_proceeding_without_any_inputdata() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnCommercialSave();

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Interchange Plan Channel - POS\" dropdown should prompt to select valid inputs")
	public void the_interchange_plan_channel_POs_dropdown_should_prompt_toselectValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelPOS();

		String selectonCommercialChannelPOS = B.getSelectonCommercialChannelPOS();

		LoginInputDatas("Commercial Channel", selectonCommercialChannelPOS);
	}
	
	@Then("the \"Interchange Plan Channel - AEPS\" dropdown should prompt to select valid inputs")
	public void the_interchange_plan_channel_AEPS_dropdown_should_prompt_toselectValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelAEPS();

		String selectonCommercialChannelAEPS = B.getSelectonCommercialChannelAEPS();

		LoginInputDatas("Commercial Channel", selectonCommercialChannelAEPS);
	}


	@Then("the Interchange Pricing Plan label name should be \"Pricing Plan\"")
	public void the_interchangePlan_labelName_shouldbe_PricingPlan() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CommercialPricingPlanLabelinterchange();

	}

	@Then("the \"Interchange Pricing Plan\" field should not allow proceeding without any input data")
	public void the_InterChangePricingPlan_field_Should_not_allow_proceeding_without_any_inputdata() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnCommercialSave();

		B.DisplayedOnThisFieldisRequired();

	}

	@When("the \"Interchange Pricing Plan - BANK TEST PLAN\" dropdown should prompt to select valid inputs")
	public void the_interchange_pricingplan_BankTestPlan_dropdownShould_Prompt_toSelect_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickONPricingPlanInterchange();

		B.SelectONPricingPlanBankPOSTest();

		String SelectONPricingPlanBankTest = B.getSelectONPricingPlanBankTest();

		LoginInputDatas("Pricing Plan", SelectONPricingPlanBankTest);

	}
	
	@When("the \"Interchange Pricing Plan - AEPS\" dropdown should prompt to select valid inputs")
	public void the_interchange_pricingplan_AEPS_dropdownShould_Prompt_toSelect_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickONPricingPlanInterchange();

		B.SelectONPricingPlanBankAEPSTest();

		String SelectONPricingPlanBankTest = B.getSelectONPricingPlanBankTest();

		LoginInputDatas("Pricing Plan", SelectONPricingPlanBankTest);

	}

	@Then("the Commercial \"Save\" button should be prompted to click")
	public void the_CommercialSave_button_SHould_be_prompted_toClick() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnCommercialSave();

	}

	@Then("the \"Bank Onboarding Commercial Add\" button should be prompted to click")
	public void the_BankOnboarding_CommercialAdd_Button_Shouldbe_prompted_toClick() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		B.ClickonCommercialADD2();
	}

	@Then("the Bank Onboarding Commercial label name should be \"Channel\"")
	public void the_BankOnboardingCommercialPlan_labelName_shouldbe_channel() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CommercialChannelLabel();

	}

	@Then("the \"Bank Onboarding Commercial Channel\" field should not allow proceeding without any input data")
	public void the_BankOnboarding_Channel_field_Should_not_allow_proceeding_without_any_inputdata() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnCommercialSave();

		B.DisplayedOnThisFieldisRequired();

	}
	
	@Then("the \"Bank Onboarding Commercial Channel - POS\" dropdown should prompt to select valid inputs")
	public void Bank_OnboardingCommercial_ChannelPOS_dropdown_should_prompt_toselectValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelPOS();

		String selectonCommercialChannelPOS = B.getSelectonCommercialChannelPOS();

		LoginInputDatas("Commercial Channel", selectonCommercialChannelPOS);
	}

	@Then("the \"Bank Onboarding Commercial Channel - AEPS\" dropdown should prompt to select valid inputs")
	public void Bank_OnboardingCommercial_ChannelAEPS_dropdown_should_prompt_toselectValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelAEPS();

		String selectonCommercialChannelAEPS = B.getSelectonCommercialChannelAEPS();

		LoginInputDatas("Commercial Channel", selectonCommercialChannelAEPS);
	}
	
	
	@Then("the \"Bank Onboarding Commercial Channel - UPI\" dropdown should prompt to select valid inputs")
	public void Bank_OnboardingCommercial_ChannelUPI_dropdown_should_prompt_toselectValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelUPI();

		String selectonCommercialChannelAEPS = B.getSelectonCommercialChannelAEPS();

		LoginInputDatas("Commercial Channel", selectonCommercialChannelAEPS);
	}


	@Then("the Bank Onboarding Commercial label name should be \"Pricing Plan\"")
	public void the_BankOnboardingCommercial_labelName_shouldbe_PricingPlan() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CommercialPricingPlanLabelBankOnboarding();

	}

	@Then("the \"Bank Onboarding Commercial Pricing Plan\" field should not allow proceeding without any input data")
	public void the_BankOnboarding_field_Should_not_allow_proceeding_without_any_inputdata() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnCommercialSave();

		B.DisplayedOnThisFieldisRequired();

	}
	
	@When("the \"Bank Onboarding Commercial Pricing Plan - POS\" dropdown should prompt to select valid inputs")
	public void the_BankOnboarding_pricingplan_POS_dropdownShould_Prompt_toSelect_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickONPricingPlanBankOnboarding();

		B.SelectONBankOnboardingPricingBankPOSPlan();

		String SelectONPricingBankAEPSPlan = B.getSelectONBankOnboardingPricingBankPlan();

		LoginInputDatas("Pricing Plan", SelectONPricingBankAEPSPlan);

	}

	@When("the \"Bank Onboarding Commercial Pricing Plan - BANK AEPS PLAN\" dropdown should prompt to select valid inputs")
	public void the_BankOnboarding_pricingplan_BankAEPSPlan_dropdownShould_Prompt_toSelect_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickONPricingPlanBankOnboarding();

		B.SelectONBankOnboardingPricingBankAEPSPlan();

		String SelectONPricingBankAEPSPlan = B.getSelectONBankOnboardingPricingBankPlan();

		LoginInputDatas("Pricing Plan", SelectONPricingBankAEPSPlan);

	}
	
	@When("the \"Bank Onboarding Commercial Pricing Plan - UPI\" dropdown should prompt to select valid inputs")
	public void the_BankOnboarding_pricingplan_UPI_dropdownShould_Prompt_toSelect_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CLickONPricingPlanBankOnboarding();

		B.SelectONBankOnboardingPricingBankUPIPlan();

		String SelectONPricingBankAEPSPlan = B.getSelectONBankOnboardingPricingBankPlan();

		LoginInputDatas("Pricing Plan", SelectONPricingBankAEPSPlan);

	}

	@Then("the \"NextStep\" button should be prompted to click on Commercial")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_Commercial() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

		try {
			B.ClickOnNextStep();

			B.DisplayedOnSettlementInfo();

		} catch (AssertionError ae) {
			takeScreenshotStr("Commercial"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

	@When("I visit the Settlement Info")
	public void I_visit_the_SettlementInfo() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnSettlementInfo();

	}

	@Then("the Settlement Info \"ADD\" button should be prompted to click")
	public void theSettlementInfoAddbuttonShould_be_Prompted_toClick() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnSettlementInfoADD();

	}

	@Then("the Settlement Info \"Channel\" field should not allow proceeding without any input data")
	public void settlementInfo_Channel_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnSettlementChannel();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);

		r.keyRelease(KeyEvent.VK_ESCAPE);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the Settlement Info \"Channel\" dropdown should prompt to select valid inputs")
	public void SettlementInfo_channel_dropdown_Should_Prompt_toSelect_ValidInputs() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnSettlementChannel();

		Thread.sleep(2000);

		B.SelectOnSettlementChannelPOS();

		String selectonsettlementChannelAEPS = B.getSelectOnSettlementChannelPOS();

		LoginInputDatas("Settlement Channel", selectonsettlementChannelAEPS);

	}

	@Then("the label name should be \"Account Type\"")
	public void the_labelName_Should_be_AccountType() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.SettlementAccountRypeLabel();

	}

	@Then("the Settlement Info \"Account Type\" field should not allow proceeding without any input data")
	public void settlementInfo_AccountType_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnSettlementAccountType();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);

		r.keyRelease(KeyEvent.VK_ESCAPE);

//		B.DoubleClickOnSettlementAccountType();

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the Settlement Info \"Account Type\" dropdown should prompt to select valid inputs")
	public void SettlementInfo_AccountType_dropdown_Should_Prompt_toSelect_ValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnSettlementAccountType();

		B.SelectOnSettlementAccountTypeCurrent();

		String SelectOnSettlementAccountTypeCurrent = B.getSelectOnSettlementAccountTypeCurrent();

		LoginInputDatas("Settlement Account Type", SelectOnSettlementAccountTypeCurrent);

	}

	@Then("the label name should be \"Bank Account Number\"")
	public void the_labelName_Shouldbe_BankAccountNumber() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.SettlementBanKAccountNumberLabel();

	}

	@Then("the Settlement Info \"Bank Account Number\" field should not allow proceeding without any input data")
	public void settlementInfo_BankAccountNumber_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnBankAccountNumber();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the Settlement Info \"Bank Account Number\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_SettlementInfo_BankAccountNumberField_ShouldPrompt_toEnterInvalidInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String BanKAccountNumber = testdata.get(rowNumber).get("Bank Account Number");

		System.out.println("0" + testdata.get(0));

		B.ClickOnBankAccountNumber();

		B.EnterOnBankAccountNumber(BanKAccountNumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisMinimumLengtherror();

		Thread.sleep(2000);

		B.ClearOnBankAccountNumber();

		LoginInputDatas("Bank Account Number", BanKAccountNumber);

	}

	@Then("the Settlement Info \"Bank Account Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_SettlementInfo_BankAccountNumberField_ShouldPrompt_toEntervalidInputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String BanKAccountNumber = testdata.get(rowNumber).get("Bank Account Number");

		System.out.println("0" + testdata.get(0));

		B.ClickOnBankAccountNumber();

		B.EnterOnBankAccountNumber(BanKAccountNumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Bank Account Number", BanKAccountNumber);
	}

	@Then("the label name should be \"IFSC Code\"")
	public void the_labelName_Should_be_IfscCode() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.SettlementIFSCCODELabel();

	}

	@Then("the Settlement Info \"IFSC Code\" field should not allow proceeding without any input data")
	public void settlementInfo_IfscCode_Should_not_allow_proceeding_without_any_inputdata()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnIFSCCode();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(3000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the Settlement Info \"IFSC Code\" dropdown should prompt to select valid inputs")
	public void SettlementInfo_IFSCCode_dropdown_Should_Prompt_toSelect_ValidInputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnIFSCCode();

		B.SelectOnIFSCCodeBHG();

		String selectOnIFSCCodeBHG = B.getSelectOnIFSCCodeBHG();

		LoginInputDatas("IFSC Code", selectOnIFSCCodeBHG);

	}

	@Then("the \"SettlementInfo\" label name should be \"Bank Name\"")
	public void the_labelName_Shouldbe_BankName() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.SettlementBankNameLabel();

	}

	@Then("the label name should be \"Branch\"")
	public void the_labelName_Shouldbe_Branch() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.SettlementBranchLabel();

	}

	@Then("the \"SettlementInfo\" label name should be \"City\"")
	public void the_labelName_Shouldbe_City() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.SettlementCityLabel();

	}

	@Then("the Bank Name should be displayed")
	public void the_BankName_should_be_displayed() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		String BankName = B.getSettlementBankName();
		assertEquals("TESTING", BankName);

	}

	@Then("the Branch should be displayed")
	public void the_Branch_should_be_displayed() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		String Branch = B.getSettlementBranch();
		assertEquals("CREDOPAY", Branch);

	}

	@Then("the CityName should be displayed")
	public void the_City_should_be_displayed() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		String City = B.getSettlementCity();
		assertEquals("chennai", City);

	}

	@Then("the SettlementInfo \"Save\" button should be prompted to click")
	public void the_Settlement_Info_Save_buttonshould_beprompted_toclick() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.CommuSavebutton();

	}

	@Then("the label name should be \"Settlement Type\"")
	public void the_label_Name_Should_be_SettlementType() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.SettlementTypeLabel();
	}

	@Then("the Settlement Info \"Settlement Type\" dropdown should prompt to select valid inputs")
	public void the_settlement_SettlementType_dropdown_Should_Prompt_toSelect_Valid_inputs()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);
		B.ClickOnSettlementType();

		Thread.sleep(3000);
		B.SelectOnSettlementTypeWallet();

		String SelectOnSettlementTypeWallet = B.getSelectOnSettlementTypeWallet();

		LoginInputDatas("Settlement Type", SelectOnSettlementTypeWallet);

	}

	@Then("the Settlement Info \"Settlement Type\" field should not allow proceeding without any input data")
	public void SettlementInfo_SettlementType_field_Shouldnot_allow_Proceeding_without_any_Input_data()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnNextStep();

		Thread.sleep(1000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"NextStep\" button should be prompted to click on Settlement Info")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_SettlementInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

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
	public void I_visit_the_Whitelabel() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnWhiteLabel();

	}

	@Then("the \"Whitelabel\" label name should be \"Bank Own Deployment\"")
	public void the_whitelabel_labelName_Shouldbe_BankOwnDeployment() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.WhitelabelBankOwnDeploymentLabel();

	}

	@Then("the Whitelabel \"BankOwnDeployment\" dropdown should prompt to select valid inputs")
	public void the_Whitelabel_BankOwnDeployment_dropdown_should_prompt_to_select_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnWhitelabelBankOwnDeployment();

		B.SelectOnWhiteLabelYes();

		String WhitelabelBankOwnDeployment = B.getClickOnWhitelabelBankOwnDeployment();

		LoginInputDatas("Whitelabel Bank Own Deployment", WhitelabelBankOwnDeployment);

	}

	@Then("the \"Whitelabel\" label name should be \"Payfac Onboarding\"")
	public void the_whitelabel_labelName_Shouldbe_PayfacOnboarding() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.WhitelabelPayfacOnboardingLabel();

	}

	@Then("the Whitelabel \"Payfac Onboarding\" dropdown should prompt to select valid inputs")
	public void the_Whitelabel_PayfacOnboarding_dropdown_should_prompt_to_select_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnWhitelabelPayfacOnboarding();

		B.SelectOnWhiteLabelNO();

		String WhitelabelPayfacOnboarding = B.getClickOnWhitelabelPayfacOnboarding();

		LoginInputDatas("Whitelabel Payfac Onboarding", WhitelabelPayfacOnboarding);

	}

	@Then("the \"Whitelabel\" label name should be \"ISO Onboarding\"")
	public void the_whitelabel_labelName_Shouldbe_ISOOnboarding() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.WhitelabelISOOnboardingLabel();

	}

	@Then("the Whitelabel \"ISO Onboarding\" dropdown should prompt to select valid inputs")
	public void the_Whitelabel_ISOOnboarding_dropdown_should_prompt_to_select_valid_inputs()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

		B.ClickOnWhitelabelISOOnboarding();

		Thread.sleep(2000);

		B.SelectOnWhiteLabelYes();

		String WhitelabelISOOnboarding = B.getClickOnWhitelabelISOOnboarding();

		LoginInputDatas("Whitelabel ISO Onboarding", WhitelabelISOOnboarding);

	}

	@Then("the \"Whitelabel\" label name should be \"Sales Team Onboarding\"")
	public void the_whitelabel_labelName_Shouldbe_SalesTeamOnboarding() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.WhitelabelSalesTeamOnboardingLabel();

	}

	@Then("the Whitelabel \"Sales Team Onboarding\" dropdown should prompt to select valid inputs")
	public void the_Whitelabel_SalesTeamOnboarding_dropdown_should_prompt_to_select_valid_inputs()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);
		B.ClickOnWhitelabelSalesTeamOnboarding();

		Thread.sleep(2000);

		B.SelectOnWhiteLabelNO();
		
		
		String WhitelabelsalesteamOnboarding = B.getClickOnWhitelabelSalesTeamOnboarding();

		LoginInputDatas("Whitelabel Sales Team Onboarding", WhitelabelsalesteamOnboarding);

	}

	@Then("the Whitelabel \"Max Number of platform\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_MaxNumberofplatformField_ShouldPrompt_toEntervalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Maximum = testdata.get(rowNumber).get("Maximum No of Platform");

		System.out.println("0" + testdata.get(0));

		B.ClickOnMaximumNoofPlatform();

		B.EnterOnMaximumNoofPlatform(Maximum);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Maximum Number Of Platform", Maximum);
	}

	@Then("the \"NextStep\" button should be prompted to click on WHiteLabel")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_WhiteLabel() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

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

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnWebhooks();

	}

	@Then("the Webhooks \"Add\" button should be prompted to click")
	public void the_webhooks_Add_button_should_be_prompted_toClick() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnWebhookADD();

	}

	@Then("the \"Webhooks\" label name should be \"Webhook Type\"")
	public void the_webhooks_label_name_should_be_webhookType() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.WebhooksTypeLabel();

	}

	@Then("the Webhooks \"Webhook Type\" field should not allow proceeding without any input data")
	public void the_webhooks_type_field_Shouldnot_allow_proceeding_without_any_input_data() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnWebhooksSave();

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the Webhooks \"Webhook Type\" dropdown should prompt to select valid inputs")
	public void the_Webhooks_WebhookType_dropdown_shouldprompt_toselect_valid_inputs() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnWebhooksType();

		B.SelectOnWebhooksType();

		B.NOTDisplayedOnInvalidFormat();
		
		String SelectOnWebhooksType = B.getSelectOnWebhooksType();

		LoginInputDatas("Webhook Type", SelectOnWebhooksType);

	}

	@Then("the \"Webhooks\" label name should be \"Webhook Url\"")
	public void the_webhooks_label_name_should_be_webhookUrl() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.WebhooksURLLabel();

	}

	@Then("the Webhooks \"Webhook Url\" field should not allow proceeding without any input data")
	public void the_webhooks_type_field_URL_Shouldnot_allow_proceeding_without_any_input_data() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnWebhooksURL();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the Webhooks \"Webhook URL\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_Webhooks_WebhookURL_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String webhookurl = testdata.get(rowNumber).get("Webhook url");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		B.ClickOnWebhooksURL();

		B.EnterOnWebhooksURL(webhookurl);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		B.ClearOnWebhooksURL();

		
		LoginInputDatas("Webhook URL", webhookurl);

	}

	@Then("the Webhooks \"Webhook URL\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_WebhookURL_ShouldPrompt_toEntervalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Webhookurl = testdata.get(rowNumber).get("Webhook url");

		System.out.println("0" + testdata.get(0));

		B.ClickOnWebhooksURL();

		B.EnterOnWebhooksURL(Webhookurl);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Webhook URL", Webhookurl);

	}

	@Then("the Webhooks \"Save\" button should be prompted to click")
	public void the_webhooks_Save_button_Shouldbe_prompted_toClick() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnWebhooksSave();

	}

	@Then("the \"NextStep\" button should be prompted to click on Webhooks")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_Webhooks() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

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

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.clickOnKYC();

	}

	@Then("the KYC Config \"Add\" button should be prompted to click")
	public void theKYC_Config_ADD_Button_should_be_promptedto_CLick() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnWebhookADD();

	}

	@Then("the KYC Config \"Business Type\" dropdown should prompt to select valid inputs")
	public void the_KYC_Config_BusinessType_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnKYCBusinessType();

		B.SelectOnKYCBusinessTypeTrust();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		
		String SelectOnBusinessType = B.getSelectOnKYCBusinessTypeTrust();

		LoginInputDatas("Business Type", SelectOnBusinessType);


	}

	@Then("the Company KYC \"Proof of Identity\" dropdown should prompt to select valid inputs")
	public void the_CompanyKYC_Config_BusinessType_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnProofOfIdentityCompany();

		B.SelectOnProofOfIdentityCompany();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		
		String SelectOnProofOfIdentityCompany = B.getSelectOnProofOfIdentityCompany();

		LoginInputDatas("Proof Of Identity", SelectOnProofOfIdentityCompany);

	}

	@Then("the Company KYC \"Proof of Address\" dropdown should prompt to select valid inputs")
	public void the_CompanyKYC_ProofOfAddress_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnProofOfAddressCompany();

		B.SelectOnProofOfAddressCompany();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		
		String SelectOnProofOfAddressCompany = B.getSelectOnProofOfAddressCompany();

		LoginInputDatas("Proof Of Address", SelectOnProofOfAddressCompany);

	}

	@Then("the Company KYC \"Bank Documents\" dropdown should prompt to select valid inputs")
	public void the_CompanyKYC_BankDocuments_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnBankDocumentCompany();

		B.SelectOnBankDocumentCompany();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		
		String SelectOnBankDocumentCompany = B.getSelectOnBankDocumentCompany();

		LoginInputDatas("Bank Document", SelectOnBankDocumentCompany);

	}

	@Then("the Company KYC \"Tax Documents\" dropdown should prompt to select valid inputs")
	public void the_CompanyKYC_TaxDocuments_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnTaxDocumentCompany();

		B.SelectOnTaxDocumentCompany();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		
		String SelectOnTaxDocumentCompany = B.getSelectOnTaxDocumentCompany();

		LoginInputDatas("Tax Document", SelectOnTaxDocumentCompany);


	}

	@Then("the Individual \"Proof of Identity\" dropdown should prompt to select valid inputs")
	public void the_Individual_Config_BusinessType_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnProofOfIdentityIndividual();

		B.SelectOnProofOfIdentityIndividual();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		
		String SelectOnProofOfIdentityIndividual = B.getSelectOnProofOfIdentityIndividual();

		LoginInputDatas("Proof Of Identity", SelectOnProofOfIdentityIndividual);

	}

	@Then("the Individual \"Proof of Address\" dropdown should prompt to select valid inputs")
	public void the_Individual_ProofOfAddress_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnProofOfAddressIndividual();

		B.SelectOnProofOfAddressIndividual();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		
		String SelectOnProofOfAddressIndividual = B.getSelectOnProofOfAddressIndividual();

		LoginInputDatas("Proof Of Address", SelectOnProofOfAddressIndividual);

	}

	@Then("the Individual \"Other Documents\" dropdown should prompt to select valid inputs")
	public void the_Individual_OtherDocuments_dropdown_should_prompt_toselect_validInputs() throws AWTException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnOtherDocumentIndividual();

		B.SelectOnOtherDocumentIndividual();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
			
			String SelectOnOtherDocumentIndividual = B.getSelectOnOtherDocumentIndividual();
	
			LoginInputDatas("Other Document", SelectOnOtherDocumentIndividual);

	}

	@Then("the KYC \"Save\" button should be prompted to click")
	public void the_KYC_Save_button_Shouldbe_prompted_toClick() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnWebhooksSave();

	}

	@Then("the \"NextStep\" button should be prompted to click on KYC")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_KYC() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

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

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnsubmitforverification();

		Thread.sleep(2000);

		B.Yesforsubmit();

		Thread.sleep(5000);

		B.OkforSuccessfully();

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
