package org.Testcases;



import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageTestcases {
	
	private WebDriver driver;
	
   	org.Locators.LoginLocators L;
   	
	
	 public LoginPageTestcases() throws InterruptedException {
	      this.driver = CustomWebDriverManager.getDriver();
	      System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
	      System.setProperty("webdriver.chrome.verboseLogging", "true");

      }
	 
	 @Given("the login page is displayed")
	 public void the_login_page_is_displayed() {
		 
		   L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.DisplayedOnLoginPage();
		 
		 
	 }		    
		 
     @Then("the label name should be \"User Name\"")
     public void verifyusername() {
    	 
    	   L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.DisplayedOnUsername();

    	 
     }
     
     @Then("the \"User Name\" field should prompt to enter valid alphanumeric inputs using sheetname {string} and rownumber {int}")
     
     public void the_User_Name_field_should_prompt_to_enter_valid_alphanumeric_inputs(String sheetName,int rowNumber) throws InvalidFormatException, IOException, InterruptedException {
    	  L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   
		   
		   ExcelDataCache cache = ExcelDataCache.getInstance();
	        List<Map<String, String>> testdata = cache.getCachedData(sheetName);
			
			 System.out.println("sheet name: " + testdata);
			
			  String userName = testdata.get(rowNumber).get("UserName");
		        
		        System.out.println("0" + testdata.get(0));
		       
		      
		           L.EnterOnUsername(userName);
		   
		 
		   
      }
     
     @Then("Error Message Should not be Displayed")
     public void Error_Message_Should_not_be_Displayed() throws AWTException {
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   Robot r = new Robot();
		   
		   r.keyPress(KeyEvent.VK_TAB);
		   r.keyRelease(KeyEvent.VK_TAB);
		   
		  
		   driver.navigate().refresh();

		   L.NOTDisplayedOnInvalidusernameorpassword();
		   L.NOTDisplayedOnThisfieldisrequired();

    	 
     }
     
     @Then("the \"User Name\" field should not allow to proceed without any input data")
     public void the_UserName_field_shouldnot_allowto_proceedwithoutany_input_data() {
    	 
    	  L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   
		   L.ClickOnSignIn();
    	 
      }
     
     @Then("This field is required Error Message Should be Displayed")
     public void This_field_is_required_Error_Message_Should_be_Displayed() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.DisplayedOnThisFieldisRequired();
    	 
     }
     
     @Then("the label name should be \"Password\"")
     public void verifyPassword() {
    	 
  	   L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.DisplayedOnPassword();

  	 
   }
     
     @Then("the \"Password\" link should be clickable using sheetname {string} and rownumber {int}")
     public void the_Password_link_should_be_clickable(String sheetName,int rowNumber) throws InvalidFormatException, IOException, InterruptedException {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		   ExcelDataCache cache = ExcelDataCache.getInstance();
	        List<Map<String, String>> testdata = cache.getCachedData(sheetName);
		   
			 System.out.println("sheet name: " + testdata);
			 
			  String Password = testdata.get(rowNumber).get("Password");
		        
		        System.out.println("0" + testdata.get(0));
		       
		      
		           L.EnterOnPassword(Password);
		           
		           Thread.sleep(3000);
		           
		           driver.navigate().refresh();
		   
		  }
     
     @Then("the \"Password\" field should not allow to proceed without any input data")
     public void the_Password_field_should_not_allow_to_proceed_without_any_input_data() {
    	 
    	   L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.ClickOnSignIn();
    	 
     }
     
     @When("the eye icon next to the \"Password\" field is clicked")
     public void the_eye_icon_next_to_the_Password_field_is_clicked() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 
    	 L.EnterOnPassword("Test@123");
    	 
    	 L.ClickOneyeicon();
    	 
     }

     @Then("the \"Password\" should be revealed")
     public void the_password_should_be_revealed() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 assertTrue("Password field should be revealed (type='text')", L.isTextField());
    	 
     }
     
     @When("the eye icon next to the \"Password\" field is clicked again")
     public void the_eye_icon_next_to_the_Password_field_is_clickedagain() {
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 
    	 
    	 L.ClickOneyeicon();
    	 
     }
     
     
     @Then("the \"Password\" should be hidden")
     public void the_password_should_be_hidden() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         // Assert that the password field is of type 'password' to confirm it's hidden
    	 assertTrue("Password field should be hidden (type='password')", L.isPasswordField());
     }

	
     @Then("the \"Captcha\" should be present and visible on the login page")
     public void the_Captcha_should_be_present_and_visible_on_the_login_page() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 
		   
    	 assertTrue("Captcha should be present and visible", L.DisplayedonCaptcha());
    	 
    	 
    
     }
     
     @Then("the label name should be \"Enter Captcha\"")
     public void the_label_name_should_be_EnterCaptcha() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   assertTrue("Captcha LabelName should be present and visible", L.CaptchaLabel());
    	 
     }
     
     @Then("the \"Captcha\" field should not allow to proceed without any input data")
     public void the_Captcha_field_shouldnot_allowto_proceedwithout_any_inputdata() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.EnterOnUsername("nishok-superadmin");
		   L.EnterOnPassword("Test@12345");
		   
		   L.ClickOnSignIn();
     }

     @Then("Invalid Captcha Error Message Should be Displayed")
     public void Invalid_Captcha_Error_Message_Should_be_Displayed() throws InterruptedException {
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   assertTrue("Invalid Captcha should be present and visible", L.InvalidCaptcha());
		   
		   Thread.sleep(2000);
		   driver.navigate().refresh();
    	 
     }
     
     @When("the \"Captcha\" refresh button is visible")
     public void the_Captcha_refresh_button_is_visible() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   assertTrue("Captcha Refresh Button should be present and visible", L.CaptchaRefresh());
    	 
     }
     
     @Then("the \"Sign In\" button should be clickable")
     public void the_SignIn_button_should_be_clickable() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.ClickOnSignIn();
		   
		   L.DisplayedOnInvalidusernameorpassword();
    	 
     }
     
     @Then("the \"Image\" should be present and visible on the login page")
     public void ThentheImage_should_be_present_and_visible_on_the_login_page(){
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		   
		   assertTrue("Image should be present and visible", L.image());
     
     }
     
     @Then("the \"Forgot\" link should be clickable")
     public void the_forgot_link_Shouldbe_clickable() {

    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.clickonforgot();
		   
		   L.ClickOnOk();
		   
		   assertTrue("Image should be present and visible", L.ForgoterrorMesage());
		   
		   driver.navigate().back();
     }
    		 
     
     @Then("the \"Terms of Use\" link should be clickable")
     public void theTermsof_Use_link_should_be_clickable() throws InterruptedException {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   
		   
		   L.clickonTermofuse();
		   
		   assertTrue("TermOfUse should be present and visible", L.TermofuseVerify());
	
    	 
     }
     
     @Then("the \"Privacy Policy\" link should be clickable")
     public void thePrivacyPolicy_link_should_be_clickable() throws InterruptedException {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.clickonPrivacypolicy();
		   assertTrue("PrivacyPolicy should be present and visible", L.PrivacyPolicyVerify());
    	 
     }
     
     @Then("the \"Contact Support\" link should be clickable")
     public void theContactSupport_link_should_be_clickable() {
    	 
    	 L = new org.Locators.LoginLocators(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   L.clickonContactSupport();
		   assertTrue("ContactSupport should be present and visible", L.ContectSupportVerify());
		   
		   driver.navigate().back();

    	 
     }

}
