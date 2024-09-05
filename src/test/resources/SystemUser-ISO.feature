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
Feature: System Users - ISO Onboarding Regression

 This feature aims to test the functionality of the 'ISO Onboarding' within the application.
 
 

Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button

 
 Scenario: System Maker sees Onboarding in Sidemenu
   When System Maker - Onboarding should be displayed in the side menu
    

Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
  
  
Scenario: SystemMaker clicks the ISO module
    When the SystemMaker clicks the ISO module
    

 Scenario: SystemMaker clicks the Create Button
    When the SystemMaker clicks the Create Button
    
Scenario: System Maker can enter mandatory fields in "Sales Info" of Aggregator Onboarding
    
    When the user select a valid date in the "ISO Application Date" field
	  When the user select a valid date in the "Agreement Date" field in ISO
	  Then the "Aggregator Name" field should prompt to select the valid inputs using sheetname "ISO Regression" and rownumber 0
    Then the "Marsid" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0	
    Then the "NextStep" button should be prompted to click on Sales Info
     
     
  Scenario: System Maker can enter mandatory fields and click Next step in "Company Info" of Aggregator Onboarding 
     When I Visit the Company Info
     Then the "Legal Name" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
     Then the "Brand Name" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
     Then the "Registered Address" field should prompt to enter valid inputs within 230 characters using sheetname "ISO Regression" and rownumber 0
     Then the "Registered Pincode" dropdown should prompt to select valid inputs
     Then the "Business Type" dropdown should prompt to select valid inputs
     When the user selects a valid date in the "Established Year" field
     Then the "Registered Number" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
     Then the "Company PAN" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
     Then the "GSTIN" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
     Then the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info
     Then the "Statement Type" dropdown should prompt to select valid inputs in Company Info
     Then the "Email Domain" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
     Then the "Save" button should be prompted to click on Company Info in ISO
     Then the "NextStep" button should be prompted to click on Company Info
     
 Scenario: System Maker can enter mandatory fields and click Next step in "personal Info" of Aggregator Onboarding
          When I visit the Personal Info
          Then the "Add" button should be prompted to click in personal info
          Then the "Title" dropdown should prompt to select valid inputs in Personal Info
          Then the "First Name" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
          Then the "Last Name" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
          When the user select a valid date in the "Date Of Birth" field in Personal Info
          Then the "PAN" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname "ISO Regression" and rownumber 0  
          Then the "Address" field should prompt to enter valid inputs within 230 characters in personal info using sheetname "ISO Regression" and rownumber 0
          Then the "Pincode" dropdown should prompt to select valid inputs in Personal Info
          Then the "Mobile Number" field should prompt to enter valid inputs in Personal Info using sheetname "ISO Regression" and rownumber 0
          Then the "Email ID" field should prompt to enter valid inputs in Personal Info using sheetname "ISO Regression" and rownumber 0
          Then the "Nationality" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
          Then the "Aadhaar Number" field should prompt to enter valid inputs in Personal Info using sheetname "ISO Regression" and rownumber 0
          Then the "Passport" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
          Then the user select a valid date in the "Passport Expiry Date" field in Personal Info
          Then the "Save" button should be prompted to click on Personal Info
          Then the "NextStep" button should be prompted to click on Personal Info
          
          
Scenario: System Maker can enter mandatory fields and click Next step in "Communication Info" of Aggregator Onboarding
    When I visit the Communication Info
    Then the "Add" button should be prompted to click
    Then the "Name" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
    Then the "Position" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0 
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "ISO Regression" and rownumber 0
    Then the "AD User" field should prompt to select Yes or No based on the given input
    Then the "Save" button should be prompted to click on Communication Info
    Then The "NextStep" button should prompt a click on Communication Info

    
Scenario: System Maker can enter mandatory fields and click Next step in "Channel Config" of Bank Onboarding
     When I visit the Channel Config
     Then the "Add" button should be prompted to click
     Then the "Channel" field should prompt to select the channels based on the given input
     Then the "Network" field should prompt to select the Network based on the given input
     Then the "Transaction Sets" field should prompt to select the transaction sets based on the given input
     Then the "Routing" field should prompt to select the routing based on the given input
     Then the "Save" button should be prompted to click on Channel COnfig
     Then the "Add" button should be prompted to click
     Then the "UPI Channel" field should prompt to select the channels based on the given input
     Then the "UPI Transaction Sets" field should prompt to select the transaction sets based on the given input
     Then the "Save" button should be prompted to click on Channel COnfig
     Then the "Add" button should be prompted to click
     Then the "AEPS Channel" field should prompt to select the channels based on the given input
     Then the "AEPS Transaction Sets" field should prompt to select the transaction sets based on the given input
     Then the "Save" button should be prompted to click on Channel COnfig
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
         
     
     
     
     
     