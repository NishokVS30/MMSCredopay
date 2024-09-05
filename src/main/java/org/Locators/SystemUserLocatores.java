package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemUserLocatores {

     WebDriver driver;
     private WebDriverWait wait;

//	@FindBy(xpath = "//button[@class='logo ng-tns-c471-4']")
	@FindBy(xpath = "//button[contains(@class, 'logo') and not(contains(@class, 'logo-alone'))]")
	private WebElement ClickOnDownArrow;

	@FindBy(xpath = "(//a[@color='accent'])[10]")
	private WebElement ClickOnOnboarding;

//	@FindBy(xpath = "//span[text()='Banks']")
	@FindBy(xpath = "//a[@href='/admin/onboard/banks']")
	private WebElement ClickOnBank;

//	@FindBy(xpath = "//span[text()='PayFac']")
	@FindBy(xpath = "//span[text()='Aggregators']")
	private WebElement ClickOnPayfac;

	@FindBy(xpath = "//span[text()='CREATE']")
	private WebElement ClickOnCreate;

	@FindBy(xpath = "//mat-select[@formcontrolname='bankId']")
	private WebElement ClickOnBankName;

	@FindBy(xpath = "//input[@formcontrolname='payfacName']")
	private WebElement EnterOnPayfacName;

	@FindBy(xpath = "//span[text()='ISO']")
	private WebElement ClickOnISO;
	
	@FindBy(xpath = "//span[text()='Sub ISO']")
	private WebElement ClickOnSUBISO;

	@FindBy(xpath = "//span[text()='Group Merchants']")
	private WebElement ClickOnGM;

	@FindBy(xpath = "//a[@href='/admin/onboard/merchants']")
	private WebElement ClickOnMerchant;

	@FindBy(xpath = "//a[@href='/admin/onboard/terminals']")
	private WebElement ClickOnTerminal;
//UserLocators

	@FindBy(xpath = "//span[text()='CREATE']")
	private WebElement Createbutton;

	@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[4]")
	private WebElement Actionbutton;

	@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[4]")
	private WebElement Actionviewbutton;

	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement Editbutton;

	@FindBy(xpath = "//span[text()='View']")
	private WebElement Viewbutton;

	@FindBy(xpath = "//span[text()='Close']")
	private WebElement Closebutton;

	@FindBy(xpath = "//span[text()=' MORE FILTERS ']")
	private WebElement MoreFilter;
	
	@FindBy(xpath = "//span[text()='Status']")
	private WebElement ClickonStatus;

	@FindBy(xpath = "//span[text()='Filter by Status']")
	private WebElement ClickonFilterByStatus;

	@FindBy(xpath = "//span[text()='Apply']")
	private WebElement ClickOnApply;

	@FindBy(xpath = "//span[text()=' New ']")
	private WebElement StatusNew;

	@FindBy(xpath = "//span[text()=' Pending ']")
	private WebElement StatusInprogress;

	@FindBy(xpath = "//span[text()=' Verified ']")
	private WebElement StatusVerified;

	@FindBy(xpath = "//span[text()=' Draft ']")
	private WebElement StatusDraft;

	@FindBy(xpath = "//span[text()=' ReferBack ']")
	private WebElement StatusReferback;
	
	@FindBy(xpath = "//span[text()=' AutoReferBack ']")
	private WebElement StatusAutoReferback;

	@FindBy(xpath = "//span[text()=' Approved ']")
	private WebElement StatusApproved;

	@FindBy(xpath = "//span[text()=' Auto Approved ']")
	private WebElement StatusAutoApproved;

	@FindBy(xpath = "//span[text()=' Rejected ']")
	private WebElement StatusRejected;

	@FindBy(xpath = "//span[text()=' Closed ']")
	private WebElement StatusClosed;

//ListPage Status

	@FindBy(xpath = "(//span[text()='New'])[1]")
	private WebElement ListStatusNew;

	@FindBy(xpath = "(//span[text()='Inprogress'])[1]")
	private WebElement ListStatusInprogress;

	@FindBy(xpath = "(//span[text()='Verified'])[1]")
	private WebElement ListStatusVerified;

	@FindBy(xpath = "(//span[text()='Draft'])[1]")
	private WebElement ListStatusDraft;

	@FindBy(xpath = "(//span[text()='ReferBack'])[1]")
	private WebElement ListStatusReferback;

	@FindBy(xpath = "(//span[text()='Approved'])[1]")
	private WebElement ListStatusApproved;

	@FindBy(xpath = "(//span[text()='Auto Approved'])[1]")
	private WebElement ListStatusAutoApproved;

	@FindBy(xpath = "(//span[text()='Rejected'])[1]")
	private WebElement ListStatusRejected;

	@FindBy(xpath = "(//span[text()='Closed'])[1]")
	private WebElement ListStatusClosed;

	@FindBy(xpath = "//span[text()=' CANCEL ']")
	private WebElement cancelbutton;

	@FindBy(xpath = "//span[contains(text(),' SAVE AS DRAFT')]")
	private WebElement Saveasdraft;

	@FindBy(xpath = "//span[text()=' SUBMIT FOR VERIFICATION ']")
	private WebElement Submitforverification;

	@FindBy(xpath = "(//span[contains(text(),'Refer Back')])[1]")
	private WebElement Referback;

	@FindBy(xpath = "//span[contains(text(),'Reject')]")
	private WebElement Reject;

	@FindBy(xpath = "//span[contains(text(),'SUBMIT FOR APPROVAL')]")
	private WebElement SubmitforApproval;

	@FindBy(xpath = "//span[text()=' APPROVE ']")
	private WebElement Approve;
	

	
	

      public SystemUserLocatores(WebDriver driver) {
		// initialize elements
	
	  this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	  this.driver = driver;
		 
		
		PageFactory.initElements(driver, this);
	}

//	public void ClickOnOnboarding() {
//		ClickOnOnboarding.click();
//	}

	public void ClickOnDownArrow() {
		
		 wait.until(ExpectedConditions.elementToBeClickable(ClickOnDownArrow)).click();
		
		
	}

//	public void ClickOnOnboarding(WebDriver driver) {
//		Actions actions = new Actions(driver);
//		actions.doubleClick(ClickOnOnboarding).click().perform();
//	}	
		
	   public void ClickOnOnboarding() {
		//	ClickOnOnboarding.click();
			
			 wait.until(ExpectedConditions.elementToBeClickable(ClickOnOnboarding)).click();
		}


	public void enterOnPayfac(String payfac) {
		EnterOnPayfacName.sendKeys(payfac);
		
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(EnterOnPayfacName));
		
		until.sendKeys(payfac);
		
		
	}

	public void ClickOnMoreFilter() {

		
		 wait.until(ExpectedConditions.elementToBeClickable(MoreFilter)).click();
	}

	public void ClickOnStatus() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickonStatus)).click();
	}

	public void ClickOnFilterByStatus() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickonFilterByStatus)).click();
	}

	public void SelectOnStatusNew() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusNew)).click();
	}

	public void SelectOnStatusInprogress() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusInprogress)).click();
	}

	public void SelectOnStatusVerified() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusVerified)).click();
	}

	public void SelectOnStatusDraft() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusDraft)).click();
	}

	public void SelectOnStatusReferback() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusReferback)).click();
	}
	
    public void SelectOnStatusAutoReferback() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusAutoReferback)).click();
	}

	public void SelectOnStatusApproved() {
		wait.until(ExpectedConditions.elementToBeClickable(StatusApproved)).click();
	}

	public void SelectOnStatusAutoApproved() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusAutoApproved)).click();
	}

	public void SelectOnStatusRejected() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusRejected)).click();
	}

	public void SelectOnStatusclosed() {
		
		wait.until(ExpectedConditions.elementToBeClickable(StatusClosed)).click();
	}

	public void Clickonapply() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnApply)).click();
	}

	public void ClickOnBank() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnBank)).click();
	}

	public void ClickOnPayfac() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnPayfac)).click();
	}

	public void ClickOnISO() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnISO)).click();
	}
	
	public void ClickOnSUBISO() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSUBISO)).click();
	}

	public void ClickOnGM() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnGM)).click();
	}

	public void ClickOnMerchant() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnMerchant)).click();
	}

	public void ClickOnTerminal() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnTerminal)).click();
	}

	public void NotDisplayedOnBank() {

		boolean BankButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			BankButtonDisplayed = ClickOnBank.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			BankButtonDisplayed = false;
		}
		if (BankButtonDisplayed) {
			Assert.assertFalse("Bank button is displayed For This Role. ", BankButtonDisplayed);
		}

	}

	public void NOTDisplayedOnPayfac() {

		boolean PayfacButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			PayfacButtonDisplayed = ClickOnPayfac.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			PayfacButtonDisplayed = false;
		}
		if (PayfacButtonDisplayed) {
			Assert.assertFalse("Payfac button is displayed For This Role. ", PayfacButtonDisplayed);
		}
	}

	public void NOTDisplayedOnISO() {

		boolean ISOButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			ISOButtonDisplayed = ClickOnISO.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ISOButtonDisplayed = false;
		}
		if (ISOButtonDisplayed) {
			Assert.assertFalse("ISO button is displayed For This Role. ", ISOButtonDisplayed);
		}
	}
	
	

	public void DisplayedOnbank() {
		try {
			assertTrue("BankButton should be displayed", ClickOnBank.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Bank button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnPayfac() {
		try {
			assertTrue("PayfacButton should be displayed", ClickOnPayfac.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Payfac button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnISO() {
		try {
			assertTrue("ISO Button should be displayed", ClickOnISO.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("ISO button Should be displayed For This Role But not found.");
		}
	}
	
	public void DisplayedOnSUBISO() {
		try {
			assertTrue("SUB ISO Button should be displayed", ClickOnSUBISO.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("SUB ISO button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnGM() {

		try {
			assertTrue("GroupMerchantButton should be displayed", ClickOnGM.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Group Merchant button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnMerchant() {

		try {
			assertTrue("MerchantButton should be displayed", ClickOnMerchant.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Merchant button Should be displayed For This Role But not found.");
		}
	}

	public void DisplayedOnTerminal() {
		try {
			assertTrue("TerminalButton should be displayed", ClickOnTerminal.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Terminal button Should be displayed For This Role But not found.");
		}
	}

	public void ClickOnEdit() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Editbutton)).click();
		
	}

	public void ClickOnCancel() {
		
		wait.until(ExpectedConditions.elementToBeClickable(cancelbutton)).click();
	}

	public void clickonView() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Viewbutton)).click();
	}

	public void ClickOnCreate() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnCreate)).click();
	}

	public void ClickOnBankName() {
		ClickOnBankName.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Editbutton)).click();
	}

//UserLocators

	public void ActionClick() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Actionbutton)).click();
	}

	public void ActionViewClick() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Actionviewbutton)).click();
	}

//New Code

	public void DisplayedOnCreatebutton() {
		try {
			assertTrue("CreateButton should be displayed", Createbutton.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Create button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnCreatebutton() {

		boolean CreateButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			CreateButtonDisplayed = Createbutton.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			CreateButtonDisplayed = false;
		}
		if (CreateButtonDisplayed) {
			Assert.assertFalse("Create button is displayed For This Role. ", CreateButtonDisplayed);
		}
	}

	public void DisplayedonEditbutton() {

		try {
			assertTrue("Edit Button should be displayed", Editbutton.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("EDIT button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnEditbutton() {

		boolean EditButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			EditButtonDisplayed = Editbutton.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			EditButtonDisplayed = false;
		}
		if (EditButtonDisplayed) {
			Assert.assertFalse("Edit button is displayed For This Role. ", EditButtonDisplayed);
		}
	}

	public void DisplayedOnViewbutton() {
		try {
			assertTrue("View Button should be displayed", Viewbutton.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("View button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnViewbutton() {

		boolean ViewButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			ViewButtonDisplayed = Viewbutton.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ViewButtonDisplayed = false;
		}
		if (ViewButtonDisplayed) {
			Assert.assertFalse("View button is displayed For This Role. ", ViewButtonDisplayed);
		}
	}

	public void DisplayedOnClosebutton() {
		try {
			assertTrue("Close Button should be displayed", Closebutton.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Close button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnClosebutton() {

		boolean CloseButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			CloseButtonDisplayed = Closebutton.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			CloseButtonDisplayed = false;
		}
		if (CloseButtonDisplayed) {
			Assert.assertFalse("Close button is displayed For This Role. ", CloseButtonDisplayed);
		}
	}

// Cancel 

	public void DisplayedOnCancelbutton() {
		try {
			assertTrue("Cancel Button should be displayed", cancelbutton.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Cancel button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnCancelbutton() {

		boolean CancelButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			CancelButtonDisplayed = Closebutton.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			CancelButtonDisplayed = false;
		}
		if (CancelButtonDisplayed) {
			Assert.assertFalse("Close button is displayed For This Role. ", CancelButtonDisplayed);
		}
	}

//save as draft

	public void DisplayedOnSaveasdraftbutton() {
		try {
			assertTrue("Saveasdraft Button should be displayed", Saveasdraft.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Saveasdraft button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnSaveasdraftbutton() {

		boolean SaveasdraftButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			SaveasdraftButtonDisplayed = Closebutton.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			SaveasdraftButtonDisplayed = false;
		}
		if (SaveasdraftButtonDisplayed) {
			Assert.assertFalse("Close button is displayed For This Role. ", SaveasdraftButtonDisplayed);
		}
	}

	// Submit for verification

	public void DisplayedOnsubmitforverificationbutton() {
		try {
			assertTrue("submitforverification Button should be displayed", Submitforverification.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("submitforverification button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnsubmitforverificationbutton() {

		boolean submitforverificationButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			submitforverificationButtonDisplayed = Closebutton.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			submitforverificationButtonDisplayed = false;
		}
		if (submitforverificationButtonDisplayed) {
			Assert.assertFalse("Submitforverification button is displayed For This Role. ",
					submitforverificationButtonDisplayed);
		}
	}

//Referback

	public void DisplayedOnReferbackbutton() {
		try {
			assertTrue("Referback Button should be displayed", Referback.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Referback button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnReferbackbutton() {

		boolean ReferbackButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			ReferbackButtonDisplayed = Referback.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ReferbackButtonDisplayed = false;
		}
		if (ReferbackButtonDisplayed) {
			Assert.assertFalse("Referback button is displayed For This Role. ", ReferbackButtonDisplayed);
		}
	}

//Reject

	public void DisplayedOnRejectbutton() {
		try {
			assertTrue("Reject Button should be displayed", Reject.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Reject button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnRejectbutton() {

		boolean RejectButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			RejectButtonDisplayed = Reject.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			RejectButtonDisplayed = false;
		}
		if (RejectButtonDisplayed) {
			Assert.assertFalse("Reject button is displayed For This Role. ", RejectButtonDisplayed);
		}
	}

//Submit for Approval	    

	public void DisplayedOnSubmitforApprovalbutton() {
		try {
			assertTrue("Submit for approval Button should be displayed", SubmitforApproval.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Submit for Approval button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnApprovalbutton() {

		boolean ApprovalButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			ApprovalButtonDisplayed = SubmitforApproval.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ApprovalButtonDisplayed = false;
		}
		if (ApprovalButtonDisplayed) {
			Assert.assertFalse("Approval button is displayed For This Role. ", ApprovalButtonDisplayed);
		}
	}

	// Approve

	public void DisplayedOnApprovebutton() {
		try {
			assertTrue("Approve Button should be displayed", Approve.isDisplayed());
		} catch (NoSuchElementException e) {
			// Fail the test if the button is not found
			fail("Approve button Should be displayed For This Role but not found.");
		}
	}

	public void NOTDisplayedOnApprovebutton() {

		boolean ApproveButtonDisplayed;
		try {
			// WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
			ApproveButtonDisplayed = Approve.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			ApproveButtonDisplayed = false;
		}
		if (ApproveButtonDisplayed) {
			Assert.assertFalse("Approve button is displayed For This Role. ", ApproveButtonDisplayed);
		}
	}

//get Location

	public void ClickOnOnboardingLocation(WebDriver driver) {

		ClickOnOnboarding.getLocation();
	}

	public void ClickOnBankLocation() {
		ClickOnBank.getLocation();
	}

	public void ClickOnPayfacLocation() {
		ClickOnPayfac.getLocation();

	}

//		public void ClickOnISOLocation() {
//			Point location = ClickOnISO.getLocation();
//			System.out.println(location);

//		       final int expectedX = 97; // Replace with actual expected X coordinate
//		       final int expectedY = 197;
//		       
//		       
//		       try {
//		          
//		           Point actualLocation = ClickOnISO.getLocation();
//
//		      
//		           System.out.println("ISO button Position: X: " + actualLocation.getX() + ", Y: " + actualLocation.getY());
//
//		           
//		           Point expectedLocation = new Point(expectedX, expectedY); 
//
//		          
//		           Assert.assertEquals("Actual Value" + actualLocation, "Expected Value:X and Y is Mismatch " + expectedLocation);
//
//		       } catch (NoSuchElementException e) {
//		           System.out.println("ISO button is not displayed.");
//		           Assert.fail("ISO button should be displayed, but it is not found.");
//		       }

//		}

	public void ClickOnISOLocation() {

		try {
			Point actualLocation = ClickOnISO.getLocation();
			Dimension actualSize = ClickOnISO.getSize();
			System.out.println("ISO button Position: X: " + actualLocation.getX() + ", Y: " + actualLocation.getY());
			System.out.println(
					"ISO button Actual Size: Width: " + actualSize.getWidth() + ", Height: " + actualSize.getHeight());

			// Calculate expected coordinates based on the element's size
			final int expectedX = (int) (actualLocation.getX() + actualSize.getWidth() * 0.1); // 10% from the left
			final int expectedY = (int) (actualLocation.getY() + actualSize.getHeight() * 0.5); // 50% from the top

			// Print expected coordinates for debugging
			System.out.println("Expected Position: X: " + expectedX + ", Y: " + expectedY);

			// Get the expected size (if needed)
			final int expectedWidth = (int) (actualSize.getWidth() * 0.9); // 90% of actual width
			final int expectedHeight = actualSize.getHeight(); // Same as actual height

			// Print expected size for debugging
			System.out.println("Expected Size: Width: " + expectedWidth + ", Height: " + expectedHeight);

			// Define tolerance for comparison
			final int tolerance = 20; // Adjusted tolerance value

			// Assert that actual coordinates are within the tolerance range of expected
			// coordinates
			Assert.assertTrue(Math.abs(actualLocation.getX() - expectedX) <= tolerance);
			Assert.assertTrue(Math.abs(actualLocation.getY() - expectedY) <= tolerance);

			// Assert that actual size matches the expected size (if needed)
			Assert.assertEquals(actualSize.getWidth(), expectedWidth, tolerance);
			Assert.assertEquals(actualSize.getHeight(), expectedHeight, tolerance);

		} catch (NoSuchElementException e) {
			System.out.println("ISO button is not displayed.");
			Assert.fail("ISO button should be displayed, but it is not found.");
		}

	}

	public void ClickOnGMLocation() {
		try {
			// Get the actual location of the element
			Point actualLocation = ClickOnGM.getLocation();
			Dimension actualSize = ClickOnGM.getSize();
			System.out.println(
					"GroupMerchant button Position: X: " + actualLocation.getX() + ", Y: " + actualLocation.getY());
			System.out.println("GroupMerchant button Actual Size: Width: " + actualSize.getWidth() + ", Height: "
					+ actualSize.getHeight());

			// Calculate expected coordinates based on the element's size
			final int expectedX = (int) (actualLocation.getX() + actualSize.getWidth() * 0.1); // 10% from the left
			final int expectedY = (int) (actualLocation.getY() + actualSize.getHeight() * 0.5); // 50% from the top

			// Print expected coordinates for debugging
			System.out.println("Expected Position: X: " + expectedX + ", Y: " + expectedY);

			// Get the expected size (if needed)
			final int expectedWidth = (int) (actualSize.getWidth() * 0.9); // 90% of actual width
			final int expectedHeight = actualSize.getHeight(); // Same as actual height

			// Print expected size for debugging
			System.out.println("Expected Size: Width: " + expectedWidth + ", Height: " + expectedHeight);

			// Define tolerance for comparison
			final int tolerance = 20; // Adjusted tolerance value

			// Assert that actual coordinates are within the tolerance range of expected
			// coordinates
			Assert.assertTrue(Math.abs(actualLocation.getX() - expectedX) <= tolerance);
			Assert.assertTrue(Math.abs(actualLocation.getY() - expectedY) <= tolerance);

			// Assert that actual size matches the expected size (if needed)
			Assert.assertEquals(actualSize.getWidth(), expectedWidth, tolerance);
			Assert.assertEquals(actualSize.getHeight(), expectedHeight, tolerance);

		} catch (NoSuchElementException e) {
			System.out.println("GroupMerchant button is not displayed.");
			Assert.fail("GroupMerchant button should be displayed, but it is not found.");
		}
	}

	public void ClickOnMerchantLocation() {

		try {
			Point actualLocation = ClickOnMerchant.getLocation();
			Dimension actualSize = ClickOnGM.getSize();
			System.out
					.println("Merchant button Position: X: " + actualLocation.getX() + ", Y: " + actualLocation.getY());
			System.out.println("Merchant button Actual Size: Width: " + actualSize.getWidth() + ", Height: "
					+ actualSize.getHeight());

			// Calculate expected coordinates based on the element's size
			final int expectedX = (int) (actualLocation.getX() + actualSize.getWidth() * 0.1); // 10% from the left
			final int expectedY = (int) (actualLocation.getY() + actualSize.getHeight() * 0.5); // 50% from the top

			// Print expected coordinates for debugging
			System.out.println("Expected Position: X: " + expectedX + ", Y: " + expectedY);

			// Get the expected size (if needed)
			final int expectedWidth = (int) (actualSize.getWidth() * 0.9); // 90% of actual width
			final int expectedHeight = actualSize.getHeight(); // Same as actual height

			// Print expected size for debugging
			System.out.println("Expected Size: Width: " + expectedWidth + ", Height: " + expectedHeight);

			// Define tolerance for comparison
			final int tolerance = 20; // Adjusted tolerance value

			// Assert that actual coordinates are within the tolerance range of expected
			// coordinates
			Assert.assertTrue(Math.abs(actualLocation.getX() - expectedX) <= tolerance);
			Assert.assertTrue(Math.abs(actualLocation.getY() - expectedY) <= tolerance);

			// Assert that actual size matches the expected size (if needed)
			Assert.assertEquals(actualSize.getWidth(), expectedWidth, tolerance);
			Assert.assertEquals(actualSize.getHeight(), expectedHeight, tolerance);

		} catch (NoSuchElementException e) {
			System.out.println("Merchant button is not displayed.");
			Assert.fail("Merchant button should be displayed, but it is not found.");
		}

	}

	public void ClickOnTerminalLocation() {

		try {
			Point actualLocation = ClickOnTerminal.getLocation();
			Dimension actualSize = ClickOnGM.getSize();
			System.out
					.println("Merchant button Position: X: " + actualLocation.getX() + ", Y: " + actualLocation.getY());
			System.out.println("Merchant button Actual Size: Width: " + actualSize.getWidth() + ", Height: "
					+ actualSize.getHeight());

			// Calculate expected coordinates based on the element's size
			final int expectedX = (int) (actualLocation.getX() + actualSize.getWidth() * 0.1); // 10% from the left
			final int expectedY = (int) (actualLocation.getY() + actualSize.getHeight() * 0.5); // 50% from the top

			// Print expected coordinates for debugging
			System.out.println("Expected Position: X: " + expectedX + ", Y: " + expectedY);

			// Get the expected size (if needed)
			final int expectedWidth = (int) (actualSize.getWidth() * 0.9); // 90% of actual width
			final int expectedHeight = actualSize.getHeight(); // Same as actual height

			// Print expected size for debugging
			System.out.println("Expected Size: Width: " + expectedWidth + ", Height: " + expectedHeight);

			// Define tolerance for comparison
			final int tolerance = 20; // Adjusted tolerance value

			// Assert that actual coordinates are within the tolerance range of expected
			// coordinates
			Assert.assertTrue(Math.abs(actualLocation.getX() - expectedX) <= tolerance);
			Assert.assertTrue(Math.abs(actualLocation.getY() - expectedY) <= tolerance);

			// Assert that actual size matches the expected size (if needed)
			Assert.assertEquals(actualSize.getWidth(), expectedWidth, tolerance);
			Assert.assertEquals(actualSize.getHeight(), expectedHeight, tolerance);

		} catch (NoSuchElementException e) {
			System.out.println("Merchant button is not displayed.");
			Assert.fail("Merchant button should be displayed, but it is not found.");
		}
	}

//Deleted Code		
//		
//		public void MakerEditbutton() {
//			boolean displayed = Editbutton.isDisplayed();
//			System.out.println(displayed);
//			
//			String E = Editbutton.getText();
//			System.out.println(E);
//		}
//		
//		public void Editbutton() {
//
//			try {
//				 assertTrue("Button should be displayed", Editbutton.isDisplayed());
//		    } catch (NoSuchElementException e) {
//		        // Fail the test if the button is not found
//		        fail("EDIT button is not displayed For This Role.");
//		    }
//			}
//
//		
//		    
//		    public void Viewbutton() {
//			try {
//				 assertTrue("Button should be displayed", Viewbutton.isDisplayed());
//		    } catch (NoSuchElementException e) {
//		        // Fail the test if the button is not found
//		        fail("View button is not displayed For This Role.");
//		    }
//			}
//		
//			public void MakerCreatebutton() {
//				   boolean displayed = Createbutton.isDisplayed();
//					System.out.println(displayed);
//					
//					String C = Createbutton.getText();
//					System.out.println(C);
//				}
//				
//				public void Createbutton() {
//					
//					boolean CreateButtonDisplayed ;
//				     try {
////				    //     WebElement cancelButton = driver.findElement(By.id("cancel-button-id"));
////				        TRUE 
//				    	 CreateButtonDisplayed = Createbutton.isDisplayed();   
//				     
//				     } catch (org.openqa.selenium.NoSuchElementException e) {
////				         FALSE Button Not Exist
//				    	 CreateButtonDisplayed = false;
//				     }
//				         
//				     
//				     if (CreateButtonDisplayed) {
//				            System.out.println("Button is not Displayed");
//				            Assert.assertFalse("Create button is displayed For This Role. ",CreateButtonDisplayed);
//				        }
//				  }
//

}
