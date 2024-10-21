package org.Testcases;

import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.picocontainer.PicoFactory;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.event.KeyEvent;

import java.io.ByteArrayInputStream;

import java.io.File;

import java.io.IOException;

import java.time.Duration;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Map;

import java.util.Set;

import java.util.UUID;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.junit.Assert;

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

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import io.qameta.allure.Allure;

public class SystemUserMultipleBankRegression {

	private WebDriver driver;

	org.Locators.BaseClassLocator BL;
	org.Locators.SystemUserLocatores S;
	org.Locators.LoginLocators L;
	org.Locators.BankLocators B;
	org.Locators.AggregatorLocators A;
	org.Locators.ISOLocators ISO;
	org.Locators.SUBISOLocators SUBISO;
	org.Locators.GroupMerchantLocator GM;
	org.Locators.MerchantLocators M;
	org.Locators.TerminalLocators T;

	ExtentTest test;

	ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();

	public SystemUserMultipleBankRegression() throws InterruptedException {

		this.driver = CustomWebDriverManager.getDriver();

//	this.driver = driver;

		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");

		System.setProperty("webdriver.chrome.verboseLogging", "true");

		BL = new org.Locators.BaseClassLocator(driver);

		L = new org.Locators.LoginLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		ISO = new org.Locators.ISOLocators(driver);

		SUBISO = new org.Locators.SUBISOLocators(driver);

		GM = new org.Locators.GroupMerchantLocator(driver);

		M = new org.Locators.MerchantLocators(driver);

		T = new org.Locators.TerminalLocators(driver);

	}

	@Before("@loadDataExcelUtils")

	@Given("I load data from Excel using sheetname \"Credentials\"")

	public static void setUp() throws InvalidFormatException, IOException {

		ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();

		System.out.println("BEFORE ALL WORK");

		cache.loadData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx"); // Load data

		// only once

	}

	@Given("I visit the System Maker Login in Regression using sheetname {string} and rownumber {int}")

	public void i_visit_the_System_maker_login(String sheetName, int rowNumber)

			throws InvalidFormatException, IOException, InterruptedException {

		try {

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String userName = testdata.get(rowNumber).get("UserName");

			String password = testdata.get(rowNumber).get("Password");

			BL.enterElement(L.EnterOnUserName, userName);

			BL.enterElement(L.EnterOnPassword, password);

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

	@And("I enter the credentials and click a login button in Regression using sheetname {string} and rownumber {int}")

	public void i_enter_the_credentials_and_click_a_login_button(String sheetName, int rowNumber)

			throws InvalidFormatException, IOException, InterruptedException {

		try {

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String Captcha = testdata.get(rowNumber).get("Captcha");

			BL.enterElement(L.EnterOnCaptcha, Captcha);

			BL.clickElement(L.ClickOnLogin);

			BL.clickElement(B.OKButton);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "LoginScreen");

			throw e;

		}

	}

	@When("System Maker - Onboarding should be displayed in the side menu")

	public void I_Visit_System_Maker_Onboarding() throws InterruptedException {

		try {

			BL.clickElement(S.ClickOnDownArrow);

			BL.clickElement(S.ClickOnOnboarding);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@Then("the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Maker_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		try {

			BL.isElementDisplayed(B.ClickOnBank, "Bank");

			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");

			BL.isElementDisplayed(B.ClickOnISO, "ISO");

			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");

			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");

			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");

			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@When("the System Maker clicks the bank module")

	public void SystemMakerClicktheBankModule() {

		try {

			BL.clickElement(B.ClickOnBank);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	int totalTestCaseCount = 0;

	@Then("the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}")

	public void processAllData(String sheetName)

			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		// Load data from the cache only once

		List<Map<String, String>> testData = cache.getCachedData(sheetName);

		if (testData == null || testData.isEmpty()) {

			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);

		}

		int numberOfRows = testData.size(); // Number of rows based on cached data

		System.out.println("Total rows found: " + numberOfRows);

		TestCaseManager testCaseManager = new TestCaseManager();

		// Iterate over the cached data

		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {

			System.out.println("Running test for row number: " + rowNumber);

			// Group by row number in Allure

			testCaseManager.startNewTestSuite(rowNumber);

			// Get row data from cache

			Map<String, String> rowData = testData.get(rowNumber - 1);

			try {

				// Start the test case and log the input data for the row

				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);

				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));

				int rowTestCaseCount = runTestForRow(sheetName, rowData, rowNumber);

				totalTestCaseCount += rowTestCaseCount;

				testCaseManager.endTestCase(true);

			} catch (Exception e) {

				takeScreenshot(rowNumber);

				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports

				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());

				testCaseManager.endTestCase(false);

			} finally {

				testCaseManager.endTestSuite(); // End the suite (grouping) for this row

			}

			if (rowNumber == numberOfRows) {

				System.out.println("Finished processing the last row. Logging out...");

				performLogout();

			}

		}

		logDashboardCount();

	}

	private void logDashboardCount() {

		String message = "Total Dashboard Count: " + totalTestCaseCount;

		ExtentCucumberAdapter.addTestStepLog(message);

		Allure.parameter("Total Test Case Count", totalTestCaseCount);

		System.out.println(message);

	}

	private int runTestForRow(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row

		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)

		int testCaseCount = 0;

		// Validate fields for the current row using testData

		testCaseCount += validateFieldsForRow(sheetName, testData, rowNumber, testCaseCount);

		return testCaseCount;

	}

	private void takeScreenshot(int rowNumber) {

		try {

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String screenshotPath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" + rowNumber

					+ ".png";

			FileUtils.copyFile(screenshot, new File(screenshotPath));

			Allure.addAttachment("Screenshot for Row " + rowNumber,

					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	ArrayList<String> key = new ArrayList<>();

	ArrayList<String> value = new ArrayList<>();

	private void logInputDataa() {

		String[] keys = key.toArray(new String[0]);

		String[] values = value.toArray(new String[0]);

		String[][] data = new String[2][keys.length];

		data[0] = keys;

		data[1] = values;

		Markup m = MarkupHelper.createTable(data);

		ExtentCucumberAdapter.getCurrentStep().log(null, m);

		StringBuilder tableBuilder = new StringBuilder();

		tableBuilder.append("<table style='color: black; border: 1px solid black; border-collapse: collapse;'>");

		tableBuilder.append("<tr>");

		for (String key : keys) {

			tableBuilder.append("<th style='border: 1px solid black; color: black;'>").append(key).append("</th>");

		}

		tableBuilder.append("</tr>");

		tableBuilder.append("<tr>");

		for (String value : values) {

			tableBuilder.append("<td style='border: 1px solid black; color: black;'>").append(value).append("</td>");

		}

		tableBuilder.append("</tr>");

		tableBuilder.append("</table>");

		Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(tableBuilder.toString().getBytes()),

				"html");

	}

	@SuppressWarnings("unused")

	private int validateFieldsForRow(String sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)

			throws Exception {

		int validatedFieldsCount = 0;

		// Bank Details Section

		String bankName = null;

		validatedFieldsCount += executeStep(() -> {

			try {

//	fillBankDetails(testData, TestcaseNo);

				String generatedBankName = fillBankDetails(testData, TestcaseNo);

				testData.put("bankName", generatedBankName);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Bank Details");

		// Communication Details Section

		validatedFieldsCount += executeStep(() -> {

			try {

				fillCommunicationDetails(testData, TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Communication Details");

		// Channel Config Section

		validatedFieldsCount += executeStep(() -> {

			try {

				fillChannelConfig(testData, TestcaseNo);

			} catch (InterruptedException | AWTException | IOException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Channel Config");

		// ONUS Section

		validatedFieldsCount += executeStep(() -> {

			try {

				configureONUS(testData, TestcaseNo);

			} catch (InterruptedException | AWTException | IOException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "ONUS Configuration");

		// Global Form Section

		validatedFieldsCount += executeStep(() -> {

			try {

				fillGlobalForm(testData, TestcaseNo);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Global Form");

		// Commercial Section

		validatedFieldsCount += executeStep(() -> {

			try {

				configureCommercialInterChange(testData, TestcaseNo);

			} catch (Exception e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Commercial InterChange");

		validatedFieldsCount += executeStep(() -> {

			try {

				configureCommercialBankOnboarding(testData, TestcaseNo);

			} catch (Exception e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Commercial Bank Onboarding");

		// Settlement Info Section

		validatedFieldsCount += executeStep(() -> {

			try {

				fillSettlementInfo(testData, TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Settlement Info");

		// White Label Section

		validatedFieldsCount += executeStep(() -> {

			try {

				configureWhiteLabel(testData, TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "White Label Configuration");

		// Webhooks Section

		validatedFieldsCount += executeStep(() -> {

			try {

				configureWebhooks(testData, TestcaseNo);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Webhook Configuration");

		// KYC Section

		validatedFieldsCount += executeStep(() -> {

			try {

				fillKYCDetails(testData, TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "KYC Details");

		// Final Submission

		validatedFieldsCount += executeStep(() -> {

			try {

				submitForVerification();

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Final Submission");

		// Return the total count of validated fields/sections

		return validatedFieldsCount;

	}

	private int executeStep(Runnable step, String stepName) {

		try {

			step.run();

			return 1; // Return 1 for successful execution

		} catch (Exception e) {

			// Handle the exception and log the error

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, stepName);

			return 0; // Return 0 for failed execution

		}

	}

	private Set<String> existingBankNames = new HashSet<>();

	// Method to fill Bank Details

	private String fillBankDetails(Map<String, String> testData, int TestcaseNo)

			throws InterruptedException, AWTException {

		try {

			Faker faker = new Faker();

			int testcaseCount = 0;

			String bankName = null;

			String address = testData.get("Address");

			String pincode = testData.get("Pincode");

			String gst = testData.get("GST");

			String pan = testData.get("PAN");

			String Marsid = testData.get("Mars id");

			String StatementFrequency = testData.get("Statement Frequency");

			String StatementType = testData.get("Statement Type");

			String[] domains = { testData.get("Domain"), testData.get("Domain1"), testData.get("Domain2") };

			key.clear();

			value.clear();

			String errorMessage = "The data does not match or is empty.";

			TestCaseManager testCaseManager = new TestCaseManager();

			if (bankName == null || bankName.trim().isEmpty()) {

				bankName = generateValidBankName(faker, existingBankNames);

			}

			if (bankName != null && !bankName.trim().isEmpty()) {

				BL.clickElement(B.Createbutton);

				BL.clickElement(B.BankName);

				BL.CLearElement(B.BankName);

				BL.enterElement(B.BankName, bankName);

				++testcaseCount;

				boolean bankNameStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					bankNameStatus = false; // Set status to false if assertion fails

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Bank Name", bankName, bankNameStatus, errorMessage);

			}

			if (address != null && !address.trim().isEmpty()) {

				BL.clickElement(B.Address);

				BL.enterElement(B.Address, address);

				++testcaseCount;

				boolean AddressNameStatus = true; // Assume success initially

				try {

					// Perform assertion check (modify this as per your requirement)

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					AddressNameStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

//	String getaddress = B.getAddress();

				logTestStep(TestcaseNo, "Address Name", address, AddressNameStatus, errorMessage);

			}

//	if (pincode != null && pincode.matches("\\d+\\.0")) {

//	pincode = pincode.substring(0, pincode.indexOf(".0"));

			if (pincode != null && !pincode.trim().isEmpty()) {

				BL.clickElement(B.Pincode);

				BL.selectDropdownOption(pincode);

				++testcaseCount;

				boolean PincodeStatus = true; // Assume success initially

				try {

					// Perform assertion check (modify this as per your requirement)

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					PincodeStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Pincode :", pincode, PincodeStatus, errorMessage);

			}

			if (gst != null && !gst.trim().isEmpty()) {

				BL.clickElement(B.GST);

				BL.enterElement(B.GST, gst);

				++testcaseCount;

				boolean GSTStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					GSTStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "GST :", gst, GSTStatus, errorMessage);

			}

			if (pan != null && !pan.trim().isEmpty()) {

				BL.clickElement(B.PAN);

				BL.enterElement(B.PAN, pan);

				++testcaseCount;

				boolean PANStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					PANStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "PAN :", pan, PANStatus, errorMessage);

			}

			if (Marsid.contains("E")) {

				Double Marsid1 = Double.valueOf(Marsid);

				Marsid = String.format("%.0f", Marsid1);

			}

			if (Marsid != null && !Marsid.trim().isEmpty()) {

				BL.clickElement(B.Marsid);

				BL.enterElement(B.Marsid, Marsid);

				++testcaseCount;

				boolean MarsidStatus = true; // Assume success initially

				logTestStep(TestcaseNo, "Marsid :", Marsid, MarsidStatus, errorMessage);

			}

			if (StatementFrequency != null && !StatementFrequency.trim().isEmpty()) {

				BL.clickElement(B.StatementFrequency);

				BL.selectDropdownOption(StatementFrequency);

				++testcaseCount;

				boolean StatementFrequencyStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					StatementFrequencyStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Statement Frequency :", StatementFrequency, StatementFrequencyStatus,

						errorMessage);

			}

			if (StatementType != null && !StatementType.trim().isEmpty()) {

				BL.clickElement(B.StatementType);

				BL.selectDropdownOption(StatementType);

				logInputData("Statement Type", StatementType);

				++testcaseCount;

				boolean StatementTypeStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					StatementTypeStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Statement Type :", StatementType, StatementTypeStatus, errorMessage);

			}

			for (String domain : domains) {

				if (domain != null && !domain.trim().isEmpty()) {

					BL.clickElement(B.Domain);

					BL.enterElement(B.Domain, domain);

					performTabKeyPress();

					logInputData("Domain", domain);

					++testcaseCount;

					boolean domainStatus = true;

					try {

						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

					} catch (AssertionError e) {

						domainStatus = false;

						errorMessage = e.getMessage(); // Capture error message

					}

					logTestStep(TestcaseNo, "Domain", domain, domainStatus, errorMessage);

				}

			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.AdminUserDetails, "Communication Info Page");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "General Info", NextstepStatus, errorMessage);

			return bankName;

		} catch (Exception e) {

			// Use the exception handler to log and handle exceptions gracefully

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "General Info");

			throw e; // Re-throw the exception after handling

		}

	}

	private String generateValidBankName(Faker faker, Set<String> existingBankNames) {

		String bankName;

		int attempts = 0;

		final int maxAttempts = 100;

		do {

			// Generate a bank name

			bankName = faker.company().name().trim();

			attempts++;

			// Check if max attempts have been reached

			if (attempts >= maxAttempts) {

				throw new IllegalStateException(

						"Unable to generate a unique valid bank name after " + maxAttempts + " attempts");

			}

		} while (!isValidBankName(bankName, existingBankNames));

		// Store the valid bank name in the set to avoid future duplicates

		existingBankNames.add(bankName.toLowerCase());

		return bankName;

	}

	// Helper method to validate bank name

	private boolean isValidBankName(String bankName, Set<String> existingBankNames) {

		// Check length

		if (bankName.length() < 7 || bankName.length() > 30) {

			return false;

		}

		// Check for duplicate variations

		String baseName = bankName.toLowerCase();

		if (existingBankNames.contains(baseName)) {

			return false;

		}

		// Check for variations (like "BANK ONE", "BANK TWO")

		for (int i = 1; i <= 100; i++) { // Assuming a maximum of 100 variations

			String variation = baseName + " " + i;

			if (existingBankNames.contains(variation)) {

				return false;

			}

		}

		// Check if the name contains only letters and spaces

		return bankName.matches("[a-zA-Z\\s]+");

	}

	private void logTestStep(int testcaseCount, String fieldName, String fieldValue, Boolean status,

			String errorMessage) {

		String message = "BO Test Case " + testcaseCount + ": " + fieldName + " with value '" + fieldValue + "' "

				+ (status ? "passed." : "failed.");

		// Log to Extent Report

		ExtentCucumberAdapter.addTestStepLog(message);

		List<String> keys = new ArrayList<>();

		List<String> values = new ArrayList<>();

		TestCaseManager testCaseManager = new TestCaseManager();

		// Start a new test case

		testCaseManager.startNewTestCase(message, status);

		// Add field name and value to the lists

		keys.add(fieldName);

		values.add(fieldValue);

		testCaseManager.logInputDataa(keys, values);

		Allure.step("Test case for row " + testcaseCount);

		testCaseManager.endTestCase(status);

		// Log error message if status is false

		if (!status && errorMessage != null) {

			// Log the assertion error message

			ExtentCucumberAdapter.addTestStepLog("Error: " + errorMessage);

		}

		// Optionally, print to console for debugging

		System.out.println(message);

	}

	// Method to fill Communication Details

	private void fillCommunicationDetails(Map<String, String> testData, int TestcaseNo)

			throws InterruptedException, AWTException {

		try {

			int testcaseCount = 0;

			String errorMessage = "The data does not match or is empty.";

			String CommName = testData.get("Communication Name");

			String CommPosition = testData.get("Communication Position");

			String CommMobileNumber = testData.get("Communication MobileNumber");

			String CommEmailid = testData.get("Communication EmailId");

			String ADUSer = testData.get("AD User");

			BL.clickElement(B.ClickonCommunicationInfo);

			BL.clickElement(B.AddButton);

			if (CommName != null && !CommName.trim().isEmpty()) {

				BL.clickElement(B.ClickonCommuName);

				BL.enterElement(B.ClickonCommuName, CommName);

				++testcaseCount;

				boolean CommunicationNameStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					CommunicationNameStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Communication Name", CommName, CommunicationNameStatus, errorMessage);

			}

			if (CommPosition != null && !CommPosition.trim().isEmpty()) {

				BL.clickElement(B.ClickonCommuPosition);

				BL.enterElement(B.ClickonCommuPosition, CommPosition);

				++testcaseCount;

				boolean CommunicationPositionStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					CommunicationPositionStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Communication Position", CommPosition, CommunicationPositionStatus,

						errorMessage);

			}

			if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {

				Faker faker = new Faker();

				// Generate a valid mobile number starting with 9, 8, 7, or 6

				String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9

				String remainingDigits = faker.number().digits(9); // Generate 9 random digits

				String communicationMobileNumber = firstDigit + remainingDigits;

				BL.clickElement(B.ClickonCommuMobileNumber);

				BL.enterElement(B.ClickonCommuMobileNumber, communicationMobileNumber);

				++testcaseCount;

				boolean CommunicationMobileNumberStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					CommunicationMobileNumberStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Communication MobileNumber", communicationMobileNumber,

						CommunicationMobileNumberStatus, errorMessage);

			}

			if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {

				Faker faker = new Faker();

				// Generate a random email address with @gmail.com

				String randomEmailPrefix = faker.internet().slug(); // Generate a random string for the prefix

				String Communicationemailid = randomEmailPrefix + "@gmail.com";

				BL.clickElement(B.ClickonCommuEmailId);

				BL.enterElement(B.ClickonCommuEmailId, Communicationemailid);

				++testcaseCount;

				boolean CommunicationEmailIDStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					CommunicationEmailIDStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Communication Emailid", Communicationemailid, CommunicationEmailIDStatus,

						errorMessage);

			}

			if (ADUSer != null && !ADUSer.trim().isEmpty()) {

				BL.clickElement(B.ClickOnAdUsers);

				BL.selectDropdownOption(ADUSer);

				++testcaseCount;

				boolean CommunicationADUSERStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					CommunicationADUSERStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "AD User", ADUSer, CommunicationADUSERStatus, errorMessage);

			}

			boolean SaveStatus = true;

			try {

				BL.clickElement(B.SaveButton);

				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

			} catch (AssertionError e) {

				SaveStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "Save Button", "Communication Info", SaveStatus, errorMessage);

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroChannelConfiguration, "Channel Config");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "Communication Info", NextstepStatus, errorMessage);

		} catch (Exception e) {

			// Use the exception handler to log and handle exceptions gracefully

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Communication Info");

			throw e; // Re-throw the exception after handling

		}

	}

	// Method to configure Channel

	private void fillChannelConfig(Map<String, String> testData, int TestcaseNo)

			throws InterruptedException, AWTException, IOException {

		int testcaseCount = 0;

		String errorMessage = "The data does not match or is empty.";

		try {

			// Initialize BankLocators only once

			if (B == null) {

			}

			// Use cached data for the "Channel Bank" sheet to avoid multiple loads

			List<Map<String, String>> cachedData = cache.getCachedData("Channel Bank");

			int numberOfRows = cachedData.size();

			System.out.println("Total rows found: " + numberOfRows);

			// Loop through each row in the cached data

			for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {

				System.out.println("Running test for row number: " + currentRow);

				ArrayList<String> key = new ArrayList<>();

				ArrayList<String> value = new ArrayList<>();

				// Fetch the current row's data from cache

				Map<String, String> rowData = cachedData.get(currentRow - 1);

				// Retrieve data for each field, handling null or empty values

				String channel = rowData.getOrDefault("Channel", "").trim();

				String network = rowData.getOrDefault("Network", "").trim();

				String transactionSet = rowData.getOrDefault("Transaction Sets", "").trim();

				String routing = rowData.getOrDefault("Routing", "").trim();

				// Clear the key-value arrays before each iteration

				key.clear();

				value.clear();

				// Process Channel data

				if (!channel.isEmpty()) {
					BL.clickElement(B.ChannelConfig);
					
					Thread.sleep(1000);

					BL.clickElement(B.CommercialADD1);

					BL.clickElement(B.CommercialChannel);

					BL.selectDropdownOption(channel);

					key.add("Channel-" + currentRow);

					value.add(channel);

					performTabKeyPress();

					boolean ChannelStatus = true;

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

					++testcaseCount;

					logTestStep(TestcaseNo, "Channel", channel, ChannelStatus, errorMessage);

				} else {

					System.out.println("Channel data is empty for row: " + currentRow);

				}

				// Process Network data

				if (!network.isEmpty()) {

					BL.clickElement(B.ClickOntNetwork);

					BL.selectDropdownOption(network);

					key.add("Network-" + currentRow);

					value.add(network);

					performTabKeyPress();

					boolean NetworkStatus = true;

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

					++testcaseCount;

					logTestStep(TestcaseNo, "Network", network, NetworkStatus, errorMessage);

				} else {

					System.out.println("Network data is empty for row: " + currentRow);

				}

				// Process Transaction Set data

				if (!transactionSet.isEmpty()) {

					BL.clickElement(B.ClickOntransaction);

					BL.selectDropdownOption(transactionSet);

					key.add("Transaction Set-" + currentRow);

					value.add(transactionSet);

					performTabKeyPress();

					boolean TransactionStatus = true;

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

					++testcaseCount;

					logTestStep(TestcaseNo, "TransactionSet", transactionSet, TransactionStatus, errorMessage);

				} else {

					System.out.println("Transaction Set data is empty for row: " + currentRow);

				}

				// Process Routing data

				if (!routing.isEmpty()) {

					BL.clickElement(B.ClickOnRouting);

					BL.selectDropdownOption(routing);

					key.add("Routing-" + currentRow);

					value.add(routing);

					performTabKeyPress();

					boolean RoutingStatus = true;

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

					++testcaseCount;

					logTestStep(TestcaseNo, "Routing", routing, RoutingStatus, errorMessage);

				} else {

					System.out.println("Routing data is empty for row: " + currentRow);

				}

				boolean SaveStatus = true;

				try {

					BL.clickElement(B.SaveButton);

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					SaveStatus = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Save Button", "Channel Config", SaveStatus, errorMessage);

				// Log input data in a structured format

				LoginInputData(key, value);

			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.ONUSRouting, "ONUS Routing");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "Channel Config", NextstepStatus, errorMessage);

		} catch (Exception e) {

			// Use the exception handler to log and handle exceptions gracefully

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Channel Config");

			throw e; // Re-throw the exception after handling

		}

	}

	private void configureONUS(Map<String, String> testData, int TestcaseNo)

			throws InterruptedException, AWTException, IOException {

		try {

			String errorMessage = "The data does not match or is empty.";

			List<Map<String, String>> cachedData = cache.getCachedData("Channel Bank");

			int numberOfRows = cachedData.size();

			System.out.println("Total rows found: " + numberOfRows);

			int testcaseCount = 0;

			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {

				System.out.println("Running test for row number: " + (currentRow + 1));

				Map<String, String> rowData = cachedData.get(currentRow);

				String POSBIN = rowData.getOrDefault("ONUS Routing POS", "").trim();

				String MATMBIN = rowData.getOrDefault("ONUS Routing MATM", "").trim();

				if (POSBIN.isEmpty() && MATMBIN.isEmpty()) {

					System.out

							.println("Stopping loop as both POSBIN and MATMBIN are empty for row " + (currentRow + 1));

					break; // Stop the loop if both values are empty

				}

				if (!POSBIN.isEmpty()) {

					if (POSBIN.matches("\\d+\\.0")) {

						POSBIN = POSBIN.substring(0, POSBIN.indexOf(".0"));

					}

					BL.clickElement(B.ActionOnOnusbutton);

					BL.clickElement(B.AddBin);

					BL.clickElement(B.ClickOnAddBin);

					BL.enterElement(B.ClickOnAddBin, POSBIN);

					performTabKeyPress();

					BL.clickElement(B.SubmitOnOnus);

					boolean POSBINStatus = true;

					try {

						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

					} catch (AssertionError e) {

						POSBINStatus = false;

						errorMessage = e.getMessage();

					}

					logTestStep(TestcaseNo, "POS BIN", POSBIN, POSBINStatus, errorMessage);

				}

				if (!MATMBIN.isEmpty()) {

					if (MATMBIN.matches("\\d+\\.0")) {

						MATMBIN = MATMBIN.substring(0, MATMBIN.indexOf(".0"));

					}

					BL.clickElement(B.ActionOnOnusbutton2);

					BL.clickElement(B.AddBin);

					BL.clickElement(B.ClickOnAddBin);

					BL.enterElement(B.ClickOnAddBin, MATMBIN);

					performTabKeyPress();

					BL.clickElement(B.SubmitOnOnus);

					boolean MATMBINSTATUS = true;

					try {

						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

					} catch (AssertionError e) {

						MATMBINSTATUS = false;

						errorMessage = e.getMessage();

					}

					logTestStep(TestcaseNo, "MATM BIN", MATMBIN, MATMBINSTATUS, errorMessage);

				}

			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroGlobalFRMParameters, "Global Frm");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "ONUS Routing", NextstepStatus, errorMessage);

		} catch (Exception e) {

			// Use the exception handler to log and handle exceptions gracefully

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "ONUS");

			throw e; // Re-throw the exception after handling

		}

	}

	// Method to fill Global Form

	private void fillGlobalForm(Map<String, String> testData, int TestcaseNo) throws InterruptedException {

		String VelocityCheckMinutes = testData.get("Velocity Check Minutes");

		String VelocityCheckCount = testData.get("Velocity Check Count");

		String CashPOSCount = testData.get("CashPOS Count");

		String MicroATMCount = testData.get("Micro ATM Count");

		String card = testData.get("International Card Acceptance");

		String ICADAILY = testData.get("ICA Daily");

		String ICAWEEKLY = testData.get("ICA Weekly");

		String ICAMonthly = testData.get("ICA Monthly");

		String POSDAILY = testData.get("POS Daily");

		String POSWEEKLY = testData.get("POS Weekly");

		String POSMonthly = testData.get("POS Monthly");

		String POSMinimum = testData.get("POS Minimum");

		String POSMaximum = testData.get("POS Maximum");

		String UPIDAILY = testData.get("UPI Daily");

		String UPIWEEKLY = testData.get("UPI Weekly");

		String UPIMonthly = testData.get("UPI Monthly");

		String UPIMinimum = testData.get("UPI Minimum");

		String UPIMaximum = testData.get("UPI Maximum");

		String AEPSDAILY = testData.get("AEPS Daily");

		String AEPSWEEKLY = testData.get("AEPS Weekly");

		String AEPSMonthly = testData.get("AEPS Monthly");

		String AEPSMinimum = testData.get("AEPS Minimum");

		String AEPSMaximum = testData.get("AEPS Maximum");

		String MATMDAILY = testData.get("MATM Daily");

		String MATMWEEKLY = testData.get("MATM Weekly");

		String MATMMonthly = testData.get("MATM Monthly");

		String MATMMinimum = testData.get("MATM Minimum");

		String MATMMaximum = testData.get("MATM Maximum");

		Thread.sleep(10000);

		int testcaseCount = 0;

		String errorMessage = "Invalid Format";

		try {

			BL.clickElement(B.GlobalFrm);
			
			Thread.sleep(1000);

			BL.clickElement(B.GlobalFRMCheckbox);

			if (VelocityCheckMinutes != null && !VelocityCheckMinutes.trim().isEmpty()) {

				// Perform the actions for the Velocity Check Minutes

				BL.clickElement(B.VelocityCheckMinute);

				BL.enterElement(B.VelocityCheckMinute, VelocityCheckMinutes);

				// Log the input data

				logInputData("Velocity Check Minutes", VelocityCheckMinutes);

				// Increment the test case count

				++testcaseCount;

				boolean Status1 = true; // Assume success initially

				try {

					// Check if there is an invalid format

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					// If an AssertionError occurs, set the status to false and capture the error

					// message

					Status1 = false;

					errorMessage = e.getMessage();

				}

				// Log the test step with the test case number, field, input value, status, and

				// error message (if any)

				logTestStep(TestcaseNo, "Velocity Check Minutes", VelocityCheckMinutes, Status1, errorMessage);

			}

			if (VelocityCheckCount != null && !VelocityCheckCount.trim().isEmpty()) {

//	if (VelocityCheckCount != null && VelocityCheckCount.matches("\\d+\\.0")) {

//	VelocityCheckCount = VelocityCheckCount.substring(0, VelocityCheckCount.indexOf(".0"));

				BL.clickElement(B.VelocityCheckCount);

				BL.enterElement(B.VelocityCheckCount, VelocityCheckCount);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Velocity Check Count", VelocityCheckCount, Status, errorMessage);

			}

			if (CashPOSCount != null && !CashPOSCount.trim().isEmpty()) {

				BL.clickElement(B.CashPOSCount);

				BL.enterElement(B.CashPOSCount, CashPOSCount);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "CashPOSCount", CashPOSCount, Status, errorMessage);

			}

			if (MicroATMCount != null && !MicroATMCount.trim().isEmpty()) {

				BL.clickElement(B.MicroATMCount);

				BL.enterElement(B.MicroATMCount, MicroATMCount);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "MicroATMCount", MicroATMCount, Status, errorMessage);

			}

			if (card != null && !card.trim().isEmpty()) {

				BL.clickElement(B.InternationalCardCount);

				;

				BL.selectDropdownOption(card);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "International Card Acceptance", card, Status, errorMessage);

			}

//ICA	

			if (ICADAILY != null && !ICADAILY.trim().isEmpty()) {

				BL.clickElement(B.ICADaily);

				BL.enterElement(B.ICADaily, ICADAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "ICA DAILY", ICADAILY, Status, errorMessage);

			}

			if (ICAWEEKLY != null && !ICAWEEKLY.trim().isEmpty()) {

				BL.clickElement(B.ICAWeekly);

				BL.enterElement(B.ICAWeekly, ICAWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "ICA WEEKLY", ICAWEEKLY, Status, errorMessage);

			}

			if (ICAMonthly != null && !ICAMonthly.trim().isEmpty()) {

				BL.clickElement(B.ICAMonthly);

				BL.enterElement(B.ICAMonthly, ICAMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "ICA Monthly", ICAMonthly, Status, errorMessage);

			}

//POS	

			if (POSDAILY != null && !POSDAILY.trim().isEmpty()) {

				BL.clickElement(B.POSDaily);

				BL.CLearElement(B.POSDaily);

				BL.enterElement(B.POSDaily, POSDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "POS DAILY", POSDAILY, Status, errorMessage);

			}

			if (POSWEEKLY != null && !POSWEEKLY.trim().isEmpty()) {

				BL.clickElement(B.POSWeekly);

				BL.CLearElement(B.POSWeekly);

				BL.enterElement(B.POSWeekly, POSWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "POS WEEKLY", POSWEEKLY, Status, errorMessage);

			}

			if (POSMonthly != null && !POSMonthly.trim().isEmpty()) {

				BL.clickElement(B.POSMonthly);

				BL.CLearElement(B.POSMonthly);

				BL.enterElement(B.POSMonthly, POSMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "POS Monthly", POSMonthly, Status, errorMessage);

			}

			if (POSMinimum != null && !POSMinimum.trim().isEmpty()) {

				BL.clickElement(B.POSMinimumAmount);

				BL.CLearElement(B.POSMinimumAmount);

				BL.enterElement(B.POSMinimumAmount, POSMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "POS Minimum", POSMinimum, Status, errorMessage);

			}

			if (POSMaximum != null && !POSMaximum.trim().isEmpty()) {

				BL.clickElement(B.POSMaximumAmount);

				BL.CLearElement(B.POSMaximumAmount);

				BL.enterElement(B.POSMaximumAmount, POSMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "POS Maximum", POSMaximum, Status, errorMessage);

			}

//UPI

			if (UPIDAILY != null && !UPIDAILY.trim().isEmpty()) {

				BL.clickElement(B.UPIDaily);

				BL.CLearElement(B.UPIDaily);

				BL.enterElement(B.UPIDaily, UPIDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "UPI DAILY", UPIDAILY, Status, errorMessage);

			}

			if (UPIWEEKLY != null && !UPIWEEKLY.trim().isEmpty()) {

				BL.clickElement(B.UPIWeekly);

				BL.CLearElement(B.UPIWeekly);

				BL.enterElement(B.UPIWeekly, UPIWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "UPI WEEKLY", UPIWEEKLY, Status, errorMessage);

			}

			if (UPIMonthly != null && !UPIMonthly.trim().isEmpty()) {

				BL.clickElement(B.UPIMonthly);

				BL.CLearElement(B.UPIMonthly);

				BL.enterElement(B.UPIMonthly, UPIMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "UPI Monthly", UPIMonthly, Status, errorMessage);

			}

			if (UPIMinimum != null && !UPIMinimum.trim().isEmpty()) {

				BL.clickElement(B.UPIMinimumAmount);

				BL.CLearElement(B.UPIMinimumAmount);

				BL.enterElement(B.UPIMinimumAmount, UPIMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "UPI Minimum", UPIMinimum, Status, errorMessage);

			}

			if (UPIMaximum != null && !UPIMaximum.trim().isEmpty()) {

				BL.clickElement(B.UPIMaximumAmount);

				BL.CLearElement(B.UPIMaximumAmount);

				BL.enterElement(B.UPIMaximumAmount, UPIMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "UPI Maximum", UPIMaximum, Status, errorMessage);

			}

//AEPS	

			if (AEPSDAILY != null && !AEPSDAILY.trim().isEmpty()) {

				BL.clickElement(B.AEPSDaily);

				BL.CLearElement(B.AEPSDaily);

				BL.enterElement(B.AEPSDaily, AEPSDAILY);

				logInputData("AEPS DAILY", AEPSDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "AEPS DAILY", AEPSDAILY, Status, errorMessage);

			}

			if (AEPSWEEKLY != null && !AEPSWEEKLY.trim().isEmpty()) {

				BL.clickElement(B.AEPSWeekly);

				BL.CLearElement(B.AEPSWeekly);

				BL.enterElement(B.AEPSWeekly, AEPSWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "AEPS WEEKLY", AEPSWEEKLY, Status, errorMessage);

			}

			if (AEPSMonthly != null && !AEPSMonthly.trim().isEmpty()) {

				BL.clickElement(B.AEPSMonthly);

				BL.CLearElement(B.AEPSMonthly);

				BL.enterElement(B.AEPSMonthly, AEPSMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "AEPS Monthly", AEPSMonthly, Status, errorMessage);

			}

			if (AEPSMinimum != null && !AEPSMinimum.trim().isEmpty()) {

				BL.clickElement(B.AEPSMinimumAmount);

				BL.CLearElement(B.AEPSMinimumAmount);

				BL.enterElement(B.AEPSMinimumAmount, AEPSMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "AEPS Minimum", AEPSMinimum, Status, errorMessage);

			}

			if (AEPSMaximum != null && !AEPSMaximum.trim().isEmpty()) {

				BL.clickElement(B.AEPSMaximumAmount);

				BL.CLearElement(B.AEPSMaximumAmount);

				BL.enterElement(B.AEPSMaximumAmount, AEPSMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "AEPS Maximum", AEPSMaximum, Status, errorMessage);

			}

//MATM

			if (MATMDAILY != null && !MATMDAILY.trim().isEmpty()) {

				BL.clickElement(B.MATMDaily);

				BL.CLearElement(B.MATMDaily);

				BL.enterElement(B.MATMDaily, MATMDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "MATM DAILY", MATMDAILY, Status, errorMessage);

			}

			if (MATMWEEKLY != null && !MATMWEEKLY.trim().isEmpty()) {

				BL.clickElement(B.MATMWeekly);

				BL.CLearElement(B.MATMWeekly);

				BL.enterElement(B.MATMWeekly, MATMWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "MATM WEEKLY", MATMWEEKLY, Status, errorMessage);

			}

			if (MATMMonthly != null && !MATMMonthly.trim().isEmpty()) {

				BL.clickElement(B.MATMMonthly);

				BL.CLearElement(B.MATMMonthly);

				BL.enterElement(B.MATMMonthly, MATMMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "MATM Monthly", MATMMonthly, Status, errorMessage);

			}

			if (MATMMinimum != null && !MATMMinimum.trim().isEmpty()) {

				BL.clickElement(B.MATMMinimumAmount);

				BL.CLearElement(B.MATMMinimumAmount);

				BL.enterElement(B.MATMMinimumAmount, MATMMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "MATM Minimum", MATMMinimum, Status, errorMessage);

			}

			if (MATMMaximum != null && !MATMMaximum.trim().isEmpty()) {

				BL.clickElement(B.MATMMaximumAmount);

				BL.CLearElement(B.MATMMaximumAmount);

				BL.enterElement(B.MATMMaximumAmount, MATMMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "MATM Maximum", MATMMaximum, Status, errorMessage);

			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroInterchangePlan, "NULL");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "Global FRM", NextstepStatus, errorMessage);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Commercial");

			throw e;

		}

	}

	// Method to configure Commercial

	private void configureCommercialInterChange(Map<String, String> testData, int TestcaseNo) throws Exception {

		try {

			int testcaseCount = 0;

			String errorMessagee = "The data does not match or is empty.";

			List<Map<String, String>> cachedData = cache.getCachedData("Commercial");
			// key for your data

			int numberOfRows = cachedData.size();

			System.out.println("Total rows found: " + numberOfRows);

			// Loop through all the rows

			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) { // Adjusted index to start from 0

				System.out.println("Running test for row number: " + (currentRow + 1));

				// Fetch the current row's data

				Map<String, String> testData1 = cachedData.get(currentRow);

				System.out.println("Test data: " + testData);

				// Extract data for each field

				String channel = testData1.getOrDefault("Interchange Channel", "").trim();

				String pricingPlan = testData1.getOrDefault("Interchange Pricing Plan", "").trim();

				// Prepare lists to log the key-value pairs

				ArrayList<String> key = new ArrayList<>();

				ArrayList<String> value = new ArrayList<>();

				// Process each field if valid

				processField(channel, "Interchange Channel", key, value, currentRow + 1, () -> {

					BL.clickElement(B.Commercial);
					
					try {
						Thread.sleep(1000);
						BL.clickElement(B.CommercialADD1); 
					} catch (InterruptedException e) {
				
					}

					BL.clickElement(B.CommercialChannel); // Click 'Add' button for the channel

					BL.selectDropdownOption(channel);

					String errorMessage = "The data does not match or is empty.";

					boolean Status = true;

					logTestStep(TestcaseNo, "Interchange Channel", channel, Status, errorMessage);

				});

				processField(pricingPlan, "Interchange Pricing Plan", key, value, currentRow + 1, () -> {

					BL.clickElement(B.PricingplanInterchange); // Click on the pricing plan dropdown

					BL.selectDropdownOption(pricingPlan); // Select pricing plan from dropdown

					String errorMessage = "The data does not match or is empty.";

					boolean Status = true;

					logTestStep(TestcaseNo, "Interchange Pricing Plan", pricingPlan, Status, errorMessage);

				});

				boolean SaveStatus = true;

				try {

					BL.clickElement(B.SaveButton);

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					SaveStatus = false;

					errorMessagee = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Save Button", "Commercial Interchange", SaveStatus, errorMessagee);

				// Log the inputs

				LoginInputData(key, value);

			}

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Commercial");

			throw e;

		}

	}

	private void processField(String fieldData, String fieldName, ArrayList<String> key, ArrayList<String> value,

			int currentRow, Runnable action) throws InterruptedException, AWTException {

		if (isValidInput1(fieldData)) {

			action.run(); // Perform the specific action for the field

			key.add(fieldName + "-" + currentRow);

			value.add(fieldData);

//	performTabKeyPress(); // Ensure to move to the next field

		} else {

			System.out.println(fieldName + " data is null or empty for row: " + currentRow);

		}

	}

	// Helper method to validate input

	private boolean isValidInput1(String input) {

		return input != null && !input.trim().isEmpty();

	}

	private void configureCommercialBankOnboarding(Map<String, String> testData, int TestcaseNo) throws Exception {

		try {

			int testcaseCount = 0;

			String errorMessagee = "The data does not match or is empty.";

			List<Map<String, String>> cachedData = cache.getCachedData("Commercial");

			int numberOfRows = cachedData.size();

			System.out.println("Total rows found: " + numberOfRows);

			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {

				System.out.println("Running test for row number: " + (currentRow + 1));

				Map<String, String> testData1 = cachedData.get(currentRow);

				System.out.println("Test data: " + testData);

				String channel = testData1.getOrDefault("Commercial Channel", "").trim();

				String pricingPlan = testData1.getOrDefault("Commercial Pricing Plan", "").trim();

				ArrayList<String> key = new ArrayList<>();

				ArrayList<String> value = new ArrayList<>();

				processField(channel, "Bank Onboarding Commercial Channel", key, value, currentRow + 1, () -> {

					BL.clickElement(B.Commercial);
					
					try {
						Thread.sleep(1000);
						BL.clickElement(B.CommercialADD2); 
					} catch (InterruptedException e) {
				
					}

					BL.clickElement(B.CommercialChannel);

					BL.selectDropdownOption(channel);

					boolean Status = true;

					String errorMessage = "The data does not match or is empty.";

					logTestStep(TestcaseNo, "Bank Onboarding Commercial Channel", channel, Status, errorMessage);

				});

				processField(pricingPlan, "Pricing Plan", key, value, currentRow + 1, () -> {

					BL.clickElement(B.PricingplanBankOnboarding);

					BL.selectDropdownOption(pricingPlan);

					String errorMessage = "The data does not match or is empty.";

					boolean Status = true;

					logTestStep(TestcaseNo, "Bank Onboarding Pricing Plan", pricingPlan, Status, errorMessage);

				});

				boolean SaveStatus = true;

				try {

					BL.clickElement(B.SaveButton);

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					SaveStatus = false;

					errorMessagee = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Save Button", "Commercial-BankOnboarding", SaveStatus, errorMessagee);

				// Log the inputs

				LoginInputData(key, value);

			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroBankDetails, "Settlement Info");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessagee = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "Commercial", NextstepStatus, errorMessagee);

		} catch (Exception e) {

			// Use the exception handler to log and handle exceptions gracefully

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Commercial");

			throw e; // Re-throw the exception after handling

		}

	}

	// Method to fill Settlement Info

	private void fillSettlementInfo(Map<String, String> testData, int TestcaseNo)

			throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "The data does not match or is empty.";

		String channel = testData.get("Settlement Channel");

		String Account = testData.get("Account Type");

		String IFSCCode = testData.get("IFSC Code");

		String BanKAccountNumber = testData.get("Bank Account Number");

		String type = testData.get("Settlement Type");

		try {

			BL.clickElement(B.SettlementInfo);

			BL.clickElement(B.AddButton);

			if (channel != null && !channel.trim().isEmpty()) {

				BL.clickElement(B.SettlementChannel);

				BL.selectDropdownOption(channel);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Settlement Channel", channel, Status, errorMessage);

			}

			if (Account != null && !Account.trim().isEmpty()) {

				BL.clickElement(B.SettlementAccountType);

				BL.selectDropdownOption(Account);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Settlement AccountType", Account, Status, errorMessage);

			}

			if (BanKAccountNumber != null && !BanKAccountNumber.trim().isEmpty()) {

				BL.clickElement(B.SettlementBankAccountNumber);

				BL.enterElement(B.SettlementBankAccountNumber, BanKAccountNumber);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "BanKAccountNumber", BanKAccountNumber, Status, errorMessage);

			}

			if (IFSCCode != null && !IFSCCode.trim().isEmpty()) {

				BL.clickElement(B.SettlementIFSCCode);

				BL.selectDropdownOption(IFSCCode);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "IFSC Code", IFSCCode, Status, errorMessage);

			}

			boolean SaveStatus = true;

			try {

				BL.clickElement(B.SaveButton);

				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

			} catch (AssertionError e) {

				SaveStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "Save Button", "Commercial", SaveStatus, errorMessage);

			// Log the inputs

			LoginInputData(key, value);

			if (type != null && !type.trim().isEmpty()) {

				BL.clickElement(B.SettlementType);

				BL.selectDropdownOption(type);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Settlement Type", type, Status, errorMessage);

			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroBankonboardingConfig, "Whitelabel");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "Settlement Info", NextstepStatus, errorMessage);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Settlement Info");

			throw e;

		}

	}

	// Method to configure White Label

	private void configureWhiteLabel(Map<String, String> testData, int TestcaseNo)

			throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "The data does not match or is empty.";

		String Bank = testData.get("Bank Own Deployment");

		String payfac = testData.get("Payfac Onboarding");

		String ISO = testData.get("ISO Onboarding");

		String Sales = testData.get("Sales Team Onboarding");

		String MaximumNoOfPlatform = testData.get("Maximum No of Platform");

		try {

			BL.clickElement(B.whitelabel);

			if (Bank != null && !Bank.trim().isEmpty()) {

				BL.clickElement(B.WhitelabelBankOwnDeployment);

				BL.selectDropdownOption(Bank);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Bank Own Deployment", Bank, Status, errorMessage);

			}

			if (payfac != null && !payfac.trim().isEmpty()) {

				BL.clickElement(B.WhitelabelPayfacOnboarding);

				BL.selectDropdownOption(payfac);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Whitelabel Payfac Onboarding", payfac, Status, errorMessage);

			}

			if (ISO != null && !ISO.trim().isEmpty()) {

				BL.clickElement(B.WhitelabelISOOnboarding);

				BL.selectDropdownOption(ISO);

				logInputData("Whitelabel ISO Onboarding", ISO);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Whitelabel ISO Onboarding", ISO, Status, errorMessage);

			}

			if (Sales != null && !Sales.trim().isEmpty()) {

				BL.clickElement(B.WhitelabelSalesTeamOnboarding);

				BL.selectDropdownOption(Sales);

				logInputData("Whitelabel Sales Team Onboarding", Sales);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Whitelabel Sales Team Onboarding", Sales, Status, errorMessage);

			}

			if (MaximumNoOfPlatform != null && !MaximumNoOfPlatform.trim().isEmpty()) {

				BL.clickElement(B.WhitelabelMaxNumberOfPlatform);

				BL.enterElement(B.WhitelabelMaxNumberOfPlatform, MaximumNoOfPlatform);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Maximum No Of Platform", MaximumNoOfPlatform, Status, errorMessage);

			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroPaymentBridge, "Webhooks");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "Whitelabel", NextstepStatus, errorMessage);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Whitelabel");

			throw e;

		}

	}

	// Method to configure Webhooks

	private void configureWebhooks(Map<String, String> testData, int TestcaseNo) throws InterruptedException {

		int testcaseCount = 0;

		String errorMessage = "The data does not match or is empty.";

		String type = testData.get("Webhook Type");

		String webhookURL = testData.get("Webhook url");

		try {

			BL.clickElement(B.webhooks);

			BL.clickElement(B.AddButton);

			if (type != null && !type.trim().isEmpty()) {

				BL.clickElement(B.WebhookType);

				BL.selectDropdownOption(type);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Webhook Type", type, Status, errorMessage);

			}

			if (webhookURL != null && !webhookURL.trim().isEmpty()) {

				BL.clickElement(B.WebhookTypeURL);

				BL.enterElement(B.WebhookTypeURL, webhookURL);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Webhook URL", webhookURL, Status, errorMessage);

			}

			boolean SaveStatus = true;

			try {

				BL.clickElement(B.SaveButton);

				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

			} catch (AssertionError e) {

				SaveStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "Save Button", "Webhooks", SaveStatus, errorMessage);

			// Log the inputs

			LoginInputData(key, value);

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroKycConfig, "KYC");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "Webhooks", NextstepStatus, errorMessage);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Webhooks");

			throw e;

		}

	}

	// Method to fill KYC Details

	private void fillKYCDetails(Map<String, String> testData, int TestcaseNo)

			throws InterruptedException, AWTException {

		String business = testData.get("Business Type");

		String Company = testData.get("Company Proof of Identity");

		String IndiPOI = testData.get("Individual Proof of Identity");

		String IndiPOA = testData.get("Individual Proof of address");

		String IndiBD = testData.get("Individual Bank Document");

		String IndiTD = testData.get("Individual Tax Document");

		String IndiOD = testData.get("Individual Other Document");

		int testcaseCount = 0;

		String errorMessage = "The data does not match or is empty.";

		try {

			BL.clickElement(B.AddButton);

			if (business != null && !business.trim().isEmpty()) {

				BL.clickElement(B.KYCBusinessType);

				BL.selectDropdownOption(business);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "KYC Business Type", business, Status, errorMessage);

			}

			if (Company != null && !Company.trim().isEmpty()) {

				BL.clickElement(B.proofofIdentityComapany);

				BL.selectDropdownOption(Company);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Proof Of Identity Company KYC", Company, Status, errorMessage);

			}

			if (IndiPOI != null && !IndiPOI.trim().isEmpty()) {

				BL.clickElement(B.KYCIndividualProofOfIdentity);

				BL.selectDropdownOption(IndiPOI);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Proof of identity Individual KYC", IndiPOI, Status, errorMessage);

			}

			if (IndiPOA != null && !IndiPOA.trim().isEmpty()) {

				BL.clickElement(B.KYCIndividualProofOFAddress);

				BL.selectDropdownOption(IndiPOA);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Proof of address Individual KYC", IndiPOA, Status, errorMessage);

			}

			if (IndiBD != null && !IndiBD.trim().isEmpty()) {

				BL.clickElement(B.KYCIndividualBankDocument);

				BL.selectDropdownOption(IndiBD);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Bank Document Individual KYC", IndiBD, Status, errorMessage);

			}

			if (IndiTD != null && !IndiTD.trim().isEmpty()) {

				BL.clickElement(B.KYCIndividualTaxDocument);

				BL.selectDropdownOption(IndiTD);

				performTabKeyPress();

				logInputData("TAX Document Individual KYC", IndiTD);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "TAX Document Individual KYC", IndiTD, Status, errorMessage);

			}

			if (IndiOD != null && !IndiOD.trim().isEmpty()) {

				BL.clickElement(B.KYCIndividualOtherDocument);

				BL.selectDropdownOption(IndiOD);

				performTabKeyPress();

				logInputData("Other Document Individual KYC", IndiOD);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {

					Status = false;

					errorMessage = e.getMessage(); // Capture error message

				}

				logTestStep(TestcaseNo, "Other Document Individual KYC", IndiOD, Status, errorMessage);

			}

			boolean SaveStatus = true;

			try {

				BL.clickElement(B.SaveButton);

				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

			} catch (AssertionError e) {

				SaveStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "Save Button", "KYC-BANK", SaveStatus, errorMessage);

			// Log the inputs

			LoginInputData(key, value);

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntrostatusHistory, "Status History");

			} catch (AssertionError e) {

				NextstepStatus = false;

				errorMessage = e.getMessage(); // Capture error message

			}

			logTestStep(TestcaseNo, "NextStep", "KYC-BANK", NextstepStatus, errorMessage);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "KYC-Bank");

			throw e;

		}

	}

	// Method to submit for verification

	private void submitForVerification() throws InterruptedException {

		BL.clickElement(B.SubmitforVerification);

		BL.clickElement(B.YesButton);

		BL.clickElement(B.OKButton);

	}

	// Utility methods

	private void performTabKeyPress() throws AWTException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_TAB);

	}

	private void logInputData(String fieldName, String fieldValue) {

		key.add(fieldName);

		value.add(fieldValue);

	}

	@Given("I visit the System Verifier Login in Regression using sheetname {string} and rownumber {int}")

	public void i_visit_the_System_verifier_login(String sheetName, int rowNumber)

			throws InvalidFormatException, IOException, InterruptedException {

		try {

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String userName = testdata.get(rowNumber).get("UserName");

			String password = testdata.get(rowNumber).get("Password");

			BL.enterElement(L.EnterOnUserName, userName);

			BL.enterElement(L.EnterOnPassword, password);

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

	@When("System Verifier - Onboarding should be displayed in the side menu")

	public void I_Visit_System_Verifier_Onboarding() throws InterruptedException {

		try {

			BL.clickElement(S.ClickOnDownArrow);

			BL.clickElement(S.ClickOnOnboarding);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@Then("the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Verifier_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		try {

			BL.isElementDisplayed(B.ClickOnBank, "Bank");

			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");

			BL.isElementDisplayed(B.ClickOnISO, "ISO");

			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");

			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");

			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");

			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@When("the System Verifier clicks the bank module")

	public void SystemVerifierClicktheBankModule() {

		try {

			BL.clickElement(B.ClickOnBank);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@Then("the System Verifier completes Bank Onboarding, the system should prompt to verify all steps using the sheet name {string}")

	public void processAllData1(String sheetName)

			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		// Load data from the cache only once

		List<Map<String, String>> testData = cache.getCachedData(sheetName);

		if (testData == null || testData.isEmpty()) {

			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);

		}

		int numberOfRows = testData.size(); // Number of rows based on cached data

		System.out.println("Total rows found: " + numberOfRows);

		TestCaseManager testCaseManager = new TestCaseManager();

		// Iterate over the cached data

		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {

			System.out.println("Running test for row number: " + rowNumber);

			// Group by row number in Allure

			testCaseManager.startNewTestSuite(rowNumber);

			// Get row data from cache

			Map<String, String> rowData = testData.get(rowNumber - 1);

			try {

				// Start the test case and log the input data for the row

				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);

				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));

				int rowTestCaseCount = runTestForRow1(sheetName, rowData, rowNumber);

				totalTestCaseCount += rowTestCaseCount;

				testCaseManager.endTestCase(true);

			} catch (Exception e) {

				takeScreenshot(rowNumber);

				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports

				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());

				testCaseManager.endTestCase(false);

			} finally {

				testCaseManager.endTestSuite(); // End the suite (grouping) for this row

			}

			if (rowNumber == numberOfRows) {

				System.out.println("Finished processing the last row. Logging out...");

				performLogout();

			}

		}

		logDashboardCount1();

	}

	private void logDashboardCount1() {

		String message = "Total Dashboard Count: " + totalTestCaseCount;

		ExtentCucumberAdapter.addTestStepLog(message);

		Allure.parameter("Total Test Case Count", totalTestCaseCount);

		System.out.println(message);

	}

	private int runTestForRow1(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row

		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)

		int testCaseCount = 0;

		// Validate fields for the current row using testData

		testCaseCount += validateFieldsForRow1(sheetName, testData, rowNumber, testCaseCount);

		return testCaseCount;

	}

	@SuppressWarnings("unused")

	private int validateFieldsForRow1(String sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)

			throws Exception {

		// Initialize the locators

		// Initialize a counter to track the number of validated fields/sections

		int validatedFieldsCount = 0;

		// Bank Details Section

		validatedFieldsCount += executeStep1(() -> {

			try {

				SearchbyBank(testData, TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "SearchbyBank");

		validatedFieldsCount += executeStep(() -> {

			try {

//	fillBankDetails(testData, TestcaseNo);

				GenernalInfoVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "General Info Verified");

		// Communication Details Section

		validatedFieldsCount += executeStep(() -> {

			try {

				CommunicationInfoVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Communication Info Verified");

		// Channel Config Section

		validatedFieldsCount += executeStep(() -> {

			try {

				ChannelConfigVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Channel Config verified");

		// ONUS Section

		validatedFieldsCount += executeStep(() -> {

			try {

				configureONUSVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "ONUS Configuration");

		// Global Form Section

		validatedFieldsCount += executeStep(() -> {

			try {

				GlobalFormVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Global Form");

		// Commercial Section

		validatedFieldsCount += executeStep(() -> {

			try {

				CommercialVerified(TestcaseNo);

			} catch (Exception e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Commercial Verfied");

		// Settlement Info Section

		validatedFieldsCount += executeStep(() -> {

			try {

				SettlementInfoVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Settlement Info Verified");

		// White Label Section

		validatedFieldsCount += executeStep(() -> {

			try {

				WhiteLabelVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "White Label Configuration Verified");

		// Webhooks Section

		validatedFieldsCount += executeStep(() -> {

			try {

				WebhooksVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Webhook Configuration");

		// KYC Section

		validatedFieldsCount += executeStep(() -> {

			try {

				KYCDetailsVerified(TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "KYC Details");

		// Final Submission

		validatedFieldsCount += executeStep(() -> {

			try {

				submitForApproval();

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "Final Submission - Verified");

		// Return the total count of validated fields/sections

		return validatedFieldsCount;

	}

	private int executeStep1(Runnable step, String stepName) {

		try {

			step.run();

			return 1; // Return 1 for successful execution

		} catch (Exception e) {

			// Handle the exception and log the error

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, stepName);

			return 0; // Return 0 for failed execution

		}

	}
	
	private void SearchbyBank(Map<String, String> testData, int TestcaseNo) throws InterruptedException, AWTException {

		String Bankname = testData.get("bankName");

		key.clear();

		value.clear();

		BL.clickElement(B.SearchbyBankName);

		BL.enterElement(B.SearchbyBankName, Bankname);

		Thread.sleep(2000);

		BL.clickElement(B.ActionClick);

		Thread.sleep(2000);

		BL.clickElement(B.ViewButton);

	}

	private void GenernalInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.GeneralInfo);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "General Info", verifiedStatus, errorMessage);

	}

	private void CommunicationInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.CommunicationInfo);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "Communication Info", verifiedStatus, errorMessage);

	}

	private void ChannelConfigVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.ChannelConfig);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "Channel Config", verifiedStatus, errorMessage);

	}

	private void configureONUSVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.ONUSRouting);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "ONUS Routing", verifiedStatus, errorMessage);

	}

	private void GlobalFormVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.GlobalFrm);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "Global FRM", verifiedStatus, errorMessage);

	}

	private void CommercialVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.Commercial);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "Commercial", verifiedStatus, errorMessage);

	}

	private void SettlementInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.SettlementInfo);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "Settlement Info", verifiedStatus, errorMessage);

	}

	private void WhiteLabelVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.whitelabel);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "Whitelabel", verifiedStatus, errorMessage);

	}

	private void WebhooksVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.webhooks);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "Webhooks", verifiedStatus, errorMessage);

	}

	private void KYCDetailsVerified(int TestcaseNo) throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		try {

			Thread.sleep(1000);

			BL.clickElement(B.VerifiedandNext);

		} catch (AssertionError e) {

			verifiedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Verified", "KYC", verifiedStatus, errorMessage);

	}

	private void submitForApproval() throws InterruptedException, AWTException {

		int testcaseCount = 0;

		String errorMessage = "Verified Button is not displayed.";

		boolean verifiedStatus = true;

		BL.clickElement(B.SubmitforApproval);

		BL.clickElement(B.YesButton);

		BL.clickElement(B.OKButton);

		BL.clickElement(B.ApproveCancel);

	}

	@Given("I visit the System Approver Login in Regression using sheetname {string} and rownumber {int}")

	public void i_visit_the_System_Approver_login(String sheetName, int rowNumber)

			throws InvalidFormatException, IOException, InterruptedException {

		try {

			// ExcelDataCache cache = ExcelDataCache.getInstance();

			List<Map<String, String>> testdata = cache.getCachedData(sheetName);

			System.out.println("sheet name: " + testdata);

			String userName = testdata.get(rowNumber).get("UserName");

			String password = testdata.get(rowNumber).get("Password");

			BL.enterElement(L.EnterOnUserName, userName);

			BL.enterElement(L.EnterOnPassword, password);

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

	@When("System Approver - Onboarding should be displayed in the side menu")

	public void I_Visit_System_Approver_Onboarding() throws InterruptedException {

		try {

			BL.clickElement(S.ClickOnDownArrow);

			BL.clickElement(S.ClickOnOnboarding);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@Then("the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")

	public void System_Approver_seessidemenu_itemsin_Onboarding() throws InterruptedException {

		try {

			BL.isElementDisplayed(B.ClickOnBank, "Bank");

			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");

			BL.isElementDisplayed(B.ClickOnISO, "ISO");

			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");

			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");

			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");

			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@When("the System Approver clicks the bank module")

	public void SystemApproverClicktheBankModule() {

		try {

			BL.clickElement(B.ClickOnBank);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@Then("the System Approver completes Bank Onboarding, the system should prompt to Approve using the sheet name {string}")

	public void processAllData2(String sheetName)

			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		// Load data from the cache only once

		List<Map<String, String>> testData = cache.getCachedData(sheetName);

		if (testData == null || testData.isEmpty()) {

			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);

		}

		int numberOfRows = testData.size(); // Number of rows based on cached data

		System.out.println("Total rows found: " + numberOfRows);

		TestCaseManager testCaseManager = new TestCaseManager();

		// Iterate over the cached data

		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {

			System.out.println("Running test for row number: " + rowNumber);

			// Group by row number in Allure

			testCaseManager.startNewTestSuite(rowNumber);

			// Get row data from cache

			Map<String, String> rowData = testData.get(rowNumber - 1);

			try {

				// Start the test case and log the input data for the row

				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);

				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));

				int rowTestCaseCount = runTestForRow2(sheetName, rowData, rowNumber);

				totalTestCaseCount += rowTestCaseCount;

				testCaseManager.endTestCase(true);

			} catch (Exception e) {

				takeScreenshot(rowNumber);

				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports

				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());

				testCaseManager.endTestCase(false);

			} finally {

				testCaseManager.endTestSuite(); // End the suite (grouping) for this row

			}

			if (rowNumber == numberOfRows) {

				System.out.println("Finished processing the last row. Logging out...");

				performLogout();

			}

		}

		logDashboardCount2();

	}

	private void logDashboardCount2() {

		String message = "Total Dashboard Count: " + totalTestCaseCount;

		ExtentCucumberAdapter.addTestStepLog(message);

		Allure.parameter("Total Test Case Count", totalTestCaseCount);

		System.out.println(message);

	}

	private int runTestForRow2(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row

		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)

		int testCaseCount = 0;

		// Validate fields for the current row using testData

		testCaseCount += validateFieldsForRow2(sheetName, testData, rowNumber, testCaseCount);

		return testCaseCount;

	}

	@SuppressWarnings("unused")

	private int validateFieldsForRow2(String sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)

			throws Exception {

		// Initialize the locators

		// Initialize a counter to track the number of validated fields/sections

		int validatedFieldsCount = 0;

		// Bank Details Section
		
		validatedFieldsCount += executeStep1(() -> {

			try {

				SearchbyBankApprove(testData, TestcaseNo);

			} catch (InterruptedException | AWTException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "SearchbyBankApprove");

		validatedFieldsCount += executeStep2(() -> {

			try {

				approveBankOnboarding(testData, TestcaseNo);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}, "approveBankOnboarding");

		// Return the total count of validated fields/sections

		return validatedFieldsCount;

	}

	private int executeStep2(Runnable step, String stepName) {

		try {

			step.run();

			return 1;

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, stepName);

			return 0; // Return 0 for failed execution

		}

	}
	

	private void SearchbyBankApprove(Map<String, String> testData, int TestcaseNo) throws InterruptedException, AWTException {

		String Bankname = testData.get("bankName");

		key.clear();

		value.clear();

		Thread.sleep(3000);

		BL.clickElement(B.SearchbyBankName);

		Thread.sleep(3000);

		BL.enterElement(B.SearchbyBankName, Bankname);

		Thread.sleep(3000);

		BL.clickElement(B.ActionClick);

		Thread.sleep(2000);

		BL.clickElement(B.ViewButton);

	}


	private void approveBankOnboarding(Map<String, String> testData, int TestcaseNo) throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		String Bankname = testData.get("bankName");

		key.clear();

		value.clear();

		int testcaseCount = 0;

		String errorMessage = "Approve Button is not visible.";

		boolean ApprovedStatus = true;

		try {

			BL.clickElement(B.Approve);

			BL.clickElement(B.YesButton);

			BL.clickElement(B.OKButton);

		} catch (AssertionError e) {

			ApprovedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Approved", "BANK", ApprovedStatus, errorMessage);

		BL.clickElement(B.ApproveCancel);

		Thread.sleep(3000);

		BL.clickElement(B.SearchbyBankName);

		Thread.sleep(3000);

		BL.enterElement(B.SearchbyBankName, Bankname);

		Thread.sleep(3000);

		BL.clickElement(B.ActionClick);

		Thread.sleep(2000);

		try {

			BL.clickElement(B.ViewButton);

		} catch (AssertionError e) {

			ApprovedStatus = false;

			errorMessage = e.getMessage(); // Capture error message

		}

		logTestStep(TestcaseNo, "Bank CPID", BL.getElementValue(B.CPID), ApprovedStatus, errorMessage);

		BL.clickElement(B.ApproveCancel);

	}

	private void takeScreenshotStr(String rowNumber) {

		try {

			// Take a screenshot

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Build the path for saving the screenshot

			String screenshotPath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" + rowNumber

					+ ".png";

			// Save the screenshot to the specified path

			FileUtils.copyFile(screenshot, new File(screenshotPath));

			// Initialize TestCaseManager (assuming it's handling test case logging)

			TestCaseManager testCaseManager = new TestCaseManager();

			testCaseManager.startNewTestCase("TEST CASE ERR", false);

			// Attach the screenshot to the Allure report

			Allure.addAttachment("Screenshot for Row " + rowNumber,

					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

			Allure.step("Test case for row " + rowNumber);

			// End the test case

			testCaseManager.endTestCase(false);

			// Attach the screenshot to the Extent report

			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

		} catch (IOException e) {

			// Log the exception and stack trace if an error occurs during screenshot

			// handling

			e.printStackTrace();

		}

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

	private void performLogout() throws InterruptedException {

		BL.clickElement(B.Profile);

		BL.clickElement(B.LogOut);

		BL.clickElement(B.YesButton);

	}

}