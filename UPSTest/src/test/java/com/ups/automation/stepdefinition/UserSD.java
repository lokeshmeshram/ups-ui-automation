package com.ups.automation.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Value;

public class UserSD {

    @Value("${com.ups.users}")
    String[] users;

    public String[] getUsers() {
        return users;
    }

    @Given("^Set default logged in user$")
    public void setDefaultLoggedInUser() throws Throwable {
    }

}
