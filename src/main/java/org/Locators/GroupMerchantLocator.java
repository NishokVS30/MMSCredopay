package org.Locators;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupMerchantLocator {

	WebDriver driver;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']")
	private WebElement UniqueReferenceNumber;

	@FindBy(xpath = "//input[@formcontrolname='subDistributors']")
	private WebElement SUBISO;

	@FindBy(xpath = "//input[@formcontrolname='businessNature']")
	private WebElement natureofbusiness;

	@FindBy(xpath = "//input[@formcontrolname='mcc']")
	private WebElement mcc;

	@FindBy(xpath = "(//span[text()=' Verify Document '])[1]")
	private WebElement VerifyDocument1;

	public GroupMerchantLocator(WebDriver driver) {

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickOnUniqueReferenceNumber() {

		UniqueReferenceNumber.click();

	}

	public void EnteronUniqueReferenceNumber(String num) {

		UniqueReferenceNumber.sendKeys(num);

	}

	public void ClickOnSUBISOName() {

		SUBISO.click();

	}

	public void EnteronSUBISOName(String name) {

		SUBISO.sendKeys(name);

	}

	public void ClickOnnatureofbusiness() {

		natureofbusiness.click();

	}

	public void ClickOnMCC() {

		mcc.click();

	}

	public void verifyDocument() {

		VerifyDocument1.click();

	}

}
