package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

        features = "/Users/ravthota/Documents/NBS/git/Selenium-Docker-Demo-Builder-Sapient/src/test/resources/features/Feature01.feature",
        glue = {"stepDefinitions"},
        tags = {"@signIn"},
//        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}) // Enable it for local execution
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:test-output/cucumber-reports/report.html"}) // Enable it for execution on image

public class testRunner1 extends AbstractTestNGCucumberTests {

}