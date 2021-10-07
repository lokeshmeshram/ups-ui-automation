@QA-REGRESSION @QA-FEATURE-LOGIN
Feature: Automation Scenarios for Login feature.

@login_test @BrowserClose
Scenario: [UPS-001] :  Verify If User is able to login/logout to UPS Dashboard
	Given User is at sign in page
	When Admin sign in
	And Verify UPS is loaded