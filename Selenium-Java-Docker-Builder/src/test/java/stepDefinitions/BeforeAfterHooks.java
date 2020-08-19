package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.TestContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class BeforeAfterHooks {

	TestContext testContext;
	
	public BeforeAfterHooks(TestContext context) {
		testContext = context;
	}
	
	 @Before
	 public void beforeScenario() throws IOException {
		 System.out.println("Clear cookies -- start");
	 testContext.getWebDriverManager().getDriver().manage().deleteAllCookies();
		 System.out.println("Clear cookies -- end");
	 }

	@After
	public void captureScreenshot(Scenario scenario) throws IOException {
		testContext.getWebDriverManager().quit();
	}

}
