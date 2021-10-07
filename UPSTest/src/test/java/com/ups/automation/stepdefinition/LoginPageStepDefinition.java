package com.ups.automation.stepdefinition;

import com.ups.automation.pageobject.LoginPage;
import cucumber.api.java.en.Given;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginPageStepDefinition {

	@Autowired
	LoginPage loginPage;
	
	@Value("${com.ups.authentication.admin_user}")
	String adminUser;
	
	@Value("${com.usp.authentication.admin_password}")
	String adminPassword;
	
	@Given("^User is at sign in page$")
	public void userIsAtSignInPage() throws Throwable {
		loginPage.toPage();
	}

	@Given("^Admin sign in$")
	public void adminCanSignIn() throws Throwable {
		loginPage.login(adminUser, adminPassword);
	}

	@Given("^Admin sign out$")
    public void adminSignOut() throws Throwable {
        loginPage.logout();
    }

}


