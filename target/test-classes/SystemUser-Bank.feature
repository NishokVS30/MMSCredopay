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
Feature: System Users - Bank Onboarding Regression

 This feature aims to test the functionality of the 'BankOnboarding' within the application.

@run
Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button
 
@run
Scenario: System Maker sees Onboarding in Sidemenu
   When System Maker - Onboarding should be displayed in the side menu
    
@run
Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 
@run 
 Scenario: SystemMaker clicks the bank module
    When the SystemMaker clicks the bank module
    
@run
 Scenario: SystemMaker clicks the Create Button
    When the SystemMaker clicks the Create Button
    
@run 
Scenario: System Maker can enter mandatory fields in "General Info" of Bank Onboarding
      Then the "Bank Name" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
      Then the "Address" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
      Then the "Pincode" dropdown should prompt to select valid inputs
      Then the "GST" field should prompt to enter valid inputs with GST format using sheetname "Bank Regression" and rownumber 0
      Then the "PAN" field should prompt to enter valid inputs with PAN format using sheetname "Bank Regression" and rownumber 0
      Then the "MarsId" field	should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
      Then the "Domain" field should prompt to enter the valid domain name using sheetname "Bank Regression" and rownumber 0
      Then the "Domain" field should prompt to enter the valid domain name using sheetname "Bank Regression" and rownumber 1
      Then the "Domain" field should prompt to enter the valid domain name using sheetname "Bank Regression" and rownumber 2
      Then the "NextStep" button should be prompted to click on General Info
      
   
@run
Scenario: System Maker can enter mandatory fields and click Next step in "Communication Info" of Bank Onboarding
    When I visit the Communication Info
    Then the "Add" button should be prompted to click
    Then the "Name" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "Position" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0 
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "AD User" field should prompt to select Yes or No based on the given input
    Then the "Save" button should be prompted to click on Communication Info
    Then The "NextStep" button should prompt a click on Communication Info
    

@run
Scenario: System Maker can enter mandatory fields and click Next step in "Channel Config" of Bank Onboarding
     When I visit the Channel Config
      Then the Channel Bank Onboarding should prompt users to enter valid inputs using the sheet name "Channel"
     #Then the "Add" button should be prompted to click
     #Then the "POS Channel" field should prompt to select the channels based on the given input
     #Then the "POS Network" field should prompt to select the Network based on the given input
     #Then the "POS Transaction Sets" field should prompt to select the transaction sets based on the given input
     #Then the "POS Routing" field should prompt to select the routing based on the given input
     #Then the "Save" button should be prompted to click on Channel COnfig
     #Then the "Add" button should be prompted to click
     #Then the "UPI Channel" field should prompt to select the channels based on the given input
     #Then the "UPI Transaction Sets" field should prompt to select the transaction sets based on the given input
     #Then the "Save" button should be prompted to click on Channel COnfig
     #Then the "Add" button should be prompted to click
     #Then the "AEPS Channel" field should prompt to select the channels based on the given input
     #Then the "AEPS Transaction Sets" field should prompt to select the transaction sets based on the given input
     #Then the "Save" button should be prompted to click on Channel COnfig
     #Then the "Add" button should be prompted to click
     #Then the "MATM Channel" field should prompt to select the channels based on the given input
     #Then the "MATM Network" field should prompt to select the Network based on the given input
     #Then the "MATM Transaction Sets" field should prompt to select the transaction sets based on the given input
     #Then the "MATM Routing" field should prompt to select the routing based on the given input
     #Then the "Save" button should be prompted to click on Channel COnfig
     #Then the "NextStep" button should be prompted to click on channel config
     #Then the "POS ADD BIN" field should prompt to select the Bin based on the given input
     #Then the "MATM ADD BIN" field should prompt to select the Bin based on the given input
     #Then the "NextStep" button should be prompted to click on ONUS Routing
     
     
     


Scenario: System Maker can enter mandatory fields and click Next step in "Global FRM" of Bank Onboarding
    When I visit the Global FRM 
    Then the GlobalFRMcheckbox should be checked
    Then the "Velocity Check Minutes" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "Velocity Check Count" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "Cash@POS Count" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "Micro ATM Count" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "International Card Acceptence" field should prompt to select Yes or No based on the given input
    Then the "ICA Daily" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "ICA Weekly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "ICA Monthly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "POS Daily" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "POS Weekly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "POS Monthly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "POS Minimum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "POS Maximum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "UPI Daily" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "UPI Weekly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "UPI Monthly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "UPI Minimum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "UPI Maximum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "AEPS Daily" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "AEPS Weekly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "AEPS Monthly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "AEPS Minimum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "AEPS Maximum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "MATM Daily" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "MATM Weekly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "MATM Monthly" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "MATM Minimum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "MATM Maximum" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    Then the "NextStep" button should be prompted to click on Global FRM
 
 
             
 Scenario: System Maker can enter mandatory fields and click Next step in "Commercial" of Bank Onboarding
      When I visit the Commercial
      Then the "Interchange Plan Add" button should be prompted to click
      Then the "Interchange Plan Channel - POS" dropdown should prompt to select valid inputs
      When the "Interchange Pricing Plan - BANK TEST PLAN" dropdown should prompt to select valid inputs
      Then the Commercial "Save" button should be prompted to click
      
      
      Then the "Interchange Plan Add" button should be prompted to click
      Then the "Interchange Plan Channel - AEPS" dropdown should prompt to select valid inputs
      When the "Interchange Pricing Plan - AEPS" dropdown should prompt to select valid inputs
      Then the Commercial "Save" button should be prompted to click
      
      
      Then the "Bank Onboarding Commercial Add" button should be prompted to click
      Then the "Bank Onboarding Commercial Channel - POS" dropdown should prompt to select valid inputs
      When the "Bank Onboarding Commercial Pricing Plan - POS" dropdown should prompt to select valid inputs
      Then the Commercial "Save" button should be prompted to click
      
      Then the "Bank Onboarding Commercial Add" button should be prompted to click
      Then the "Bank Onboarding Commercial Channel - AEPS" dropdown should prompt to select valid inputs
      When the "Bank Onboarding Commercial Pricing Plan - BANK AEPS PLAN" dropdown should prompt to select valid inputs
      Then the Commercial "Save" button should be prompted to click
      
      Then the "Bank Onboarding Commercial Add" button should be prompted to click
      Then the "Bank Onboarding Commercial Channel - UPI" dropdown should prompt to select valid inputs
      When the "Bank Onboarding Commercial Pricing Plan - UPI" dropdown should prompt to select valid inputs
      Then the Commercial "Save" button should be prompted to click
      
      Then the "NextStep" button should be prompted to click on Commercial
      
Scenario: System Maker can enter mandatory fields and click Next step in "Settlement Info" of Bank Onboarding
       When I visit the Settlement Info
       Then the Settlement Info "ADD" button should be prompted to click
       Then the Settlement Info "Channel" dropdown should prompt to select the valid inputs
       Then the Settlement Info "Account Type" dropdown should prompt to select the valid inputs
       Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
       Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs
       Then the SettlementInfo "Save" button should be prompted to click
       Then the Settlement Info "Settlement Type" dropdown should prompt to select valid inputs
       Then the "NextStep" button should be prompted to click on Settlement Info
       
       
Scenario: System Maker can enter mandatory fields and click Next step in "Whitelabel" of Bank Onboarding
       When I visit the Whitelabel
       Then the Whitelabel "BankOwnDeployment" dropdown should prompt to select valid inputs
       Then the Whitelabel "Payfac Onboarding" dropdown should prompt to select valid inputs
       Then the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs
       Then the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs
       Then the Whitelabel "Max Number of platform" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
       Then the "NextStep" button should be prompted to click on WHiteLabel
       
Scenario: System Maker can enter mandatory fields and click Next step in "Webhook" of Bank Onboarding
       When I visit the Webhooks
       Then the Webhooks "Add" button should be prompted to click
       Then the Webhooks "Webhook Type" dropdown should prompt to select valid inputs
       Then the Webhooks "Webhook URL" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
       Then the Webhooks "Save" button should be prompted to click
       Then the "NextStep" button should be prompted to click on Webhooks
       
Scenario: System Maker can enter mandatory fields and click Next step in "KYC Config" of Bank Onboarding
     When I visit the KYC Config
     Then the KYC Config "Add" button should be prompted to click
     Then the KYC Config "Business Type" dropdown should prompt to select valid inputs
     Then the Company KYC "Proof of Identity" dropdown should prompt to select valid inputs
     Then the Company KYC "Proof of Address" dropdown should prompt to select valid inputs
     Then the Company KYC "Bank Documents" dropdown should prompt to select valid inputs
     Then the Company KYC "Tax Documents" dropdown should prompt to select valid inputs
     Then the Individual "Proof of Identity" dropdown should prompt to select valid inputs
     Then the Individual "Proof of Address" dropdown should prompt to select valid inputs
     Then the Individual "Other Documents" dropdown should prompt to select valid inputs
     Then the KYC "Save" button should be prompted to click
     Then the "NextStep" button should be prompted to click on KYC
  
  Scenario: System Maker submits the application for verification
  When the System Maker clicks the "Submit for verification" button in Bank Onboarding

Scenario: System Maker confirms submission by clicking the "Yes" button
  When the System Maker clicks the "Yes" button to confirm submission in Bank Onboarding
  

Scenario: System Maker logs out by clicking profile and log-out button
  When the System Maker clicks on the profile and log-out button

Scenario: System Maker handles the pop-up and is redirected to the login page
  When the System Maker handles the pop-up by selecting the "Yes" button and redirected to login page
  
  

Scenario: System verifier Login
 Given I visit the System Verifier Login using sheetname "Bank Regression" and rownumber 1
 And I enter the credentials and click a login button
    
  	 
Scenario: System Verifier sees Onboarding in Sidemenu
   When System Verifier - Onboarding should be displayed in the side menu
    

Scenario: System Verifier sees side menu items in Onboarding
  Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Verifier clicks the bank module
    When the System Verifier clicks the bank module
   

 Scenario: System Verifier Ensure the Bank Status - Inprogress
    When the System Verifier ensure the bank status "Inprogress" using sheetname "Bank Regression" and rownumber 0
  
 
Scenario: System Verifier - click on action (Three dot button) and select the view option
    When the System Verifier click on action Three dot button and select the view option
  
 
  Scenario: System Verifier checks "General Info" and clicks "Verified and Next"
  When the System Verifier checks "General Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons


  Scenario: System Verifier checks "Communication Info" and clicks "Verified and Next"
  When the System Verifier checks "Communication Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
   
  
  Scenario: System Verifier checks "Channel Config" and clicks "Verified and Next"
  When the System Verifier checks "Channel Config" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "ONUS Routing" and clicks "Verified and Next"
  When the System Verifier checks "ONUS Routing" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Global FRM" and clicks "Verified and Next"
  When the System Verifier checks "Global FRM" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Commercial" and clicks "Verified and Next"
  When the System Verifier checks "Commerical" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Settlement Info" and clicks "Verified and Next"
  When the System Verifier checks "Settlement Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "WhiteLabel" and clicks "Verified and Next"
  When the System Verifier checks "WhiteLabel" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Webhooks" and clicks "Verified and Next"
  When the System Verifier checks "Webhooks" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "KYC" and clicks "Verified and Next"
  When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System verifier submits the application for Approval
  When the System verifier clicks the "Submit for Approval" button in Bank Onboarding

  
  Scenario: System verifier confirms submission by clicking the "Yes" button
  When the System verifier clicks the "Yes" button to confirm submission in Bank Onboarding
  
 
  Scenario: System verifier logs out by clicking profile and log-out button
  When the System verifier clicks on the profile and log-out button

 
  Scenario: System Verifier handles the pop-up and is redirected to the login page
  When the System verifier handles the pop-up by selecting the "Yes" button and redirected to login page
  
  
  
Scenario: System Approver Login
  Given I visit the System Approver Login using sheetname "Bank Regression" and rownumber 2
  And I enter the credentials and click a login button
   
  
 
  Scenario: System Approver sees Onboarding in Sidemenu
   When System Approver - Onboarding should be displayed in the side menu
    
 
Scenario: System Approver sees side menu items in Onboarding
  Then the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Approver clicks the bank module
    When the System Approver clicks the bank module
   
 
 Scenario: System Approver Ensure the Bank Status - Inprogress
    When the System Approver ensure the bank status "Inprogress" using sheetname "Bank Regression" and rownumber 0
  
  
Scenario: System Approver - click on action (Three dot button) and select the view option
    When the System Approver click on action Three dot button and select the view option
    
  
  Scenario: System Approver checks if "General Info" is verified and clicks "NextStep" button
  When the System Approver check if "General Info" is verified and clicks the "NextStep" button  
  
  
  Scenario: System Approver checks if "Communication Info" is verified and clicks "NextStep" button
  When the System Approver check if "Communication Info" is verified and clicks the "NextStep" button
  
  
  Scenario: System Approver checks if "Channel Config" is verified and clicks "NextStep" button
        When the System Approver check if "Channel Config" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "ONUS Routing" is verified and clicks "NextStep" button
        When the System Approver check if "ONUS Routing" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "Global FRM" is verified and clicks "NextStep" button
        When the System Approver check if "Global FRM" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "Commercial" is verified and clicks "NextStep" button
        When the System Approver check if "Commercial" is verified and clicks the "NextStep" button   
        
        
  Scenario: System Approver checks if "Settlement Info" is verified and clicks "NextStep" button
        When the System Approver check if "Settlement Info" is verified and clicks the "NextStep" button
        
        
  Scenario: System Approver checks if "Whitelabel" is verified and clicks "NextStep" button
        When the System Approver check if "Whitelabel" is verified and clicks the "NextStep" button
        
       
  Scenario: System Approver checks if "Webhooks" is verified and clicks "NextStep" button
        When the System Approver check if "Webhooks" is verified and clicks the "NextStep" button
        
         
  Scenario: System Approver checks if "KYC" is verified and clicks "NextStep" button
        When the System Approver check if "KYC" is verified and clicks the "NextStep" button     
        
       
  Scenario: System Approver submits the application for Approve
  When the System Approver clicks the "Submit for Approve" button in Bank Onboarding


  Scenario: System Approver confirms submission by clicking the "Yes" button
     When the System Approver clicks the "Yes" button to confirm submission in Bank Onboarding
   
     
   Scenario: Verify that Bank CPID is generated after changing the status to Approved
    When Verify that Bank CPID is displayed correctly on the "Bank Onboarding List page" using sheetname "Bank Regression" and rownumber 0 
  

  Scenario: System Approver logs out by clicking profile and log-out button
     When the System Approver clicks on the profile and log-out button

   Scenario: System Approver handles the pop-up and is redirected to the login page
      When the System Approver handles the pop-up by selecting the "Yes" button and redirected to login page   
        
  
    
       
