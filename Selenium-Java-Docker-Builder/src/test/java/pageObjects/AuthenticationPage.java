package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePO{

	public AuthenticationPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		initialise(this);
	}

	@FindBy(how=How.CLASS_NAME, using = "page-heading") private WebElement pageHeading; 
	@FindBy(how=How.ID, using = "email") private WebElement emailTxt;
	@FindBy(how=How.ID, using = "passwd") private WebElement pswdTxt; 
	@FindBy(how=How.ID, using = "SubmitLogin") private WebElement SignIn; 
	
	
	public String getPageHeading() {
		return pageHeading.getText();
	}

	public void enterUsername(String username) {
		emailTxt.sendKeys(username);
	}

	public void enterPassword(String password) {
		pswdTxt.sendKeys(password);
	}
	
	public void clickSignInBtn() {
		SignIn.click();
	}
}
