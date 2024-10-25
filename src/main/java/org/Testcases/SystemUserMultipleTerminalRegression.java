package org.Testcases;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class SystemUserMultipleTerminalRegression {

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

	public SystemUserMultipleTerminalRegression() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
//			 this.driver = driver;
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
	
	@When("the System Maker clicks the Terminal module")
	public void SystemMakerClicktheSUBISOModule() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			BL.clickElement(S.ClickOnTerminal);

//			S.ClickOnTerminal();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SUB ISO");
			throw e;
		}

	}
	
	int totalTestCaseCount = 0;

	@Then("the System Maker Terminal Onboarding should prompt users to enter valid inputs using the sheet name {string}")
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
		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;

		// Terminal Info Section

		validatedFieldsCount += executeStep(() -> {
			try {
				
				String generatedterminalName = fillTerminalInfo(testData, TestcaseNo);
				testData.put("TerminalName", generatedterminalName);
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Terminal Info");
		
		validatedFieldsCount += executeStep(() -> {
			try {

				TransactionSet(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Transaction Set");


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

	
	private String fillTerminalInfo(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {
			
			Faker faker = new Faker();

			String Merchant = testData.get("Merchant Name");
			String TerminalName = null;
			String TerminalType = testData.get("Terminal Type");
			String UPITerminalType = testData.get("UPI Terminal Type");
			String UPIOffliceType = testData.get("UPI Offline Type");
			String DeviceModel = testData.get("Device Model");
			
			String DeviceNumber = generateDeviceNumber(faker);
			String ActiveDeviceNumber = testData.get("Active Device Number");
			String IMEINumber = testData.get("IMEI Number");
			String DeviceType = testData.get("Device Type");
			String Devicecommercial = testData.get("Device commercial");
			String TIDFeeApplicable = testData.get("TID Fee Applicable");
			String DevicePrice = testData.get("Device Price");
			String InstallationFee = testData.get("Installation Fee");
			String errorMessage = "The data does not match or is empty.";

			int testcaseCount = 0;

			if (Merchant != null && !Merchant.trim().isEmpty()) {

				BL.clickElement(B.Createbutton);

				BL.clickElement(T.Merchant); // T.clickElement(T.Merchant);

//				BL.enterElement(T.Merchant, Merchant);

//				T.enterElement(T.Merchant, Merchant);

				BL.selectDropdownOption(Merchant);

//				B.selectDropdownOption(Merchant);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//					B.NOTDisplayedOnInvalidFormat();
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				  logTestStep(TestcaseNo, "Merchant Name", Merchant , Status, errorMessage);

			}
			
			if (TerminalName == null || TerminalName.trim().isEmpty()) {
				TerminalName = generateValidterminalname(faker, testData);
			}

			if (TerminalName != null && !TerminalName.trim().isEmpty()) {

				BL.clickElement(T.TerminalName);
				BL.enterElement(T.TerminalName, TerminalName);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				 logTestStep(TestcaseNo, "Terminal Name", TerminalName , Status, errorMessage);

			}
			if (TerminalType != null && !TerminalType.trim().isEmpty()) {

				BL.clickElement(T.Terminaltype);
				BL.selectDropdownOption(TerminalType);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Terminal Type", TerminalType , Status, errorMessage);


			}
			if (UPITerminalType != null && !UPITerminalType.trim().isEmpty()) {

				BL.clickElement(M.UPITerminalType);

				BL.selectDropdownOption(UPITerminalType);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "UPI Terminal Type", UPITerminalType , Status, errorMessage);

			}

			if (UPIOffliceType != null && !UPIOffliceType.trim().isEmpty()) {

				BL.clickElement(M.UPIofflineType);

				BL.selectDropdownOption(UPIOffliceType);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "UPI Offline Type", UPIOffliceType , Status, errorMessage);

			}

			if (DeviceModel != null && !DeviceModel.trim().isEmpty()) {

				BL.clickElement(T.DeviceModel);

				BL.enterElement(T.DeviceModel, DeviceModel);

				BL.selectDropdownOption(DeviceModel);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Model", DeviceModel , Status, errorMessage);

			}
			if (DeviceNumber != null && !DeviceNumber.trim().isEmpty()) {

				BL.clickElement(T.DeviceNumber);

				BL.enterElement(T.DeviceNumber, DeviceNumber);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Number", DeviceNumber , Status, errorMessage);

			}

			if (ActiveDeviceNumber != null && !ActiveDeviceNumber.trim().isEmpty()) {

				BL.clickElement(T.ActiveDeviceNumber);

				BL.enterElement(T.ActiveDeviceNumber, ActiveDeviceNumber);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Active Device Number", ActiveDeviceNumber , Status, errorMessage);
			}

			if (IMEINumber != null && !IMEINumber.trim().isEmpty()) {

				BL.clickElement(T.IMEINumber);

				BL.enterElement(T.IMEINumber, IMEINumber);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "IMEI Number", IMEINumber , Status, errorMessage);
				
			}

			if (DeviceType != null && !DeviceType.trim().isEmpty()) {

				BL.clickElement(M.DeviceType);

				BL.selectDropdownOption(DeviceType);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Type", DeviceType , Status, errorMessage);
			}

			if (Devicecommercial != null && !Devicecommercial.trim().isEmpty()) {

				BL.clickElement(T.DeviceCommericialmode);

				BL.selectDropdownOption(Devicecommercial);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device commercial", Devicecommercial , Status, errorMessage);
			}

			if (TIDFeeApplicable != null && !TIDFeeApplicable.trim().isEmpty()) {

				BL.clickElement(T.TIDFeeApplicable);

				BL.selectDropdownOption(TIDFeeApplicable);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "TID Fee Applicable", TIDFeeApplicable , Status, errorMessage);
			}

			if (DevicePrice != null && !DevicePrice.trim().isEmpty()) {

				BL.clickElement(T.Deviceprice);

				BL.enterElement(T.Deviceprice, DevicePrice);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Price", DevicePrice , Status, errorMessage);
			}

			if (InstallationFee != null && !InstallationFee.trim().isEmpty()) {

				BL.clickElement(T.InstallationFee);

				BL.enterElement(T.InstallationFee, InstallationFee);

				++testcaseCount;

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Installation Fee", InstallationFee , Status, errorMessage);
			}

			boolean NextstepStatus = true;
			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(T.DisplayTransctionSet, "Transaction Set Page");

			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			return TerminalName;
			
		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Terminal Info");
			throw e; // Re-throw the exception after handling
		}
		

	}
	
	
	private void TransactionSet(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {
			
			String errorMessage = "The data does not match or is empty.";
			
			boolean SaveStatus = true;
			try {
				
				BL.clickElement(T.TransctionSet);


				BL.clickElement(B.SaveButton);

				BL.clickElement(B.OKButton);

				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}	
			
			logTestStep(TestcaseNo, "Transaction Set", "Save Successfully" , SaveStatus, errorMessage);
			
		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Terminal Info");
			throw e; // Re-throw the exception after handling
		}

	}
	
	private String generateValidterminalname(Faker faker, Map<String, String> testData) {
		String TerminalName;
		Set<String> existingLegalNames = new HashSet<>();

		// Extract the "LegalName" from testData if it exists and add it to the set
		if (testData.get("TerminalName") != null) {
			existingLegalNames.add(testData.get("TerminalName"));
		}

		while (true) {
			// Generate a unique legal name (7 to 10 alphanumeric characters)
			TerminalName = faker.regexify("[A-Za-z0-9]{7,10}");

			// Ensure the generated legal name is unique
			if (!existingLegalNames.contains(TerminalName)) {
				return TerminalName; // Return the valid unique legal name
			}
		}
	}

	
	private String generateDeviceNumber(Faker faker) {
	    StringBuilder deviceNumber = new StringBuilder();

	    // First 3 characters: Uppercase letters
	    for (int i = 0; i < 3; i++) {
	        deviceNumber.append(faker.regexify("[A-Z]"));
	    }

	    // Next 7 characters: Digits
	    for (int i = 0; i < 7; i++) {
	        deviceNumber.append(faker.number().numberBetween(0, 10));
	    }

	    // Last 2 characters: Uppercase letters
	    for (int i = 0; i < 2; i++) {
	        deviceNumber.append(faker.regexify("[A-Z]"));
	    }

	    return deviceNumber.toString();
	}
	

	private void submitForVerification() throws InterruptedException {

		BL.clickElement(B.SubmitforVerification);

		BL.clickElement(B.YesButton);
		BL.clickElement(B.OKButton);
	}
	
	@When("the System Verifier clicks the Terminal module")
	public void SystemVerifierClicktheModule() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			BL.clickElement(S.ClickOnTerminal);

//			S.ClickOnTerminal();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SUB ISO");
			throw e;
		}

	}
	
	
	@Then("the System Verifier completes Terminal Onboarding, the system should prompt to verify all steps using the sheet name {string}")
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
		}, "Searchbyname");

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

	private void Searchbyname(Map<String, String> testData, int TestcaseNo) throws InterruptedException, AWTException {

		String TerminalName = testData.get("TerminalName");

		key.clear();
		value.clear();
		
		String errorMessag = "The data does not match or is empty.";

		boolean VerifiedStatus = true;

		try {

			String errorMessage = "The data does not match or is empty.";

			boolean Status = true;
			try {
				Thread.sleep(3000);

				BL.clickElement(B.SearchbyBankName);
				Thread.sleep(3000);

				BL.UploadImage(B.SearchbyBankName, TerminalName);

			}catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Search by name");
				throw e;
			}
			
			
			try {

			logTestStep(TestcaseNo, "Search by name", TerminalName, Status, errorMessage);

			Thread.sleep(3000);

			BL.clickElement(B.ActionClick);

			Thread.sleep(2000);

			BL.ActionclickElement(B.ViewButton);
			
			}catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "ACTION AND VIEW BUTTON");
				throw e;
			}


			int testcaseCount = 0;

			boolean verifiedStatus = true;
		
				
				BL.clickElement(B.SubmitforApproval);

				BL.clickElement(B.YesButton);

				BL.clickElement(B.OKButton);

				BL.clickElement(B.ApproveCancel);

			} catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Verified");
				throw e;
			}
		
		logTestStep(TestcaseNo, "Verified", "Terminal", VerifiedStatus, errorMessag);

	}
	
	@When("the System Approver clicks the Terminal module")
	public void SystemApproverClicktheModule() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			BL.clickElement(S.ClickOnTerminal);

//			S.ClickOnTerminal();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SUB ISO");
			throw e;
		}

	}
	
	@Then("the System Approver completes Terminal Onboarding, the system should prompt to Approve using the sheet name {string}")
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
		}, "approveOnboarding");

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

		String TerminalName = testData.get("TerminalName");

		key.clear();
		value.clear();

		String errorMessag = "The data does not match or is empty.";

		boolean Status = true;
		try {
			Thread.sleep(3000);

			BL.clickElement(B.SearchbyBankName);
			Thread.sleep(3000);

			BL.enterElement(B.SearchbyBankName, TerminalName);

		} catch (AssertionError e) {
			Status = false;
			errorMessag = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Search by name", TerminalName, Status, errorMessag);
		Thread.sleep(4000);

		BL.ActionclickElement(B.ActionClick);

		Thread.sleep(1000);

		BL.clickElement(B.ViewButton);

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

		logTestStep(TestcaseNo, "Approved", "Terminal", ApprovedStatus, errorMessage);

//		B.ClickOnApprove();
//
//		B.Yesforsubmit();
//
//		B.OkforSuccessfully();

		BL.clickElement(B.ApproveCancel);

		Thread.sleep(3000);

		BL.clickElement(B.SearchbyBankName);
		Thread.sleep(3000);

		BL.UploadImage(B.SearchbyBankName, TerminalName);
		Thread.sleep(3000);

		BL.ActionclickElement(B.ActionClick);

		try {

			BL.clickElement(B.ViewButton);

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Terminal CPID", BL.getElementValue(B.CPID), ApprovedStatus, errorMessage);

//		B.ClickonViewButton();
//
//		logInputData("Bank CPID", B.getCPID());

		BL.clickElement(B.ApproveCancel);

	}
	
	private void logTestStep(int testcaseCount, String fieldName, String fieldValue, Boolean status,
			String errorMessage) {
		String message = "TO Test Case " + testcaseCount + ": " + fieldName + " with value '" + fieldValue + "' "
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


	
		

	private void performLogout() throws InterruptedException {

		BL.clickElement(B.Profile);

		BL.clickElement(B.LogOut);

		BL.clickElement(B.YesButton);

	}
}
