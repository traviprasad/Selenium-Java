package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AuthenticationPage;
import pageObjects.BasePO;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class PageObjectManager {

	private WebDriver driver;
	private WebDriverWait wait;
	private HomePage homePage;
	private AuthenticationPage authPage;
	private MyAccountPage myAccPage;
	
	public PageObjectManager(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver,wait) : homePage;
	}
	
	public AuthenticationPage getAuthenticationPage() {
		return (authPage == null)? authPage = new AuthenticationPage(driver,wait) : authPage;
	}
	
	public MyAccountPage getMyAccountPage() {
		return (myAccPage == null)? myAccPage = new MyAccountPage(driver,wait) : myAccPage;
	}
	
}
