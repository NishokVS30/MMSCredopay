package org.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.Locators.AggregatorLocators;
import org.Locators.BankLocators;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class SystemUserMutipleAggregatorRegression {

	private WebDriver driver;

	org.Locators.LoginLocators L;
	org.Locators.BankLocators B;
	org.Locators.AggregatorLocators A;
	org.Locators.SystemUserLocatores S;

	ExtentTest test;
	ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();

	public SystemUserMutipleAggregatorRegression() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
//		 this.driver = driver;
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}

	int totalTestCaseCount = 0;

	@Then("the System Maker Aggregator Onboarding should prompt users to enter valid inputs using the sheet name {string}")
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
		B = new org.Locators.BankLocators(driver);

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

	@SuppressWarnings("unused")
	private int validateFieldsForRow(String sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)
			throws Exception {

		// Initialize the locators
		B = new org.Locators.BankLocators(driver);

		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;

//		validatedFieldsCount += executeStep(() -> fillLoginDetails(testData, TestcaseNo), "Login Details");
//		validatedFieldsCount += executeStep(
//				() -> SystemMakerOnboardingshouldbedisplayedinthesidemenu(testData, TestcaseNo), "Onboarding Display");
//		validatedFieldsCount += executeStep(() -> SystemMakershouldseeallSideMenu(testData, TestcaseNo),
//				"Side Menu Visibility");
//		validatedFieldsCount += executeStep(() -> SystemMakerclicksthebankmodule(testData, TestcaseNo),
//				"Bank Module Click");

		// Sales Details Section

		validatedFieldsCount += executeStep(() -> {
			try {
				fillSalesInfo(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Sales Info");

		// Company Details Section
		String LegalName = null;
		validatedFieldsCount += executeStep(() -> {
			try {

				String generatedLegalName = fillCompanyInfo(testData, TestcaseNo);
				testData.put("LegalName", generatedLegalName);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Company Info");

		// Personal Details Section

		validatedFieldsCount += executeStep(() -> {
			try {
				fillPersonalInfo(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Personal Info");

		// Communication Details Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillCommunicationDetailsAdminUserDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Communication Details");

		validatedFieldsCount += executeStep(() -> {
			try {
				fillCommunicationDetailsSettlementReconContactDetails(testData, TestcaseNo);
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

		// KYC Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillKYCDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "KYC Details");

		// Risk Info Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillRiskInfo(testData, TestcaseNo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Risk Info");

		// Commercial Section
		validatedFieldsCount += executeStep(() -> {
			try {
				FillDiscountRate(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Aggregator Discount Rate");

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

	private void fillSalesInfo(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {
			A = new org.Locators.AggregatorLocators(driver);
			B = new org.Locators.BankLocators(driver);

			Faker faker = new Faker();

			int testcaseCount = 0;
			String errorMessage = "The data does not match or is empty.";

			String VAS1 = testData.get("VAS Commission");
			String aggregatorCode = null;
			String Marsid = testData.get("Marsid");
			String VAS2 = testData.get("EKYC Required");

			if (VAS1 != null && !VAS1.trim().isEmpty()) {
				B.ClickOnCreatebutton();
				A.ClickOnSalesInfo();
				A.ClickOnVASCommisiionOne();
				B.selectDropdownOption(VAS1);

				++testcaseCount;

				boolean VASStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					VASStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "VAS Commission", VAS1, VASStatus, errorMessage);

			}

			boolean DateStatus = true; // Assume success initially
			try {
				A.ClickOnAggreratorApplictionDate();
				A.ClickOnApply();

				B.NOTDisplayedOnInvalidFormat();
			} catch (AssertionError e) {
				DateStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Aggrerator Appliction Date", "Current Date", DateStatus, errorMessage);

			try {
				A.ClickOnAggrementnDate();
				A.ClickOnApply();

				B.NOTDisplayedOnInvalidFormat();
			} catch (AssertionError e) {
				DateStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Agreement Date", "Current Date", DateStatus, errorMessage);

			if (aggregatorCode == null || aggregatorCode.trim().isEmpty()
					|| !aggregatorCode.matches("^[a-zA-Z0-9]{6}$")) {
				aggregatorCode = generateValidAggregatorCode(faker, testData);
			}

			if (aggregatorCode != null && !aggregatorCode.trim().isEmpty()) {
				A.ClickOnAggregatorCOde();
				A.EnterOnAggregatorCOde(aggregatorCode);
//				logInputData("Aggregator Code", aggregatorCode);
				++testcaseCount;

				boolean AggregatorStatus = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					AggregatorStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Aggregator Code", aggregatorCode, AggregatorStatus, errorMessage);
			}

			if (Marsid.contains("E")) {
				Double Marsid1 = Double.valueOf(Marsid);
				Marsid = String.format("%.0f", Marsid1);
			}

			if (Marsid != null && !Marsid.trim().isEmpty()) {
				A.ClickOnMarsid();
				A.EnterOnMarsid(Marsid);
//				logInputData("Marsid", Marsid);
				++testcaseCount;

				boolean MarsidStatus = true;

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					MarsidStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Marsid :", Marsid, MarsidStatus, errorMessage);

			}

			if (VAS2 != null && !VAS2.trim().isEmpty()) {

				A.ClickOnEKYCRequired();

				B.selectDropdownOption(VAS2);

				++testcaseCount;

				boolean VASStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					VASStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "EKYC Required", VAS2, VASStatus, errorMessage);

			}

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroCompanyInfo();
			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "NextStep", "Sales Info", NextstepStatus, errorMessage);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e; // Re-throw the exception after handling
		}

	}

	private String fillCompanyInfo(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			Faker faker = new Faker();

//			String LegalName = null;
			String LegalName = testData.get("LegalName");
			String brand = testData.get("Brand Name");
			String Address = testData.get("Registered Address");
			String pincode = testData.get("Registered Pincode");
			String type = testData.get("Business Type");
			String registeredNumber = testData.get("Registered Number");
			String pan = generateValidPAN(faker);
			String GstIN = testData.get("GSTIN");
			String frequency = testData.get("Statement Frequency");
			String Type = testData.get("Statement Type");
			String domain = testData.get("Email Domain");

			String errorMessage = "The data does not match or is empty.";
			int testcaseCount = 0;

			TestCaseManager testCaseManager = new TestCaseManager();

			if (LegalName == null || LegalName.trim().isEmpty()) {
				LegalName = generateValidLegalName(faker, testData);
			}

			if (LegalName != null && !LegalName.trim().isEmpty()) {

				A.ClickOnCompanyInfo();
				A.ClickOnLegalName();
				A.EnterOnLegalName(LegalName);

				++testcaseCount;

				boolean legalNameStatus = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					legalNameStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Legal Name", LegalName, legalNameStatus, errorMessage);

			}

			if (brand != null && !brand.trim().isEmpty()) {

				A.ClickOnBrandName();

				A.EnterOnBrandName(brand);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Brand Name", brand, Status, errorMessage);

			}

			if (Address != null && !Address.trim().isEmpty()) {

				A.ClickOnRegisteredAddress();

				A.EnterOnRegisteredAddress(Address);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Registered Address", Address, Status, errorMessage);

			}

			if (pincode != null && !pincode.trim().isEmpty()) {

				A.ClickOnRegisteredPincode();

				B.selectDropdownOption(pincode);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Registered Pincode", pincode, Status, errorMessage);

			}

			if (type != null && !type.trim().isEmpty()) {

				A.ClickOnBusinessType();

				B.selectDropdownOption(type);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Business Type", type, Status, errorMessage);

			}

			boolean DateStatus = true;
			try {
				A.ClickOnEstablishedYearDatepicker();

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ENTER);

				r.keyRelease(KeyEvent.VK_ENTER);

				A.ClickOnApply();

				B.NOTDisplayedOnInvalidFormat();
			} catch (AssertionError e) {
				DateStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Established Year", "Current Date", DateStatus, errorMessage);

//
//     		if (registeredNumber.contains("E")) {
//				Double numberInScientificNotation = Double.valueOf(registeredNumber);
//				registeredNumber = String.format("%.0f", numberInScientificNotation);

			if (registeredNumber != null && !registeredNumber.trim().isEmpty()) {

				A.CLickOnRegisterNumber();
				A.EnterOnRegisterNumber(registeredNumber);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Registered Number", registeredNumber, Status, errorMessage);

			}

			if (pan != null && !pan.trim().isEmpty()) {

				A.CLickOnCompanyPAN();

				A.EnterOnCompanyPAN(pan);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Company PAN", pan, Status, errorMessage);

			}

			if (GstIN != null && !GstIN.trim().isEmpty()) {

				A.CLickOnGSTIN();

				A.EnterOnGSTIN(GstIN);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "GstIN", GstIN, Status, errorMessage);

			}

			if (frequency != null && !frequency.trim().isEmpty()) {

				A.CLickOnStatementFrequency();

				B.selectDropdownOption(frequency);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Statement Frequency", frequency, Status, errorMessage);

			}

			if (Type != null && !Type.trim().isEmpty()) {

				A.CLickOnStatementType();

				B.selectDropdownOption(Type);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Statement Type", Type, Status, errorMessage);

			}

			if (domain != null && !domain.trim().isEmpty()) {

				A.CLickOnEmailDomain();

				A.EnterOnEmailDomain(domain);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Domain", domain, Status, errorMessage);

			}

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroPersonalInfo();
			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "NextStep", "Company Info", NextstepStatus, errorMessage);

			return LegalName;

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e; // Re-throw the exception after handling
		}

	}

	private void fillPersonalInfo(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			int testcaseCount = 0;
			String errorMessage = "The data does not match or is empty.";

			Faker faker = new Faker();

			String title = testData.get("Title");
			String FirstName = testData.get("First Name");
			String LastName = testData.get("Last Name");
			String pan = generateValidPAN(faker);
			String Address = testData.get("Address");
			String pincode = testData.get("Personal Pincode");
			String PMobilenumber = testData.get("Personal Mobile Number");
			String telephone = testData.get("TelePhone Number");
			String emailid = testData.get("Email");
			String Nationality = testData.get("Nationality");
			String aadhaar = generateValidAadhaar();
			String Passport = testData.get("Passport");

			if (title != null && !title.trim().isEmpty()) {

				A.ClickOnPersonalInfo();

				A.PersonalINfoADD();

				A.ClickOntitlepersonal();

				B.selectDropdownOption(title);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Title", title, Status, errorMessage);

			}

			if (FirstName != null && !FirstName.trim().isEmpty()) {

				A.ClickOnFirstNamePersonal();

				A.EnterOnFirstNamePersonal(FirstName);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "FirstName", FirstName, Status, errorMessage);

			}

			if (LastName != null && !LastName.trim().isEmpty()) {

				A.ClickOnLastNamePersonal();

				A.EnterOnLastNamePersonal(LastName);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "LastName", LastName, Status, errorMessage);

			}

			boolean DateStatus = true; // Assume success initially

			try {
				A.ClickOnOpenCalenderPersonal();

				A.ClickOnChooseMonthandYearPersonal();

				A.ClickOnYearPersonal();

				A.ClickOnMonthPersonal();

				A.ClickOnDatePersonal();

				A.ClickOnApplyPersonal();

				B.NOTDisplayedOnInvalidFormat();
			} catch (AssertionError e) {
				DateStatus = false; // Set status to false if assertion fails
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Date Of Birth", "30/11/1998", DateStatus, errorMessage);

			if (pan != null && !pan.trim().isEmpty()) {

				A.ClickOnPANPersonal();

				A.EnterOnPanPersonal(pan);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Pan", pan, Status, errorMessage);

			}

			if (Address != null && !Address.trim().isEmpty()) {

				A.ClickOnAddressPersonal();

				A.EnterOnAddressPersonal(Address);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Address", Address, Status, errorMessage);

			}

			if (pincode != null && !pincode.trim().isEmpty()) {

				A.ClickOnPincodePersonal();

				B.selectDropdownOption(pincode);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Pincode", pincode, Status, errorMessage);

			}

			if (PMobilenumber != null && !PMobilenumber.trim().isEmpty()) {

				// Generate a valid mobile number starting with 9, 8, 7, or 6
				String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9
				String remainingDigits = faker.number().digits(9); // Generate 9 random digits
				String Mobilenumber = firstDigit + remainingDigits;

				A.ClickOnMobileNumberPersonal();

				A.EnterOnMobileNumberPersonal(Mobilenumber);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Mobilenumber", Mobilenumber, Status, errorMessage);

			}

			if (telephone != null && !telephone.trim().isEmpty()) {

				A.ClickOnTelephonePersonal();
				A.EnterOnTelephonePersonal(telephone);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Telephone Number", telephone, Status, errorMessage);

			}

			if (emailid != null && !emailid.trim().isEmpty()) {

				A.ClickOnEmailPersonal();

				A.EnterOnemailPersonal(emailid);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Emailid", emailid, Status, errorMessage);

			}

			if (Nationality != null && !Nationality.trim().isEmpty()) {

				A.ClickOnNationalityPersonal();

				A.EnterOnNationalitypersonal(Nationality);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Nationality", Nationality, Status, errorMessage);

			}

			if (aadhaar != null && !aadhaar.trim().isEmpty()) {

				A.ClickOnAadhaarNumberPersonal();

				A.EnterOnAadhaarNumberPersonal(aadhaar);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Aadhaar", aadhaar, Status, errorMessage);

			}

			if (Passport != null && !Passport.trim().isEmpty()) {

				A.ClickOnPassportNumberPersonal();

				A.EnterOnPassportNumberPersonal(Passport);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "Passport", Passport, Status, errorMessage);

			}

			try {

				A.ClickOnOpenCalenderPasswordExpiry();

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ENTER);

				r.keyRelease(KeyEvent.VK_ENTER);

				A.ClickOnApplyPersonal();

				performTabKeyPress();

				B.NOTDisplayedOnInvalidFormat();
			} catch (AssertionError e) {
				DateStatus = false; // Set status to false if assertion fails
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Date", "Passport ExpiryDate", DateStatus, errorMessage);

			boolean SaveStatus = true;
			try {

				A.ClickOnSAVEPersonal();

				B.OkforSuccessfully();

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Save Button", "Personal Info", SaveStatus, errorMessage);

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroCommunicationInfo();
			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "NextStep", "Personal Info", NextstepStatus, errorMessage);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e; // Re-throw the exception after handling
		}

	}

	private void fillCommunicationDetailsAdminUserDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			int testcaseCount = 0;
			String errorMessage = "The data does not match or is empty.";

			String CommName = testData.get("Communication Name");
			String CommPosition = testData.get("Communication Position");
			String CommMobileNumber = testData.get("Communication MobileNumber");
			String CommEmailid = testData.get("Communication EmailId");
			String ADUSer = testData.get("AD User");

			B.CLickOnCommunicationInfo();

			B.CommADD();

			if (CommName != null && !CommName.trim().isEmpty()) {

				B.ClickOnCommName();
				B.EnterOnCommName(CommName);

				++testcaseCount;

				boolean CommunicationNameStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					CommunicationNameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Admin user details Communication Name", CommName, CommunicationNameStatus,
						errorMessage);

			}

			if (CommPosition != null && !CommPosition.trim().isEmpty()) {
				B.ClickOnCommPosition();
				B.EnterOnCommunicationPosition(CommPosition);

				++testcaseCount;

				boolean CommunicationPositionStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					CommunicationPositionStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Admin user details Communication Position", CommPosition,
						CommunicationPositionStatus, errorMessage);

			}

			if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {
				Faker faker = new Faker();

				// Generate a valid mobile number starting with 9, 8, 7, or 6
				String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9
				String remainingDigits = faker.number().digits(9); // Generate 9 random digits
				String communicationMobileNumber = firstDigit + remainingDigits;

				B.ClickonCommMobileNumber();
				B.EnteronCommMobileNumber(communicationMobileNumber);

				++testcaseCount;

				boolean CommunicationMobileNumberStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					CommunicationMobileNumberStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Admin user details Communication MobileNumber", communicationMobileNumber,
						CommunicationMobileNumberStatus, errorMessage);

			}

			if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {

				Faker faker = new Faker();

				// Generate a random email address with @gmail.com
				String randomEmailPrefix = faker.internet().slug(); // Generate a random string for the prefix
				String Communicationemailid = randomEmailPrefix + "@gmail.com";
				B.ClickonCommEmailid();
				B.EnteronCommEmailid(Communicationemailid);

				++testcaseCount;

				boolean CommunicationEmailIDStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();

				} catch (AssertionError e) {
					CommunicationEmailIDStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Admin user details Communication Emailid", Communicationemailid,
						CommunicationEmailIDStatus, errorMessage);

			}

			if (ADUSer != null && !ADUSer.trim().isEmpty()) {
				B.ClickOnAdUser();
				B.selectDropdownOption(ADUSer);

				++testcaseCount;

				boolean CommunicationADUSERStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();

				} catch (AssertionError e) {
					CommunicationADUSERStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Admin user details AD User", ADUSer, CommunicationADUSERStatus,
						errorMessage);

			}

			boolean SaveStatus = true;
			try {
				B.CommuSavebutton();

				B.NOTDisplayedOnInvalidFormat();

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Admin user details Save Button", "Communication Info", SaveStatus, errorMessage);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e; // Re-throw the exception after handling
		}
	}

	private void fillCommunicationDetailsSettlementReconContactDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);

			int testcaseCount = 0;
			String errorMessage = "The data does not match or is empty.";

			String CommName = testData.get("Communication Name");
			String CommPosition = testData.get("Communication Position");
			String CommMobileNumber = testData.get("Communication MobileNumber");
			String CommEmailid = testData.get("Communication EmailId");

			B.CLickOnCommunicationInfo();

			B.CommSettlementandReconADD();

			if (CommName != null && !CommName.trim().isEmpty()) {

				B.ClickOnCommName();
				B.EnterOnCommName(CommName);

				++testcaseCount;

				boolean CommunicationNameStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					CommunicationNameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "SettlementReconContactDetails Communication Name", CommName,
						CommunicationNameStatus, errorMessage);

			}

			if (CommPosition != null && !CommPosition.trim().isEmpty()) {
				B.ClickOnCommPosition();
				B.EnterOnCommunicationPosition(CommPosition);

				++testcaseCount;

				boolean CommunicationPositionStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					CommunicationPositionStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "SettlementReconContactDetails Communication Position", CommPosition,
						CommunicationPositionStatus, errorMessage);

			}

			if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {
				Faker faker = new Faker();

				// Generate a valid mobile number starting with 9, 8, 7, or 6
				String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9
				String remainingDigits = faker.number().digits(9); // Generate 9 random digits
				String communicationMobileNumber = firstDigit + remainingDigits;

				B.ClickonCommMobileNumber();
				B.EnteronCommMobileNumber(communicationMobileNumber);

				++testcaseCount;

				boolean CommunicationMobileNumberStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					CommunicationMobileNumberStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "SettlementReconContactDetails Communication MobileNumber",
						communicationMobileNumber, CommunicationMobileNumberStatus, errorMessage);

			}

			if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {

				Faker faker = new Faker();

				// Generate a random email address with @gmail.com
				String randomEmailPrefix = faker.internet().slug(); // Generate a random string for the prefix
				String Communicationemailid = randomEmailPrefix + "@gmail.com";
				B.ClickonCommEmailid();
				B.EnteronCommEmailid(Communicationemailid);

				++testcaseCount;

				boolean CommunicationEmailIDStatus = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();

				} catch (AssertionError e) {
					CommunicationEmailIDStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "SettlementReconContactDetails Communication Emailid", Communicationemailid,
						CommunicationEmailIDStatus, errorMessage);

			}

			boolean SaveStatus = true;
			try {
				B.CommuSavebutton();

				B.NOTDisplayedOnInvalidFormat();

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "SettlementReconContactDetails Save Button", "Communication Info", SaveStatus,
					errorMessage);

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroChannelConfig();

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

	private void fillChannelConfig(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException, IOException {

		int testcaseCount = 0;
		String errorMessage = "The data does not match or is empty.";

		try {
			// Initialize BankLocators and AggregatorLocators only once
			if (B == null) {
				B = new org.Locators.BankLocators(driver);
			}
			if (A == null) {
				A = new org.Locators.AggregatorLocators(driver);
			}

			// Load cached data for "Channel Bank" sheet
			List<Map<String, String>> cachedData = cache.getCachedData("Channel Aggregator");
			int numberOfRows = cachedData.size();
			System.out.println("Total rows found: " + numberOfRows);

			for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
				System.out.println("Running test for row number: " + currentRow);

				ArrayList<String> key = new ArrayList<>();
				ArrayList<String> value = new ArrayList<>();

				// Fetch the current row's data
				Map<String, String> rowData = cachedData.get(currentRow - 1);

				// Retrieve data for each field, handling null or empty values
				String channelbank = rowData.getOrDefault("Channel Bank Name", "").trim();
				String channel = rowData.getOrDefault("Channel", "").trim();
				String network = rowData.getOrDefault("Network", "").trim();
				String transactionSet = rowData.getOrDefault("Transaction Sets", "").trim();
				String routing = rowData.getOrDefault("Routing", "").trim();

				// Clear the key-value arrays before each iteration
				key.clear();
				value.clear();

				// Process Channel Bank Name
				if (!channelbank.isEmpty()) {
					A.ClickOnChannelConfig();
					driver.navigate().refresh();
					B.ChannelADD();
					A.ClickOnChannelBankName();
					A.EnterOnChannelBankName(channelbank);
					B.selectDropdownOption(channelbank);

					key.add("Channel Bank Name-" + currentRow);
					value.add(channelbank);

					boolean channelBankStatus = true;
					B.NOTDisplayedOnInvalidFormat();

					testcaseCount++;
					logTestStep(TestcaseNo, "Channel BANK", channelbank, channelBankStatus, errorMessage);

				} else {
					System.out.println("ChannelBank data is empty for row: " + currentRow);
				}

				// Process Channel
				if (!channel.isEmpty()) {
					B.ClickonCommercialChannel();
					B.selectDropdownOption(channel);

					key.add("Channel-" + currentRow);
					value.add(channel);

					performTabKeyPress();

					boolean channelStatus = true;
					B.NOTDisplayedOnInvalidFormat();

					testcaseCount++;
					logTestStep(TestcaseNo, "Channel", channel, channelStatus, errorMessage);

				} else {
					System.out.println("Channel data is empty for row: " + currentRow);
				}

				// Process Network
				if (!network.isEmpty()) {
					B.clickonNetwork();
					B.selectDropdownOption(network);

					key.add("Network-" + currentRow);
					value.add(network);

					performTabKeyPress();

					boolean networkStatus = true;
					B.NOTDisplayedOnInvalidFormat();

					testcaseCount++;
					logTestStep(TestcaseNo, "Network", network, networkStatus, errorMessage);

				} else {
					System.out.println("Network data is empty for row: " + currentRow);
				}

				// Process Transaction Set
				if (!transactionSet.isEmpty()) {
					B.clickonTransactionset();
					B.selectDropdownOption(transactionSet);

					key.add("Transaction Set-" + currentRow);
					value.add(transactionSet);

					performTabKeyPress();

					boolean transactionSetStatus = true;
					B.NOTDisplayedOnInvalidFormat();

					testcaseCount++;
					logTestStep(TestcaseNo, "TransactionSet", transactionSet, transactionSetStatus, errorMessage);

				} else {
					System.out.println("Transaction Set data is empty for row: " + currentRow);
				}

				// Process Save Button
				boolean saveStatus = true;
				try {
					B.CommuSavebutton();
					B.NOTDisplayedOnInvalidFormat();

				} catch (AssertionError e) {
					saveStatus = false;
					errorMessage = e.getMessage();
				}

				logTestStep(TestcaseNo, "Save Button", "Channel Config", saveStatus, errorMessage);
			}

			// Process Next Step
			boolean nextStepStatus = true;
			try {
				B.ClickOnNextStep();
				A.DisplayedOnIntroKYC();

			} catch (AssertionError e) {
				nextStepStatus = false;
				errorMessage = e.getMessage();
			}

			logTestStep(TestcaseNo, "NextStep", "Channel Config", nextStepStatus, errorMessage);

		} catch (Exception e) {
			// Handle and log exceptions
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config-Aggregator");
			throw e;
		}
	}

	private void fillKYCDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		try {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			int testcaseCount = 0;
			String errorMessage = "The data does not match or is empty.";

			String poAImage = testData.get("Company Proof of address");

			if (poAImage != null && !poAImage.trim().isEmpty()) {

				A.ClickOnKYC();
				A.UploadCompanyProofofaddress(poAImage);
				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "KYC Details", poAImage, Status, errorMessage);

			}

			B.ClickOnNextStep();

			boolean nextStepStatus = true;
			try {

				Thread.sleep(1000);

				B.ClickOnNextStep();

				A.DisplayedOnIntroRiskInfo();

			} catch (AssertionError e) {
				nextStepStatus = false;
				errorMessage = e.getMessage();
			}

			logTestStep(TestcaseNo, "NextStep", "KYC-Aggregator", nextStepStatus, errorMessage);

		} catch (Exception e) {
			// Handle and log exceptions
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC-Aggregator");
			throw e;
		}
	}

	private void fillRiskInfo(Map<String, String> testData, int TestcaseNo) throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		String VelocityCheckMinutes = testData.get("Velocity Check Minutes");

		String VelocityCheckCount = testData.get("Velocity Check Count");

		String CashPOSCount = testData.get("CashPOS Count");

		String MicroATMCount = testData.get("Micro Atm Count");

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

			A.ClickOnRiskInfo();

			B.checkboxGlobalfrm();

			if (VelocityCheckMinutes != null && !VelocityCheckMinutes.trim().isEmpty()) {

				// Perform the actions for the Velocity Check Minutes
				A.ClickOnVelocityCheckMinute();
				A.EnterOnVelocityCheckMinute(VelocityCheckMinutes);
				++testcaseCount;

				boolean Status1 = true; // Assume success initially
				try {
					// Check if there is an invalid format
					B.NOTDisplayedOnInvalidFormat();
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
//		if (VelocityCheckCount != null && VelocityCheckCount.matches("\\d+\\.0")) {
//			VelocityCheckCount = VelocityCheckCount.substring(0, VelocityCheckCount.indexOf(".0"));
				A.ClickOnVelocityCheckCount();

				A.EnterOnVelocityCheckCount(VelocityCheckCount);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Velocity Check Count", VelocityCheckCount, Status, errorMessage);

			}

			if (CashPOSCount != null && !CashPOSCount.trim().isEmpty()) {
				A.ClickOnCashpOScount();

				A.EnterOnCashpOScount(CashPOSCount);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "CashPOSCount", CashPOSCount, Status, errorMessage);

			}

			if (MicroATMCount != null && !MicroATMCount.trim().isEmpty()) {
				A.ClickOnMicroAtmcount();

				A.EnterOnMicroAtmcount(MicroATMCount);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MicroATMCount", MicroATMCount, Status, errorMessage);

			}

			if (card != null && !card.trim().isEmpty()) {
				A.ClickOnInternationalcardCount();

				B.selectDropdownOption(card);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "International Card Acceptance", card, Status, errorMessage);

			}

//ICA		

			if (ICADAILY != null && !ICADAILY.trim().isEmpty()) {
				A.ClickonICAdaily();

				A.EnteronICAdaily(ICADAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "ICA DAILY", ICADAILY, Status, errorMessage);

			}

			if (ICAWEEKLY != null && !ICAWEEKLY.trim().isEmpty()) {
				A.ClickonICAWeekly();

				A.EnteronICAWeekly(ICAWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "ICA WEEKLY", ICAWEEKLY, Status, errorMessage);

			}

			if (ICAMonthly != null && !ICAMonthly.trim().isEmpty()) {
				A.ClickonICAMonthly();

				A.EnteronICAMonthly(ICAMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "ICA Monthly", ICAMonthly, Status, errorMessage);

			}

//POS	

			if (POSDAILY != null && !POSDAILY.trim().isEmpty()) {
				B.ClickonPosdaily();

				B.ClearonPosdaily();

				B.EnteronPosdaily(POSDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "POS DAILY", POSDAILY, Status, errorMessage);

			}

			if (POSWEEKLY != null && !POSWEEKLY.trim().isEmpty()) {
				B.ClickonPosWeekly();

				B.ClearonPosWeekly();

				B.EnteronPosWeekly(POSWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "POS WEEKLY", POSWEEKLY, Status, errorMessage);

			}

			if (POSMonthly != null && !POSMonthly.trim().isEmpty()) {
				B.ClickonPosMonthly();

				B.ClearonPosMonthly();

				B.EnteronPosMonthly(POSMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "POS Monthly", POSMonthly, Status, errorMessage);

			}

			if (POSMinimum != null && !POSMinimum.trim().isEmpty()) {
				B.ClickonPOSMinimum();

				B.ClearonPOSMinimum();

				B.EnteronPOSMinimum(POSMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "POS Minimum", POSMinimum, Status, errorMessage);

			}

			if (POSMaximum != null && !POSMaximum.trim().isEmpty()) {
				B.ClickonPOSMaximum();

				B.ClearonPOSMaximum();

				B.EnteronPOSMaximum(POSMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "POS Maximum", POSMaximum, Status, errorMessage);

			}

//UPI

			if (UPIDAILY != null && !UPIDAILY.trim().isEmpty()) {
				B.ClickonUPIdaily();

				B.ClearonUPIdaily();

				B.EnteronUPIdaily(UPIDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "UPI DAILY", UPIDAILY, Status, errorMessage);

			}

			if (UPIWEEKLY != null && !UPIWEEKLY.trim().isEmpty()) {
				B.ClickonUPIWeekly();

				B.ClearonUPIWeekly();

				B.EnteronUPIWeekly(UPIWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "UPI WEEKLY", UPIWEEKLY, Status, errorMessage);

			}

			if (UPIMonthly != null && !UPIMonthly.trim().isEmpty()) {
				B.ClickonUPIMonthly();

				B.ClearonUPIMonthly();

				B.EnteronUPIMonthly(UPIMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "UPI Monthly", UPIMonthly, Status, errorMessage);

			}

			if (UPIMinimum != null && !UPIMinimum.trim().isEmpty()) {
				B.ClickonUPIMinimum();

				B.ClearonUPIMinimum();

				B.EnteronUPIMinimum(UPIMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "UPI Minimum", UPIMinimum, Status, errorMessage);

			}

			if (UPIMaximum != null && !UPIMaximum.trim().isEmpty()) {

				B.ClickonUPIMaximum();

				B.ClearonUPIMaximum();

				B.EnteronUPIMaximum(UPIMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "UPI Maximum", UPIMaximum, Status, errorMessage);

			}

//AEPS		

			if (AEPSDAILY != null && !AEPSDAILY.trim().isEmpty()) {
				B.ClickonAEPSdaily();

				B.ClearonAEPSdaily();

				B.EnteronAEPSdaily(AEPSDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "AEPS DAILY", AEPSDAILY, Status, errorMessage);

			}

			if (AEPSWEEKLY != null && !AEPSWEEKLY.trim().isEmpty()) {
				B.ClickonAEPSWeekly();

				B.ClearonAEPSWeekly();

				B.EnteronAEPSWeekly(AEPSWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "AEPS WEEKLY", AEPSWEEKLY, Status, errorMessage);

			}

			if (AEPSMonthly != null && !AEPSMonthly.trim().isEmpty()) {
				B.ClickonAEPSMonthly();

				B.ClearonAEPSMonthly();

				B.EnteronAEPSMonthly(AEPSMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "AEPS Monthly", AEPSMonthly, Status, errorMessage);

			}

			if (AEPSMinimum != null && !AEPSMinimum.trim().isEmpty()) {
				B.ClickonAEPSMinimum();

				B.ClearonAEPSMinimum();

				B.EnteronAEPSMinimum(AEPSMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "AEPS Minimum", AEPSMinimum, Status, errorMessage);

			}

			if (AEPSMaximum != null && !AEPSMaximum.trim().isEmpty()) {

				B.ClickonAEPSMaximum();

				B.ClearonAEPSMaximum();

				B.EnteronAEPSMaximum(AEPSMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "AEPS Maximum", AEPSMaximum, Status, errorMessage);

			}

//MATM

			if (MATMDAILY != null && !MATMDAILY.trim().isEmpty()) {
				B.ClickonMATMdaily();

				B.ClearonMATMdaily();

				B.EnteronMATMdaily(MATMDAILY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MATM DAILY", MATMDAILY, Status, errorMessage);

			}

			if (MATMWEEKLY != null && !MATMWEEKLY.trim().isEmpty()) {
				B.ClickonMATMWeekly();

				B.ClearonMATMWeekly();

				B.EnteronMATMWeekly(MATMWEEKLY);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MATM WEEKLY", MATMWEEKLY, Status, errorMessage);

			}

			if (MATMMonthly != null && !MATMMonthly.trim().isEmpty()) {
				B.ClickonMATMMonthly();

				B.ClearonMATMMonthly();

				B.EnteronMATMMonthly(MATMMonthly);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MATM Monthly", MATMMonthly, Status, errorMessage);

			}

			if (MATMMinimum != null && !MATMMinimum.trim().isEmpty()) {
				B.ClickonMATMMinimum();

				B.ClearonMATMMinimum();

				B.EnteronMATMMinimum(MATMMinimum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MATM Minimum", MATMMinimum, Status, errorMessage);

			}

			if (MATMMaximum != null && !MATMMaximum.trim().isEmpty()) {

				B.ClickonMATMMaximum();

				B.ClearonMATMMaximum();

				B.EnteronMATMMaximum(MATMMaximum);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MATM Maximum", MATMMaximum, Status, errorMessage);

			}

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroDiscountRate();

			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "NextStep", "Risk Info", NextstepStatus, errorMessage);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	private void FillDiscountRate(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException, IOException {

		int testcaseCount = 0;
		String errorMessage = "The data does not match or is empty.";

		try {
			// Initialize BankLocators and AggregatorLocators only once
			if (B == null) {
				B = new org.Locators.BankLocators(driver);
			}
			if (A == null) {
				A = new org.Locators.AggregatorLocators(driver);
			}

			// Load cached data for "Channel Bank" sheet
			List<Map<String, String>> cachedData = cache.getCachedData("Discount Rate Aggregator");
			int numberOfRows = cachedData.size();
			System.out.println("Total rows found: " + numberOfRows);

			for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
				System.out.println("Running test for row number: " + currentRow);

				ArrayList<String> key = new ArrayList<>();
				ArrayList<String> value = new ArrayList<>();

				// Fetch the current row's data
				Map<String, String> rowData = cachedData.get(currentRow - 1);

				// Retrieve data for each field, handling null or empty values
				String channel = rowData.getOrDefault("Channel", "").trim();
				String pricingPlan = rowData.getOrDefault("Pricing plan", "").trim();

				// Clear the key-value arrays before each iteration
				key.clear();
				value.clear();

				// Process Channel Bank Name

				// Process Channel
				if (!channel.isEmpty()) {
					A.ClickOnDiscountRate();
					Thread.sleep(1000);
					B.ChannelADD();

					Thread.sleep(1000);
					B.clickonChannel();
					B.selectDropdownOption(channel);

					key.add("Channel-" + currentRow);
					value.add(channel);

					performTabKeyPress();

					boolean channelStatus = true;
					B.NOTDisplayedOnInvalidFormat();

					testcaseCount++;
					logTestStep(TestcaseNo, "DiscountRate : Channel", channel, channelStatus, errorMessage);

				} else {
					System.out.println("Channel data is empty for row: " + currentRow);
				}

				// Process Network
				if (!pricingPlan.isEmpty()) {
					Thread.sleep(1000);
					A.ClickOnDiscountRatePricingPlan();
					B.selectDropdownOption(pricingPlan);

					performTabKeyPress();

					boolean networkStatus = true;
					B.NOTDisplayedOnInvalidFormat();

					testcaseCount++;
					logTestStep(TestcaseNo, "Pricing Plan", pricingPlan, networkStatus, errorMessage);

				} else {
					System.out.println("Network data is empty for row: " + currentRow);
				}

				// Process Save Button
				boolean saveStatus = true;
				try {
					A.ClickOnSAVEPersonal();
					B.NOTDisplayedOnInvalidFormat();

				} catch (AssertionError e) {
					saveStatus = false;
					errorMessage = e.getMessage();
				}

				logTestStep(TestcaseNo, "Save Button", "Aggregator Discount Rate", saveStatus, errorMessage);
			}

			// Process Next Step
			boolean nextStepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroSettlement();

			} catch (AssertionError e) {
				nextStepStatus = false;
				errorMessage = e.getMessage();
			}

			logTestStep(TestcaseNo, "NextStep", "Aggregator Discount Rate", nextStepStatus, errorMessage);

		} catch (Exception e) {
			// Handle and log exceptions
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config-Aggregator");
			throw e;
		}
	}

	private void fillSettlementInfo(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		int testcaseCount = 0;
		String errorMessage = "The data does not match or is empty.";

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		String channel = testData.get("Settlement Channel");
		String Account = testData.get("Account Type");
		String IFSCCode = testData.get("IFSC Code");

		String BanKAccountNumber = testData.get("Bank Account Number");
		String Mode = testData.get("Settlement Mode");
		String payment = testData.get("Payment Flag");

		try {

			B.clickOnSettlementInfo();

			B.ClickOnSettlementInfoADD();

			if (channel != null && !channel.trim().isEmpty()) {

				B.ClickOnSettlementChannel();

				B.selectDropdownOption(channel);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Settlement Channel", channel, Status, errorMessage);

			}

			if (Account != null && !Account.trim().isEmpty()) {
				B.ClickOnSettlementAccountType();

				B.selectDropdownOption(Account);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Settlement AccountType", Account, Status, errorMessage);

			}

			if (BanKAccountNumber != null && !BanKAccountNumber.trim().isEmpty()) {
				B.ClickOnBankAccountNumber();
				B.EnterOnBankAccountNumber(BanKAccountNumber);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "BanKAccountNumber", BanKAccountNumber, Status, errorMessage);

			}

			if (IFSCCode != null && !IFSCCode.trim().isEmpty()) {

				B.ClickOnIFSCCode();

				B.selectDropdownOption(IFSCCode);

				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "IFSC Code", IFSCCode, Status, errorMessage);

			}

			boolean SaveStatus = true;
			try {
				B.ClickOnCommercialSave();

				B.NOTDisplayedOnInvalidFormat();

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Save Button", "Commercial", SaveStatus, errorMessage);

			if (Mode != null && !Mode.trim().isEmpty()) {

				A.ClickOnSettlementMode();

				B.selectDropdownOption(Mode);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Settlement Mode", Mode, Status, errorMessage);

			}

			if (payment != null && !payment.trim().isEmpty()) {

				A.ClickOnPaymentFlag();

				B.selectDropdownOption(payment);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Payment Flag", payment, Status, errorMessage);

			}

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroWhiteLabel();

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

		B = new org.Locators.BankLocators(driver);

		String ISO = testData.get("ISO Onboarding");
		String Sales = testData.get("Sales Team Onboarding");
		String merchant = testData.get("Allow to create merchant onboard");
		String MaximumNoOfPlatform = testData.get("Maximum No of Platform");
		String usernameAs = testData.get("UsernamAs");

		try {

			B.clickOnWhiteLabel();

			if (ISO != null && !ISO.trim().isEmpty()) {
				B.ClickOnWhitelabelISOOnboarding();

				B.selectDropdownOption(ISO);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Whitelabel ISO Onboarding", ISO, Status, errorMessage);
			}

			if (Sales != null && !Sales.trim().isEmpty()) {
				B.ClickOnWhitelabelSalesTeamOnboarding();

				B.selectDropdownOption(Sales);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Whitelabel Sales Team Onboarding", Sales, Status, errorMessage);
			}

			if (merchant != null && !merchant.trim().isEmpty()) {
				A.ClickOnAllowCreateMerchantOnboard();

				B.selectDropdownOption(merchant);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Allow to create merchant onboard", merchant, Status, errorMessage);
			}

			if (MaximumNoOfPlatform != null && !MaximumNoOfPlatform.trim().isEmpty()) {
				B.ClickOnMaximumNoofPlatform();
				B.EnterOnMaximumNoofPlatform(MaximumNoOfPlatform);
				performTabKeyPress();

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Maximum No Of Platform", MaximumNoOfPlatform, Status, errorMessage);
			}

			if (usernameAs != null && !usernameAs.trim().isEmpty()) {
				A.ClickOnUserNameAs();

				B.selectDropdownOption(usernameAs);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "UsernameAs", usernameAs, Status, errorMessage);
			}

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				A.DisplayedOnIntroWebhook();

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

		B = new org.Locators.BankLocators(driver);

		String type = testData.get("Webhook Type");
		String webhookURL = testData.get("Webhook url");

		try {

			B.clickOnWebhooks();

			B.ClickOnWebhookADD();

			if (type != null && !type.trim().isEmpty()) {
				B.ClickOnWebhooksType();

				B.selectDropdownOption(type);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Webhook Type", type, Status, errorMessage);
			}

			if (webhookURL != null && !webhookURL.trim().isEmpty()) {
				B.ClickOnWebhooksURL();
				B.EnterOnWebhooksURL(webhookURL);

				++testcaseCount;

				boolean Status = true; // Assume success initially
				try {

					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "Webhook URL", webhookURL, Status, errorMessage);
			}

			boolean SaveStatus = true;
			try {
				B.ClickOnCommercialSave();

				B.NOTDisplayedOnInvalidFormat();

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Save Button", "Webhooks", SaveStatus, errorMessage);

			boolean NextstepStatus = true;
			try {
				B.ClickOnNextStep();

				B.DisplayedOnstatusHistory();

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

	private void submitForVerification() throws InterruptedException {

		B.ClickOnsubmitforverification();

		B.Yesforsubmit();

		B.OkforSuccessfully();
	}

	@Then("the System Verifier completes Aggregator Onboarding, the system should prompt to verify all steps using the sheet name {string}")
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
		B = new org.Locators.BankLocators(driver);

		int testCaseCount = 0;

		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow1(sheetName, testData, rowNumber, testCaseCount);

		return testCaseCount;

	}

	@SuppressWarnings("unused")
	private int validateFieldsForRow1(String sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)
			throws Exception {

		// Initialize the locators
		B = new org.Locators.BankLocators(driver);

		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;
		// Bank Details Section
		validatedFieldsCount += executeStep1(() -> {
			try {
				Searchbyname(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "SearchbyBank");

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

	private void Searchbyname(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		String LegalName = testData.get("LegalName");

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		key.clear();
		value.clear();

		try {

			String errorMessage = "The data does not match or is empty.";

			boolean Status = true;
			try {
				Thread.sleep(3000);

				B.ClickSearchbyBankName();

				Thread.sleep(3000);

				B.SearchbyBankName(LegalName);

			} catch (AssertionError e) {
				Status = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Search by name", LegalName, Status, errorMessage);

			Thread.sleep(3000);

			B.ActionClick();

			Thread.sleep(2000);

			B.ClickonViewButton();

			int testcaseCount = 0;

			boolean verifiedStatus = true;
			try {
				
				Thread.sleep(1000);

				A.DisplayedonSalesInfo();

				A.ClickOnSalesInfo();

				A.ClickOnManualTakeOver();

				B.Yesforsubmit();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Sales Info", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedOnCompanyInfo();

				A.ClickOnCompanyInfo();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Company Info", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedOnPersonalInfo();

				A.ClickOnPersonalInfo();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Personal Info", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedOnCommunicationInfo();

				A.ClickOnCommunicationInfo();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Communication Info", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedonChannelConfig();

				A.ClickOnChannelConfig();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Channel Config", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedOnKYC();
				
				A.ClickOnKYC();

				A.ClickOnKYC();

				A.ClickOnViewDocument1();

				A.ClickonActionDiscountRate();

				A.ViewDocumentVerified();

				A.ViewDocumentSubmitandNext();

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ESCAPE);

				r.keyRelease(KeyEvent.VK_ESCAPE);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "KYC-Aggregator", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedOnRiskInfo();

				A.ClickOnRiskInfo();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Risk Info", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedOnDiscountRate();

				A.ClickOnDiscountRate();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Discount Rate", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedOnSettlementInfo();

				A.ClickOnSettlementInfo();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Settlement Info", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedonWhitelabel();

				A.ClickOnWhitelabel();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Whitelabel", verifiedStatus, errorMessage);

			try {
				
				Thread.sleep(1000);

				A.DisplayedonWebhooks();
				A.ClickOnWebhooks();

				B.VerifiedandNext();

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "Verified", "Webhooks", verifiedStatus, errorMessage);

			B.SubmitforApproval();

			B.Yesforsubmit();

			B.OkforSuccessfully();

			B.CancelApprove();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Verified");
			throw e;
		}

	}

	@Then("the System Approver completes Aggregator Onboarding, the system should prompt to Approve using the sheet name {string}")
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
		B = new org.Locators.BankLocators(driver);

		int testCaseCount = 0;

		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow2(sheetName, testData, rowNumber, testCaseCount);

		return testCaseCount;

	}

	@SuppressWarnings("unused")
	private int validateFieldsForRow2(String sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)
			throws Exception {

		// Initialize the locators
		B = new org.Locators.BankLocators(driver);

		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;
		// Bank Details Section
		validatedFieldsCount += executeStep2(() -> {
			try {
				approveOnboarding(testData, TestcaseNo);
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
			return 1; // Return 1 for successful execution
		} catch (Exception e) {
			// Handle the exception and log the error
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, stepName);
			return 0; // Return 0 for failed execution
		}
	}

	private void approveOnboarding(Map<String, String> testData, int TestcaseNo) throws InterruptedException {

		String LegalName = testData.get("LegalName");

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		key.clear();
		value.clear();

		String errorMessag = "The data does not match or is empty.";

		boolean Status = true;
		try {
			Thread.sleep(3000);

			B.ClickSearchbyBankName();

			Thread.sleep(3000);

			B.SearchbyBankName(LegalName);

		} catch (AssertionError e) {
			Status = false;
			errorMessag = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Search by name", LegalName, Status, errorMessag);
		Thread.sleep(2000);

		B.ActionClick();

		Thread.sleep(1000);

		B.ClickonViewButton();

		int testcaseCount = 0;
		String errorMessage = "Approve Button is not visible.";

		boolean ApprovedStatus = true;

		try {

			B.ClickOnApprove();

			B.Yesforsubmit();

			B.OkforSuccessfully();

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Approved", "Aggregator", ApprovedStatus, errorMessage);

//		B.ClickOnApprove();
//
//		B.Yesforsubmit();
//
//		B.OkforSuccessfully();

		B.CancelApprove();

		Thread.sleep(3000);

		B.ClickSearchbyBankName();

		Thread.sleep(3000);

		B.SearchbyBankName(LegalName);

		Thread.sleep(3000);

		B.ActionClick();

		try {

			B.ClickonViewButton();

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Aggregator CPID", B.getCPID(), ApprovedStatus, errorMessage);

//		B.ClickonViewButton();
//
//		logInputData("Bank CPID", B.getCPID());

		B.CancelApprove();

	}

	// Set to track previously generated Aadhaar numbers to ensure uniqueness
	private Set<String> existingAadhaarNumbers = new HashSet<>();

	private String generateValidAadhaar() {
		Faker faker = new Faker();
		String aadhaarNumber;

		// Continuously generate Aadhaar numbers until a unique and valid one is found
		do {
			StringBuilder aadhaarBuilder = new StringBuilder();

			// Ensure the first digit is NOT 0 or 1
			aadhaarBuilder.append(faker.number().numberBetween(2, 10)); // First digit: 2 to 9

			// Generate the next 10 digits randomly (digits between 0 and 9)
			for (int i = 1; i < 11; i++) {
				aadhaarBuilder.append(faker.number().numberBetween(0, 10)); // Digits between 0 and 9
			}

			// Generate the 12th digit (check digit) using the Verhoeff algorithm
			int checkDigit = calculateVerhoeffCheckDigit(aadhaarBuilder.toString());
			aadhaarBuilder.append(checkDigit);

			// Final generated Aadhaar number
			aadhaarNumber = aadhaarBuilder.toString();

			// Check if the generated Aadhaar number is unique
		} while (existingAadhaarNumbers.contains(aadhaarNumber));

		// Add the newly generated Aadhaar number to the set to track it
		existingAadhaarNumbers.add(aadhaarNumber);

		return aadhaarNumber;
	}

	// Verhoeff algorithm for check digit calculation (same as before)
	private static final int[][] verhoeffMultiplicationTable = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
			{ 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 }, { 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 }, { 3, 4, 0, 1, 2, 8, 9, 5, 6, 7 },
			{ 4, 0, 1, 2, 3, 9, 5, 6, 7, 8 }, { 5, 9, 8, 7, 6, 0, 4, 3, 2, 1 }, { 6, 5, 9, 8, 7, 1, 0, 4, 3, 2 },
			{ 7, 6, 5, 9, 8, 2, 1, 0, 4, 3 }, { 8, 7, 6, 5, 9, 3, 2, 1, 0, 4 }, { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 } };

	private static final int[][] verhoeffPermutationTable = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
			{ 1, 5, 7, 6, 2, 8, 3, 0, 9, 4 }, { 5, 8, 0, 3, 7, 9, 6, 1, 4, 2 }, { 8, 9, 1, 6, 0, 4, 3, 5, 2, 7 },
			{ 9, 4, 5, 3, 1, 2, 6, 8, 7, 0 }, { 4, 2, 8, 6, 5, 7, 3, 9, 0, 1 }, { 2, 7, 9, 3, 8, 0, 6, 4, 1, 5 },
			{ 7, 0, 4, 6, 9, 1, 3, 2, 5, 8 } };

	private static final int[] verhoeffInverseTable = { 0, 4, 3, 2, 1, 5, 6, 7, 8, 9 };

	// Calculate Verhoeff check digit for the given number (11 digits for Aadhaar)
	private int calculateVerhoeffCheckDigit(String number) {
		int checkSum = 0;
		int[] digits = number.chars().map(c -> c - '0').toArray();

		for (int i = digits.length - 1, j = 0; i >= 0; i--, j++) {
			checkSum = verhoeffMultiplicationTable[checkSum][verhoeffPermutationTable[j % 8][digits[i]]];
		}

		return verhoeffInverseTable[checkSum];
	}

	private String generateValidLegalName(Faker faker, Map<String, String> testData) {
		String legalName;
		Set<String> existingLegalNames = new HashSet<>();

		// Extract the "LegalName" from testData if it exists and add it to the set
		if (testData.get("LegalName") != null) {
			existingLegalNames.add(testData.get("LegalName"));
		}

		while (true) {
			// Generate a unique legal name (7 to 10 alphanumeric characters)
			legalName = faker.regexify("[A-Za-z0-9]{7,10}");

			// Ensure the generated legal name is unique
			if (!existingLegalNames.contains(legalName)) {
				return legalName; // Return the valid unique legal name
			}
		}
	}

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

	private void logTestStep(int testcaseCount, String fieldName, String fieldValue, Boolean status,
			String errorMessage) {
		String message = "AO Test Case " + testcaseCount + ": " + fieldName + " with value '" + fieldValue + "' "
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

	private String generateValidAggregatorCode(Faker faker, Map<String, String> testData) {
		String aggregatorCode;
		Set<String> existingAggregatorCodes = new HashSet<>(Collections.singletonList(testData.get("Aggregator Code")));

		while (true) {
			// Generate a 6-character alphanumeric Aggregator Code
			aggregatorCode = faker.regexify("[A-Za-z0-9]{6}");

			// Ensure the code is unique and matches the required format
			if (!existingAggregatorCodes.contains(aggregatorCode) && aggregatorCode.matches("^[a-zA-Z0-9]{6}$")) {
				return aggregatorCode; // Return valid, unique Aggregator Code
			}
		}
	}

	private void performTabKeyPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	private void performLogout() throws InterruptedException {

		B.LogoutProfile();

		B.Logoutbutton();

		B.LogoutYESbutton();

	}

}