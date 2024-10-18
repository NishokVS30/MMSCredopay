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
Feature: System Users - Terminal Onboarding Regression

 This feature aims to test the functionality of the 'Terminal Onboarding' within the application.
 
 
 @loadDataExcelUtils
 @run
Scenario: Load Data from Excel
    Given I load data from Excel using sheetname "Credentials"
    
Scenario: SystemMaker Login
 Given I visit the System Maker Login in Regression using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button in Regression using sheetname "Credentials" and rownumber 1


   Scenario: System Maker sees Onboarding in Sidemenu in Terminal Onboarding
    When System Maker - Onboarding should be displayed in the side menu

  Scenario: System Maker sees side menu items in Terminal Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
  
  
   Scenario: System Maker Successfully Completes Mandatory Fields in Terminal Onboarding
    When the SystemMaker clicks the Terminal module
    Then the System Maker Terminal Onboarding should prompt users to enter valid inputs using the sheet name "Terminal Regression"