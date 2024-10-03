package org.Testcases;

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

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest; 
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.qameta.allure.Allure; 
public class SystemUserMultipleBankRegression { 
	private WebDriver driver;

	org.Locators.LoginLocators L;
	org.Locators.BankLocators B;
	org.Locators.AggregatorLocators A;
	org.Locators.SystemUserLocatores S;

     ExtentTest test;
     ExcelDataCache cache = ExcelDataCache.getInstance();

	public SystemUserMultipleBankRegression() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}
	int totalTestCaseCount = 0; 
	
	@Then("the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}")
//	public void processAllData(String sheetName)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//		// Set the Excel file and sheet
//		ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
//				sheetName);
//		
//		// Get the total number of non-empty rows
//		int numberOfRows = ExcelUtils.getRowCount(sheetName);
//		System.out.println("Total rows found: " + numberOfRows);
//		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
//			System.out.println("Running test for row number: " + rowNumber);
//
//			Map<String, String> rowData = ExcelUtils.getRowData(sheetName, rowNumber);
////		        logInputDataa(rowData);
//			try {
//	            // Run the test for the current row
//	            runTestForRow(sheetName, rowNumber);
//	        } catch (Exception e) {
//	            // Handle the exception: take a screenshot and fail the scenario
//	            takeScreenshot(rowNumber);
//	            Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());
//	        }
//
//	        if (rowNumber == numberOfRows) {
//	            System.out.println("Finished processing the last row. Logging out...");
//	            performLogout();
//	        }
//	    }
//	} 
	 // Track the total test case count

	public void processAllData(String sheetName)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {
	    
	    // Set the Excel file and sheet
	    ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
	            sheetName);
	    
	    // Get the total number of non-empty rows
	    int numberOfRows = ExcelUtils.getRowCount(sheetName);
	    System.out.println("Total rows found: " + numberOfRows);
	    
	    TestCaseManager testCaseManager = new TestCaseManager();
	    
	    for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
	        System.out.println("Running test for row number: " + rowNumber);

	        // Get data for the current row
	        Map<String, String> rowData = ExcelUtils.getRowData(sheetName, rowNumber);

	        testCaseManager.startNewTestCase("Test Case for Row " + rowNumber,true);

	        try {
	            // Run the test for the current row
	            int rowTestCaseCount = runTestForRow(sheetName, rowNumber);
	            totalTestCaseCount += rowTestCaseCount;  // Add the row's test case count to the total count 
	            testCaseManager.logInputDataa(key,value);
	        } catch (Exception e) {
	            // Handle the exception: take a screenshot and fail the scenario
	            takeScreenshot(rowNumber);
	            Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());
	        } 

//	        testCaseManager.endTestCase();
	        
	        // If the last row has been processed, log out
	        if (rowNumber == numberOfRows) {
	            System.out.println("Finished processing the last row. Logging out...");
	            performLogout();
	        }
	    }

	    // Log total dashboard count in Extent and Allure reports after all rows are processed
	    logDashboardCount();
	}

	private void logDashboardCount() {
	    String message = "Total Dashboard Count: " + totalTestCaseCount;
	    
	    // Log to Extent Report
	    ExtentCucumberAdapter.addTestStepLog(message);
	    Allure.parameter("Total Test Case Count", totalTestCaseCount);

	    // Log to Allure Report
//	    Allure.addAttachment("Total Dashboard Count", new ByteArrayInputStream(message.getBytes()));

	    // Optionally, print to console for debugging
	    System.out.println(message);
	}

	private int runTestForRow(String sheetName, int rowNumber)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {
	    
	    // Get data for the specified row
	    Map<String, String> testData = ExcelUtils.getRowData(sheetName, rowNumber);
	    System.out.println("Data for row " + rowNumber + ": " + testData);
	    
	    // Initialize the locators (if necessary)
	    B = new org.Locators.BankLocators(driver);

	    // Set implicit wait and page load timeout
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	    int testCaseCount = 0;  // Initialize test case count for the row
       
	    // Perform test actions and validations (increase count as each test case is executed)
	    testCaseCount += validateFieldsForRow(sheetName, testData,rowNumber);

         
 	    return testCaseCount;  // Return the test case count for this row
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



	ArrayList<String> key = new ArrayList<>();
	ArrayList<String> value = new ArrayList<>();

	private void logInputDataa() {
		// Convert ArrayLists to arrays
		String[] keys = key.toArray(new String[0]);
		String[] values = value.toArray(new String[0]);

		// Prepare data for Extent Report
		String[][] data = new String[2][keys.length];
		data[0] = keys; // Header row
		data[1] = values; // Data row

		// Create table markup and log to Extent Report
		Markup m = MarkupHelper.createTable(data);
//		ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, m);
		ExtentCucumberAdapter.getCurrentStep().log(null, m);
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

	

	@SuppressWarnings("unused")
//	private void validateFieldsForRow(String sheetName, Map<String, String> testData)
//			throws InvalidFormatException, IOException, InterruptedException, AWTException {
//
//		// Initialize the locators
//		B = new org.Locators.BankLocators(driver);
//
//		// Set implicit wait and page load timeout
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//
//		// Bank Details Section
//		fillBankDetails(testData);
//
//		// Communication Details Section
//		fillCommunicationDetails(testData);
//
//		// Channel Config Section
//		configureChannel();
//
//		// ONUS Section
//		configureONUS();
//
//		// Global Form Section
//		fillGlobalForm(testData);
//
//		// Commercial Section
//		configureCommercial();
//
//		// Settlement Info Section
//		fillSettlementInfo(testData);
//
//		// White Label Section
//		configureWhiteLabel(testData);
//
//		// Webhooks Section
//		configureWebhooks(testData);
//
//		// KYC Section
//		fillKYCDetails();
//
//		// Final Submission
//		submitForVerification();
//	}
	
	private int validateFieldsForRow(String sheetName, Map<String, String> testData,int TescaseNo)
	        throws InvalidFormatException, IOException, InterruptedException, AWTException {

	    // Initialize the locators
	    B = new org.Locators.BankLocators(driver);

	    // Set implicit wait and page load timeout
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	    // Initialize a counter to track the number of validated fields/sections
	    int validatedFieldsCount = 0;

	    // Bank Details Section
	    fillBankDetails(testData,TescaseNo);
	    validatedFieldsCount++;  // Increment count after successfully filling the section

	    // Communication Details Section
//	    fillCommunicationDetails(testData);
//	    validatedFieldsCount++;
//
//	    // Channel Config Section
//	    configureChannel();
//	    validatedFieldsCount++;
//
//	    // ONUS Section
//	    configureONUS();
//	    validatedFieldsCount++;
//
//	    // Global Form Section
//	    fillGlobalForm(testData);
//	    validatedFieldsCount++;
//
//	    // Commercial Section
//	    configureCommercial();
//	    validatedFieldsCount++;
//
//	    // Settlement Info Section
//	    fillSettlementInfo(testData);
//	    validatedFieldsCount++;
//
//	    // White Label Section
//	    configureWhiteLabel(testData);
//	    validatedFieldsCount++;
//
//	    // Webhooks Section
//	    configureWebhooks(testData);
//	    validatedFieldsCount++;
//
//	    // KYC Section
//	    fillKYCDetails();
//	    validatedFieldsCount++;
//
//	    // Final Submission
//	    submitForVerification();
//	    validatedFieldsCount++;  // Increment count for the final submission

	    // Return the total count of validated fields/sections
	    return validatedFieldsCount;
	}

	private Set<String> existingBankNames = new HashSet<>();
	// Method to fill Bank Details
	private void fillBankDetails(Map<String, String> testData,int TescaseNo) throws InterruptedException, AWTException {
		
		B = new org.Locators.BankLocators(driver);
		
		 Faker faker = new Faker();
		
		int testcaseCount = 0;

		String bankName = testData.get("bankName");
		String address = testData.get("Address");
		String pincode = testData.get("Pincode");
		String gst = testData.get("GST");
		String pan = testData.get("PAN");
		String Marsid = testData.get("Mars id");
		String[] domains = { testData.get("Domain"), testData.get("Domain1"), testData.get("Domain2") };

		key.clear();
		value.clear();
		
		if (bankName == null || bankName.trim().isEmpty()) {
	        bankName = generateValidBankName(faker);
	    }

		if (bankName != null && !bankName.trim().isEmpty()) {
			B.ClickOnCreatebutton();
			B.ClickonBankName();
			B.clearBankName();
			B.EnteronBankName(bankName);
			logInputData("Bank Name", bankName);
			++testcaseCount;
			logTestStep( TescaseNo, "Bank Name", bankName);
		}

		if (address != null && !address.trim().isEmpty()) {
			B.EnterOnAddress(address);
			logInputData("Address", address);
			++testcaseCount;
			logTestStep(TescaseNo, "Address Name", address);
		}
		
		if (pincode != null && pincode.matches("\\d+\\.0")) {
			pincode = pincode.substring(0, pincode.indexOf(".0"));
		B.ClickonPincode();
		B.selectDropdownOption(pincode);
		logInputData("Pincode", B.getPincode());

		++testcaseCount;
		logTestStep(TescaseNo, "Pincode", pincode);
		
		}

		if (gst != null && !gst.trim().isEmpty()) {
			B.ClickOnGst();
			B.EnterOnGst(gst);
			logInputData("GST", gst);
			logTestStep(++testcaseCount, "GST", gst);
		}

		if (pan != null && !pan.trim().isEmpty()) {
			B.EnterOnPAN(pan);
			logInputData("PAN", pan);
			++testcaseCount;
			logTestStep(TescaseNo, "PAN", pan);
		}

		if (Marsid != null && !Marsid.trim().isEmpty()) {
			B.EnteronMarsid(Marsid);
			logInputData("Marsid", Marsid);

			++testcaseCount;
			logTestStep(TescaseNo, "Marsid", Marsid);
			
		}

		for (String domain : domains) {
			if (domain != null && !domain.trim().isEmpty()) {
				B.ClickOnDomain();
				B.EnterOnDomain(domain);
				performTabKeyPress();
				logInputData("Domain", domain);
				++testcaseCount;
				logTestStep(TescaseNo, "Domain", domain);
			}
		}
//		logInputDataa();
		Thread.sleep(2000);
		B.ClickOnNextStep();
	}
	
	private String generateValidBankName(Faker faker) {
	    String bankName;
	    
	    do {
	        // Generate a random bank name
	        bankName = faker.company().name();
	        
	        // Check if the generated name meets the required conditions
	    } while (bankName.length() < 7 || bankName.length() > 30 
	             || existingBankNames.contains(bankName) 
	             || !bankName.matches("[a-zA-Z\\s]+"));
	    
	    // Return a valid and unique bank name
	    return bankName;
	}
	
	private void logTestStep(int testcaseCount, String fieldName, String fieldValue) {
	    String message = "Test Case " + testcaseCount + ": " + fieldName + " with value '" + fieldValue + "' passed.";
	    
	    // Log to Extent Report
	    ExtentCucumberAdapter.addTestStepLog(message);
	    List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();

	    TestCaseManager testCaseManager = new TestCaseManager();
	 // Start a new test case
        testCaseManager.startNewTestCase(message, true);
 
        // Add field name and value to the lists
        keys.add(fieldName);
        values.add(fieldValue);
        
	    testCaseManager.logInputDataa(keys,values);
	    Allure.step("Test case for row " + testcaseCount); 
        testCaseManager.endTestCase(); 
	    // Optionally, print to console for debugging
	    System.out.println(message);
	}

	// Method to fill Communication Details
	private void fillCommunicationDetails(Map<String, String> testData) throws InterruptedException, AWTException {
		
		B = new org.Locators.BankLocators(driver);

		String CommName = testData.get("Communication Name");
		String CommPosition = testData.get("Communication Position");
		String CommMobileNumber = testData.get("Communication MobileNumber");
		String CommEmailid = testData.get("Communication EmailId");

		Thread.sleep(2000);
		B.CLickOnCommunicationInfo();

		Thread.sleep(1000);
		B.CommADD();

		if (CommName != null && !CommName.trim().isEmpty()) {
			Thread.sleep(2000);
			B.ClickOnCommName();
			B.EnterOnCommName(CommName);
			logInputData("Communication Name", CommName);
			performTabKeyPress();

		}

		if (CommPosition != null && !CommPosition.trim().isEmpty()) {
			B.ClickOnCommPosition();
			B.EnterOnCommunicationPosition(CommPosition);
			logInputData("Position", CommPosition);

		}

		if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {
			B.ClickonCommMobileNumber();
			B.EnteronCommMobileNumber(CommMobileNumber);
			logInputData("Mobile Number", CommMobileNumber);
			performTabKeyPress();

		}

		if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {
			B.ClickonCommEmailid();
			B.EnteronCommEmailid(CommEmailid);
			logInputData("Email ID", CommEmailid);
			performTabKeyPress();

		}

		B.ClickOnAdUser();
		B.SelectOnYesAdUser();
		logInputData("AD User", B.getADUSer());

		Thread.sleep(2000);
		B.CommuSavebutton();

		Thread.sleep(3000);
		B.ClickOnNextStep();

	}

	// Method to configure Channel
	private void configureChannel() throws InterruptedException, AWTException {

	
		Thread.sleep(1000);
		B.ChannelADD();

		B.clickonChannel();

		B.SelectonUPIChannel();

		logInputData("Channel-2", B.getSelectonUPIChannel());

		B.clickonTransactionset();

		B.SelectonTransactionsetkUPI();

		logInputData("Transaction Set-2", B.getSelectonTransactionsetkUPI());

		performTabKeyPress();

		B.CommuSavebutton();

		Thread.sleep(1000);
		B.ChannelADD();

		B.clickonChannel();

		B.SelectonAEPSChannel();

		logInputData("Channel-3", B.getSelectonAEPSChannel());

		B.clickonTransactionset();

		B.SelectonTransactionsetAEPS();

		logInputData("Transaction Set-3", B.getSelectonTransactionsetAEPS());

		performTabKeyPress();

		B.CommuSavebutton();

		
		
		
		Thread.sleep(1000);
		B.ChannelADD();

		B.clickonChannel();

		B.SelectonMATMChannel();

		logInputData("Channel-4", B.getSelectonPOSChannel());

		B.clickonNetwork();

		B.getSelectonNetworkMATM();

		logInputData("Network-4", B.getSelectonNetworkPOS());

		B.clickonTransactionsetPoS();

		B.SelectonTransactionsetMATM();

		logInputData("Transaction Set-4", B.getSelectonTransactionsetpos());

		B.clickonRouting();

		B.SelectonRoutingMATM();

		logInputData("Routing-4", B.getSelectonRouting());

		B.CommuSavebutton();
		
		Thread.sleep(3000);
		B.ClickOnNextStep();

	}

	// Method to configure ONUS
	private void configureONUS() throws InterruptedException {
		
		B = new org.Locators.BankLocators(driver);

		Thread.sleep(2000);

		B.ActionOnONUSButton();

		B.addbin();

		Thread.sleep(2000);

		B.SelectonBin();

		logInputData("BIN", B.getSelectonBin());

		B.SubmitOnONUS();
		


		B.ActionOnONUSButton2();

		B.addbin();

		Thread.sleep(2000);

		B.SelectonBin();

		logInputData("BIN", B.getSelectonBin());

		B.SubmitOnONUS();

	}

	// Method to fill Global Form
	private void fillGlobalForm(Map<String, String> testData) throws InterruptedException {
		
		B = new org.Locators.BankLocators(driver);

		String VelocityCheckMinutes = testData.get("Velocity Check Minutes");

		String VelocityCheckCount = testData.get("Velocity Check Count");

		String CashPOSCount = testData.get("CashPOS Count");

		String MicroATMCount = testData.get("Micro ATM Count");

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

		Thread.sleep(2000);

		B.CLickOnglobalfrm();

		Thread.sleep(2000);

		B.checkboxGlobalfrm();

		B.ClickOnVelocityCheckMinute();

		B.EnterOnVelocityCheckMinute(VelocityCheckMinutes);

		B.ClickOnVelocityCheckCount();

		B.EnterOnVelocityCheckCount(VelocityCheckCount);

		B.ClickOnCashpOScount();

		B.EnterOnCashpOScount(CashPOSCount);

		B.ClickOnMicroATMCount();

		B.EnterOnMicroATMCount(MicroATMCount);

		Thread.sleep(3000);

		B.ClickOnInternationalcardCount();

		B.yesInternationalcardCount();

		B.ClickonICAdaily();

		B.EnteronICAdaily(ICADAILY);

		B.ClickonICAWeekly();

		B.EnteronICAWeekly(ICAWEEKLY);

		B.ClickonICAMonthly();

		B.EnteronICAMonthly(ICAMonthly);
		
		//POs    		

				B.ClickonPosdaily();

				B.ClearonPosdaily();

				B.EnteronPosdaily(POSDAILY);

				B.ClickonPosWeekly();

				B.ClearonPosWeekly();

				B.EnteronPosWeekly(POSWEEKLY);

				B.ClickonPosMonthly();

				B.ClearonPosMonthly();

				B.EnteronPosMonthly(POSMonthly);

				B.ClickonPOSMinimum();

				B.ClearonPOSMinimum();

				B.EnteronPOSMinimum(POSMinimum);

				B.ClickonPOSMaximum();

				B.ClearonPOSMaximum();

				B.EnteronPOSMaximum(POSMaximum);

		
//MATM
		B.ClickonMATMdaily();

		B.ClearonMATMdaily();

		B.EnteronMATMdaily(MATMDAILY);

		B.ClickonMATMWeekly();

		B.ClearonMATMWeekly();

		B.EnteronMATMWeekly(MATMWEEKLY);

		B.ClickonMATMMonthly();

		B.ClearonMATMMonthly();

		B.EnteronMATMMonthly(MATMMonthly);

		B.ClickonMATMMinimum();

		B.ClearonMATMMinimum();

		B.EnteronMATMMinimum(MATMMinimum);

		B.ClickonMATMMaximum();

		B.ClearonMATMMaximum();

		B.EnteronMATMMaximum(MATMMaximum);

//UPI

		B.ClickonUPIdaily();

		B.ClearonUPIdaily();

		B.EnteronUPIdaily(UPIDAILY);

		B.ClickonUPIWeekly();

		B.ClearonUPIWeekly();

		B.EnteronUPIWeekly(UPIWEEKLY);

		B.ClickonUPIMonthly();

		B.ClearonUPIMonthly();

		B.EnteronUPIMonthly(UPIMonthly);

		B.ClickonUPIMinimum();

		B.ClearonUPIMinimum();

		B.EnteronUPIMinimum(UPIMinimum);

		B.ClickonUPIMaximum();

		B.ClearonUPIMaximum();

		B.EnteronUPIMaximum(UPIMaximum);

//AEPS

		B.ClickonAEPSdaily();

		B.ClearonAEPSdaily();

		B.EnteronAEPSdaily(AEPSDAILY);

		B.ClickonAEPSWeekly();

		B.ClearonAEPSWeekly();

		B.EnteronAEPSWeekly(AEPSWEEKLY);

		B.ClickonAEPSMonthly();

		B.ClearonAEPSMonthly();

		B.EnteronAEPSMonthly(AEPSMonthly);

		B.ClickonAEPSMinimum();

		B.ClearonAEPSMinimum();

		B.EnteronAEPSMinimum(AEPSMinimum);

		B.ClickonAEPSMaximum();

		B.ClearonAEPSMaximum();

		B.EnteronAEPSMaximum(AEPSMaximum);


		Thread.sleep(3000);
		B.ClickOnNextStep();

		logInputData("Velocity Check Minutes", VelocityCheckMinutes);
		logInputData("Velocity Check Count", VelocityCheckCount);
		logInputData("CashPOSCount", CashPOSCount);
		logInputData("Micro ATM Count", MicroATMCount);
		logInputData("ICA DAILY", ICADAILY);
		logInputData("ICA WEEKLY", ICAWEEKLY);
		logInputData("ICA Monthly", ICAMonthly);
		logInputData("POS DAILY", POSDAILY);
		logInputData("POS WEEKLY", POSWEEKLY);
		logInputData("POS Monthly", POSMonthly);
		logInputData("POS Minimum", POSMinimum);
		logInputData("POS Maximum", POSMaximum);
		logInputData("UPI WEEKLY", UPIWEEKLY);
		logInputData("UPI Monthly", UPIMonthly);
		logInputData("UPI Minimum", UPIMinimum);
		logInputData("UPI Maximum", UPIMaximum);
		logInputData("AEPS DAILY", AEPSDAILY);
		logInputData("AEPS WEEKLY", AEPSWEEKLY);
		logInputData("AEPS Monthly", AEPSMonthly);
		logInputData("AEPS Minimum", AEPSMinimum);
		logInputData("AEPS Maximum", AEPSMaximum);
		logInputData("MATM DAILY", MATMDAILY);
		logInputData("MATM WEEKLY", MATMWEEKLY);
		logInputData("MATM Monthly", MATMMonthly);
		logInputData("MATM Minimum", MATMMinimum);
		logInputData("MATM Maximum", MATMMaximum);
	

	}

	// Method to configure Commercial
	private void configureCommercial() throws InterruptedException {
		
		B = new org.Locators.BankLocators(driver);

		Thread.sleep(2000);

		B.clickOnCommericial();

		Thread.sleep(2000);

		B.ClickonCommercialADD1();

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelPOS();

		logInputData("Interchange Plan Commercial Channel", B.getSelectonCommercialChannelPOS());

		B.CLickONPricingPlanInterchange();

		B.SelectONPricingPlanBankPOSTest();

		logInputData("Interchange Plan Pricing Plan", B.getSelectONPricingPlanBankTest());

		B.ClickOnCommercialSave();
		
		
		B.ClickonCommercialADD1();

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelAEPS();

		logInputData("Interchange Plan Commercial Channel", B.getSelectonCommercialChannelAEPS());

		B.CLickONPricingPlanInterchange();

		B.SelectONPricingPlanBankAEPSTest();

		logInputData("Interchange Plan Pricing Plan", B.getSelectONPricingPlanBankTest());

		B.ClickOnCommercialSave();

		Thread.sleep(2000);
		
		B.ClickonCommercialADD2();

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelPOS();

		logInputData("Bank Onboarding Commercial Commercial Channel", B.getSelectonCommercialChannelPOS());

		B.CLickONPricingPlanBankOnboarding();

		B.SelectONBankOnboardingPricingBankPOSPlan();

		logInputData("Bank Onboarding Commercial Pricing Plan", B.getSelectONBankOnboardingPricingBankPlan());

		B.ClickOnCommercialSave();


		B.ClickonCommercialADD2();

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelUPI();

		logInputData("Bank Onboarding Commercial Commercial Channel", B.getSelectonCommercialChannelAEPS());

		B.CLickONPricingPlanBankOnboarding();

		B.SelectONBankOnboardingPricingBankUPIPlan();

		logInputData("Bank Onboarding Commercial Pricing Plan", B.getSelectONBankOnboardingPricingBankPlan());

		B.ClickOnCommercialSave();
		
		B.ClickonCommercialADD2();

		B.ClickonCommercialChannel();

		B.SelectonCommercialChannelAEPS();

		logInputData("Bank Onboarding Commercial Commercial Channel", B.getSelectonCommercialChannelAEPS());

		B.CLickONPricingPlanBankOnboarding();

		B.SelectONBankOnboardingPricingBankAEPSPlan();

		logInputData("Bank Onboarding Commercial Pricing Plan", B.getSelectONBankOnboardingPricingBankPlan());

		B.ClickOnCommercialSave();


		Thread.sleep(3000);
		B.ClickOnNextStep();

	}

	// Method to fill Settlement Info
	private void fillSettlementInfo(Map<String, String> testData) throws InterruptedException {
		
		B = new org.Locators.BankLocators(driver);


		String BanKAccountNumber = testData.get("Bank Account Number");

		Thread.sleep(3000);
		B.clickOnSettlementInfo();

		B.ClickOnSettlementInfoADD();

		B.ClickOnSettlementChannel();

		Thread.sleep(2000);

		B.SelectOnSettlementChannelPOS();

		logInputData("Settlement Channel", B.getSelectOnSettlementChannelPOS());

		B.ClickOnSettlementAccountType();

		B.SelectOnSettlementAccountTypeCurrent();

		logInputData("Settlement Type", B.getSelectOnSettlementAccountTypeCurrent());

		if (BanKAccountNumber != null && !BanKAccountNumber.trim().isEmpty()) {
			B.ClickOnBankAccountNumber();
			B.EnterOnBankAccountNumber(BanKAccountNumber);
			B.ClickOnIFSCCode();
			B.SelectOnIFSCCodeBHG();

			logInputData("BanK Account Number", BanKAccountNumber);

		}

		B.ClickOnIFSCCode();

		B.SelectOnIFSCCodeBHG();

		logInputData("IFSC Code", B.getSelectOnIFSCCodeBHG());

		B.CommuSavebutton();

		Thread.sleep(3000);
		B.ClickOnSettlementType();

		Thread.sleep(3000);
		B.SelectOnSettlementTypeWallet();

		logInputData("Settlement Type", B.getSelectOnSettlementTypeWallet());

		Thread.sleep(3000);
		B.ClickOnNextStep();

	}

	// Method to configure White Label
	private void configureWhiteLabel(Map<String, String> testData) throws InterruptedException, AWTException {
		
		B = new org.Locators.BankLocators(driver);


		String MaximumNoOfPlatform = testData.get("Maximum No of Platform");

		Thread.sleep(3000);

		B.clickOnWhiteLabel();

		Thread.sleep(3000);

		B.ClickOnWhitelabelBankOwnDeployment();

		B.SelectOnWhiteLabelYes();

		logInputData("Bank Own Deployment", B.getClickOnWhitelabelBankOwnDeployment());

		Thread.sleep(1000);

		B.ClickOnWhitelabelPayfacOnboarding();

		B.SelectOnWhiteLabelNO();

		logInputData("Whitelabel Payfac Onboarding", B.getClickOnWhitelabelPayfacOnboarding());

		Thread.sleep(1000);

		B.ClickOnWhitelabelISOOnboarding();

		Thread.sleep(2000);

		B.SelectOnWhiteLabelYes();

		logInputData("Whitelabel ISO Onboarding", B.getClickOnWhitelabelISOOnboarding());

		Thread.sleep(1000);
		B.ClickOnWhitelabelSalesTeamOnboarding();

		Thread.sleep(2000);

		B.SelectOnWhiteLabelNO();

		logInputData("Whitelabel Sales Team Onboarding", B.getClickOnWhitelabelSalesTeamOnboarding());

		if (MaximumNoOfPlatform != null && !MaximumNoOfPlatform.trim().isEmpty()) {
			B.ClickOnMaximumNoofPlatform();
			B.EnterOnMaximumNoofPlatform(MaximumNoOfPlatform);
			performTabKeyPress();
		}

		Thread.sleep(3000);

		B.ClickOnNextStep();

	}

	// Method to configure Webhooks
	private void configureWebhooks(Map<String, String> testData) throws InterruptedException {
		
		B = new org.Locators.BankLocators(driver);


		String webhookURL = testData.get("Webhook url");

		Thread.sleep(2000);

		B.clickOnWebhooks();

		Thread.sleep(2000);
		B.ClickOnWebhookADD();
		Thread.sleep(2000);

		B.ClickOnWebhooksType();

		B.SelectOnWebhooksType();

		logInputData("Webhook Type", B.getSelectOnWebhooksType());

		if (webhookURL != null && !webhookURL.trim().isEmpty()) {
			B.ClickOnWebhooksURL();
			B.EnterOnWebhooksURL(webhookURL);

			logInputData("Webhook URL", webhookURL);
			logInputDataa();

			logInputData("Webhook URL", webhookURL);

		}

		B.ClickOnWebhooksSave();

		Thread.sleep(3000);

		B.ClickOnNextStep();
	}

	// Method to fill KYC Details
	private void fillKYCDetails() throws InterruptedException, AWTException {
		
		B = new org.Locators.BankLocators(driver);

		Thread.sleep(3000);
		B.clickOnKYC();

		Thread.sleep(3000);

		B.ClickOnWebhookADD();

		B.ClickOnKYCBusinessType();

		B.SelectOnKYCBusinessTypeTrust();

		performTabKeyPress();

		logInputData("KYC Business Type", B.getSelectOnKYCBusinessTypeTrust());

		B.ClickOnProofOfIdentityCompany();

		B.SelectOnProofOfIdentityCompany();

		performTabKeyPress();

		logInputData("Proof Of Identity Company KYC", B.getSelectOnProofOfIdentityCompany());

		B.ClickOnProofOfAddressCompany();

		B.SelectOnProofOfAddressCompany();

		performTabKeyPress();

		logInputData("Proof Of Address Company KYC", B.getSelectOnProofOfAddressCompany());

		B.ClickOnBankDocumentCompany();

		B.SelectOnBankDocumentCompany();

		performTabKeyPress();

		logInputData("Bank Document Company KYC", B.getSelectOnBankDocumentCompany());

		B.ClickOnTaxDocumentCompany();

		B.SelectOnTaxDocumentCompany();

		performTabKeyPress();

		logInputData("Tax Document Company KYC", B.getSelectOnTaxDocumentCompany());

		B.ClickOnProofOfIdentityIndividual();

		B.SelectOnProofOfIdentityIndividual();

		performTabKeyPress();

		logInputData("Proof of identity Individual KYC", B.getSelectOnProofOfIdentityIndividual());

		B.ClickOnProofOfAddressIndividual();

		B.SelectOnProofOfAddressIndividual();

		performTabKeyPress();

		logInputData("Proof of address Individual KYC", B.getSelectOnProofOfAddressIndividual());

		B.ClickOnOtherDocumentIndividual();

		B.SelectOnOtherDocumentIndividual();

		performTabKeyPress();

		logInputData("Other Document Individual KYC", B.getSelectOnOtherDocumentIndividual());

		B.ClickOnWebhooksSave();

		Thread.sleep(3000);

		B.ClickOnNextStep();

	}

	// Method to submit for verification
	private void submitForVerification() throws InterruptedException {
		Thread.sleep(2000);
		B.ClickOnsubmitforverification();

		Thread.sleep(2000);

		B.Yesforsubmit();

		Thread.sleep(5000);

		B.OkforSuccessfully();
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

	@Then("the System Verifier completes Bank Onboarding, the system should prompt to verify all steps using the sheet name {string}")
	public void processAllData1(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		// Set the Excel file and sheet
		ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
				sheetName);

		// Get the total number of non-empty rows
		int numberOfRows = ExcelUtils.getRowCount(sheetName);
		System.out.println("Total rows found: " + numberOfRows);
		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
			System.out.println("Running test for row number: " + rowNumber);

			Map<String, String> rowData = ExcelUtils.getRowData(sheetName, rowNumber);
//		        logInputDataa(rowData);
			runTestForRow1(sheetName, rowNumber);

			if (rowNumber == numberOfRows) {
				System.out.println("Finished processing the last row. Logging out...");
				performLogout();
			}
		}
	}
	

	private void runTestForRow1(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		// Get data for the specified row

		Map<String, String> testData = ExcelUtils.getRowData(sheetName, rowNumber);
		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Execute validation with the extracted row data
		validateFieldsForRow1(sheetName, testData);
	}

	private void validateFieldsForRow1(String sheetName, Map<String, String> testData)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		B = new org.Locators.BankLocators(driver);

		// Set implicit wait and page load timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// Fill out various sections
		SearchbyBank(testData);
	}

	private void SearchbyBank(Map<String, String> testData) throws InterruptedException, AWTException {

		String Bankname = testData.get("BankName");
		
		B = new org.Locators.BankLocators(driver);
		
		key.clear();
		value.clear();


		Thread.sleep(4000);

		B.ClickSearchbyBankName();

		Thread.sleep(2000);

		B.SearchbyBankName(Bankname);

		Thread.sleep(2000);

		logInputData("Search By BankName", B.getClickSearchbyBankName());

		logInputDataa();

		Thread.sleep(3000);

		B.ActionClick();

		Thread.sleep(4000);

		B.ClickonViewButton();

		B.CLickOnGenralInfo();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.CLickOnCommunicationInfo();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.CLickOnChannelConfig();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.CLickOnglobalfrm();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.clickOnCommericial();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.clickOnSettlementInfo();

		Thread.sleep(4000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.clickOnWhiteLabel();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.clickOnWebhooks();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(2000);

		B.clickOnKYC();

		Thread.sleep(2000);

		B.VerifiedandNext();

		Thread.sleep(3000);

		B.SubmitforApproval();

		Thread.sleep(2000);

		B.Yesforsubmit();

		Thread.sleep(5000);

		B.OkforSuccessfully();

		B.CancelApprove();

	}
	
	
	@Then("the System Approver completes Bank Onboarding, the system should prompt to Approve using the sheet name {string}")
	public void processAllData2(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		// Set the Excel file and sheet
		ExcelUtils.setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx",
				sheetName);

		// Get the total number of non-empty rows
		int numberOfRows = ExcelUtils.getRowCount(sheetName);
		System.out.println("Total rows found: " + numberOfRows);
		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
			System.out.println("Running test for row number: " + rowNumber);

			Map<String, String> rowData = ExcelUtils.getRowData(sheetName, rowNumber);
//		        logInputDataa(rowData);
			runTestForRow2(sheetName, rowNumber);

			if (rowNumber == numberOfRows) {
				System.out.println("Finished processing the last row. Logging out...");
				performLogout();
			}
		}
	}

	private void runTestForRow2(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		// Get data for the specified row

		Map<String, String> testData = ExcelUtils.getRowData(sheetName, rowNumber);
		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Execute validation with the extracted row data
		validateFieldsForRow2(sheetName, testData);
	}

	private void validateFieldsForRow2(String sheetName, Map<String, String> testData)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		B = new org.Locators.BankLocators(driver);

		// Set implicit wait and page load timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// Fill out various sections
		approveBankOnboarding(testData);
		
		

	}

	private void approveBankOnboarding(Map<String, String> testData) throws InterruptedException {
		
		
		B = new org.Locators.BankLocators(driver);
		
		String Bankname = testData.get("BankName");
		
		key.clear();
		value.clear();
		
         Thread.sleep(4000);
		
		B.ClickSearchbyBankName();
		
		Thread.sleep(3000);

		B.SearchbyBankName(Bankname);
		
		Thread.sleep(3000);
		logInputData("Search By BankName", B.getClickSearchbyBankName());
		
		B.ActionClick();
		
		Thread.sleep(4000);
		
		B.ClickonViewButton();
		
		Thread.sleep(3000);
		
		B.ClickOnApprove();
		
		Thread.sleep(2000);
			
		B.Yesforsubmit();
			
	    Thread.sleep(5000);
			
	   B.OkforSuccessfully();
	   
	   Thread.sleep(3000);
		
		B.CancelApprove();
		
		Thread.sleep(4000);
		
		B.ClickSearchbyBankName();
		
		Thread.sleep(2000);

		B.SearchbyBankName(Bankname);
		
		Thread.sleep(2000);
		
		B.ActionClick();
		
		B.ClickonViewButton();
	    
	    logInputData("Bank CPID", B.getCPID());
	    
	    logInputDataa();
	    
	    B.CancelApprove();
	    
	   
	   


		
		
	}

	private void performLogout() throws InterruptedException {

		Thread.sleep(5000);

		B.LogoutProfile();

		Thread.sleep(2000);

		B.Logoutbutton();

		B.LogoutYESbutton();

	}
	
	

}
