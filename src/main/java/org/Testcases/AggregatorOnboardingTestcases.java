package org.Testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class AggregatorOnboardingTestcases {

	private WebDriver driver;

	org.Locators.LoginLocators L;
	org.Locators.BankLocators B;
	org.Locators.AggregatorLocators A;
	org.Locators.SystemUserLocatores S;

	private ExtentTest test;

	public AggregatorOnboardingTestcases() {
		this.driver = CustomWebDriverManager.getDriver();
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");

	}

	@Given("I visit the payfac onboarding page")

	public void I_visit_the_Payfac_Onboarding_Page() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnDownArrow();

		Thread.sleep(2000);

		B.ClickOnOnboarding();

		Thread.sleep(2000);

		B.ClickOnPayfac();

		Thread.sleep(2000);

		B.ClickOnCreatebutton();

		Thread.sleep(1000);

	}

	@Then("the First label name should be \"VAS Commission\"")
	public void the_label_name_should_be_VASCommission() throws InterruptedException {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnSalesInfo();

		Thread.sleep(1000);

		A.VASCommissionLabelNameOne();

	}

	@Then("the First \"VAS Commission\" field should prompt to select Yes or No based on the given input")
	public void the_First_VAS_COmmission_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnVASCommisiionOne();

		A.SalesInfoYes();

	}

	@Then("the label name should be \"Aggregator Application Date\"")
	public void the_label_Name_Should_be_Aggrerator_Application_Date() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.AggregatorApplicationDateLabelName();
	}

	@When("the user select a valid date in the \"Aggregator Application Date\" field")
	public void theuser_select_avalid_date_inthe_Aggregator_ApplicationDate_field() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnAggreratorApplictionDate();
		A.ClickOnApply();

	}

	@Then("the label name should be \"Agreement Date\"")
	public void the_label_Name_Should_be_AgreementDate() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.AggreementDateLabelName();
	}



	

	@Then("the label name should be \"Aggregator Code\"")
	public void the_label_nameshould_be_AggregatorCode() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.AggregatorCodeLabelName();

	}

	@Then("the \"Aggregator Code\" field should not allow to proceed without any input data")
	public void the_aggregatorCode_field_Should_not_allow_to_Proceed_Without_any_input_data()
			throws InterruptedException, AWTException {

		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnAggregatorCOde();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Aggregator Code\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AggragatorCode_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String code = testdata.get(rowNumber).get("Aggregator Code");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.ClickOnAggregatorCOde();

		A.EnterOnAggregatorCOde(code);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Aggregator Code</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + code + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Aggregator Code" }, { code },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Allow Self Merchant Onboard\"")
	public void the_labelname_should_be_Allow_Self_MerchantOnboard() {
		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.AllowSelfMerchantOnboardLabelName();

	}

	@Then("the \"Allow Self Merchant Onboard\" field should prompt to select Yes or No based on the given input")
	public void the_AllowSelfMerchantOnboard_fieldshouldprompt_toselect_YesorNobasedon_the_given_input() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnAllowSelfMerchantOnboard();

		A.SalesInfoYes();
	}

	@Then("the label name should be \"Marsid\" in Sales Info")
	public void the_labelname_should_be_Marsid_inSalesInfo() {
		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.MarsidLabelName();

	}

	@Then("the \"Marsid\" field should not allow to proceed without any input data in Sales Info")
	public void the_Marsid_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnMarsid();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Marsid\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Marsid_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String id = testdata.get(rowNumber).get("Marsid");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.ClickOnMarsid();

		A.EnterOnMarsid(id);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Marsid</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + id + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Marsid" }, { id },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Auto Deactivation Days\" in Sales Info")
	public void the_labelname_should_be_AutoDeactivationdays_inSalesInfo() {
		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.AutoDeactivationLabelName();

	}

	@Then("the \"Auto Deactivation Days\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_AutoDeactivationDays_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String days = testdata.get(rowNumber).get("Auto Deactivation Days");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.ClearOnAutoDeactivationdays();

		A.ClickOnAutoDeactivationdays();

		A.EnterOnAutoDeactivationdays(days);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Auto Deactivation Days</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + days + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Auto Deactivation Days" }, { days },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the Second label name should be \"VAS Commission\"")
	public void the_Secondlabel_name_should_be_VASCommission() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.VASCommissionLabelNameTWO();

	}

	@Then("the Second \"VAS Commission\" field should prompt to select Yes or No based on the given input")
	public void the_Second_VAS_COmmission_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnVASCommisiionTWO();

		A.SalesInfoYes();

	}

	@Then("the label name should be \"IS TMS Aggregator\"")
	public void the_Secondlabel_name_should_be_IS_TMS_Aggregator() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.IsTMSAggregatorLabel();

	}

	@Then("the \"IS TMS Aggregator\" field should prompt to select Yes or No based on the given input")
	public void the_IS_TMS_Aggregator_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnISTMSAggregator();

		A.SalesInfoYes();

	}

	@Then("the label name should be \"EKyc Required\"")
	public void the_Secondlabel_name_should_be_EKYC_Required() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.EKycRequiredLabel();

	}

	@Then("the \"EKyc Required\" field should prompt to select Yes or No based on the given input")
	public void the_EKyc_Required_field_Should_Prompt_toSelect_Yes_NO_Based_Onthegiven_Input() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnEKYCRequired();

		A.SalesInfoYes();

	}

	@Then("the \"NextStep\" button should be prompted to click on Sales Info")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_SalesInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnNextStep();

	}
	
//Company Info	
	
	@When("I Visit the Company Info")
	public void CompanyInfo() throws InterruptedException {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(6000);

		A.ClickOnCompanyInfo();
		
	}

	@Then("the label name should be \"Legal Name\"")
	public void the_label_name_should_be_LegalName() throws InterruptedException {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(6000);

		A.LegalNameLabel();

	}

	@Then("the \"Legal Name\" field should not allow to proceed without any input data")
	public void the_LegalName_fieldshould_notallow_toproceed_withoutany_input_data()
			throws InterruptedException, AWTException {

		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnLegalName();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisFieldisRequired();
	}

	@Then("the \"Legal Name\" field should prompts for invalid input if Less than 2 characters are entered using sheetname {string} and rownumber {int}")
	public void the_LegalName_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String legal = testdata.get(rowNumber).get("Legal Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.ClickOnLegalName();

		A.EnterOnLegalName(legal);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);
		A.ClearOnLegalName();

		B.DisplayedOnThisInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Legal Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + legal + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Legal Name" }, { legal },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Legal Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_legalName_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String legal = testdata.get(rowNumber).get("Legal Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.ClickOnLegalName();

		A.EnterOnLegalName(legal);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Legal Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + legal + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Legal Name" }, { legal },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}
//Brand Name

	@Then("the label name should be \"Brand Name\"")
	public void the_label_name_should_be_BrandName() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.BrandNameLabel();

	}

	@Then("the \"Brand Name\" field should not allow to proceed without any input data")
	public void the_BrandName_fieldshould_notallow_toproceed_withoutany_input_data()
			throws InterruptedException, AWTException {

		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnBrandName();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Brand Name\" field should prompts for invalid input if Less than 2 characters are entered using sheetname {string} and rownumber {int}")
	public void the_BrandName_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String brand = testdata.get(rowNumber).get("Brand Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.ClickOnBrandName();

		A.EnterOnBrandName(brand);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		A.ClearOnBrandName();

		B.DisplayedOnThisInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Brand Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + brand + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Brand Name" }, { brand },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Brand Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_BrandName_ShouldPrompt_toEntervalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String brand = testdata.get(rowNumber).get("Brand Name");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.ClickOnBrandName();

		A.EnterOnBrandName(brand);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Brand Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + brand + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Brand Name" }, { brand },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Registered Address\"")
	public void the_label_name_should_be_registeredAddress() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.RegisteredAddressLabel();

	}

	@Then("the \"Registered Address\" field should not allow to proceed without any input data")
	public void the_RegisteredAddress_fieldshould_notallow_toproceed_withoutany_input_data()
			throws InterruptedException, AWTException {

		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnRegisteredAddress();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Registered Address\" field should prompt to enter valid inputs within 230 characters using sheetname {string} and rownumber {int}")
	public void theAddress_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Address = testdata.get(rowNumber).get("Registered Address");

		System.out.println("0" + testdata.get(0));

		A.EnterOnRegisteredAddress(Address);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Registered Address</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Address + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Registered Address" }, { Address },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Registered Pincode\"")
	public void the_label_name_should_be_Pincode() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.RegisteredPincodeLabel();

	}

	@Then("the \"Registered Pincode\" field should not allow to proceed without any input data")
	public void the_Pincode_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnRegisteredPincode();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Registered Pincode\" dropdown should prompt to select valid inputs")
	public void thePincode_dropdown_should_prompt_to_select_valid_inputs() throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnRegisteredPincode();

		A.SelectOnRegisteredPincode();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		String SelectedPincode = A.getRegisteredPincode();
		assertEquals("600341", SelectedPincode);

	}

	@Then("the label name should be \"Registered State\"")
	public void the_label_Name_Shouldbe_RegisteredSate() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.RegisteredStateLabel();

	}

	@Then("the Registered state name should be displayed")
	public void the_statename_should_be_displayed() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String State = A.getState();
		assertEquals("tamilnadu", State);

	}

	@Then("the label name should be \"Registered City\"")
	public void the_label_Name_Shouldbe_RegisteredCIty() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.RegisteredCityLabel();

	}

	@Then("the Registered city name should be displayed")
	public void the_cityname_should_be_displayed() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String City = A.getCity();
		assertEquals("chennai", City);

	}

	@Then("the label name should be \"Business Type\"")
	public void the_label_Name_Shouldbe_BusinessType() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.BusinessTypeLabel();

	}

	@Then("the \"Business Type\" field should not allow to proceed without any input data")
	public void the_Business_Type_field_Shouldnot_allow_toProceed_without_anyInputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnBusinessType();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);

		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Business Type\" dropdown should prompt to select valid inputs")
	public void the_Business_Type_dropdown_should_prompt_to_select_valid_inputs() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnBusinessType();

		A.SelectOnBusinessType();

	}

	@Then("the label name should be \"Established Year\"")
	public void the_label_Name_Shouldbe_EstablishedYear() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.EstablishedYearLabel();

	}

	@Then("the user selects a valid date in the \"Established Year\" field")
	public void the_userselects_avalid_date_inthe_EstablishedYear_field() throws AWTException {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnEstablishedYearDatepicker();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		A.ClickOnApply();

	}

	@Then("the label name should be \"Registered Number\"")
	public void the_label_Name_Shouldbe_RegisteredNumber() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.RegisteredNumberLabel();

	}

	@Then("the \"Registered Number\" field should not allow to proceed without any input data")
	public void the_registeredNumber_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CLickOnRegisterNumber();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Registered Number\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theRegisteredNumber_field_shouldprompt_toenter_valid_inputs_within_230_characters(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String registeredNumber = testdata.get(rowNumber).get("Registered Number");

		int register = (int) Double.parseDouble(registeredNumber);

		System.out.println("0" + testdata.get(0));

		A.CLickOnRegisterNumber();

		A.EnterOnRegisterNumber(register);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Registered Number</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + registeredNumber + "</td></tr>"
				+ "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Registered Number" }, { registeredNumber },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Company PAN\"")
	public void the_label_Name_Shouldbe_CompanyPAN() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CompanyPANLabel();

	}

	@Then("the \"Company PAN\" field should not allow to proceed without any input data")
	public void the_CompanyPAN_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CLickOnCompanyPAN();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Company PAN\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_company_PAN_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String pan = testdata.get(rowNumber).get("Company PAN");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.CLickOnCompanyPAN();

		A.EnterOnCompanyPAN(pan);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		A.CLearOnCompanyPAN();

		B.DisplayedOnThisInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Company Pan</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + pan + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Company Pan" }, { pan },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Company PAN\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theCompanyPAN_field_shouldprompt_toenter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String pan = testdata.get(rowNumber).get("Company PAN");

		System.out.println("0" + testdata.get(0));

		A.CLickOnCompanyPAN();

		A.EnterOnCompanyPAN(pan);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Company Pan</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + pan + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Company Pan" }, { pan },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

//GSTIN

	@Then("the label name should be \"GSTIN\"")
	public void the_label_Name_Shouldbe_GstIN() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.GSTINLabel();

	}

	@Then("the \"GSTIN\" field should not allow to proceed without any input data")
	public void the_GstIN_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CLickOnGSTIN();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"GSTIN\" field should prompt to enter Invalid inputs using sheetname {string} and rownumber {int}")
	public void the_GstIN_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String GstIN = testdata.get(rowNumber).get("GSTIN");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.CLickOnGSTIN();

		A.EnterOnGSTIN(GstIN);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		A.CLearOnGSTIN();

		B.DisplayedOnThisInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>GstIN</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + GstIN + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "GstIN" }, { GstIN },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"GSTIN\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theGSTIN_field_shouldprompt_toenter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String GstIN = testdata.get(rowNumber).get("GSTIN");

		System.out.println("0" + testdata.get(0));

		A.CLickOnGSTIN();

		A.EnterOnGSTIN(GstIN);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>GstIN</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + GstIN + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "GstIN" }, { GstIN },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Statement Frequency\" in Company Info")
	public void the_label_Name_Shouldbe_StatementFrequency() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.StatementFrequencyLabel();

	}

	@Then("the \"Statement Frequency\" dropdown should prompt to select valid inputs in Company Info")
	public void the_StatementFrequency_dropdown_should_prompt_toselect_validinputs() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CLickOnStatementFrequency();

		A.SelectOnStatementFrequencyQuarterly();

	}

	@Then("the label name should be \"Statement Type\" in Company Info")
	public void the_label_Name_Shouldbe_StatementType() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.StatementTypeLabel();

	}

	@Then("the \"Statement Type\" field should not allow to proceed without any input data in Company Info")
	public void the_Statement_Type_field_Shouldnot_allow_toProceed_without_anyInputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CLickOnStatementType();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);

		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Statement Type\" dropdown should prompt to select valid inputs in Company Info")
	public void the_StatementType_dropdown_should_prompt_toselect_validinputs() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CLickOnStatementType();

		A.SelectOnStatementTypePDF();

	}

	@Then("the label name should be \"Email Domain\"")
	public void the_label_Name_Shouldbe_emaildomain() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.EmailDomainLabel();

	}

	@Then("the \"Email Domain\" field should not allow to proceed without any input data")
	public void the_emaildomain_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CLickOnEmailDomain();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Email Domain\" field should prompt to enter invalid alphabet domain names using sheetname {string} and rownumber {int}")
	public void the_Emaildomain_ShouldPrompt_toEnterInvalidInputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String domain = testdata.get(rowNumber).get("Email Domain");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.CLickOnEmailDomain();

		A.EnterOnEmailDomain(domain);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.EmailDomainClear();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email Domain</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + domain + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email Domain" }, { domain },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Email Domain\" field should prompt to enter invalid number domain names using sheetname {string} and rownumber {int}")
	public void the_Emaildomain_ShouldPrompt_toEnterInvalidNumbers(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String domain = testdata.get(rowNumber).get("Email Domain");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);

		A.CLickOnEmailDomain();

		A.EnterOnEmailDomain(domain);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.EmailDomainClear();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email Domain</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + domain + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email Domain" }, { domain },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Email Domain\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void theEmaildomain_field_shouldprompt_toenter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String domain = testdata.get(rowNumber).get("Email Domain");

		System.out.println("0" + testdata.get(0));

		A.CLickOnEmailDomain();

		A.EnterOnEmailDomain(domain);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email Domain</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + domain + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email Domain" }, { domain },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"NextStep\" button should be prompted to click on Company Info")
	public void the_nextstep_button_Should_be_prompted_to_clickOn_CompanyInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(3000);

		B.ClickOnNextStep();

	}
	
//Personal Info	

	@When("I visit the Personal Info")
	public void I_visit_the_Personal_Info() throws InterruptedException {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnPersonalInfo();

	}

	@Then("the \"Add\" button should be prompted to click in personal info")
	public void the_Add_button_shouldbe_promptedto_clickinpersonal_info() throws InterruptedException {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		A.PersonalINfoADD();

	}

	@Then("the label name should be \"Title\" in Personal Info")
	public void the_label_Name_Shouldbe_title() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.Titlepersonallabel();

	}

	@Then("the \"Title\" field should not allow proceeding without any input data in personal info")
	public void the_title_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOntitlepersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);

		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Title\" dropdown should prompt to select valid inputs in Personal Info")
	public void the_title_field_should_allow_to_proceed_valid_input_data() throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOntitlepersonal();

		A.Selectbytitlepersonal();

		B.NOTDisplayedOnInvalidFormat();

	}

	@Then("the label name should be \"First Name\" in Personal Info")
	public void the_label_Name_Shouldbefirstname() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.FirstNamePersonalLabel();

	}

	@Then("the \"First Name\" field should not allow proceeding without any input data in personal info")
	public void the_firstName_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnFirstNamePersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"First Name\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String FirstName = testdata.get(rowNumber).get("First Name");

		System.out.println("0" + testdata.get(0));

		A.ClickOnFirstNamePersonal();

		A.EnterOnFirstNamePersonal(FirstName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnFirstNamePersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>First Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + FirstName + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "First Name" }, { FirstName },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"First Name\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String FirstName = testdata.get(rowNumber).get("First Name");

		System.out.println("0" + testdata.get(0));

		A.ClickOnFirstNamePersonal();

		A.EnterOnFirstNamePersonal(FirstName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnFirstNamePersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>First Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + FirstName + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "First Name" }, { FirstName },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"First Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Name_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String FirstName = testdata.get(rowNumber).get("First Name");

		System.out.println("0" + testdata.get(0));

		A.ClickOnFirstNamePersonal();

		A.EnterOnFirstNamePersonal(FirstName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>First Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + FirstName + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "First Name" }, { FirstName },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

//LastName

	@Then("the label name should be \"Last Name\" in Personal Info")
	public void the_label_Name_ShouldbeLastname() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.LastNamePersonalLabel();

	}

	@Then("the \"Last Name\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_lastName_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String LastName = testdata.get(rowNumber).get("Last Name");

		System.out.println("0" + testdata.get(0));

		A.ClickOnLastNamePersonal();

		A.EnterOnLastNamePersonal(LastName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnLastNamePersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Last Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + LastName + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Last Name" }, { LastName },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Last Name\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_lastName_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String LastName = testdata.get(rowNumber).get("Last Name");

		System.out.println("0" + testdata.get(0));

		A.ClickOnLastNamePersonal();

		A.EnterOnLastNamePersonal(LastName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnLastNamePersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Last Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + LastName + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Last Name" }, { LastName },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Last Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_lastName_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String LastName = testdata.get(rowNumber).get("Last Name");

		System.out.println("0" + testdata.get(0));

		A.ClickOnLastNamePersonal();

		A.EnterOnLastNamePersonal(LastName);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Last Name</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + LastName + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Last Name" }, { LastName },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Date of Birth\" in Personal Info")
	public void the_label_Name_Shouldbedateofbirth() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.DOBPersonalLabel();

	}

	@Then("the \"Date Of Birth\" field should not allow proceeding without any input data in personal info")
	public void the_DOB_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnDOBPersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the user select a valid date in the \"Date Of Birth\" field in Personal Info")
	public void theuser_selecta_validdatein_the_DateOf_Birthfield_inPersonal_Info()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnOpenCalenderPersonal();

		A.ClickOnChooseMonthandYearPersonal();

		Thread.sleep(2000);

		A.ClickOnYearPersonal();

		A.ClickOnMonthPersonal();

		A.ClickOnDatePersonal();

		A.ClickOnApplyPersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

	}

	@Then("the label name should be \"PAN\" in Personal Info")
	public void labelName_should_be_PAN() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.PANPersonalLabel();

	}

	@Then("the \"PAN\" field should not allow to proceed without any input data in Personal Info")
	public void the_PAN_field_shouldnotallow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		A = new org.Locators.AggregatorLocators(driver);
		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnPANPersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"PAN\" field should prompt to enter Invalid inputs with PAN Format in Personal Info using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_Invalid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String pan = testdata.get(rowNumber).get("PAN");

		A.ClickOnPANPersonal();

		A.EnterOnPanPersonal(pan);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		B.ClearPAN();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>PAN</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + pan + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "PAN" }, { pan },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"PAN\" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname {string} and rownumber {int}")
	public void the_PAN_field_should_prompt_to_enter_valid_inputs_with_PAN_format(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String pan = testdata.get(rowNumber).get("PAN");

		System.out.println("0" + testdata.get(0));

		A.ClickOnPANPersonal();

		A.EnterOnPanPersonal(pan);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>PAN</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + pan + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "PAN" }, { pan },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Address\" in Personal Info")
	public void labelName_Should_be_Address() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.AddressPersonalLabel();

	}

	@Then("the \"Address\" field should not allow to proceed without any input data in personal info")
	public void the_Address_field_shouldnotallowto_proceed_withoutanyinput_data()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		A.ClickOnAddressPersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Address\" field should prompt to enter valid inputs within 230 characters in personal info using sheetname {string} and rownumber {int}")
	public void theAddress_field_shouldprompt_toenter_valid_inputs_within_230_characters_inPersonalInfo(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Address = testdata.get(rowNumber).get("Address");

		System.out.println("0" + testdata.get(0));

		A.ClickOnAddressPersonal();

		A.EnterOnAddressPersonal(Address);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Address</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Address + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Address" }, { Address },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Pincode\" in Personal Info")
	public void the_label_name_should_be_Pincode_inPersonal_Info() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.PincodePersonalLabel();

	}

	@Then("the \"Pincode\" field should not allow to proceed without any input data in Personal Info")
	public void the_Pincode_field_should_not_allow_to_proceed_without_any_input_data_inPersonal_info()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnPincodePersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Pincode\" dropdown should prompt to select valid inputs in Personal Info")
	public void thePincode_dropdown_should_prompt_to_select_valid_inputs_in_Personal_Info()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnPincodePersonal();

		A.SelectOnRegisteredPincode();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		String SelectedPincode = A.getPincodePersonal();
		assertEquals("600341", SelectedPincode);

	}

	@Then("the label name should be \"State\" in Personal Info")
	public void the_label_Name_Shouldbe_State() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.StatePersonalLabel();

	}

	@Then("the \"state name\" should be displayed in Personal info")
	public void the_statename_should_be_displayedinpersonalInfo() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String State = A.getState();
		assertEquals("tamilnadu", State);

	}

	@Then("the label name should be \"City\" in Personal Info")
	public void the_label_Name_Shouldbe_CIty() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.CityPersonalLabel();

	}

	@Then("the \"City name\" should be displayed in Personal info")
	public void the_cityname_should_be_displayedinpersonalInfo() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String City = A.getCity();
		assertEquals("chennai", City);

	}

	@Then("the label name should be \"Mobile Number\" in Personal Info")
	public void the_label_name_shouldbe_MobileNumber() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.MobilePersonalLabel();

	}

	@Then("the \"Mobile Number\" field should not allow proceeding without any input data in Personal Info")
	public void the_MobileNumber_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnMobileNumberPersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Mobile Number\" field should not allow inputs with fewer digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Mobilenumber = testdata.get(rowNumber).get("Mobile Number");

		System.out.println("0" + testdata.get(0));

		A.ClickOnMobileNumberPersonal();

		A.EnterOnMobileNumberPersonal(Mobilenumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnShouldbe10digits();

		Thread.sleep(2000);

		A.ClearOnMobileNumberPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Mobile Number</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Mobilenumber + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Mobile Number" }, { Mobilenumber },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Mobile Number\" field should not allow inputs with more digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Mobilenumber = testdata.get(rowNumber).get("Mobile Number");

		System.out.println("0" + testdata.get(0));

		A.ClickOnMobileNumberPersonal();

		A.EnterOnMobileNumberPersonal(Mobilenumber);

		String enteredMobileNumber = B.getMobileNumber();
		assertTrue("Mobile Number field allows more than 10 digits.", enteredMobileNumber.length() <= 10);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		A.ClearOnMobileNumberPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Mobile Number</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Mobilenumber + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Mobile Number" }, { Mobilenumber },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Mobile Number\" field should prompt to enter valid inputs in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Mobile_field_should_promptto_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Mobilenumber = testdata.get(rowNumber).get("Mobile Number");

		System.out.println("0" + testdata.get(0));

		A.ClickOnMobileNumberPersonal();

		A.EnterOnMobileNumberPersonal(Mobilenumber);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Mobile Number</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Mobilenumber + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Mobile Number" }, { Mobilenumber },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Telephone\" in Personal Info")
	public void the_label_name_shouldbe_telePhoneNumber() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		B.LabelCommPhoneNumber();

	}

	@Then("the \"Telephone\" field should not allow inputs with fewer digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_TelePhone_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Telephone = testdata.get(rowNumber).get("Telephone");

		System.out.println("0" + testdata.get(0));

		A.ClickOnTelephonePersonal();
		A.EnterOnTelephonePersonal(Telephone);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnTelephonePersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Telephone</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Telephone + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Telephone" }, { Telephone },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Telephone\" field should not allow inputs with more digits than required in Personal Info using sheetname {string} and rownumber {int}")
	public void the_TelePhone_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Telephone = testdata.get(rowNumber).get("Telephone");

		System.out.println("0" + testdata.get(0));

		A.ClickOnTelephonePersonal();
		A.EnterOnTelephonePersonal(Telephone);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnTelephonePersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Telephone</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Telephone + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Telephone" }, { Telephone },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Telephone\" field should not allow numbers that do not start with the digit 0 in Personal Info using sheetname {string} and rownumber {int}")
	public void the_telePhome_field_should_not_allow_numbers_numbers_that_do_not_start_with_the_digit_0(
			String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Telephone = testdata.get(rowNumber).get("Telephone");

		System.out.println("0" + testdata.get(0));

		Thread.sleep(2000);
		A.ClickOnTelephonePersonal();
		A.EnterOnTelephonePersonal(Telephone);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnTelephonePersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Telephone</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Telephone + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Telephone" }, { Telephone },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Telephone\" field should prompt to enter valid inputs in Personal Info")

	public void the_telephoneNumberfield_shouldprompt_toenter_validinputs(List<Map<String, String>> dataTable)
			throws InterruptedException, AWTException {
		for (Map<String, String> row : dataTable) {

			B = new org.Locators.BankLocators(driver);
			L = new org.Locators.LoginLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			String telephone = row.get("TelePhone Number");

			A.ClickOnTelephonePersonal();
			A.EnterOnTelephonePersonal(telephone);

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			B.NOTDisplayedOnInvalidFormat();

		}
	}

	@Then("the label name should be \"Email ID\" in Personal Info")
	public void the_label_name_shouldbe_Emailid() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.EmailPersonalLabel();

	}

	@Then("the \"Email ID\" field should not allow proceeding without any input data in Personal Info")
	public void the_EmailID_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnEmailPersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Email ID\" field should not allow inputs missing the '@' symbol in personal info using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_symbol(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String emailid = testdata.get(rowNumber).get("Email");

		System.out.println("0" + testdata.get(0));

		A.ClickOnEmailPersonal();

		A.EnterOnemailPersonal(emailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnEmailPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + emailid + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email" }, { emailid },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Email ID\" field should not allow inputs missing the domain name in Personal Info using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_inputs_missing_the_domainname(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String emailid = testdata.get(rowNumber).get("Email");

		System.out.println("0" + testdata.get(0));

		A.ClickOnEmailPersonal();

		A.EnterOnemailPersonal(emailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnEmailPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + emailid + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email" }, { emailid },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the Personal Info \"Email ID\" field should not allow consecutive dots in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_consective_dots_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String emailid = testdata.get(rowNumber).get("Email");

		System.out.println("0" + testdata.get(0));

		A.ClickOnEmailPersonal();

		A.EnterOnemailPersonal(emailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(4000);

		A.ClearOnEmailPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + emailid + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email" }, { emailid },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the Personal Info \"Email ID\" field should not allow spaces in the email address using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_notallow_spaces_inthe_emailaddress(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String emailid = testdata.get(rowNumber).get("Email");

		System.out.println("0" + testdata.get(0));

		A.ClickOnEmailPersonal();

		A.EnterOnemailPersonal(emailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnEmailPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + emailid + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email" }, { emailid },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Email ID\" field should prompt to enter valid inputs in Personal Info using sheetname {string} and rownumber {int}")
	public void the_EmailID_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String emailid = testdata.get(rowNumber).get("Email");

		System.out.println("0" + testdata.get(0));

		A.ClickOnEmailPersonal();

		A.EnterOnemailPersonal(emailid);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Email</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + emailid + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Email" }, { emailid },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Nationality\" in Personal Info")
	public void the_label_Name_ShouldbeNationality() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.NationalityPersonalLabel();

	}

	@Then("the \"Nationality\" field should not allow proceeding without any input data in personal info")
	public void the_Nationality_field_should_not_allow_to_proceed_without_any_input_data()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnNationalityPersonal();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ESCAPE);

		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Nationality\" field should not allow numeric characters using sheetname {string} and rownumber {int}")
	public void the_Nationality_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Nationality = testdata.get(rowNumber).get("Nationality");

		System.out.println("0" + testdata.get(0));

		A.ClickOnNationalityPersonal();

		A.EnterOnNationalitypersonal(Nationality);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnNationalityPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Nationality</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Nationality + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Nationality" }, { Nationality },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Nationality\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Nationality_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Nationality = testdata.get(rowNumber).get("Nationality");

		System.out.println("0" + testdata.get(0));

		A.ClickOnNationalityPersonal();

		A.EnterOnNationalitypersonal(Nationality);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnNationalityPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Nationality</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Nationality + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Nationality" }, { Nationality },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Nationality\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Nationality_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Nationality = testdata.get(rowNumber).get("Nationality");

		System.out.println("0" + testdata.get(0));

		A.ClickOnNationalityPersonal();

		A.EnterOnNationalitypersonal(Nationality);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Nationality</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Nationality + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Nationality" }, { Nationality },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Aadhaar Number\" in Personal Info")
	public void the_label_name_shouldbe_Aadhaar() {

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.AadhaarNumberPersonalLabel();

	}

	@Then("the \"Aadhaar Number\" field should not allow inputs with fewer than 12 digits in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Aadhaar_field_should_not_allow_inputs_with_fewer_digits_than_required(String sheetName,
			int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Aadhaar = testdata.get(rowNumber).get("Aadhaar Number");

		System.out.println("0" + testdata.get(0));

		A.ClickOnAadhaarNumberPersonal();

		A.EnterOnAadhaarNumberPersonal(Aadhaar);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnShouldbe10digits();

		Thread.sleep(2000);

		A.ClearOnAadhaarNumberPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Aadhaar Number</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Aadhaar + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Aadhaar Number" }, { Aadhaar },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Aadhaar Number\" field should not allow inputs with more than 12 digits in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Aadhar_field_should_not_allow_inputs_with_more_digits_than_required(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Aadhaar = testdata.get(rowNumber).get("Aadhaar Number");

		System.out.println("0" + testdata.get(0));

		A.ClickOnAadhaarNumberPersonal();

		A.EnterOnAadhaarNumberPersonal(Aadhaar);

		String enteredAadhaarNumber = A.getAadhaarPersonal();
		assertTrue("Mobile Number field allows more than 10 digits.", enteredAadhaarNumber.length() <= 12);

		Thread.sleep(2000);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		A.ClearOnAadhaarNumberPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Aadhaar Number</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Aadhaar + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Aadhaar Number" }, { Aadhaar },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Aadhaar Number\" field should prompt to enter valid inputs in Personal Info using sheetname {string} and rownumber {int}")
	public void the_Aadhaar_field_should_promptto_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Aadhaar = testdata.get(rowNumber).get("Aadhaar Number");

		System.out.println("0" + testdata.get(0));

		A.ClickOnAadhaarNumberPersonal();

		A.EnterOnAadhaarNumberPersonal(Aadhaar);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Aadhaar Number</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Aadhaar + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Aadhaar Number" }, { Aadhaar },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Passport\" in Personal Info")
	public void the_label_Name_ShouldbepassportNumber() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.PassportNumberPersonalLabel();

	}

	@Then("the \"Passport\" field should not allow only numeric characters using sheetname {string} and rownumber {int}")
	public void the_PassportNumber_field_should_not_allow_numeric_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Passport = testdata.get(rowNumber).get("Passport");

		System.out.println("0" + testdata.get(0));

		A.ClickOnPassportNumberPersonal();

		A.EnterOnPassportNumberPersonal(Passport);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnPassportNumberPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Passport</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Passport + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Passport" }, { Passport },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Passport\" field should not allow special characters using sheetname {string} and rownumber {int}")
	public void the_Passport_field_should_not_allow_Special_Characters(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Passport = testdata.get(rowNumber).get("Passport");

		System.out.println("0" + testdata.get(0));

		A.ClickOnPassportNumberPersonal();

		A.EnterOnPassportNumberPersonal(Passport);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.DisplayedOnThisInvalidFormat();

		Thread.sleep(2000);

		A.ClearOnPassportNumberPersonal();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Passport</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Passport + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Passport" }, { Passport },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"Passport\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")
	public void the_Passport_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String Passport = testdata.get(rowNumber).get("Passport");

		System.out.println("0" + testdata.get(0));

		A.ClickOnPassportNumberPersonal();

		A.EnterOnPassportNumberPersonal(Passport);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Passport</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + Passport + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Passport" }, { Passport },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"Passport Expiry Date\" in Personal Info")
	public void the_label_Name_ShouldbepassportExpiryDate() {
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.PassportExpiryDatePersonalLabel();

	}

	@Then("the user select a valid date in the \"Passport Expiry Date\" field in Personal Info")
	public void theuser_selecta_validdatein_the_PasswordExpiryDate_inPersonal_Info()
			throws InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnOpenCalenderPasswordExpiry();

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);

		r.keyRelease(KeyEvent.VK_ENTER);

		A.ClickOnApplyPersonal();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.NOTDisplayedOnInvalidFormat();

	}

	@Then("the \"Save\" button should be prompted to click on Personal Info")
	public void the_savebutton_shouldbe_prompted_toclick_On_PersonalInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		A.ClickOnSAVEPersonal();

		Thread.sleep(3000);

		B.OkforSuccessfully();
	}

	@Then("the \"NextStep\" button should be prompted to click on Personal Info")
	public void the_Nextbutton_shouldbe_prompted_toclick_On_personalInfo() {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		B.ClickOnNextStep();
	}
	
	//Channel Config	

		@When("I visit the Channel Config in Aggregator")
		public void I_visit_the_Channel_Config() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(2000);

			A.ClickOnChannelConfig();

		}

		@Then("the Channel Config \"Add\" button should be prompted to click in Aggregator")
		public void the_Add_button_should_be_prompted_to_click_inchannel_config() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			B.ChannelADD();
		}

		@Then("the label name should be \"Bank Name\" in Channel Config")
		public void labelName_should_be_bankname() {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelBankNameLabel();

		}

		@Then("the Channel Config \"Bank Name\" field should not allow to proceed without any input data")
		public void the_Channel_Config_BankName_field_should_not_allow_to_proceedwithout_any_input_data()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelBankName();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

			B.DisplayedOnThisFieldisRequired();

		}

		@Then("the Channel Config \"Bank Name\" field prompts for invalid input if a number is entered using sheetname {string} and rownumber {int}")

		public void the_ChannelConfig_BankName_field_prompts_for_invalid_input_ifanumber_is_entered(String sheetName,
				int rowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader
					.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String BankName = testdata.get(rowNumber).get("Channel Bank Name");

			System.out.println("0" + testdata.get(0));

			A.ClearOnChannelBankName();

			A.EnterOnChannelBankName(BankName);

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			A.DisplayedOnInvalidBankName();

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>Bank Name</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + BankName + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "Bank Name" }, { BankName },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

		}

		@Then("the Channel Config \"Bank Name\" field prompts for invalid input if special characters are entered using sheetname {string} and rownumber {int}")

		public void the_ChannelConfig_BankName_field_prompts_for_invalid_input_ifaSpecialCharacter_is_entered(
				String sheetName, int rowNumber)
				throws InvalidFormatException, IOException, InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader
					.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String BankName = testdata.get(rowNumber).get("Channel Bank Name");

			System.out.println("0" + testdata.get(0));

			A.ClearOnChannelBankName();

			A.EnterOnChannelBankName(BankName);

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(2000);

			A.DisplayedOnInvalidBankName();

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>Bank Name</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + BankName + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "Bank Name" }, { BankName },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

		}

		@Then("the Channel Config \"Bank Name\" field should prompt to enter valid inputs using sheetname {string} and rownumber {int}")

		public void the_ChannelConfig_BankName_field_prompts_for_valid_input(String sheetName, int rowNumber)
				throws InvalidFormatException, IOException, InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader
					.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String BankName = testdata.get(rowNumber).get("Channel Bank Name");

			System.out.println("0" + testdata.get(0));

			A.ClearOnChannelBankName();

			A.EnterOnChannelBankName(BankName);

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_DOWN);

			r.keyRelease(KeyEvent.VK_DOWN);

			Thread.sleep(3000);

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);

			B.NOTDisplayedOnInvalidFormat();

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>Bank Name</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + BankName + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "Bank Name" }, { BankName },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

		}

		@Then("the label name should be \"Channel\" in Channel Config")
		public void labelName_should_be_Channel() {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelLabel();

		}

		@Then("the Channel Config \"Channel\" field should not allow to proceed without any input data in Aggregator")
		public void the_Channel_Config_POSChannel_field_should_not_allow_to_proceedwithout_any_input_data()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannel();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);

			B.DisplayedOnThisFieldisRequired();

		}

		@Then("the \"POS Channel\" field should prompt to select the channels based on the given input in Aggregator")
		public void POS_Channel_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannel();

			A.SelectOnPOSChannel();

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

	//Network	
		@Then("the label name should be \"Network\" in Channel Config")
		public void labelName_should_be_Network() {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.CHannelNetworkLabel();

		}

		@Then("the Channel Config \"Network\" field should not allow to proceed without any input data in Aggregator")
		public void the_Channel_Config_POSNetwork_field_should_not_allow_to_proceedwithout_any_input_data()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelNetwork();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);

			B.DisplayedOnThisFieldisRequired();

		}

		@Then("the \"POS Network\" field should prompt to select the channels based on the given input in Aggregator")
		public void POS_Network_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(2000);

			A.ClickOnChannelNetwork();

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

		
		
	// TransactionSets
		@Then("the label name should be \"Transaction Sets\" in Channel Config")
		public void labelName_should_be_Transactionsets() {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelTransactionsetsLabel();

		}

		@Then("the Channel Config \"Transaction Sets\" field should not allow to proceed without any input data in Aggregator")
		public void the_Channel_Config_TransactionSets_field_should_not_allow_to_proceedwithout_any_input_data()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelTransactionsets();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(2000);

			B.DisplayedOnThisFieldisRequired();

		}

		@Then("the \"POS Transaction Sets\" field should prompt to select the transaction sets based on the given input in Aggregator")
		public void POSTransaction_Sets_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelTransactionsets();

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

		@Then("the label name should be \"Start Date\" in Channel Config")
		public void labelName_should_be_Startdate() {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelStartDateLabel();

		}

		@Then("the \"Start Date\" field should prompt to select the transaction sets based on the given input in Aggregator")
		public void POSStartDate_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelStartDate();

			Thread.sleep(2000);

			A.ClickOnChannelApply();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

		@Then("the label name should be \"END Date\" in Channel Config")
		public void labelName_should_be_Enddate() {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			A.ChannelEndDateLabel();

		}

		@Then("the \"End Date\" field should prompt to select the transaction sets based on the given input in Aggregator")
		public void POSEndDate_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelENDDate();

			Thread.sleep(2000);

			A.ClickOnChannelApply();

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

		@Then("the \"Save\" button should be prompted to click on POS Channel Config")
		public void Save_button_to_clickOn_POS_Channel_Config() throws InterruptedException {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			Thread.sleep(2000);

			A.ClickOnChannelSave();

		}
		
		@Then("the \"Save\" button should be prompted to click on AEPS Channel Config")
		public void Save_button_to_clickOn_AEPS_Channel_Config() throws InterruptedException {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			Thread.sleep(2000);

			A.ClickOnChannelSave();	

		}
		
		@Then("the \"Save\" button should be prompted to click on UPI Channel Config")
		public void Save_button_to_clickOn_UPI_Channel_Config() throws InterruptedException {
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			Thread.sleep(2000);

			A.ClickOnChannelSave();

		}

		@Then("the \"UPI Channel\" field should prompt to select the channels based on the given input in Aggregator")
		public void UPI_Channel_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannel();
			
			Thread.sleep(2000);	

			A.SelectonUPIChannel();

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

		@Then("the \"UPI Transaction Sets\" field should prompt to select the transaction sets based on the given input in Aggregator")
		public void UPIransaction_Sets_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelTransactionsets();

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

		@Then("the \"AEPS Channel\" field should prompt to select the channels based on the given input in Aggregator")
		public void AEPS_Channel_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			Thread.sleep(2000);

			A.ClickOnChannel();
			
			Thread.sleep(2000);

			A.SelectOnAEPSChannel();

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

		@Then("the \"AEPS Transaction Sets\" field should prompt to select the transaction sets based on the given input in Aggregator")
		public void AEPSransaction_Sets_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			A.ClickOnChannelTransactionsets();

			Thread.sleep(2000);

			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ENTER);

			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			r.keyPress(KeyEvent.VK_TAB);

			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}

	//KYC

		@When("I visit the KYC in Aggregator")
		public void I_visit_the_KYC_in_Aggregator() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(17000);

			A.ClickOnKYC();

		}

		@Then("the KYC \"Company PAN\" field should not allow to proceed without any input data in Aggregator")
		public void the_KYC_CompanyPAN_field_should_not_allow_to_proceedwithout_any_input_data()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Thread.sleep(4000);

			B.ClickOnNextStep();

			A.DisplayedOnInvalidDocumenterror();

		}

		@Then("the KYC \"Company PAN\" field should prompt a selection based on the uploaded image in the Aggregator using sheetname {string} and rownumber {int}")
		public void the_KYC_CompanyPAN_Certificate_fieldshouldprompt_aselectionbased_onthe_uploadedimage_inthe_Aggregator(
				String sheetName, int rowNumber)
				throws InvalidFormatException, IOException, InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader
					.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String panImage = testdata.get(rowNumber).get("Company Pan Image");

			System.out.println("0" + testdata.get(0));

			A.UploadCompanyPAN(panImage);

//		    	driver.switchTo().activeElement().sendKeys(panImage);

			Thread.sleep(2000);

			B.NOTDisplayedOnInvalidFormat();

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>Upload Pan Image Link</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + panImage + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "Upload Pan Image Link" }, { panImage },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

			B.NOTDisplayedOnInvalidFormat();

		}

		@Then("the KYC \"GST Registration Certificate\" field should not allow to proceed without any input data in Aggregator")
		public void the_KYC_GST_RegistrationCertificate_field_should_not_allow_to_proceedwithout_any_input_data()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			B.ClickOnNextStep();

			A.DisplayedOnInvalidDocumenterror();

		}

		@Then("the KYC \"GST Registration Certificate\" field should prompt a selection based on the uploaded image in the Aggregator using sheetname {string} and rownumber {int}")
		public void the_KYC_GSTRegistration_Certificate_fieldshouldprompt_aselectionbased_onthe_uploadedimage_inthe_Aggregator(
				String sheetName, int rowNumber)
				throws InvalidFormatException, IOException, InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader
					.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String gst = testdata.get(rowNumber).get("GST Registration Certificate");

			System.out.println("0" + testdata.get(0));

			A.UploadGSTCertificate(gst);

			// driver.switchTo().activeElement().sendKeys(gst);

			Thread.sleep(2000);

			B.NOTDisplayedOnInvalidFormat();

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>GST Certificate Image Link</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + gst + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "GST Certificate Image Link" }, { gst },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

			B.NOTDisplayedOnInvalidFormat();

		}
		
		
		@Then("the KYC \"Aadhaar\" field should prompt a selection based on the uploaded image in the Aggregator using sheetname {string} and rownumber {int}")
		public void the_KYC_Aadhaar_fieldshouldprompt_aselectionbased_onthe_uploadedimage_inthe_Aggregator(
				String sheetName, int rowNumber)
				throws InvalidFormatException, IOException, InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ExcelReader reader = new ExcelReader();

			List<Map<String, String>> testdata = reader
					.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

			System.out.println("sheet name: " + testdata);

			String Aadhaar = testdata.get(rowNumber).get("Aadhaar Image");

			System.out.println("0" + testdata.get(0));

			A.Aadhaar(Aadhaar);

			// driver.switchTo().activeElement().sendKeys(gst);

			Thread.sleep(2000);

			B.NOTDisplayedOnInvalidFormat();

			test = ExtentCucumberAdapter.getCurrentStep();

			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>Aadhaar Image Link</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + Aadhaar + "</td></tr>" + "</table>";

			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

			String[][] data = { { "Aadhaar Image Link" }, { Aadhaar },

			};
			Markup m = MarkupHelper.createTable(data);

			// or
			test.log(Status.PASS, m);

			B.NOTDisplayedOnInvalidFormat();

		}

	




	//RiskInfo	

		@When("I visit the Risk Info")
		public void I_visit_RiskInfo() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			A.ClickOnRiskInfo();

		}

		@Then("the FRMParameterscheckbox should be checked")

		public void the_FRMParameterscheckbox_shouldbe_checked() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			B.checkboxGlobalfrm();

		}

		@Then("the FRMParameterscheckbox should be unchecked")

		public void the_FRMParameterscheckbox_shouldbe_unchecked() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			B.uncheckboxGlobalfrm();

			Thread.sleep(4000);

			B.checkboxGlobalfrm();

		}

	@When("I click on the \"Velocity Check Minutes\" field in Risk Info")
	public void I_Click_On_the_VelocityCheckMinutes_Field() {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnVelocityCheckMinute();

	}

	@Then("the label name should be \"Velocity Check Minutes\" in Risk Info")
	public void labelName_should_be_VelocityCheckMinutes() {
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		A.VelocityCheckMinuteLabel();

	}

	@Then("the \"Velocity Check Minutes\" field should not allow proceeding without any input data in Risk Info")
	public void the_VelocityCheckMinutes_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnVelocityCheckMinute();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Velocity Check Minutes\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Minutes_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String VelocityCheckMinutes = testdata.get(rowNumber).get("Velocity Check Minutes");

		System.out.println("0" + testdata.get(0));

		A.EnterOnVelocityCheckMinute(VelocityCheckMinutes);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

	}

	@When("I click on the \"Velocity Check Count\" field in Risk Info")
	public void I_Click_On_the_VelocityCheckCount_Field() {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnVelocityCheckCount();

	}

	@Then("the label name should be \"Velocity Check Count\" in Risk Info")
	public void labelName_should_be_Velocity_Check_Count() {
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		A.VelocityCheckCountLabel();

	}

	@Then("the \"Velocity Check Count\" field should not allow proceeding without any input data in Risk Info")
	public void the_VelocityCheckCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnVelocityCheckCount();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Velocity Check Count\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_Velocity_Check_Count_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String VelocityCheckCount = testdata.get(rowNumber).get("Velocity Check Count");

		System.out.println("0" + testdata.get(0));

		A.EnterOnVelocityCheckCount(VelocityCheckCount);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>Velocity Check Count</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + VelocityCheckCount + "</td></tr>"
				+ "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "Velocity Check Count" }, { VelocityCheckCount },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@When("I click on the \"Cash@POS Count\" field in Risk Info")
	public void I_Click_On_the_CashPOSCount_Field() {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnCashpOScount();

	}

	@Then("the label name should be \"Cash@POS Count\" in Risk Info")
	public void labelName_should_be_CashPOSCount() {
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		A.CashpOScountLabel();

	}

	@Then("the \"Cash@POS Count\" field should not allow proceeding without any input data in Risk Info")
	public void the_CashPOSCount_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickOnCashpOScount();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"Cash@POS Count\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_CashPOSCount_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String CashPOSCount = testdata.get(rowNumber).get("CashPOS Count");

		System.out.println("0" + testdata.get(0));

		A.EnterOnCashpOScount(CashPOSCount);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>CashPOSCount</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + CashPOSCount + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "CashPOSCount" }, { CashPOSCount },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the label name should be \"International Card Acceptence\" in Risk Info")
	public void labelName_should_be_InternationalCardAcceptence() {
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		A.InternationalcardCountLabel();

	}

	@Then("the \"International Card Acceptence\" field should prompt to select Yes or No based on the given input in Risk Info")
	public void the_InternationalCardAcceptence_field_should_prompt_to_select_YesNO_basedon_the_given_input()
			throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);

		A.ClickOnInternationalcardCount();

		A.NoInternationalcardCount();

		Thread.sleep(3000);

		A.ClickOnInternationalcardCount();

		A.yesInternationalcardCount();

	}

	@When("I click on the \"ICA Daily\" field in Risk Info")
	public void I_Click_On_the_ICADaily_Field() {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickonICAdaily();

	}

	@Then("the label name should be \"Daily\" in Risk Info")
	public void labelName_should_be_daily() {
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		A.DailyLabel();

	}

	@Then("the \"ICA Daily\" field should not allow proceeding without any input data in Risk Info")
	public void the_ICADaily_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickonICAdaily();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"ICA Daily\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_ICADaily_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICADAILY = testdata.get(rowNumber).get("ICA Daily");

		System.out.println("0" + testdata.get(0));

		A.ClearonICAdaily();

		A.EnteronICAdaily(ICADAILY);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>ICA DAILY</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + ICADAILY + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "ICA DAILY" }, { ICADAILY },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

//ICA Weekly					

	@When("I click on the \"ICA Weekly\" field in Risk Info")
	public void I_Click_On_the_ICAWeekly_Field() {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickonICAWeekly();

	}

	@Then("the label name should be \"Weekly\" in Risk Info")
	public void labelName_should_be_weekly() {
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		A.WeeklyLabel();

	}

	@Then("the \"ICA Weekly\" field should not allow proceeding without any input data in Risk Info")
	public void the_ICAWeekly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickonICAWeekly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"ICA Weekly\" field Must be greater than \"ICA Daily\" in Risk Info using sheetname {string} and rownumber {int}")

	public void the_ICAWeekly_field_Mustbe_greaterthan_ICA_D(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

		System.out.println("0" + testdata.get(0));

		A.ClearonICAWeekly();
		A.EnteronICAWeekly(ICAWEEKLY);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.MustbegreaterthanDailyLimit();

		A.ClearonICAWeekly();

	}

	@Then("the \"ICA Weekly\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_ICAWeekly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAWEEKLY = testdata.get(rowNumber).get("ICA Weekly");

		System.out.println("0" + testdata.get(0));

		A.ClearonICAWeekly();

		A.EnteronICAWeekly(ICAWEEKLY);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>ICA WEEKLY</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + ICAWEEKLY + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "ICA WEEKLY" }, { ICAWEEKLY },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

//Monthly

	@When("I click on the \"ICA Monthly\" field in Risk Info")
	public void I_Click_On_the_ICAMonthly_Field() {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickonICAMonthly();

	}

	@Then("the label name should be \"Monthly\" in Risk Info")
	public void labelName_should_be_Monthly() {
		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		A.MonthlyLabel();

	}

	@Then("the \"ICA Monthly\" field should not allow proceeding without any input data in Risk Info")
	public void the_ICAMonthly_field_shouldnot_allow_proceeding_withoutany_inputdata()
			throws AWTException, InterruptedException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		A.ClickonICAMonthly();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		B.DisplayedOnThisFieldisRequired();

	}

	@Then("the \"ICA Monthly\" field Must be greater than \"ICA Weekly\" in Risk Info using sheetname {string} and rownumber {int}")

	public void the_ICAMonthly_field_Mustbe_greaterthan_ICA_Weekly(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

		System.out.println("0" + testdata.get(0));

		A.ClearonICAMonthly();

		A.EnteronICAMonthly(ICAMonthly);

		Thread.sleep(2000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.Mustbegreaterthanweeklylimit();

		A.ClearonICAMonthly();

	}

	@Then("the \"ICA Monthly\" field should prompt to enter valid inputs in Risk Info using sheetname {string} and rownumber {int}")
	public void the_ICAmonthly_field_should_prompt_to_enter_valid_inputs(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		B = new org.Locators.BankLocators(driver);
		A = new org.Locators.AggregatorLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader
				.getData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel\\MMSCredopay.xlsx", sheetName);

		System.out.println("sheet name: " + testdata);

		String ICAMonthly = testdata.get(rowNumber).get("ICA Monthly");

		System.out.println("0" + testdata.get(0));

		A.ClearonICAMonthly();

		A.EnteronICAMonthly(ICAMonthly);

		Thread.sleep(1000);
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);

		r.keyRelease(KeyEvent.VK_TAB);

		B.NOTDisplayedOnInvalidFormat();

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>ICA MONTHLY</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + ICAMonthly + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { "ICA MONTHLY" }, { ICAMonthly },

		};
		Markup m = MarkupHelper.createTable(data);

		// or
		test.log(Status.PASS, m);

	}

	@Then("the \"NextStep\" button should be prompted to click on Risk Info")
	public void the_Nextbutton_shouldbe_prompted_toclick_on_RiskInfo() throws InterruptedException {

		B = new org.Locators.BankLocators(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		Thread.sleep(1000);

		B.ClickOnNextStep();

	}
	
	
	//Settlement Info	

		@Then("the label name should be \"Settlement Mode\"")
		public void the_label_Name_Should_be_SettlementType() {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			A.SettlementModeLabel();
		}

		@Then("the Settlement Info \"Settlement Mode\" field should not allow proceeding without any input data")
		public void SettlementInfo_SettlementType_field_Shouldnot_allow_Proceeding_without_any_Input_data()
				throws InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			A.ClickOnSettlementMode();

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		}

		@Then("the Settlement Info \"Settlement Mode\" dropdown should prompt to select valid inputs")
		public void the_settlement_SettlementType_dropdown_Should_Prompt_toSelect_Valid_inputs()
				throws InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);
			A.ClickOnSettlementMode();

			Thread.sleep(3000);
			A.SelectOnSettlementMode();
		}

		@Then("the label name should be \"Payment Flag\"")
		public void the_label_Name_Should_be_paymentflag() {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			A.PaymentFlagLabel();
		}

		@Then("the Settlement Info \"Payment Flag\" field should not allow proceeding without any input data")
		public void SettlementInfo_PaymentFlag_field_Shouldnot_allow_Proceeding_without_any_Input_data()
				throws InterruptedException, AWTException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);

			A.ClickOnPaymentFlag();

			Thread.sleep(2000);
			Robot r = new Robot();

			r.keyPress(KeyEvent.VK_ESCAPE);

			r.keyRelease(KeyEvent.VK_ESCAPE);

			B.DisplayedOnThisFieldisRequired();

		}

		@Then("the Settlement Info \"Payment Flag\" dropdown should prompt to select valid inputs")
		public void the_settlement_PaymentFlag_dropdown_Should_Prompt_toSelect_Valid_inputs() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(3000);
			A.ClickOnPaymentFlag();

			Thread.sleep(3000);
			A.SelectOnPaymentFlag();
		}

	//WhiteLabel

		@Then("the \"Whitelabel\" label name should be \"Allow to Create Merchant User\"")
		public void the_whitelabel_labelName_Shouldbe_CreateMerchantUser() {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			A.AllowtocreateMerchantLabel();

		}

		@Then("the Whitelabel \"Allow to Create Merchant User\" dropdown should prompt to select valid inputs")
		public void the_Whitelabel_MerchantUser_dropdown_should_prompt_to_select_valid_inputs()
				throws InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(1000);

			A.ClickOnAllowCreateMerchantOnboard();

			Thread.sleep(2000);

			B.SelectOnWhiteLabelYes();

		}

		@Then("the \"Whitelabel\" label name should be \"UserName As\"")
		public void the_whitelabel_labelName_Shouldbe_UserNameAs() {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			A.UserNameAsLabel();

		}

		@Then("the Whitelabel \"UserName As\" dropdown should prompt to select valid inputs")
		public void the_Whitelabel_UserNameAs_dropdown_should_prompt_to_select_valid_inputs() throws InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			Thread.sleep(1000);

			A.ClickOnUserNameAs();

			Thread.sleep(2000);

			A.SelectOnUserNameAs();

		}
		
//Discount Rate
		
		@When("I visit the Discount Rate")
		public void I_visit_the_Discount_Rate() throws InterruptedException {
			
			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
			 Thread.sleep(2000);

			A.ClickOnDiscountRate();
			
	
        }
		
          @Then("the Discount Rate \"ADD\" button should be prompted to click")
          public void the_DiscountRate_ADD_button_should_be_prompted_to_click() throws InterruptedException {
        	  
        	B = new org.Locators.BankLocators(driver);
  			A = new org.Locators.AggregatorLocators(driver);

  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
  			
  			Thread.sleep(3000);
  			
  			B.ChannelADD();
        	  
          }
          
      	@Then("the POS \"Pricing Plan\" field should prompt to select the channels based on the given input in Aggregator")
		public void POS_PricingPlan_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			Thread.sleep(3000);

			A.ClickOnDiscountRatePricingPlan();

			A.SelectOnPOSPricingPlan();

			Thread.sleep(2000);

//			Robot r = new Robot();
//
//			r.keyPress(KeyEvent.VK_TAB);
//
//			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}
      	
      	@Then("the AEPS \"Pricing Plan\" field should prompt to select the channels based on the given input in Aggregator")
    		public void AEPS_PricingPlan_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
    				throws AWTException, InterruptedException {

    			B = new org.Locators.BankLocators(driver);
    			A = new org.Locators.AggregatorLocators(driver);

    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    			
    			Thread.sleep(2000);

    			A.ClickOnDiscountRatePricingPlan();
    			
    			Thread.sleep(2000);

    			A.SelectOnAEPSPricingPlan();

    			Thread.sleep(2000);

//    			Robot r = new Robot();
   
//    			r.keyPress(KeyEvent.VK_TAB);
    
//    			r.keyRelease(KeyEvent.VK_TAB);

    			B.NOTDisplayedOnInvalidFormat();

    		}
      	      	
    	@Then("the UPI \"Pricing Plan\" field should prompt to select the channels based on the given input in Aggregator")
		public void UPI_PricingPlan_fieldshould_promptto_select_thetransaction_setsbased_onthe_giveninput_inAggregator()
				throws AWTException, InterruptedException {

			B = new org.Locators.BankLocators(driver);
			A = new org.Locators.AggregatorLocators(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			Thread.sleep(2000);

			A.ClickOnDiscountRatePricingPlan();
			
			Thread.sleep(2000);

			A.SelectOnUPIPricingPlan();

			Thread.sleep(2000);

//			Robot r = new Robot();

//			r.keyPress(KeyEvent.VK_TAB);

//			r.keyRelease(KeyEvent.VK_TAB);

			B.NOTDisplayedOnInvalidFormat();

		}
      	
      	
      	@Then("the DiscountRate \"Save\" button should be prompted to click")
    	public void the_savebutton_shouldbe_prompted_toclick_On_discountRate() throws InterruptedException {

    		B = new org.Locators.BankLocators(driver);

    		A = new org.Locators.AggregatorLocators(driver);

    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    		A.ClickOnSAVEPersonal();
    		
    	}
      	
      	
      						
      		
		
	
		




	
}
