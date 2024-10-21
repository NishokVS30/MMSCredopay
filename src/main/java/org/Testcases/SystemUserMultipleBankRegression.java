/*
 * package org.Testcases;
 * 
 * import java.awt.AWTException; import java.awt.Robot; import
 * java.awt.event.KeyEvent; import java.io.ByteArrayInputStream; import
 * java.io.File; import java.io.IOException;
 * 
 * import java.util.ArrayList; import java.util.HashSet; import java.util.List;
 * import java.util.Map; import java.util.Set;
 * 
 * import org.Locators.BaseClassLocator; import org.apache.commons.io.FileUtils;
 * import org.apache.poi.openxml4j.exceptions.InvalidFormatException; import
 * org.junit.Assert; import org.openqa.selenium.OutputType; import
 * org.openqa.selenium.TakesScreenshot; import org.openqa.selenium.WebDriver;
 * 
 * import com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter; import
 * com.aventstack.extentreports.markuputils.Markup; import
 * com.aventstack.extentreports.markuputils.MarkupHelper; import
 * com.github.javafaker.Faker;
 * 
 * import io.cucumber.java.Before; import io.cucumber.java.en.And; import
 * io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
 * io.opentelemetry.exporter.logging.SystemOutLogRecordExporter; import
 * io.qameta.allure.Allure;
 * 
 * public class SystemUserMultipleBankRegression { private WebDriver driver;
 * 
 * org.Locators.BaseClassLocator BL;
 * 
 * ExtentTest test; ExcelUtilsDataCache cache =
 * ExcelUtilsDataCache.getInstance();
 * 
 * public SystemUserMultipleBankRegression() throws InterruptedException {
 * this.driver = CustomWebDriverManager.getDriver();
 * System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
 * System.setProperty("webdriver.chrome.verboseLogging", "true");
 * 
 * }
 * 
 * @Before("@loadDataExcelUtils")
 * 
 * @Given("I load data from Excel using sheetname \"Credentials\"") public
 * static void setUp() throws InvalidFormatException, IOException {
 * ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();
 * System.out.println("BEFORE ALL WORK"); cache.
 * loadData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx"
 * ); // Load data // only once }
 * 
 * @Given("I visit the System Maker Login in Regression using sheetname {string} and rownumber {int}"
 * ) public void i_visit_the_System_maker_login(String sheetName, int rowNumber)
 * throws InvalidFormatException, IOException, InterruptedException {
 * 
 * try {
 * 
 * // ExcelDataCache cache = ExcelDataCache.getInstance(); List<Map<String,
 * String>> testdata = cache.getCachedData(sheetName);
 * 
 * System.out.println("sheet name: " + testdata);
 * 
 * String userName = testdata.get(rowNumber).get("UserName"); String password =
 * testdata.get(rowNumber).get("Password");
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * BL.enterElement(BL.EnterOnUserName, userName);
 * BL.enterElement(BL.EnterOnPassword, password);
 * 
 * test = ExtentCucumberAdapter.getCurrentStep();
 * 
 * String styledTable =
 * "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
 * +
 * "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
 * + "<tr><td style='border: 1px solid black;color: black'>" + userName +
 * "</td><td style='border: 1px solid black;color: black'>" + password +
 * "</td></tr>" + "</table>";
 * 
 * Allure.addAttachment("Input Datas", "text/html", new
 * ByteArrayInputStream(styledTable.getBytes()), "html");
 * 
 * String[][] data = { { "UserName", "Password" }, { userName, password },
 * 
 * }; Markup m = MarkupHelper.createTable(data);
 * 
 * // or test.log(Status.PASS, m);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "LoginScreen"); throw e; } }
 * 
 * @And("I enter the credentials and click a login button in Regression using sheetname {string} and rownumber {int}"
 * ) public void i_enter_the_credentials_and_click_a_login_button(String
 * sheetName, int rowNumber) throws InvalidFormatException, IOException,
 * InterruptedException {
 * 
 * try {
 * 
 * // ExcelDataCache cache = ExcelDataCache.getInstance(); List<Map<String,
 * String>> testdata = cache.getCachedData(sheetName);
 * 
 * System.out.println("sheet name: " + testdata);
 * 
 * String Captcha = testdata.get(rowNumber).get("Captcha");
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * BL.enterElement(BL.EnterOnCaptcha, Captcha);
 * 
 * BL.clickElement(BL.ClickOnLogin);
 * 
 * BL.clickElement(BL.OKButton);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "LoginScreen"); throw e; }
 * 
 * }
 * 
 * int totalTestCaseCount = 0;
 * 
 * //Single TAB
 * 
 * // public void processAllData(String sheetName) // throws
 * InvalidFormatException, IOException, InterruptedException, AWTException { //
 * // Set the Excel file and sheet // ExcelUtils.
 * setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx"
 * , // sheetName); // // int numberOfRows = ExcelUtils.getRowCount(sheetName);
 * // System.out.println("Total rows found: " + numberOfRows); // //
 * TestCaseManager testCaseManager = new TestCaseManager(); // // for (int
 * rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) { //
 * System.out.println("Running test for row number: " + rowNumber); // // //
 * Group by row number in Allure //
 * testCaseManager.startNewTestSuite(rowNumber); // // Map<String, String>
 * rowData = ExcelUtils.getRowData(sheetName, rowNumber); // // try { // //
 * Start the test case and log the input data for the row //
 * testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true); //
 * testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new
 * ArrayList<>(rowData.values())); // // int rowTestCaseCount =
 * runTestForRow(sheetName, rowNumber); // totalTestCaseCount +=
 * rowTestCaseCount; // testCaseManager.endTestCase(true); // } catch (Exception
 * e) { // takeScreenshot(rowNumber); //
 * testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent
 * reports // Assert.fail("Exception encountered while processing row " +
 * rowNumber + ": " + e.getMessage()); // testCaseManager.endTestCase(false); //
 * } finally { // // testCaseManager.endTestSuite(); // End the suite (grouping)
 * for this row // } // // if (rowNumber == numberOfRows) { //
 * System.out.println("Finished processing the last row. Logging out..."); //
 * performLogout(); // } // } // // // Log total dashboard count //
 * logDashboardCount(); // }
 * 
 * @Then("the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}"
 * ) public void processAllData(String sheetName) throws InvalidFormatException,
 * IOException, InterruptedException, AWTException {
 * 
 * // Load data from the cache only once List<Map<String, String>> testData =
 * cache.getCachedData(sheetName);
 * 
 * if (testData == null || testData.isEmpty()) { throw new
 * RuntimeException("No data found in the cache for sheet: " + sheetName); }
 * 
 * int numberOfRows = testData.size(); // Number of rows based on cached data
 * System.out.println("Total rows found: " + numberOfRows);
 * 
 * TestCaseManager testCaseManager = new TestCaseManager();
 * 
 * // Iterate over the cached data for (int rowNumber = 1; rowNumber <=
 * numberOfRows; rowNumber++) {
 * System.out.println("Running test for row number: " + rowNumber);
 * 
 * // Group by row number in Allure
 * testCaseManager.startNewTestSuite(rowNumber);
 * 
 * // Get row data from cache Map<String, String> rowData =
 * testData.get(rowNumber - 1);
 * 
 * try { // Start the test case and log the input data for the row
 * testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
 * testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new
 * ArrayList<>(rowData.values()));
 * 
 * int rowTestCaseCount = runTestForRow(sheetName, rowData, rowNumber);
 * totalTestCaseCount += rowTestCaseCount; testCaseManager.endTestCase(true); }
 * catch (Exception e) { takeScreenshot(rowNumber);
 * testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent
 * reports Assert.fail("Exception encountered while processing row " + rowNumber
 * + ": " + e.getMessage()); testCaseManager.endTestCase(false); } finally {
 * testCaseManager.endTestSuite(); // End the suite (grouping) for this row }
 * 
 * if (rowNumber == numberOfRows) {
 * System.out.println("Finished processing the last row. Logging out...");
 * performLogout(); } }
 * 
 * logDashboardCount(); }
 * 
 * private void logDashboardCount() { String message = "Total Dashboard Count: "
 * + totalTestCaseCount;
 * 
 * ExtentCucumberAdapter.addTestStepLog(message);
 * Allure.parameter("Total Test Case Count", totalTestCaseCount);
 * 
 * System.out.println(message); }
 * 
 * private int runTestForRow(String sheetName, Map<String, String> testData, int
 * rowNumber) throws Exception {
 * 
 * System.out.println("Data for row " + rowNumber + ": " + testData);
 * 
 * int testCaseCount = 0;
 * 
 * testCaseCount += validateFieldsForRow(sheetName, testData, rowNumber,
 * testCaseCount);
 * 
 * return testCaseCount; }
 * 
 * // @Then("the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}"
 * ) // public void processAllData(String sheetName) // throws
 * InvalidFormatException, IOException, InterruptedException, AWTException { //
 * // // Load data from the cache only once // List<Map<String, String>>
 * testData = cache.getCachedData(sheetName); // // if (testData == null ||
 * testData.isEmpty()) { // throw new
 * RuntimeException("No data found in the cache for sheet: " + sheetName); // }
 * // // int numberOfRows = testData.size(); // Number of rows based on cached
 * data // System.out.println("Total rows found: " + numberOfRows); // //
 * TestCaseManager testCaseManager = new TestCaseManager(); // WebDriver driver
 * = CustomWebDriverManager.getDriver(); // Get the WebDriver instance // //
 * String baseUrl = CustomWebDriverManager.getBaseUrl(); // Get the base URL
 * from the environment // // // Store all window handles (tab identifiers) //
 * List<String> windowHandles = new ArrayList<>(); // // // Open a new tab for
 * each row // for (int i = 0; i < numberOfRows; i++) { // if (i == 0) { //
 * driver.get(baseUrl); // Open the first URL in the existing tab // } else { //
 * ((JavascriptExecutor) driver).executeScript("window.open()"); // Open new
 * tabs // } // // // Switch to the new tab and navigate to the base URL //
 * Set<String> allHandles = driver.getWindowHandles(); //
 * windowHandles.add(allHandles.toArray()[i].toString()); // Store each tab's
 * handle // // driver.switchTo().window(windowHandles.get(i)); // Switch to the
 * new tab // driver.get(baseUrl); // Navigate to the base URL in the new tab //
 * } // // // Iterate over the cached data and process each row in a separate
 * tab // for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) { //
 * System.out.println("Running test for row number: " + rowNumber); // // //
 * Switch to the corresponding tab for the current row //
 * driver.switchTo().window(windowHandles.get(rowNumber - 1)); // // // Group by
 * row number in Allure // testCaseManager.startNewTestSuite(rowNumber); // //
 * // Get row data from cache // Map<String, String> rowData =
 * testData.get(rowNumber - 1); // // try { // // Start the test case and log
 * the input data for the row //
 * testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true); //
 * testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new
 * ArrayList<>(rowData.values())); // // int rowTestCaseCount =
 * runTestForRow(sheetName, rowData, rowNumber); // totalTestCaseCount +=
 * rowTestCaseCount; // testCaseManager.endTestCase(true); // } catch (Exception
 * e) { // takeScreenshot(rowNumber); //
 * testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent
 * reports // Assert.fail("Exception encountered while processing row " +
 * rowNumber + ": " + e.getMessage()); // testCaseManager.endTestCase(false); //
 * } finally { // testCaseManager.endTestSuite(); // End the suite (grouping)
 * for this row // } // // if (rowNumber == numberOfRows) { //
 * System.out.println("Finished processing the last row. Logging out..."); //
 * performLogout(); // } // } // // logDashboardCount(); // // // Quit the
 * driver instance once done // CustomWebDriverManager.quitDriver(); // } // //
 * private void logDashboardCount() { // String message =
 * "Total Dashboard Count: " + totalTestCaseCount; // //
 * ExtentCucumberAdapter.addTestStepLog(message); //
 * Allure.parameter("Total Test Case Count", totalTestCaseCount); // //
 * System.out.println(message); // } // // private int runTestForRow(String
 * sheetName, Map<String, String> testData, int rowNumber) throws Exception { //
 * System.out.println("Data for row " + rowNumber + ": " + testData); // // BL =
 * new org.Locators.BaseClassLocator(driver); // Initialize the locators // //
 * int testCaseCount = 0; // testCaseCount += validateFieldsForRow(sheetName,
 * testData, rowNumber, testCaseCount); // // return testCaseCount; // }
 * 
 * // Multiple Tab
 * 
 * // @Then("the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}"
 * ) // public void processAllData(String sheetName) throws
 * InvalidFormatException, IOException, InterruptedException, AWTException { //
 * // Load data from the cache only once // List<Map<String, String>> testData =
 * cache.getCachedData(sheetName); // // if (testData == null ||
 * testData.isEmpty()) { // throw new
 * RuntimeException("No data found in the cache for sheet: " + sheetName); // }
 * // // // Create an instance of TestExecutor and execute tests // TestExecutor
 * testExecutor = new TestExecutor(sheetName, testData, driver); //
 * testExecutor.executeTests(); // // // Log the dashboard count after executing
 * tests //// testExecutor.logDashboardCount(); // // // Quit the driver
 * instance once done // CustomWebDriverManager.quitDriver(); // } // private
 * int testCaseCount = 0; // // public void logDashboardCount() { // String
 * message = "Total Dashboard Count: " + totalTestCaseCount; //
 * ExtentCucumberAdapter.addTestStepLog(message); // // // Use a primitive type
 * or String for Allure parameter instead of a List //
 * Allure.parameter("Total Test Case Count",
 * String.valueOf(totalTestCaseCount)); // System.out.println(message); // } //
 * // // public int runTestForRow(String sheetName, Map<String, String>
 * testData, int rowNumber,WebDriver newdriver) throws Exception { //
 * System.out.println("Data for row " + rowNumber + ": " + testData); //
 * this.driver = newdriver; // BL = new org.Locators.BaseClassLocator(driver);
 * // // Pass the fourth argument (testCaseCount) when calling
 * validateFieldsForRow // int testCaseCount = 0; // Initialize testCaseCount //
 * testCaseCount += validateFieldsForRow(sheetName, testData, rowNumber,
 * testCaseCount); // return testCaseCount; // }
 * 
 * private void takeScreenshot(int rowNumber) { try {
 * 
 * File screenshot = ((TakesScreenshot)
 * driver).getScreenshotAs(OutputType.FILE); String screenshotPath =
 * "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" +
 * rowNumber + ".png";
 * 
 * FileUtils.copyFile(screenshot, new File(screenshotPath));
 * 
 * Allure.addAttachment("Screenshot for Row " + rowNumber, new
 * ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));
 * 
 * ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath,
 * "Screenshot for Row " + rowNumber);
 * 
 * } catch (IOException e) { e.printStackTrace(); } }
 * 
 * ArrayList<String> key = new ArrayList<>(); ArrayList<String> value = new
 * ArrayList<>();
 * 
 * private void logInputDataa() {
 * 
 * String[] keys = key.toArray(new String[0]); String[] values =
 * value.toArray(new String[0]);
 * 
 * String[][] data = new String[2][keys.length]; data[0] = keys; data[1] =
 * values;
 * 
 * Markup m = MarkupHelper.createTable(data);
 * ExtentCucumberAdapter.getCurrentStep().log(null, m); StringBuilder
 * tableBuilder = new StringBuilder(); tableBuilder.
 * append("<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
 * );
 * 
 * tableBuilder.append("<tr>"); for (String key : keys) {
 * tableBuilder.append("<th style='border: 1px solid black; color: black;'>").
 * append(key).append("</th>"); } tableBuilder.append("</tr>");
 * 
 * tableBuilder.append("<tr>"); for (String value : values) {
 * tableBuilder.append("<td style='border: 1px solid black; color: black;'>").
 * append(value).append("</td>"); } tableBuilder.append("</tr>");
 * 
 * tableBuilder.append("</table>");
 * 
 * Allure.addAttachment("Input Data", "text/html", new
 * ByteArrayInputStream(tableBuilder.toString().getBytes()), "html"); }
 * 
 * // @SuppressWarnings("unused") // private int validateFieldsForRow(String
 * sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber) //
 * throws Exception { // // // Initialize the locators // BL = new
 * org.Locators.BaseClassLocator(driver); // // // Set implicit wait and page
 * load timeout // // // Initialize a counter to track the number of validated
 * fields/sections // int validatedFieldsCount = 0; // // // Bank Details
 * Section // fillBankDetails(testData, TestcaseNo); // validatedFieldsCount++;
 * // Increment count after successfully filling the section // // //
 * Communication Details Section // fillCommunicationDetails(testData,
 * TestcaseNo); // validatedFieldsCount++; // // // Channel Config Section //
 * fillChannelConfig(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * ONUS Section // configureONUS(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Global Form Section //
 * fillGlobalForm(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * Commercial Section // configureCommercialInterChange(testData, TestcaseNo);
 * // validatedFieldsCount++; // // configureCommercialBankOnboarding(testData,
 * TestcaseNo); // validatedFieldsCount++; // //// // Settlement Info Section //
 * fillSettlementInfo(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * White Label Section // configureWhiteLabel(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Webhooks Section //
 * configureWebhooks(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * KYC Section // fillKYCDetails(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Final Submission // submitForVerification();
 * // validatedFieldsCount++; // Increment count for the final submission // //
 * // Return the total count of validated fields/sections // return
 * validatedFieldsCount; // }
 * 
 * // @SuppressWarnings("unused") // private int validateFieldsForRow(String
 * sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber) //
 * throws Exception { // // // Initialize the locators // BL = new
 * org.Locators.BaseClassLocator(driver); // // // Set implicit wait and page
 * load timeout // // // Initialize a counter to track the number of validated
 * fields/sections // int validatedFieldsCount = 0; // //
 * fillLoginDetails(testData, TestcaseNo); // validatedFieldsCount++; // //
 * SystemMakerOnboardingshouldbedisplayedinthesidemenu(testData, TestcaseNo); //
 * validatedFieldsCount++; // // SystemMakershouldseeallSideMenu(testData,
 * TestcaseNo); // validatedFieldsCount++; // //
 * SystemMakerclicksthebankmodule(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Bank Details Section //
 * fillBankDetails(testData, TestcaseNo); // validatedFieldsCount++; //
 * Increment count after successfully filling the section // // // Communication
 * Details Section // fillCommunicationDetails(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Channel Config Section //
 * fillChannelConfig(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * ONUS Section // configureONUS(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Global Form Section //
 * fillGlobalForm(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * Commercial Section // configureCommercialInterChange(testData, TestcaseNo);
 * // validatedFieldsCount++; // // configureCommercialBankOnboarding(testData,
 * TestcaseNo); // validatedFieldsCount++; // //// // Settlement Info Section //
 * fillSettlementInfo(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * White Label Section // configureWhiteLabel(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Webhooks Section //
 * configureWebhooks(testData, TestcaseNo); // validatedFieldsCount++; // // //
 * KYC Section // fillKYCDetails(testData, TestcaseNo); //
 * validatedFieldsCount++; // // // Final Submission // submitForVerification();
 * // validatedFieldsCount++; // Increment count for the final submission // //
 * // Return the total count of validated fields/sections // return
 * validatedFieldsCount; // }
 * 
 * @SuppressWarnings("unused") private int validateFieldsForRow(String
 * sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)
 * throws Exception {
 * 
 * // Initialize the locators BL = new org.Locators.BaseClassLocator(driver);
 * 
 * // Initialize a counter to track the number of validated fields/sections int
 * validatedFieldsCount = 0;
 * 
 * // validatedFieldsCount += executeStep(() -> fillLoginDetails(testData,
 * TestcaseNo), "Login Details"); // validatedFieldsCount += executeStep( // ()
 * -> SystemMakerOnboardingshouldbedisplayedinthesidemenu(testData, TestcaseNo),
 * "Onboarding Display"); // validatedFieldsCount += executeStep(() ->
 * SystemMakershouldseeallSideMenu(testData, TestcaseNo), //
 * "Side Menu Visibility"); // validatedFieldsCount += executeStep(() ->
 * SystemMakerclicksthebankmodule(testData, TestcaseNo), //
 * "Bank Module Click");
 * 
 * // Bank Details Section String bankName = null; validatedFieldsCount +=
 * executeStep(() -> { try { // fillBankDetails(testData, TestcaseNo); String
 * generatedBankName = fillBankDetails(testData, TestcaseNo);
 * testData.put("bankName", generatedBankName); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "Bank Details");
 * 
 * // Communication Details Section validatedFieldsCount += executeStep(() -> {
 * try { fillCommunicationDetails(testData, TestcaseNo); } catch
 * (InterruptedException | AWTException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }, "Communication Details");
 * 
 * // Channel Config Section validatedFieldsCount += executeStep(() -> { try {
 * fillChannelConfig(testData, TestcaseNo); } catch (InterruptedException |
 * AWTException | IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }, "Channel Config");
 * 
 * // ONUS Section validatedFieldsCount += executeStep(() -> { try {
 * configureONUS(testData, TestcaseNo); } catch (InterruptedException |
 * AWTException | IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }, "ONUS Configuration");
 * 
 * // Global Form Section validatedFieldsCount += executeStep(() -> { try {
 * fillGlobalForm(testData, TestcaseNo); } catch (InterruptedException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } }, "Global Form");
 * 
 * // Commercial Section validatedFieldsCount += executeStep(() -> { try {
 * configureCommercialInterChange(testData, TestcaseNo); } catch (Exception e) {
 * // TODO Auto-generated catch block e.printStackTrace(); } },
 * "Commercial InterChange"); validatedFieldsCount += executeStep(() -> { try {
 * configureCommercialBankOnboarding(testData, TestcaseNo); } catch (Exception
 * e) { // TODO Auto-generated catch block e.printStackTrace(); } },
 * "Commercial Bank Onboarding");
 * 
 * // Settlement Info Section validatedFieldsCount += executeStep(() -> { try {
 * fillSettlementInfo(testData, TestcaseNo); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "Settlement Info");
 * 
 * // White Label Section validatedFieldsCount += executeStep(() -> { try {
 * configureWhiteLabel(testData, TestcaseNo); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "White Label Configuration");
 * 
 * // Webhooks Section validatedFieldsCount += executeStep(() -> { try {
 * configureWebhooks(testData, TestcaseNo); } catch (InterruptedException e) {
 * // TODO Auto-generated catch block e.printStackTrace(); } },
 * "Webhook Configuration");
 * 
 * // KYC Section validatedFieldsCount += executeStep(() -> { try {
 * fillKYCDetails(testData, TestcaseNo); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "KYC Details");
 * 
 * // Final Submission validatedFieldsCount += executeStep(() -> { try {
 * submitForVerification(); } catch (InterruptedException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } }, "Final Submission");
 * 
 * // Return the total count of validated fields/sections return
 * validatedFieldsCount; }
 * 
 * private int executeStep(Runnable step, String stepName) { try { step.run();
 * return 1; // Return 1 for successful execution } catch (Exception e) { //
 * Handle the exception and log the error ExceptionHandler exceptionHandler =
 * new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, stepName); return 0; // Return 0 for
 * failed execution } }
 * 
 * private void fillLoginDetails(Map<String, String> testData, int TestcaseNo) {
 * 
 * try {
 * 
 * String userName = testData.get("UserName"); String password =
 * testData.get("Password"); String Captcha = testData.get("Captcha");
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * 
 * BL.enterElement(BL.EnterOnUserName, userName);
 * BL.enterElement(BL.EnterOnPassword, password);
 * 
 * BL.enterElement(BL.EnterOnCaptcha, Captcha);
 * 
 * BL.clickElement(BL.ClickOnLogin);
 * 
 * BL.clickElement(BL.OKButton);
 * 
 * test = ExtentCucumberAdapter.getCurrentStep();
 * 
 * String styledTable =
 * "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
 * +
 * "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
 * + "<tr><td style='border: 1px solid black;color: black'>" + userName +
 * "</td><td style='border: 1px solid black;color: black'>" + password +
 * "</td></tr>" + "</table>";
 * 
 * Allure.addAttachment("Input Datas", "text/html", new
 * ByteArrayInputStream(styledTable.getBytes()), "html");
 * 
 * String[][] data = { { "UserName", "Password" }, { userName, password },
 * 
 * }; Markup m = MarkupHelper.createTable(data);
 * 
 * // or test.log(Status.PASS, m);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "LoginScreen"); throw e; }
 * 
 * }
 * 
 * private void SystemMakerOnboardingshouldbedisplayedinthesidemenu(Map<String,
 * String> testData, int TestcaseNo) { try {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * BL.clickElement(BL.ClickOnDownArrow);
 * 
 * BL.clickElement(BL.ClickOnOnboarding);
 * 
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Onboarding"); throw e; }
 * 
 * }
 * 
 * private void SystemMakershouldseeallSideMenu(Map<String, String> testData,
 * int TestcaseNo) { try {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * BL.isElementDisplayed(BL.ClickOnBank, "Bank Name");
 * 
 * BL.isElementDisplayed(BL.ClickOnPayfac, "Aggregator Name");
 * 
 * BL.isElementDisplayed(BL.ClickOnISO, "ISO Name");
 * 
 * BL.isElementDisplayed(BL.ClickOnSUBISO, "SUB ISO Name");
 * 
 * BL.isElementDisplayed(BL.ClickOnGM, "Group Merchant Name");
 * 
 * BL.isElementDisplayed(BL.ClickOnMerchant, "Merchant Name");
 * 
 * BL.isElementDisplayed(BL.ClickOnTerminal, "Terminal Name");
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Onboarding"); throw e; }
 * 
 * }
 * 
 * private void SystemMakerclicksthebankmodule(Map<String, String> testData, int
 * TestcaseNo) {
 * 
 * try {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * BL.clickElement(BL.ClickOnBank);
 * 
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Onboarding"); throw e; }
 * 
 * }
 * 
 * private Set<String> existingBankNames = new HashSet<>();
 * 
 * // Method to fill Bank Details private String fillBankDetails(Map<String,
 * String> testData, int TestcaseNo) throws InterruptedException, AWTException {
 * 
 * try {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * Faker faker = new Faker();
 * 
 * int testcaseCount = 0;
 * 
 * String bankName = null; String address = testData.get("Address"); String
 * pincode = testData.get("Pincode"); String gst = testData.get("GST"); String
 * pan = testData.get("PAN"); String Marsid = testData.get("Mars id"); String
 * StatementFrequency = testData.get("Statement Frequency"); String
 * StatementType = testData.get("Statement Type");
 * 
 * String[] domains = { testData.get("Domain"), testData.get("Domain1"),
 * testData.get("Domain2") };
 * 
 * key.clear(); value.clear();
 * 
 * String errorMessage = "The data does not match or is empty.";
 * 
 * TestCaseManager testCaseManager = new TestCaseManager();
 * 
 * if (bankName == null || bankName.trim().isEmpty()) { bankName =
 * generateValidBankName(faker, existingBankNames); }
 * 
 * if (bankName != null && !bankName.trim().isEmpty()) {
 * 
 * BL.clickElement(BL.Createbutton); BL.clickElement(BL.BankName);
 * BL.CLearElement(BL.BankName); BL.enterElement(BL.BankName, bankName);
 * 
 * ++testcaseCount;
 * 
 * boolean bankNameStatus = true; // Assume success initially
 * 
 * try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { bankNameStatus = false; // Set status to false if
 * assertion fails errorMessage = e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Bank Name", bankName, bankNameStatus, errorMessage);
 * 
 * }
 * 
 * if (address != null && !address.trim().isEmpty()) {
 * 
 * BL.enterElement(BL.Address, address); ++testcaseCount;
 * 
 * boolean AddressNameStatus = true; try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { AddressNameStatus = false; errorMessage =
 * e.getMessage(); }
 * 
 * logTestStep(TestcaseNo, "Address Name", address, AddressNameStatus,
 * errorMessage);
 * 
 * }
 * 
 * 
 * if (pincode != null && !pincode.trim().isEmpty()) {
 * BL.clickElement(BL.Pincode); BL.selectDropdownOption(pincode);
 * 
 * ++testcaseCount;
 * 
 * boolean PincodeStatus = true; try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { PincodeStatus = false; errorMessage = e.getMessage(); }
 * 
 * logTestStep(TestcaseNo, "Pincode :", pincode, PincodeStatus, errorMessage);
 * 
 * }
 * 
 * if (gst != null && !gst.trim().isEmpty()) {
 * 
 * BL.clickElement(BL.GST); BL.enterElement(BL.GST, gst);
 * 
 * ++testcaseCount;
 * 
 * boolean GSTStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { GSTStatus = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "GST :", gst, GSTStatus,
 * errorMessage);
 * 
 * }
 * 
 * if (pan != null && !pan.trim().isEmpty()) {
 * 
 * BL.clickElement(BL.PAN); BL.enterElement(BL.PAN, pan); ++testcaseCount;
 * 
 * boolean PANStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { PANStatus = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "PAN :", pan, PANStatus,
 * errorMessage);
 * 
 * }
 * 
 * if (Marsid.contains("E")) { Double Marsid1 = Double.valueOf(Marsid); Marsid =
 * String.format("%.0f", Marsid1); }
 * 
 * if (Marsid != null && !Marsid.trim().isEmpty()) {
 * 
 * 
 * BL.clickElement(BL.Marsid); BL.enterElement(BL.Marsid, Marsid);
 * 
 * ++testcaseCount;
 * 
 * boolean MarsidStatus = true; // Assume success initially
 * logTestStep(TestcaseNo, "Marsid :", Marsid, MarsidStatus, errorMessage);
 * 
 * }
 * 
 * if (StatementFrequency != null && !StatementFrequency.trim().isEmpty()) {
 * 
 * BL.clickElement(BL.StatementFrequency);
 * 
 * BL.selectDropdownOption(StatementFrequency);
 * 
 * ++testcaseCount;
 * 
 * boolean StatementFrequencyStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { StatementFrequencyStatus = false; errorMessage =
 * e.getMessage(); // Capture error message } logTestStep(TestcaseNo,
 * "Statement Frequency :", StatementFrequency, StatementFrequencyStatus,
 * errorMessage);
 * 
 * }
 * 
 * if (StatementType != null && !StatementType.trim().isEmpty()) {
 * 
 * BL.clickElement(BL.StatementType);
 * 
 * BL.selectDropdownOption(StatementType);
 * 
 * ++testcaseCount;
 * 
 * boolean StatementTypeStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { StatementTypeStatus = false; errorMessage =
 * e.getMessage(); // Capture error message } logTestStep(TestcaseNo,
 * "Statement Type :", StatementType, StatementTypeStatus, errorMessage);
 * 
 * }
 * 
 * for (String domain : domains) { if (domain != null &&
 * !domain.trim().isEmpty()) { BL.clickElement(BL.Domain);
 * BL.enterElement(BL.Domain, domain); performTabKeyPress(); ++testcaseCount;
 * 
 * boolean domainStatus = true; try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { domainStatus = false; errorMessage = e.getMessage(); //
 * Capture error message }
 * 
 * logTestStep(TestcaseNo, "Domain", domain, domainStatus, errorMessage); } }
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * BL.isElementDisplayed(BL.AdminUserDetails, "Communication Info Page");
 * 
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "General Info", NextstepStatus,
 * errorMessage);
 * 
 * return bankName; } catch (Exception e) { // Use the exception handler to log
 * and handle exceptions gracefully ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "General Info"); throw e; // Re-throw the
 * exception after handling }
 * 
 * }
 * 
 * // private String generateValidBankName(Faker faker) { // String bankName; //
 * // do { // // Generate a random bank name // bankName =
 * faker.company().name(); // // // Check if the generated name meets the
 * required conditions // } while (bankName.length() < 7 || bankName.length() >
 * 30 || existingBankNames.contains(bankName) // ||
 * !bankName.matches("[a-zA-Z\\s]+")); // // // Return a valid and unique bank
 * name // return bankName; // }
 * 
 * // private String generateValidBankName(Faker faker, Set<String>
 * existingBankNames) { // String bankName; // // // Strict validation to ensure
 * uniqueness // do { // // Generate a random bank name // bankName =
 * faker.company().name().trim(); // // // Ensure the generated name meets all
 * conditions: // // 1. Length between 7 and 30 characters // // 2. Only
 * alphabetic characters and spaces (ignoring extra spaces) // // 3. Not already
 * present in the existingBankNames set // } while (bankName.length() < 7 ||
 * bankName.length() > 30 || existingBankNames.contains(bankName.toLowerCase())
 * // case-insensitive // // comparison // ||
 * !bankName.matches("[a-zA-Z\\s]+")); // // // Add the generated bank name to
 * the existing set to avoid future duplicates //
 * existingBankNames.add(bankName.toLowerCase()); // // // Return a valid and
 * unique bank name // return bankName; // } //
 * 
 * // private String generateValidBankName(Faker faker, Set<String>
 * existingBankNames) { // String bankName; // int attempts = 0; // final int
 * maxAttempts = 100; // // do { // bankName = faker.company().name().trim(); //
 * attempts++; // // if (attempts >= maxAttempts) { // throw new
 * IllegalStateException( //
 * "Unable to generate a unique valid bank name after " + maxAttempts +
 * " attempts"); // } // // } while (bankName.length() < 7 || bankName.length()
 * > 30 || existingBankNames.contains(bankName.toLowerCase()) // ||
 * !bankName.matches("[a-zA-Z\\s]+")); // //
 * existingBankNames.add(bankName.toLowerCase()); // // return bankName; // }
 * 
 * private String generateValidBankName(Faker faker, Set<String>
 * existingBankNames) { String bankName; int attempts = 0; final int maxAttempts
 * = 100;
 * 
 * do { // Generate a bank name bankName = faker.company().name().trim();
 * attempts++;
 * 
 * // Check if max attempts have been reached if (attempts >= maxAttempts) {
 * throw new IllegalStateException(
 * "Unable to generate a unique valid bank name after " + maxAttempts +
 * " attempts"); }
 * 
 * } while (!isValidBankName(bankName, existingBankNames));
 * 
 * // Store the valid bank name in the set to avoid future duplicates
 * existingBankNames.add(bankName.toLowerCase());
 * 
 * return bankName; }
 * 
 * // Helper method to validate bank name private boolean isValidBankName(String
 * bankName, Set<String> existingBankNames) { // Check length if
 * (bankName.length() < 7 || bankName.length() > 30) { return false; }
 * 
 * // Check for duplicate variations String baseName = bankName.toLowerCase();
 * if (existingBankNames.contains(baseName)) { return false; }
 * 
 * // Check for variations (like "BANK ONE", "BANK TWO") for (int i = 1; i <=
 * 100; i++) { // Assuming a maximum of 100 variations String variation =
 * baseName + " " + i; if (existingBankNames.contains(variation)) { return
 * false; } }
 * 
 * // Check if the name contains only letters and spaces return
 * bankName.matches("[a-zA-Z\\s]+"); }
 * 
 * // private void logTestStep(int testcaseCount, String fieldName, String
 * fieldValue,Boolean status) { // String message = "Test Case " + testcaseCount
 * + ": " + fieldName + " with value '" + fieldValue + "' passed."; // // // Log
 * to Extent Report // ExtentCucumberAdapter.addTestStepLog(message); //
 * List<String> keys = new ArrayList<>(); // List<String> values = new
 * ArrayList<>(); // // TestCaseManager testCaseManager = new TestCaseManager();
 * // // Start a new test case // testCaseManager.startNewTestCase(message,
 * true); // // // Add field name and value to the lists // keys.add(fieldName);
 * // values.add(fieldValue); // // testCaseManager.logInputDataa(keys,values);
 * // Allure.step("Test case for row " + testcaseCount); //
 * testCaseManager.endTestCase(status); // // Optionally, print to console for
 * debugging // System.out.println(message); // }
 * 
 * // private void logTestStep(int testcaseCount,String fieldName, String
 * ActualValue,String ExpectedValue, Boolean status, String errorMessage) { //
 * String message = "Test Case " + testcaseCount + ": " + fieldName +
 * " with value '" + ExpectedValue + "' " + (status ? "passed." : "failed."); //
 * // // Log to Extent Report // ExtentCucumberAdapter.addTestStepLog(message);
 * // // List<String> keys = new ArrayList<>(); // List<String> values = new
 * ArrayList<>(); // // TestCaseManager testCaseManager = new TestCaseManager();
 * // // // Start a new test case // testCaseManager.startNewTestCase(message,
 * status); // // // Add field name and value to the lists //
 * keys.add("Expected Value : "+fieldName); // values.add(ExpectedValue); //
 * keys.add("Actual Value : "+fieldName); // values.add(ActualValue); // //
 * testCaseManager.logInputDataa(keys, values); //
 * Allure.step("Test case for row " + testcaseCount); //
 * testCaseManager.endTestCase(status); // // // Log error message if status is
 * false // if (!status && errorMessage != null) { // // Log the assertion error
 * message // ExtentCucumberAdapter.addTestStepLog("Error: " + errorMessage); //
 * } // // // Optionally, print to console for debugging //
 * System.out.println(message); // }
 * 
 * private void logTestStep(int testcaseCount, String fieldName, String
 * fieldValue, Boolean status, String errorMessage) { String message =
 * "BO Test Case " + testcaseCount + ": " + fieldName + " with value '" +
 * fieldValue + "' " + (status ? "passed." : "failed.");
 * 
 * // Log to Extent Report ExtentCucumberAdapter.addTestStepLog(message);
 * 
 * List<String> keys = new ArrayList<>(); List<String> values = new
 * ArrayList<>();
 * 
 * TestCaseManager testCaseManager = new TestCaseManager();
 * 
 * // Start a new test case testCaseManager.startNewTestCase(message, status);
 * 
 * // Add field name and value to the lists keys.add(fieldName);
 * values.add(fieldValue);
 * 
 * testCaseManager.logInputDataa(keys, values); Allure.step("Test case for row "
 * + testcaseCount); testCaseManager.endTestCase(status);
 * 
 * // Log error message if status is false if (!status && errorMessage != null)
 * { // Log the assertion error message
 * ExtentCucumberAdapter.addTestStepLog("Error: " + errorMessage); }
 * 
 * // Optionally, print to console for debugging System.out.println(message); }
 * 
 * // Method to fill Communication Details private void
 * fillCommunicationDetails(Map<String, String> testData, int TestcaseNo) throws
 * InterruptedException, AWTException {
 * 
 * try {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * int testcaseCount = 0; String errorMessage =
 * "The data does not match or is empty.";
 * 
 * String CommName = testData.get("Communication Name"); String CommPosition =
 * testData.get("Communication Position"); String CommMobileNumber =
 * testData.get("Communication MobileNumber"); String CommEmailid =
 * testData.get("Communication EmailId"); String ADUSer =
 * testData.get("AD User");
 * 
 * BL.clickElement(BL.CommunicationInfo);
 * 
 * BL.clickElement(BL.AddButton);
 * 
 * 
 * if (CommName != null && !CommName.trim().isEmpty()) {
 * 
 * BL.clickElement(BL.ClickonCommuName); BL.enterElement(BL.ClickonCommuName,
 * CommName);
 * 
 * ++testcaseCount;
 * 
 * boolean CommunicationNameStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { CommunicationNameStatus = false; errorMessage =
 * e.getMessage(); // Capture error message } logTestStep(TestcaseNo,
 * "Communication Name", CommName, CommunicationNameStatus, errorMessage);
 * 
 * }
 * 
 * if (CommPosition != null && !CommPosition.trim().isEmpty()) {
 * 
 * 
 * 
 * BL.clickElement(BL.ClickonCommuPosition);
 * BL.enterElement(BL.ClickonCommuPosition, CommPosition);
 * 
 * ++testcaseCount;
 * 
 * boolean CommunicationPositionStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { CommunicationPositionStatus = false; errorMessage =
 * e.getMessage(); // Capture error message } logTestStep(TestcaseNo,
 * "Communication Position", CommPosition, CommunicationPositionStatus,
 * errorMessage);
 * 
 * }
 * 
 * if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) { Faker
 * faker = new Faker();
 * 
 * // Generate a valid mobile number starting with 9, 8, 7, or 6 String
 * firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6,
 * 7, 8, or 9 String remainingDigits = faker.number().digits(9); // Generate 9
 * random digits String communicationMobileNumber = firstDigit +
 * remainingDigits;
 * 
 * BL.clickElement(BL.ClickonCommuMobileNumber);
 * BL.enterElement(BL.ClickonCommuMobileNumber, communicationMobileNumber);
 * 
 * ++testcaseCount;
 * 
 * boolean CommunicationMobileNumberStatus = true; // Assume success initially
 * try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { CommunicationMobileNumberStatus = false; errorMessage =
 * e.getMessage(); // Capture error message } logTestStep(TestcaseNo,
 * "Communication MobileNumber", communicationMobileNumber,
 * CommunicationMobileNumberStatus, errorMessage);
 * 
 * }
 * 
 * if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {
 * 
 * Faker faker = new Faker();
 * 
 * // Generate a random email address with @gmail.com String randomEmailPrefix =
 * faker.internet().slug(); // Generate a random string for the prefix String
 * Communicationemailid = randomEmailPrefix + "@gmail.com";
 * 
 * BL.clickElement(BL.ClickonCommuEmailId);
 * BL.enterElement(BL.ClickonCommuEmailId, Communicationemailid);
 * 
 * ++testcaseCount;
 * 
 * boolean CommunicationEmailIDStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { CommunicationEmailIDStatus = false; errorMessage
 * = e.getMessage(); // Capture error message } logTestStep(TestcaseNo,
 * "Communication Emailid", Communicationemailid, CommunicationEmailIDStatus,
 * errorMessage);
 * 
 * }
 * 
 * if (ADUSer != null && !ADUSer.trim().isEmpty()) {
 * BL.clickElement(BL.ClickOnAdUsers); BL.selectDropdownOption(ADUSer);
 * 
 * 
 * ++testcaseCount;
 * 
 * boolean CommunicationADUSERStatus = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { CommunicationADUSERStatus = false; errorMessage
 * = e.getMessage(); // Capture error message } logTestStep(TestcaseNo,
 * "AD User", ADUSer, CommunicationADUSERStatus, errorMessage);
 * 
 * }
 * 
 * boolean SaveStatus = true; try {
 * 
 * BL.clickElement(BL.SaveButton);
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { SaveStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Save Button", "Communication Info", SaveStatus,
 * errorMessage);
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * BL.isElementDisplayed(BL.ChannelConfiguration, "Channel Config - Bank");
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "Communication Info", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { // Use the exception handler to log and handle
 * exceptions gracefully ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Communication Info"); throw e; //
 * Re-throw the exception after handling } }
 * 
 * private void fillChannelConfig(Map<String, String> testData, int TestcaseNo)
 * throws InterruptedException, AWTException, IOException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "The data does not match or is empty.";
 * 
 * try { // Initialize BankLocators only once if (BL == null) { BL = new
 * org.Locators.BaseClassLocator(driver); }
 * 
 * // Use cached data for the "Channel Bank" sheet to avoid multiple loads
 * List<Map<String, String>> cachedData = cache.getCachedData("Channel Bank");
 * int numberOfRows = cachedData.size(); System.out.println("Total rows found: "
 * + numberOfRows);
 * 
 * // Loop through each row in the cached data for (int currentRow = 1;
 * currentRow <= numberOfRows; currentRow++) {
 * System.out.println("Running test for row number: " + currentRow);
 * 
 * ArrayList<String> key = new ArrayList<>(); ArrayList<String> value = new
 * ArrayList<>();
 * 
 * // Fetch the current row's data from cache Map<String, String> rowData =
 * cachedData.get(currentRow - 1);
 * 
 * // Retrieve data for each field, handling null or empty values String channel
 * = rowData.getOrDefault("Channel", "").trim(); String network =
 * rowData.getOrDefault("Network", "").trim(); String transactionSet =
 * rowData.getOrDefault("Transaction Sets", "").trim(); String routing =
 * rowData.getOrDefault("Routing", "").trim();
 * 
 * // Clear the key-value arrays before each iteration key.clear();
 * value.clear();
 * 
 * // Process Channel data if (!channel.isEmpty()) { B.ClickonCommercialADD1();
 * B.ClickonCommercialChannel(); BL.selectDropdownOption(channel);
 * key.add("Channel-" + currentRow); value.add(channel); performTabKeyPress();
 * 
 * boolean ChannelStatus = true;
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * ++testcaseCount;
 * 
 * logTestStep(TestcaseNo, "Channel", channel, ChannelStatus, errorMessage);
 * 
 * } else { System.out.println("Channel data is empty for row: " + currentRow);
 * }
 * 
 * // Process Network data if (!network.isEmpty()) { B.clickonNetwork();
 * B.selectDropdownOption(network); key.add("Network-" + currentRow);
 * value.add(network); performTabKeyPress();
 * 
 * boolean NetworkStatus = true;
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * ++testcaseCount;
 * 
 * logTestStep(TestcaseNo, "Network", network, NetworkStatus, errorMessage);
 * 
 * } else { System.out.println("Network data is empty for row: " + currentRow);
 * }
 * 
 * // Process Transaction Set data if (!transactionSet.isEmpty()) {
 * B.clickonTransactionset(); B.selectDropdownOption(transactionSet);
 * key.add("Transaction Set-" + currentRow); value.add(transactionSet);
 * performTabKeyPress();
 * 
 * boolean TransactionStatus = true;
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * ++testcaseCount;
 * 
 * logTestStep(TestcaseNo, "TransactionSet", transactionSet, TransactionStatus,
 * errorMessage); } else {
 * System.out.println("Transaction Set data is empty for row: " + currentRow); }
 * 
 * // Process Routing data if (!routing.isEmpty()) { B.clickonRouting();
 * B.selectDropdownOption(routing); key.add("Routing-" + currentRow);
 * value.add(routing); performTabKeyPress();
 * 
 * boolean RoutingStatus = true;
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * ++testcaseCount;
 * 
 * logTestStep(TestcaseNo, "Routing", routing, RoutingStatus, errorMessage); }
 * else { System.out.println("Routing data is empty for row: " + currentRow); }
 * 
 * boolean SaveStatus = true; try { B.CommuSavebutton();
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { SaveStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Save Button", "Channel Config", SaveStatus,
 * errorMessage);
 * 
 * // Log input data in a structured format LoginInputData(key, value);
 * 
 * }
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnRoutingONUS();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "Channel Config", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { // Use the exception handler to log and handle
 * exceptions gracefully ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Channel Config"); throw e; // Re-throw
 * the exception after handling }
 * 
 * // BL.clickElement(BL.NextStep); // // Handle Assertion Errors for ONUS page
 * // try { // // B.DisplayedOnRoutingONUS(); // } catch (Exception ae) { //
 * takeScreenshotStr("ONUS"); //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // Re-throw to ensure test fails // } }
 * 
 * private void configureONUS(Map<String, String> testData, int TestcaseNo)
 * throws InterruptedException, AWTException, IOException {
 * 
 * try {
 * 
 * String errorMessage = "The data does not match or is empty.";
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * List<Map<String, String>> cachedData = cache.getCachedData("Channel Bank");
 * int numberOfRows = cachedData.size(); System.out.println("Total rows found: "
 * + numberOfRows); int testcaseCount = 0;
 * 
 * for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
 * System.out.println("Running test for row number: " + (currentRow + 1));
 * 
 * Map<String, String> rowData = cachedData.get(currentRow); String POSBIN =
 * rowData.getOrDefault("ONUS Routing POS", "").trim(); String MATMBIN =
 * rowData.getOrDefault("ONUS Routing MATM", "").trim();
 * 
 * if (POSBIN.isEmpty() && MATMBIN.isEmpty()) { System.out
 * .println("Stopping loop as both POSBIN and MATMBIN are empty for row " +
 * (currentRow + 1)); break; // Stop the loop if both values are empty }
 * 
 * if (!POSBIN.isEmpty()) { if (POSBIN.matches("\\d+\\.0")) { POSBIN =
 * POSBIN.substring(0, POSBIN.indexOf(".0")); }
 * 
 * B.ActionOnONUSButton(); B.addbin(); B.ClickonADDBIN();
 * B.EnterOnAddBin(POSBIN); performTabKeyPress(); B.SubmitOnONUS();
 * 
 * boolean POSBINStatus = true;
 * 
 * try { BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { POSBINStatus = false; errorMessage = e.getMessage(); }
 * logTestStep(TestcaseNo, "POS BIN", POSBIN, POSBINStatus, errorMessage); }
 * 
 * if (!MATMBIN.isEmpty()) { if (MATMBIN.matches("\\d+\\.0")) { MATMBIN =
 * MATMBIN.substring(0, MATMBIN.indexOf(".0")); }
 * 
 * B.ActionOnONUSButton2(); B.addbin(); B.ClickonADDBIN();
 * B.EnterOnAddBin(MATMBIN); performTabKeyPress(); B.SubmitOnONUS();
 * 
 * boolean MATMBINSTATUS = true;
 * 
 * try { BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { MATMBINSTATUS = false; errorMessage = e.getMessage(); }
 * logTestStep(TestcaseNo, "MATM BIN", MATMBIN, MATMBINSTATUS, errorMessage);
 * 
 * }
 * 
 * }
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnGlobalFRMParameters();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "ONUS Routing", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { // Use the exception handler to log and handle
 * exceptions gracefully ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "ONUS"); throw e; // Re-throw the
 * exception after handling }
 * 
 * // BL.clickElement(BL.NextStep); // try { // // B.DisplayedOnGlobalFrm(); //
 * } catch (AssertionError ae) { // takeScreenshotStr("GlobalFRM"); //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // } // }
 * 
 * }
 * 
 * // Method to fill Global Form private void fillGlobalForm(Map<String, String>
 * testData, int TestcaseNo) throws InterruptedException {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * String VelocityCheckMinutes = testData.get("Velocity Check Minutes");
 * 
 * String VelocityCheckCount = testData.get("Velocity Check Count");
 * 
 * String CashPOSCount = testData.get("CashPOS Count");
 * 
 * String MicroATMCount = testData.get("Micro ATM Count");
 * 
 * String card = testData.get("International Card Acceptance");
 * 
 * String ICADAILY = testData.get("ICA Daily");
 * 
 * String ICAWEEKLY = testData.get("ICA Weekly");
 * 
 * String ICAMonthly = testData.get("ICA Monthly");
 * 
 * String POSDAILY = testData.get("POS Daily");
 * 
 * String POSWEEKLY = testData.get("POS Weekly");
 * 
 * String POSMonthly = testData.get("POS Monthly");
 * 
 * String POSMinimum = testData.get("POS Minimum");
 * 
 * String POSMaximum = testData.get("POS Maximum");
 * 
 * String UPIDAILY = testData.get("UPI Daily");
 * 
 * String UPIWEEKLY = testData.get("UPI Weekly");
 * 
 * String UPIMonthly = testData.get("UPI Monthly");
 * 
 * String UPIMinimum = testData.get("UPI Minimum");
 * 
 * String UPIMaximum = testData.get("UPI Maximum");
 * 
 * String AEPSDAILY = testData.get("AEPS Daily");
 * 
 * String AEPSWEEKLY = testData.get("AEPS Weekly");
 * 
 * String AEPSMonthly = testData.get("AEPS Monthly");
 * 
 * String AEPSMinimum = testData.get("AEPS Minimum");
 * 
 * String AEPSMaximum = testData.get("AEPS Maximum");
 * 
 * String MATMDAILY = testData.get("MATM Daily");
 * 
 * String MATMWEEKLY = testData.get("MATM Weekly");
 * 
 * String MATMMonthly = testData.get("MATM Monthly");
 * 
 * String MATMMinimum = testData.get("MATM Minimum");
 * 
 * String MATMMaximum = testData.get("MATM Maximum");
 * 
 * Thread.sleep(10000);
 * 
 * int testcaseCount = 0;
 * 
 * String errorMessage = "Invalid Format";
 * 
 * try {
 * 
 * B.CLickOnglobalfrm();
 * 
 * B.checkboxGlobalfrm();
 * 
 * if (VelocityCheckMinutes != null && !VelocityCheckMinutes.trim().isEmpty()) {
 * 
 * // Perform the actions for the Velocity Check Minutes
 * B.ClickOnVelocityCheckMinute();
 * B.EnterOnVelocityCheckMinute(VelocityCheckMinutes);
 * 
 * // Log the input data logInputData("Velocity Check Minutes",
 * VelocityCheckMinutes);
 * 
 * // Increment the test case count ++testcaseCount;
 * 
 * boolean Status1 = true; // Assume success initially try { // Check if there
 * is an invalid format BL.isElementNotDisplayed(BL.InvalidFormat,
 * "Invalid Format"); } catch (AssertionError e) { // If an AssertionError
 * occurs, set the status to false and capture the error // message Status1 =
 * false; errorMessage = e.getMessage(); }
 * 
 * // Log the test step with the test case number, field, input value, status,
 * and // error message (if any) logTestStep(TestcaseNo,
 * "Velocity Check Minutes", VelocityCheckMinutes, Status1, errorMessage); }
 * 
 * if (VelocityCheckCount != null && !VelocityCheckCount.trim().isEmpty()) { //
 * if (VelocityCheckCount != null && VelocityCheckCount.matches("\\d+\\.0")) {
 * // VelocityCheckCount = VelocityCheckCount.substring(0,
 * VelocityCheckCount.indexOf(".0")); B.ClickOnVelocityCheckCount();
 * 
 * B.EnterOnVelocityCheckCount(VelocityCheckCount);
 * 
 * logInputData("Velocity Check Count", VelocityCheckCount);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Velocity Check Count",
 * VelocityCheckCount, Status, errorMessage);
 * 
 * }
 * 
 * if (CashPOSCount != null && !CashPOSCount.trim().isEmpty()) {
 * B.ClickOnCashpOScount();
 * 
 * B.EnterOnCashpOScount(CashPOSCount);
 * 
 * logInputData("CashPOSCount", CashPOSCount);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "CashPOSCount", CashPOSCount,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (MicroATMCount != null && !MicroATMCount.trim().isEmpty()) {
 * B.ClickOnMicroATMCount();
 * 
 * B.EnterOnMicroATMCount(MicroATMCount);
 * 
 * logInputData("MicroATMCount", MicroATMCount);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "MicroATMCount",
 * MicroATMCount, Status, errorMessage);
 * 
 * }
 * 
 * if (card != null && !card.trim().isEmpty()) {
 * B.ClickOnInternationalcardCount();
 * 
 * B.selectDropdownOption(card);
 * 
 * logInputData("International Card Acceptance", card);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "International Card Acceptance", card, Status, errorMessage);
 * 
 * }
 * 
 * //ICA
 * 
 * if (ICADAILY != null && !ICADAILY.trim().isEmpty()) { B.ClickonICAdaily();
 * 
 * B.EnteronICAdaily(ICADAILY);
 * 
 * logInputData("ICA DAILY", ICADAILY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "ICA DAILY", ICADAILY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (ICAWEEKLY != null && !ICAWEEKLY.trim().isEmpty()) { B.ClickonICAWeekly();
 * 
 * B.EnteronICAWeekly(ICAWEEKLY);
 * 
 * logInputData("ICA WEEKLY", ICAWEEKLY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "ICA WEEKLY", ICAWEEKLY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (ICAMonthly != null && !ICAMonthly.trim().isEmpty()) {
 * B.ClickonICAMonthly();
 * 
 * B.EnteronICAMonthly(ICAMonthly);
 * 
 * logInputData("ICA Monthly", ICAMonthly);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "ICA Monthly", ICAMonthly,
 * Status, errorMessage);
 * 
 * }
 * 
 * //POS
 * 
 * if (POSDAILY != null && !POSDAILY.trim().isEmpty()) { B.ClickonPosdaily();
 * 
 * B.ClearonPosdaily();
 * 
 * B.EnteronPosdaily(POSDAILY);
 * 
 * logInputData("POS DAILY", POSDAILY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "POS DAILY", POSDAILY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (POSWEEKLY != null && !POSWEEKLY.trim().isEmpty()) { B.ClickonPosWeekly();
 * 
 * B.ClearonPosWeekly();
 * 
 * B.EnteronPosWeekly(POSWEEKLY);
 * 
 * logInputData("POS WEEKLY", POSWEEKLY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "POS WEEKLY", POSWEEKLY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (POSMonthly != null && !POSMonthly.trim().isEmpty()) {
 * B.ClickonPosMonthly();
 * 
 * B.ClearonPosMonthly();
 * 
 * B.EnteronPosMonthly(POSMonthly);
 * 
 * logInputData("POS Monthly", POSMonthly);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "POS Monthly", POSMonthly,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (POSMinimum != null && !POSMinimum.trim().isEmpty()) {
 * B.ClickonPOSMinimum();
 * 
 * B.ClearonPOSMinimum();
 * 
 * B.EnteronPOSMinimum(POSMinimum);
 * 
 * logInputData("POS Minimum", POSMinimum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "POS Minimum", POSMinimum,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (POSMaximum != null && !POSMaximum.trim().isEmpty()) {
 * B.ClickonPOSMaximum();
 * 
 * B.ClearonPOSMaximum();
 * 
 * B.EnteronPOSMaximum(POSMaximum);
 * 
 * logInputData("POS Maximum", POSMaximum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "POS Maximum", POSMaximum,
 * Status, errorMessage);
 * 
 * }
 * 
 * //UPI
 * 
 * if (UPIDAILY != null && !UPIDAILY.trim().isEmpty()) { B.ClickonUPIdaily();
 * 
 * B.ClearonUPIdaily();
 * 
 * B.EnteronUPIdaily(UPIDAILY);
 * 
 * logInputData("UPI DAILY", UPIDAILY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "UPI DAILY", UPIDAILY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (UPIWEEKLY != null && !UPIWEEKLY.trim().isEmpty()) { B.ClickonUPIWeekly();
 * 
 * B.ClearonUPIWeekly();
 * 
 * B.EnteronUPIWeekly(UPIWEEKLY);
 * 
 * logInputData("UPI WEEKLY", UPIWEEKLY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "UPI WEEKLY", UPIWEEKLY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (UPIMonthly != null && !UPIMonthly.trim().isEmpty()) {
 * B.ClickonUPIMonthly();
 * 
 * B.ClearonUPIMonthly();
 * 
 * B.EnteronUPIMonthly(UPIMonthly);
 * 
 * logInputData("UPI Monthly", UPIMonthly);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "UPI Monthly", UPIMonthly,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (UPIMinimum != null && !UPIMinimum.trim().isEmpty()) {
 * B.ClickonUPIMinimum();
 * 
 * B.ClearonUPIMinimum();
 * 
 * B.EnteronUPIMinimum(UPIMinimum);
 * 
 * logInputData("UPI Minimum", UPIMinimum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "UPI Minimum", UPIMinimum,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (UPIMaximum != null && !UPIMaximum.trim().isEmpty()) {
 * 
 * B.ClickonUPIMaximum();
 * 
 * B.ClearonUPIMaximum();
 * 
 * B.EnteronUPIMaximum(UPIMaximum);
 * 
 * logInputData("UPI Maximum", UPIMaximum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "UPI Maximum", UPIMaximum,
 * Status, errorMessage);
 * 
 * }
 * 
 * //AEPS
 * 
 * if (AEPSDAILY != null && !AEPSDAILY.trim().isEmpty()) { B.ClickonAEPSdaily();
 * 
 * B.ClearonAEPSdaily();
 * 
 * B.EnteronAEPSdaily(AEPSDAILY);
 * 
 * logInputData("AEPS DAILY", AEPSDAILY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "AEPS DAILY", AEPSDAILY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (AEPSWEEKLY != null && !AEPSWEEKLY.trim().isEmpty()) {
 * B.ClickonAEPSWeekly();
 * 
 * B.ClearonAEPSWeekly();
 * 
 * B.EnteronAEPSWeekly(AEPSWEEKLY);
 * 
 * logInputData("AEPS WEEKLY", AEPSWEEKLY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "AEPS WEEKLY", AEPSWEEKLY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (AEPSMonthly != null && !AEPSMonthly.trim().isEmpty()) {
 * B.ClickonAEPSMonthly();
 * 
 * B.ClearonAEPSMonthly();
 * 
 * B.EnteronAEPSMonthly(AEPSMonthly);
 * 
 * logInputData("AEPS Monthly", AEPSMonthly);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "AEPS Monthly", AEPSMonthly,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (AEPSMinimum != null && !AEPSMinimum.trim().isEmpty()) {
 * B.ClickonAEPSMinimum();
 * 
 * B.ClearonAEPSMinimum();
 * 
 * B.EnteronAEPSMinimum(AEPSMinimum);
 * 
 * logInputData("AEPS Minimum", AEPSMinimum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "AEPS Minimum", AEPSMinimum,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (AEPSMaximum != null && !AEPSMaximum.trim().isEmpty()) {
 * 
 * B.ClickonAEPSMaximum();
 * 
 * B.ClearonAEPSMaximum();
 * 
 * B.EnteronAEPSMaximum(AEPSMaximum);
 * 
 * logInputData("AEPS Maximum", AEPSMaximum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "AEPS Maximum", AEPSMaximum,
 * Status, errorMessage);
 * 
 * }
 * 
 * //MATM
 * 
 * if (MATMDAILY != null && !MATMDAILY.trim().isEmpty()) { B.ClickonMATMdaily();
 * 
 * B.ClearonMATMdaily();
 * 
 * B.EnteronMATMdaily(MATMDAILY);
 * 
 * logInputData("MATM DAILY", MATMDAILY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "MATM DAILY", MATMDAILY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (MATMWEEKLY != null && !MATMWEEKLY.trim().isEmpty()) {
 * B.ClickonMATMWeekly();
 * 
 * B.ClearonMATMWeekly();
 * 
 * B.EnteronMATMWeekly(MATMWEEKLY);
 * 
 * logInputData("MATM WEEKLY", MATMWEEKLY);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "MATM WEEKLY", MATMWEEKLY,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (MATMMonthly != null && !MATMMonthly.trim().isEmpty()) {
 * B.ClickonMATMMonthly();
 * 
 * B.ClearonMATMMonthly();
 * 
 * B.EnteronMATMMonthly(MATMMonthly);
 * 
 * logInputData("MATM Monthly", MATMMonthly);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "MATM Monthly", MATMMonthly,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (MATMMinimum != null && !MATMMinimum.trim().isEmpty()) {
 * B.ClickonMATMMinimum();
 * 
 * B.ClearonMATMMinimum();
 * 
 * B.EnteronMATMMinimum(MATMMinimum);
 * 
 * logInputData("MATM Minimum", MATMMinimum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "MATM Minimum", MATMMinimum,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (MATMMaximum != null && !MATMMaximum.trim().isEmpty()) {
 * 
 * B.ClickonMATMMaximum();
 * 
 * B.ClearonMATMMaximum();
 * 
 * B.EnteronMATMMaximum(MATMMaximum);
 * 
 * logInputData("MATM Maximum", MATMMaximum);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "MATM Maximum", MATMMaximum,
 * Status, errorMessage);
 * 
 * }
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnInterchangePlan();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "Global FRM", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Global FRM"); throw e; }
 * 
 * // try { // BL.clickElement(BL.NextStep); // // B.DisplayedOnCommericial();
 * // // } catch (Exception ae) { // takeScreenshotStr("Commerical"); // Take
 * screenshot on assertion error //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // }
 * 
 * }
 * 
 * // Method to configure Commercial private void
 * configureCommercialInterChange(Map<String, String> testData, int TestcaseNo)
 * throws Exception { try {
 * 
 * int testcaseCount = 0; String errorMessagee =
 * "The data does not match or is empty.";
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * // Fetch cached data from Excel List<Map<String, String>> cachedData =
 * cache.getCachedData("Commercial"); // Assuming "Commercial" is the // key for
 * your data int numberOfRows = cachedData.size();
 * System.out.println("Total rows found: " + numberOfRows);
 * 
 * // Loop through all the rows for (int currentRow = 0; currentRow <
 * numberOfRows; currentRow++) { // Adjusted index to start from 0
 * System.out.println("Running test for row number: " + (currentRow + 1));
 * 
 * // Fetch the current row's data Map<String, String> testData1 =
 * cachedData.get(currentRow); System.out.println("Test data: " + testData);
 * 
 * // Extract data for each field String channel =
 * testData1.getOrDefault("Interchange Channel", "").trim(); String pricingPlan
 * = testData1.getOrDefault("Interchange Pricing Plan", "").trim();
 * 
 * // Prepare lists to log the key-value pairs ArrayList<String> key = new
 * ArrayList<>(); ArrayList<String> value = new ArrayList<>();
 * 
 * // Process each field if valid processField(channel, "Interchange Channel",
 * key, value, currentRow + 1, () -> { B.clickOnCommericial();
 * B.ClickonCommercialADD1(); // Click 'Add' button for the channel
 * B.ClickonCommercialChannel(); // Click on the channel dropdown
 * B.selectDropdownOption(channel); String errorMessage =
 * "The data does not match or is empty.";
 * 
 * boolean Status = true; logTestStep(TestcaseNo, "Interchange Channel",
 * channel, Status, errorMessage);
 * 
 * });
 * 
 * processField(pricingPlan, "Interchange Pricing Plan", key, value, currentRow
 * + 1, () -> { B.CLickONPricingPlanInterchange(); // Click on the pricing plan
 * dropdown B.selectDropdownOption(pricingPlan); // Select pricing plan from
 * dropdown String errorMessage = "The data does not match or is empty.";
 * boolean Status = true; logTestStep(TestcaseNo, "Interchange Pricing Plan",
 * pricingPlan, Status, errorMessage);
 * 
 * });
 * 
 * boolean SaveStatus = true; try { B.ClickOnCommercialSave();
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { SaveStatus = false; errorMessagee =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Save Button", "Commercial Interchange", SaveStatus,
 * errorMessagee);
 * 
 * // Log the inputs LoginInputData(key, value); }
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Commercial"); throw e; } }
 * 
 * private void processField(String fieldData, String fieldName,
 * ArrayList<String> key, ArrayList<String> value, int currentRow, Runnable
 * action) throws InterruptedException, AWTException { if
 * (isValidInput1(fieldData)) { action.run(); // Perform the specific action for
 * the field key.add(fieldName + "-" + currentRow); value.add(fieldData); //
 * performTabKeyPress(); // Ensure to move to the next field } else {
 * System.out.println(fieldName + " data is null or empty for row: " +
 * currentRow); } }
 * 
 * // Helper method to validate input private boolean isValidInput1(String
 * input) { return input != null && !input.trim().isEmpty(); }
 * 
 * private void configureCommercialBankOnboarding(Map<String, String> testData,
 * int TestcaseNo) throws Exception {
 * 
 * try {
 * 
 * int testcaseCount = 0; String errorMessagee =
 * "The data does not match or is empty."; BL = new
 * org.Locators.BaseClassLocator(driver);
 * 
 * List<Map<String, String>> cachedData = cache.getCachedData("Commercial"); int
 * numberOfRows = cachedData.size(); System.out.println("Total rows found: " +
 * numberOfRows);
 * 
 * for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
 * System.out.println("Running test for row number: " + (currentRow + 1));
 * 
 * Map<String, String> testData1 = cachedData.get(currentRow);
 * System.out.println("Test data: " + testData);
 * 
 * String channel = testData1.getOrDefault("Commercial Channel", "").trim();
 * String pricingPlan = testData1.getOrDefault("Commercial Pricing Plan",
 * "").trim();
 * 
 * ArrayList<String> key = new ArrayList<>(); ArrayList<String> value = new
 * ArrayList<>();
 * 
 * processField(channel, "Bank Onboarding Commercial Channel", key, value,
 * currentRow + 1, () -> { B.clickOnCommericial(); B.ClickonCommercialADD2();
 * B.ClickonCommercialChannel(); B.selectDropdownOption(channel);
 * 
 * boolean Status = true; String errorMessage =
 * "The data does not match or is empty."; logTestStep(TestcaseNo,
 * "Bank Onboarding Commercial Channel", channel, Status, errorMessage);
 * 
 * });
 * 
 * processField(pricingPlan, "Pricing Plan", key, value, currentRow + 1, () -> {
 * B.CLickONPricingPlanBankOnboarding(); B.selectDropdownOption(pricingPlan);
 * String errorMessage = "The data does not match or is empty."; boolean Status
 * = true; logTestStep(TestcaseNo, "Bank Onboarding Pricing Plan", pricingPlan,
 * Status, errorMessage); });
 * 
 * boolean SaveStatus = true; try { B.ClickOnCommercialSave();
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { SaveStatus = false; errorMessagee =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Save Button", "Commercial-BankOnboarding",
 * SaveStatus, errorMessagee);
 * 
 * // Log the inputs LoginInputData(key, value); }
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnBankDetails();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessagee =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "Commercial", NextstepStatus,
 * errorMessagee);
 * 
 * } catch (Exception e) { // Use the exception handler to log and handle
 * exceptions gracefully ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Commercial"); throw e; // Re-throw the
 * exception after handling }
 * 
 * // try { // // BL.clickElement(BL.NextStep); // //
 * B.DisplayedOnBankDetails(); // // } catch (Exception ae) { //
 * takeScreenshotStr("Settlement Info"); // Take screenshot on assertion error
 * // ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
 * "Assertion failed: " + ae.getMessage()); // throw ae; // }
 * 
 * }
 * 
 * // Method to fill Settlement Info private void fillSettlementInfo(Map<String,
 * String> testData, int TestcaseNo) throws InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "The data does not match or is empty.";
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * String channel = testData.get("Settlement Channel"); String Account =
 * testData.get("Account Type"); String IFSCCode = testData.get("IFSC Code");
 * 
 * String BanKAccountNumber = testData.get("Bank Account Number"); String type =
 * testData.get("Settlement Type");
 * 
 * try {
 * 
 * B.clickOnSettlementInfo();
 * 
 * B.ClickOnSettlementInfoADD();
 * 
 * if (channel != null && !channel.trim().isEmpty()) {
 * 
 * B.ClickOnSettlementChannel();
 * 
 * B.selectDropdownOption(channel);
 * 
 * logInputData("Settlement Channel", B.getSelectOnSettlementChannelPOS());
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Settlement Channel",
 * channel, Status, errorMessage);
 * 
 * }
 * 
 * if (Account != null && !Account.trim().isEmpty()) {
 * B.ClickOnSettlementAccountType();
 * 
 * B.selectDropdownOption(Account);
 * 
 * logInputData("Settlement Type", B.getSelectOnSettlementAccountTypeCurrent());
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Settlement AccountType",
 * Account, Status, errorMessage);
 * 
 * }
 * 
 * if (BanKAccountNumber != null && !BanKAccountNumber.trim().isEmpty()) {
 * B.ClickOnBankAccountNumber(); B.EnterOnBankAccountNumber(BanKAccountNumber);
 * logInputData("BanK Account Number", BanKAccountNumber);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "BanKAccountNumber",
 * BanKAccountNumber, Status, errorMessage);
 * 
 * }
 * 
 * if (IFSCCode != null && !IFSCCode.trim().isEmpty()) {
 * 
 * B.ClickOnIFSCCode();
 * 
 * B.selectDropdownOption(IFSCCode);
 * 
 * performTabKeyPress();
 * 
 * logInputData("IFSC Code", B.getSelectOnIFSCCodeBHG());
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "IFSC Code", IFSCCode,
 * Status, errorMessage);
 * 
 * }
 * 
 * boolean SaveStatus = true; try { B.ClickOnCommercialSave();
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { SaveStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Save Button", "Commercial", SaveStatus,
 * errorMessage);
 * 
 * // Log the inputs LoginInputData(key, value);
 * 
 * // B.ClickOnSettlementType(); // // B.selectDropdownOption(type); // //
 * logInputData("Settlement Type", B.getSelectOnSettlementTypeWallet());
 * 
 * if (type != null && !type.trim().isEmpty()) {
 * 
 * B.ClickOnSettlementType();
 * 
 * B.selectDropdownOption(type);
 * 
 * logInputData("Settlement Type", type); ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Settlement Type", type,
 * Status, errorMessage);
 * 
 * }
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnBankonboardingConfig();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "Settlement Info", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Settlement Info"); throw e; }
 * 
 * // BL.clickElement(BL.NextStep); // // try { // //
 * B.DisplayedOnBankonboardingConfig(); // // } catch (Exception ae) { //
 * takeScreenshotStr("Settlement Info"); // Take screenshot on assertion error
 * // ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
 * "Assertion failed: " + ae.getMessage()); // throw ae; // }
 * 
 * }
 * 
 * // Method to configure White Label private void
 * configureWhiteLabel(Map<String, String> testData, int TestcaseNo) throws
 * InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "The data does not match or is empty.";
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * String Bank = testData.get("Bank Own Deployment"); String payfac =
 * testData.get("Payfac Onboarding"); String ISO =
 * testData.get("ISO Onboarding"); String Sales =
 * testData.get("Sales Team Onboarding"); String MaximumNoOfPlatform =
 * testData.get("Maximum No of Platform");
 * 
 * try {
 * 
 * B.clickOnWhiteLabel();
 * 
 * if (Bank != null && !Bank.trim().isEmpty()) {
 * B.ClickOnWhitelabelBankOwnDeployment();
 * 
 * B.selectDropdownOption(Bank);
 * 
 * logInputData("Bank Own Deployment", Bank);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Bank Own Deployment", Bank,
 * Status, errorMessage);
 * 
 * }
 * 
 * if (payfac != null && !payfac.trim().isEmpty()) {
 * B.ClickOnWhitelabelPayfacOnboarding();
 * 
 * B.selectDropdownOption(payfac);
 * 
 * logInputData("Whitelabel Payfac Onboarding", payfac);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "Whitelabel Payfac Onboarding", payfac, Status, errorMessage); }
 * 
 * if (ISO != null && !ISO.trim().isEmpty()) {
 * B.ClickOnWhitelabelISOOnboarding();
 * 
 * B.selectDropdownOption(ISO);
 * 
 * logInputData("Whitelabel ISO Onboarding", ISO);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Whitelabel ISO Onboarding",
 * ISO, Status, errorMessage); }
 * 
 * if (Sales != null && !Sales.trim().isEmpty()) {
 * B.ClickOnWhitelabelSalesTeamOnboarding();
 * 
 * B.selectDropdownOption(Sales);
 * 
 * logInputData("Whitelabel Sales Team Onboarding", Sales);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "Whitelabel Sales Team Onboarding", Sales, Status, errorMessage); }
 * 
 * if (MaximumNoOfPlatform != null && !MaximumNoOfPlatform.trim().isEmpty()) {
 * B.ClickOnMaximumNoofPlatform();
 * B.EnterOnMaximumNoofPlatform(MaximumNoOfPlatform); performTabKeyPress();
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Maximum No Of Platform",
 * MaximumNoOfPlatform, Status, errorMessage); }
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnPaymentBridge();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "Whitelabel", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Whitelabel"); throw e; }
 * 
 * // BL.clickElement(BL.NextStep); // // try { // //
 * B.DisplayedOnPaymentBridge(); // // } catch (Exception ae) { //
 * takeScreenshotStr("Whitelabel"); // Take screenshot on assertion error //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // }
 * 
 * }
 * 
 * // Method to configure Webhooks private void configureWebhooks(Map<String,
 * String> testData, int TestcaseNo) throws InterruptedException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "The data does not match or is empty.";
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * String type = testData.get("Webhook Type"); String webhookURL =
 * testData.get("Webhook url");
 * 
 * try {
 * 
 * B.clickOnWebhooks();
 * 
 * B.ClickOnWebhookADD();
 * 
 * if (type != null && !type.trim().isEmpty()) { B.ClickOnWebhooksType();
 * 
 * B.selectDropdownOption(type);
 * 
 * logInputData("Webhook Type", B.getSelectOnWebhooksType());
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Webhook Type", type, Status,
 * errorMessage); }
 * 
 * if (webhookURL != null && !webhookURL.trim().isEmpty()) {
 * B.ClickOnWebhooksURL(); B.EnterOnWebhooksURL(webhookURL);
 * 
 * logInputData("Webhook URL", webhookURL);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "Webhook URL", webhookURL,
 * Status, errorMessage); }
 * 
 * boolean SaveStatus = true; try { B.ClickOnCommercialSave();
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { SaveStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Save Button", "Webhooks", SaveStatus, errorMessage);
 * 
 * // Log the inputs LoginInputData(key, value);
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnKYCConfig();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "Webhooks", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "Webhooks"); throw e; }
 * 
 * // try { // // B.ClickOnWebhooksSave(); // // } catch (Exception ae) { //
 * takeScreenshotStr("Webhook"); // Take screenshot on assertion error //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // } // // BL.clickElement(BL.NextStep); //
 * try { // // B.DisplayedOnKYCConfig(); // // } catch (Exception ae) { //
 * takeScreenshotStr("Webhook"); // Take screenshot on assertion error //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // }
 * 
 * }
 * 
 * // Method to fill KYC Details private void fillKYCDetails(Map<String, String>
 * testData, int TestcaseNo) throws InterruptedException, AWTException {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * String business = testData.get("Business Type"); String Company =
 * testData.get("Company Proof of Identity"); String IndiPOI =
 * testData.get("Individual Proof of Identity"); String IndiPOA =
 * testData.get("Individual Proof of address"); String IndiBD =
 * testData.get("Individual Bank Document"); String IndiTD =
 * testData.get("Individual Tax Document"); String IndiOD =
 * testData.get("Individual Other Document");
 * 
 * int testcaseCount = 0; String errorMessage =
 * "The data does not match or is empty.";
 * 
 * try {
 * 
 * B.ClickOnWebhookADD();
 * 
 * if (business != null && !business.trim().isEmpty()) {
 * 
 * B.ClickOnKYCBusinessType();
 * 
 * B.selectDropdownOption(business);
 * 
 * performTabKeyPress();
 * 
 * logInputData("KYC Business Type", business);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo, "KYC Business Type",
 * business, Status, errorMessage);
 * 
 * }
 * 
 * if (Company != null && !Company.trim().isEmpty()) {
 * 
 * B.ClickOnProofOfIdentityCompany();
 * 
 * B.selectDropdownOption(Company); performTabKeyPress();
 * 
 * logInputData("Proof Of Identity Company KYC", Company);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "Proof Of Identity Company KYC", Company, Status, errorMessage); }
 * 
 * if (IndiPOI != null && !IndiPOI.trim().isEmpty()) {
 * B.ClickOnProofOfIdentityIndividual();
 * 
 * B.selectDropdownOption(IndiPOI);
 * 
 * performTabKeyPress();
 * 
 * logInputData("Proof of identity Individual KYC", IndiPOI);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "Proof of identity Individual KYC", IndiPOI, Status, errorMessage);
 * 
 * }
 * 
 * if (IndiPOA != null && !IndiPOA.trim().isEmpty()) {
 * B.ClickOnProofOfAddressIndividual();
 * 
 * B.selectDropdownOption(IndiPOA);
 * 
 * performTabKeyPress();
 * 
 * logInputData("Proof of address Individual KYC", IndiPOA);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "Proof of address Individual KYC", IndiPOA, Status, errorMessage); }
 * 
 * if (IndiBD != null && !IndiBD.trim().isEmpty()) {
 * B.ClickOnBankDocumentIndividual();
 * 
 * B.selectDropdownOption(IndiBD);
 * 
 * performTabKeyPress();
 * 
 * logInputData("Bank Document Individual KYC", IndiBD); ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "Bank Document Individual KYC", IndiBD, Status, errorMessage); }
 * 
 * if (IndiTD != null && !IndiTD.trim().isEmpty()) {
 * B.ClickOnTaxDocumentIndividual();
 * 
 * B.selectDropdownOption(IndiTD);
 * 
 * performTabKeyPress();
 * 
 * logInputData("TAX Document Individual KYC", IndiTD);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "TAX Document Individual KYC", IndiTD, Status, errorMessage); }
 * 
 * if (IndiOD != null && !IndiOD.trim().isEmpty()) {
 * B.ClickOnOtherDocumentIndividual();
 * 
 * B.selectDropdownOption(IndiOD);
 * 
 * performTabKeyPress();
 * 
 * logInputData("Other Document Individual KYC", IndiOD);
 * 
 * ++testcaseCount;
 * 
 * boolean Status = true; // Assume success initially try {
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format"); } catch
 * (AssertionError e) { Status = false; errorMessage = e.getMessage(); //
 * Capture error message } logTestStep(TestcaseNo,
 * "Other Document Individual KYC", IndiOD, Status, errorMessage); }
 * 
 * boolean SaveStatus = true; try { B.ClickOnCommercialSave();
 * 
 * BL.isElementNotDisplayed(BL.InvalidFormat, "Invalid Format");
 * 
 * } catch (AssertionError e) { SaveStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Save Button", "KYC-BANK", SaveStatus, errorMessage);
 * 
 * // Log the inputs LoginInputData(key, value);
 * 
 * boolean NextstepStatus = true; try { BL.clickElement(BL.NextStep);
 * 
 * B.DisplayedOnstatusHistory();
 * 
 * } catch (AssertionError e) { NextstepStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "NextStep", "KYC-BANK", NextstepStatus,
 * errorMessage);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "KYC-Bank"); throw e; }
 * 
 * // try { // // B.ClickOnWebhooksSave(); // // } catch (Exception ae) { //
 * takeScreenshotStr("KYC Config"); // Take screenshot on assertion error //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // } // // BL.clickElement(BL.NextStep); //
 * // try { // // B.DisplayedOnstatusHistory(); // // } catch (Exception ae) {
 * // takeScreenshotStr("KYC"); // Take screenshot on assertion error //
 * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Assertion failed: "
 * + ae.getMessage()); // throw ae; // }
 * 
 * }
 * 
 * // Method to submit for verification private void submitForVerification()
 * throws InterruptedException {
 * 
 * B.ClickOnsubmitforverification();
 * 
 * B.Yesforsubmit();
 * 
 * B.OkforSuccessfully(); }
 * 
 * // Utility methods private void performTabKeyPress() throws AWTException {
 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_TAB);
 * robot.keyRelease(KeyEvent.VK_TAB); }
 * 
 * private void logInputData(String fieldName, String fieldValue) {
 * key.add(fieldName); value.add(fieldValue);
 * 
 * }
 * 
 * @Given("I visit the System Verifier Login in Regression using sheetname {string} and rownumber {int}"
 * ) public void i_visit_the_System_verifier_login(String sheetName, int
 * rowNumber) throws InvalidFormatException, IOException, InterruptedException {
 * 
 * try {
 * 
 * // ExcelDataCache cache = ExcelDataCache.getInstance(); List<Map<String,
 * String>> testdata = cache.getCachedData(sheetName);
 * 
 * System.out.println("sheet name: " + testdata);
 * 
 * String userName = testdata.get(rowNumber).get("UserName"); String password =
 * testdata.get(rowNumber).get("Password");
 * 
 * L = new org.Locators.LoginLocators(driver);
 * 
 * L.EnterOnUsername(userName);
 * 
 * L.EnterOnPassword(password);
 * 
 * test = ExtentCucumberAdapter.getCurrentStep();
 * 
 * String styledTable =
 * "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
 * +
 * "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
 * + "<tr><td style='border: 1px solid black;color: black'>" + userName +
 * "</td><td style='border: 1px solid black;color: black'>" + password +
 * "</td></tr>" + "</table>";
 * 
 * Allure.addAttachment("Input Datas", "text/html", new
 * ByteArrayInputStream(styledTable.getBytes()), "html");
 * 
 * String[][] data = { { "UserName", "Password" }, { userName, password },
 * 
 * }; Markup m = MarkupHelper.createTable(data);
 * 
 * // or test.log(Status.PASS, m);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "LoginScreen"); throw e; } }
 * 
 * @Then("the System Verifier completes Bank Onboarding, the system should prompt to verify all steps using the sheet name {string}"
 * ) // public void processAllData1(String sheetName) // throws
 * InvalidFormatException, IOException, InterruptedException, AWTException { //
 * // Set the Excel file and sheet // ExcelUtils.
 * setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx"
 * , // sheetName); // // // Get the total number of non-empty rows // int
 * numberOfRows = ExcelUtils.getRowCount(sheetName); //
 * System.out.println("Total rows found: " + numberOfRows); // for (int
 * rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) { //
 * System.out.println("Running test for row number: " + rowNumber); // //
 * Map<String, String> rowData = ExcelUtils.getRowData(sheetName, rowNumber);
 * //// logInputDataa(rowData); // runTestForRow1(sheetName, rowNumber); // //
 * if (rowNumber == numberOfRows) { //
 * System.out.println("Finished processing the last row. Logging out..."); //
 * performLogout(); // } // } // } // // private void runTestForRow1(String
 * sheetName, int rowNumber) // throws InvalidFormatException, IOException,
 * InterruptedException, AWTException { // // Get data for the specified row //
 * // Map<String, String> testData = ExcelUtils.getRowData(sheetName,
 * rowNumber); // System.out.println("Data for row " + rowNumber + ": " +
 * testData); // // // Execute validation with the extracted row data //
 * validateFieldsForRow1(sheetName, testData); // } // // private void
 * validateFieldsForRow1(String sheetName, Map<String, String> testData) //
 * throws InvalidFormatException, IOException, InterruptedException,
 * AWTException { // BL = new org.Locators.BaseClassLocator(driver); // // //
 * Set implicit wait and page load timeout // // // Fill out various sections //
 * SearchbyBank(testData); // }
 * 
 * public void processAllData1(String sheetName) throws InvalidFormatException,
 * IOException, InterruptedException, AWTException {
 * 
 * // Load data from the cache only once List<Map<String, String>> testData =
 * cache.getCachedData(sheetName);
 * 
 * if (testData == null || testData.isEmpty()) { throw new
 * RuntimeException("No data found in the cache for sheet: " + sheetName); }
 * 
 * int numberOfRows = testData.size(); // Number of rows based on cached data
 * System.out.println("Total rows found: " + numberOfRows);
 * 
 * TestCaseManager testCaseManager = new TestCaseManager();
 * 
 * // Iterate over the cached data for (int rowNumber = 1; rowNumber <=
 * numberOfRows; rowNumber++) {
 * System.out.println("Running test for row number: " + rowNumber);
 * 
 * // Group by row number in Allure
 * testCaseManager.startNewTestSuite(rowNumber);
 * 
 * // Get row data from cache Map<String, String> rowData =
 * testData.get(rowNumber - 1);
 * 
 * try { // Start the test case and log the input data for the row
 * testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
 * testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new
 * ArrayList<>(rowData.values()));
 * 
 * int rowTestCaseCount = runTestForRow1(sheetName, rowData, rowNumber);
 * totalTestCaseCount += rowTestCaseCount; testCaseManager.endTestCase(true); }
 * catch (Exception e) { takeScreenshot(rowNumber);
 * testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent
 * reports Assert.fail("Exception encountered while processing row " + rowNumber
 * + ": " + e.getMessage()); testCaseManager.endTestCase(false); } finally {
 * testCaseManager.endTestSuite(); // End the suite (grouping) for this row }
 * 
 * if (rowNumber == numberOfRows) {
 * System.out.println("Finished processing the last row. Logging out...");
 * performLogout(); } }
 * 
 * logDashboardCount1(); }
 * 
 * private void logDashboardCount1() { String message =
 * "Total Dashboard Count: " + totalTestCaseCount;
 * 
 * ExtentCucumberAdapter.addTestStepLog(message);
 * Allure.parameter("Total Test Case Count", totalTestCaseCount);
 * 
 * System.out.println(message); }
 * 
 * private int runTestForRow1(String sheetName, Map<String, String> testData,
 * int rowNumber) throws Exception {
 * 
 * // Log the test data for the current row System.out.println("Data for row " +
 * rowNumber + ": " + testData);
 * 
 * // Initialize the locators (e.g., BankLocators) BL = new
 * org.Locators.BaseClassLocator(driver);
 * 
 * int testCaseCount = 0;
 * 
 * // Validate fields for the current row using testData testCaseCount +=
 * validateFieldsForRow1(sheetName, testData, rowNumber, testCaseCount);
 * 
 * return testCaseCount;
 * 
 * }
 * 
 * @SuppressWarnings("unused") private int validateFieldsForRow1(String
 * sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)
 * throws Exception {
 * 
 * // Initialize the locators BL = new org.Locators.BaseClassLocator(driver);
 * 
 * // Initialize a counter to track the number of validated fields/sections int
 * validatedFieldsCount = 0; // Bank Details Section validatedFieldsCount +=
 * executeStep1(() -> { try { SearchbyBank(testData, TestcaseNo); } catch
 * (InterruptedException | AWTException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }, "SearchbyBank");
 * 
 * validatedFieldsCount += executeStep(() -> { try { //
 * fillBankDetails(testData, TestcaseNo); GenernalInfoVerified(TestcaseNo); }
 * catch (InterruptedException | AWTException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); } }, "General Info Verified");
 * 
 * // Communication Details Section validatedFieldsCount += executeStep(() -> {
 * try { CommunicationInfoVerified(TestcaseNo); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "Communication Info Verified");
 * 
 * // Channel Config Section validatedFieldsCount += executeStep(() -> { try {
 * ChannelConfigVerified(TestcaseNo); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "Channel Config verified");
 * 
 * // ONUS Section validatedFieldsCount += executeStep(() -> { try {
 * configureONUSVerified(TestcaseNo); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "ONUS Configuration");
 * 
 * // Global Form Section validatedFieldsCount += executeStep(() -> { try {
 * GlobalFormVerified(TestcaseNo); } catch (InterruptedException | AWTException
 * e) { // TODO Auto-generated catch block e.printStackTrace(); } },
 * "Global Form");
 * 
 * // Commercial Section validatedFieldsCount += executeStep(() -> { try {
 * CommercialVerified(TestcaseNo); } catch (Exception e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } }, "Commercial Verfied");
 * // Settlement Info Section validatedFieldsCount += executeStep(() -> { try {
 * SettlementInfoVerified(TestcaseNo); } catch (InterruptedException |
 * AWTException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * }, "Settlement Info Verified");
 * 
 * // White Label Section validatedFieldsCount += executeStep(() -> { try {
 * WhiteLabelVerified(TestcaseNo); } catch (InterruptedException | AWTException
 * e) { // TODO Auto-generated catch block e.printStackTrace(); } },
 * "White Label Configuration Verified");
 * 
 * // Webhooks Section validatedFieldsCount += executeStep(() -> { try {
 * WebhooksVerified(TestcaseNo); } catch (InterruptedException | AWTException e)
 * { // TODO Auto-generated catch block e.printStackTrace(); } },
 * "Webhook Configuration");
 * 
 * // KYC Section validatedFieldsCount += executeStep(() -> { try {
 * KYCDetailsVerified(TestcaseNo); } catch (InterruptedException | AWTException
 * e) { // TODO Auto-generated catch block e.printStackTrace(); } },
 * "KYC Details");
 * 
 * // Final Submission validatedFieldsCount += executeStep(() -> { try {
 * submitForApproval(); } catch (InterruptedException | AWTException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } },
 * "Final Submission - Verified");
 * 
 * // Return the total count of validated fields/sections return
 * validatedFieldsCount; }
 * 
 * private int executeStep1(Runnable step, String stepName) { try { step.run();
 * return 1; // Return 1 for successful execution } catch (Exception e) { //
 * Handle the exception and log the error ExceptionHandler exceptionHandler =
 * new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, stepName); return 0; // Return 0 for
 * failed execution } }
 * 
 * private void SearchbyBank(Map<String, String> testData, int TestcaseNo)
 * throws InterruptedException, AWTException {
 * 
 * String Bankname = testData.get("bankName");
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * key.clear(); value.clear();
 * 
 * Thread.sleep(3000);
 * 
 * B.ClickSearchbyBankName();
 * 
 * Thread.sleep(3000);
 * 
 * B.SearchbyBankName(Bankname);
 * 
 * logInputData("Search By BankName", B.getClickSearchbyBankName());
 * 
 * Thread.sleep(3000);
 * 
 * B.ActionClick();
 * 
 * Thread.sleep(2000);
 * 
 * B.ClickonViewButton();
 * 
 * }
 * 
 * private void GenernalInfoVerified(int TestcaseNo) throws
 * InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true; try {
 * 
 * Thread.sleep(1000); B.CLickOnGenralInfo();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "General Info", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void CommunicationInfoVerified(int TestcaseNo) throws
 * InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try { Thread.sleep(1000); B.CLickOnCommunicationInfo();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "Communication Info", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void ChannelConfigVerified(int TestcaseNo) throws
 * InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true; try { Thread.sleep(1000);
 * B.CLickOnChannelConfig();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "Channel Config", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void configureONUSVerified(int TestcaseNo) throws
 * InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try {
 * 
 * Thread.sleep(1000);
 * 
 * B.CLickOnONUSRouting();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "ONUS Routing", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void GlobalFormVerified(int TestcaseNo) throws InterruptedException,
 * AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try {
 * 
 * Thread.sleep(1000);
 * 
 * B.CLickOnglobalfrm();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "Global FRM", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void CommercialVerified(int TestcaseNo) throws InterruptedException,
 * AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try {
 * 
 * Thread.sleep(1000);
 * 
 * B.clickOnCommericial();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "Commercial", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void SettlementInfoVerified(int TestcaseNo) throws
 * InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try {
 * 
 * Thread.sleep(1000);
 * 
 * B.clickOnSettlementInfo();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "Settlement Info", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void WhiteLabelVerified(int TestcaseNo) throws InterruptedException,
 * AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try { Thread.sleep(1000); B.clickOnWhiteLabel();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "Whitelabel", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void WebhooksVerified(int TestcaseNo) throws InterruptedException,
 * AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try { Thread.sleep(1000);
 * 
 * B.clickOnWebhooks();
 * 
 * B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "Webhooks", verifiedStatus,
 * errorMessage);
 * 
 * }
 * 
 * private void KYCDetailsVerified(int TestcaseNo) throws InterruptedException,
 * AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * try { Thread.sleep(1000); B.VerifiedandNext();
 * 
 * } catch (AssertionError e) { verifiedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Verified", "KYC", verifiedStatus, errorMessage);
 * 
 * }
 * 
 * private void submitForApproval() throws InterruptedException, AWTException {
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Verified Button is not displayed.";
 * 
 * boolean verifiedStatus = true;
 * 
 * B.SubmitforApproval();
 * 
 * B.Yesforsubmit();
 * 
 * B.OkforSuccessfully();
 * 
 * B.CancelApprove();
 * 
 * }
 * 
 * @Given("I visit the System Approver Login in Regression using sheetname {string} and rownumber {int}"
 * ) public void i_visit_the_System_Approver_login(String sheetName, int
 * rowNumber) throws InvalidFormatException, IOException, InterruptedException {
 * 
 * try {
 * 
 * // ExcelDataCache cache = ExcelDataCache.getInstance(); List<Map<String,
 * String>> testdata = cache.getCachedData(sheetName);
 * 
 * System.out.println("sheet name: " + testdata);
 * 
 * String userName = testdata.get(rowNumber).get("UserName"); String password =
 * testdata.get(rowNumber).get("Password");
 * 
 * L = new org.Locators.LoginLocators(driver);
 * 
 * L.EnterOnUsername(userName);
 * 
 * L.EnterOnPassword(password);
 * 
 * test = ExtentCucumberAdapter.getCurrentStep();
 * 
 * String styledTable =
 * "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
 * +
 * "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
 * + "<tr><td style='border: 1px solid black;color: black'>" + userName +
 * "</td><td style='border: 1px solid black;color: black'>" + password +
 * "</td></tr>" + "</table>";
 * 
 * Allure.addAttachment("Input Datas", "text/html", new
 * ByteArrayInputStream(styledTable.getBytes()), "html");
 * 
 * String[][] data = { { "UserName", "Password" }, { userName, password },
 * 
 * }; Markup m = MarkupHelper.createTable(data);
 * 
 * // or test.log(Status.PASS, m);
 * 
 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, "LoginScreen"); throw e; } }
 * 
 * @Then("the System Approver completes Bank Onboarding, the system should prompt to Approve using the sheet name {string}"
 * ) // public void processAllData2(String sheetName) // throws
 * InvalidFormatException, IOException, InterruptedException, AWTException { //
 * // Set the Excel file and sheet // ExcelUtils.
 * setExcelFile("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx"
 * , // sheetName); // // // Get the total number of non-empty rows // int
 * numberOfRows = ExcelUtils.getRowCount(sheetName); //
 * System.out.println("Total rows found: " + numberOfRows); // for (int
 * rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) { //
 * System.out.println("Running test for row number: " + rowNumber); // //
 * Map<String, String> rowData = ExcelUtils.getRowData(sheetName, rowNumber);
 * //// logInputDataa(rowData); // runTestForRow2(sheetName, rowNumber); // //
 * if (rowNumber == numberOfRows) { //
 * System.out.println("Finished processing the last row. Logging out..."); //
 * performLogout(); // } // } // } // // private void runTestForRow2(String
 * sheetName, int rowNumber) // throws InvalidFormatException, IOException,
 * InterruptedException, AWTException { // // Get data for the specified row //
 * // Map<String, String> testData = ExcelUtils.getRowData(sheetName,
 * rowNumber); // System.out.println("Data for row " + rowNumber + ": " +
 * testData); // // // Execute validation with the extracted row data //
 * validateFieldsForRow2(sheetName, testData); // }
 * 
 * public void processAllData2(String sheetName) throws InvalidFormatException,
 * IOException, InterruptedException, AWTException {
 * 
 * // Load data from the cache only once List<Map<String, String>> testData =
 * cache.getCachedData(sheetName);
 * 
 * if (testData == null || testData.isEmpty()) { throw new
 * RuntimeException("No data found in the cache for sheet: " + sheetName); }
 * 
 * int numberOfRows = testData.size(); // Number of rows based on cached data
 * System.out.println("Total rows found: " + numberOfRows);
 * 
 * TestCaseManager testCaseManager = new TestCaseManager();
 * 
 * // Iterate over the cached data for (int rowNumber = 1; rowNumber <=
 * numberOfRows; rowNumber++) {
 * System.out.println("Running test for row number: " + rowNumber);
 * 
 * // Group by row number in Allure
 * testCaseManager.startNewTestSuite(rowNumber);
 * 
 * // Get row data from cache Map<String, String> rowData =
 * testData.get(rowNumber - 1);
 * 
 * try { // Start the test case and log the input data for the row
 * testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
 * testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new
 * ArrayList<>(rowData.values()));
 * 
 * int rowTestCaseCount = runTestForRow2(sheetName, rowData, rowNumber);
 * totalTestCaseCount += rowTestCaseCount; testCaseManager.endTestCase(true); }
 * catch (Exception e) { takeScreenshot(rowNumber);
 * testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent
 * reports Assert.fail("Exception encountered while processing row " + rowNumber
 * + ": " + e.getMessage()); testCaseManager.endTestCase(false); } finally {
 * testCaseManager.endTestSuite(); // End the suite (grouping) for this row }
 * 
 * if (rowNumber == numberOfRows) {
 * System.out.println("Finished processing the last row. Logging out...");
 * performLogout(); } }
 * 
 * logDashboardCount2(); }
 * 
 * private void logDashboardCount2() { String message =
 * "Total Dashboard Count: " + totalTestCaseCount;
 * 
 * ExtentCucumberAdapter.addTestStepLog(message);
 * Allure.parameter("Total Test Case Count", totalTestCaseCount);
 * 
 * System.out.println(message); }
 * 
 * private int runTestForRow2(String sheetName, Map<String, String> testData,
 * int rowNumber) throws Exception {
 * 
 * // Log the test data for the current row System.out.println("Data for row " +
 * rowNumber + ": " + testData);
 * 
 * // Initialize the locators (e.g., BankLocators) BL = new
 * org.Locators.BaseClassLocator(driver);
 * 
 * int testCaseCount = 0;
 * 
 * // Validate fields for the current row using testData testCaseCount +=
 * validateFieldsForRow2(sheetName, testData, rowNumber, testCaseCount);
 * 
 * return testCaseCount;
 * 
 * }
 * 
 * @SuppressWarnings("unused") private int validateFieldsForRow2(String
 * sheetName, Map<String, String> testData, int TestcaseNo, int rowNumber)
 * throws Exception {
 * 
 * // Initialize the locators BL = new org.Locators.BaseClassLocator(driver);
 * 
 * // Initialize a counter to track the number of validated fields/sections int
 * validatedFieldsCount = 0; // Bank Details Section validatedFieldsCount +=
 * executeStep2(() -> { try { approveBankOnboarding(testData, TestcaseNo); }
 * catch (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }, "approveBankOnboarding");
 * 
 * // Return the total count of validated fields/sections return
 * validatedFieldsCount; }
 * 
 * private int executeStep2(Runnable step, String stepName) { try { step.run();
 * return 1; // Return 1 for successful execution } catch (Exception e) { //
 * Handle the exception and log the error ExceptionHandler exceptionHandler =
 * new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
 * exceptionHandler.handleException(e, stepName); return 0; // Return 0 for
 * failed execution } }
 * 
 * private void approveBankOnboarding(Map<String, String> testData, int
 * TestcaseNo) throws InterruptedException {
 * 
 * BL = new org.Locators.BaseClassLocator(driver);
 * 
 * String Bankname = testData.get("bankName");
 * 
 * key.clear(); value.clear();
 * 
 * Thread.sleep(3000);
 * 
 * B.ClickSearchbyBankName();
 * 
 * Thread.sleep(1000);
 * 
 * B.SearchbyBankName(Bankname);
 * 
 * logInputData("Search By BankName", B.getClickSearchbyBankName());
 * 
 * Thread.sleep(2000);
 * 
 * B.ActionClick();
 * 
 * Thread.sleep(1000);
 * 
 * B.ClickonViewButton();
 * 
 * int testcaseCount = 0; String errorMessage =
 * "Approve Button is not visible.";
 * 
 * boolean ApprovedStatus = true;
 * 
 * try {
 * 
 * B.ClickOnApprove();
 * 
 * B.Yesforsubmit();
 * 
 * B.OkforSuccessfully();
 * 
 * } catch (AssertionError e) { ApprovedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Approved", "BANK", ApprovedStatus, errorMessage);
 * 
 * // B.ClickOnApprove(); // // B.Yesforsubmit(); // // B.OkforSuccessfully();
 * 
 * B.CancelApprove();
 * 
 * Thread.sleep(3000);
 * 
 * B.ClickSearchbyBankName();
 * 
 * Thread.sleep(1000);
 * 
 * B.SearchbyBankName(Bankname);
 * 
 * Thread.sleep(2000);
 * 
 * B.ActionClick();
 * 
 * Thread.sleep(1000);
 * 
 * try {
 * 
 * B.ClickonViewButton();
 * 
 * logInputData("Bank CPID", B.getCPID());
 * 
 * } catch (AssertionError e) { ApprovedStatus = false; errorMessage =
 * e.getMessage(); // Capture error message }
 * 
 * logTestStep(TestcaseNo, "Bank CPID", B.getCPID(), ApprovedStatus,
 * errorMessage);
 * 
 * // B.ClickonViewButton(); // // logInputData("Bank CPID", B.getCPID());
 * 
 * B.CancelApprove();
 * 
 * }
 * 
 * // private void takeScreenshotStr(String rowNumber) { // try { // // Take a
 * screenshot // File screenshot = ((TakesScreenshot)
 * driver).getScreenshotAs(OutputType.FILE); // String screenshotPath =
 * "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" +
 * rowNumber // + ".png"; // // // Save the screenshot to the specified path //
 * FileUtils.copyFile(screenshot, new File(screenshotPath)); // // // Attach the
 * screenshot to the Allure report // Allure.addAttachment("Screenshot for Row "
 * + rowNumber, // new
 * ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot))); // // //
 * Attach the screenshot to the Extent report //
 * ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath,
 * "Screenshot for Row " + rowNumber); // // } catch (IOException e) { //
 * e.printStackTrace(); // // } // } private void takeScreenshotStr(String
 * rowNumber) { try { // Take a screenshot File screenshot = ((TakesScreenshot)
 * driver).getScreenshotAs(OutputType.FILE);
 * 
 * // Build the path for saving the screenshot String screenshotPath =
 * "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" +
 * rowNumber + ".png";
 * 
 * // Save the screenshot to the specified path FileUtils.copyFile(screenshot,
 * new File(screenshotPath));
 * 
 * // Initialize TestCaseManager (assuming it's handling test case logging)
 * TestCaseManager testCaseManager = new TestCaseManager();
 * 
 * // Start a new test case (Assuming message and status are provided by the //
 * calling code) testCaseManager.startNewTestCase("TEST CASE ERR", false);
 * 
 * // Attach the screenshot to the Allure report
 * Allure.addAttachment("Screenshot for Row " + rowNumber, new
 * ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot))); // Log
 * input data (keys and values should be passed from the calling code) //
 * testCaseManager.logInputDataa(keys, values);
 * 
 * // Log the step in Allure Allure.step("Test case for row " + rowNumber);
 * 
 * // End the test case testCaseManager.endTestCase(false);
 * 
 * // Attach the screenshot to the Extent report
 * ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath,
 * "Screenshot for Row " + rowNumber);
 * 
 * } catch (IOException e) { // Log the exception and stack trace if an error
 * occurs during screenshot // handling e.printStackTrace(); } }
 * 
 * public void LoginInputData(ArrayList<String> Keys, ArrayList<String> Values)
 * { // Convert ArrayLists to arrays String[] keys = Keys.toArray(new
 * String[0]); String[] values = Values.toArray(new String[0]);
 * 
 * // Prepare data for Extent Report String[][] data = new
 * String[2][keys.length]; data[0] = keys; // Header row data[1] = values; //
 * Data row
 * 
 * // Create table markup and log to Extent Report Markup m =
 * MarkupHelper.createTable(data);
 * ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, m);
 * 
 * // Construct HTML table for Allure report StringBuilder tableBuilder = new
 * StringBuilder(); tableBuilder.
 * append("<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
 * );
 * 
 * // Add header row tableBuilder.append("<tr>"); for (String key : keys) {
 * tableBuilder.append("<th style='border: 1px solid black; color: black;'>").
 * append(key).append("</th>"); } tableBuilder.append("</tr>");
 * 
 * // Add data row tableBuilder.append("<tr>"); for (String value : values) {
 * tableBuilder.append("<td style='border: 1px solid black; color: black;'>").
 * append(value).append("</td>"); } tableBuilder.append("</tr>");
 * 
 * tableBuilder.append("</table>");
 * 
 * // Attach HTML table to Allure report Allure.addAttachment("Input Data",
 * "text/html", new ByteArrayInputStream(tableBuilder.toString().getBytes()),
 * "html"); }
 * 
 * private void performLogout() throws InterruptedException {
 * 
 * B.LogoutProfile();
 * 
 * B.Logoutbutton();
 * 
 * B.LogoutYESbutton();
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * }
 */