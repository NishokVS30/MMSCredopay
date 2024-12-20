package org.Testcases;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.Locators.BankLocators;
import org.Locators.BaseClassLocator;
import org.Locators.LoginLocators;
import org.Locators.SystemUserLocatores;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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

public class SystemUserMultipleBankRegression extends TestHooks {
//	private List<WebDriver> drivers = new ArrayList<WebDriver>();
	Map<String,WebDriver> drivers = new HashMap<String,WebDriver>();
	int waitTime;
	int assertwaittime;

//	org.Locators.BaseClassLocator BL;
//	org.Locators.SystemUserLocatores S;
//	org.Locators.LoginLocators L;
//	org.Locators.BankLocators B;
//	org.Locators.AggregatorLocators A;
//	org.Locators.ISOLocators ISO;
//	org.Locators.SUBISOLocators SUBISO;
//	org.Locators.GroupMerchantLocator GM;
//	org.Locators.MerchantLocators M;
//	org.Locators.TerminalLocators T;
	ExtentTest test;
	ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();

	public SystemUserMultipleBankRegression() throws InterruptedException {
//		this.driver = CustomWebDriverManager.getDriver();
//		this.waitTime = CustomWebDriverManager.getWaitTime();

//	this.driver = driver;
//		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
//		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}

//	private void setBase(WebDriver driver) {
//		L = new org.Locators.LoginLocators(driver);
//		S = new org.Locators.SystemUserLocatores(driver);
//		B = new org.Locators.BankLocators(driver);
//		A = new org.Locators.AggregatorLocators(driver);
//		ISO = new org.Locators.ISOLocators(driver);
//		SUBISO = new org.Locators.SUBISOLocators(driver);
//		GM = new org.Locators.GroupMerchantLocator(driver);
//		M = new org.Locators.MerchantLocators(driver);
//		T = new org.Locators.TerminalLocators(driver);
//	}
//	@Before("@loadDataExcelUtils")
//	@Given("I load data from Excel using sheetname \"Credentials\"")
//	public void setUp() {
//		// Retrieve the Excel file path from the environment variable
//		String excelFilePath = CustomWebDriverManager.getExcelFilePath();
//		String propertiesFilePath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\src\\test\\resources\\extent.properties";
//		PropertiesFileModifier.updatePropertiesFile(propertiesFilePath);
//
//		System.out.println(
//				"_______________________________________________________Excel file path from environment variable: "
//						+ excelFilePath);
//
//		// Check if the excelFilePath is null or empty
//		if (excelFilePath == null || excelFilePath.isEmpty()) {
//			throw new IllegalArgumentException("Excel file path is not set. Please check the environment variable.");
//		}
//
//		// Proceed to load the data
//		ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();
//		try {
//			cache.loadData(excelFilePath);
//		} catch (InvalidFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // Assuming your loadData method requires the file path
//
//	}
	@Given("I visit the System Maker Login in Regression using sheetname {string} and rownumber {int}")
	public void i_visit_the_System_maker_login(String sheetName, int rowNumber, WebDriver driver)
			throws InvalidFormatException, IOException, InterruptedException {
		try {

			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			LoginLocators L = new org.Locators.LoginLocators(driver);
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
			String[][] data = { { "UserName", "Password" }, { userName, password }, };
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
	public void i_enter_the_credentials_and_click_a_login_button(String sheetName, int rowNumber, WebDriver driver)
			throws InvalidFormatException, IOException, InterruptedException {
		try {

			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			LoginLocators L = new org.Locators.LoginLocators(driver);
			BankLocators B = new org.Locators.BankLocators(driver);
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
	public void I_Visit_System_Maker_Onboarding(WebDriver driver) throws InterruptedException {
		try {
			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			SystemUserLocatores S = new org.Locators.SystemUserLocatores(driver);
			BL.clickElement(S.ClickOnDownArrow);
			BL.clickElement(S.ClickOnOnboarding);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@Then("the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")
	public void System_Maker_seessidemenu_itemsin_Onboarding(WebDriver driver) throws InterruptedException {
		try {
			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			BankLocators B = new org.Locators.BankLocators(driver);
			BL = new org.Locators.BaseClassLocator(driver);
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
	public void SystemMakerClicktheBankModule(WebDriver driver) {
		try {
			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			BankLocators B = new org.Locators.BankLocators(driver);
			BL.clickElement(B.ClickOnBank);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	int totalTestCaseCount = 0;

//	@Then("the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}")
//	public void processAllData(String sheetName)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//		// Load data from the cache only once
//		List<Map<String, String>> testData = cache.getCachedData(sheetName);
//		if (testData == null || testData.isEmpty()) {
//			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);
//		}
//		int numberOfRows = testData.size(); // Number of rows based on cached data
//		System.out.println("Total rows found: " + numberOfRows);
//		 int threadCount = numberOfRows -1; // You can adjust this as needed
//		    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
//		TestCaseManager testCaseManager = new TestCaseManager();
//		// Iterate over the cached data
//		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
//	        // Capture the row number for each iteration to use inside the Runnable task
//	        final int currentRow = rowNumber;
//
//	        // Define the test task for each row
//	        Runnable testTask = () -> {
//	            System.out.println("Running test for row number: " + currentRow);
//
//	            // Open a new tab for this thread and switch to it
//	            WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
//	            newTab.get(CustomWebDriverManager.getBaseUrl());
//	            
//	            Object[] windowHandles=driver.getWindowHandles().toArray();
//	            driver.switchTo().window((String) windowHandles[1]);
//	            // Group by row number in Allure
//	            testCaseManager.startNewTestSuite(currentRow);
//
//	            // Get row data
//	            Map<String, String> rowData = testData.get(currentRow - 1);
//
//	            try {
//	                // Start the test case and log the input data for the row
//	                testCaseManager.startNewTestCase("Test Case for Row " + currentRow, true);
//	                testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));
//
//	                // Run the test in the new tab
//	                int rowTestCaseCount = runTestForRow(sheetName, rowData, currentRow);
//	                synchronized (this) {
//	                    totalTestCaseCount += rowTestCaseCount;
//	                }
//	                testCaseManager.endTestCase(true);
//
//	            } catch (Exception e) {
//	                // Capture screenshot and log error
//	                takeScreenshot(currentRow);
//	                testCaseManager.logErrorInExtent(e.getMessage());
//	                testCaseManager.endTestCase(false);
//	                e.printStackTrace();
//	            } finally {
//	                // End the suite (grouping) for this row
//	                testCaseManager.endTestSuite();
//	                newTab.close(); // Close the tab once done
//	            }
//
//	            // Perform logout only if this is the last row (optional)
//	            if (currentRow == numberOfRows) {
//	                System.out.println("Finished processing the last row. Logging out...");
//	                try {
//						performLogout(currentRow);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//	            }
//	        };
//
//	        // Submit the test task for execution
//	        executorService.submit(testTask);
//	    }
//
//	    // Shutdown the executor service after all tasks are submitted
//	    executorService.shutdown();
//	    try {
//	        // Wait for all tasks to complete
//	        executorService.awaitTermination(10, TimeUnit.MINUTES);
//	    } catch (InterruptedException e) {
//	        e.printStackTrace();
//	    }
//		logDashboardCount();
//	}
//
//	private void logDashboardCount() {
//		String message = "Total Dashboard Count: " + totalTestCaseCount;
//		ExtentCucumberAdapter.addTestStepLog(message);
//		Allure.parameter("Total Test Case Count", totalTestCaseCount);
//		System.out.println(message);
//	}
//
//	private int runTestForRow(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {
//		// Log the test data for the current row
//		System.out.println("Data for row " + rowNumber + ": " + testData);
//		// Initialize the locators (e.g., BankLocators)
//		int testCaseCount = 0;
//		// Validate fields for the current row using testData
//		testCaseCount += validateFieldsForRow(testData, rowNumber);
//		return testCaseCount;
//	}

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
//		WebDriver driver = CustomWebDriverManager.getDriver(); // Get the WebDriver instance

//		String baseUrl = CustomWebDriverManager.getBaseUrl(); // Get the base URL from the environment

		// Store all window handles (tab identifiers)
//		List<String> windowHandles = new ArrayList<>();

		// Open a new tab for each row
//		for (int i = 0; i < numberOfRows; i++) {
//		    if (i == 0) {
//		        driver.get(baseUrl); // Open the first URL in the existing tab
//		    } else {
//		        ((JavascriptExecutor) driver).executeScript("window.open()"); // Open new tabs
//		        Thread.sleep(2000); // Allow the tab to load before getting handles
//		    }
//
//		    // Update the window handles and switch to the correct tab
//		    Set<String> allHandles = driver.getWindowHandles();
//		    windowHandles.clear(); // Clear and repopulate to ensure the order is correct
//		    windowHandles.addAll(allHandles);
//		    
//		    driver.switchTo().window(windowHandles.get(i)); // Switch to the correct tab
//		    driver.get(baseUrl); // Navigate to the base URL in the new tab
//		}
		int noOfBrowsers = 2; // Configurable number of browsers
		Semaphore semaphore = new Semaphore(noOfBrowsers);
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfRows);
		// Iterate over the cached data and process each row in a separate tab
		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
		    int finalRowNumber = rowNumber - 1; // Must be final or effectively final for use in a lambda
		    executorService.submit(() -> {
		        try {
		            // Acquire a permit to proceed
		            semaphore.acquire();
		            System.out.println("Running test for row number: " + finalRowNumber);

		            WebDriver driver;
		            try {
		                // Open and manage a browser
		                driver = CustomWebDriverManager.getDriver();
		                driver.get(CustomWebDriverManager.getBaseUrl());
		                drivers.put(String.valueOf(finalRowNumber), driver);

		                // Simulate processing time
		                Thread.sleep(15000);

		                // Group by row number in Allure
		                testCaseManager.startNewTestSuite(finalRowNumber);

		                // Get row data from cache
		                Map<String, String> rowData = testData.get(finalRowNumber);

		                // Start the test case and log the input data for the row
		                testCaseManager.startNewTestCase("Test Case for Row " + finalRowNumber, true);
		                testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));

		                int rowTestCaseCount = runTestForRow(sheetName, rowData, finalRowNumber);
		                synchronized (this) { // Synchronize access to shared variables
		                    totalTestCaseCount += rowTestCaseCount;
		                }
		                testCaseManager.endTestCase(true);

		            } catch (Exception e) {
		                takeScreenshot(finalRowNumber);
		                testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports
		                Assert.fail("Exception encountered while processing row " + finalRowNumber + ": " + e.getMessage());
		                testCaseManager.endTestCase(false);
		            } finally {
		                testCaseManager.endTestSuite(); // End the suite (grouping) for this row
		                logDashboardCount();

		                // Release the semaphore permit
		                semaphore.release();
		            }
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt(); // Restore the interrupted status
		            System.err.println("Test execution interrupted: " + e.getMessage());
		        }
		    });
		}

		executorService.shutdown(); // Stop accepting new tasks
		try {
			executorService.awaitTermination(1, TimeUnit.HOURS); // Wait for all tasks to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		// Quit the driver instance once done
//		CustomWebDriverManager.quitDriver();
	}

	private void logDashboardCount() {
		String message = "Total Dashboard Count: " + totalTestCaseCount;

		ExtentCucumberAdapter.addTestStepLog(message);
		Allure.parameter("Total Test Case Count", totalTestCaseCount);

		System.out.println(message);
	}

	private int runTestForRow(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {
		System.out.println("Data for row " + rowNumber + ": " + testData);

		BankLocators B = new org.Locators.BankLocators(drivers.get(String.valueOf(rowNumber)));

		int testCaseCount = 0;
		testCaseCount += validateFieldsForRow(sheetName, testData, rowNumber, testCaseCount);

		return testCaseCount;
	}

	private void takeScreenshot(int rowNumber) {
		try {
			File screenshot = ((TakesScreenshot) drivers.get(String.valueOf(rowNumber))).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "//home//ic-002//eclipse-workspace//MMSCredopay//Screenshorts" + rowNumber + ".png";
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

	private int validateFieldsForRow(String sheetName, Map<String, String> testData, int TestcaseNo, int testCaseCount)
			throws Exception {
		int validatedFieldsCount = 0;
//		ONUSINDEX = 1;

		validatedFieldsCount += executeStep(() -> {
			try {			
				fillLoginDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Login Details", drivers.get(String.valueOf(TestcaseNo)));

		validatedFieldsCount += executeStep(() -> {
			try {
//	fillBankDetails(testData, TestcaseNo);
				String generatedBankName = fillBankDetails(testData, TestcaseNo);
				testData.put("bankName", generatedBankName);
			} catch (InterruptedException | AWTException e) {
				//
				e.printStackTrace();
			}
		}, "Bank Details", drivers.get(String.valueOf(TestcaseNo)));
		// Communication Details Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				fillCommunicationDetails(testData, TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Communication Details");
//		// Channel Config Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				fillChannelConfig(TestcaseNo);
//			} catch (Exception e) {
//				//
//				e.printStackTrace();
//			}
//		}, "Channel Config");
//
//		// Global Form Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				fillGlobalForm(testData, TestcaseNo);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Global Form");
//		// Commercial Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				configureCommercialInterChange(testData, TestcaseNo);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Commercial InterChange");
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				configureCommercialBankOnboarding(testData, TestcaseNo);
//			} catch (Exception e) {
//				//
//				e.printStackTrace();
//			}
//		}, "Commercial Bank Onboarding");
//		// Settlement Info Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				fillSettlementInfo(testData, TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Settlement Info");
//		// White Label Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				configureWhiteLabel(testData, TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "White Label Configuration");
//		// Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				configureWebhooks(testData, TestcaseNo);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Webhook Configuration");
//		// KYC Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				fillKYCDetails(testData, TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "KYC Details");
//		// Final Submission
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				submitForVerification(TestcaseNo);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Final Submission");
//		// Return the total count of validated fields/sections
		return validatedFieldsCount;
	}

	private int executeStep(Runnable step, String stepName, WebDriver driver) {
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

	private void fillLoginDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {
		WebDriver driver = drivers.get(String.valueOf(TestcaseNo));
		try {
			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			BankLocators B = new org.Locators.BankLocators(driver);
			LoginLocators L = new org.Locators.LoginLocators(driver);
			SystemUserLocatores S = new org.Locators.SystemUserLocatores(driver);
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String Captcha = testData.get("Captcha");

			BL = new org.Locators.BaseClassLocator(driver);
			BL.enterElement(L.EnterOnUserName, userName);

			BL.enterElement(L.EnterOnPassword, password);

			BL.enterElement(L.EnterOnCaptcha, Captcha);

			BL.clickElement(L.ClickOnLogin);

			BL.clickElement(B.OKButton);

			BL.clickElement(S.ClickOnDownArrow);

			BL.clickElement(S.ClickOnOnboarding);

			BL.clickElement(B.ClickOnBank);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Login Info");
			throw e; // Re-throw the exception after handling
		}
	}

	// Method to fill Bank Details
	private String fillBankDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {
		WebDriver driver = drivers.get(String.valueOf(TestcaseNo));
		try {
			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			BankLocators B = new org.Locators.BankLocators(driver);
			String bankName = testData.get("BankName");
			String address = testData.get("Address");
			String pincode = testData.get("Pincode");
			String gst = testData.get("GST");
			String pan = testData.get("PAN");
			String Marsid = testData.get("Mars id");
			String StatementFrequency = testData.get("Statement Frequency");
			String StatementType = testData.get("Statement Type");
//			String[] domains = { testData.get("Domain"), testData.get("Domain1"), testData.get("Domain2") };
			String domains = testData.get("Domain");
			key.clear();
			value.clear();
			String errorMessage = "The data does not match or is empty.";
			new TestCaseManager();

			BL = new org.Locators.BaseClassLocator(driver);
			if (bankName != null && !bankName.trim().isEmpty()) {

				boolean CreateStatus = true; // Assume success initially
				try {
					BL.clickElement(B.Createbutton);
				} catch (AssertionError e) {
					CreateStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Create : ", "Bank", CreateStatus, errorMessage);

				BL.clickElement(B.BankName);
				BL.CLearElement(B.BankName);
				BL.enterElement(B.BankName, bankName);
				performTabKeyPress(driver);
				boolean bankNameStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.GeneralinfoBanknameInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoBanknameRequiredField, "Field is Required");
				} catch (AssertionError e) {
					bankNameStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Bank Name", bankName, bankNameStatus,
						errorMessage);
			}

			if (address != null && !address.trim().isEmpty()) {
				BL.clickElement(B.Address);
				BL.enterElement(B.Address, address);
				performTabKeyPress(driver);
				boolean AddressNameStatus = true; // Assume success initially
				try {

					// Perform assertion check (modify this as per your requirement)
					BL.isElementNotDisplayed(B.GeneralinfoAddressInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoBanknameRequiredField, "Field is Required");
				} catch (AssertionError e) {
					AddressNameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
//	String getaddress = B.getAddress();
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Address Name", address,
						AddressNameStatus, errorMessage);
			}
			if (pincode != null && !pincode.trim().isEmpty()) {
				BL.clickElement(B.Pincode);
				BL.enterElement(B.Pincode, pincode);
				BL.selectDropdownOption(pincode);
				performTabKeyPress(driver);
				boolean PincodeStatus = true; // Assume success initially
				try {
					// Perform assertion check (modify this as per your requirement)
					BL.isElementNotDisplayed(B.GeneralinfoPincodeInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoPincodeRequiredField, "Field is Required");
				} catch (AssertionError e) {
					PincodeStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Pincode :", pincode, PincodeStatus,
						errorMessage);
			}

			if (gst != null && !gst.trim().isEmpty()) {
				BL.clickElement(B.GST);
				BL.enterElement(B.GST, gst);
				performTabKeyPress(driver);
				boolean GSTStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.GeneralinfogstInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoGSTRequiredField, "Field is Required");
				} catch (AssertionError e) {
					GSTStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : GST :", gst, GSTStatus, errorMessage);
			}

			if (pan != null && !pan.trim().isEmpty()) {
				BL.clickElement(B.PAN);
				BL.enterElement(B.PAN, pan);
				performTabKeyPress(driver);
				boolean PANStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.GeneralinfopanInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoPanRequiredField, "Field is Required");
				} catch (AssertionError e) {
					PANStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : PAN :", pan, PANStatus, errorMessage);
			}
			if (Marsid.contains("E")) {
				Double Marsid1 = Double.valueOf(Marsid);
				Marsid = String.format("%.0f", Marsid1);
			}
			if (Marsid != null && !Marsid.trim().isEmpty()) {
				BL.clickElement(B.Marsid);
				BL.enterElement(B.Marsid, Marsid);
				performTabKeyPress(driver);
				boolean MarsidStatus = true; // Assume success initially
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Marsid :", Marsid, MarsidStatus,
						errorMessage);
			}
			if (StatementFrequency != null && !StatementFrequency.trim().isEmpty()) {
				BL.clickElement(B.StatementFrequency);
				BL.selectDropdownOption(StatementFrequency);
				performTabKeyPress(driver);

				String actualValue = BL.getElementText(B.StatementFrequency);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null)

					{
						assertEquals(StatementFrequency.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Statement Frequency :",
						StatementFrequency, Status, errorMessage);
			}
			if (StatementType != null && !StatementType.trim().isEmpty()) {
				BL.clickElement(B.StatementType);
				BL.selectDropdownOption(StatementType);
				performTabKeyPress(driver);
//				logInputData("Statement Type", StatementType);

				String actualValue = BL.getElementText(B.StatementType);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(StatementType.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Statement Type :", StatementType,
						Status, errorMessage);
			}
//			for (String domain : domains) {
//				if (domain != null && !domain.trim().isEmpty()) {
//					BL.clickElement(B.Domain);
//					BL.enterElement(B.Domain, domain);
//					performTabKeyPress();
//					logInputData("Domain", domain);
//					boolean domainStatus = true;
//					try {
//						BL.isElementNotDisplayed(B.GeneralinfoDomainInvalidformat, "Invalid Format");
//					} catch (AssertionError e) {
//						domainStatus = false;
//						errorMessage = e.getMessage(); // Capture error message
//					}
//					logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Domain", domain, domainStatus,
//							errorMessage);
//				}
//			}

			if (domains != null && !domains.trim().isEmpty()) {

//	            if (!domains.isEmpty()) {    
				String[] DomainArray = domains.split(",");

				for (String domain : DomainArray) {
					domain = domain.trim();
					if (!domain.isEmpty()) {
						// Enter the domain name
						BL.enterElement(B.Domain, domain);

						// Perform Tab key press to trigger the next domain creation
						performTabKeyPress(driver);

						boolean Status = true;
						// Assume success initially
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							Status = false;
							errorMessage = e.getMessage(); // Capture error message
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : Domain Entry", domains, Status, errorMessage);
					}
				}
			}

			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("navigator.geolocation.getCurrentPosition = function(success) { "
						+ "success({coords: {latitude: 0, longitude: 0}}); " + "};");
				if (!BL.isElementDisplayed(B.AdminUserDetails, "Communication Info Page")) {
					throw new AssertionError("Assertion Error ");
				}
			} catch (AssertionError e) {

//				CustomWebDriverManager.takeScreenshotStr("Bank : Genral Info"); // Take screenshot on error

			}

			logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : ", "NextStep", NextstepStatus,
					errorMessage);
			return bankName;

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e; // Re-throw the exception after handling
		}
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
//	private void fillCommunicationDetails(Map<String, String> testData, int TestcaseNo)
//			throws InterruptedException, AWTException {
//		try {
//			String errorMessage = "The data does not match or is empty.";
//			String CommName = testData.get("Communication Name");
//			String CommPosition = testData.get("Communication Position");
//			String CommMobileNumber = testData.get("Communication MobileNumber");
//			String CommEmailid = testData.get("Communication EmailId");
//			String ADUSer = testData.get("AD User");
//			BL.clickElement(B.ClickonCommunicationInfo);
//			BL.clickElement(B.AddButton);
//			if (CommName != null && !CommName.trim().isEmpty()) {
//
//				BL.clickElement(B.ClickonCommuName);
//
//				BL.enterElement(B.ClickonCommuName, CommName);
//				performTabKeyPress();
//				boolean CommunicationNameStatus = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.CommunicationNameInvalidFormat, "Invalid Format");
//					BL.isElementNotDisplayed(B.CommunicationNameFieldisRequired, "Field is Required");
//				} catch (AssertionError e) {
//					CommunicationNameStatus = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication Name", CommName,
//						CommunicationNameStatus, errorMessage);
//			}
//			if (CommPosition != null && !CommPosition.trim().isEmpty()) {
//				BL.clickElement(B.ClickonCommuPosition);
//				BL.enterElement(B.ClickonCommuPosition, CommPosition);
//				performTabKeyPress();
//				boolean CommunicationPositionStatus = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.CommunicationPositionInvalidFormat, "Invalid Format");
//					BL.isElementNotDisplayed(B.CommunicationPositionFieldisRequired, "Field is Required");
//				} catch (AssertionError e) {
//					CommunicationPositionStatus = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication Position",
//						CommPosition, CommunicationPositionStatus, errorMessage);
//			}
//			if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {
//				BL.clickElement(B.ClickonCommuMobileNumber);
//				BL.enterElement(B.ClickonCommuMobileNumber, CommMobileNumber);
//				performTabKeyPress();
//				boolean CommunicationMobileNumberStatus = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.CommunicationMobileInvalidFormat, "Invalid Format");
//					BL.isElementNotDisplayed(B.CommunicationMobileFieldisRequired, "Field is Required");
//				} catch (AssertionError e) {
//					CommunicationMobileNumberStatus = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication MobileNumber",
//						CommMobileNumber, CommunicationMobileNumberStatus, errorMessage);
//			}
//			if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {
//				BL.clickElement(B.ClickonCommuEmailId);
//				BL.enterElement(B.ClickonCommuEmailId, CommEmailid);
//				performTabKeyPress();
//				boolean CommunicationEmailIDStatus = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.CommunicationEmailInvalidFormat, "Invalid Format");
//					BL.isElementNotDisplayed(B.CommunicationEmailFieldisRequired, "Field is Required");
//				} catch (AssertionError e) {
//					CommunicationEmailIDStatus = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication Emailid",
//						CommEmailid, CommunicationEmailIDStatus, errorMessage);
//			}
//			if (ADUSer != null && !ADUSer.trim().isEmpty()) {
//				BL.clickElement(B.ClickOnAdUsers);
//				BL.selectDropdownOption(ADUSer);
//
//				String actualValue = BL.getElementText(B.ClickOnAdUsers);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
//						assertEquals(ADUSer.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : AD User", ADUSer, Status,
//						errorMessage);
//			}
//
//			boolean SaveStatus = true;
//			StringBuilder errorMessageBuilder = new StringBuilder();
//			try {
//				BL.clickElement(B.SaveButton);
//
//				// Check if "Field is Required" message is displayed
//
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessageBuilder.append(e.getMessage()); // Capture the assertion error message
//			}
//
//			// Log the test step regardless of success or failure
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Save Button", "Communication Info",
//					SaveStatus, errorMessage);
//
//			boolean NextstepStatus = true;
//			try {
//
//				BL.clickElement(B.NextStep);
//
//				BL.isElementDisplayed(B.IntroChannelConfiguration, "Channel Config Page");
//
//			} catch (AssertionError e) {
//				NextstepStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : ", "NextStep", NextstepStatus,
//					errorMessage);
//		} catch (Exception e) {
//			// Use the exception handler to log and handle exceptions gracefully
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Communication Info");
//			throw e; // Re-throw the exception after handling
//		}
//	}
//
//	int ONUSINDEX = 1;
//
//	private void fillChannelConfig(int TestcaseNo) throws InterruptedException, AWTException, IOException {
//		try {
//			if (B == null) {
//				// Initialize BankLocators here if needed
//			}
//
//			List<Map<String, String>> cachedData = cache.getCachedData("Channel Bank");
//			int numberOfRows = cachedData.size();
//			System.out.println("Total rows found: " + numberOfRows);
//
//			for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
//				System.out.println("Running test for row number: " + currentRow);
//				ArrayList<String> key = new ArrayList<>();
//				ArrayList<String> value = new ArrayList<>();
//
//				Map<String, String> rowData = cachedData.get(currentRow - 1);
//
//				String channel = rowData.getOrDefault("Channel", "").trim().replaceAll("\\s*,\\s*", ",");
//				String networkData = rowData.getOrDefault("Network", "").trim().replaceAll("\\s*,\\s*", ",");
//				String transactionSet = rowData.getOrDefault("Transaction Sets", "").trim().replaceAll("\\s*,\\s*",
//						",");
//				String routing = rowData.getOrDefault("Routing", "").trim().replaceAll("\\s*,\\s*", ",");
//				String ONUS = rowData.getOrDefault("ONUS Routing", "").trim().replaceAll("\\s*,\\s*", ",");
//
//				System.out.println(ONUS);
//				// Run each process step
//				processChannelData(TestcaseNo, currentRow, channel, key, value);
//				processNetworkData(TestcaseNo, currentRow, networkData, key, value);
//				processTransactionSetData(TestcaseNo, currentRow, transactionSet, key, value);
//				processRoutingData(TestcaseNo, currentRow, routing, key, value);
//				saveAction(TestcaseNo, key, value);
//				processONUSEntries(TestcaseNo, currentRow, ONUS);
//			}
//
//			String errorMessage = "The data does not match or is empty.";
//			boolean NextstepStatus = true;
//			try {
//				BL.clickElement(B.NextStep);
//
//				if (!BL.isElementDisplayed(B.LabelGlobalFRM, "Global FRM"))
//
//				{
//					throw new AssertionError("Assertion Error ");
//				}
//
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Bank : ONUS Routing"); // Take screenshot on error
//
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : ONUS Routing : ", "NextStep", NextstepStatus,
//					errorMessage);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Channel Config And ONUS Routing");
//			throw e;
//		}
//	}
//
//	private void processChannelData(int TestcaseNo, int currentRow, String channel, ArrayList<String> key,
//			ArrayList<String> value) throws InterruptedException, AWTException {
//		String errorMessage = "The data does not match or is empty.";
//		if (!channel.isEmpty()) {
//			try {
//				Thread.sleep(1000);
//				BL.clickElement(B.ChannelConfig);
//				Thread.sleep(1000);
//				BL.clickElement(B.CommercialADD1);
//				BL.clickElement(B.CommercialChannel);
//				BL.selectDropdownOption(channel);
//				key.add("Channel-" + currentRow);
//				value.add(channel);
//				performTabKeyPress();
//
//				String actualValue = BL.getElementText(B.ClickOnChannel);
//				boolean Status = true;
//				try {
//					if (actualValue != null) {
//						assertEquals(channel.toUpperCase(), actualValue.toUpperCase());
//						BL.isElementNotDisplayed(B.ChannelnameFieldisRequired, "Field is Required");
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage();
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Channel", channel, Status,
//						errorMessage);
//			} catch (Exception e) {
//				System.out.println("Error in processing Channel data for row: " + currentRow + " - " + e.getMessage());
//				throw e;
//			}
//		} else {
//			System.out.println("Channel data is empty for row: " + currentRow);
//		}
//	}
//
//	// Similar approach to other data methods:
//	private void processNetworkData(int TestcaseNo, int currentRow, String networkData, ArrayList<String> key,
//			ArrayList<String> value) throws InterruptedException, AWTException {
//		String errorMessage = "The data does not match or is empty.";
//		if (!networkData.isEmpty()) {
//			try {
//				String[] networks = networkData.split(",");
//				for (String network : networks) {
//					network = network.trim();
//					if (!network.isEmpty()) {
//						BL.clickElement(B.ClickOntNetwork);
//						BL.selectDropdownOption(network);
//						key.add("Network-" + currentRow);
//						value.add(network);
//						performTabKeyPress();
//
//					}
//
//				}
//				String actualValue = BL.getElementText(B.ClickOntNetwork);
//				boolean Status = true;
//				try {
//					if (actualValue != null) {
//						assertEquals(networkData.toUpperCase(), actualValue.toUpperCase());
//						BL.isElementNotDisplayed(B.ChannelNetworkFieldisRequired, "Field is Required");
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage();
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Network", networkData, Status,
//						errorMessage);
//
//			} catch (Exception e) {
//				System.out.println("Error in processing Network data for row: " + currentRow + " - " + e.getMessage());
//				throw e;
//			}
//		} else {
//			System.out.println("Network data is empty for row: " + currentRow);
//		}
//	}
//
//	private void processTransactionSetData(int testcaseNo, int currentRow, String transactionSet, ArrayList<String> key,
//			ArrayList<String> value) throws InterruptedException, AWTException {
//		String errorMessage = "The data does not match or is empty.";
//
//		if (!transactionSet.isEmpty()) {
//			try {
//				String[] transa = transactionSet.split(",");
//				for (String trans : transa) {
//					trans = trans.trim();
//					if (!trans.isEmpty()) {
//						BL.clickElement(B.ClickOntransaction);
//						BL.selectDropdownOption(trans);
//						key.add("Transaction Set-" + currentRow);
//						value.add(trans);
//						performTabKeyPress();
//					}
//				}
//				String actualValue = BL.getElementText(B.ClickOntransaction);
//				boolean Status = true;
//				try {
//					if (actualValue != null) {
//						System.out.println("Expected network: " + transactionSet);
//						System.out.println("Actual ADUser from UI: " + BL.getElementText(B.ClickOntransaction));
//						assertEquals(transactionSet.toUpperCase(), actualValue.toUpperCase());
//						BL.isElementNotDisplayed(B.ChannelNetworkFieldisRequired, "Field is Required");
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage();
//				}
//
//				// Log transaction status
//				logTestStep(testcaseNo, "MMS : Bank Onboarding : Channel Config : TransactionSet", transactionSet,
//						Status, errorMessage);
//
//			} catch (Exception e) {
//				System.out.println("Error in processing Network data for row: " + currentRow + " - " + e.getMessage());
//				throw e;
//			}
//		} else {
//			System.out.println("Network data is empty for row: " + currentRow);
//		}
//	}
//
//	private void processRoutingData(int TestcaseNo, int currentRow, String routing, ArrayList<String> key,
//			ArrayList<String> value) throws InterruptedException, AWTException {
//		String errorMessage = "The data does not match or is empty.";
//		if (!routing.isEmpty()) {
//			BL.clickElement(B.ClickOnRouting);
//			BL.selectDropdownOption(routing);
//			key.add("Routing-" + currentRow);
//			value.add(routing);
//			performTabKeyPress();
//
//			String actualValue = BL.getElementText(B.ClickOnRouting);
//
//			boolean Status = true;
//			try {
//				if (actualValue != null) {
//					assertEquals(routing.toUpperCase(), actualValue.toUpperCase());
//					BL.isElementNotDisplayed(B.ChannelRoutingFieldisRequired, "Field is Required");
//				}
//			} catch (AssertionError e) {
//				Status = false;
//				errorMessage = e.getMessage();
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Routing", routing, Status, errorMessage);
//		} else {
//			System.out.println("Routing data is empty for row: " + currentRow);
//		}
//	}
//
//	// Additional helper functions for TransactionSet, Routing, and POSBIN with same
//	// structure.
//
//	private void saveAction(int TestcaseNo, ArrayList<String> key, ArrayList<String> value)
//			throws InterruptedException {
//		String errorMessage = "The data does not match or is empty.";
//		boolean SaveStatus = true;
//		try {
//			BL.clickElement(B.SaveButton);
//			BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//		} catch (AssertionError e) {
//			SaveStatus = false;
//			errorMessage = e.getMessage();
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Save Button", "Channel Config", SaveStatus,
//				errorMessage);
//	}
//
//	private void processONUSEntries(int TestcaseNo, int currentRow, String BIN)
//			throws InterruptedException, AWTException {
//
//		String errorMessage = "The data does not match or is empty.";
//		System.out.println("BIN" + BIN);
//		if (!BIN.isEmpty()) {
//			try {
//				String[] posBinValues = BIN.split("\\s+");
//				for (String ONUS : posBinValues) {
//					ONUS = ONUS.contains(".0") ? ONUS.replace(".0", "") : ONUS;
//					BL.clickElement(B.ONUSRouting);
//					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
//					Thread.sleep(1000);
//					WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
//							.xpath("(//td/button[@aria-label='Example icon-button with a menu'])[" + ONUSINDEX + "]")));
//
//					wait.until(ExpectedConditions.elementToBeClickable(optionElement)).click();
//
//					BL.clickElement(B.AddBin);
//					BL.enterElement(B.ClickOnAddBin, ONUS);
//					performTabKeyPress();
//					BL.clickElement(B.SubmitOnOnus);
//					ONUSINDEX++;
//
//					boolean POSBINStatus = true;
//					try {
//						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//					} catch (AssertionError e) {
//						POSBINStatus = false;
//						errorMessage = e.getMessage();
//					}
//					logTestStep(TestcaseNo, "MMS : Bank Onboarding : ONUS Routing : BIN", ONUS, POSBINStatus,
//							errorMessage);
//				}
//			} catch (Exception e) {
//				System.out.println("Error in processing POS BIN for row: " + currentRow + " - " + e.getMessage());
//				throw e;
//			}
//		}
//	}
//
//	// Method to fill Global Form
//	private void fillGlobalForm(Map<String, String> testData, int TestcaseNo) throws Exception {
//		String VelocityCheckMinutes = testData.get("Velocity Check Minutes");
//		String VelocityCheckCount = testData.get("Velocity Check Count");
//		String CashPOSCount = testData.get("CashPOS Count");
//		String MicroATMCount = testData.get("Micro ATM Count");
//		String card = testData.get("International Card Acceptance");
//		String ICADAILY = testData.get("ICA Daily");
//		String ICAWEEKLY = testData.get("ICA Weekly");
//		String ICAMonthly = testData.get("ICA Monthly");
//		String POSDAILY = testData.get("POS Daily");
//		String POSWEEKLY = testData.get("POS Weekly");
//		String POSMonthly = testData.get("POS Monthly");
//		String POSMinimum = testData.get("POS Minimum");
//		String POSMaximum = testData.get("POS Maximum");
//		String UPIDAILY = testData.get("UPI Daily");
//		String UPIWEEKLY = testData.get("UPI Weekly");
//		String UPIMonthly = testData.get("UPI Monthly");
//		String UPIMinimum = testData.get("UPI Minimum");
//		String UPIMaximum = testData.get("UPI Maximum");
//		String AEPSDAILY = testData.get("AEPS Daily");
//		String AEPSWEEKLY = testData.get("AEPS Weekly");
//		String AEPSMonthly = testData.get("AEPS Monthly");
//		String AEPSMinimum = testData.get("AEPS Minimum");
//		String AEPSMaximum = testData.get("AEPS Maximum");
//		String MATMDAILY = testData.get("MATM Daily");
//		String MATMWEEKLY = testData.get("MATM Weekly");
//		String MATMMonthly = testData.get("MATM Monthly");
//		String MATMMinimum = testData.get("MATM Minimum");
//		String MATMMaximum = testData.get("MATM Maximum");
//
//		String errorMessage = "Invalid Format";
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.GlobalFrm);
//			Thread.sleep(2000);
//			BL.clickElement(B.GlobalFRMCheckbox);
//			if (VelocityCheckMinutes != null && !VelocityCheckMinutes.trim().isEmpty()) {
//				// Perform the actions for the Velocity Check Minutes
//				BL.clickElement(B.VelocityCheckMinute);
//				BL.enterElement(B.VelocityCheckMinute, VelocityCheckMinutes);
//				performTabKeyPress();
//				// Log the input data
//				logInputData("Velocity Check Minutes", VelocityCheckMinutes);
//
//				boolean Status = true; // Assume success initially
//				try {
//					// Check if there is an invalid format
//					assertEquals(VelocityCheckMinutes, BL.getElementText(B.VelocityCheckMinute));
//					BL.isElementNotDisplayed(B.VcheckminutesFieldisRequired, "Field is Required");
//
//				} catch (AssertionError e) {
//					// If an AssertionError occurs, set the status to false and capture the error
//					// message
//					Status = false;
//					errorMessage = e.getMessage();
//				}
//				// Log the test step with the test case number, field, input value, status, and
//				// error message (if any)
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Velocity Check Minutes",
//						VelocityCheckMinutes, Status, errorMessage);
//			}
//			if (VelocityCheckCount != null && !VelocityCheckCount.trim().isEmpty()) {
//				BL.clickElement(B.VelocityCheckCount);
//				BL.enterElement(B.VelocityCheckCount, VelocityCheckCount);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(VelocityCheckCount, BL.getElementText(B.VelocityCheckCount));
//					BL.isElementNotDisplayed(B.VcheckcountFieldisRequired, "Field is Required");
//
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Velocity Check Count", VelocityCheckCount,
//						Status, errorMessage);
//			}
//			if (CashPOSCount != null && !CashPOSCount.trim().isEmpty()) {
//				BL.clickElement(B.CashPOSCount);
//				BL.enterElement(B.CashPOSCount, CashPOSCount);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(CashPOSCount, BL.getElementText(B.CashPOSCount));
//					BL.isElementNotDisplayed(B.CashposcountFieldisRequired, "Field is Required");
//
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : CashPOSCount", CashPOSCount, Status,
//						errorMessage);
//			}
//			if (MicroATMCount != null && !MicroATMCount.trim().isEmpty()) {
//				BL.clickElement(B.MicroATMCount);
//				BL.enterElement(B.MicroATMCount, MicroATMCount);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(MicroATMCount, BL.getElementText(B.MicroATMCount));
//					BL.isElementNotDisplayed(B.MicroATMCountFieldisRequired, "Field is Required");
//
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : MicroATMCount", MicroATMCount, Status,
//						errorMessage);
//			}
//			if (card != null && !card.trim().isEmpty()) {
//				BL.clickElement(B.InternationalCardCount);
//
//				BL.selectDropdownOption(card);
//
//				boolean Status = true; // Assume success initially
//
//				String actualValue = BL.getElementText(B.InternationalCardCount);
//				try {
//					if (actualValue != null) {
//						System.out.println("Expected network: " + card);
//						System.out.println("Actual ADUser from UI: " + BL.getElementText(B.InternationalCardCount));
//						assertEquals(card.toUpperCase(), actualValue.toUpperCase());
//						BL.isElementNotDisplayed(B.IcardacceptanceFieldisRequired, "Field is Required");
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : International Card Acceptance", card,
//						Status, errorMessage);
//			}
////ICA	
//			if (ICADAILY != null && !ICADAILY.trim().isEmpty()) {
//				BL.clickElement(B.ICADaily);
//				BL.enterElement(B.ICADaily, ICADAILY);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(ICADAILY, BL.getElementText(B.ICADaily));
//					BL.isElementNotDisplayed(B.ICADailyFieldisRequired, "Field is Required");
//					BL.isElementNotDisplayed(B.ICAdailylessthanweeklylimtError, "Daily Must be less than Weekly Limit");
//
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ICA DAILY", ICADAILY, Status,
//						errorMessage);
//			}
//			if (ICAWEEKLY != null && !ICAWEEKLY.trim().isEmpty()) {
//				BL.clickElement(B.ICAWeekly);
//				BL.enterElement(B.ICAWeekly, ICAWEEKLY);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(ICAWEEKLY, BL.getElementText(B.ICAWeekly));
//					BL.isElementNotDisplayed(B.ICAWeeklyFieldisRequired, "Field is Required");
//					BL.isElementNotDisplayed(B.ICAWeeklygreaterthanDailylimtError,
//							"Weekly Must be greater than Daily Limit");
//					BL.isElementNotDisplayed(B.ICAWeeklylessthanmonthlylimtError,
//							"Weekly Must be Less than Daily Limit");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ICA WEEKLY", ICAWEEKLY, Status,
//						errorMessage);
//			}
//			if (ICAMonthly != null && !ICAMonthly.trim().isEmpty()) {
//				BL.clickElement(B.ICAMonthly);
//				BL.enterElement(B.ICAMonthly, ICAMonthly);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(ICAMonthly, BL.getElementText(B.ICAMonthly));
//					BL.isElementNotDisplayed(B.ICAMonthlyFieldisRequired, "Field is Required");
//					BL.isElementNotDisplayed(B.ICAMonthlygreaterthanweeklylimtError,
//							"Monthly  Must be greater than Weekly Limit");
//
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ICA Monthly", ICAMonthly, Status,
//						errorMessage);
//			}
////POS	
//			if (POSDAILY != null && !POSDAILY.trim().isEmpty()) {
//				BL.clickElement(B.POSDaily);
//				BL.CLearElement(B.POSDaily);
//				BL.enterElement(B.POSDaily, POSDAILY);
//
//				boolean Status = true; // Assume success initially
//				try {
//
//					System.out.println("Expected network: " + POSDAILY);
//					System.out.println("Actual ADUser from UI: " + BL.getElementText(B.POSDaily));
//					assertEquals(POSDAILY, BL.getElementText(B.POSDaily));
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : POS DAILY", POSDAILY, Status,
//						errorMessage);
//			}
//			if (POSWEEKLY != null && !POSWEEKLY.trim().isEmpty()) {
//				BL.clickElement(B.POSWeekly);
//				BL.CLearElement(B.POSWeekly);
//				BL.enterElement(B.POSWeekly, POSWEEKLY);
//
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(POSWEEKLY, BL.getElementText(B.POSWeekly));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : POS WEEKLY", POSWEEKLY, Status,
//						errorMessage);
//			}
//			if (POSMonthly != null && !POSMonthly.trim().isEmpty()) {
//				BL.clickElement(B.POSMonthly);
//				BL.CLearElement(B.POSMonthly);
//				BL.enterElement(B.POSMonthly, POSMonthly);
//
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(POSMonthly, BL.getElementText(B.POSMonthly));
//
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : POS Monthly", POSMonthly, Status,
//						errorMessage);
//			}
//			if (POSMinimum != null && !POSMinimum.trim().isEmpty()) {
//				BL.clickElement(B.POSMinimumAmount);
//				BL.CLearElement(B.POSMinimumAmount);
//				BL.enterElement(B.POSMinimumAmount, POSMinimum);
//
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(POSMinimum, BL.getElementText(B.POSMinimumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : POS Minimum", POSMinimum, Status,
//						errorMessage);
//			}
//			if (POSMaximum != null && !POSMaximum.trim().isEmpty()) {
//				BL.clickElement(B.POSMaximumAmount);
//				BL.CLearElement(B.POSMaximumAmount);
//				BL.enterElement(B.POSMaximumAmount, POSMaximum);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(POSMaximum, BL.getElementText(B.POSMaximumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : POS Maximum", POSMaximum, Status,
//						errorMessage);
//			}
////UPI
//			if (UPIDAILY != null && !UPIDAILY.trim().isEmpty()) {
//				BL.clickElement(B.UPIDaily);
//				BL.CLearElement(B.UPIDaily);
//				BL.enterElement(B.UPIDaily, UPIDAILY);
//				boolean Status = true; // Assume success initially
//				try {
//
//					assertEquals(UPIDAILY, BL.getElementText(B.UPIDaily));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : UPI DAILY", UPIDAILY, Status,
//						errorMessage);
//			}
//			if (UPIWEEKLY != null && !UPIWEEKLY.trim().isEmpty()) {
//				BL.clickElement(B.UPIWeekly);
//				BL.CLearElement(B.UPIWeekly);
//				BL.enterElement(B.UPIWeekly, UPIWEEKLY);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(UPIWEEKLY, BL.getElementText(B.UPIWeekly));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : UPI WEEKLY", UPIWEEKLY, Status,
//						errorMessage);
//			}
//			if (UPIMonthly != null && !UPIMonthly.trim().isEmpty()) {
//				BL.clickElement(B.UPIMonthly);
//				BL.CLearElement(B.UPIMonthly);
//				BL.enterElement(B.UPIMonthly, UPIMonthly);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(UPIMonthly, BL.getElementText(B.UPIMonthly));
//					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : UPI Monthly", UPIMonthly, Status,
//						errorMessage);
//			}
//			if (UPIMinimum != null && !UPIMinimum.trim().isEmpty()) {
//				BL.clickElement(B.UPIMinimumAmount);
//				BL.CLearElement(B.UPIMinimumAmount);
//				BL.enterElement(B.UPIMinimumAmount, UPIMinimum);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(UPIMinimum, BL.getElementText(B.UPIMinimumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : UPI Minimum", UPIMinimum, Status,
//						errorMessage);
//			}
//			if (UPIMaximum != null && !UPIMaximum.trim().isEmpty()) {
//				BL.clickElement(B.UPIMaximumAmount);
//				BL.CLearElement(B.UPIMaximumAmount);
//				BL.enterElement(B.UPIMaximumAmount, UPIMaximum);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(UPIMaximum, BL.getElementText(B.UPIMaximumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : UPI Maximum", UPIMaximum, Status,
//						errorMessage);
//			}
////AEPS	
//			if (AEPSDAILY != null && !AEPSDAILY.trim().isEmpty()) {
//				BL.clickElement(B.AEPSDaily);
//				BL.CLearElement(B.AEPSDaily);
//				BL.enterElement(B.AEPSDaily, AEPSDAILY);
//				logInputData("AEPS DAILY", AEPSDAILY);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(AEPSDAILY, BL.getElementText(B.AEPSDaily));
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : AEPS DAILY", AEPSDAILY, Status,
//						errorMessage);
//			}
//			if (AEPSWEEKLY != null && !AEPSWEEKLY.trim().isEmpty()) {
//				BL.clickElement(B.AEPSWeekly);
//				BL.CLearElement(B.AEPSWeekly);
//				BL.enterElement(B.AEPSWeekly, AEPSWEEKLY);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(AEPSWEEKLY, BL.getElementText(B.AEPSWeekly));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : AEPS WEEKLY", AEPSWEEKLY, Status,
//						errorMessage);
//			}
//			if (AEPSMonthly != null && !AEPSMonthly.trim().isEmpty()) {
//				BL.clickElement(B.AEPSMonthly);
//				BL.CLearElement(B.AEPSMonthly);
//				BL.enterElement(B.AEPSMonthly, AEPSMonthly);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(AEPSMonthly, BL.getElementText(B.AEPSMonthly));
//					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : AEPS Monthly", AEPSMonthly, Status,
//						errorMessage);
//			}
//			if (AEPSMinimum != null && !AEPSMinimum.trim().isEmpty()) {
//				BL.clickElement(B.AEPSMinimumAmount);
//				BL.CLearElement(B.AEPSMinimumAmount);
//				BL.enterElement(B.AEPSMinimumAmount, AEPSMinimum);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(AEPSMinimum, BL.getElementText(B.AEPSMinimumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : AEPS Minimum", AEPSMinimum, Status,
//						errorMessage);
//			}
//			if (AEPSMaximum != null && !AEPSMaximum.trim().isEmpty()) {
//				BL.clickElement(B.AEPSMaximumAmount);
//				BL.CLearElement(B.AEPSMaximumAmount);
//				BL.enterElement(B.AEPSMaximumAmount, AEPSMaximum);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(AEPSMaximum, BL.getElementText(B.AEPSMaximumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : AEPS Maximum", AEPSMaximum, Status,
//						errorMessage);
//			}
////MATM
//			if (MATMDAILY != null && !MATMDAILY.trim().isEmpty()) {
//				BL.clickElement(B.MATMDaily);
//				BL.CLearElement(B.MATMDaily);
//				BL.enterElement(B.MATMDaily, MATMDAILY);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(MATMDAILY, BL.getElementText(B.MATMDaily));
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : MATM DAILY", MATMDAILY, Status,
//						errorMessage);
//			}
//			if (MATMWEEKLY != null && !MATMWEEKLY.trim().isEmpty()) {
//				BL.clickElement(B.MATMWeekly);
//				BL.CLearElement(B.MATMWeekly);
//				BL.enterElement(B.MATMWeekly, MATMWEEKLY);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(MATMWEEKLY, BL.getElementText(B.MATMWeekly));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : MATM WEEKLY", MATMWEEKLY, Status,
//						errorMessage);
//			}
//			if (MATMMonthly != null && !MATMMonthly.trim().isEmpty()) {
//				BL.clickElement(B.MATMMonthly);
//				BL.CLearElement(B.MATMMonthly);
//				BL.enterElement(B.MATMMonthly, MATMMonthly);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(MATMMonthly, BL.getElementText(B.MATMMonthly));
//					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : MATM Monthly", MATMMonthly, Status,
//						errorMessage);
//			}
//			if (MATMMinimum != null && !MATMMinimum.trim().isEmpty()) {
//				BL.clickElement(B.MATMMinimumAmount);
//				BL.CLearElement(B.MATMMinimumAmount);
//				BL.enterElement(B.MATMMinimumAmount, MATMMinimum);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(MATMMinimum, BL.getElementText(B.MATMMinimumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : MATM Minimum", MATMMinimum, Status,
//						errorMessage);
//			}
//			if (MATMMaximum != null && !MATMMaximum.trim().isEmpty()) {
//				BL.clickElement(B.MATMMaximumAmount);
//				BL.CLearElement(B.MATMMaximumAmount);
//				BL.enterElement(B.MATMMaximumAmount, MATMMaximum);
//				boolean Status = true; // Assume success initially
//				try {
//					assertEquals(MATMMaximum, BL.getElementText(B.MATMMaximumAmount));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : MATM Maximum", MATMMaximum, Status,
//						errorMessage);
//			}
//			boolean NextstepStatus = true;
//			try {
//				BL.clickElement(B.NextStep);
//
//				if (!BL.isElementDisplayed(B.IntroInterchangePlan, "Commercial Info")) {
//					throw new AssertionError("Assertion Error ");
//				}
//
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Bank : Global FRM"); // Take screenshot on error
//
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ", "NextStep", NextstepStatus, errorMessage);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Commercial");
//			throw e;
//		}
//	}
//
//	// Method to configure Commercial
//	private void configureCommercialInterChange(Map<String, String> testData, int TestcaseNo) throws Exception {
//		try {
//			String errorMessagee = "The data does not match or is empty.";
//			List<Map<String, String>> cachedData = cache.getCachedData("Commercial");
//			int numberOfRows = cachedData.size();
//			System.out.println("Total rows found: " + numberOfRows);
//
//			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
//				System.out.println("Running test for row number: " + (currentRow + 1));
//				Map<String, String> testData1 = cachedData.get(currentRow);
//				System.out.println("Test data: " + testData);
//
//				String channel = testData1.getOrDefault("Interchange Channel", "").trim();
//				String pricingPlan = testData1.getOrDefault("Interchange Pricing Plan", "").trim();
//
//				ArrayList<String> key = new ArrayList<>();
//				ArrayList<String> value = new ArrayList<>();
//
//				boolean hasValidData = false;
//
//				// Only process the channel if it’s not null or empty
//				if (!channel.isEmpty()) {
//					hasValidData = true;
//					processField(channel, "Interchange Channel", key, value, currentRow + 1, () -> {
//						BL.clickElement(B.Commercial);
//						BL.clickElement(B.CommercialADD1);
//						BL.clickElement(B.CommercialChannel);
//						BL.selectDropdownOption(channel);
//						boolean Status = true;
//						logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Interchange Channel", channel,
//								Status, "Data matched");
//					});
//				} else {
//					System.out.println("Channel is empty, skipping this field.");
//				}
//
//				// Only process the pricing plan if it’s not null or empty
//				if (!pricingPlan.isEmpty()) {
//					hasValidData = true;
//					processField(pricingPlan, "Interchange Pricing Plan", key, value, currentRow + 1, () -> {
//						BL.clickElement(B.PricingplanInterchange);
//						BL.selectDropdownOption(pricingPlan);
//						boolean Status = true;
//						logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Interchange Pricing Plan",
//								pricingPlan, Status, "Data matched");
//					});
//				} else {
//					System.out.println("Pricing plan is empty, skipping this field.");
//				}
//
//				// Only click the Save button if at least one valid field was processed
//				if (hasValidData) {
//					boolean SaveStatus = true;
//					try {
//
//						BL.clickElement(B.SaveButton);
//						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//
//					} catch (AssertionError e) {
//						SaveStatus = false;
//						errorMessagee = e.getMessage(); // Capture error message
//					}
//					logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Save Button",
//							"Commercial Interchange", SaveStatus, errorMessagee);
//				} else {
//					System.out.println("No valid data found for this row, skipping save operation.");
//				}
//			}
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Commercial");
//			throw e;
//		}
//	}
//
//	private void processField(String fieldData, String fieldName, ArrayList<String> key, ArrayList<String> value,
//			int currentRow, Runnable action) throws InterruptedException, AWTException {
//		if (isValidInput1(fieldData)) {
//			action.run(); // Perform the specific action for the field
//			key.add(fieldName + "-" + currentRow);
//			value.add(fieldData);
////	performTabKeyPress(); // Ensure to move to the next field
//		} else {
//			System.out.println(fieldName + " data is null or empty for row: " + currentRow);
//		}
//	}
//
//	// Helper method to validate input
//	private boolean isValidInput1(String input) {
//		return input != null && !input.trim().isEmpty();
//	}
//
//	private void configureCommercialBankOnboarding(Map<String, String> testData, int TestcaseNo) throws Exception {
//		try {
//			final String defaultErrorMessage = "The data does not match or is empty.";
//			List<Map<String, String>> cachedData = cache.getCachedData("Commercial");
//			int numberOfRows = cachedData.size();
//			System.out.println("Total rows found: " + numberOfRows);
//
//			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
//				System.out.println("Running test for row number: " + (currentRow + 1));
//				Map<String, String> testData1 = cachedData.get(currentRow);
//				System.out.println("Test data: " + testData);
//
//				String channel = testData1.getOrDefault("Commercial Channel", "").trim();
//				String pricingPlan = testData1.getOrDefault("Commercial Pricing Plan", "").trim();
//
//				ArrayList<String> key = new ArrayList<>();
//				ArrayList<String> value = new ArrayList<>();
//				boolean hasValidData = false;
//
//				// Process "Commercial Channel" if it's valid
//				if (!channel.isEmpty()) {
//					hasValidData = true;
//					processField(channel, "Bank Onboarding Commercial Channel", key, value, currentRow + 1, () -> {
//						BL.clickElement(B.Commercial);
//						BL.clickElement(B.CommercialADD2);
//						BL.clickElement(B.CommercialChannel);
//						BL.selectDropdownOption(channel);
//						logTestStep(TestcaseNo,
//								"MMS : Bank Onboarding : Commercial : Bank Onboarding Commercial Channel", channel,
//								true, defaultErrorMessage);
//					});
//				} else {
//					System.out.println("Channel is empty, skipping this field.");
//				}
//
//				// Process "Pricing Plan" if it's valid
//				if (!pricingPlan.isEmpty()) {
//					hasValidData = true;
//					processField(pricingPlan, "Pricing Plan", key, value, currentRow + 1, () -> {
//						BL.clickElement(B.PricingplanBankOnboarding);
//						BL.selectDropdownOption(pricingPlan);
//						logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Bank Onboarding Pricing Plan",
//								pricingPlan, true, defaultErrorMessage);
//					});
//				} else {
//					System.out.println("Pricing plan is empty, skipping this field.");
//				}
//
//				// Attempt to save only if there's valid data
//				if (hasValidData) {
//					boolean SaveStatus = true;
//					String saveErrorMessage = defaultErrorMessage;
//					try {
//						BL.clickElement(B.SaveButton);
//						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//
//					} catch (AssertionError e) {
//						SaveStatus = false;
//						saveErrorMessage = e.getMessage(); // Capture error message
//					}
//					logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Save Button",
//							"Commercial-BankOnboarding", SaveStatus, saveErrorMessage);
//				} else {
//					System.out.println("No valid data found for this row, skipping save operation.");
//				}
//			}
//
//			// Next Step action and log status outside the loop, as it should run once after
//			// all rows are processed
//			boolean NextStepStatus = true;
//			String nextStepErrorMessage = defaultErrorMessage;
//
//			try {
//				BL.clickElement(B.NextStep);
//				if (!BL.isElementDisplayed(B.IntroBankDetails, "Settlement Info")) {
//					throw new AssertionError("Assertion Error ");
//				}
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Bank : Commercial "); // Take screenshot on error
//
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : NextStep", "NextStep", NextStepStatus,
//					nextStepErrorMessage);
//
//		} catch (Exception e) {
//			// Use the exception handler to log and handle exceptions gracefully
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Commercial");
//			throw e; // Re-throw the exception after handling
//		}
//	}
//
//	// Method to fill Settlement Info
//	private void fillSettlementInfo(Map<String, String> testData, int TestcaseNo)
//			throws InterruptedException, AWTException {
//		String errorMessage = "The data does not match or is empty.";
//		String channel = testData.get("Settlement Channel");
//		String Account = testData.get("Account Type");
//		String IFSCCode = testData.get("IFSC Code");
//		String BanKAccountNumber = testData.get("Bank Account Number");
//		String type = testData.get("Settlement Type");
//		try {
//			BL.clickElement(B.SettlementInfo);
//			BL.clickElement(B.AddButton);
//			if (channel != null && !channel.trim().isEmpty()) {
//				BL.clickElement(B.SettlementChannel);
//				BL.selectDropdownOption(channel);
//				String actualValue = BL.getElementText(B.SettlementChannel);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
////					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//						BL.isElementNotDisplayed(B.SettlementChannelFieldisRequired, "Field is Required");
//						assertEquals(channel.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Settlement Channel", channel, Status,
//						errorMessage);
//			}
//			if (Account != null && !Account.trim().isEmpty()) {
//				BL.clickElement(B.SettlementAccountType);
//				BL.selectDropdownOption(Account);
//				boolean Status = true;
//
//				String actualValue = BL.getElementText(B.SettlementAccountType);
//				try {
//					if (actualValue != null) {
//						BL.isElementNotDisplayed(B.SettlementAccTypeFieldisRequired, "Field is Required");
//						assertEquals(Account.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Settlement AccountType", Account,
//						Status, errorMessage);
//			}
//			if (BanKAccountNumber != null && !BanKAccountNumber.trim().isEmpty()) {
//				BL.clickElement(B.SettlementBankAccountNumber);
//				BL.enterElement(B.SettlementBankAccountNumber, BanKAccountNumber);
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.SettlementBankAccNumberFieldisRequired, "Field is Required");
//					assertEquals(BanKAccountNumber, BL.getElementText(B.SettlementBankAccountNumber));
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : BanKAccountNumber",
//						BanKAccountNumber, Status, errorMessage);
//			}
//			if (IFSCCode != null && !IFSCCode.trim().isEmpty()) {
//				BL.clickElement(B.SettlementIFSCCode);
//				BL.selectDropdownOption(IFSCCode);
//				performTabKeyPress();
//				String actualValue = BL.getElementText(B.SettlementIFSCCode);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
//						BL.isElementNotDisplayed(B.SettlementIFSCFieldisRequired, "Field is Required");
//						assertEquals(IFSCCode.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : IFSC Code", IFSCCode, Status,
//						errorMessage);
//			}
//			boolean SaveStatus = true;
//			try {
//				BL.clickElement(B.SaveButton);
//				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Save Button", "Commercial", SaveStatus,
//					errorMessage);
//
//			if (type != null && !type.trim().isEmpty()) {
//				BL.clickElement(B.SettlementType);
//				BL.selectDropdownOption(type);
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Settlement Type", type, Status,
//						errorMessage);
//			}
//			boolean NextstepStatus = true;
//			try {
//				BL.clickElement(B.NextStep);
//				if (!BL.isElementDisplayed(B.IntroBankonboardingConfig, "Whitelabel")) {
//					throw new AssertionError("Assertion Error ");
//				}
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Bank : Settlement Info"); // Take screenshot on error
//
//			}
//
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : ", "NextStep", NextstepStatus,
//					errorMessage);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Settlement Info");
//			throw e;
//		}
//	}
//
//	// Method to configure White Label
//	private void configureWhiteLabel(Map<String, String> testData, int TestcaseNo)
//			throws InterruptedException, AWTException {
//		String errorMessage = "The data does not match or is empty.";
//		String Bank = testData.get("Bank Own Deployment");
//		String payfac = testData.get("Payfac Onboarding");
//		String ISO = testData.get("ISO Onboarding");
//		String Sales = testData.get("Sales Team Onboarding");
//		String MaximumNoOfPlatform = testData.get("Maximum No of Platform");
//		try {
//			BL.clickElement(B.whitelabel);
//			if (Bank != null && !Bank.trim().isEmpty()) {
//				BL.clickElement(B.WhitelabelBankOwnDeployment);
//				BL.selectDropdownOption(Bank);
//				String actualValue = BL.getElementText(B.WhitelabelBankOwnDeployment);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
//						assertEquals(Bank.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Bank Own Deployment", Bank, Status,
//						errorMessage);
//			}
//			if (payfac != null && !payfac.trim().isEmpty()) {
//				BL.clickElement(B.WhitelabelPayfacOnboarding);
//				BL.selectDropdownOption(payfac);
//				String actualValue = BL.getElementText(B.WhitelabelPayfacOnboarding);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
//						assertEquals(payfac.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Payfac Onboarding", payfac, Status,
//						errorMessage);
//			}
//			if (ISO != null && !ISO.trim().isEmpty()) {
//				BL.clickElement(B.WhitelabelISOOnboarding);
//				BL.selectDropdownOption(ISO);
//				logInputData("Whitelabel ISO Onboarding", ISO);
//				String actualValue = BL.getElementText(B.WhitelabelISOOnboarding);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
//						assertEquals(ISO.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Whitelabel ISO Onboarding", ISO, Status,
//						errorMessage);
//			}
//			if (Sales != null && !Sales.trim().isEmpty()) {
//				BL.clickElement(B.WhitelabelSalesTeamOnboarding);
//				BL.selectDropdownOption(Sales);
//				logInputData("Whitelabel Sales Team Onboarding", Sales);
//				String actualValue = BL.getElementText(B.WhitelabelSalesTeamOnboarding);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
//						assertEquals(Sales.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Whitelabel Sales Team Onboarding", Sales,
//						Status, errorMessage);
//			}
//			if (MaximumNoOfPlatform != null && !MaximumNoOfPlatform.trim().isEmpty()) {
//				BL.clickElement(B.WhitelabelMaxNumberOfPlatform);
//				BL.enterElement(B.WhitelabelMaxNumberOfPlatform, MaximumNoOfPlatform);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.MaxPlatformUserInvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Maximum No Of Platform",
//						MaximumNoOfPlatform, Status, errorMessage);
//			}
//			boolean NextstepStatus = true;
//			try {
//				BL.clickElement(B.NextStep);
//				if (!BL.isElementDisplayed(B.IntroPaymentBridge, "Webhooks")) {
//					throw new AssertionError("Assertion Error ");
//				}
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Bank : Whitelabel"); // Take screenshot on error
//
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : ", " NextStep ", NextstepStatus,
//					errorMessage);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Whitelabel");
//			throw e;
//		}
//	}
//
//// Method to configure Webhooks
//	private void configureWebhooks(Map<String, String> testData, int TestcaseNo) throws Exception {
//		String errorMessage = "The data does not match or is empty.";
//		String type = testData.get("Webhook Type");
//		String webhookURL = testData.get("Webhook url");
//		try {
//			BL.clickElement(B.webhooks);
//			BL.clickElement(B.AddButton);
//			if (type != null && !type.trim().isEmpty()) {
//				BL.clickElement(B.WebhookType);
//				BL.selectDropdownOption(type);
//				String actualValue = BL.getElementText(B.WebhookType);
//				boolean Status = true; // Assume success initially
//				try {
//					if (actualValue != null) {
//
//						assertEquals(type.toUpperCase(), actualValue.toUpperCase());
//					}
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Webhooks : Webhook Type", type, Status, errorMessage);
//			}
//			if (webhookURL != null && !webhookURL.trim().isEmpty()) {
//				BL.clickElement(B.WebhookTypeURL);
//				BL.enterElement(B.WebhookTypeURL, webhookURL);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.WebhookURLFieldisRequired, "Field is Required");
//					BL.isElementNotDisplayed(B.WebhookURLInvalidformat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Webhooks : Webhook URL", webhookURL, Status,
//						errorMessage);
//			}
//			boolean SaveStatus = true;
//			try {
//
//				BL.clickElement(B.SaveButton);
//
//				BL.isElementDisplayed(B.InvalidFormat, "Invalid Format");
//
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Webhooks : Save Button", "Webhooks", SaveStatus,
//					errorMessage);
//
//			boolean NextstepStatus = true;
//			try {
//				BL.clickElement(B.NextStep);
//				if (!BL.isElementDisplayed(B.IntroKycConfig, "KYC")) {
//					throw new AssertionError("Assertion Error ");
//				}
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr(" Bank : Webhooks "); // Take screenshot on error
//
//			}
//
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Webhooks : ", "NextStep", NextstepStatus, errorMessage);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Webhooks");
//			throw e;
//		}
//	}
//
//	// Method to fill KYC Details
//	private void fillKYCDetails(Map<String, String> testData, int TestcaseNo)
//			throws InterruptedException, AWTException {
//		String business = testData.get("Business Type");
//		String Company = testData.get("Company Proof of Identity");
//		String IndiPOI = testData.get("Individual Proof of Identity");
//		String IndiPOA = testData.get("Individual Proof of address");
//		String IndiBD = testData.get("Individual Bank Document");
//		String IndiTD = testData.get("Individual Tax Document");
//		String IndiOD = testData.get("Individual Other Document");
//		String errorMessage = "The data does not match or is empty.";
//		try {
//			BL.clickElement(B.AddButton);
//			if (business != null && !business.trim().isEmpty()) {
//				BL.clickElement(B.KYCBusinessType);
//				BL.selectDropdownOption(business);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : KYC Business Type", business, Status,
//						errorMessage);
//			}
//			if (Company != null && !Company.trim().isEmpty()) {
//				BL.clickElement(B.proofofIdentityComapany);
//				BL.selectDropdownOption(Company);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof Of Identity Company KYC", Company, Status,
//						errorMessage);
//			}
//			if (IndiPOI != null && !IndiPOI.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualProofOfIdentity);
//				BL.selectDropdownOption(IndiPOI);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof of identity Individual KYC", IndiPOI,
//						Status, errorMessage);
//			}
//			if (IndiPOA != null && !IndiPOA.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualProofOFAddress);
//				BL.selectDropdownOption(IndiPOA);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof of address Individual KYC", IndiPOA,
//						Status, errorMessage);
//			}
//			if (IndiBD != null && !IndiBD.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualBankDocument);
//				BL.selectDropdownOption(IndiBD);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Bank Document Individual KYC", IndiBD, Status,
//						errorMessage);
//			}
//			if (IndiTD != null && !IndiTD.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualTaxDocument);
//				BL.selectDropdownOption(IndiTD);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : TAX Document Individual KYC", IndiTD, Status,
//						errorMessage);
//			}
//			if (IndiOD != null && !IndiOD.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualOtherDocument);
//				BL.selectDropdownOption(IndiOD);
//				performTabKeyPress();
//				logInputData("Other Document Individual KYC", IndiOD);
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Other Document Individual KYC", IndiOD, Status,
//						errorMessage);
//			}
//			boolean SaveStatus = true;
//			try {
//				BL.clickElement(B.SaveButton);
//				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Save Button", "KYC-BANK", SaveStatus, errorMessage);
//
//			boolean NextstepStatus = true;
//			try {
//				BL.clickElement(B.NextStep);
//				if (!BL.isElementDisplayed(B.IntrostatusHistory, "Status History")) {
//					throw new AssertionError("Assertion Error ");
//				}
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Bank : KYC "); // Take screenshot on error
//
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : ", "NextStep", NextstepStatus, errorMessage);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "KYC-Bank");
//			throw e;
//		}
//	}
//
//	// Method to submit for verification
//	private void submitForVerification(int TestcaseNo) throws InterruptedException {
//
//		try {
//			String errorMessage = "The data does not match or is empty.";
//			boolean SaveStatus = true;
//			try {
//				BL.clickElement(B.SubmitforVerification);
//
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Submit for Verification", "Bank", SaveStatus,
//						errorMessage);
//
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//
//			try {
//				BL.clickElement(B.YesButton);
//
//				if (!BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Submit for Verification")) {
//					throw new AssertionError(
//							"Verification not completed. 'Submit for Verification' element not displayed.");
//				}
//
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : System Maker : Yes Button", "Submit for Verification",
//						SaveStatus, errorMessage);
//
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Maker Verification"); // Take screenshot on error
//
//			}
//			BL.clickElement(B.OKButton);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Submit for verification");
//			throw e;
//		}
//	}
//
//	// Utility methods
	private void performTabKeyPress(WebDriver driver) throws AWTException {
		Actions builder = new Actions(driver);
        Action tab= builder
                .keyDown(Keys.TAB)
                .build();
        tab.perform();
	}
//
//	private void logInputData(String fieldName, String fieldValue) {
//		key.add(fieldName);
//		value.add(fieldValue);
//	}
//
//	@Given("I visit the System Verifier Login in Regression using sheetname {string} and rownumber {int}")
//	public void i_visit_the_System_verifier_login(String sheetName, int rowNumber)
//			throws InvalidFormatException, IOException, InterruptedException {
//		try {
//			// ExcelDataCache cache = ExcelDataCache.getInstance();
//			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
//			System.out.println("sheet name: " + testdata);
//			String userName = testdata.get(rowNumber).get("UserName");
//			String password = testdata.get(rowNumber).get("Password");
//			BL.enterElement(L.EnterOnUserName, userName);
//			BL.enterElement(L.EnterOnPassword, password);
//			test = ExtentCucumberAdapter.getCurrentStep();
//			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
//					+ "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
//					+ "<tr><td style='border: 1px solid black;color: black'>" + userName
//					+ "</td><td style='border: 1px solid black;color: black'>" + password + "</td></tr>" + "</table>";
//			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");
//			String[][] data = { { "UserName", "Password" }, { userName, password }, };
//			Markup m = MarkupHelper.createTable(data);
//			// or
//			test.log(Status.PASS, m);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "LoginScreen");
//			throw e;
//		}
//	}
//
//	@When("System Verifier - Onboarding should be displayed in the side menu")
//	public void I_Visit_System_Verifier_Onboarding() throws InterruptedException {
//		try {
//			BL.clickElement(S.ClickOnDownArrow);
//			BL.clickElement(S.ClickOnOnboarding);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Onboarding");
//			throw e;
//		}
//	}
//
//	@Then("the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")
//	public void System_Verifier_seessidemenu_itemsin_Onboarding() throws InterruptedException {
//		try {
//			BL.isElementDisplayed(B.ClickOnBank, "Bank");
//			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");
//			BL.isElementDisplayed(B.ClickOnISO, "ISO");
//			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");
//			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");
//			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");
//			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Onboarding");
//			throw e;
//		}
//	}
//
//	@When("the System Verifier clicks the bank module")
//	public void SystemVerifierClicktheBankModule() {
//		try {
//			BL.clickElement(B.ClickOnBank);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Onboarding");
//			throw e;
//		}
//	}
//
//	@Then("the System Verifier completes Bank Onboarding, the system should prompt to verify all steps using the sheet name {string}")
//	public void processAllData1(String sheetName)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//		// Load data from the cache only once
//		List<Map<String, String>> testData = cache.getCachedData(sheetName);
//		if (testData == null || testData.isEmpty()) {
//			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);
//		}
//		int numberOfRows = testData.size(); // Number of rows based on cached data
//		System.out.println("Total rows found: " + numberOfRows);
//		TestCaseManager testCaseManager = new TestCaseManager();
//		// Iterate over the cached data
//		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
//			System.out.println("Running test for row number: " + rowNumber);
//			// Group by row number in Allure
//			testCaseManager.startNewTestSuite(rowNumber);
//			// Get row data from cache
//			Map<String, String> rowData = testData.get(rowNumber - 1);
//			try {
//				// Start the test case and log the input data for the row
//				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
//				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));
//				int rowTestCaseCount = runTestForRow1(sheetName, rowData, rowNumber);
//				totalTestCaseCount += rowTestCaseCount;
//				testCaseManager.endTestCase(true);
//			} catch (Exception e) {
//				takeScreenshot(rowNumber);
//				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports
//				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());
//				testCaseManager.endTestCase(false);
//			} finally {
//				testCaseManager.endTestSuite(); // End the suite (grouping) for this row
//			}
//			if (rowNumber == numberOfRows) {
//				System.out.println("Finished processing the last row. Logging out...");
//				performLogout(rowNumber);
//			}
//		}
//		logDashboardCount1();
//	}
//
//	private void logDashboardCount1() {
//		String message = "Total Dashboard Count: " + totalTestCaseCount;
//		ExtentCucumberAdapter.addTestStepLog(message);
//		Allure.parameter("Total Test Case Count", totalTestCaseCount);
//		System.out.println(message);
//	}
//
//	private int runTestForRow1(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {
//		// Log the test data for the current row
//		System.out.println("Data for row " + rowNumber + ": " + testData);
//		// Initialize the locators (e.g., BankLocators)
//		int testCaseCount = 0;
//		// Validate fields for the current row using testData
//		testCaseCount += validateFieldsForRow1(testData, rowNumber);
//		return testCaseCount;
//	}
//
//	@SuppressWarnings("unused")
//	private int validateFieldsForRow1(Map<String, String> testData, int TestcaseNo) throws Exception {
//		// Initialize the locators
//		// Initialize a counter to track the number of validated fields/sections
//		int validatedFieldsCount = 0;
//		// Bank Details Section
//		validatedFieldsCount += executeStep1(() -> {
//			try {
//				SearchbyBank(testData, TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "SearchbyBank");
//		validatedFieldsCount += executeStep(() -> {
//			try {
////	fillBankDetails(testData, TestcaseNo);
//				GenernalInfoVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "General Info Verified");
//		// Communication Details Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				CommunicationInfoVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Communication Info Verified");
//		// Channel Config Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				ChannelConfigVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Channel Config verified");
//		// ONUS Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				configureONUSVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "ONUS Configuration");
//		// Global Form Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				GlobalFormVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Global Form");
//		// Commercial Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				CommercialVerified(TestcaseNo);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Commercial Verfied");
//		// Settlement Info Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				SettlementInfoVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Settlement Info Verified");
//		// White Label Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				WhiteLabelVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "White Label Configuration Verified");
//		// Webhooks Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				WebhooksVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Webhook Configuration");
//		// KYC Section
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				KYCDetailsVerified(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "KYC Details");
//		// Final Submission
//		validatedFieldsCount += executeStep(() -> {
//			try {
//				submitForApproval(TestcaseNo);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "Final Submission - Verified");
//		// Return the total count of validated fields/sections
//		return validatedFieldsCount;
//	}
//
//	private int executeStep1(Runnable step, String stepName) {
//		try {
//			step.run();
//			return 1; // Return 1 for successful execution
//		} catch (Exception e) {
//			// Handle the exception and log the error
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, stepName);
//			return 0; // Return 0 for failed execution
//		}
//	}
//
//	private void SearchbyBank(Map<String, String> testData, int TestcaseNo) throws InterruptedException, AWTException {
//		String Bankname = testData.get("bankName");
////		String Bankname = "PRI BANK";
//		key.clear();
//		value.clear();
//		BL.clickElement(B.SearchbyBankName);
//		Thread.sleep(1000);
//		BL.enterElement(B.SearchbyBankName, Bankname);
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(4000);
//			BL.clickElement(B.ActionClick);
//			Thread.sleep(1000);
//			BL.clickElement(B.ViewButton);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding :Actions and View", "Bank Status Inprogress", verifiedStatus,
//				errorMessage);
//	}
//
//	private void GenernalInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.GeneralInfo);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "General Info", verifiedStatus, errorMessage);
//	}
//
//	private void CommunicationInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.CommunicationInfo);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Communication Info", verifiedStatus, errorMessage);
//	}
//
//	private void ChannelConfigVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.ChannelConfig);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Channel Config", verifiedStatus, errorMessage);
//	}
//
//	private void configureONUSVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.ONUSRouting);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "ONUS Routing", verifiedStatus, errorMessage);
//	}
//
//	private void GlobalFormVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.GlobalFrm);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Global FRM", verifiedStatus, errorMessage);
//	}
//
//	private void CommercialVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.Commercial);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Commercial", verifiedStatus, errorMessage);
//	}
//
//	private void SettlementInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.SettlementInfo);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Settlement Info", verifiedStatus, errorMessage);
//	}
//
//	private void WhiteLabelVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.whitelabel);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified ", "Whitelabel", verifiedStatus, errorMessage);
//	}
//
//	private void WebhooksVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.webhooks);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Webhooks", verifiedStatus, errorMessage);
//	}
//
//	private void KYCDetailsVerified(int TestcaseNo) throws InterruptedException, AWTException {
//		String errorMessage = "Verified Button is not displayed.";
//		boolean verifiedStatus = true;
//		try {
//			Thread.sleep(1000);
//			BL.clickElement(B.VerifiedandNext);
//		} catch (AssertionError e) {
//			verifiedStatus = false;
//			errorMessage = e.getMessage(); // Capture error message
//		}
//		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "KYC", verifiedStatus, errorMessage);
//	}
//
//	private void submitForApproval(int TestcaseNo) throws InterruptedException, AWTException {
//
//		try {
//
//			String errorMessage = "The data does not match or is empty.";
//			boolean SaveStatus = true;
//			try {
//				BL.clickElement(B.SubmitforApproval);
//
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : 	proval", "Bank", SaveStatus, errorMessage);
//
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//
//			try {
//				BL.clickElement(B.YesButton);
//				BL.clickElement(B.OKButton);
//
//				BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Submit for Approval");
//
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : System Verifier : Yes Button", "Submit for Approval",
//						SaveStatus, errorMessage);
//
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//			BL.clickElement(B.ApproveCancel);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Submit for Approval");
//			throw e;
//		}
//	}
//
//	@Given("I visit the System Approver Login in Regression using sheetname {string} and rownumber {int}")
//	public void i_visit_the_System_Approver_login(String sheetName, int rowNumber)
//			throws InvalidFormatException, IOException, InterruptedException {
//		try {
//			// ExcelDataCache cache = ExcelDataCache.getInstance();
//			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
//			System.out.println("sheet name: " + testdata);
//			String userName = testdata.get(rowNumber).get("UserName");
//			String password = testdata.get(rowNumber).get("Password");
//			BL.enterElement(L.EnterOnUserName, userName);
//			BL.enterElement(L.EnterOnPassword, password);
//			test = ExtentCucumberAdapter.getCurrentStep();
//			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
//					+ "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
//					+ "<tr><td style='border: 1px solid black;color: black'>" + userName
//					+ "</td><td style='border: 1px solid black;color: black'>" + password + "</td></tr>" + "</table>";
//			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");
//			String[][] data = { { "UserName", "Password" }, { userName, password }, };
//			Markup m = MarkupHelper.createTable(data);
//			// or
//			test.log(Status.PASS, m);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "LoginScreen");
//			throw e;
//		}
//	}
//
//	@When("System Approver - Onboarding should be displayed in the side menu")
//	public void I_Visit_System_Approver_Onboarding() throws InterruptedException {
//		try {
//			BL.clickElement(S.ClickOnDownArrow);
//			BL.clickElement(S.ClickOnOnboarding);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Onboarding");
//			throw e;
//		}
//	}
//
//	@Then("the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")
//	public void System_Approver_seessidemenu_itemsin_Onboarding() throws InterruptedException {
//		try {
//			BL.isElementDisplayed(B.ClickOnBank, "Bank");
//			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");
//			BL.isElementDisplayed(B.ClickOnISO, "ISO");
//			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");
//			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");
//			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");
//			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Onboarding");
//			throw e;
//		}
//	}
//
//	@When("the System Approver clicks the bank module")
//	public void SystemApproverClicktheBankModule() {
//		try {
//			BL.clickElement(B.ClickOnBank);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Onboarding");
//			throw e;
//		}
//	}
//
//	@Then("the System Approver completes Bank Onboarding, the system should prompt to Approve using the sheet name {string}")
//	public void processAllData2(String sheetName)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//		// Load data from the cache only once
//		List<Map<String, String>> testData = cache.getCachedData(sheetName);
//		if (testData == null || testData.isEmpty()) {
//			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);
//		}
//		int numberOfRows = testData.size(); // Number of rows based on cached data
//		System.out.println("Total rows found: " + numberOfRows);
//		TestCaseManager testCaseManager = new TestCaseManager();
//		// Iterate over the cached data
//		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
//			System.out.println("Running test for row number: " + rowNumber);
//			// Group by row number in Allure
//			testCaseManager.startNewTestSuite(rowNumber);
//			// Get row data from cache
//			Map<String, String> rowData = testData.get(rowNumber - 1);
//			try {
//				// Start the test case and log the input data for the row
//				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
//				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));
//				int rowTestCaseCount = runTestForRow2(sheetName, rowData, rowNumber);
//				totalTestCaseCount += rowTestCaseCount;
//				testCaseManager.endTestCase(true);
//			} catch (Exception e) {
//				takeScreenshot(rowNumber);
//				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports
//				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());
//				testCaseManager.endTestCase(false);
//			} finally {
//				testCaseManager.endTestSuite(); // End the suite (grouping) for this row
//			}
//			if (rowNumber == numberOfRows) {
//				System.out.println("Finished processing the last row. Logging out...");
//				performLogout(rowNumber);
//			}
//		}
//		logDashboardCount2();
//	}
//
//	private void logDashboardCount2() {
//		String message = "Total Dashboard Count: " + totalTestCaseCount;
//		ExtentCucumberAdapter.addTestStepLog(message);
//		Allure.parameter("Total Test Case Count", totalTestCaseCount);
//		System.out.println(message);
//	}
//
//	private int runTestForRow2(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {
//		// Log the test data for the current row
//		System.out.println("Data for row " + rowNumber + ": " + testData);
//		// Initialize the locators (e.g., BankLocators)
//		int testCaseCount = 0;
//		// Validate fields for the current row using testData
//		testCaseCount += validateFieldsForRow2(testData, rowNumber);
//		return testCaseCount;
//	}
//
//	@SuppressWarnings("unused")
//	private int validateFieldsForRow2(Map<String, String> testData, int TestcaseNo) throws Exception {
//		// Initialize the locators
//		// Initialize a counter to track the number of validated fields/sections
//		int validatedFieldsCount = 0;
//		// Bank Details Section
//		validatedFieldsCount += executeStep1(() -> {
//			try {
//				SearchbyBankApprove(testData);
//			} catch (InterruptedException | AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "SearchbyBankApprove");
//		validatedFieldsCount += executeStep2(() -> {
//			try {
//				approveBankOnboarding(testData, TestcaseNo);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "approveBankOnboarding");
//
//		validatedFieldsCount += executeStep2(() -> {
//			try {
//				getCpid(testData, TestcaseNo);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}, "getCpid");
//		// Return the total count of validated fields/sections
//		return validatedFieldsCount;
//	}
//
//	private int executeStep2(Runnable step, String stepName) {
//		try {
//			step.run();
//			return 1;
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, stepName);
//			return 0; // Return 0 for failed execution
//		}
//	}
//
//	private void SearchbyBankApprove(Map<String, String> testData) throws InterruptedException, AWTException {
//		String Bankname = testData.get("bankName");
//		key.clear();
//		value.clear();
//		BL.clickElement(B.SearchbyBankName);
//		Thread.sleep(1000);
//		BL.enterSplitElement(B.SearchbyBankName, Bankname);
//		try {
//			Thread.sleep(3000);
//			BL.clickElement(B.ActionClick);
//			Thread.sleep(1000);
//			BL.clickElement(B.ViewButton);
//		} catch (AssertionError e) {
//		}
//
//	}
//
//	private void approveBankOnboarding(Map<String, String> testData, int TestcaseNo) throws InterruptedException {
//		B = new org.Locators.BankLocators(driver);
//		key.clear();
//		value.clear();
//
//		try {
//			String errorMessage = "The data does not match or is empty.";
//			boolean ApprovedStatus = true;
//			try {
//				BL.clickElement(B.Approve);
//
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Approval", "Bank", ApprovedStatus, errorMessage);
//
//			} catch (AssertionError e) {
//				ApprovedStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//
//			try {
//				BL.clickElement(B.YesButton);
//				BL.clickElement(B.OKButton);
//
//				BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Approval");
//
//				BL.clickElement(B.ApproveCancel);
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : System Approver : Yes", "Approval", ApprovedStatus,
//						errorMessage);
//
//			} catch (AssertionError e) {
//				ApprovedStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Submit for Approval");
//			throw e;
//		}
//
//	}
//
//	private void getCpid(Map<String, String> testData, int TestcaseNo) throws InterruptedException {
//
//		B = new org.Locators.BankLocators(driver);
//		String Bankname = testData.get("bankName");
//		key.clear();
//		value.clear();
//
//		try {
//			String errorMessage = "The data does not match or is empty.";
//			boolean ApprovedStatus = true;
//
//			try {
//				BL.clickElement(B.SearchbyBankName);
//				Thread.sleep(1000);
//				BL.enterSplitElement(B.SearchbyBankName, Bankname);
//				Thread.sleep(4000);
//				BL.clickElement(B.ActionClick);
//				Thread.sleep(1000);
//				BL.clickElement(B.ViewButton);
//			} catch (AssertionError e) {
//				ApprovedStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding :  Bank CPID", BL.getElementValue(B.CPID), ApprovedStatus,
//					errorMessage);
//			BL.clickElement(B.ApproveCancel);
//
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "Submit for Approval");
//			throw e;
//		}
//	}

	private void performLogout(int TestcaseNo, WebDriver driver) throws InterruptedException {

		try {
			BaseClassLocator BL = new org.Locators.BaseClassLocator(driver);
			BankLocators B = new org.Locators.BankLocators(driver);
			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.Profile);
				BL.clickElement(B.LogOut);

				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Profile & Log Out", "Bank", SaveStatus, errorMessage);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			try {
				BL.clickElement(B.YesButton);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Yes Button", "Log-Out", SaveStatus, errorMessage);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Log Out");
			throw e;
		}

	}
}