package pageObjects;

import helpers.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePO{

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		initialise(this);
	}

	@FindBy(how=How.LINK_TEXT, using = "Sign in") private WebElement signIn;
	
	public void launchHomePage() {
		try {
			String url = ConfigFileReader.getHomePageURL();
			driver.get(url);
			waitForPageToLoad();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSignInLink() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
	}

}
