package com.ups.automation.stepdefinition;

import com.ups.automation.TestUPSApplication;
import com.ups.automation.pageobject.AbstractPage;
import com.ups.automation.pageobject.UPSHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestUPSApplication.class})
@SpringBootTest

public class UPSHomePageSD extends AbstractPage {

    @Autowired
    private UPSHomePage UPSHomePage;

    public UPSHomePageSD(UPSHomePage UPSHomePage) {
        this.UPSHomePage = UPSHomePage;
    }

    @When("^Verify UPS is loaded$")
    public void verifyUPSIsLoaded() {
    }

    @Given("^User should navigate to \"([^\"]*)\" page$")
    public void navigateToPage(String pageName) {
    }

    @Then("^User Verify \"([^\"]*)\" button is enabled$")
    public void buttonEnableCheck(String elemementText) {
    }

    @Given("^User Select multiple record with equipmentNumber=\"([^\"]*)\" for Action=\"([^\"]*)\"$")
    public void bulkRecordUpload(String listOfId, String actionName) {
        UPSHomePage.bulkUpload(listOfId,actionName);
    }
}
