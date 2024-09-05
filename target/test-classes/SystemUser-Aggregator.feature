#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: System Users - Aggregator Onboarding Regression

 This feature aims to test the functionality of the 'AggregatorOnboarding' within the application.
 
 

Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button

 
 Scenario: System Maker sees Onboarding in Sidemenu
   When System Maker - Onboarding should be displayed in the side menu
    

Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
  
  
Scenario: SystemMaker clicks the Aggregator module
    When the SystemMaker clicks the Aggregator module
    

 Scenario: SystemMaker clicks the Create Button
    When the SystemMaker clicks the Create Button
    
Scenario: System Maker can enter mandatory fields in "Sales Info" of Aggregator Onboarding
    
     When the user select a valid date in the "Aggregator Application Date" field
     When the user select a valid date in the "Agreement Date" field
     Then the "Aggregator Code" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "Marsid" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "NextStep" button should be prompted to click on Sales Info
     
    Scenario: System Maker can enter mandatory fields and click Next step in "Company Info" of Aggregator Onboarding 
     When I Visit the Company Info
     Then the "Legal Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "Brand Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "Registered Address" field should prompt to enter valid inputs within 230 characters using sheetname "Aggregator Regression" and rownumber 0
     Then the "Registered Pincode" dropdown should prompt to select valid inputs
     Then the "Business Type" dropdown should prompt to select valid inputs
     When the user selects a valid date in the "Established Year" field
     Then the "Registered Number" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "Company PAN" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "GSTIN" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info
     Then the "Statement Type" dropdown should prompt to select valid inputs in Company Info
     Then the "Email Domain" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the "Save" button should be prompted to click on POS Channel Config
     Then the "NextStep" button should be prompted to click on Company Info
     
 Scenario: System Maker can enter mandatory fields and click Next step in "personal Info" of Aggregator Onboarding
          When I visit the Personal Info
          Then the "Add" button should be prompted to click in personal info
          Then the "Title" dropdown should prompt to select valid inputs in Personal Info
          Then the "First Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
          Then the "Last Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
          When the user select a valid date in the "Date Of Birth" field in Personal Info
          Then the "PAN" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname "Aggregator Regression" and rownumber 0  
          Then the "Address" field should prompt to enter valid inputs within 230 characters in personal info using sheetname "Aggregator Regression" and rownumber 0
          Then the "Pincode" dropdown should prompt to select valid inputs in Personal Info
          Then the "Mobile Number" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          Then the "Email ID" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          Then the "Nationality" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
          Then the "Aadhaar Number" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          Then the "Passport" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
          Then the user select a valid date in the "Passport Expiry Date" field in Personal Info
          Then the "Save" button should be prompted to click on Personal Info
          Then the "NextStep" button should be prompted to click on Personal Info
          
          
Scenario: System Maker can enter mandatory fields and click Next step in "Communication Info" of Aggregator Onboarding
    When I visit the Communication Info
    Then the "Add" button should be prompted to click
    Then the "Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "Position" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0 
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "AD User" field should prompt to select Yes or No based on the given input
    Then the "Save" button should be prompted to click on Communication Info
    Then The "NextStep" button should prompt a click on Communication Info

    
Scenario: System Maker can enter mandatory fields and click Next step in "Channel Config" of Aggregator Onboarding
   Then the Channel Config "Add" button should be prompted to click in Aggregator
   Then the Channel Config "Bank Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
   Then the "POS Channel" field should prompt to select the channels based on the given input in Aggregator
   Then the "POS Network" field should prompt to select the channels based on the given input in Aggregator
   Then the "POS Transaction Sets" field should prompt to select the transaction sets based on the given input in Aggregator
   Then the "Start Date" field should prompt to select the transaction sets based on the given input in Aggregator
   Then the "End Date" field should prompt to select the transaction sets based on the given input in Aggregator
   Then the "Save" button should be prompted to click on POS Channel Config
   
   
   Then the Channel Config "Add" button should be prompted to click in Aggregator
   Then the Channel Config "Bank Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
   Then the "UPI Channel" field should prompt to select the channels based on the given input in Aggregator
   Then the "UPI Transaction Sets" field should prompt to select the transaction sets based on the given input in Aggregator
   Then the "Start Date" field should prompt to select the transaction sets based on the given input in Aggregator
   Then the "End Date" field should prompt to select the transaction sets based on the given input in Aggregator
   Then the "Save" button should be prompted to click on UPI Channel Config
   
    
    Then the Channel Config "Add" button should be prompted to click in Aggregator
    Then the Channel Config "Bank Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "AEPS Channel" field should prompt to select the channels based on the given input in Aggregator
    Then the "AEPS Transaction Sets" field should prompt to select the transaction sets based on the given input in Aggregator
    Then the "Start Date" field should prompt to select the transaction sets based on the given input in Aggregator
    Then the "End Date" field should prompt to select the transaction sets based on the given input in Aggregator
    Then the "Save" button should be prompted to click on AEPS Channel Config
    Then the "NextStep" button should be prompted to click on channel config
    
    
    Then the Channel Config "Add" button should be prompted to click in Aggregator
    Then the Channel Config "Bank Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "MATM Channel" field should prompt to select the channels based on the given input in Aggregator
    Then the "MATM Network" field should prompt to select the channels based on the given input in Aggregator
    Then the "MATM Transaction Sets" field should prompt to select the transaction sets based on the given input in Aggregator
    Then the "Start Date" field should prompt to select the transaction sets based on the given input in Aggregator
    Then the "End Date" field should prompt to select the transaction sets based on the given input in Aggregator
    Then the "Save" button should be prompted to click on AEPS Channel Config
    Then the "NextStep" button should be prompted to click on channel config
    
    
Scenario: System Maker can enter mandatory fields and click Next step in "KYC" of Aggregator Onboarding    
    Given I visit the KYC in Aggregator
    Then the KYC "Company PAN" field should prompt a selection based on the uploaded image in the Aggregator using sheetname "Aggregator Regression" and rownumber 0
    Then the KYC "GST Registration Certificate" field should prompt a selection based on the uploaded image in the Aggregator using sheetname "Aggregator Regression" and rownumber 0
    Then the KYC "Aadhaar" field should prompt a selection based on the uploaded image in the Aggregator using sheetname "Aggregator Regression" and rownumber 0
    Then the "NextStep" button should be prompted to click on KYC
    
    


Scenario: System Maker can enter mandatory fields and click Next step in "Discount Rate" of Aggregator Onboarding
     When I visit the Discount Rate
     Then the Discount Rate "ADD" button should be prompted to click    
     Then the "POS Channel" field should prompt to select the channels based on the given input in Aggregator
     Then the POS "Pricing Plan" field should prompt to select the channels based on the given input in Aggregator
     Then the DiscountRate "Save" button should be prompted to click
     
      Then the Discount Rate "ADD" button should be prompted to click
      Then the "UPI Channel" field should prompt to select the channels based on the given input in Aggregator
      Then the UPI "Pricing Plan" field should prompt to select the channels based on the given input in Aggregator
      Then the DiscountRate "Save" button should be prompted to click
       
      Then the Discount Rate "ADD" button should be prompted to click
      Then the "AEPS Channel" field should prompt to select the channels based on the given input in Aggregator
      Then the AEPS "Pricing Plan" field should prompt to select the channels based on the given input in Aggregator
      Then the DiscountRate "Save" button should be prompted to click
      Then the "NextStep" button should be prompted to click on Risk Info
    
     Scenario: System Maker can enter mandatory fields and click Next step in "Settlement Info" of Aggregator Onboarding
     When I visit the Settlement Info
     Then the Settlement Info "ADD" button should be prompted to click
     Then the Settlement Info "Channel" dropdown should prompt to select valid inputs
     Then the Settlement Info "Account Type" dropdown should prompt to select valid inputs
     Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs
     Then the SettlementInfo "Save" button should be prompted to click
     Then the Settlement Info "Settlement Mode" dropdown should prompt to select valid inputs
     Then the Settlement Info "Payment Flag" dropdown should prompt to select valid inputs
     Then the "NextStep" button should be prompted to click on Settlement Info
     
     
     Scenario: System Maker can enter mandatory fields and click Next step in "Whitelabel" of Aggregator Onboarding
       When I visit the Whitelabel
       Then the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs
       Then the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs
       Then the Whitelabel "Allow to Create Merchant User" dropdown should prompt to select valid inputs
       Then the Whitelabel "Max Number of platform" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
       Then the Whitelabel "UserName As" dropdown should prompt to select valid inputs 
       Then the "NextStep" button should be prompted to click on WHiteLabel
       
Scenario: System Maker can enter mandatory fields and click Next step in "Webhook" of Aggregator Onboarding
       When I visit the Webhooks
       Then the Webhooks "Add" button should be prompted to click
       Then the Webhooks "Webhook Type" dropdown should prompt to select valid inputs
       Then the Webhooks "Webhook URL" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
       Then the Webhooks "Save" button should be prompted to click
       Then the "NextStep" button should be prompted to click on Webhooks
       
       Scenario: System Maker can enter mandatory fields and click Next step in "Risk Info" of Aggregator Onboarding
    When I visit the Risk Info
    Then the FRMParameterscheckbox should be checked
    Then the "Velocity Check Minutes" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0 
    Then the "Velocity Check Count" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    Then the "Cash@POS Count" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    Then the "International Card Acceptence" field should prompt to select Yes or No based on the given input in Risk Info      
    Then the "ICA Daily" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0 
    Then the "ICA Weekly" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    Then the "ICA Monthly" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    Then the "UPI Daily" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "UPI Weekly" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "UPI Monthly" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0 
    Then the "UPI Minimum" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "UPI Maximum" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "AEPS Daily" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "AEPS Weekly" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "AEPS Monthly" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "AEPS Minimum" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "AEPS Maximum" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "POS Daily" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "POS Weekly" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "POS Monthly" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "POS Minimum" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "POS Maximum" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    Then the "NextStep" button should be prompted to click on Risk Info
    
   
       
 Scenario: System Maker submits the application for verification
  When the System Maker clicks the "Submit for verification" button in Bank Onboarding

Scenario: System Maker confirms submission by clicking the "Yes" button
  When the System Maker clicks the "Yes" button to confirm submission in Bank Onboarding
  
  
  Scenario: System Maker logs out by clicking profile and log-out button
  When the System Maker clicks on the profile and log-out button

Scenario: System Maker handles the pop-up and is redirected to the login page
  When the System Maker handles the pop-up by selecting the "Yes" button and redirected to login page
  
   
Scenario: System verifier Login
 Given I visit the System Verifier Login using sheetname "Credentials" and rownumber 2
 And I enter the credentials and click a login button
    
	 
Scenario: System Verifier sees Onboarding in Sidemenu
   When System Verifier - Onboarding should be displayed in the side menu
    

Scenario: System Verifier sees side menu items in Onboarding
  Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Verifier clicks the Aggregator module
    When the System Verifier clicks the Aggregator module
   

 Scenario: System Verifier Ensure the Bank Status - Inprogress
    When the System Verifier ensure the Aggregator status "Inprogress" using sheetname "Aggregator Regression" and rownumber 0
  

Scenario: System Verifier - click on action (Three dot button) and select the view option
    When the System Verifier click on action Three dot button and select the view option
    
    
  Scenario: System Verifier checks "Sales Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Sales Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons


  Scenario: System Verifier checks "Company Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Company Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Personal Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Personal Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
 
 
  Scenario: System Verifier checks "Communication Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Communication Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
   
   
   
  Scenario: System Verifier checks "Channel Config" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Channel Config" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  

  Scenario: System Verifier checks "KYC" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verified and Next" buttons in Aggregator
  
 
  Scenario: System Verifier checks "Risk Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Risk Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
 
Scenario: System Verifier checks "Discount Rate" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Discount Rate" to ensure mandatory details are added and clicks the "Verified and Next" buttons

  
  
  Scenario: System Verifier checks "Settlement Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Settlement Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
 
  Scenario: System Verifier checks "WhiteLabel" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "WhiteLabel" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  

  Scenario: System Verifier checks "Webhooks" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Webhooks" to ensure mandatory details are added and clicks the "Verified and Next" buttons
    
  
  Scenario: System verifier submits the application for Approval
  When the System verifier clicks the "Submit for Approval" button in Bank Onboarding

 
  Scenario: System verifier confirms submission by clicking the "Yes" button
  When the System verifier clicks the "Yes" button to confirm submission in Bank Onboarding
  

  Scenario: System verifier logs out by clicking profile and log-out button
  When the System verifier clicks on the profile and log-out button

 
  Scenario: System Verifier handles the pop-up and is redirected to the login page
  When the System verifier handles the pop-up by selecting the "Yes" button and redirected to login page
  
  
  
 
  Scenario: System Approver Login
  Given I visit the System Approver Login using sheetname "Credentials" and rownumber 3
  And I enter the credentials and click a login button
   
 
 
  Scenario: System Approver sees Onboarding in Sidemenu
   When System Approver - Onboarding should be displayed in the side menu
    

Scenario: System Approver sees side menu items in Onboarding
  Then the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Approver clicks the Aggregator module
    When the System Approver clicks the Aggregator module
   
 
 Scenario: System Approver Ensure the Aggregators Status - Inprogress
    When the System Approver ensure the Aggregator status "Inprogress" using sheetname "Aggregator Regression" and rownumber 0
  
  
Scenario: System Approver - click on action (Three dot button) and select the view option
    When the System Approver click on action Three dot button and select the view option
    
   
  Scenario: System Approver checks if "Seles Info" is verified and clicks "NextStep" button
  When the System Approver check if "Sales Info" is verified and clicks the "NextStep" button
  
   
   Scenario: System Approver checks if "Company Info" is verified and clicks "NextStep" button
  When the System Approver check if "Company Info" is verified and clicks the "NextStep" button
  
   
  Scenario: System Approver checks if "Personal Info" is verified and clicks "NextStep" button
  When the System Approver check if "Personal Info" is verified and clicks the "NextStep" button        
  
   
  Scenario: System Approver checks if "Communication Info" is verified and clicks "NextStep" button
  When the System Approver check if "Communication Info" is verified and clicks the "NextStep" button
  
  
  Scenario: System Approver checks if "Channel Config" is verified and clicks "NextStep" button
        When the System Approver check if "Channel Config" is verified and clicks the "NextStep" button
    
         
   Scenario: System Approver checks if "KYC" is verified and clicks "NextStep" button
        When the System Approver check if "KYC" is verified and clicks the "NextStep" button          
        
 
  Scenario: System Approver checks if "Risk Info" is verified and clicks "NextStep" button
        When the System Approver check if "Risk Info" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "Discount Rate" is verified and clicks "NextStep" button
        When the System Approver check if "Discount Rate" is verified and clicks the "NextStep" button
        
   
  Scenario: System Approver checks if "Settlement Info" is verified and clicks "NextStep" button
        When the System Approver check if "Settlement Info" is verified and clicks the "NextStep" button
        
       
  Scenario: System Approver checks if "Whitelabel" is verified and clicks "NextStep" button
        When the System Approver check if "Whitelabel" is verified and clicks the "NextStep" button
        
     
  Scenario: System Approver checks if "Webhooks" is verified and clicks "NextStep" button
        When the System Approver check if "Webhooks" is verified and clicks the "NextStep" button
        
       
  Scenario: System Approver submits the application for Approve
  When the System Approver clicks the "Submit for Approve" button in Bank Onboarding

 
  Scenario: System Approver confirms submission by clicking the "Yes" button
     When the System Approver clicks the "Yes" button to confirm submission in Bank Onboarding
   
     
   Scenario: Verify that Bank CPID is generated after changing the status to Approved
    When Verify that Aggregator CPID is displayed correctly on the "Aggregator Onboarding List page" using sheetname "Aggregator Regression" and rownumber 0 
  
 
  Scenario: System Approver logs out by clicking profile and log-out button
     When the System Approver clicks on the profile and log-out button

 
   Scenario: System Approver handles the pop-up and is redirected to the login page
      When the System Approver handles the pop-up by selecting the "Yes" button and redirected to login page   
    
           
      
      	
     
     
     
   