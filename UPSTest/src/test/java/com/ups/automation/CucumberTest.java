
package com.ups.automation;

import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport ="target/reports/index.json",
				retryCount=0,detailedReport =true,
				detailedAggregatedReport =true,
				overviewReport=true,
				coverageReport=true,
				jsonUsageReports="target/reports/index-usage.json",
				usageReport=false,
				toPDF=true,
				outputFolder="target/reports/")
@CucumberOptions(features = "src/test/resources",
				plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/reports/index.html","json:target/reports/index.json"},monochrome = true,
				glue = {"com.ups.automation.stepdefinition"},
				tags={"@Update_D&D_details"})

public class CucumberTest {

}
