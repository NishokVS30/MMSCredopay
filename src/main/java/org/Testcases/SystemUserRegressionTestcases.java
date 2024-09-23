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
import org.openqa.selenium.JavascriptExecutor;
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

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class SystemUserRegressionTestcases {

	private WebDriver driver;

	org.Locators.BankLocators B;
	org.Locators.SystemUserLocatores S;
	org.Locators.AggregatorLocators A;
	org.Locators.ISOLocators ISO;
	org.Locators.SUBISOLocators SUBISO;
	org.Locators.GroupMerchantLocator GM;

	public SystemUserRegressionTestcases() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}

	private ExtentTest test;

	@When("System Maker - Onboarding should be displayed in the side menu")
	public void I_Visit_System_Maker_Onboarding() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			B.ClickOnOnboarding();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}

	}

	@Then("the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Maker_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		try {

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}

	}

	@When("the SystemMaker clicks the bank module")
	public void SystemMakerClicktheBankModule() {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			S.ClickOnBank();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}

	}

	@When("the SystemMaker clicks the Create Button")
	public void the_SystemMaker_clicks_theCreateButton() {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			S.ClickOnCreate();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}

	}

	@Then("the \"Bank Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
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

			Thread.sleep(3000);

			B.ClickonBankName();

			B.clearBankName();

			B.EnteronBankName(Bankname);

			String enteredBankName = B.getBankName();

			LoginInputDatas("Bank Name", Bankname);

			assertTrue("Bank Name field does not accept valid input within 30 characters.",
					enteredBankName.length() <= 30);

			Thread.sleep(2000);

			performTabKeyPress();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Address\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
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

			performTabKeyPress();

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("Address", Address);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

	}

	@Then("the \"Domain\" field should prompt to enter the valid domain name using sheetname {string} and rownumber {int}")
	public void the_Domain_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e;
		}

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

	@Then("The \"NextStep\" button should prompt a click on Communication Info in Aggregator")
	public void the_nextstep_button_shouldbe_prompted_toClickonCommInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		test = ExtentCucumberAdapter.getCurrentStep();
		test.info("Scenario running on environment: ");

		Thread.sleep(1000);
		try {
			B.ClickOnNextStep();

			B.DisplayedOnChannelConfiguration();

		} catch (AssertionError ae) {
			takeScreenshotStr("Communication Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}

	}

//Global FRM

	@Then("the \"Velocity Check Minutes\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Minutes_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String VelocityCheckMinutes = testdata.get(rowNumber).get("Velocity Check Minutes");

			if (VelocityCheckMinutes != null && VelocityCheckMinutes.matches("\\d+\\.0")) {
				VelocityCheckMinutes = VelocityCheckMinutes.substring(0, VelocityCheckMinutes.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnVelocityCheckMinute(VelocityCheckMinutes);

				LoginInputDatas("Velocity Check Minutes", VelocityCheckMinutes);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"Velocity Check Count\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String VelocityCheckCount = testdata.get(rowNumber).get("Velocity Check Count");

			if (VelocityCheckCount != null && VelocityCheckCount.matches("\\d+\\.0")) {
				VelocityCheckCount = VelocityCheckCount.substring(0, VelocityCheckCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnVelocityCheckCount(VelocityCheckCount);

				LoginInputDatas("Velocity Check Count", VelocityCheckCount);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"Cash@POS Count\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_CashPOSCount_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String CashPOSCount = testdata.get(rowNumber).get("CashPOS Count");

			if (CashPOSCount != null && CashPOSCount.matches("\\d+\\.0")) {
				CashPOSCount = CashPOSCount.substring(0, CashPOSCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnCashpOScount(CashPOSCount);

				LoginInputDatas("CashPOSCount", CashPOSCount);

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"Micro ATM Count\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_MicroATM_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String MicroATMCount = testdata.get(rowNumber).get("Micro ATM Count");

			if (MicroATMCount != null && MicroATMCount.matches("\\d+\\.0")) {
				MicroATMCount = MicroATMCount.substring(0, MicroATMCount.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnterOnMicroATMCount(MicroATMCount);

				LoginInputDatas("Micro ATM Count", MicroATMCount);

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"International Card Acceptence\" field should prompt to select the Yes or No based on the given input")
	public void the_InternationalCardAcceptence_field_should_prompt_to_select_YesNO_basedon_the_given_input()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(1000);

			B.ClickOnInternationalcardCount();

			B.yesInternationalcardCount();

			String getyesInternationalcardCount = B.getyesInternationalcardCount();

			LoginInputDatas("International Card Count", getyesInternationalcardCount);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"ICA Daily\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICADaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String ICADAILY = testdata.get(rowNumber).get("ICA Daily");

			if (ICADAILY != null && ICADAILY.matches("\\d+\\.0")) {
				ICADAILY = ICADAILY.substring(0, ICADAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAdaily(ICADAILY);

				LoginInputDatas("ICA DAILY", ICADAILY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

//ICA Weekly					

	@Then("the \"ICA Weekly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICAWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

			if (ICAWEEKLY != null && ICAWEEKLY.matches("\\d+\\.0")) {
				ICAWEEKLY = ICAWEEKLY.substring(0, ICAWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAWeekly(ICAWEEKLY);

				LoginInputDatas("ICA Weekly", ICAWEEKLY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

//Monthly

	@Then("the \"ICA Monthly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_ICAmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

			if (ICAMonthly != null && ICAMonthly.matches("\\d+\\.0")) {
				ICAMonthly = ICAMonthly.substring(0, ICAMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronICAMonthly(ICAMonthly);

				LoginInputDatas("ICA Monthly", ICAMonthly);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

//POS

	@Then("the \"POS Daily\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String POSDAILY = testdata.get(rowNumber).get("POS Daily");

			if (POSDAILY != null && POSDAILY.matches("\\d+\\.0")) {
				POSDAILY = POSDAILY.substring(0, POSDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronPosdaily(POSDAILY);

				LoginInputDatas("POS Daily", POSDAILY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// POS Weekly

	@Then("the \"POS Weekly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String POSWEEKLY = testdata.get(rowNumber).get("POS Weekly");

			if (POSWEEKLY != null && POSWEEKLY.matches("\\d+\\.0")) {
				POSWEEKLY = POSWEEKLY.substring(0, POSWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronPosWeekly(POSWEEKLY);

				LoginInputDatas("POS Weekly", POSWEEKLY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// POSMonthly

	@Then("the \"POS Monthly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_POSmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String POSMonthly = testdata.get(rowNumber).get("POS Monthly");

			if (POSMonthly != null && POSMonthly.matches("\\d+\\.0")) {
				POSMonthly = POSMonthly.substring(0, POSMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronPosMonthly(POSMonthly);

				LoginInputDatas("POS Monthly", POSMonthly);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"POS Minimum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_Minimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("POS Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronPOSMinimum(Minimum);

				LoginInputDatas("POS Minimum", Minimum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"POS Maximum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_Maximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("POS Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronPOSMaximum(Maximum);

				LoginInputDatas("POS Maximum", Maximum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

//AEPS

	@Then("the \"AEPS Daily\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String AEPSDAILY = testdata.get(rowNumber).get("AEPS Daily");

			if (AEPSDAILY != null && AEPSDAILY.matches("\\d+\\.0")) {
				AEPSDAILY = AEPSDAILY.substring(0, AEPSDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronAEPSdaily(AEPSDAILY);

				LoginInputDatas("AEPS Daily", AEPSDAILY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// AEPS Weekly

	@Then("the \"AEPS Weekly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String AEPSWEEKLY = testdata.get(rowNumber).get("AEPS Weekly");

			if (AEPSWEEKLY != null && AEPSWEEKLY.matches("\\d+\\.0")) {
				AEPSWEEKLY = AEPSWEEKLY.substring(0, AEPSWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronAEPSWeekly(AEPSWEEKLY);

				LoginInputDatas("AEPS Weekly", AEPSWEEKLY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// Monthly

	@Then("the \"AEPS Monthly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String AEPSMonthly = testdata.get(rowNumber).get("AEPS Monthly");

			if (AEPSMonthly != null && AEPSMonthly.matches("\\d+\\.0")) {
				AEPSMonthly = AEPSMonthly.substring(0, AEPSMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronAEPSMonthly(AEPSMonthly);

				LoginInputDatas("AEPS Monthly", AEPSMonthly);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"AEPS Minimum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("AEPS Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronAEPSMinimum(Minimum);

				LoginInputDatas("AEPS Minimum", Minimum);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"AEPS Maximum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_AEPSMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("AEPS Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronAEPSMaximum(Maximum);

				LoginInputDatas("AEPS Maximum", Maximum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

//UPI

	@Then("the \"UPI Daily\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String UPIDAILY = testdata.get(rowNumber).get("UPI Daily");

			if (UPIDAILY != null && UPIDAILY.matches("\\d+\\.0")) {
				UPIDAILY = UPIDAILY.substring(0, UPIDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));
				B.EnteronUPIdaily(UPIDAILY);

				LoginInputDatas("UPI Daily", UPIDAILY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// UPI Weekly

	@Then("the \"UPI Weekly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String UPIWEEKLY = testdata.get(rowNumber).get("UPI Weekly");

			if (UPIWEEKLY != null && UPIWEEKLY.matches("\\d+\\.0")) {
				UPIWEEKLY = UPIWEEKLY.substring(0, UPIWEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronUPIWeekly(UPIWEEKLY);

				LoginInputDatas("UPI Weekly", UPIWEEKLY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// Monthly

	@Then("the \"UPI Monthly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPImonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String UPIMonthly = testdata.get(rowNumber).get("UPI Monthly");

			if (UPIMonthly != null && UPIMonthly.matches("\\d+\\.0")) {
				UPIMonthly = UPIMonthly.substring(0, UPIMonthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronUPIMonthly(UPIMonthly);

				LoginInputDatas("UPI Monthly", UPIMonthly);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"UPI Minimum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("UPI Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));
				B.EnteronUPIMinimum(Minimum);

				LoginInputDatas("UPI Minimum", Minimum);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"UPI Maximum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_UPIMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("UPI Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronUPIMaximum(Maximum);

				LoginInputDatas("UPI Maximum", Maximum);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

//MATM

	@Then("the \"MATM Daily\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMDaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String MATMDAILY = testdata.get(rowNumber).get("MATM Daily");

			if (MATMDAILY != null && MATMDAILY.matches("\\d+\\.0")) {
				MATMDAILY = MATMDAILY.substring(0, MATMDAILY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronMATMdaily(MATMDAILY);

				LoginInputDatas("MATM Daily", MATMDAILY);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// MATM Weekly

	@Then("the \"MATM Weekly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String WEEKLY = testdata.get(rowNumber).get("MATM Weekly");

			if (WEEKLY != null && WEEKLY.matches("\\d+\\.0")) {
				WEEKLY = WEEKLY.substring(0, WEEKLY.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronMATMWeekly(WEEKLY);
				LoginInputDatas("MATM Weekly", WEEKLY);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	// MATMMonthly

	@Then("the \"MATM Monthly\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Monthly = testdata.get(rowNumber).get("MATM Monthly");

			if (Monthly != null && Monthly.matches("\\d+\\.0")) {
				Monthly = Monthly.substring(0, Monthly.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronMATMMonthly(Monthly);

				LoginInputDatas("MATM Monthly", Monthly);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"MATM Minimum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMMinimum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Minimum = testdata.get(rowNumber).get("MATM Minimum");

			if (Minimum != null && Minimum.matches("\\d+\\.0")) {
				Minimum = Minimum.substring(0, Minimum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronMATMMinimum(Minimum);

				LoginInputDatas("MATM Minimum", Minimum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the \"MATM Maximum\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void the_MATMMaximum_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Maximum = testdata.get(rowNumber).get("MATM Maximum");

			if (Maximum != null && Maximum.matches("\\d+\\.0")) {
				Maximum = Maximum.substring(0, Maximum.indexOf(".0"));

				System.out.println("0" + testdata.get(0));

				B.EnteronMATMMaximum(Maximum);

				LoginInputDatas("MATM Maximum", Maximum);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Global FRM");
			throw e;
		}

	}

	@Then("the Channel Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}")
	public void processAllData(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		try {

			// Initialize BankLocators only once
			B = new org.Locators.BankLocators(driver);

			// Set implicit wait for the driver
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// Set the Excel file path and sheet name
			ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
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

				key.clear();
				value.clear();

				// Check if any of the data fields are null or empty and skip that field
				if (channel != null && !channel.trim().isEmpty()) {
//	            B.CLickOnChannelConfig(); // Open the channel config
					Thread.sleep(2000); // Wait to ensure page elements load properly
					B.ClickonCommercialADD1(); // Click 'Add' button for the channel
					B.ClickonCommercialChannel(); // Click on the channel dropdown

					Thread.sleep(1000);
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

					Thread.sleep(1000);
					B.clickonNetwork();
					Thread.sleep(1000);// Click on the network dropdown
					B.selectDropdownOption(network); // Select network from Excel
//	            LoginInputDatas("Network-" + currentRow, network);

					performTabKeyPress();

					key.add("Network-" + currentRow);
					value.add(network);

					performTabKeyPress();

					// Log input data for the network
				} else {
					System.out.println("Network data is null or empty for row: " + currentRow);
				}

				if (transactionSet != null && !transactionSet.trim().isEmpty()) {
					// Transaction Set selection
					Thread.sleep(1000);
					B.clickonTransactionsetPoS();
					Thread.sleep(2000);// Click on the transaction set dropdown
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
					Thread.sleep(2000);
					B.clickonRouting();
					Thread.sleep(2000);// Click on the routing dropdown
					B.selectDropdownOption(routing); // Select routing from Excel
//	            LoginInputDatas("Routing-" + currentRow, routing);
					key.add("Routing-" + currentRow);
					value.add(routing);

					performTabKeyPress();

					// Log input data for routing
				} else {
					System.out.println("Routing data is null or empty for row: " + currentRow);
				}

				Thread.sleep(2000);
				// Save the configuration (Only after filling all required fields)
				B.CommuSavebutton();

				Thread.sleep(3000);
				LoginInputData(key, value);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config");
			throw e;
		}

	}

	@Then("the Commercial \"Interchange Plan\" should prompt users to enter valid inputs using the sheet name {string}")
	public void CommercialInterchange(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			// Initialize BankLocators only once
			B = new org.Locators.BankLocators(driver);

			// Set implicit wait for the driver
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// Set the Excel file path and sheet name
			ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
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
				String channel = testData.get("Interchange Channel");
				String pricingplan = testData.get("Interchange Pricing Plan");

				key.clear();
				value.clear();

				// Check if any of the data fields are null or empty and skip that field
				if (channel != null && !channel.trim().isEmpty()) {

//	            B.CLickOnChannelConfig(); // Open the channel config
					Thread.sleep(2000); // Wait to ensure page elements load properly
					B.ClickonCommercialADD1();
					// Click 'Add' button for the channel
					Thread.sleep(1000);
					B.ClickonCommercialChannel();

					B.selectDropdownOption(channel);
//	            LoginInputDatas("Channel-" + currentRow, channel);
					key.add("Interchange Channel-" + currentRow);
					value.add(channel);

					performTabKeyPress();
					// Log input data for the channel
				} else {
					System.out.println("Channel data is null or empty for row: " + currentRow);
				}

				if (pricingplan != null && !pricingplan.trim().isEmpty()) {

					Thread.sleep(1000);
					B.CLickONPricingPlanInterchange();
					Thread.sleep(1000);
					B.selectDropdownOption(pricingplan);

//	            LoginInputDatas("Channel-" + currentRow, channel);
					key.add("pricing Plan-" + currentRow);
					value.add(pricingplan);

					performTabKeyPress();
					// Log input data for the channel
				} else {
					System.out.println("Channel data is null or empty for row: " + currentRow);
				}

				// Save the configuration (Only after filling all required fields)
				B.ClickOnCommercialSave();

				Thread.sleep(3000);

				LoginInputData(key, value);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}

	}

	@Then("the Commercial \"Bank Onboarding\" should prompt users to enter valid inputs using the sheet name {string}")
	public void CommercialBankOmboarding(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			// Initialize BankLocators only once
			B = new org.Locators.BankLocators(driver);

			// Set implicit wait for the driver
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// Set the Excel file path and sheet name
			ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
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
				String channel = testData.get("Commercial Channel");
				String pricingplan = testData.get("Commercial Pricing Plan");

				key.clear();
				value.clear();

				// Check if any of the data fields are null or empty and skip that field
				if (channel != null && !channel.trim().isEmpty()) {

//	            B.CLickOnChannelConfig(); // Open the channel config
					Thread.sleep(2000); // Wait to ensure page elements load properly
					B.ClickonCommercialADD2();
					// Click 'Add' button for the channel
					Thread.sleep(1000);
					B.ClickonCommercialChannel();

					B.selectDropdownOption(channel);
//	            LoginInputDatas("Channel-" + currentRow, channel);
					key.add("Bank Onboarding Commercial	 Channel-" + currentRow);
					value.add(channel);

					performTabKeyPress();
					// Log input data for the channel
				} else {
					System.out.println("Channel data is null or empty for row: " + currentRow);
				}

				if (pricingplan != null && !pricingplan.trim().isEmpty()) {

					Thread.sleep(1000);
					B.CLickONPricingPlanBankOnboarding();

					B.selectDropdownOption(pricingplan);

//	            LoginInputDatas("Channel-" + currentRow, channel);
					key.add("Pricing Plan-" + currentRow);
					value.add(pricingplan);

					performTabKeyPress();
					// Log input data for the channel
				} else {
					System.out.println("Channel data is null or empty for row: " + currentRow);
				}

				// Save the configuration (Only after filling all required fields)
				B.ClickOnCommercialSave();

				LoginInputData(key, value);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}

	}

	@Then("the Settlement Info \"Channel\" dropdown should prompt to select the valid inputs")
	public void SettlementInfo_channel_dropdown_Should_Prompt_toSelect_ValidInputs() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnSettlementChannel();

			Thread.sleep(2000);

			B.SelectOnSettlementChannelPOS();

			String selectOnSettlementChannelPOS = B.getSelectOnSettlementChannelPOS();

			LoginInputDatas("Settlement Channel", selectOnSettlementChannelPOS);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}

	}

	@Then("the Settlement Info \"Account Type\" dropdown should prompt to select the valid inputs")
	public void SettlementInfo_AccountType_dropdown_Should_Prompt_toSelect_ValidInputs() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.ClickOnSettlementAccountType();

			B.SelectOnSettlementAccountTypeCurrent();

			String SelectOnSettlementAccountTypeCurrent = B.getSelectOnSettlementAccountTypeCurrent();

			LoginInputDatas("Settlement Account Type", SelectOnSettlementAccountTypeCurrent);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}

	}

	@When("the System Maker clicks the \"Submit for verification\" button")
	public void the_SystemMaker_ClickThe_Submitforverification_button_inBankOnboarding() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			B.ClickOnsubmitforverification();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Submit for verification");
			throw e;
		}

	}

	@When("the System Maker clicks the \"Yes\" button to confirm submission")
	public void the_SystemMaker_clicksthe_Yes_buttonto_confirm_submissionin_BankOnboarding()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(2000);

			B.Yesforsubmit();

			Thread.sleep(5000);

			B.OkforSuccessfully();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Completed");
			throw e;
		}

	}

	@When("the System Maker clicks on the profile and log-out button")
	public void the_SystemMaker_clicksontheprofileand_log_out_button() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(5000);

			B.LogoutProfile();

			Thread.sleep(2000);

			B.Logoutbutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Log Out");
			throw e;
		}

	}

	@When("the System Maker handles the pop-up by selecting the \"Yes\" button and redirected to login page")
	public void the_SystemMaker_handles_thePopUp_by_selecting_YES_button() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.LogoutYESbutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Log Out");
			throw e;
		}

	}

//System Verifier - Bank

	@When("System Verifier - Onboarding should be displayed in the side menu")
	public void System_Verifier_Onboarding_should_be_displayed_intheside_menu() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			B.ClickOnVerifierOnboarding();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Onboarding");
			throw e;
		}

	}

	@Then("the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Verifier_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		try {

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Onboarding");
			throw e;
		}

	}

	@When("the System Verifier clicks the bank module")
	public void the_SystemVerifier_Clicks_the_bank_Module() {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			S.ClickOnBank();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Onboarding");
			throw e;
		}

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

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Bankname = testdata.get(rowNumber).get("BankName");

			System.out.println("0" + testdata.get(0));

			Thread.sleep(4000);

			B.ClickSearchbyBankName();

			Thread.sleep(2000);

			B.SearchbyBankName(Bankname);

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Onboarding");
			throw e;
		}

	}

	@When("the System Verifier click on action Three dot button and select the view option")
	public void theSystem_Verifierclick_onaction_Threedot_button_and_selecttheview_option()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(3000);

			B.ActionClick();

			Thread.sleep(4000);

			S.clickonView();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Onboarding");
			throw e;
		}

	}

	@When("the System Verifier checks \"General Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_General_Info_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickOnGenralInfo();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - General Info");
			throw e;
		}

	}

	@When("the System Verifier checks \"Communication Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_CommunicationInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickOnCommunicationInfo();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Communication Info");
			throw e;
		}

	}

	@When("the System Verifier checks \"Channel Config\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_ChannelConfig_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickOnChannelConfig();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Channel Config");
			throw e;
		}

	}

	@When("the System Verifier checks \"ONUS Routing\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_ONUSRouting_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - ONUS Routing");
			throw e;
		}

	}

	@When("the System Verifier checks \"Global FRM\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_GlobalFRM_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.CLickOnglobalfrm();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Global FRM");
			throw e;
		}

	}

	@When("the System Verifier checks \"Commerical\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_Commerical_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnCommericial();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Commercial");
			throw e;
		}

	}

	@When("the System Verifier checks \"Settlement Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_SettlementInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnSettlementInfo();

			Thread.sleep(4000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Settlement Info");
			throw e;
		}

	}

	@When("the System Verifier checks \"WhiteLabel\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_WhiteLabel_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnWhiteLabel();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Whitelabel");
			throw e;
		}

	}

	@When("the System Verifier checks \"Webhooks\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_Webhooks_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnWebhooks();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Webhook");
			throw e;
		}

	}

	@When("the System Verifier checks \"KYC\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_KYC_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.clickOnKYC();

			Thread.sleep(2000);

			B.VerifiedandNext();

			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - KYC");
			throw e;
		}

	}

	@When("the System verifier clicks the \"Submit for Approval\" button")
	public void the_Systemverifier_ClickThe_Submitforapproval_button_inBankOnboarding() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			B.SubmitforApproval();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approval");
			throw e;
		}

	}

	@When("the System verifier clicks the \"Yes\" button to confirm submission")
	public void the_Systemverifier_clicksthe_Yes_buttonto_confirm_submissionin_BankOnboarding()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(2000);

			B.Yesforsubmit();

			Thread.sleep(5000);

			B.OkforSuccessfully();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Approval");
			throw e;
		}

	}

	@When("the System verifier clicks on the profile and log-out button")
	public void the_Systemverifier_clicksontheprofileand_log_out_button() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(5000);

			B.LogoutProfile();

			Thread.sleep(2000);

			B.Logoutbutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Log Out");
			throw e;
		}

	}

	@When("the System verifier handles the pop-up by selecting the \"Yes\" button and redirected to login page")
	public void the_Systemverifier_handles_thePopUp_by_selecting_YES_button() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.LogoutYESbutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Verifier - Log Out");
			throw e;
		}

	}

	@When("System Approver - Onboarding should be displayed in the side menu")
	public void System_Approver_Onboarding_should_be_displayed_intheside_menu() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(3000);

			S.ClickOnDownArrow();

			B.ClickOnVerifierOnboarding();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Onboarding");
			throw e;
		}

	}

	@Then("the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Approver_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		try {

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
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Onboarding");
			throw e;
		}

	}

	@When("the System Approver clicks the bank module")
	public void the_SystemApprover_Clicks_the_bank_Module() {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			S.ClickOnBank();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Onboarding");
			throw e;
		}

	}

	@When("the System Approver ensure the bank status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_System_Approver_Ensure_the_BankStatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Onboarding");
			throw e;
		}

	}

	@When("the System Approver click on action Three dot button and select the view option")
	public void theSystem_Approverclick_onaction_Threedot_button_and_selecttheview_option()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(3000);

			B.ActionClick();

			Thread.sleep(4000);

			S.clickonView();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Onboarding");
			throw e;
		}

	}

	@When("the System Approver check if \"General Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_GeneralInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.CLickOnGenralInfo();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - General Info");
			throw e;
		}

	}

	@When("the System Approver check if \"Communication Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_CommunicationInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.CLickOnCommunicationInfo();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Communication Info");
			throw e;
		}

	}

	@When("the System Approver check if \"Channel Config\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_ChannelConfig_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.CLickOnChannelConfig();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Channel Config");
			throw e;
		}

	}

	@When("the System Approver check if \"ONUS Routing\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_ONUSRouting_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - ONUS");
			throw e;
		}

	}

	@When("the System Approver check if \"Global FRM\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_GlobalFRM_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.CLickOnglobalfrm();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - ONUS");
			throw e;
		}

	}

	@When("the System Approver check if \"Commercial\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_Commercial_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.clickOnCommericial();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Commercial");
			throw e;
		}

	}

	@When("the System Approver check if \"Settlement Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_SettlementInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.clickOnSettlementInfo();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Settlement Info");
			throw e;
		}

	}

	@When("the System Approver check if \"Whitelabel\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_Whitelabel_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.clickOnWhiteLabel();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - WhiteLabel");
			throw e;
		}

	}

	@When("the System Approver check if \"Webhooks\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_Webhooks_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.clickOnWebhooks();

			Thread.sleep(2000);

			B.DisplayedOnVerified();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Webhook");
			throw e;
		}

	}

	@When("the System Approver check if \"KYC\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_KYC_isverified_andclicks_the_NextStepbutton() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.clickOnKYC();

			Thread.sleep(2000);

			B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - KYC");
			throw e;
		}

	}

	@When("the System Approver clicks the \"Submit for Approve\" button")
	public void the_SystemApprover_ClickThe_Submitforapprove_button_inBankOnboarding() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		try {
			Thread.sleep(3000);

			B.ClickOnApprove();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Submit");
			throw e;
		}

	}

	@When("the System Approver clicks the \"Yes\" button to confirm submission")
	public void the_SystemvApprover_clicksthe_Yes_buttonto_confirm_submissionin_BankOnboarding()
			throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(2000);

			B.Yesforsubmit();

			Thread.sleep(5000);

			B.OkforSuccessfully();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Submit");
			throw e;
		}

	}

	@When("the System Approver clicks on the profile and log-out button")
	public void the_Systemapprover_clicksontheprofileand_log_out_button() throws InterruptedException {

		try {
			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(5000);

			B.LogoutProfile();

			Thread.sleep(2000);

			B.Logoutbutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Log Out");
			throw e;
		}

	}

	@When("the System Approver handles the pop-up by selecting the \"Yes\" button and redirected to login page")
	public void the_SystemApprover_handles_thePopUp_by_selecting_YES_button() {

		try {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			B.LogoutYESbutton();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "System Approver - Log Out");
			throw e;
		}

	}

	@When("Verify that Bank CPID is displayed correctly on the \"Bank Onboarding List page\" using sheetname {string} and rownumber {int}")
	public void Verify_thatBankCPID_isdisplayedcorrectly_onthe_BankOnboarding_Listpage(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "CPID");
			throw e;
		}

	}

//Aggregator

	@When("the SystemMaker clicks the Aggregator module")
	public void SystemMakerClicktheAggregatorModule() {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			S.ClickOnPayfac();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Aggregator");
			throw e;
		}

	}
//
//	@Then("the Channel Aggregator Onboarding should prompt users to enter valid inputs using the sheet name {string}")
//	public void processAllDataAggregator(String sheetName)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//		// Initialize BankLocators only once
//		B = new org.Locators.BankLocators(driver);
//		A = new org.Locators.AggregatorLocators(driver);
//
//		// Set implicit wait for the driver
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//		// Set the Excel file path and sheet name
//		ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
//				sheetName);
//		// Get the total number of non-empty rows
//		int numberOfRows = ExcelUtils.getRowCount(sheetName);
//		System.out.println("Total rows found: " + numberOfRows);
//
//		// Loop through all the rows
//		for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
//			System.out.println("Running test for row number: " + currentRow);
//			ArrayList<String> key = new ArrayList<>();
//			ArrayList<String> value = new ArrayList<>();
//
//			// Fetch the current row's data
//			Map<String, String> testData = ExcelUtils.getRowData(sheetName, currentRow);
//			System.out.println("Test data: " + testData);
//
//			// Retrieve data from the row for each field, handling null values
//			String bankName = testData.get("Channel Bank Name");
//			String channel = testData.get("Channel");
//			String network = testData.get("Network");
//			String transactionSet = testData.get("Transaction Sets");
//
//			key.clear();
//			value.clear();
//
//			if (bankName != null && !bankName.trim().isEmpty()) {
////	            B.CLickOnChannelConfig(); // Open the channel config
//				Thread.sleep(1000);
//
//				A.ClickOnChannelConfig();
//
//				Thread.sleep(4000);// Wait to ensure page elements load properly
//				B.ChannelADD();
//
//				Thread.sleep(1000);
//
//				A.ClickOnChannelBankName(); // Click on the channel dropdown
//
//				Thread.sleep(2000);
//				// Select the channel based on the Excel value (e.g., POS, AEPS, etc.)
//				A.EnterOnChannelBankName(bankName);
//
//				Thread.sleep(2000);
//				Robot r = new Robot();
//
//				r.keyPress(KeyEvent.VK_DOWN);
//
//				r.keyRelease(KeyEvent.VK_DOWN);
//
//				Thread.sleep(2000);
//
//				r.keyPress(KeyEvent.VK_ENTER);
//
//				r.keyRelease(KeyEvent.VK_ENTER);
//
//				B.NOTDisplayedOnInvalidFormat();
//
//				LoginInputDatas("Bank Name", bankName);
//
////	            LoginInputDatas("Channel-" + currentRow, channel);
//				key.add("Bank Name-" + currentRow);
//				value.add(bankName);
//
//				performTabKeyPress();
//				// Log input data for the channel
//			} else {
//				System.out.println("Channel data is null or empty for row: " + currentRow);
//			}
//
//			// Check if any of the data fields are null or empty and skip that field
//			if (channel != null && !channel.trim().isEmpty()) {
////	            B.CLickOnChannelConfig(); // Open the channel config
//				Thread.sleep(2000); // Wait to ensure page elements load properly
//				B.ClickonCommercialChannel(); // Click on the channel dropdown
//
//				Thread.sleep(2000);
//				// Select the channel based on the Excel value (e.g., POS, AEPS, etc.)
//				B.selectDropdownOption(channel);
////	            LoginInputDatas("Channel-" + currentRow, channel);
//				key.add("Channel-" + currentRow);
//				value.add(channel);
//
//				
//				// Log input data for the channel
//			} else {
//				System.out.println("Channel data is null or empty for row: " + currentRow);
//			}
//
//			if (network != null && !network.trim().isEmpty()) {
//				// Network selection
//
//				Thread.sleep(1000);
//				B.clickonNetwork();
//				Thread.sleep(1000);// Click on the network dropdown
//				B.selectDropdownOption(network); // Select network from Excel
////	            LoginInputDatas("Network-" + currentRow, network); 
//
//				key.add("Network-" + currentRow);
//				value.add(network);
//
//				
//				// Log input data for the network
//			} else {
//				System.out.println("Network data is null or empty for row: " + currentRow);
//			}
//
//			if (transactionSet != null && !transactionSet.trim().isEmpty()) {
//				// Transaction Set selection
//				Thread.sleep(1000);
//				B.clickonTransactionsetPoS();
//				Thread.sleep(1000);// Click on the transaction set dropdown
//				B.selectDropdownOption(transactionSet); // Select transaction set from Excel
//
//				key.add("Transaction Set-" + currentRow);
//				value.add(transactionSet);
//				performTabKeyPress();
//				
//			} else {
//				System.out.println("Transaction Set data is null or empty for row: " + currentRow);
//			}
//
//			Thread.sleep(2000);
//			A.ClickOnChannelStartDate();
//			A.ClickOnChannelApply();
//			
//			
//			Thread.sleep(2000);
//			A.ClickOnChannelENDDate();
//			A.ClickOnChannelApply();
//			
//
//			Thread.sleep(2000);
//			
//			A.ClickOnChannelSave();
//
//			Thread.sleep(2000);
//			LoginInputData(key, value);
//		}
//	}

	@Then("the Channel Aggregator Onboarding should prompt users to enter valid inputs using the sheet name {string}")
	public void processAllDataAggregator(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
			// Initialize locators only once
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			// Set implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// Load the Excel file
			ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
					sheetName);

			// Get the total number of non-empty rows
			int numberOfRows = ExcelUtils.getRowCount(sheetName);
			System.out.println("Total rows found: " + numberOfRows);

			// Loop through all rows
			for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
				System.out.println("Running test for row number: " + currentRow);
				processRowData(sheetName, currentRow);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config - Aggregator");
			throw e;
		}

	}

	
	private void processRowData(String sheetName, int currentRow) throws InterruptedException, AWTException {
		Map<String, String> testData = ExcelUtils.getRowData(sheetName, currentRow);
		System.out.println("Test data: " + testData);

		ArrayList<String> key = new ArrayList<>();
		ArrayList<String> value = new ArrayList<>();

		// Extract values from Excel
		String bankName = testData.get("Channel Bank Name");
		String channel = testData.get("Channel");
		String network = testData.get("Network");
		String transactionSet = testData.get("Transaction Sets");

		// Process Bank Name
		if (isValidInput(bankName)) {
			handleBankName(bankName, key, value, currentRow);
		} else {
			System.out.println("Bank Name is missing for row: " + currentRow);
		}

		// Process Channel
		if (isValidInput(channel)) {
			handleChannel(channel, key, value, currentRow);
		} else {
			System.out.println("Channel is missing for row: " + currentRow);
		}

		// Process Network
		if (isValidInput(network)) {
			handleNetwork(network, key, value, currentRow);
		} else {
			System.out.println("Network is missing for row: " + currentRow);
		}

		// Process Transaction Set
		if (isValidInput(transactionSet)) {
			handleTransactionSet(transactionSet, key, value, currentRow);
		} else {
			System.out.println("Transaction Set is missing for row: " + currentRow);
		}

		// Finalize channel start/end dates and save
		finalizeChannelSetup(key, value);
	}

	private boolean isValidInput(String input) {
		return input != null && !input.trim().isEmpty();
	}

	private void handleBankName(String bankName, ArrayList<String> key, ArrayList<String> value, int currentRow)
			throws InterruptedException, AWTException {
		Thread.sleep(1000);
		A.ClickOnChannelConfig();

		driver.navigate().refresh();
		Thread.sleep(4000);
		B.ChannelADD();
		Thread.sleep(1000);
		A.ClickOnChannelBankName();
		Thread.sleep(2000);
		A.EnterOnChannelBankName(bankName);
		Thread.sleep(2000);
		B.selectDropdownOption(bankName);

		Thread.sleep(2000);
		// performRobotActions();
		B.NOTDisplayedOnInvalidFormat();
		key.add("Bank Name-" + currentRow);
		value.add(bankName);

	}

	private void handleChannel(String channel, ArrayList<String> key, ArrayList<String> value, int currentRow)
			throws InterruptedException {
		Thread.sleep(1000);
		B.ClickonCommercialChannel();
		Thread.sleep(3000);
		B.selectDropdownOption(channel);
		key.add("Channel-" + currentRow);
		value.add(channel);
	}

	private void handleNetwork(String network, ArrayList<String> key, ArrayList<String> value, int currentRow)
			throws InterruptedException {
		Thread.sleep(1000);
		B.clickonNetwork();
		Thread.sleep(3000);
		B.selectDropdownOption(network);
		key.add("Network-" + currentRow);
		value.add(network);
	}

	private void handleTransactionSet(String transactionSet, ArrayList<String> key, ArrayList<String> value,
			int currentRow) throws InterruptedException, AWTException {
		Thread.sleep(1000);
		B.clickonTransactionsetPoS();
		Thread.sleep(3000);
		B.selectDropdownOption(transactionSet);
		key.add("Transaction Set-" + currentRow);
		value.add(transactionSet);
		performTabKeyPress();
	}

	private void finalizeChannelSetup(ArrayList<String> key, ArrayList<String> value) throws InterruptedException {
		Thread.sleep(2000);
		A.ClickOnChannelStartDate();
		A.ClickOnChannelApply();
		Thread.sleep(2000);
		A.ClickOnChannelENDDate();
		A.ClickOnChannelApply();
		Thread.sleep(2000);
		A.ClickOnChannelSave();
		Thread.sleep(2000);
		LoginInputData(key, value);
	}

	private void performRobotActions() throws AWTException, InterruptedException {

		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

//	@Then("the \"Discount Rate\" should prompt users to enter valid inputs using the sheet name {string}")
//	public void DiscountRate(String sheetName)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//		// Initialize BankLocators only once
//		B = new org.Locators.BankLocators(driver);
//		A = new org.Locators.AggregatorLocators(driver);
//
//		// Set implicit wait for the driver
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//		// Set the Excel file path and sheet name
//		ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
//				sheetName);
//
//		// Get the total number of non-empty rows
//		int numberOfRows = ExcelUtils.getRowCount(sheetName);
//		System.out.println("Total rows found: " + numberOfRows);
//
//		// Loop through all the rows
//		for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
//			System.out.println("Running test for row number: " + currentRow);
//			ArrayList<String> key = new ArrayList<>();
//			ArrayList<String> value = new ArrayList<>();
//
//			// Fetch the current row's data
//			Map<String, String> testData = ExcelUtils.getRowData(sheetName, currentRow);
//			System.out.println("Test data: " + testData);
//
//			// Retrieve data from the row for each field, handling null values
//			String channel = testData.get("Channel");
//			String pricingplan = testData.get("Pricing plan");
//
//			key.clear();
//			value.clear();
//
//			// Check if any of the data fields are null or empty and skip that field
//			if (channel != null && !channel.trim().isEmpty()) {
//
////	            B.CLickOnChannelConfig(); // Open the channel config
//				Thread.sleep(2000); // Wait to ensure page elements load properly
//				B.ChannelADD();
//				// Click 'Add' button for the channel
//				Thread.sleep(1000);
//				B.clickonChannel();
//
//				B.selectDropdownOption(channel);
////	            LoginInputDatas("Channel-" + currentRow, channel);
//				key.add("Channel-" + currentRow);
//				value.add(channel);
//
//				performTabKeyPress();
//				// Log input data for the channel
//			} else {
//				System.out.println("Channel data is null or empty for row: " + currentRow);
//			}
//
//			if (pricingplan != null && !pricingplan.trim().isEmpty()) {
//
//				Thread.sleep(1000);
//				A.ClickOnDiscountRatePricingPlan();
//
//				B.selectDropdownOption(pricingplan);
//
////	            LoginInputDatas("Channel-" + currentRow, channel);
//				key.add("Pricing Plan-" + currentRow);
//				value.add(pricingplan);
//
//				performTabKeyPress();
//				// Log input data for the channel
//			} else {
//				System.out.println("Channel data is null or empty for row: " + currentRow);
//			}
//
//			// Save the configuration (Only after filling all required fields)
//			A.ClickOnSAVEPersonal();
//			
//			Thread.sleep(3000);
//
//			LoginInputData(key, value);
//		}
//	}

	@Then("the \"Discount Rate\" should prompt users to enter valid inputs using the sheet name {string}")
	public void DiscountRate(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		try {
		// Initialize BankLocators and AggregatorLocators only once
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		// Set implicit wait for the driver (optional, explicit wait preferred)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Set the Excel file path and sheet name
		ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
				sheetName);

		// Get the total number of non-empty rows
		int numberOfRows = ExcelUtils.getRowCount(sheetName);
		System.out.println("Total rows found: " + numberOfRows);

		// Loop through all the rows
		for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
			System.out.println("Running test for row number: " + currentRow);

			// Fetch the current row's data
			Map<String, String> testData = ExcelUtils.getRowData(sheetName, currentRow);
			System.out.println("Test data: " + testData);

			ArrayList<String> key = new ArrayList<>();
			ArrayList<String> value = new ArrayList<>();

			// Retrieve data from the row for each field, handling null values
			String channel = testData.get("Channel");
			String pricingPlan = testData.get("Pricing plan");

			key.clear();
			value.clear();

			// Handle "Channel" input
			if (channel != null && !channel.trim().isEmpty()) {
				handleChannelInput(channel, currentRow, key, value);
			} else {
				System.out.println("Channel data is null or empty for row: " + currentRow);
			}

			// Handle "Pricing Plan" input
			if (pricingPlan != null && !pricingPlan.trim().isEmpty()) {
				handlePricingPlanInput(pricingPlan, currentRow, key, value);
			} else {
				System.out.println("Pricing Plan data is null or empty for row: " + currentRow);
			}

			// Save the configuration (after filling all required fields)
			A.ClickOnSAVEPersonal();
			Thread.sleep(3000); // wait for the save action to complete

			// Log input data
			LoginInputData(key, value);
	
		}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate - Aggregator");
			throw e;
		}

	}
	

	private void handleChannelInput(String channel, int currentRow, ArrayList<String> key, ArrayList<String> value)
			throws InterruptedException, AWTException {
		// Handle the channel input
		B.ChannelADD(); // Click 'Add' button for the channel
		Thread.sleep(1000); // Wait for UI stabilization
		B.clickonChannel(); // Click on the Channel dropdown

		// Select the channel from the dropdown
		B.selectDropdownOption(channel);

		// Log input data
		key.add("Channel-" + currentRow);
		value.add(channel);

		performTabKeyPress(); // Navigate to the next input field
	}

	private void handlePricingPlanInput(String pricingPlan, int currentRow, ArrayList<String> key,
			ArrayList<String> value) throws InterruptedException, AWTException {
		// Handle the pricing plan input
		Thread.sleep(1000); // Optional wait for element stabilization
		A.ClickOnDiscountRatePricingPlan(); // Click to select the pricing plan

		// Select the pricing plan from the dropdown
		B.selectDropdownOption(pricingPlan);

		// Log input data
		key.add("Pricing Plan-" + currentRow);
		value.add(pricingPlan);

		performTabKeyPress(); // Navigate to the next input field
	}

	// SystemVerifier-Aggregator

	@When("the System Verifier clicks the Aggregator module")
	public void the_SystemVerifier_Clicks_the_Aggregator_Module() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnPayfac();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Aggregator");
			throw e;
		}

	}

	@When("the System Verifier ensure the Aggregator status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemVerifier_ensure_the_bankstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Aggregator");
			throw e;
		}

	}

	@When("the System Verifier check the Aggregator \"Sales Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifiercheck_SalesInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {
		
		try {

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "SalesInfo");
			throw e;
		}

	}

	@When("the System Verifier checks \"Company Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_CompanyInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnCompanyInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}

	@When("the System Verifier checks \"Personal Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_PersonalInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnPersonalInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@When("the System Verifier checks \"Risk Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_RiskInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnRiskInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@When("the System Verifier checks \"Discount Rate\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_Discount_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnDiscountRate();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate");
			throw e;
		}

	}

	@When("the System Verifier checks \"KYC\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons in Aggregator")
	public void theSystem_Verifierchecks_KYC_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons_Aggregator()
			throws InterruptedException, AWTException {
		
		try {

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

//		Thread.sleep(4000);
//
//		A.ClickOnViewDocument2();
//
//		Thread.sleep(2000);
//
//		A.ClickonActionDiscountRate();
//
//		Thread.sleep(2000);
//
//		A.ViewDocumentVerified();
//
//		Thread.sleep(2000);
//
//		A.ViewDocumentSubmitandNext();
//
//		Thread.sleep(2000);
//
//		A.ClickonActionDiscountRate();
//
//		Thread.sleep(2000);
//
//		A.ViewDocumentVerified();
//
//		Thread.sleep(2000);
//
//		A.ViewDocumentSubmitandNext();
//
//		r.keyPress(KeyEvent.VK_ESCAPE);
//
//		r.keyRelease(KeyEvent.VK_ESCAPE);

		Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

//Approver	

	@When("the System Approver clicks the Aggregator module")
	public void the_SystemApprover_Clicks_the_Aggregator_Module() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnPayfac();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Aggregator");
			throw e;
		}

	}

	@When("the System Approver ensure the Aggregator status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemApprover_ensure_the_bankstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Aggregator");
			throw e;
		}

	}

	@When("the System Approver check if \"Sales Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_SalesInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnSalesInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Aggregator");
			throw e;
		}

	}

	@When("the System Approver check if \"Company Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_CompanyInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnCompanyInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e;
		}

	}


	@When("the System Approver check if \"Personal Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_personalInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnPersonalInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e;
		}

	}

	@When("the System Approver check if \"Risk Info\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_riskInfo_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnRiskInfo();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}

	}

	@When("the System Approver check if \"Discount Rate\" is verified and clicks the \"NextStep\" button")
	public void the_System_Approvercheckif_DiscountRate_isverified_andclicks_the_NextStepbutton()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnDiscountRate();

		Thread.sleep(2000);

		B.DisplayedOnVerified();

		Thread.sleep(2000);

		B.ClickOnNextStep();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Discount Rate");
			throw e;
		}

	}

	@When("Verify that Aggregator CPID is displayed correctly on the \"Aggregator Onboarding List page\" using sheetname {string} and rownumber {int}")
	public void Verify_thatAggregatorCPID_isdisplayedcorrectly_onthe_AggregatorOnboarding_Listpage(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		
		try {

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

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "CPID");
			throw e;
		}

	}

//ISO

	@When("the SystemMaker clicks the ISO module")
	public void SystemMakerClicktheISOModule() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnISO();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "ISO");
			throw e;
		}

	}

	@When("the user select a valid date in the \"ISO Application Date\" field")
	public void theuser_select_avalid_date_inthe_ISO_ApplicationDate_field() throws AWTException, InterruptedException {
		
		try {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnAggreratorApplictionDate();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"Aggregator Name\" field should prompt to select the valid inputs using sheetname {string} and rownumber {int}")
	public void the_AggragatorCode_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

//		String da = "//span[contains(text(),'" + code + "')]";
//		driver.findElement(By.xpath(da)).click();

		String da = "//span[contains(text(),'" + code + "')]";
		WebElement element = driver.findElement(By.xpath(da));
		Thread.sleep(2000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Aggregator Name", code);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@When("the user select a valid date in the \"Agreement Date\" field in ISO")
	public void theuser_select_avalid_date_inthe_AgreementDate_field() throws AWTException, InterruptedException {
		
		try {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnAggrementnDate();

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}


	@When("the SystemMaker clicks the SUBSO module")
	public void SystemMakerClicktheSUBSOModule() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnISO();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SubIso");
			throw e;
		}

	}

	@Then("the \"Save\" button should be prompted to click on Company Info")
	public void the_savebutton_shouldbe_prompted_toclick_On_CompanyInfo() throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

		A.ClickOnSAVEPersonal();

		Thread.sleep(2000);

		B.OkforSuccessfully();
		
		
		} catch (AssertionError ae) {
			takeScreenshotStr("Company Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}


	@Then("the \"Save\" button should be prompted to click on Personal Info in ISO")
	public void the_savebutton_shouldbe_prompted_toclick_On_PersonalInfoiniso() throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

		A.ClickOnSAVEPersonal();

		Thread.sleep(2000);

		driver.navigate().refresh();

		B.OkforSuccessfully();

//		B.OkforSuccessfully();

		driver.navigate().refresh();

	} catch (AssertionError ae) {
		takeScreenshotStr("Personal Info"); // Take screenshot on assertion error
		ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
		throw ae;
	}
}


//ISO

	@Then("the Channel ISO Onboarding should prompt users to enter valid inputs using the sheet name {string}")
	public void processAllDataISO(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		
	try {

		// Initialize BankLocators only once
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		// Set implicit wait for the driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Set the Excel file path and sheet name
		ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
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

			key.clear();
			value.clear();

			// Check if any of the data fields are null or empty and skip that field
			if (channel != null && !channel.trim().isEmpty()) {

				A.ClickOnChannelConfig();

				Thread.sleep(2000);// Wait to ensure page elements load properly
				B.ChannelADD();

				Thread.sleep(1000);

//	            B.CLickOnChannelConfig(); // Open the channel config
				Thread.sleep(2000); // Wait to ensure page elements load properly
				B.ClickonCommercialChannel(); // Click on the channel dropdown

				Thread.sleep(1000);
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

				Thread.sleep(1000);
				B.clickonNetwork();
				Thread.sleep(1000);// Click on the network dropdown
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
				Thread.sleep(1000);
				B.clickonTransactionsetPoS();
				Thread.sleep(1000);// Click on the transaction set dropdown
				B.selectDropdownOption(transactionSet); // Select transaction set from Excel
//	            LoginInputDatas("Transaction Set-" + currentRow, transactionSet);
				key.add("Transaction Set-" + currentRow);
				value.add(transactionSet);
				performTabKeyPress();
				// Log input data for transaction set
			} else {
				System.out.println("Transaction Set data is null or empty for row: " + currentRow);
			}

			Thread.sleep(2000);
			A.ClickOnChannelStartDate();
			A.ClickOnChannelApply();
			performTabKeyPress();

			Thread.sleep(2000);
			A.ClickOnChannelENDDate();
			A.ClickOnChannelApply();
			performTabKeyPress();

			Thread.sleep(2000);
			// Save the configuration (Only after filling all required fields)
			A.ClickOnChannelSave();

			Thread.sleep(2000);
			LoginInputData(key, value);
		}
		
		
	} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		exceptionHandler.handleException(e, "Channel ISO");
		throw e;
	}

}


//ISO

	@When("the System Verifier clicks the ISO module")
	public void the_SystemVerifier_Clicks_the_ISO_Module() {
		
		
	try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnISO();

	} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		exceptionHandler.handleException(e, "Onboarding ISO");
		throw e;
	}

}

	@When("the System Verifier ensure the ISO status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemVerifier_ensure_the_ISOstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		LoginInputDatas("Search by ISO Name", Aggrename);

	
		} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		exceptionHandler.handleException(e, "Onboarding - ISO");
		throw e;
	}

}

	@When("the System Verifier checks \"Sales Info\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons")
	public void theSystem_Verifierchecks_SalesInfo_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons()
			throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnSalesInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@When("Verify that ISO CPID is displayed correctly on the \"ISO Onboarding List page\" using sheetname {string} and rownumber {int}")
	public void Verify_thatISOCPID_isdisplayedcorrectly_onthe_ISOOnboarding_Listpage(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		
	try {

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

		LoginInputDatas("ISO CPID", cpid);

	} catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		exceptionHandler.handleException(e, "CPID");
		throw e;
	}

}

	@When("the System Approver clicks the ISO module")
	public void the_SystemApprover_Clicks_the_ISO_Module() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnISO();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "ISO");
			throw e;
		}

	}

	@When("the System Approver ensure the ISO status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemApprover_ensure_the_ISOstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		
		try {

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

		LoginInputDatas("Search by ISO Name", Aggrename);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - ISO");
			throw e;
		}

	}

	@Then("The \"NextStep\" button should prompted to click on KYC in ISO")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_KYC_ISO() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);
		ISO = new org.Locators.ISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		try {

			B.ClickOnNextStep();

			Thread.sleep(1000);

			ISO.DisplayedOnIntroDiscountRate();

		} catch (AssertionError ae) {
			takeScreenshotStr("KYC"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("The \"NextStep\" button should prompted to click on Channel Config in ISO")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_ChannelComfig_ISO() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);
		ISO = new org.Locators.ISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		try {

			B.ClickOnNextStep();

			Thread.sleep(1000);

			A.DisplayedOnIntroKYC();

		} catch (AssertionError ae) {
			takeScreenshotStr("Channel Config"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"NextStep\" button should prompted to click on Settlement Info in ISO")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_Settlement_ISO() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);
		ISO = new org.Locators.ISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		try {

			B.ClickOnNextStep();

			Thread.sleep(1000);

			ISO.DisplayedOnIntroWhiteLabelISO();

		} catch (AssertionError ae) {
			takeScreenshotStr("Settlement Info"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"NextStep\" button should prompted to click on Whitelabel in ISO")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_Whitelabel_ISO() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);
		ISO = new org.Locators.ISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		try {

			B.ClickOnNextStep();

			Thread.sleep(1000);

			A.DisplayedOnIntroWebhook();

		} catch (AssertionError ae) {
			takeScreenshotStr("Whitelabel"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@Then("the \"NextStep\" button should prompted to click on Webhook in ISO")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_Webhook_ISO() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);
		ISO = new org.Locators.ISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(2000);

		try {

			B.ClickOnNextStep();

			Thread.sleep(1000);

			B.DisplayedOnstatusHistory();

		} catch (AssertionError ae) {
			takeScreenshotStr("Webhook"); // Take screenshot on assertion error
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
			throw ae;
		}
	}

	@When("the System Verifier checks \"KYC\" to ensure mandatory details are added and clicks the \"Verified and Next\" buttons in ISO")
	public void theSystem_Verifierchecks_KYC_toensure_mandatory_detailsareadded_and_clicksthe_VerifiedandNext_buttons_ISO()
			throws InterruptedException, AWTException {
		
		try {

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

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);

		r.keyRelease(KeyEvent.VK_ESCAPE);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
			throw e;
		}

	}

//SUB ISO

	@When("the SystemMaker clicks the SUB ISO module")
	public void SystemMakerClicktheSUBISOModule() throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(1000);

		S.ClickOnSUBISO();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SUB ISO");
			throw e;
		}

	}

	@Then("the \"ISO Name\" field should prompt to select the valid inputs using sheetname {string} and rownumber {int}")
	public void the_ISOCode_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		ISO = new org.Locators.ISOLocators(driver);

		SUBISO = new org.Locators.SUBISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String code = testdata.get(rowNumber).get("ISO Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		SUBISO.ClickOnISOName();

		Thread.sleep(1000);

//		SUBISO.EnteronISOName(code);

		Thread.sleep(2000);

		String da = "//span[contains(text(),'" + code + "')]";
		WebElement element = driver.findElement(By.xpath(da));
		Thread.sleep(2000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);

//			Thread.sleep(2000);
//			Robot r = new Robot();
//	
//			r.keyPress(KeyEvent.VK_TAB);
//	
//			r.keyRelease(KeyEvent.VK_TAB);
//	
		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("ISO Name", code);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the Whitelabel \"Group Merchant Onboarding\" dropdown should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_Whitelabel_GroupMerchantOnboarding_dropdown_should_prompt_to_select_valid_inputs(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String type = testdata.get(rowNumber).get("Group Merchant Onboarding");

		System.out.println("0" + testdata.get(0));

		B.ClickOnWhitelabelISOOnboarding();

		B.selectDropdownOption(type);

		Thread.sleep(2000);

		performTabKeyPress();

		LoginInputDatas("Whitelabel Group Merchant Onboarding", type);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}

	}

	@When("the System Verifier clicks the SUB ISO module")
	public void the_SystemVerifier_Clicks_the_SUBISO_Module() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnSUBISO();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sub ISO");
			throw e;
		}

	}

	@When("the System Verifier ensure the SUB ISO status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemVerifier_ensure_the_SUBISOstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		LoginInputDatas("Search by SUB SO Name", Aggrename);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding -Sub ISO");
			throw e;
		}

	}

	@When("Verify that SUB ISO CPID is displayed correctly on the \"SUB ISO Onboarding List page\" using sheetname {string} and rownumber {int}")
	public void Verify_thatSUBISOCPID_isdisplayedcorrectly_onthe_ISOOnboarding_Listpage(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		LoginInputDatas("SUB ISO CPID", cpid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "SUB ISO - CPID");
			throw e;
		}

	}

	@When("the System Approver clicks the SUB ISO module")
	public void the_SystemApprover_Clicks_the_SUBISO_Module() {
		
    try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnSUBISO();

    } catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		exceptionHandler.handleException(e, "Onboarding -Sub ISO");
		throw e;
	}

}


	@When("the System Approver ensure the SUB ISO status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemApprover_ensure_the_SUBISOstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		LoginInputDatas("Search by SUB ISO Name", Aggrename);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding -Sub ISO");
			throw e;
		}

	}

	@Then("the \"Save\" button should be prompted to click on Whitelabel")
	public void the_savebutton_shouldbe_prompted_toclick_On_Whitelabel() throws InterruptedException {
		
		
	try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

		A.ClickOnSAVEPersonal();

		Thread.sleep(2000);
		
		
//
//		B.OkforSuccessfully();
	} catch (AssertionError ae) {
		takeScreenshotStr("Whitelabel"); // Take screenshot on assertion error
		ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: " + ae.getMessage());
		throw ae;
	}
}


//Group Merchant

	@When("the SystemMaker clicks the Group Merchant module")
	public void SystemMakerClicktheGroupMerchantModule() throws InterruptedException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(1000);

		S.ClickOnGM();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding -Group Merchant");
			throw e;
		}

	}
	
	@Then("the \"SUB ISO Name\" field should prompt to select the valid inputs using sheetname {string} and rownumber {int}")
	public void the_GroupMerchant_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		ISO = new org.Locators.ISOLocators(driver);

		GM = new org.Locators.GroupMerchantLocator(driver);

		SUBISO = new org.Locators.SUBISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String code = testdata.get(rowNumber).get("SUB ISO Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		GM.ClickOnSUBISOName();

		Thread.sleep(1000);

//		SUBISO.EnteronISOName(code);

		Thread.sleep(2000);

		String da = "//span[contains(text(),'" + code + "')]";
		WebElement element = driver.findElement(By.xpath(da));
		Thread.sleep(2000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);

//			Thread.sleep(2000);
//			Robot r = new Robot();
//	
//			r.keyPress(KeyEvent.VK_TAB);
//	
//			r.keyRelease(KeyEvent.VK_TAB);
//	
		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("SUB ISO Name", code);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e;
		}

	}

	@Then("the \"Unique Reference Number\" field should prompt to enter the valid inputs using sheetname {string} and rownumber {int}")
	public void UniqueReferenceNumber_field_should_prompt_to_enter_valid_inputs_within_30_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {
		try {
			B = new org.Locators.BankLocators(driver);

			GM = new org.Locators.GroupMerchantLocator(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader.getData(
					"C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String num = testdata.get(rowNumber).get("Unique Reference Number");

			System.out.println("0" + testdata.get(0));

			Thread.sleep(1000);

			GM.ClickOnUniqueReferenceNumber();

			Thread.sleep(1000);

			GM.EnteronUniqueReferenceNumber(num);

			performTabKeyPress();

			LoginInputDatas("Unique Reference Number", num);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Unique Reference Number");
			throw e;
		}
	}

	@Then("the \"Nature of business\" field should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_business_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		ISO = new org.Locators.ISOLocators(driver);

		GM = new org.Locators.GroupMerchantLocator(driver);

		SUBISO = new org.Locators.SUBISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String code = testdata.get(rowNumber).get("Nature Of Business");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		GM.ClickOnnatureofbusiness();

		Thread.sleep(2000);

		B.selectDropdownOption(code);

		B.NOTDisplayedOnInvalidFormat();

		LoginInputDatas("Nature Of Business", code);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Nature Of Business");
			throw e;
		}
	}

	@Then("the \"MCC\" field should prompt to select valid inputs using sheetname {string} and rownumber {int}")
	public void the_MCC_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		ISO = new org.Locators.ISOLocators(driver);

		GM = new org.Locators.GroupMerchantLocator(driver);

		SUBISO = new org.Locators.SUBISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String mcc = testdata.get(rowNumber).get("MCC");

		if (mcc != null && mcc.matches("\\d+\\.0")) {
			mcc = mcc.substring(0, mcc.indexOf(".0"));

			System.out.println("0" + testdata.get(0));

			Thread.sleep(2000);

			GM.ClickOnMCC();

			Thread.sleep(2000);

			B.selectDropdownOption(mcc);

			B.NOTDisplayedOnInvalidFormat();

			LoginInputDatas("MCC", mcc);

		}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "MCC");
			throw e;
		}
	}

	@When("the System Verifier clicks the Group Merchant module")
	public void the_SystemVerifier_Clicks_the_GroupMerchant_Module() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnGM();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Group Merchant");
			throw e;
		}
	}

	@When("the System Verifier ensure the Group Merchant status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemVerifier_ensure_the_GMstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		LoginInputDatas("Search by Group Merchant Name", Aggrename);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Group Merchant");
			throw e;
		}
	}

	@When("Verify that Group Merchant CPID is displayed correctly on the \"Group Merchant Onboarding List page\" using sheetname {string} and rownumber {int}")
	public void Verify_thatGroupMerchantCPID_isdisplayedcorrectly_onthe_ISOOnboarding_Listpage(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		LoginInputDatas("Group Merchant CPID", cpid);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "CPID - Group Merchant");
			throw e;
		}
	}

	@When("the System Approver clicks the Group Merchant module")
	public void the_SystemApprover_Clicks_the_GroupMerchant_Module() {
		
		try {

		B = new org.Locators.BankLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		S.ClickOnGM();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Group Merchant");
			throw e;
		}
	}

	@When("the System Approver ensure the Group Merchant status \"Inprogress\" using sheetname {string} and rownumber {int}")
	public void the_SystemApprover_ensure_the_GroupMerchantstatus_Inprogress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		
		try {

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

		LoginInputDatas("Search by Group Merchant Name", Aggrename);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - Group Merchant");
			throw e;
		}
	}

	@When("the System Verifier checks \"KYC\" to ensure mandatory details are added and clicks the \"Verify Document\" button")
	public void theSystem_Verifierchecks_KYC_toensure_mandatory_details_areadded_andclicks_the_VerifyDocumentbutton()
			throws InterruptedException {
		
		try {
		GM = new org.Locators.GroupMerchantLocator(driver);

		SUBISO = new org.Locators.SUBISOLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		GM.verifyDocument();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC");
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
