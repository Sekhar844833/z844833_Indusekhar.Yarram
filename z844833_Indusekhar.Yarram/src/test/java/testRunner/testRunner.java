package testRunner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "feature//feature.feature",
		glue= {"stepDefinitions"},
		// To Generate html,json,junit reports
		plugin= {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true,
		strict=true,
		dryRun=false
		)
public class testRunner {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/extent-config.xml");
    }
}