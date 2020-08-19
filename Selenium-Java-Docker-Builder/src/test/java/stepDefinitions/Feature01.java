package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.TestContext;
import org.testng.asserts.SoftAssert;
import pageObjects.AuthenticationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class Feature01{

	HomePage homePage;
	AuthenticationPage authPage;
	MyAccountPage myAccPage;
	SoftAssert sa;
	
	TestContext testContext;
	
	public Feature01(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		authPage = testContext.getPageObjectManager().getAuthenticationPage();
		myAccPage = testContext.getPageObjectManager().getMyAccountPage();
		sa = new SoftAssert();
	}

	@Given("^I am on the HomePage$")
	public void launchHomePage() {		
		homePage.launchHomePage();
	}

	@When("^I click on SignIn button$")
	public void clickSignInBtn() throws Throwable {
		homePage.clickSignInLink();
	}

	@Then("^I should be on the Authentication page$")
	public void authenticationPageNavigation() throws Throwable {
		authPage.waitForPageToLoad();
		sa.assertEquals("AUTHENTICATION", authPage.getPageHeading());
	}

	@And("^I enter UserName as \"([^\"]*)\"$")
	public void enterUsername(String userName) throws Throwable {
		authPage.enterUsername(userName);
	}

	@And("^I enter Password as \"([^\"]*)\"$")
	public void enterPassword(String password) throws Throwable {
		authPage.enterPassword(password);
	}

	@When("^I click on LogIn button$")
	public void logIn() throws Throwable {
		authPage.clickSignInBtn();
	}

	@Then("^I should be on the MyAccount page$")
	public void myAccountPageNavigation() throws Throwable {
		myAccPage.waitForPageToLoad();
		sa.assertEquals("MY ACCOUNT", myAccPage.getPageHeading());
	}

	@When("^I click on SignOut button$")
	public void signOut() throws Throwable {
		myAccPage.clickSignOutBtn();
		sa.assertAll();
	}
}
